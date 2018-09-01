/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.cancelarcolaboracionPersistencia;
import Persistencia.colaboracionesPersistencia;
import Persistencia.creadoresPropuestaPersistencia;
import Persistencia.estadoPersistencia;
import Persistencia.propuestasPersistencia;
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
import java.sql.SQLException;
/**
 *
 * @author nicolasgutierrez
 */
public class ContUsuario implements iConUsuario {


 usuariosPersistencia usuPer = new usuariosPersistencia();
 private Map<String, usuario> usuarios= new HashMap<String,usuario>();
 seguirdejardeseguirPersistencia segdej= new seguirdejardeseguirPersistencia();
 colaboracionesPersistencia colabPer= new colaboracionesPersistencia();

    
    
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

   
    @Override
    public void cargarUsuarios() {
        
        cargarUsuario();
        cargaSeguidores();
         
        
    }

    @Override
    public void agregarUsu(dtUsuario dtusu) throws Exception {
    try {
        
   if(dtusu instanceof dtProponente){
       dtProponente dtProp = (dtProponente)dtusu;
       proponente usuProp= new proponente((dtProp.getNickname()), dtProp.getNombre(), dtProp.getApellido(), dtProp.getEmail(), dtProp.getImagen()
               , dtProp.getFechaNac(), dtProp.getDireccion(),dtProp.getBiografia(),dtProp.getSitioWeb());
       usuarios.put(usuProp.getNickname(), usuProp);
       usuPer.altaUsuario(dtusu);
   } else {
   }
           
        if (dtusu instanceof dtColaborador){
             dtColaborador colaborador = (dtColaborador)dtusu;
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
         if(this.usuarios.get(key) instanceof colaborador){
            colaborador c=(colaborador)this.usuarios.get(key);
            if(c!=null)
                 colabs.add(c.nickname);
         }
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
        for (String key: this.usuarios.keySet()){
           if(this.usuarios.get(key) instanceof colaborador){
                colaborador c=(colaborador) this.usuarios.get(key);
                if(c.colaborasconpropuesta(idPropuesta)){
                    res=res+c.getmontocolaboracion(idPropuesta);
                }
           }
        }
        return res;
    }
     
     @Override
     public List<String> listarusuarios(String nick){
         List<String> lst= new ArrayList();
         this.usuarios.keySet().stream().filter((key) -> (key.contains(nick))).forEachOrdered((key) -> {
             lst.add(key);
     });
         return lst;
     }
    

     public void cargarUsuario(){
         Map<String, proponente> mapproponentes=new HashMap<String, proponente>();
         mapproponentes = usuPer.CargarProponentes();
         for(String keyp : mapproponentes.keySet()){
             proponente p=mapproponentes.get(keyp);
             this.usuarios.put(keyp, p);        
         }
         
         Map<String, colaborador> mapcolaboradores=new HashMap<String, colaborador>();
         mapcolaboradores= usuPer.CargarColaboradores();
         for(String keyc : mapcolaboradores.keySet()){
             colaborador c=mapcolaboradores.get(keyc);
             this.usuarios.put(keyc, c);        
         }
     }
     
     public void cargaSeguidores(){
         List<dtSeguidores> list= new ArrayList<>();
         list= seguirdejardeseguirPersistencia.cargarSeguidores();
         Iterator it= list.iterator();
         while(it.hasNext()){
             dtSeguidores dt=(dtSeguidores)it.next();
             usuario u=this.usuarios.get(dt.nickusuario);
             u.seguir(this.usuarios.get(dt.nickaseguir));
         }
         
     }
     
     public void esteUsuariopropusoestaProp(String nickproponente, propuesta p){
         proponente prop=(proponente)this.usuarios.get(nickproponente);
         prop.agregarPropuesta(p);
     }
     
     
     public boolean compararfechas(dtFecha uno, dtFecha dos){
         int unoanio=Integer.parseInt(uno.getAnio());
         int unomes=Integer.parseInt(uno.getMes());
         int unodia=Integer.parseInt(uno.getDia());
         int dosanio=Integer.parseInt(dos.getAnio());
         int dosmes=Integer.parseInt(dos.getMes());
         int dosdia=Integer.parseInt(dos.getDia());
         
         if(unoanio>dosanio){
             return true;
         }
         if(unoanio==dosanio && unomes>dosmes){
             return true;
         }
         if(unoanio==dosanio && unomes==dosmes && unodia>dosdia){
             return true;
         }
         if(unoanio==dosanio && unomes==dosmes && unodia==dosdia){ //CASO DUDOSO
             return true;
         }
         else{
             return false;
         }
         
     }
     
     public boolean compararhoras(dtHora uno, dtHora dos){
         if(uno.getHoras()>dos.getHoras()){
             return true;
         }
         if(uno.getHoras()==dos.getHoras() && uno.getMinutos()>dos.getMinutos()){
             return true;
         }
         if(uno.getHoras()==dos.getHoras() && uno.getMinutos()==dos.getMinutos()){
             return true;
         }
         else
             return false;
         
     }
     
     public void agregarEstadoAPropuesta(estado e, String titulo, dtFecha dtf, dtHora dth){
         
     }
     
     public propuesta damePropuesta(String titulo) {
        
        for( String key : this.usuarios.keySet()){
            proponente p=(proponente)this.usuarios.get(key);
            if (p!=null && p.tenesPropuesta(titulo)){
                return p.damelapropuesta(titulo);
                
                }
             
            }
       return null;  
    }
     
    public void ordenarLosEstadosdeCadaPropuesta(){
        for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof proponente){
                proponente p=(proponente)this.usuarios.get(key);
                p.ordenalosestadosdepropuestas();
            }
                
        }
    }
    
    public void registrarcolaboracion(String nickc, String titulo, colProp cp){
        cp.setPropuesta(this.damePropuesta(titulo));
        if(this.usuarios.get(nickc) instanceof colaborador){
            colaborador c=(colaborador)this.usuarios.get(nickc);
            c.agregarcolaboracion(cp);
        }
    }

    @Override
    public void borrartodocUsuario() {
        Map<String, usuario> anoborrar=usuariosPersistencia.usuariosANoBorrar();
        //VACIAR LOS SEGUIDOS POR LOS USUARIOS QUE SERAN ELIMINADOS
        
        for(String key: this.usuarios.keySet()){
            if(anoborrar.containsKey(key)==false){
                usuario u;
                u = this.usuarios.get(key);
                u.eliminartodoslosseguidos();
            }
        }
        
        //SACAR DE LOS USUARIOS DE PRUEBA POSIBLE SEGUIMIENTO A USUARIOS QUE SERAN BORRADOS
        
        for(String key: this.usuarios.keySet()){
            if(anoborrar.containsKey(key)==true){
                usuario us;
                us= this.usuarios.get(key);
                us.NoSigasAlosQueNoEstenAca(anoborrar);
                
            }
        }
        
        //SACA EL PUNTERO AL USUARIO RECORDADO SI ESTE DEBE SER ELIMINADO
        
        if(this.usuariorecordado !=null){
            if(anoborrar.containsKey(this.usuariorecordado.getNickname())==false){
                this.usuariorecordado=null;
            }
        }
        
    }
    
    public void borrarColaboraciones(){
        Map<String, usuario> anoborrar=usuariosPersistencia.usuariosANoBorrar();
        for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof colaborador && anoborrar.containsKey(key)==false){
                colaborador c=(colaborador) this.usuarios.get(key);
                c.eliminarcolaboraciones();
            }
            
            
        }
        
       //ELIMINAR COLABORACIONES POSIBLES DE LOS USUARIOS DE PRUEBA CON PROPUESTAS QUE SERAN BORRADAS
       
        Map<String, propuesta> lista=propuestasPersistencia.cargarPropuestasNOBorrar();
        for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof colaborador && anoborrar.containsKey(key)==true){
                colaborador c=(colaborador) this.usuarios.get(key);
                if(c.notenescolaboraciones()==false){ //SI EL USUARIO TIENE AL MENOS UNA COLPROP
                    c.eliminalasrestantes(lista);
                
                }
            }
            
            
        }
    }
    
    public void borrarPropuestas(Map<String, propuesta> pnoborrar){
         Map<String, usuario> anoborrar=usuariosPersistencia.usuariosANoBorrar();
         for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof proponente && anoborrar.containsKey(key)==false){
                proponente p=(proponente) this.usuarios.get(key);
                p.borratuspropuestas();
                
            }
        }
     
    }

    @Override
    public void levantarBDdesdeMemoria() {
        cargarUsuariosaBD();
        cargarSeguidoresaBD();
        cargarColaboracionesaBD();
    }
    
    public void cargarUsuariosaBD(){
        for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof proponente){
                proponente p;
                p = (proponente) this.usuarios.get(key);
                try {
                    this.usuPer.altaUsuario(p.getDtProponente());
                } catch (Exception ex) {
                    Logger.getLogger(ContUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                colaborador c;
                c = (colaborador) this.usuarios.get(key);
                try {
                    this.usuPer.altaUsuario(c.getColaborador());
                } catch (Exception ex) {
                    Logger.getLogger(ContUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }

    private void cargarSeguidoresaBD() {
        for(String keu: this.usuarios.keySet()){
            usuario u;
            u = this.usuarios.get(keu);
            for(String key: u.seguidos.keySet()){
                usuario uaux;
                uaux= u.seguidos.get(key);
                segdej.seguir(u, uaux);
            }
            
        }
    }

    private void cargarColaboracionesaBD() {
         for(String key: this.usuarios.keySet()){
             if(this.usuarios.get(key) instanceof colaborador){
                 colaborador c;
                 c = (colaborador) this.usuarios.get(key);
                 for(String k: c.colaboracionesUsuario.keySet()){
                     colProp cp;
                     cp = c.colaboracionesUsuario.get(k);
                     colabPer.registrarColaboracion(c.nickname, cp.getPropColaborada().getTitulo(), cp.getFecha().getFecha(), cp.getHora().getHora(), Integer.toString(cp.getMontocolaborado()), cp.getRetorno());
                 } 
             }
         }
    }

    void cargarpropuestasaBD() throws SQLException {
        
        for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof proponente){
                proponente p;
                p = (proponente) this.usuarios.get(key);
                for(String k: p.propuestasUsuario.keySet()){
                    propuesta prop;
                    prop = p.propuestasUsuario.get(k);
                    dtPropuestasBD dtp= new dtPropuestasBD(prop.getTitulo(),p.getNickname(),prop.getDescripcion(),prop.getImagen(),prop.getLugar(),prop.getCategoria(),prop.getRetorno(),prop.getFecharealizacion(),prop.getFechapublicada(),prop.getPrecioEntrada(),prop.getMontoRequerido());
                    propuestasPersistencia.altaPropuesta(dtp);
                }
            }
        }
    }

    void cargarcreadorespropuestasaBD() {
        for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof proponente){
                proponente p;
                p = (proponente) this.usuarios.get(key);
                for(String k: p.propuestasUsuario.keySet()){
                    creadoresPropuestaPersistencia.agregarCreador(key,k);
                }
            }
        
        }
    }

    void cargarestadospropuestasaBD() {
        for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof proponente){
                proponente p;
                p = (proponente) this.usuarios.get(key);
                for(String k: p.propuestasUsuario.keySet()){
                    propuesta prop=p.propuestasUsuario.get(k);
                    Iterator it=prop.estados.iterator();
                    while(it.hasNext()){
                        propEstado pestado=(propEstado)it.next();
                        dtEstadosPropuestas dtep= new dtEstadosPropuestas(prop.getTitulo(),pestado.getEstado().getNombre(),pestado.getFecha(),pestado.getHora());
                        estadoPersistencia.agregarEstadosPropuestas(dtep);
                    }
                }
            }            
        }
    }

    @Override
    public List<String> listarColaboradoresporNick(String nick) {
           List res= new ArrayList<String>();
           for (String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof colaborador){   
            colaborador c=(colaborador) this.usuarios.get(key);
                if(c.getNickname().contains(nick)){
                    res.add(c.getNickname());               
                 }
            }
        }
        return res;
    }

    public List<dtCola> colaboracionesde(String nickcolaborador){
        List<dtCola> list= new ArrayList<>();
        colaborador c=(colaborador) this.usuarios.get(nickcolaborador);
        for(String key: c.colaboracionesUsuario.keySet()){
            colProp cp= c.colaboracionesUsuario.get(key);
            dtCola dtco= new dtCola(cp.getPropColaborada().getTitulo(),cp.getPropColaborada().getEstadoActual(),quienpropuso(cp.getPropColaborada().getTitulo()),montopropuesta(cp.getPropColaborada().getTitulo()));
            list.add(dtco);
        
        }
        return list;
    }
    
    public String quienpropuso(String titulo){
        for(String key: this.usuarios.keySet()){
            if(this.usuarios.get(key) instanceof proponente){
                proponente p=(proponente) this.usuarios.get(key);
                if(p.propuestasUsuario.containsKey(key))
                    return p.getNickname();
            }
        }
        return "";
    }
    
    
}
