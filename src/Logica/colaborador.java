/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Esteban Menendez
 */
public class colaborador extends usuario{
    private List<colProp> colaboraciones;
    
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
String s = "retorno";
return s;
}

public void darAltaColaboracion(String tipoRetorno,int montoColaboracion ){
}

    @Override
    public colProp seleccioonarColaboracion(String titulo){
        ListIterator it=this.colaboraciones.listIterator();
        while(it.hasNext()){
            colProp cp=(colProp)it.next();
        /*    if(cp.getTitulo()==titulo){
                return cp;
            } */
        
        }

        return null;
    }
    
    @Override
    public void eliminarColaboracion(colProp c){
        this.colaboraciones.remove(c);        
    }

//CONSTRUCTOR//
    public colaborador() {
    }

    
}
