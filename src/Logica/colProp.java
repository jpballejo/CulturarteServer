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
public class colProp {
    private propuesta propColaborada;
    private dtFecha fecha;
    private dtHora hora;
    private int montocolaborado;
    private String retorno;
    private String comentario;


    //METODOS//
    
    public void sosColProp(String idPropuesta){
    }
    
    public dtColaborador getColProp(){
    dtColaborador dtcol=null;
    return dtcol;
    }
    
    public void altaColaboracionEnPropuesta(String idPropuesta){
    }
    public propuesta getPropColaborada(){  
    return this.propColaborada;
}
//CONSTRUCTOR//

    public colProp(dtFecha fecha, dtHora hora, int montocolaborado, String retorno, propuesta prop, String comen) {
        this.fecha = fecha;
        this.hora = hora;
        this.montocolaborado = montocolaborado;
        this.retorno = retorno;
        this.propColaborada=prop;
        this.comentario=comen;
    }
    
    //GETTERS//
    public dtFecha getFecha() {
        return fecha;
    }

    public dtHora getHora() {
        return hora;
    }

    public int getMontocolaborado() {
        return montocolaborado;
    }

    public String getRetorno() {
        return retorno;
    }
    
    
    //SETTERS//
    public void setFecha(dtFecha fecha) {
        this.fecha = fecha;
    }

    public void setHora(dtHora hora) {
        this.hora = hora;
    }

    public void setMontocolaborado(int montocolaborado) {
        this.montocolaborado = montocolaborado;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public void setPropuesta(propuesta p) {
        this.propColaborada=p;
    }

    void eliminate() {
        this.propColaborada=null;
        this.fecha=null;
        this.hora=null;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
 
}
