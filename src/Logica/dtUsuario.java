/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Esteban Menendez
 */
public class dtUsuario {

    private String nombre, apellido, nickname, imagen, email;
    dtFecha fechaNac;

//CONSTRUCTOR//
    public dtUsuario(String nombre, String apellido, String nickname, String imagen, String email, dtFecha fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.imagen = imagen;
        this.email = email;
        this.fechaNac = fechaNac;
    }

//GETTERS//
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public String getImagen() {
        return imagen;
    }

    public String getEmail() {
        return email;
    }

    public dtFecha getFechaNac() {
        return fechaNac;
    }

//SETTERS//
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaNac(dtFecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    
    
}
