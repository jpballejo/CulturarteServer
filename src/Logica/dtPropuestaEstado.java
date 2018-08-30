/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author nicolasgutierrez
 */
public class dtPropuestaEstado {
    String titulo, estado;
    String fecha, hora;
    
    public dtPropuestaEstado(String titulo, String estado, String fecha, String hora){
        this.estado=estado;
        this.titulo=titulo;
        this.fecha=fecha;
        this.hora=hora;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getFecha(){
        return this.fecha;
    }
    
    public String getHora(){
        return this.hora;
    }
}
