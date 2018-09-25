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
    
            ContColaboracion ic= ContColaboracion.getInstance();
            ContUsuario iu= ContUsuario.getInstance();
           ContPropuesta ip= ContPropuesta.getInstance();
          
           
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
          //  levantarBDdesdeMemoria();
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
            
            ic.borrartodocColaboraciones();
            ip.borrartodocPropuesta();
            iu.borrartodocUsuario();
            ic.borrarColecciones();
            ip.borrarColecciones();
            iu.borrarColecciones();
            ContCargaBD.getInstance().borrarColecciones();
            
        }

  
    
    public void cargarinicio(){
        iu.cargarUsuarios();
        ip.cargarPropuestas();
        ic.cargarColaboracion();
        iu.cargarFavoritos();
    }

    public String funcionprueba() {
        return "exito";
    }

    
    
  

    


    
    
}
