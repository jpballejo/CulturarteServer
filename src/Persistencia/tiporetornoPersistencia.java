/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtColaboracionCompleto;
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
public class tiporetornoPersistencia {
    
    ConexionDB conexion;
    
    public List<String> cargarRetornos(){
     try{
        List<String> list= new ArrayList<>();
        String sql=null;
        Statement st=conexion.getConn().createStatement();
        sql= "SELECT * FROM tipoRetorno";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){              
            list.add(rs.getString("nombre"));
            
        }
            return list;
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }
}
