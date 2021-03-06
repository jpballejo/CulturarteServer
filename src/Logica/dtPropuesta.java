/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Esteban Menendez
 */
public class dtPropuesta {

    String titulo, descripcion, imagen, lugar, estado, categoria, proponente;
    private String retorno;
    dtFecha fechaRealizacion, fechapublicada;
    int precioentrada, montorequerido, montoactual;
    List<String> colaboradores;

//CONSTRUCTOR//
    public dtPropuesta(String titulo, String descripcion, String imagen, String lugar, String estado, String categoria, String proponente, dtFecha fechaRealizacion, dtFecha fechapublicada, int precioentrada, int montorequerido, int montoactual, String retorno) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.estado = estado;
        this.categoria = categoria;
        this.proponente = proponente;
        this.fechaRealizacion = fechaRealizacion;
        this.fechapublicada = fechapublicada;
        this.precioentrada = precioentrada;
        this.montorequerido = montorequerido;
        this.montoactual=montoactual;
       this.retorno=retorno;
        this.colaboradores= new ArrayList<String>();
    }

    public dtPropuesta(String titulo, String proponente) {
        this.titulo = titulo;
        this.proponente = proponente;
    }
    
    

//GETTERS//
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

    public String getEstado() {
        return estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getProponente() {
        return proponente;
    }

    public dtFecha getFechaRealizacion() {
        return fechaRealizacion;
    }

    public dtFecha getFechapublicada() {
        return fechapublicada;
    }

    public int getPrecioentrada() {
        return precioentrada;
    }

    public int getMontorequerido() {
        return montorequerido;
    }
    
    public List<String> detColaboradores(){
        return colaboradores;
    }
    
    public int getMontoTotal() {
        return montoactual;
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setProponente(String proponente) {
        this.proponente = proponente;
    }

    public void setFechaRealizacion(dtFecha fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public void setFechapublicada(dtFecha fechapublicada) {
        this.fechapublicada = fechapublicada;
    }

    public void setPrecioentrada(int precioentrada) {
        this.precioentrada = precioentrada;
    }

    public void setMontorequerido(int montorequerido) {
        this.montorequerido = montorequerido;
    }
    
    public void setColaboradores(List<String> l){
        this.colaboradores=l;
    }
    
    public void setMontoTotal(int m){
        this.montoactual=m;
    }

    /**
     * @return the retorno
     */
    public String getRetorno() {
        return retorno;
    }
}
