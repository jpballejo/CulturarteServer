/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Esteban Menendez
 */
public class propuesta {

    private String titulo, descripcion, imagen, lugar, retorno;
    private dtFecha fecharealizacion;
    protected List<propEstado> estados;
    private categoria categoria;


    public propuesta(String titulo, String descripcion, String imagen, String lugar, dtFecha fecharealizacion, dtFecha fechapublicada, int precioEntrada, int montoRequerido, String retorno) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecharealizacion = fecharealizacion;
        this.fechapublicada = fechapublicada;
        this.precioEntrada = precioEntrada;
        this.montoRequerido = montoRequerido;
        this.estados=new ArrayList<>();
        this.retorno=retorno;
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
    
    public String getEstadoActual(){
        propEstado aux=null;
        Iterator it= estados.iterator();
        while(it.hasNext()){
            aux=(propEstado) it.next();
        }
        
        if(aux==null)
            return null;
        else
            return aux.getEstado().getNombre();
        
        
    }

    
    public List<propEstado> getEstados(){
        return this.estados;
    }
    
    public void agregarNuevoEstado(estado e, dtFecha dtf, dtHora dth){
        propEstado pe=new propEstado(dtf,dth,e);
        this.estados.add(pe);
    
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
    
    public String getCategoria() {
        return categoria.getNombre();
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
    
    public void setRetorno(String r){
        this.retorno=r;
    }
    
    public String getRetorno(){
        return this.retorno;
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

    
    //METODOS//
    public boolean sosPropuesta(String idPropuesta){
    return true;
    }

  
    public void ordenarestados(){
        propEstado chiquito=null;
        List<propEstado> aux=new ArrayList<>();
        Iterator it=this.estados.iterator();
        while(it.hasNext()){
            Iterator it2=this.estados.iterator();
            propEstado p1=(propEstado) it.next();
            while(it2.hasNext()){
                propEstado p2=(propEstado) it2.next();
                if(compararfechas(p1.getFecha(),p2.getFecha())==false)
                    chiquito=p1;
                else
                    chiquito=p2;
            }
            aux.add(chiquito);
            this.estados.remove(chiquito);
            
        }
        
        this.estados=aux;
        
    }

    public boolean compararfechas(dtFecha uno, dtFecha dos){
         int unoanio=Integer.parseInt(uno.getAnio());
         int unomes=Integer.parseInt(uno.getMes());
         int unodia=Integer.parseInt(uno.getDia());
         int dosanio=Integer.parseInt(dos.getAnio());
         int dosmes=Integer.parseInt(dos.getMes());
         int dosdia=Integer.parseInt(dos.getDia());
         
         if(unoanio>dosanio){
             return true;
         }
         if(unoanio==dosanio && unomes>dosmes){
             return true;
         }
         if(unoanio==dosanio && unomes==dosmes && unodia>dosdia){
             return true;
         }
         if(unoanio==dosanio && unomes==dosmes && unodia==dosdia){ //CASO DUDOSO
             return false;
         }
         else{
             return false;
         }
         
     }
         
    public boolean compararhoras(dtHora uno, dtHora dos){
         if(uno.getHoras()>dos.getHoras()){
             return true;
         }
         if(uno.getHoras()==dos.getHoras() && uno.getMinutos()>dos.getMinutos()){
             return true;
         }
         if(uno.getHoras()==dos.getHoras() && uno.getMinutos()==dos.getMinutos()){
             return true;
         }
         else
             return false;
         
     }
    
    public void desvincular(){
        this.estados.clear();
        this.categoria=null;
        this.fechapublicada=null;
        this.fecharealizacion=null;
        
    }
  
  }
