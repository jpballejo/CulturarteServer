/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Esteban Menendez
 */
public class proponente extends usuario {

    private final Map<String,propuesta> propuestasUsuario = new HashMap<String,propuesta>();//diccionario con clave string
    private String direccion;

    private String biografia, web;

    public proponente(String nickname, String nombre, String apellido, String email, String imagen, dtFecha nacimiento, String direccion, String biografia, String web) {
        super(nickname, nombre, apellido, email, imagen, nacimiento);
        this.direccion=direccion;
        this.biografia=biografia;
        this.web=web;
        }

    /**
     *
     */
    public void agregarPropuesta(propuesta prop){
        propuestasUsuario.put(prop.getTitulo(), prop);
        
    }
    
    public dtProponente getDtProponente(){
   
        dtProponente dtprop = null;
     
        return dtprop;}

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the biografia
     */
    public String getBiografia() {
        return biografia;
    }

    /**
     * @param biografia the biografia to set
     */
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
    }
}
