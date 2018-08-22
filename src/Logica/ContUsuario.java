/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class ContUsuario implements iConUsuario {
 private  Map<String,usuario>usuariosSistemas= new HashMap<String,usuario>();
 
 public boolean existeUsuario(String nickName){
     if(usuariosSistemas.get(nickName)!=null){return true;}return false;
}
        
    private static ContUsuario instance;
    
    public static ContUsuario getInstance() {
        if(instance==null){
            instance= new ContUsuario();
        }
            return instance;
    }

    @Override
    public void cargarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarUsu(dtUsuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listarProponentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public dtUsuario infoProponente(String idProponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> listarColaboradores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public dtUsuario infoColaborador(String idColaborador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<dtPropuesta> listarPropuestas(String idColaborador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<dtColaborador> listarColaboradores(String idPropuesta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public dtColaboraciones seleccionarColaborador(String idColaborador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seguir(String nicknameSeguidor, String nicknameASeguir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dejarDeSeguir(String nicknameSeguidor, String nicknameADejarDeSeguir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

   
    
}
