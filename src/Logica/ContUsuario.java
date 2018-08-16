/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class ContUsuario implements iConUsuario {
  
  //  private Map<String, Usuario> usuarios;
    private static ContUsuario instance;
    
    public static ContUsuario getInstance() {
        if(instance==null){
            instance= new ContUsuario();
        }
            return instance;
    }
    

    @Override
    public void cargarUsuarios() {
    
    }
    
    
}
