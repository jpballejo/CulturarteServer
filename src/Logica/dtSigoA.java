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
public class dtSigoA {
    private String nickusuario,rol,nombrecompleto;

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public dtSigoA(String nickusuario, String rol, String nc) {
        this.nickusuario = nickusuario;
        this.rol = rol;
        this.nombrecompleto=nc;
    }

    public String getNickusuario() {
        return nickusuario;
    }

    public String getRol() {
        return rol;
    }
    
    
}
