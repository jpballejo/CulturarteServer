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
public class dtColaboraciones {

    private String nickname, idPropuesta;

//CONSTRUCTOR//
    public dtColaboraciones(String nickname, String idPropuesta) {
        this.nickname = nickname;
        this.idPropuesta = idPropuesta;
    }

//GETTERS//
    public String getNickname() {
        return nickname;
    }

    public String getIdPropuesta() {
        return idPropuesta;
    }

//SETTERS//
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setIdPropuesta(String idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    
}
