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
public class colaborador extends usuario{

public boolean sosColaborador(){
    return true;
    }
    
public dtColaborador getColaboradores(){

    dtColaborador dtcol=new dtColaborador();
    return dtcol;
}

public dtColaborador getColaborador(){
    
dtColaborador dtcol=new dtColaborador();
    return dtcol;
}


public String getRetornos(){
String s = "a";
return s;
}

public void darAltaColaboracion(String tipoRetorno,int montoColaboracion ){
}
   
}
