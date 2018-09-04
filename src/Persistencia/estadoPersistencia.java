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

    static ConexionDB conexion = new ConexionDB();

    public static boolean agregarestado(String nombre) {
        try {
            String sql = "INSERT INTO 'estado' ('estado') VALUES ('" + nombre + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            //conexion.cerrar(conn);

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
            //  conexion.cerrar(conn);

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void CargarEstados(ArrayList<String> estados) {
        try {
            String sql = "SELECT * FROM cultuRarte.estado";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                estados.add(rs.getString(1));
            }
            //   conexion.cerrar(conn);
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
    }

    public static void agregarEstadosPropuestas(dtEstadosPropuestas dtep) {
        try {
            String sql = null;
            sql = "INSERT INTO `estadoPropuesta`(`propuesta`, `estado`, `fecha`, `hora`) VALUES ('" + dtep.getTituloprop() + "','" + dtep.getEstado() + "','" + dtep.getFecha().getFecha() + "','" + dtep.getHora().getHora() + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            //     conexion.cerrar(conn);

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    public dtFecha construirFecha(String fecha) {
        String[] splited = fecha.split("/");
        dtFecha fec = new dtFecha(splited[0], splited[1], splited[2]);
        return fec;
    }

    public dtHora construirHora(String hora) {

        String[] h = hora.split(":");
        dtHora dth = new dtHora(Integer.parseInt(h[0]), Integer.parseInt(h[1]));
        return dth;
    }

    public void CargarEstadosPropuestas(ArrayList<dtEstadosPropuestas> estados) {
        try {
            List<dtEstadosPropuestas> list = new ArrayList<>();
            String sql = null;
            sql = "SELECT * FROM cultuRarte.estadoPropuesta";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dtFecha dtf = construirFecha(rs.getString(3));
                dtHora dth= construirHora(rs.getString(4));
                dtEstadosPropuestas dt = new dtEstadosPropuestas(rs.getString(1), rs.getString(2), dtf, dth);
                estados.add(dt);
            }
            //      conexion.cerrar(conn);

        } catch (SQLException ex) {
            System.err.print(ex.getMessage());

        }
    }
}
