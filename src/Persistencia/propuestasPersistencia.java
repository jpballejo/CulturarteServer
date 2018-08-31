/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtColaboracionCompleto;
import Logica.dtFecha;
import Logica.dtHora;
import Logica.dtPropuestasBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class propuestasPersistencia {
    
    static ConexionDB conexion;
    
    public static Map<String, dtPropuestasBD> cargarPropuestas(){
        try{ 
            Map<String, dtPropuestasBD> propuestas= new HashMap<String, dtPropuestasBD>();
            String sql=null;
        
            Statement st=conexion.getConn().createStatement();
            sql= "SELECT * FROM 'Propuesta'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String key=rs.getString("titulo");
                String[] f=rs.getString("fecha").split("/");
                dtFecha dtf= new dtFecha(f[0],f[1],f[2]);
                String[] h=rs.getString("fecha_publicacion").split("/");
                dtFecha dtfc= new dtFecha(f[0],f[1],f[2]);           
                dtPropuestasBD dt= new dtPropuestasBD(rs.getString("titulo"),rs.getString("proponente"),rs.getString("descripcion"),rs.getString("imagen"),rs.getString("lugar"),rs.getString("categoria"),rs.getString("retorno"),dtf,dtfc,Integer.parseInt(rs.getString("precio_entrada")),Integer.parseInt(rs.getString("monto_necesario")));
                propuestas.put(key, dt);
            
            }
            
            return propuestas;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }      
        
    }
    
}
