/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.cancelarcolaboracionPersistencia;
import Persistencia.seguirdejardeseguirPersistencia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    private seguirdejardeseguirPersistencia seguirdejardeseguir= new seguirdejardeseguirPersistencia();
    private cancelarcolaboracionPersistencia cancelarcolab= new cancelarcolaboracionPersistencia();
    
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

    public List<String> listarProponentes(String nick) {
        List<String> retornar=new ArrayList<String>();
        Set set = usuarios.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            usuario aux=(proponente) mentry.getValue();        
            if (aux.getNickname().contains(nick)){
                retornar.add(aux.getNickname());
            }
           
        }       
        return retornar;
    }

    @Override
    public dtProponente infoProponente(String idProponente) {
        proponente p=(proponente)usuarios.get(idProponente);
        dtProponente res= new dtProponente(p.getNombre(),p.getApellido(),p.getNickname(),p.getImagen(),p.getEmail(),p.getNacimiento(),p.getDireccion(),p.getBiografia(),p.getWeb());
        this.usuariorecordado=p;
        return res;
    }

    @Override
    public List<String> listarColaboradores() {
        List<String> colabs=new ArrayList();
     for (String key : this.usuarios.keySet()) {
         colaborador c=(colaborador)this.usuarios.get(key);
         if(c!=null)
             colabs.add(c.nickname);
     }
        return colabs;
        
    }

    @Override
    public dtUsuario infoColaborador(String idColaborador) {
        colaborador c=(colaborador)this.usuarios.get(idColaborador);
        return c.getColaborador();
    }

    @Override
    public List<dtPropuesta> listarPropuestas(String idProponente) {
        proponente p= (proponente)this.usuarios.get(idProponente);
        return p.getTodasPropuestas();
    }

    @Override
    public List<String> listarColaboradores(String idPropuesta) {
        List res= new ArrayList<String>();
        Iterator it= this.usuarios.keySet().iterator();
        while(it.hasNext()){
            colaborador c=(colaborador) this.usuarios.get((String)it.next());
            if(c.colaborasconpropuesta(idPropuesta)){
                res.add(c.getNickname());               
            }
        }
        return res;
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
                boolean res= this.seguirdejardeseguir.seguir(us, as);
                if(res)
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
                boolean res= this.seguirdejardeseguir.dejardeseguir(us, adds);
                if(res)
                us.dejardeSeguir(adds);
                }
        }
        else{
             throw new Exception("El usuario "+ nicknameSeguidor+ " no existe");
        }
    }

    @Override
    public void eliminarColaboracion(colProp col) throws Exception {
        boolean res= this.cancelarcolab.cancelarColaboracion(this.usuariorecordado.getNickname(), col);
        if(res)
            this.usuariorecordado.eliminarColaboracion(col);
        else
            throw new Exception("Imposible eliminar la colaboracion");
    }

    @Override
    public colProp seleccionarColaboracion(String nickusuario, String titulo) {
        colaborador c=(colaborador)this.usuarios.get(nickusuario);
        this.usuariorecordado=c;
        return c.seleccioonarColaboracion(titulo);
    }
    
    
    public usuario getUsuarioRecordado(){
        return this.usuariorecordado;
    }

    @Override
    public List<String> listarProponentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public List<String> listartodaslaspropuestas(String titulo){
        List<String> ret=new ArrayList();
    
     if(titulo.isEmpty()){   
        for (String key : this.usuarios.keySet()) {
         proponente p=(proponente) this.usuarios.get(key);
         ret.addAll(p.listarmispropuestas());      
        }
     }
     else{
         for (String key : this.usuarios.keySet()) {
         proponente p=(proponente) this.usuarios.get(key);
         ret.addAll(p.listarmispropuestaslike(titulo));      
        }
     }
     
     return ret;
}
    
    public dtPropuesta infoPropuesta(String titulo) throws Exception{
        dtPropuesta dtp=null;
        for( String key : this.usuarios.keySet()){
            proponente p=(proponente)this.usuarios.get(key);
            if (p!=null)
                dtp=p.getPropuestas(titulo);
                if(dtp!=null&&dtp.getTitulo().equals(titulo))
                    break;
            }
        
        if(dtp!=null) {
            dtp.setColaboradores(this.listarColaboradores(titulo));
            dtp.setMontoTotal(this.montopropuesta(titulo));
            return dtp;
     } else {
            throw new Exception("Propuesta no encontrada");
     }
    }
    
     public int montopropuesta(String idPropuesta) {
        int res=0;
        Iterator it= this.usuarios.keySet().iterator();
        while(it.hasNext()){
            colaborador c=(colaborador) this.usuarios.get((String)it.next());
            if(c.colaborasconpropuesta(idPropuesta)){
                    res=res+c.getmontocolaboracion(idPropuesta);
            }
        }
        return res;
    }
    

}