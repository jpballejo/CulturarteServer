/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author nicolasgutierrez
 */
public class culturarteFabrica {
    
    private static culturarteFabrica instance;
    
    public static culturarteFabrica getInstance() {
        if(instance==null){
            instance= new culturarteFabrica();
        }
            return instance;
    }
    
        private culturarteFabrica(){
            
        }
        
        public void cargarDatosPrueba(){
            iConColaboracion ic= this.getIContColaboracion();
            iConUsuario iu= this.getIContUsuario();
            iConPropuesta ip= this.getIContPropuesta();
            ic.cargarColaboracion();
            iu.cargarUsuarios();
            ip.cargarPropuestas();
        }
    
        public iConColaboracion getIContColaboracion(){
            iConColaboracion icc= ContColaboracion.getInstance();
            return icc;
        }
        
        public iConUsuario getIContUsuario(){
            iConUsuario icu= ContUsuario.getInstance();
            return icu;
        }
        
        public iConPropuesta getIContPropuesta(){
            iConPropuesta icp= ContPropuesta.getInstance();
            return icp;
        }
    
}
