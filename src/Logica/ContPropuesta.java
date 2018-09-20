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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


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

    private void cargaridEstado(ArrayList<dtEstado> nomEstados) {
        try {
            for (int i = 0; i < nomEstados.size(); i++) {
                dtEstado est = (dtEstado) nomEstados.get(i);
                idEstado.put(est.getNombre(), est.getNumero());
            }
            contCarga.setearEstado(nomEstados);
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
                inicio = "/home/juan/ProgAplicaciones2018/progAplicaciones/Imagenes_mover/imagenesProp/" + imagen;
                destino = "/home/juan/ProgAplicaciones2018/progAplicaciones/imagenesProp/" + imagen;
                System.out.println(destino);
                copiarArchivo(inicio, destino);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return false;
        }

        return true;
    }

    public boolean copiarArchivo(String origen, String destino) throws IOException {
        File imagen = new File(origen);
        File va = new File(destino);
        if (imagen.exists()) {
            try {
                InputStream inp = new FileInputStream(imagen);
                OutputStream out = new FileOutputStream(va);
                byte[] bufer = new byte[1024];
                int largo;
                while ((largo = inp.read(bufer)) > 0) {
                    out.write(bufer, 0, largo);
                }
                inp.close();
                out.close();
                return true;
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public void sacarRutaImagen(dtPropuestasBD prop) {
        if (prop.getImagen() != null) {
            String imagen = prop.getImagen();
            listaImagenes.add(imagen);
        }

    }

    private Integer getNumEstado(String estado) {
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
            estaprop = new propEstado(dtestProp.getFecha(), dtestProp.getHora(), est);

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
                }

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    /**
     *
     * retorna un arreglo de dtPropuestasBD con las propuestas
     * con estado ingresado solamente
     */
    public ArrayList<dtPropuestasBD> getdtPropIngr() {
        ArrayList<dtPropuestasBD> propu = new ArrayList<>();
        ArrayList<proponente> proponentes = (ArrayList<proponente>) cUsuario.getProponentes();
        for (int i=0;i<proponentes.size();i++){
        proponente pro= (proponente)proponentes.get(i);
        if(pro.noPropuestas()!=true){
            cargaPropEstIngDt(propu, pro);
        }
        }
        
        return propu;
    }
    /**
     *
     * carga un arreglo de dtPropuestaBD con las propuestas con estado
     * ingresado del proponente
     * by Jp
     */
    private void cargaPropEstIngDt(ArrayList<dtPropuestasBD> propu,proponente prop){
    ArrayList<propuesta> propuestas= (ArrayList<propuesta>)prop.getPropuestasObj();
    for (int i =0;i<propuestas.size();i++){
    propuesta pro=(propuesta)propuestas.get(i);
    if(pro.getEstadoActual().equals("Ingresada")){
        dtPropuestasBD dtprop = new dtPropuestasBD(pro.getTitulo(), prop.getNickname());
        propu.add(dtprop);
    //dtPropuestaComp dtprop=new dtPropuestaComp(titulo, descripcion, imagen, lugar, fechaPublicada, estado, categoria, fechaRealizacion, i, i, i)
    }
    
    }
    
    }
    /**
     *
     * setea el estado a la propuesta, recibe dos string: el titulo y el estado by jp
     */
    public boolean nuevoEstadoProp(String idProp, String estado){
        try {
            for (int i =0;i<propuestas.size();i++){
            propuesta p=(propuesta)propuestas.get(i);
            if(p.getTitulo().equals(idProp)){
                estado est = (estado)retornaEstado(estado);
                dtFecha fecha = getFecha();
                dtHora hora = getHora();
                propEstado pE =new propEstado(fecha, hora, est);
            p.setEstado(pE, getIdEstado(estado));
            }
            
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    return true;
    }
    /**
     *
     * retorna el estado que le pases by jp
     */
    private estado retornaEstado(String estado){
    
        estado get = estados.get(estado);
        return get;
    }
    /**
     *
     * retorna un dtFecha con la fecha actual del sistema 
     */
       private dtFecha getFecha() {
        dtFecha fecha = null;
        Calendar cal = Calendar.getInstance();
        Date da = cal.getTime();
        da.setYear(2018);
        fecha = new dtFecha(Integer.toString(da.getDay()), Integer.toString(da.getMonth()), Integer.toString(da.getYear()));
        return fecha;
    }
     /**
     *
     * retorna un dtHora con la hora actual del sistema 
     */
    private dtHora getHora() {
        dtHora hora = null;
        Calendar cal = Calendar.getInstance();
        Date da = cal.getTime();
        da.setYear(2018);
        hora = new dtHora(da.getHours(), da.getMinutes());
        return hora;
    }
    
    public void agregarestadoapropWEB(String estado, String titulo){
        Date date= new Date();
        DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dt2=new SimpleDateFormat("hh:mm");
        String f=dt.format(date);
        String h=dt2.format(date);
        String[] fp=f.split("/");
        String dia=fp[0];
        String mes=fp[1];
        String anio=fp[2];
        String[] hp=h.split(":");
        int hs= Integer.parseInt(hp[0]);
        int ms= Integer.parseInt(hp[1]);
        
        dtFecha dtf= new dtFecha(dia,mes,anio);
        dtHora dth= new dtHora(hs,ms);
        
        agregarEstadoAPropuesta(estado,titulo,dtf,dth); //estado titulo fecha hora
    }
    
    
}

