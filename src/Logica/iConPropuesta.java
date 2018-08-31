/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author nicolasgutierrez
 */
public interface iConPropuesta {
    
    public abstract void cargarPropuestas();
    public abstract List<dtPropuesta> listaPropuestas(String idProponente);
    public abstract dtInfoProp infoPropuesta(String idPropuesta);
    public abstract void nuevaPropuesta(String idProponente, String tipoEspectaculo);
    public abstract void datosPropuesta(dtPropuesta dtProp);
    public abstract void altaPropuesta();
    public abstract List<dtPropuesta> listarPropuesta();
    public abstract dtPropuesta infoProp(String idPropuesta);
    public abstract void modificarPropuesta(dtPropuesta dtProp);
    public abstract List<dtPropuestaComp> informacionPropuestas(String titulo);
    public abstract List<dtPropuestasProponente> listarPropuestasExistentes();
    public abstract dtPropuesta mostrarInfoPropuesta(String idPropuesta) throws Exception;
    public abstract List<String>listartodasPropuestas(String titulo);
    public abstract void borrartodocPropuesta();

    public void levantarBDdesdeMemoria();

}
    