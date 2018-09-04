/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtColaboracionCompleto;
import Logica.dtFecha;
import Logica.dtHora;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicolasgutierrez
 */
public class colaboracionesPersistencia {

    static ConexionDB conexion = new ConexionDB();

    public boolean registrarColaboracion(String colaborador, String titulo, String fecha, String hora, String monto, String retorno) {
        try {
            String sql = null;
            sql = "INSERT INTO 'Colaboraciones' ('nickusuario', 'tituloprop', 'fecha', 'hora', 'monto', 'retorno') VALUES ('" + colaborador + "','" + titulo + "','" + fecha + "','" + hora + "','" + monto + "','" + retorno + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
           // conexion.cerrar(conn);

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarColaboracion(String colaborador, String titulo) {
        try {
            String sql = null;
            sql = "DELETE FROM 'Colaboraciones' WHERE nickusuario ='" + colaborador + "' AND tituloprop ='" + titulo+"'";
           Connection conn= conexion.getConexion();
           Statement st=conn.createStatement();
            st.executeUpdate(sql);
           // conexion.cerrar(conn);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<dtColaboracionCompleto> cargarColaboraciones() {
        try {
            List<dtColaboracionCompleto> list = new ArrayList<>();
            String sql = "SELECT * FROM Colaboraciones";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] f = rs.getString("fecha").split("/");
                dtFecha dtf = new dtFecha(f[0], f[1], f[2]);
                String[] h = rs.getString("hora").split(":");
                dtHora dth = new dtHora(Integer.parseInt(h[0]), Integer.parseInt(h[1]));
                dtColaboracionCompleto dtc = new dtColaboracionCompleto(rs.getString("nickusuario"), rs.getString("tituloprop"), dtf, dth, Integer.parseInt(rs.getString("monto")), rs.getString("retorno"));
                list.add(dtc);

            }
           // conexion.cerrar(conn);
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
