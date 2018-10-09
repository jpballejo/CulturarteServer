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
    private String comentario;
    private String titulo;
    
//CONSTRUCTOR//
    public dtColProp(String nickname, String retorno, dtFecha fecha, dtHora hora, int montoColaborado,String comen) {
        this.nickname = nickname;
        this.retorno = retorno;
        this.fecha = fecha;
        this.hora = hora;
        this.montoColaborado = montoColaborado;
        this.comentario=comen;
    }

    public dtColProp(String nickname, dtFecha fecha, dtHora hora, int montoColaborado, String titulo) {
        this.nickname = nickname;
        this.fecha = fecha;
        this.hora = hora;
        this.montoColaborado = montoColaborado;
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
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

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
}
