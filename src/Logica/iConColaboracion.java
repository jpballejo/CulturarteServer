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
public interface iConColaboracion {
    
    public abstract void cargarColaboracion();
    public abstract List<String> tipoRetorno();
    public abstract void seleccionarTipoRet(String tipoRet);
    public abstract List<String> listaEstados();
    public abstract List<String> listarCategorias();
    public abstract void nuevaCategoria(String nombre);
    public abstract void altaCategoria();
    public abstract List<String> listarTipoRetorno();
    public abstract void seleccionarTipoYMontoColaborador(String tipoRetorno, int montoColaboracion);
    public abstract dtColabAProp seleccionarColaboración(String idPropuesta); 
    public abstract List<dtColaboraciones> listarColaboraciones();
    public abstract dtColProp seleccionarColaboracion(String nickusuario, String titulo);
    public abstract void eliminar() throws Exception;
    public abstract void borrartodocColaboraciones();
    public abstract List<dtCola> listarcolaboracionesdelcolaborador(String nickcolaborador);
    public abstract void eliminarcolaboracion(String nickname, String titulo) throws Exception;
 
}
