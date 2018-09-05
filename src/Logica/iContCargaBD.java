/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author juan
 */
public interface iContCargaBD {

    public abstract void agregardtusu(dtUsuario us);

    public abstract void agregardtcolaboraciones(dtColaboracionCompleto dtcol);

    public abstract void agregardtpropuesta(dtPropuestasBD dtprop);

    public abstract void setearEstado(ArrayList<dtEstado> estadosV);

    public abstract void setearCategoria(dtCategoria dtcat);

    public abstract void setearEstadoPropuesta(dtEstadosPropuestas estProp);

    public abstract void levantarBDproPer();

    public abstract void levantaBDusuPer();

    public abstract void levantarBDcolPer();

    public abstract void levantarBDestadosPropPer();

    public abstract boolean cargarDatos();
}
