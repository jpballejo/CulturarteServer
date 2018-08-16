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
public class ContColaboracion implements iConColaboracion{

    private static ContColaboracion instance;
    
    public static ContColaboracion getInstance() {
        if(instance==null){
            instance= new ContColaboracion();
        }
            return instance;
    }
    
    @Override
    public void cargarColaboracion() {
        
    }
    
}
