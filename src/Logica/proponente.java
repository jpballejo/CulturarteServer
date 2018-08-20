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
public class proponente extends usuario {

    private String direccion, biografia, web;

    //METODOS//
    public dtPropuesta getPropuestas(String idPropuesta){
    dtPropuesta prop=new dtPropuesta(web, direccion, web, web, web, biografia, idPropuesta, nacimiento, nacimiento, 0, 0);
    return prop;
    }

    //CONTRUCTORES//
    public proponente(String direccion, String biografia, String web) {
        this.direccion = direccion;
        this.biografia = biografia;
        this.web = web;
    }
    
    //GETTERS//
    public String getDireccion() {
        return direccion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getWeb() {
        return web;
    }
    
    //SETTERS//

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    

    
    
}
