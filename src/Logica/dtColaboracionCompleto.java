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
    private String comentario;
    
    public dtColaboracionCompleto(String n, String t, dtFecha dtf, dtHora dth, int m, String r, String comen) {
        this.nickname=n;
        this.titulo=t;
        this.fecha=dtf;
        this.hora=dth;
        this.monto=m;
        this.retorno=r;
        this.comentario=comen;
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

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

}
