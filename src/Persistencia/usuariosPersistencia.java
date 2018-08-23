/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Persistencia.ConexionDB;
import Logica.dtColaborador;
import Logica.dtProponente;
import Logica.dtUsuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class usuariosPersistencia {
    ConexionDB conexion;

    public void altaUsuario(dtUsuario dtUsu){
        try {
            String sqlUsu=null,sqlProp=null,sqlCol=null;
            Statement st=conexion.getConn().createStatement();
            dtProponente dtProp = (dtProponente)dtUsu;
            if (dtProp!=null){
                sqlUsu = "INSERT INTO usuario (idUsuario,nombre,apellido,email,fechaNacimiento, imagen)VALUES("+dtProp.getNickname()+","+dtProp.getNombre()+","+dtProp.getApellido()+","+dtProp.getEmail()+","+dtProp.getFechaNac().getFecha()+","+dtProp.getImagen()+")";
                sqlProp ="INSERT INTO Proponente (id_usuario,direccion,pag_web,biografia) VALUES ("+dtProp.getNickname()+","+dtProp.getDireccion()+","+dtProp.getSitioWeb()+","+dtProp.getBiografia()+")";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlProp);
                conexion.getConn().close();
            }
            dtColaborador dtCol = (dtColaborador)dtUsu;
            if(dtCol!=null){
                sqlCol="INSERT INTO colaborador VALUES ("+dtCol.getNickname()+")";
                st.executeUpdate(sqlCol);
                conexion.getConn().close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuariosPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
