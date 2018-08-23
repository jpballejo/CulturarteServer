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
public class dtHora {

    private int horas, minutos;

//CONSTRUCTOR//
    public dtHora(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
    }

//GETTERS//
    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

//SETTERS//
    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    
    
}
