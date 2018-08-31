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
    ConexionDB conexion = new ConexionDB();

    public void altaUsuario(dtUsuario dtUsu) throws Exception{
        try {
            String sqlUsu=null,sqlProp=null,sqlCol=null;
            Connection con= conexion.getConn();
            Statement st= (Statement)con.createStatement();
        
            if (dtUsu instanceof dtProponente){
                dtProponente dtProp = (dtProponente)dtUsu;
                sqlUsu = "INSERT INTO `usuario`(`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`)VALUES('"+dtProp.getNickname()+"','"+dtProp.getNombre()+"','"+dtProp.getApellido()+"','"+dtProp.getEmail()+"','"+dtProp.getFechaNac().getFecha()+"','"+dtProp.getImagen()+"')";
                sqlProp ="INSERT INTO `Proponente` (`id_usuario`,`direccion`,`pag_web`,`biografia`) VALUES ('"+dtProp.getNickname()+"','"+dtProp.getDireccion()+"','"+dtProp.getSitioWeb()+"','"+dtProp.getBiografia()+"')";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlProp);
                con.close();
            }
            
            
            if(dtUsu instanceof dtColaborador){
                dtColaborador dtCol = (dtColaborador)dtUsu;
                
                sqlUsu = "INSERT INTO `usuario`(`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`)VALUES('"+dtCol.getNickname()+"','"+dtCol.getNombre()+"','"+dtCol.getApellido()+"','"+dtCol.getEmail()+"','"+dtCol.getFechaNac().getFecha()+"','"+dtCol.getImagen()+"')";
                sqlCol="INSERT INTO colaborador (`idUsuario`) VALUES ('"+dtCol.getNickname()+"')";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlCol);
                conexion.getConn().close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           // throw new Exception("Error al insertar los datos en la BD");
            
        }
    
    }
    
}
