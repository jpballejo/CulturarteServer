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
public class dtProponente extends dtUsuario{

    private String direccion, biografia, sitioWeb;


    public dtProponente(String nombre, String apellido, String nickname, String imagen, String email, dtFecha fechaNac, String direccion, String biografia, String sitioWeb,String pass) {
        super(nombre, apellido, nickname, imagen, email, fechaNac,pass);
   this.direccion=direccion;
   this.biografia=biografia;
   this.sitioWeb=sitioWeb;
          
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @return the biografia
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * @return the sitioWeb
     */
    public String getSitioWeb() {
        return sitioWeb;
    }

    


}
