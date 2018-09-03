/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtEstadosPropuestas;
import Logica.dtFecha;
import Logica.dtHora;
import Logica.estado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class estadoPersistencia {

    static ConexionDB conexion;

    public static boolean agregarestado(String nombre) {
        try {
            String sql = "INSERT INTO 'estado' ('estado') VALUES ('" + nombre + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conexion.cerrar(conn);

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarestado(String nombre) {
        try {
            String sql = "DELETE FROM 'estado' WHERE estado='" + nombre + "'";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conexion.cerrar(conn);

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Map<String, estado> CargarEstados() {
        try {
            String sql = "SELECT * FROM cultuRarte.estado";
            Map<String, estado> lista = new HashMap<String, estado>();
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String codigo = rs.getString("estado");
                estado e = new estado(codigo);
                lista.put(codigo, e);
            }
            conexion.cerrar(conn);
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void agregarEstadosPropuestas(dtEstadosPropuestas dtep) {
        try {
            String sql = null;
            sql = "INSERT INTO `estadoPropuesta`(`propuesta`, `estado`, `fecha`, `hora`) VALUES ('" + dtep.getTituloprop() + "','" + dtep.getEstado() + "','" + dtep.getFecha().getFecha() + "','" + dtep.getHora().getHora() + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            conexion.cerrar(conn);

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public static List<dtEstadosPropuestas> CargarEstadosPropuestas() {
        try {
            List<dtEstadosPropuestas> list = new ArrayList<>();
            String sql = null;
            sql = "SELECT * FROM estadoPropuesta";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String[] f = rs.getString("fecha").split("/");
                dtFecha dtf = new dtFecha(f[0], f[1], f[2]);
                String[] h = rs.getString("hora").split(":");
                dtHora dth = new dtHora(Integer.parseInt(h[0]), Integer.parseInt(h[1]));

                dtEstadosPropuestas dt = new dtEstadosPropuestas(rs.getString(1), rs.getString(2), dtf, dth);
            }
            conexion.cerrar(conn);
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
