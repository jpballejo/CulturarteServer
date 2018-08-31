/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtFecha;
import Logica.dtPropuestasBD;
import Logica.dtSeguidores;
import Logica.proponente;
import Logica.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicolasgutierrez
 */
public class seguirdejardeseguirPersistencia {
    
    private Connection conexion = new ConexionDB().getConexion();
   static ConexionDB conne;
    
    public boolean seguir(usuario us,usuario uas){
                    try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO 'Seguidores' "
                    + "('nickusuario', 'nickasegior') values(?,?)");
            statement.setString(1, us.getNickname());
            statement.setString(2, uas.getNickname());         
            statement.executeUpdate();
            statement.close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    public boolean dejardeseguir(usuario us,usuario uas){
                    try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM 'Seguidores' WHERE "
                    + "nickusuario = ? AND nickaseguir = ?");
            statement.setString(1, us.getNickname());
            statement.setString(2, uas.getNickname());         
            statement.executeUpdate();
            statement.close();
       
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    public static List<dtSeguidores> cargarSeguidores(){
        try {
            
            List<dtSeguidores> list= new ArrayList<>();
            String sql=null;       
            Statement st=conne.getConn().createStatement();
            sql= "SELECT * FROM 'Seguidores'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                dtSeguidores dt=new dtSeguidores(rs.getString("nickusuario"),rs.getString("nickaseguir"));
                list.add(dt);      
            }
            return list;    
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }         
    }
}    
    
    
