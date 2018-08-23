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

private Map<String,colProp> colaboracionesUsuario = new HashMap<String,colProp>();//diccionario con clave string
    
public boolean sosColaborador(){
    return true;
    }
    
public dtColaborador getColaboradores(){

    return null;
}

public dtColaborador getColaborador(){
return null;
}


public String getRetornos(){
String s = "retorno";
return s;
}

public void darAltaColaboracion(String tipoRetorno,int montoColaboracion ){
}

    @Override
    public colProp seleccioonarColaboracion(String titulo){
        
        return null;
    }
    
    @Override
    public void eliminarColaboracion(colProp c){
        this.colaboracionesUsuario.remove(c.getPropColaborada().getTitulo());
    }

   

    public colaborador(String nickname, String nombre, String apellido, String email, String imagen, dtFecha nacimiento) {
        super(nickname, nombre, apellido, email, imagen, nacimiento);
    }
 



}
