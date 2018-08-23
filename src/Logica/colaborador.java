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

private final Map<String,colProp> colaboracionesUsuario = new HashMap<String,colProp>();//diccionario con clave string
    
public void agregarolaboracion(colProp colaboracion){
colaboracionesUsuario.put(colaboracion.getPropColaborada().getTitulo(), colaboracion);
}

public boolean sosColaborador(){
    return true;
    }
    

    public colaborador(String nickname, String nombre, String apellido, String email, String imagen, dtFecha nacimiento) {
        super(nickname, nombre, apellido, email, imagen, nacimiento);
    }

public dtColaborador getColaboradores(){

    dtColaborador dtcol=null;
    return dtcol;
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


}
