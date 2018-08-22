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
    private dtFecha fecharealizacion;

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
    private dtFecha fechapublicada;
    private int precioEntrada;
    private int montoRequerido;

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the fecharealizacion
     */
    public dtFecha getFecharealizacion() {
        return fecharealizacion;
    }

    /**
     * @param fecharealizacion the fecharealizacion to set
     */
    public void setFecharealizacion(dtFecha fecharealizacion) {
        this.fecharealizacion = fecharealizacion;
    }

    /**
     * @return the fechapublicada
     */
    public dtFecha getFechapublicada() {
        return fechapublicada;
    }

    /**
     * @param fechapublicada the fechapublicada to set
     */
    public void setFechapublicada(dtFecha fechapublicada) {
        this.fechapublicada = fechapublicada;
    }

    /**
     * @return the precioEntrada
     */
    public int getPrecioEntrada() {
        return precioEntrada;
    }

    /**
     * @param precioEntrada the precioEntrada to set
     */
    public void setPrecioEntrada(int precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    /**
     * @return the montoRequerido
     */
    public int getMontoRequerido() {
        return montoRequerido;
    }

    /**
     * @param montoRequerido the montoRequerido to set
     */
    public void setMontoRequerido(int montoRequerido) {
        this.montoRequerido = montoRequerido;
    }

}
