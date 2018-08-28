/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class ContPropuesta implements iConPropuesta {

    private static ContPropuesta instance;
    private ContUsuario cUsuario;
    
    public static ContPropuesta getInstance() {
        if(instance==null){
            instance= new ContPropuesta();
        }
            return instance;
    }
    
    
    @Override
    public void cargarPropuestas() {
      
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
    public void datosPropuesta(dtPropuesta dtProp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        this.cUsuario=ContUsuario.getInstance();
        proponente p=(proponente) this.cUsuario.getUsuarioRecordado();
        dtPropuesta dtp=p.getPropuestas(idPropuesta);
        dtp.setColaboradores(this.cUsuario.listarColaboradores(idPropuesta));
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
    
    
    
}
