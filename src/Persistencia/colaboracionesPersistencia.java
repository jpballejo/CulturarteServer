/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nicolasgutierrez
 */
public class colaboracionesPersistencia {
    
    ConexionDB conexion;
    
    public boolean registrarColaboracion(String colaborador, String titulo, String fecha, String hora, String monto, String retorno){
                    try {
             String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "INSERT INTO Colaboraciones (nickusuario, tituloprop, fecha, hora, monto, retorno) VALUES ("+colaborador+","+titulo+","+fecha+","+hora+","+monto+","+retorno+")";
            st.executeQuery(sql);           
            conexion.getConn().close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    public boolean eliminarColaboracion(String colaborador,String titulo){
                    try {
            String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "DELETE FROM Colaboraciones WHERE nickusuario ="+colaborador+" AND tituloprop ="+titulo;
            st.executeQuery(sql);           
            conexion.getConn().close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
}
