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

    private String nombre, apellido, nickname, imagen, email,pass;
    private dtFecha fechaNac;
    private String rol;

    public dtUsuario(String nombre, String apellido, String nickname, String imagen, String email, dtFecha fechaNac,String pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.imagen = imagen;
        this.email = email;
        this.fechaNac = fechaNac;
        this.pass=pass;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the fechaNac
     */
    public dtFecha getFechaNac() {
        return fechaNac;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}
