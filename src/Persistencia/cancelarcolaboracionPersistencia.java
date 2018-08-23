/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.colProp;
import Logica.proponente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nicolasgutierrez
 */
public class cancelarcolaboracionPersistencia {
    
    
    private Connection conexion = new ConexionDB().getConexion();
    
    public boolean cancelarColaboracion(String nick,colProp cp ){
            try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM Colaboraciones WHERE "
                    + "nickusuario = ? AND tituloprop = ?");
            statement.setString(1, nick);
            statement.setString(2, cp.getPropColaborada().getTitulo());
            statement.executeUpdate();
            statement.close();
   
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }        
    }    
    
}
