/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Esteban Menendez
 */
public class colaborador extends usuario{
    
    public colaborador(String nickname, String nombre, String apellido, String email, String imagen, dtFecha nacimiento) {
        super(nickname, nombre, apellido, email, imagen, nacimiento);
    }
    
    private final Map<String,colProp> colaboracionesUsuario = new HashMap<String,colProp>();//diccionario con clave string
public void agregarolaboracion(colProp colaboracion){
colaboracionesUsuario.put(colaboracion.getPropColaborada().getTitulo(), colaboracion);
}
}
