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
public class ContPropuesta implements iConPropuesta {

    private static ContPropuesta instance;
    
    public static ContPropuesta getInstance() {
        if(instance==null){
            instance= new ContPropuesta();
        }
            return instance;
    }
    
    
    @Override
    public void cargarPropuestas() {
      
    }
    
}
