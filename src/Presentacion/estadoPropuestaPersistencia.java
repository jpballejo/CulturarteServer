/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.dtPropuestaEstado;
import Logica.estado;
import Persistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class estadoPropuestaPersistencia {
    
       ConexionDB conexion;
    
    public boolean agregarPropEstado(String titulo, String estado, String fecha, String hora){
                    try {
            String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "INSERT INTO estadoPropuesta (propuesta, estado, fecha, hora) VALUES ("+titulo+","+estado+","+fecha+","+hora+")";
            st.executeUpdate(sql);           
            conexion.getConn().close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
        public boolean eliminarPropEstado(String propuesta, String estado){
                    try {
            String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "DELETE FROM estadoPropuesta WHERE propuesta="+propuesta+" AND estado="+estado;
            st.executeUpdate(sql);           
            conexion.getConn().close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
                    
       }    
        
               public List<dtPropuestaEstado> CargarPropuestaEstados(){
                try {
            String sql=null;
            List<dtPropuestaEstado> lista=new ArrayList<dtPropuestaEstado>();
            Statement st = conexion.getConn().createStatement();  
            sql=("SELECT * FROM estadoPropuesta"); 
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                dtPropuestaEstado e=new dtPropuestaEstado(rs.getString("propuesta"),rs.getString("estado"),rs.getString("fecha"),rs.getString("hora"));
                lista.add(e);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }  
        } 
}
