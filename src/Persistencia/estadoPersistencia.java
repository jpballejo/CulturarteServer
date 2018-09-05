/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.ContCargaBD;
import Logica.dtEstado;
import Logica.dtEstadosPropuestas;
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
public class estadoPersistencia {

    static ConexionDB conexion = new ConexionDB();
//    ContCargaBD contCarga = ContCargaBD.getInstance();

    private ArrayList<dtEstadosPropuestas> estados = new ArrayList<>();

    public static boolean agregarestado(String nombre) {
        try {
            String sql = "INSERT INTO `cultuRarte`.'estado' ('estado') VALUES ('" + nombre + "')";
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
            String sql = "DELETE FROM `cultuRarte`.'estado' WHERE estado='" + nombre + "'";
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

    public void CargarEstados(ArrayList<dtEstado> nomEstados) {
        try {
            String sql = "SELECT * FROM cultuRarte.estado";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                dtEstado esta = new dtEstado(rs.getInt(2), rs.getString(1));
                nomEstados.add(esta);
            }
            //   conexion.cerrar(conn);
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
    }

    public static void agregarEstadosPropuestas(dtEstadosPropuestas dtep) {
        try {
            String sql = null;
            sql = "INSERT INTO `cultuRarte`.`estadoPropuesta`(`propuesta`,`estado`,`fecha`,`hora`)VALUES('" + dtep.getTituloprop() + "','" + dtep.getEstado() + "','" + dtep.getFecha().getFecha() + "','" + dtep.getHora().getHora() + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            //     conexion.cerrar(conn);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

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

    private void setearEstadoPropuesta(dtEstadosPropuestas dt) {
        estados.add(dt);

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
                System.out.println(rs.getString(1) + " " + rs.getString(4));
                dtHora dth = construirHora(rs.getString(4));
                dtEstadosPropuestas dt = new dtEstadosPropuestas(rs.getString(1), rs.getString(2), dtf, dth);
                setearEstadoPropuesta(dt);
                estados.add(dt);
            }
            //      conexion.cerrar(conn);

        } catch (SQLException ex) {
            System.err.print(ex.getMessage());

        }
    }

    /**
     * @return the estados
     */
    public ArrayList<dtEstadosPropuestas> getEstados() {
        return estados;
    }
}
