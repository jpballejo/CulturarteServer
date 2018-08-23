/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Esteban Menendez
 */
public class usuario {


    protected 
            String nickname
            ,nombre, 
            apellido, 
            email, 
            imagen;
   protected dtFecha nacimiento;

    private Map<String, usuario> seguidos;
   
    //METODOS
    public dtPropuestasProponente getPropuestas() {
        dtPropuestasProponente dtpp = new dtPropuestasProponente(email, nickname);
        return dtpp;
    }

    //CONSTRUCTORES//
    public usuario() {}

    public usuario(String nickname, String nombre, String apellido, String email, String imagen, dtFecha nacimiento) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.imagen = imagen;
        this.nacimiento = nacimiento;
    }

    //GETTERS//
    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getImagen() {
        return imagen;
    }

    public dtFecha getNacimiento() {
        return nacimiento;
    }

    //SETTERS//
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNacimiento(dtFecha nacimiento) {
        this.nacimiento = nacimiento;
    }

    
    //OPERACIONES
    
    public boolean loSigue(String nick) {
        return this.seguidos.containsKey(nick);
    }
    
    public void seguir(usuario us) {
        this.seguidos.put(us.getNickname(), us);
    }

   
    public String getNacimientoString() {
        String retorno= this.nacimiento.getDia()+"/"+this.nacimiento.getMes()+"/"+this.nacimiento.getAnio();
        return retorno;
    }

   
    
    public void dejardeSeguir(usuario us){
        this.seguidos.remove(us.getNickname(), us);
    }


    public void eliminarColaboracion(colProp c){
        
    }
    
    public colProp seleccioonarColaboracion(String titulo){
    throw new UnsupportedOperationException("Not supported yet.");
    }

  /*  public colProp seleccioonarColaboracion(String titulo){
        
    } */

}
