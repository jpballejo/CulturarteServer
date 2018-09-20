/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.cancelarcolaboracionPersistencia;
import Persistencia.colaboracionesPersistencia;
import Persistencia.creadoresPropuestaPersistencia;
import Persistencia.estadoPropuestaPersistencia;
import Persistencia.propuestasPersistencia;
import Persistencia.seguirdejardeseguirPersistencia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import Persistencia.usuariosPersistencia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author nicolasgutierrez
 */
public class ContUsuario implements iConUsuario {

    private ArrayList<String> listaImagenes = new ArrayList<>();
    usuariosPersistencia usuPer = new usuariosPersistencia();
    private Map<String, usuario> usuarios = new HashMap<String, usuario>();
    seguirdejardeseguirPersistencia segdej = new seguirdejardeseguirPersistencia();
    colaboracionesPersistencia colabPer = new colaboracionesPersistencia();
    estadoPropuestaPersistencia estadopropper = new estadoPropuestaPersistencia();
    propuestasPersistencia propPersis = new propuestasPersistencia();
    utilidades util = new utilidades();

    public boolean existeUsuario(String nickName) {
        if (usuarios.containsKey(nickName) == true) {
            return true;
        }
        return false;

    }
    private ContCargaBD contCarga = ContCargaBD.getInstance();
    private static ContUsuario instance;
    private usuario usuariorecordado;
    private seguirdejardeseguirPersistencia seguirdejardeseguir = new seguirdejardeseguirPersistencia();
    private cancelarcolaboracionPersistencia cancelarcolab = new cancelarcolaboracionPersistencia();

    public static ContUsuario getInstance() {
        if (instance == null) {
            instance = new ContUsuario();
        }
        return instance;
    }

    public boolean moverImagenesUsu() {
        //"/home/juan/ProgAplicaciones2018/progAplicaciones/Imagenes_mover/imagenesProp/"
        //   int tam = listaImagenes.size();
        for (int i = 0; i < listaImagenes.size(); i++) {
            try {
                String inicio = null;
                String destino = null;
                String imagen = listaImagenes.get(i);
                inicio = "/home/juan/ProgAplicaciones2018/Servidor/Imagenes_mover/imagenesPer/" + imagen;
                destino = "/home/juan/ProgAplicaciones2018/Servidor/imagenesPerfil/" + imagen;
                System.out.println(destino);
                util.copiarArchivo(inicio, destino);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }
//y este elcoso que mueve la cosa

    @Override
    public void cargarUsuarios() {

        try {
            contCarga.levantaBDusuPer();
            ArrayList<dtUsuario> dtUsuarios = new ArrayList<dtUsuario>();
            dtUsuarios = usuPer.cargaUsuarios();

            int tam = dtUsuarios.size();
            //Iterator<dtUsuario> iterador = dtUsuarios.iterator();
            for (int i = 0; i < dtUsuarios.size(); i++) {
                dtUsuario usu = (dtUsuario) dtUsuarios.get(i);
                sacarRutaImagen(usu);
                agregaUsuCD(usu);
                contCarga.agregardtusu(usu);
                usu = null;
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        moverImagenesUsu();
        cargarSeguidores();

    }

    public void sacarRutaImagen(dtUsuario usu) {
        if (usu.getImagen() != null) {
            String imagen = usu.getImagen();
            listaImagenes.add(imagen);
        }

    }
//revisar--debugin   gg la dota

    public void cargarSeguidores() {
        ArrayList<dtSeguidores> siguen = new ArrayList<>();
        contCarga.levantarBDseguidoresPer();
        try {
            usuPer.seguidores(siguen);
            for (int i = 0; i < siguen.size(); i++) {
                dtSeguidores seg = null;
                seg = (dtSeguidores) siguen.get(i);
                seguirCD(seg);
                contCarga.seteardtSeguidores(seg);

            }
        } catch (Exception ex) {
            Logger.getLogger(ContUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void seguirCD(dtSeguidores dtseg) {
        usuario ussig = null;
        usuario usaseg = null;
        try {
            ussig = (usuario) usuarios.get(dtseg.getNickusuario());
            usaseg = (usuario) usuarios.get(dtseg.getNickaseguir());
            ussig.seguir(usaseg);
        } catch (Exception e) {
        }

    }

    public void agregaUsuCD(dtUsuario dtusu) throws Exception {
        if (dtusu instanceof dtProponente) {
            dtProponente dtProp = (dtProponente) dtusu;
            proponente usuProp = new proponente((dtProp.getNickname()), dtProp.getNombre(), dtProp.getApellido(), dtProp.getEmail(), dtProp.getImagen(),
                    dtProp.getFechaNac(), dtProp.getDireccion(), dtProp.getBiografia(), dtProp.getSitioWeb(), dtProp.getPass());
            usuarios.put(usuProp.getNickname(), usuProp);

        } else {
        }

        if (dtusu instanceof dtColaborador) {
            dtColaborador colaborador = (dtColaborador) dtusu;
            colaborador usuCola = new colaborador(colaborador.getNickname(), colaborador.getNombre(), colaborador.getApellido(), colaborador.getEmail(), colaborador.getImagen(), colaborador.getFechaNac(), colaborador.getPass());
            usuarios.put(usuCola.getNickname(), usuCola);

        }
    }

    /**
     *
     * @param dtusu
     * @throws Exception
     */
    @Override
    public void agregarUsu(dtUsuario dtusu) throws Exception {
        try {

            if (dtusu instanceof dtProponente) {
                dtProponente dtProp = (dtProponente) dtusu;

                proponente usuProp = new proponente((dtProp.getNickname()), dtProp.getNombre(), dtProp.getApellido(), dtProp.getEmail(), dtProp.getImagen(),
                        dtProp.getFechaNac(), dtProp.getDireccion(), dtProp.getBiografia(), dtProp.getSitioWeb(), dtProp.getPass());
                usuarios.put(usuProp.getNickname(), usuProp);
                usuPer.altaUsuario(dtusu);
            } else {
            }

            if (dtusu instanceof dtColaborador) {
                dtColaborador colaborador = (dtColaborador) dtusu;
                colaborador usuCola = new colaborador(colaborador.getNickname(), colaborador.getNombre(), colaborador.getApellido(), colaborador.getEmail(), colaborador.getImagen(), colaborador.getFechaNac(), colaborador.getPass());
                usuarios.put(usuCola.getNickname(), usuCola);
                usuPer.altaUsuario(dtusu);
            }

        } catch (Exception ex) {

            throw new Exception("Error: " + ex);

        }
    }

    /**
     *
     * @param nick
     * @return
     */
    @Override
    public List<String> listarProponentes(String nick) {
        List<String> retornar = new ArrayList<String>();
        /*       Set set = usuarios.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            usuario aux = (proponente) mentry.getValue();
            if (aux.getNickname().contains(nick)) {
                retornar.add(aux.getNickname());
            }

        }
        return retornar; */
        if (nick.isEmpty()) {
            for (String key : this.usuarios.keySet()) {
                if (this.usuarios.get(key) instanceof proponente) {
                    retornar.add(key);
                }
            }
        } else {
            for (String key : this.usuarios.keySet()) {
                if (this.usuarios.get(key) instanceof proponente && key.contains(nick)) {
                    retornar.add(key);
                }
            }
        }

        return retornar;
    }

    @Override
    public dtProponente infoProponente(String idProponente) {
        proponente p = (proponente) usuarios.get(idProponente);
        dtProponente res = new dtProponente(p.getNombre(), p.getApellido(), p.getNickname(), p.getImagen(), p.getEmail(), p.getNacimiento(), p.getDireccion(), p.getBiografia(), p.getWeb(), p.getPassword());
        this.usuariorecordado = p;
        return res;
    }

    @Override
    public List<String> listarColaboradores() {
        List<String> colabs = new ArrayList();
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador) {
                colaborador c = (colaborador) this.usuarios.get(key);
                if (c != null) {
                    colabs.add(c.nickname);
                }
            }
        }
        return colabs;

    }

    @Override
    public dtUsuario infoColaborador(String idColaborador) {
        colaborador c = (colaborador) this.usuarios.get(idColaborador);
        return c.getColaborador();
    }

    @Override
    public List<dtPropuesta> listarPropuestas(String idProponente) {
        List<dtPropuesta> retornar = new ArrayList<dtPropuesta>();
        List<dtPropuesta> aux = new ArrayList<dtPropuesta>();

        proponente p = (proponente) this.usuarios.get(idProponente);
        aux = p.getTodasPropuestas();
        if (aux.isEmpty() == false) {
            Iterator it = aux.iterator();
            while (it.hasNext()) {
                dtPropuesta dtp = (dtPropuesta) it.next();
                dtp.montoactual = this.montopropuesta(dtp.titulo);
                retornar.add(dtp);
            }
            aux.clear();
        }
        return retornar;
    }

    @Override
    public List<String> listarColaboradores(String idPropuesta) {
        List<String> res = new ArrayList<>();
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador) {
                colaborador c = (colaborador) this.usuarios.get(key);
                if (c.colaborasconpropuesta(idPropuesta)) {
                    res.add(c.getNickname());
                }

            }

        }
        return res;
    }

    @Override
    public dtColaboraciones seleccionarColaborador(String idColaborador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seguir(String nicknameSeguidor, String nicknameASeguir) throws Exception {
        usuario us = this.usuarios.get(nicknameSeguidor);
        if (us != null) {
            usuario as = this.usuarios.get(nicknameASeguir);
            if (as == null) //throw el usuario a seguir no existe
            {
                throw new Exception("El usuario " + nicknameASeguir + " que desea seguir no existe");
            }
            if (!us.loSigue(nicknameASeguir)) {
                dtSeguidores dts = new dtSeguidores(nicknameSeguidor, nicknameASeguir);
                boolean res = this.seguirdejardeseguir.seguir(dts);
                if (res) {
                    us.seguir(as);
                }
            } else {
                //throw ya lo sigue
                throw new Exception("Ya sigue a este usuario");
            }
        } else {
            //throw no existe el usuario
            throw new Exception("El usuario " + nicknameSeguidor + " no existe");

        }

    }

    @Override
    public void dejarDeSeguir(String nicknameSeguidor, String nicknameADejarDeSeguir) throws Exception {
        usuario us = this.usuarios.get(nicknameSeguidor);
        if (us != null) {
            usuario adds = this.usuarios.get(nicknameADejarDeSeguir);
            if (adds == null) {
                throw new Exception("El usuario " + nicknameADejarDeSeguir + " que desea dejar de seguir no existe");
            }
            if (!us.loSigue(nicknameADejarDeSeguir)) {
                throw new Exception("El usuario " + nicknameADejarDeSeguir + " no se encuentra entre tus usuarios seguidos");
            } else {
                dtSeguidores dts = new dtSeguidores(nicknameSeguidor, nicknameADejarDeSeguir);
                boolean res = this.seguirdejardeseguir.dejardeseguir(dts);
                if (res) {
                    us.dejardeSeguir(adds);
                }
            }
        } else {
            throw new Exception("El usuario " + nicknameSeguidor + " no existe");
        }
    }

    @Override
    public void eliminarColaboracion(colProp col) throws Exception {
        boolean res = this.cancelarcolab.cancelarColaboracion(this.usuariorecordado.getNickname(), col);
        if (res) {
            this.usuariorecordado.eliminarColaboracion(col);
        } else {
            throw new Exception("Imposible eliminar la colaboracion");
        }
    }

    /**
     *
     * @param nickusuario
     * @param titulo
     * @return
     */
    @Override
    public colProp seleccionarColaboracion(String nickusuario, String titulo) {
        colaborador c = (colaborador) this.usuarios.get(nickusuario);
        this.usuariorecordado = c;
        return c.seleccioonarColaboracion(titulo);
    }

    public usuario getUsuarioRecordado() {
        return this.usuariorecordado;
    }

    @Override
    public List<String> listarProponentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> listartodaslaspropuestas(String titulo) {
        List<String> ret = new ArrayList();

        if (titulo.isEmpty()) {
            for (String key : this.usuarios.keySet()) {
                if (this.usuarios.get(key) instanceof proponente) {
                    proponente p = (proponente) this.usuarios.get(key);
                    ret.addAll(p.listarmispropuestas());

                }
            }
        } else {
            for (String key : this.usuarios.keySet()) {
                if (this.usuarios.get(key) instanceof proponente) {
                    proponente p = (proponente) this.usuarios.get(key);
                    ret.addAll(p.listarmispropuestaslike(titulo));
                }
            }
        }

        return ret;
    }

    public dtPropuesta infoPropuesta(String titulo) throws Exception {
        dtPropuesta dtp = null;
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof proponente) {
                proponente p = (proponente) this.usuarios.get(key);
                if (p.propuestasUsuario.containsKey(titulo)) {
                    dtp = p.getPropuestas(titulo);
                    dtp.montoactual = this.montopropuesta(dtp.titulo);

                }

            }
        }

        if (dtp.getTitulo().equals(titulo)) {
            dtp.setColaboradores(this.listarColaboradores(titulo));
            dtp.setMontoTotal(this.montopropuesta(titulo));
            return dtp;
        } else {
            throw new Exception("Propuesta no encontrada");
        }
    }

    public int montopropuesta(String idPropuesta) {
        int res = 0;
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador) {
                colaborador c = (colaborador) this.usuarios.get(key);
                if (c.colaborasconpropuesta(idPropuesta)) {
                    res = res + c.getmontocolaboracion(idPropuesta);
                }
            }
        }
        return res;
    }

    @Override
    public List<String> listarusuarios(String nick) {
        List<String> lst = new ArrayList<String>();
        if (nick.isEmpty() == false) {
            for (String key : this.usuarios.keySet()) {
                if (key.contains(nick)) {
                    lst.add(key);
                }

            }
        } else {
            for (String key : this.usuarios.keySet()) {
                lst.add(key);
            }
        }
        return lst;
    }

    public void esteUsuariopropusoestaProp(String nickproponente, propuesta p) {
        try {
            proponente prop = (proponente) usuarios.get(nickproponente);
            prop.agregarPropuesta(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean compararfechas(dtFecha uno, dtFecha dos) {
        int unoanio = Integer.parseInt(uno.getAnio());
        int unomes = Integer.parseInt(uno.getMes());
        int unodia = Integer.parseInt(uno.getDia());
        int dosanio = Integer.parseInt(dos.getAnio());
        int dosmes = Integer.parseInt(dos.getMes());
        int dosdia = Integer.parseInt(dos.getDia());

        if (unoanio > dosanio) {
            return true;
        }
        if (unoanio == dosanio && unomes > dosmes) {
            return true;
        }
        if (unoanio == dosanio && unomes == dosmes && unodia > dosdia) {
            return true;
        }
        if (unoanio == dosanio && unomes == dosmes && unodia == dosdia) { //CASO DUDOSO
            return true;
        } else {
            return false;
        }

    }

    public boolean compararhoras(dtHora uno, dtHora dos) {
        if (uno.getHoras() > dos.getHoras()) {
            return true;
        }
        if (uno.getHoras() == dos.getHoras() && uno.getMinutos() > dos.getMinutos()) {
            return true;
        }
        if (uno.getHoras() == dos.getHoras() && uno.getMinutos() == dos.getMinutos()) {
            return true;
        } else {
            return false;
        }

    }

    public void agregarEstadoAPropuesta(estado e, String titulo, dtFecha dtf, dtHora dth, int orden) {
        propuesta p = this.damePropuesta(titulo);
        if (p.getTitulo() == titulo) {
            boolean agrego = p.agregarNuevoEstado(e, dtf, dth, orden);
            if (agrego) {
                estadopropper.agregarPropEstado(titulo, e.getNombre(), dtf.getFecha(), dth.getHora());
            }
        }
    }

    public propuesta damePropuesta(String titulo) {

        for (String key : this.usuarios.keySet()) {
            // proponente p = (proponente) this.usuarios.get(key);
            usuario usu = (usuario) usuarios.get(key);
            if (usu instanceof proponente) {
                proponente p = (proponente) usu;
                if (p.tenesPropuesta(titulo) == true) {
                    return p.damelapropuesta(titulo);

                }
            }
        }
        return null;
    }

    public void registrarcolaboracion(String nickc, String titulo, colProp cp) {
        propuesta prop = damePropuesta(titulo);
        cp.setPropuesta(prop);
        usuario usu = usuarios.get(nickc);
        if (usu instanceof colaborador) {
            colaborador c = (colaborador) usu;
            c.agregarcolaboracion(cp);
        }
    }

    @Override
    public void borrartodocUsuario() {

        //VACIAR LOS SEGUIDOS POR LOS USUARIOS QUE SERAN ELIMINADOS
        for (String key : this.usuarios.keySet()) {

            usuario u;
            u = this.usuarios.get(key);
            u.eliminartodoslosseguidos();

        }

        //SACAR DE LOS USUARIOS DE PRUEBA POSIBLE SEGUIMIENTO A USUARIOS QUE SERAN BORRADOS
        /*       for (String key : this.usuarios.keySet()) {
            if (anoborrar.containsKey(key) == true) {
                usuario us;
                us = this.usuarios.get(key);
                us.NoSigasAlosQueNoEstenAca(anoborrar);

            }
        } */
        //SACA EL PUNTERO AL USUARIO RECORDADO SI ESTE DEBE SER ELIMINADO
    }

    public void borrarColaboraciones() {

        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador) {
                colaborador c = (colaborador) this.usuarios.get(key);
                c.eliminarcolaboraciones();
            }

        }

        //ELIMINAR COLABORACIONES POSIBLES DE LOS USUARIOS DE PRUEBA CON PROPUESTAS QUE SERAN BORRADAS
        /*   for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador && anoborrar.containsKey(key) == true) {
                colaborador c = (colaborador) this.usuarios.get(key);
                if (c.notenescolaboraciones() == false) { //SI EL USUARIO TIENE AL MENOS UNA COLPROP
                    c.eliminalasrestantes(lista);

                }
            }

        } */
    }

    public void borrarPropuestas(Map<String, String> pnoborrar) {

        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof proponente) {
                proponente p = (proponente) this.usuarios.get(key);
                p.borratuspropuestas();

            }
        }

    }

    @Override
    public void levantarBDdesdeMemoria() {
        cargarUsuariosaBD();
        cargarSeguidoresaBD();
        cargarColaboracionesaBD();
    }

    public void cargarUsuariosaBD() {
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof proponente) {
                proponente p;
                p = (proponente) this.usuarios.get(key);
                try {
                    this.usuPer.altaUsuario(p.getDtProponente());
                } catch (Exception ex) {
                    Logger.getLogger(ContUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                colaborador c;
                c = (colaborador) this.usuarios.get(key);
                try {
                    this.usuPer.altaUsuario(c.getColaborador());
                } catch (Exception ex) {
                    Logger.getLogger(ContUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void cargarSeguidoresaBD() {
        for (String keu : this.usuarios.keySet()) {
            usuario u;
            u = this.usuarios.get(keu);
            for (String key : u.seguidos.keySet()) {
                usuario uaux;
                uaux = u.seguidos.get(key);
                dtSeguidores dts = new dtSeguidores(u.getNickname(), uaux.getNickname());

                segdej.seguir(dts);
            }

        }
    }

    private void cargarColaboracionesaBD() {
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador) {
                colaborador c;
                c = (colaborador) this.usuarios.get(key);
                for (String k : c.colaboracionesUsuario.keySet()) {
                    colProp cp;
                    cp = c.colaboracionesUsuario.get(k);
                    colabPer.registrarColaboracion(c.nickname, cp.getPropColaborada().getTitulo(), cp.getFecha().getFecha(), cp.getHora().getHora(), Integer.toString(cp.getMontocolaborado()), cp.getRetorno());
                }
            }
        }
    }

    void cargarpropuestasaBD() throws SQLException {

        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof proponente) {
                proponente p;
                p = (proponente) this.usuarios.get(key);
                for (String k : p.propuestasUsuario.keySet()) {
                    propuesta prop;
                    prop = p.propuestasUsuario.get(k);
                    dtPropuestasBD dtp = new dtPropuestasBD(prop.getTitulo(), p.getNickname(), prop.getDescripcion(), prop.getImagen(), prop.getLugar(), prop.getCategoria(), prop.getRetorno(), prop.getFecharealizacion(), prop.getFechapublicada(), prop.getPrecioEntrada(), prop.getMontoRequerido());
                    propuestasPersistencia.altaPropuesta(dtp);
                }
            }
        }
    }

    void cargarcreadorespropuestasaBD() {
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof proponente) {
                proponente p;
                p = (proponente) this.usuarios.get(key);
                for (String k : p.propuestasUsuario.keySet()) {
                    creadoresPropuestaPersistencia.agregarCreador(key, k);
                }
            }

        }
    }

    void cargarestadospropuestasaBD() {
        /*    for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof proponente) {
                proponente p;
                p = (proponente) this.usuarios.get(key);
                for (String k : p.propuestasUsuario.keySet()) {
                    propuesta prop = p.propuestasUsuario.get(k);
 //                   Iterator it = prop.estados.iterator();
                    while (it.hasNext()) {
                        propEstado pestado = (propEstado) it.next();
                        dtEstadosPropuestas dtep = new dtEstadosPropuestas(prop.getTitulo(), pestado.getEstado().getNombre(), pestado.getFecha(), pestado.getHora());
                        estadoPersistencia.agregarEstadosPropuestas(dtep);
                    }
                }
            }
        }*/
    }

    @Override
    public List<String> listarColaboradoresporNick(String nick) {
        List res = new ArrayList<String>();
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador) {
                colaborador c = (colaborador) this.usuarios.get(key);
                if (c.getNickname().contains(nick)) {
                    res.add(c.getNickname());
                }
            }
        }
        return res;
    }

    public List<dtCola> colaboracionesde(String nickcolaborador) {
        List<dtCola> list = new ArrayList<>();
        colaborador c = (colaborador) this.usuarios.get(nickcolaborador);
        for (String key : c.colaboracionesUsuario.keySet()) {
            colProp cp = c.colaboracionesUsuario.get(key);
            dtCola dtco = new dtCola(cp.getPropColaborada().getTitulo(), cp.getPropColaborada().getEstadoActual(), quienpropuso(cp.getPropColaborada().getTitulo()), montopropuesta(cp.getPropColaborada().getTitulo()));
            list.add(dtco);

        }
        return list;
    }

    public String quienpropuso(String titulo) {
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof proponente) {
                proponente p = (proponente) this.usuarios.get(key);
                if (p.propuestasUsuario.containsKey(titulo)) {
                    return p.getNickname();
                }
            }
        }
        return "";
    }

    public void linkearpropuesta(propuesta p, String prop) {
        for (String key : this.usuarios.keySet()) {
            if (key.contentEquals(prop)) {
                if (this.usuarios.get(key) instanceof proponente) {
                    proponente pr = (proponente) this.usuarios.get(key);
                    pr.propuestasUsuario.put(p.getTitulo(), p);
                }
            }
        }
    }

    @Override
    public List<String> listarColaboradoresLike(String nick) {

        List<String> colabs = new ArrayList();
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador) {
                colaborador c = (colaborador) this.usuarios.get(key);
                if (c != null && c.getNickname().contains(nick)) {
                    colabs.add(c.nickname);
                }
            }
        }
        return colabs;

    }

    public boolean registrarColaboracion(String titulo, String colab, int monto, String retorno, String comentario) {
        propuesta p = this.damePropuesta(titulo);
        if (this.usuarios.get(colab) instanceof colaborador) {
            colaborador c = (colaborador) this.usuarios.get(colab);
            if (c != null) {
                if (p != null && c.colaborasconpropuesta(titulo) == false) {
                    Calendar cal = Calendar.getInstance();
                    Date da = cal.getTime();
                    da.setYear(2018);
                    dtFecha dtf = new dtFecha(Integer.toString(da.getDay()), Integer.toString(da.getMonth()), Integer.toString(da.getYear()));
                    dtHora dth = new dtHora(da.getHours(), da.getMinutes());
                    colProp cp = new colProp(dtf, dth, monto, retorno, p, comentario);
                    c.colaboracionesUsuario.put(p.getTitulo(), cp);
                    colabPer.registrarColaboracion(colab, titulo, dtf.getFecha(), dth.getHora(), Integer.toString(monto), retorno);
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void actualizardatospropuesta(dtPropuesta dtp, estado e, int orden, dtFecha dtf, dtHora dth) throws Exception {

        propuesta p = this.damePropuesta(dtp.getTitulo());
        if (p.getTitulo() == dtp.getTitulo()) {
            p.setDescripcion(dtp.getDescripcion());
            p.setImagen(dtp.getImagen());
            p.setLugar(dtp.getLugar());
            boolean estadoagregado = p.agregarNuevoEstado(e, dtf, dth, orden);
            p.setFechapublicada(dtp.getFechapublicada());
            p.setFecharealizacion(dtp.getFechaRealizacion());
            p.setPrecioEntrada(dtp.getPrecioentrada());
            p.setMontoRequerido(dtp.getMontorequerido());

            dtPropuestasBD dtpbd = new dtPropuestasBD(dtp.getTitulo(), dtp.getProponente(), dtp.getDescripcion(), dtp.getImagen(), dtp.getLugar(), dtp.getCategoria(), p.getRetorno(), dtp.getFechaRealizacion(), dtp.getFechapublicada(), dtp.getPrecioentrada(), dtp.getMontorequerido());
            propPersis.actualizarPropuesta(dtpbd);
            if (estadoagregado == true) {
                estadopropper.agregarPropEstado(p.getTitulo(), e.getNombre(), dtf.getFecha(), dth.getHora());
            }

        } else {
            throw new Exception("La propuesta " + dtp.getTitulo() + " que desea modificar no existe");
        }
    }

    List<String> listarPropuestasPorEstado(String estado) {
        List<String> retorno = new ArrayList<>();

        for (String ku : this.usuarios.keySet()) {
            if (this.usuarios.get(ku) instanceof proponente) {
                proponente prop = (proponente) this.usuarios.get(ku);
                for (String kp : prop.propuestasUsuario.keySet()) {
                    propuesta p = prop.propuestasUsuario.get(kp);
                    if (p.getEstadoActual().contains(estado)) {
                        retorno.add(kp);
                    }
                }

            }
        }
        return retorno;
    }

    void eliminarcolaboracion(String nickname, String titulo) throws Exception {
        colaborador c = this.damecolaborador(nickname);
        if (c.getNickname().contentEquals(nickname)) {
            colProp cp = c.colaboracionesUsuario.remove(titulo);
            cp.eliminate();
            colabPer.eliminarColaboracion(nickname, titulo);
        } else {
            throw new Exception("El colaborador " + nickname + " no existe");
        }
    }

    public colaborador damecolaborador(String nick) {
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof colaborador && key.contentEquals(nick)) {
                colaborador c = (colaborador) this.usuarios.get(key);
                return c;
            }
        }

        return null;
    }

    void borrarColecciones() {
        this.listaImagenes.clear();
        this.usuariorecordado = null;
        this.usuarios.clear();
    }

    @Override
    public ArrayList<proponente> getProponentes() {

        ArrayList<proponente> propo = new ArrayList<>();

        try {
            Iterator it = usuarios.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                if ((usuario) usuarios.get(key) instanceof proponente) {
                    proponente prop = (proponente) (usuario) usuarios.get(key);
                    propo.add(prop);

                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return propo;
    }

   

    /**
     * Esta funcion se usa para tener informacion sin importar si es Colaborador
     * o Proponente es usada en la pagina WEB
     *
     * @param nick
     * @return
     */
    public dtUsuario infoUsuarioGeneral(String nick) {
        dtUsuario dtu = null;
        if (this.usuarios.get(nick) instanceof proponente) {
            proponente p = (proponente) this.usuarios.get(nick);
            dtu = p.getDtProponente();
        }
        if (this.usuarios.get(nick) instanceof colaborador) {
            colaborador c = (colaborador) this.usuarios.get(nick);
            dtu = c.getColaborador();
        }
        return dtu;
    }

    /**
     * Esta funcion es usada por la WEB para listar los usuarios que siguen a el
     * usuario nick
     *
     * @param nick
     * @return
     */
    public List<String> listarmisseguidores(String nick) {
        ArrayList<String> retorno = new ArrayList<>();
        for (String key : this.usuarios.keySet()) {
            usuario u = this.usuarios.get(key);
            if (u.seguidos.containsKey(nick)) {
                retorno.add(key);
            }
        }
        return retorno;
    }

    /**
     * Esta funcion es usada por la WEB para listar los seguidores de un usuario
     *
     * @param nick
     * @return
     */
    public List<dtSigoA> listarmisseguidos(String nick) {
        ArrayList<dtSigoA> retorno = new ArrayList<>();
        usuario u = this.usuarios.get(nick);
        for (String key : u.seguidos.keySet()) {
            if (u.seguidos.get(key) instanceof proponente) {
                dtSigoA dtsa = new dtSigoA(key, "Proponente");
                retorno.add(dtsa);
            }
            if (u.seguidos.get(key) instanceof colaborador) {
                dtSigoA dtsa = new dtSigoA(key, "Colaborador");
                retorno.add(dtsa);
            }
        }
        return retorno;
    }

    public List<String> mispropuestasfavoritas(String nick) {
        ArrayList<String> retorno = new ArrayList<>();
        usuario u = this.usuarios.get(nick);
        for (String key : u.favoritas.keySet()) {
            retorno.add(key);
        }
        return retorno;
    }

    /**
     * funcion utilizada por la WEB para listar las propuestas de un proponente
     * ecepto las ingresadas
     *
     * @param nick
     * @return
     */
    public List<String> mispropuestasaceptadas(String nick) {
        ArrayList<String> retorno = new ArrayList<>();
        if (this.usuarios.get(nick) instanceof proponente) {
            proponente p = (proponente) this.usuarios.get(nick);
            for (String key : p.propuestasUsuario.keySet()) {
                propuesta prop = p.propuestasUsuario.get(key);
                if (prop.getEstadoActual().equals("Ingresada") == false) {
                    retorno.add(prop.getTitulo());
                }
            }
        }
        return retorno;
    }

    public List<String> listarColaboraciones(String nick) {
        ArrayList<String> retorno = new ArrayList<>();
        if (this.usuarios.get(nick) instanceof colaborador) {
            colaborador c = (colaborador) this.usuarios.get(nick);
            retorno = c.listarmiscolaboraciones();
        }
        return retorno;
    }

    public List<String> mispropuestasaingresadas(String nick) {
        ArrayList<String> retorno = new ArrayList<>();
        if (this.usuarios.get(nick) instanceof proponente) {
            proponente p = (proponente) this.usuarios.get(nick);
            for (String key : p.propuestasUsuario.keySet()) {
                propuesta prop = p.propuestasUsuario.get(key);
                if (prop.getEstadoActual().equals("Ingresada")) {
                    retorno.add(prop.getTitulo());
                }
            }
        }
        return retorno;
    }

    public List<dtColProp> listarmiscolaboraciones(String nick) {
        ArrayList<dtColProp> retorno = new ArrayList<>();
        if (this.usuarios.get(nick) instanceof colaborador) {
            colaborador c = (colaborador) this.usuarios.get(nick);
            for (String key : c.colaboracionesUsuario.keySet()) {
                colProp cp = c.colaboracionesUsuario.get(key);
                dtColProp dtcp = new dtColProp(nick, cp.getFecha(), cp.getHora(), cp.getMontocolaborado(), key);
                retorno.add(dtcp);
            }
        }
        return retorno;
    }

    public List<String> listarpropuestasmenosingresadas(String titulo) {
        List<String> ret = new ArrayList();

        if (titulo.isEmpty()) {
            for (String key : this.usuarios.keySet()) {
                if (this.usuarios.get(key) instanceof proponente) {
                    proponente p = (proponente) this.usuarios.get(key);
                    ret.addAll(p.listarmispropuestasmenosingresadas());

                }
            }
        } else {
            for (String key : this.usuarios.keySet()) {
                if (this.usuarios.get(key) instanceof proponente) {
                    proponente p = (proponente) this.usuarios.get(key);
                    ret.addAll(p.listarmispropuestaslike(titulo));
                }
            }
        }

        return ret;
    }

    /**
     * Esta funcion se usa para listar propuestas en el la WEB
     *
     * @return
     */
    public List<dtPropuesta> listarpropuestasenlaweb() {
        List<dtPropuesta> retorno = new ArrayList<>();
        for (String key : this.usuarios.keySet()) {
            if (this.usuarios.get(key) instanceof proponente) {
                proponente p = (proponente) this.usuarios.get(key);
                for (String keyp : p.propuestasUsuario.keySet()) {
                    dtPropuesta dtp = new dtPropuesta(keyp, key);
                    retorno.add(dtp);
                }
            }
        }
        return retorno;
    }

    public List<String> cargarlosseguidospor(String nickusuario) {
        List<String> retorno = new ArrayList<>();
        usuario u = this.usuarios.get(nickusuario);
        for (String key : u.seguidos.keySet()) {
            retorno.add(key);
        }
        return retorno;
    }

    @Override
    public dtUsuario usuarioLogin(String usu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<dtUsuario> getDtUsus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

