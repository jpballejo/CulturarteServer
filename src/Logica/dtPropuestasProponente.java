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
public class dtPropuestasProponente {

    private String titulo, nickname;

//CONSTRUCTOR//
    public dtPropuestasProponente(String titulo, String nickname) {
        this.titulo = titulo;
        this.nickname = nickname;
    }

//GETTERS//
    public String getTitulo() {
        return titulo;
    }

    public String getNickname() {
        return nickname;
    }

//SETTERS//
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
