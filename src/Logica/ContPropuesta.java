/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.categoriaPersistencia;
import Persistencia.estadoPersistencia;
import Persistencia.estadoPropuestaPersistencia;
import Persistencia.propuestasPersistencia;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class ContPropuesta implements iConPropuesta {

    private ArrayList<String> listaImagenes = new ArrayList<>();
    private static ContPropuesta instance;
    private ContUsuario cUsuario = ContUsuario.getInstance();
    private Map<String, categoria> categorias = new HashMap<String, categoria>();
    private Map<String, estado> estados = new HashMap<String, estado>();
    categoriaPersistencia catPer = new categoriaPersistencia();
    estadoPersistencia estPer = new estadoPersistencia();
    propuestasPersistencia propPer = new propuestasPersistencia();
    estadoPropuestaPersistencia estPropPer = new estadoPropuestaPersistencia();
    ArrayList<propuesta> propuestas = new ArrayList<>();
    private Map<String, Integer> idEstado = new HashMap<String, Integer>();
    private ContCargaBD contCarga = ContCargaBD.getInstance();
    ArrayList<propuesta> propFiltradaING = new ArrayList<>();
    ArrayList<propuesta> propCambioEstadoAuto = new ArrayList<>();

    ArrayList<dtEstadosPropuestas> arregloDtEstProp = new ArrayList<>();
    utilidades util = utilidades.getInstance();

    private void cargaridEstado(ArrayList<dtEstado> nomEstados) {
        try {
            for (int i = 0; i < nomEstados.size(); i++) {
                dtEstado est = (dtEstado) nomEstados.get(i);
                idEstado.put(est.getNombre(), est.getNumero());
            }
            contCarga.setearEstado(nomEstados);
            util.setearidEstado(nomEstados);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int getIdEstado(String estadoNom) {
        int id = 0;
        id = idEstado.get(estadoNom);
        return id;

    }

    public boolean moverImagenesProp() {
        //"/home/juan/ProgAplicaciones2018/progAplicaciones/Imagenes_mover/imagenesProp/"
        int tam = listaImagenes.size();

        try {
            for (int i = 0; i < listaImagenes.size(); i++) {
                String inicio = null;
                String destino = null;
                String imagen = listaImagenes.get(i);
                inicio = "/home/juan/ProgAplicaciones2018/Servidor/Imagenes_mover/imagenesProp/" + imagen;
                destino = "/home/juan/ProgAplicaciones2018/Servidor/imagenesProp/" + imagen;
                System.out.println(destino);
                util.copiarArchivo(inicio, destino);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return false;
        }

        return true;
    }

    public void sacarRutaImagen(dtPropuestasBD prop) {
        if (prop.getImagen() != null) {
            String imagen = prop.getImagen();
            listaImagenes.add(imagen);
        }

    }

    private int getNumEstado(String estado) {
        return this.idEstado.get(estado);

    }

    public static ContPropuesta getInstance() {
        if (instance == null) {
            instance = new ContPropuesta();
        }
        return instance;
    }

    @Override
    public void cargarPropuestas() {
        cargaCategorias();
        cargaEstados();
        cargaPropuestas();
        moverImagenesProp();

    }

    @Override
    public List<dtPropuesta> listaPropuestas(String idProponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public dtInfoProp infoPropuesta(String idPropuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nuevaPropuesta(String idProponente, String tipoEspectaculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //revisado jp---cambio atributos que se pasan al constructor/testear!
    public void datosPropuesta(dtPropuesta dtp) {
        estado esta = (estado) estados.get(dtp.getEstado());
        categoria cat = (categoria) getCategorias().get(dtp.getCategoria());
        propuesta p = new propuesta(dtp.getTitulo(), dtp.getDescripcion(), dtp.getImagen(), dtp.getLugar(), dtp.getFechaRealizacion(), dtp.getFechapublicada(), dtp.getPrecioentrada(), dtp.getMontorequerido(), dtp.getRetorno(), esta, cat);
        cUsuario.linkearpropuesta(p, dtp.getProponente());

        dtPropuestasBD dtpbd = new dtPropuestasBD(dtp.getTitulo(), dtp.getProponente(), dtp.getDescripcion(), dtp.getImagen(), dtp.getLugar(), dtp.getCategoria(), dtp.getRetorno(), dtp.getFechaRealizacion(), dtp.getFechapublicada(), dtp.getPrecioentrada(), dtp.getMontorequerido());
        try {
            propuestasPersistencia.altaPropuesta(dtpbd);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void altaPropuesta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<dtPropuesta> listarPropuesta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public dtPropuesta infoProp(String idPropuesta) {
        this.cUsuario = ContUsuario.getInstance();
        proponente p = (proponente) this.cUsuario.getUsuarioRecordado();
        dtPropuesta dtp = p.getPropuestas(idPropuesta);
        dtp.setColaboradores(this.cUsuario.listarColaboradores(idPropuesta));
        dtp.setMontoTotal(this.cUsuario.montopropuesta(idPropuesta));
        return dtp;
    }

    @Override
    public void modificarPropuesta(dtPropuesta dtProp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<dtPropuestaComp> informacionPropuestas(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<dtPropuestasProponente> listarPropuestasExistentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public dtPropuesta mostrarInfoPropuesta(String idPropuesta) throws Exception {
        return ContUsuario.getInstance().infoPropuesta(idPropuesta);
    }

    @Override
    public List<String> listartodasPropuestas(String titulo) {
        return ContUsuario.getInstance().listartodaslaspropuestas(titulo);
    }
    // public ArrayList<dtCategoria> getdtCategorias(){}

    public void cargaCategorias() {
        try {
            ArrayList<dtCategoria> dtcate = new ArrayList<>();
            contCarga.levantarBDCategoriasPer();
            catPer.cargarCat(dtcate);
            contCarga.setearCategoria(dtcate);
            System.out.println(dtcate.size());
            for (int i = 0; i < dtcate.size(); i++) {
                System.out.print(i);
                dtCategoria dtcat = (dtCategoria) dtcate.get(i);
                categoria cat = new categoria(dtcat.getNombre());

                //+++++++++++++++++++
                getCategorias().put(cat.getNombre(), cat);
            }
            //dtcate.lastIndexOf(null);
            System.out.println(dtcate.size());
            for (int p = 0; p < dtcate.size(); p++) {
                dtCategoria dtcatp = (dtCategoria) dtcate.get(p);

                if (dtcatp.getPadre() != null) {
                    categoria catp = (categoria) getCategorias().get(dtcatp.getPadre());
                    categoria cath = (categoria) getCategorias().get(dtcatp.getNombre());
                    cath.setPadre(catp);
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }//revisado

    public void cargaEstados() {
        try {
            ArrayList<dtEstado> nomEstados = new ArrayList<>();
            estPer.CargarEstados(nomEstados);
            for (int i = 0; i < nomEstados.size(); i++) {
                dtEstado est = nomEstados.get(i);
                String nombre = est.getNombre();
                estado nuevoEstado = new estado(nombre);
                estados.put(nuevoEstado.getNombre(), nuevoEstado);

            }
            cargaridEstado(nomEstados);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public void cargaPropuestas() {
        contCarga.levantarBDproPer();
        contCarga.levantarBDestadosPropPer();
        ArrayList<dtPropuestasBD> dtpropuestasDb = new ArrayList<dtPropuestasBD>();
        propPer.cargarPropuestas(dtpropuestasDb);
        contCarga.agregardtpropuesta(dtpropuestasDb);
        ArrayList<dtEstadosPropuestas> estProp = new ArrayList<>();
        estPer.CargarEstadosPropuestas(estProp);
        llenaEstadosCarga(estProp);

        for (int i = 0; i < dtpropuestasDb.size(); i++) {
            dtPropuestasBD dtProp = (dtPropuestasBD) dtpropuestasDb.get(i);
            sacarRutaImagen(dtProp);

            propuesta prop = armarPropuesta(dtProp);
            cargarEstadosProp(prop, estProp);//revisar if ==true
            //filtraPropuestas(prop);
            String nick = dtProp.getNickproponente();
            cUsuario.esteUsuariopropusoestaProp(nick, prop);

        }
    }

    private void llenaEstadosCarga(ArrayList<dtEstadosPropuestas> estProp) {

        try {
            for (int i = 0; i < estProp.size(); i++) {
                dtEstadosPropuestas esta = estProp.get(i);
                contCarga.setearEstadoPropuesta(esta);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     *
     * @param prop
     * @param estProp
     */
    @Override
    public void cargarEstadosProp(propuesta prop, ArrayList<dtEstadosPropuestas> estProp) {
        try {
            int orden = 0;
            String nombre = null;
            for (int p = 0; p < estProp.size(); p++) {
                dtEstadosPropuestas dtEtPop = (dtEstadosPropuestas) estProp.get(p);
                nombre = dtEtPop.getEstado();

                if (prop.getTitulo().equals(dtEtPop.getTituloprop()) == true) {
                    propEstado propest = crearEstado(dtEtPop);

                    orden = getNumEstado(nombre);
                    prop.setEstado(propest, orden);

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public propEstado crearEstado(dtEstadosPropuestas dtestProp) {
        propEstado estaprop = null;
        try {
            estado est = getEstado(dtestProp.getEstado());
            estaprop = new propEstado(dtestProp.getFecha(), dtestProp.getHora(), est, dtestProp.getFechaFin());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return estaprop;
    }

    public propuesta armarPropuesta(dtPropuestasBD dtProp) {
        //propuesta prop = new propuesta(dtProp.getTitulo(), dtProp.getDescripcion() dtProp.getImagen(), dtProp.getLugar(), dtProp.getFecha(),dtProp.getFecha_publicacion(), dtProp.getPrecio_entrada(), dtProp.getMonto_necesario(), dtProp.getRetorno(),getCategoria(dtProp.getCategoria())); 
        categoria cat = getCategoria(dtProp.getCategoria());
        propuesta prop = new propuesta(dtProp.getTitulo(), dtProp.getDescripcion(), dtProp.getImagen(), dtProp.getLugar(), dtProp.getFecha(), dtProp.getFecha_publicacion(), dtProp.getPrecio_entrada(), dtProp.getMonto_necesario(), dtProp.getRetorno(), cat);
        return prop;
    }

    public estado getEstado(String estaNombre) {
        estado est = (estado) estados.get(estaNombre);
        return est;
    }

    public categoria getCategoria(String cateNombre) {
        categoria cat = (categoria) categorias.get(cateNombre);
        return cat;
    }

    // //////// trunkate y carga bd
    @Override
    public void borrartodocPropuesta() {
        Map<String, String> lista = propuestasPersistencia.cargarPropuestasNOBorrar();
        cUsuario.borrarPropuestas(lista);
    }

    private void cargarestadosaBD() {
        for (String key : this.estados.keySet()) {
            estadoPersistencia.agregarestado(key);
        }
    }

    private void cargarcategoriasaBD() throws Exception {
        for (String key : this.getCategorias().keySet()) {
            categoria c = this.getCategorias().get(key);
            catPer.altaCategoria(c.getNombre(), c.getPadre().getNombre());
        }
    }

    public List<String> listarCategorias(String text) {
        List<String> retorno = new ArrayList<>();
        for (String key : this.getCategorias().keySet()) {
            if (key.contains(text)) {
                retorno.add(key);
            }
        }
        return retorno;
    }

    @Override
    public void agregarEstadoAPropuesta(String e, String titulo, dtFecha dtf, dtHora dth) {
        cUsuario.agregarEstadoAPropuesta(getEstado(e), titulo, dtf, dth, getIdEstado(e));
    }

    @Override
    public List<String> listarEstados() {
        List<String> retorno = new ArrayList<>();
        for (String key : this.idEstado.keySet()) {
            retorno.add(key);
        }
        return retorno;
    }

    @Override
    public void actualizardatospropuesta(dtPropuesta dtp, String e, dtFecha dtf, dtHora dth) throws Exception {
        cUsuario.actualizardatospropuesta(dtp, this.getEstado(e), this.getIdEstado(e), dtf, dth);
    }

    @Override
    public List<String> listarPropuestasPorEstado(String estado) {
        return cUsuario.listarPropuestasPorEstado(estado);
    }

    public List<String> listarCategoriasBeta() {
        List<String> retorno = new ArrayList<>();
        for (String key : this.categorias.keySet()) {
            categoria c = this.categorias.get(key);
            String categoriacompleta = c.getNombre() + "/" + c.getPadre().getNombre();
            retorno.add(categoriacompleta);

        }
        return retorno;
    }

    void borrarColecciones() {
        this.listaImagenes.clear();
        this.categorias.clear();
        this.estados.clear();
        this.idEstado.clear();
        this.propCambioEstadoAuto.clear();
        this.propFiltradaING.clear();
        this.arregloDtEstProp.clear();
        

    }

    /**
     * @return the categorias
     */
    public ArrayList<dtCategoria> getdtCategorias() {
        ArrayList<dtCategoria> cat = new ArrayList<>();

        try {
            Iterator it = categorias.keySet().iterator();
            while (it.hasNext()) {
                String stkey = (String) it.next();
                categoria cate = (categoria) categorias.get(stkey);
                String nombre = null;
                nombre = cate.getNombre();
                String padre = null;
                if (cate.getPadre() != null) {
                    padre = cate.getPadre().getNombre();
                }

                dtCategoria dtcat = new dtCategoria(nombre, padre);
                cat.add(dtcat);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return cat;

    }

    /**
     * @return the categorias
     */
    public Map<String, categoria> getCategorias() {
        return this.categorias;
    }

    @Override
    public void levantarBDdesdeMemoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaCategoria(dtCategoria cate) {
        try {
            if (cate.getPadre() != null) {
                if (cate.getPadre().equals("Categorias") != true) {
                    categoria catP = (categoria) categorias.get(cate.getPadre());
                    categoria categ = new categoria(catP, cate.getNombre());
                    categorias.put(cate.getNombre(), catP);
                    catPer.altaCategoria(cate.getNombre(), cate.getPadre());
                } else {
                    categoria categ = new categoria(null, cate.getNombre());
                    categorias.put(cate.getNombre(), categ);
                    catPer.altaCategoria(cate.getNombre(), null);
                }

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    /**
     *
     * retorna un arreglo de dtPropuestasBD con las propuestas con estado
     * ingresado solamente
     */
    public ArrayList<dtPropuestasBD> getdtPropIngr() {
        ArrayList<dtPropuestasBD> propu = new ArrayList<>();
        ArrayList<proponente> proponentes = (ArrayList<proponente>) cUsuario.getProponentes();
        for (int i = 0; i < proponentes.size(); i++) {
            proponente pro = (proponente) proponentes.get(i);
            if (pro.noPropuestas() != true) {
                cargaPropEstIngDt(propu, pro);
            }
        }

        return propu;
    }

    /**
     *
     * carga un arreglo de dtPropuestaBD con las propuestas con estado ingresado
     * del proponente by Jp
     */
    private void cargaPropEstIngDt(ArrayList<dtPropuestasBD> propu, proponente prop) {
        ArrayList<propuesta> propING = (ArrayList<propuesta>) prop.getPropuestasObj();
        for (int i = 0; i < propING.size(); i++) {
            propuesta pro = (propuesta) propING.get(i);
            if (pro.getEstadoActual().equals("Ingresada")) {
                propFiltradaING.add(pro);
                dtPropuestasBD dtprop = new dtPropuestasBD(pro.getTitulo(), prop.getNickname());
                propu.add(dtprop);
                //dtPropuestaComp dtprop=new dtPropuestaComp(titulo, descripcion, imagen, lugar, fechaPublicada, estado, categoria, fechaRealizacion, i, i, i)
            }

        }

    }

    /**
     *
     * setea el estado a la propuesta, recibe dos string: el titulo y el estado
     * by jp
     */
    public boolean nuevoEstadoProp(String idProp, String estado) {
        try {
            for (int i = 0; i < propFiltradaING.size(); i++) {
                propuesta p = (propuesta) propFiltradaING.get(i);
                System.out.println(p.getTitulo());
                System.out.println(idProp);
                if (p.getTitulo().equals(idProp)) {
                    estado est = (estado) retornaEstado(estado);
                    dtFecha fecha = (dtFecha) util.getFecha();
                    dtHora hora = (dtHora) util.getHora();
                    //  dtFecha fechaFin = getFechaFin(fecha, 30);
                    propEstado pE = new propEstado(fecha, hora, est, null);
                    p.setEstado(pE, getIdEstado(estado));
                    estPropPer.agregarPropEstado(idProp, estado, fecha.getFecha(), hora.getHora(), (String) pE.getFechaFin().getFecha());
                    return true;
                }

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    /**
     *
     * retorna el estado que le pases by jp
     */
    private estado retornaEstado(String estado) {

        estado get = estados.get(estado);
        return get;
    }

    public void agregarestadoapropWEB(String estado, String titulo) {
        dtFecha dtf = util.getFecha();
        dtHora dth = util.getHora();

        agregarEstadoAPropuesta(estado, titulo, dtf, dth); //estado titulo fecha hora
    }
    
    
////////////////////PROCEDIMIENTO estado Automatico-----------------
public void propAutomaticas(){
    try {
        this.propCambioEstadoAuto.clear();
    cUsuario.getPropuestas(propCambioEstadoAuto);
        for(int i =0;i<propCambioEstadoAuto.size();i++){
            propuesta p = (propuesta)propCambioEstadoAuto.get(i);
            filtraPropuestas(p);
        }
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }

}
    
    /**
     *
     * Funcion que recibe una propuesta y verifica el estado, la fecha y la hora
     * Si la fecha es anterior a la actual actualiza de inmediato el estado al
     * que le sigue Si la fecha es igual a la actual verifica la hora, si la
     * hora es inferior o igual a la actual cambia el estado al que le sigue Si
     * la hora es superior a la actual almacena la propuesta en una coleccion
     * que se verifica durante el uso del programa y se encarga comprobar la
     * hora hasta que coincida y cambia el estado
     */
    public void filtraPropuestas(propuesta p) {

        if (comparaEstado(p.getEstadoActual())) {
            if (verificaFecha(p) == 0) {
               if (verificaHora(p) == -1) {
                cambiaPropEstadoAuto(p);
            }
            if (verificaHora(p) == 0) {
                cambiaPropEstadoAuto(p);
            }
            }
            if (verificaFecha(p) == -1) {
                cambiaPropEstadoAuto(p);
            }
        }
    }

 

    /*
 *cambiaPropEstadoAuto recibe una propuesta y verifica si el estado es Publicada o En Financiacion
 * si es publicada cambia el estado a En Financiacion 
 * Si es En Financiacion verifica los montos y selecciona Financiada o No Financiada
 * 
     */
    private void cambiaPropEstadoAuto(propuesta p) {
        int m;
        String estado = p.getEstadoActual();
        if (estado.equals("Publicada")) {
            nuevoEstPropAUTO(p, "En financiacion");
        }
        if (estado.equals("En financiacion")) {
            int montoReq = p.getMontoRequerido();
            m = cUsuario.getMontoColaborado(p.getTitulo());
            if (m >= montoReq) {
                nuevoEstPropAUTO(p, "Financiada");
            }
            if (m < montoReq) {
                nuevoEstPropAUTO(p, "No financiada");
            }
        }
    }

    /**
     *
     *
     */
    private void nuevoEstPropAUTO(propuesta p, String estado) {
        try {
            estado est = (estado) retornaEstado(estado);
            dtFecha fecha = (dtFecha) util.getFecha();
            dtHora hora = (dtHora) util.getHora();
            propEstado pE = new propEstado(fecha, hora, est, null);
            int posicion = getNumEstado(estado);
            p.setEstado(pE, posicion);
            estPropPer.agregarPropEstado(p.getTitulo(), estado, fecha.getFecha(), hora.getHora(), p.getFechaFinEstadoActual());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     *
     * verificarFecha: funcion que retorna un int (-1, 0, 1)
     *
     * (1) si la fecha es anterior a la del sistema (0) si la fecha es igual a
     * la del sistema (-1) si es posterior a la del sistema
     */
    private int verificaFecha(propuesta p) {

        try {
            Date fechaFin = (Date) util.fechaDate(p.getFechaFinEstadoActual(), p.getHoraFinEstadoActual());
            dtFecha dtf = util.getFecha();
            dtHora dtH = util.getHora();
            Date fechaAc = util.fechaDate((String) dtf.getFecha(), dtH.getHora());
            if (fechaFin.before(fechaAc)) {
                return -1;
            }
            if (fechaAc.before(fechaFin)) {
                return 1;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return 0;
    }

    /**
     *
     * verificarHora: funcion que retorna un int (-1, 0, 1)
     *
     * (-1) si la hora es anterior a la del sistema (0) si la hora es igual a la
     * del sistema (1) si es posterior a la del sistema
     */
    private int verificaHora(propuesta p) {

        try {
            Date hora = (Date) util.fechaDate(null, (String) p.getPropEstadoActual().getHora().getHora());
            dtHora dth = (dtHora) util.getHora();
            Date horaSis = (Date) util.fechaDate(null, (String) dth.getHora());
            if (horaSis.before(hora)) {
                return 1;
            }
            if (hora.before(horaSis)) {
                return -1;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    /**
     * comparaEstado: funcion que compara los estados
     *
     * false: si el estado es: Ingresada - No Financiada - Financiada true: si
     * es otro estado
     */
    private boolean comparaEstado(String stado) {
        if (stado.equals("Cancelada")) {
            return false;
        }
        if (stado.equals("Ingresada")) {
            return false;
        }
        if (stado.equals("No Financiada")) {
            return false;
        }
        if (stado.equals("Financiada")) {
            return false;
        }
        return true;
    }
}
