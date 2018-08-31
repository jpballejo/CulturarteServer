/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtColaboracionCompleto;
import Logica.dtCreadoresPropuestas;
import Logica.dtFecha;
import Logica.dtHora;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicolasgutierrez
 */
public class creadoresPropuestaPersistencia {
    
        
    ConexionDB conexion;
    
    public boolean agregarCreador(String proponente, String titulo){
                    try {
             String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "INSERT INTO 'CreadoresPropuesta' ('nickusuario', 'tituloprop') VALUES ("+proponente+","+titulo+")";
            st.executeUpdate(sql);           
            conexion.getConn().close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    
    public boolean eliminarCreador(String proponente, String titulo){
                    try {
             String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "DELETE FROM 'CreadoresPropuesta' WHERE nickusuario="+proponente+" AND tituloprop="+titulo;
            st.executeUpdate(sql);
            conexion.getConn().close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    
    public String quienMeCreo(String titulo){
        try {
            String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "SELECT 'nickusuario' FROM 'CreadoresPropuesta' WHERE tituloprop="+titulo;
            ResultSet ret=st.executeQuery(sql);
            conexion.getConn().close();
            return ret.getString("nickusuario");
       
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
        
    }
    
    public List<dtCreadoresPropuestas> cargarCreadores(){
        
        try{
            List<dtCreadoresPropuestas> list=new ArrayList<>();
            String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "SELECT * FROM 'CreadoresPropuesta'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){           
                dtCreadoresPropuestas dt= new dtCreadoresPropuestas(rs.getString("nickusuario"),rs.getString("tituloprop"));
                list.add(dt);
            
        }
            return list;
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }
}
