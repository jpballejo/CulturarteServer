/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtPropuestaEstado;
import Persistencia.ConexionDB;
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
public class estadoPropuestaPersistencia {

    ConexionDB conexion;

    public boolean agregarPropEstado(String titulo, String estado, String fecha, String hora) {
        try {
            String sql = null;
            sql = "INSERT INTO 'estadoPropuesta' ('propuesta', 'estado', 'fecha', 'hora') VALUES ('" + titulo + "','" + estado + "','" + fecha + "','" + hora + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conexion.cerrar(conn);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean eliminarPropEstado(String propuesta, String estado) {
        try {
            String sql = null;
            sql = "DELETE FROM 'estadoPropuesta' WHERE propuesta='" + propuesta + "' AND estado='" + estado + "'";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conexion.cerrar(conn);
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public List<dtPropuestaEstado> CargarPropuestaEstados() {
        try {
            String sql = "SELECT * FROM estadoPropuesta";
            List<dtPropuestaEstado> lista = new ArrayList<>();
            Connection conn = conexion.getConexion();
            Statement st= conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dtPropuestaEstado e = new dtPropuestaEstado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lista.add(e);
            }
            conexion.cerrar(conn);
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
}
