/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.proponente;
import Logica.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nicolasgutierrez
 */
public class seguirdejardeseguirPersistencia {
    
    private Connection conexion = new ConexionDB().getConexion();
    
    public boolean seguir(usuario us,usuario uas){
                    try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO Seguidores "
                    + "(nickusuario, nickasegior) values(?,?)");
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
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM Seguidores WHERE "
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
}    
    
    
