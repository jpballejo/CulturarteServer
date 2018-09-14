/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.colaboracionesPersistencia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author nicolasgutierrez
 */
public class ContColaboracion implements iConColaboracion {

    private static ContColaboracion instance;
    private colProp colaboracion;
    private ContUsuario cUsuario = ContUsuario.getInstance();
    private colaboracionesPersistencia colPer = new colaboracionesPersistencia();
    private ContCargaBD contCarga = ContCargaBD.getInstance();
    public static ContColaboracion getInstance() {
        if (instance == null) {
            instance = new ContColaboracion();
        }
        return instance;
    }

    @Override
    public void cargarColaboracion() {
        cargarColaboraciones();
    }

    @Override
    public List<String> tipoRetorno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarTipoRet(String tipoRet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listaEstados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listarCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nuevaCategoria(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listarTipoRetorno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarTipoYMontoColaborador(String tipoRetorno, int montoColaboracion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public dtColabAProp seleccionarColaboración(String idPropuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<dtColaboraciones> listarColaboraciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public dtColProp seleccionarColaboracion(String nickusuario, String titulo) {
        colProp cp = (colProp) this.cUsuario.seleccionarColaboracion(nickusuario, titulo);
        this.colaboracion = cp;
        dtColProp dtcp = new dtColProp(nickusuario, cp.getRetorno(), cp.getFecha(), cp.getHora(), cp.getMontocolaborado(),cp.getComentario());
        return dtcp;
    }

    @Override
    public void eliminar() throws Exception {
        this.cUsuario.eliminarColaboracion(this.colaboracion);
    }

    public void cargarColaboraciones() {
        ArrayList<dtColaboracionCompleto> dtColaComp = new ArrayList<>();
   //////////////     
        try {
            contCarga.levantarBDcolPer();
            colPer.cargarColaboraciones(dtColaComp);
            for (int i = 0; i < dtColaComp.size(); i++) {
                dtColaboracionCompleto dt = (dtColaboracionCompleto) dtColaComp.get(i);
                contCarga.agregardtcolaboraciones(dt);
                colProp cp = new colProp(dt.getFecha(), dt.getHora(), dt.getMonto(), dt.getRetorno(), null,dt.getComentario());
                cUsuario.registrarcolaboracion(dt.getNickname(), dt.getTitulo(), cp);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void borrartodocColaboraciones() {
        cUsuario.borrarColaboraciones();
    }

   

    @Override
    public List<dtCola> listarcolaboracionesdelcolaborador(String nickcolaborador) {
        return cUsuario.colaboracionesde(nickcolaborador);
    }

    @Override
    public void eliminarcolaboracion(String nickname, String titulo) throws Exception {
        cUsuario.eliminarcolaboracion(nickname,titulo);
    }

    void borrarColecciones() {
        this.colaboracion=null;
    }

}
