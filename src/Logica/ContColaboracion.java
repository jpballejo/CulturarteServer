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
public class ContColaboracion implements iConColaboracion{

    private static ContColaboracion instance;
    private colProp colaboracion;
    private ContUsuario cUsuario=ContUsuario.getInstance();
    
    
    public static ContColaboracion getInstance() {
        if(instance==null){
            instance= new ContColaboracion();
        }
            return instance;
    }
    
    @Override
    public void cargarColaboracion() {
        
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
       colProp cp=(colProp)this.cUsuario.seleccionarColaboracion(nickusuario, titulo);
       this.colaboracion=cp;
       dtColProp dtcp= new dtColProp(nickusuario,cp.getRetorno().toString(),cp.getFecha(),cp.getHora(),cp.getMontocolaborado());
       return dtcp;
    }

    @Override
    public void eliminar() throws Exception{
        this.cUsuario.eliminarColaboracion(this.colaboracion);
    }
    
}
