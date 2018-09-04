/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Esteban Menendez
 */
public class propuesta {

    private String titulo, descripcion, imagen, lugar, retorno;
    private dtFecha fecharealizacion;
    private TreeMap<Integer, propEstado> estados;
    private categoria categoria;
    private dtFecha fechapublicada;
    private int precioEntrada;
    private int montoRequerido;

    public propuesta(String titulo, String descripcion, String imagen, String lugar, dtFecha fecharealizacion, dtFecha fechapublicada, int precioEntrada, int montoRequerido, String retorno, estado est, categoria cat) {
        this.estados = new TreeMap<Integer, propEstado>();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecharealizacion = fecharealizacion;
        this.fechapublicada = fechapublicada;
        this.precioEntrada = precioEntrada;
        this.montoRequerido = montoRequerido;
        this.retorno = retorno;
        this.categoria = cat;
        if (est != null) {
            Calendar cal = Calendar.getInstance();
            Date da = cal.getTime();
            dtHora dth = new dtHora(da.getHours(), da.getMinutes());
            propEstado e = new propEstado(fechapublicada, dth, est);
            this.estados.put(getNumEstado(est.getNombre()), e);
        }
    }

    public propuesta(String titulo, String descripcion, String imagen, String lugar, dtFecha fecharealizacion, dtFecha fechapublicada, int precioEntrada, int montoRequerido, String retorno, categoria cat) {
        this.estados = new TreeMap<Integer, propEstado>();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.lugar = lugar;
        this.fecharealizacion = fecharealizacion;
        this.fechapublicada = fechapublicada;
        this.precioEntrada = precioEntrada;
        this.montoRequerido = montoRequerido;
        this.retorno = retorno;
        this.categoria = cat;

    }

    propuesta(String titulo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the titulo
     */
    public Integer getNumEstado(String estado) {
        HashMap<String, Integer> idEstado = new HashMap<String, Integer>();
        idEstado.put("Cancelada", 6);
        idEstado.put("No financiada", 5);
        idEstado.put("Financiada", 4);
        idEstado.put("En financiacion", 3);
        idEstado.put("Publicada", 2);
        idEstado.put("Ingresada", 1);
        return idEstado.get(estado);

    }

    public String getTitulo() {
        return titulo;
    }

    public void setEstado(propEstado estprop) {
        int orden = getNumEstado(estprop.getEstado().getNombre());
        estados.put(orden, estprop);

    }

    public String getEstadoActual() {
        propEstado aux = null;
        Iterator it = estados.keySet().iterator();
        while (it.hasNext()) {
            aux = (propEstado) estados.get(it.next());
        }

        if (aux == null) {
            return null;
        } else {
            return aux.getEstado().getNombre();
        }

    }

    public TreeMap<Integer, propEstado> getEstados() {
        return this.estados;
    }

    public void agregarNuevoEstado(estado e, dtFecha dtf, dtHora dth) {
        propEstado pe = new propEstado(dtf, dth, e);
        this.estados.put(getNumEstado(e.getNombre()), pe);

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

    public void setRetorno(String r) {
        this.retorno = r;
    }

    public String getRetorno() {
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
    public boolean sosPropuesta(String idPropuesta) {
        if (this.titulo.equals(idPropuesta) == true) {
            return true;
        }
        return false;
    }

    public boolean compararfechas(dtFecha uno, dtFecha dos) {
        int unoanio = Integer.parseInt(uno.getAnio());
        int unomes = Integer.parseInt(uno.getMes());
        int unodia = Integer.parseInt(uno.getDia());
        int dosanio = Integer.parseInt(dos.getAnio());
        int dosmes = Integer.parseInt(dos.getMes());
        int dosdia = Integer.parseInt(dos.getDia());

        if (unoanio > dosanio) {
            return true;
        }
        if (unoanio == dosanio && unomes > dosmes) {
            return true;
        }
        if (unoanio == dosanio && unomes == dosmes && unodia > dosdia) {
            return true;
        }
        if (unoanio == dosanio && unomes == dosmes && unodia == dosdia) { //CASO DUDOSO
            return false;
        } else {
            return false;
        }

    }

    public boolean compararhoras(dtHora uno, dtHora dos) {
        if (uno.getHoras() > dos.getHoras()) {
            return true;
        }
        if (uno.getHoras() == dos.getHoras() && uno.getMinutos() > dos.getMinutos()) {
            return true;
        }
        if (uno.getHoras() == dos.getHoras() && uno.getMinutos() == dos.getMinutos()) {
            return true;
        } else {
            return false;
        }

    }

    public void desvincular() {
        this.estados.clear();
        this.categoria = null;
        this.fechapublicada = null;
        this.fecharealizacion = null;

    }

}
