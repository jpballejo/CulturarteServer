/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtEstadosPropuestas;
import Logica.dtFecha;
import Logica.dtHora;
import Logica.estado;
import java.sql.PreparedStatement;
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
public class estadoPersistencia {
          
    static ConexionDB conexion;
    
    public boolean agregarestado(String nombre){
                    try {
             String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "INSERT INTO 'estado' ('estado') VALUES ("+nombre+")";
            st.executeUpdate(sql);           
            conexion.getConn().close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
        public boolean eliminarestado(String nombre){
                    try {
             String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "DELETE FROM 'estado' WHERE estado="+nombre;
            st.executeUpdate(sql);           
            conexion.getConn().close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
        
        public static Map<String, estado> CargarEstados(){
                try {
            String sql=null;
            Map<String, estado> lista=new HashMap<String, estado>();
            Statement st = conexion.getConn().createStatement();  
            sql=("SELECT * FROM 'estado'"); 
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                String codigo=rs.getString("estado");
                estado e=new estado(codigo);
                lista.put(codigo, e);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }  
        }
        
        
        public static List<dtEstadosPropuestas> CargarEstadosPropuestas(){
            try{
            List<dtEstadosPropuestas> list= new ArrayList<>();
            String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql="SELECT * FROM 'estadoPropuesta'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                 String[] f=rs.getString("fecha").split("/");
                dtFecha dtf= new dtFecha(f[0],f[1],f[2]);
                String[] h=rs.getString("hora").split(":");
                dtHora dth= new dtHora(Integer.parseInt(h[0]),Integer.parseInt(h[1]));  
                
                dtEstadosPropuestas dt=new dtEstadosPropuestas(rs.getString("propuesta"),rs.getString("estado"),dtf,dth);
            }
            
            return list;
            
            } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }  
        }
}
