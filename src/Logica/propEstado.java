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
    private dtHora hora;
    private estado estado;
    
//METODOS//

    public propEstado(dtFecha fecha, dtHora hora, estado estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }
    
    

    public dtFecha getFecha() {
        return fecha;
    }

    public dtHora getHora() {
        return hora;
    }

    public estado getEstado() {
        return estado;
    }

    
    
    public void setFecha(dtFecha fecha) {
        this.fecha = fecha;
    }

    public void setHora(dtHora hora) {
        this.hora = hora;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }
    


}