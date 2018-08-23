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
public class dtColProp {

    private String nickname, retorno;
    dtFecha fecha;
    dtHora hora;
    int montoColaborado;
    
//CONSTRUCTOR//
    public dtColProp(String nickname, String retorno, dtFecha fecha, dtHora hora, int montoColaborado) {
        this.nickname = nickname;
        this.retorno = retorno;
        this.fecha = fecha;
        this.hora = hora;
        this.montoColaborado = montoColaborado;
    }

//GETTERS//
    public String getNickname() {
        return nickname;
    }

    public String getRetorno() {
        return retorno;
    }

    public dtFecha getFecha() {
        return fecha;
    }

    public dtHora getHora() {
        return hora;
    }

    public int getMontoColaborado() {
        return montoColaborado;
    }

//SETTERS//
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public void setFecha(dtFecha fecha) {
        this.fecha = fecha;
    }

    public void setHora(dtHora hora) {
        this.hora = hora;
    }

    public void setMontoColaborado(int montoColaborado) {
        this.montoColaborado = montoColaborado;
    }
    
    
    
}
