/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author Esteban Menendez
 */
public class dtFecha {

    private String dia, mes, anio;
   

//CONSTRUCTOR//
    /**
     *
     * Constructor de 3 parametros String dia/mes/año
     */
    public dtFecha(String dia, String mes, String anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     *
     * Constructor de 4 parametros String dia/mes/año Date fecha - recibe un
     * objeto date
     */
   

//GETTERS//
    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAnio() {
        return anio;
    }

    public String getFecha() {
        String fecha = null;
        fecha = this.dia + "/" + this.mes + "/" + this.anio;

        return fecha;
    }

    /**
     * retorna un objeto date
     */
    
}
