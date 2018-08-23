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
    private enumRetorno retorno;


    //METODOS//
    
    public void sosColProp(String idPropuesta){
    }
    
    public dtColaborador getColProp(){
    dtColaborador dtcol=null;
    return dtcol;
    }
    
    public void altaColaboracionEnPropuesta(String idPropuesta){
    }
public propuesta getPropColaborada(){return null;}
//CONSTRUCTOR//

    public colProp(dtFecha fecha, dtHora hora, int montocolaborado, enumRetorno retorno) {
        this.fecha = fecha;
        this.hora = hora;
        this.montocolaborado = montocolaborado;
        this.retorno = retorno;
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

    public enumRetorno getRetorno() {
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

    public void setRetorno(enumRetorno retorno) {
        this.retorno = retorno;
    }

 
}
