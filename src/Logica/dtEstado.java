/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author juan
 */
public class dtEstado {
    private int numero;
    private String nombre;

    public dtEstado(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
}
