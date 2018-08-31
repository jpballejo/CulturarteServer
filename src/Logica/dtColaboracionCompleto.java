/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author nicolasgutierrez
 */
public class dtColaboracionCompleto {
    
    String nickname, titulo, retorno;
    int monto;
    dtFecha fecha;
    dtHora hora;
    
    public dtColaboracionCompleto(String n, String t, dtFecha dtf, dtHora dth, int m, String r) {
        this.nickname=n;
        this.titulo=t;
        this.fecha=dtf;
        this.hora=dth;
        this.monto=m;
        this.retorno=r;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRetorno() {
        return retorno;
    }

    public int getMonto() {
        return monto;
    }

    public dtFecha getFecha() {
        return fecha;
    }

    public dtHora getHora() {
        return hora;
    }

    
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setFecha(dtFecha fecha) {
        this.fecha = fecha;
    }

    public void setHora(dtHora hora) {
        this.hora = hora;
    }
    
    
}
