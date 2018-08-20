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
public class dtProponente {

    private String direccion, biografia, sitioWeb;

//CONSTRUCTOR//
    public dtProponente(String direccion, String biografia, String sitioWeb) {
        this.direccion = direccion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
    }

//GETTERS//
    public String getDireccion() {
        return direccion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

//SETTERS// 
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

}
