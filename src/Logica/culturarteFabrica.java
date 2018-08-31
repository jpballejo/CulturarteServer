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
        
        public void cargarDatosdePrueba(){
            borrartodo();
            levantarBDdesdeMemoria();
        }
        
        public void cargarDesdeBD(){
            iConColaboracion ic= this.getIContColaboracion();
            iConUsuario iu= this.getIContUsuario();
            iConPropuesta ip= this.getIContPropuesta();
          
            iu.cargarUsuarios();
            ip.cargarPropuestas();
            ic.cargarColaboracion();
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
        
        public void borrartodo(){
            iConColaboracion ic= this.getIContColaboracion();
            iConUsuario iu= this.getIContUsuario();
            iConPropuesta ip= this.getIContPropuesta();
            
            
            ic.borrartodocColaboraciones();
            ip.borrartodocPropuesta();
            iu.borrartodocUsuario();
            
            
        }

    private void levantarBDdesdeMemoria() {
            iConColaboracion ic= this.getIContColaboracion();
            iConUsuario iu= this.getIContUsuario();
            iConPropuesta ip= this.getIContPropuesta();
                    
        
       iu.levantarBDdesdeMemoria();
       ip.levantarBDdesdeMemoria();
       ic.levantarBDdesdeMemoria();
    }
    
}
