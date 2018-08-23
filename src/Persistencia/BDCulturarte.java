/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.proponente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nicolasgutierrez
 */
public class BDCulturarte {
    
    private Connection conexion = new ConexionDB().getConexion();
    
    public boolean agregarProponente(proponente p){
            try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO usuario "
                    + "(IdUsuario, nombre, apellido, email, imagen, fechaNacimiento) values(?,?,?,?,?,?)");
            statement.setString(1, p.getNickname());
            statement.setString(2, p.getNombre());
            statement.setString(3, p.getApellido());
            statement.setString(4, p.getEmail());
            statement.setString(5, p.getImagen());
            statement.setString(6, p.getNacimientoString());
            statement.executeUpdate();
            statement.close();
            
            PreparedStatement statement2 = conexion.prepareStatement("INSERT INTO Proponente "
                    + "(id_usuario, direccion, pag_web, biografia) values(?,?,?,?)");
            statement2.setString(1, p.getNickname());
            statement2.setString(2, p.getDireccion());
            statement2.setString(4, p.getBiografia());
            statement2.setString(3, p.getWeb());
            statement2.executeUpdate();
            statement2.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }        
    }
    
    
}
