/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtSeguidores;
import Logica.dtUsuario;
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

    static ConexionDB conexion = new ConexionDB();

    public boolean seguir(dtUsuario us, dtUsuario uas) {
        try {
            Connection conn = conexion.getConexion();
            String sql = "INSERT INTO `cultuRarte`.`Seguidores`(`nickusuario`,`nickaseguir`) VALUES ('" + us.getNickname() + "','" + uas.getNickname() + "')";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println();
         //   conexion.cerrar(conn);
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public boolean dejardeseguir(dtUsuario us, dtUsuario uas) {
        try {
            String sql="DELETE FROM 'Seguidores' WHERE nickusuario ='"+us.getNickname()+"'  AND nickaseguir ='"+uas.getNickname()+"'";
            Connection conn = conexion.getConexion();
            Statement st=conn.createStatement();
            st.executeUpdate(sql);
        //    conexion.cerrar(conn);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<dtSeguidores> cargarSeguidores() {
        try {

            List<dtSeguidores> list = new ArrayList<>();
            String sql = "SELECT * FROM Seguidores";
            Connection conn = conexion.getConexion();
            Statement st=conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dtSeguidores dt = new dtSeguidores(rs.getString(1), rs.getString(2));
                list.add(dt);
            }
         //   conexion.cerrar(conn);
            return list;

        } catch (SQLException ex) {
            return null;
        }
    }
}
