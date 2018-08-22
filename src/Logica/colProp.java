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

    /**
     * @return the fecha
     */
    public dtFecha getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(dtFecha fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public dtHora getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(dtHora hora) {
        this.hora = hora;
    }

    /**
     * @return the montocolaborado
     */
    public int getMontocolaborado() {
        return montocolaborado;
    }

    /**
     * @param montocolaborado the montocolaborado to set
     */
    public void setMontocolaborado(int montocolaborado) {
        this.montocolaborado = montocolaborado;
    }

    /**
     * @return the retorno
     */
    public enumRetorno getRetorno() {
        return retorno;
    }

    /**
     * @param retorno the retorno to set
     */
    public void setRetorno(enumRetorno retorno) {
        this.retorno = retorno;
    }

    /**
     * @return the propColaborada
     */
    public propuesta getPropColaborada() {
        return propColaborada;
    }

    /**
     * @param propColaborada the propColaborada to set
     */
    public void setPropColaborada(propuesta propColaborada) {
        this.propColaborada = propColaborada;
    }

}
