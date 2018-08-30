/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.categoria;
import Logica.dtColaborador;
import Logica.dtFecha;
import Logica.dtProponente;
import Logica.dtUsuario;
import Logica.proponente;
import Logica.usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class categoriaPersistencia {
   static ConexionDB conexion;

    public void altaCategoria(String nombre, String padre) throws Exception{
        try {
            String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "INSERT INTO Categoria (nombre, padre) VALUES ("+nombre+","+padre+")";
            st.executeUpdate(sql);
            conexion.getConn().close();
            
        } catch (SQLException ex) {
            throw new Exception("Error al insertar los datos en la BD");
        }
    
    }
    
        public void borrarCategoria(String nombre) throws Exception{
        try {
            String sql=null;
            Statement st=conexion.getConn().createStatement();
            sql= "DELETE FROM Categoria WHERE nombre ="+nombre;
            st.executeUpdate(sql);
            conexion.getConn().close();
            
        } catch (SQLException ex) {
            throw new Exception("Error al insertar los datos en la BD");
        }
    
    }
        
        public static Map<String, categoria> CargarCategorias(){
            Map<String, categoria> list= new HashMap<String, categoria>();
                 try {
            String sql=null;

            Statement st = conexion.getConn().createStatement();  
            sql=("SELECT * FROM Categoria"); 
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                String codigo=rs.getString("nombre");
                categoria c=new categoria(null,codigo);
                list.put(codigo, c);
            }
            rs.close();
            st.close();
            
            String sql2=null;

            Statement st2 = conexion.getConn().createStatement();  
            sql=("SELECT * FROM Categoria"); 
            ResultSet rs2=st2.executeQuery(sql2);
            while (rs2.next()){
                String clave=rs2.getString("nombre");
                String papito=rs2.getString("padre");
                if(papito!=""){
                     categoria c=(categoria)list.get(clave);
                     categoria p=(categoria)list.get(papito);
                     c.setPadre(p);
                     list.replace(clave, c);
                }
               
               
            }
            rs.close();
            st.close();
        
              return list;   
                  } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }  
    
}
        

}