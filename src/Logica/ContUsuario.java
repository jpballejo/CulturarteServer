/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Exception;
import Persistencia.usuariosPersistencia;
/**
 *
 * @author nicolasgutierrez
 */
public class ContUsuario implements iConUsuario {

 usuariosPersistencia usuPer;
    private Map<String, usuario> usuarios= new HashMap<String,usuario>();
    
    
 public boolean existeUsuario(String nickName){
     if(usuarios.containsKey(nickName)== true){return true;}return false;

 }
        
  

    private static ContUsuario instance;
    private usuario usuariorecordado;
    
    public static ContUsuario getInstance() {
        if(instance==null){
            instance= new ContUsuario();
        }
            return instance;
    }

    /**
     *
     * @throws Exception
     */
    @Override
    public void cargarUsuarios() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarUsu(dtUsuario dtusu) throws Exception {
    try {
        dtProponente proponente = (dtProponente)dtusu;
   if(proponente!=null){
            
                proponente usuProp= new proponente((proponente.getNickname()), proponente.getNombre(), proponente.getApellido(), proponente.getEmail(), proponente.getImagen()
                        , proponente.getFechaNac(), proponente.getDireccion(),proponente.getBiografia(),proponente.getSitioWeb());
                usuarios.put(usuProp.getNickname(), usuProp);
                usuPer.altaUsuario(dtusu);
           
   }
   dtColaborador colaborador = (dtColaborador)dtusu;
   if (colaborador!=null){
   colaborador usuCola= new colaborador(colaborador.getNickname(),colaborador.getNombre(), colaborador.getApellido(), colaborador.getEmail(),colaborador.getImagen(),colaborador.getFechaNac());
   usuarios.put(usuCola.getNickname(),usuCola);
       usuPer.altaUsuario(dtusu);
   }
   
     } catch (Exception ex) {
               
            throw new Exception ("Error: "+ex);
        
            }
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
    public void seguir(String nicknameSeguidor, String nicknameASeguir) throws Exception {
        usuario us=this.usuarios.get(nicknameSeguidor);
        if(us!=null){
            usuario as=this.usuarios.get(nicknameASeguir);
            if(as==null) //throw el usuario a seguir no existe
                throw new Exception("El usuario "+nicknameASeguir+ " que desea seguir no existe");
            if(!us.loSigue(nicknameASeguir)) {
                us.seguir(as);
            } 
            else {
                //throw ya lo sigue
                throw new Exception("Ya sigue a este usuario"); 
            }
        }
        else{
                //throw no existe el usuario
                throw new Exception("El usuario "+ nicknameSeguidor+ " no existe");
            
        }
            
    }

    @Override
    public void dejarDeSeguir(String nicknameSeguidor, String nicknameADejarDeSeguir) throws Exception {
        usuario us=this.usuarios.get(nicknameSeguidor);
        if(us!=null){
            usuario adds=this.usuarios.get(nicknameADejarDeSeguir);
            if(adds==null)
                throw new Exception("El usuario "+nicknameADejarDeSeguir+ " que desea dejar de seguir no existe");
            if(!us.loSigue(nicknameADejarDeSeguir))
                throw new Exception("El usuario "+nicknameADejarDeSeguir+ " no se encuentra entre tus usuarios seguidos");
            else{
                us.dejardeSeguir(adds);
                }
        }
        else{
             throw new Exception("El usuario "+ nicknameSeguidor+ " no existe");
        }
    }

    @Override
    public void eliminarColaboracion(colProp col) {
       this.usuariorecordado.eliminarColaboracion(col);
    }

    @Override
    public colProp seleccionarColaboracion(String nickusuario, String titulo) {
        usuario u=this.usuarios.get(nickusuario);
        return u.seleccioonarColaboracion(titulo);
    }
    
    

   
    
}
