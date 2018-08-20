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
public class propuesta {

    private String titulo, descripcion, imagen, lugar;
    dtFecha fecharealizacion, fechapublicada;
    int precioEntrada, montoRequerido;

    
    //METODOS//
    public boolean sosPropuesta(String idPropuesta){
    return true;
    }

    public propuesta getPropuesta(){
    propuesta prop=new propuesta();
    return prop;
    }

    public propuesta getPropExistentes(){
    propuesta prop=new propuesta();
    return prop;
    }

    
    //CONSTRUCTORES//
    public propuesta() {}
    
    public propuesta(String titulo, String descripcion, String imagen, String lugar, dtFecha fecharealizacion, dtFecha fechapublicada, int precioEntrada, int montoRequerido) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecharealizacion = fecharealizacion;
        this.fechapublicada = fechapublicada;
        this.precioEntrada = precioEntrada;
        this.montoRequerido = montoRequerido;
    }

    //GETTERS
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public String getLugar() {
        return lugar;
    }

    public dtFecha getFecharealizacion() {
        return fecharealizacion;
    }

    public dtFecha getFechapublicada() {
        return fechapublicada;
    }

    public int getPrecioEntrada() {
        return precioEntrada;
    }

    public int getMontoRequerido() {
        return montoRequerido;
    }
    
    //SETTERS//
     public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecharealizacion(dtFecha fecharealizacion) {
        this.fecharealizacion = fecharealizacion;
    }

    public void setFechapublicada(dtFecha fechapublicada) {
        this.fechapublicada = fechapublicada;
    }

    public void setPrecioEntrada(int precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public void setMontoRequerido(int montoRequerido) {
        this.montoRequerido = montoRequerido;
    }

    
    
}
