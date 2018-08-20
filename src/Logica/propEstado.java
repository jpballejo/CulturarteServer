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
public class propEstado {

    private dtFecha fecha;
    
//METODOS//
    

//CONSTRUCTOR//
    public propEstado(dtFecha fecha) {
        this.fecha = fecha;
    }
  
//GETTER//
    public dtFecha getFecha() {
        return fecha;
    }
    
//SETTER//
    public void setFecha(dtFecha fecha) {
        this.fecha = fecha;
    }
}
