/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtFecha;
import Logica.dtPropuestasBD;
import Logica.propuesta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nicolasgutierrez
 */
public class propuestasPersistencia {

    static ConexionDB conexion = new ConexionDB();

    public static void altaPropuesta(dtPropuestasBD dtp) throws SQLException {
        try {
            String sql = null;
            sql = "INSERT INTO `Propuesta`(`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`)"
                    + " VALUES ('" + dtp.getTitulo() + "','" + dtp.getDescripcion() + "','" + dtp.getImagen() + "','" + dtp.getLugar() + "','" + dtp.getFecha().getFecha() + "','" + Integer.toString(dtp.getPrecio_entrada()) + "','" + Integer.toString(dtp.getMonto_necesario()) + "','" + dtp.getFecha_publicacion().getFecha() + "','" + dtp.getNickproponente() + "," + dtp.getCategoria() + "','" + dtp.getRetorno() + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            //   conexion.cerrar(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }
    
    

    public dtFecha construirFecha(String fecha) {
        String[] splited = fecha.split("/");
        dtFecha fec = new dtFecha(splited[0], splited[1], splited[2]);
        return fec;
    }

    public void cargarPropuestas(ArrayList<dtPropuestasBD> propuestas) {
        try {
            String sql = "SELECT * FROM cultuRarte.Propuesta";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String imagen = null;
                if (rs.getString(3) != null) {
                    imagen = rs.getString(3);
                }
                dtFecha dtf = construirFecha(rs.getString(5));
                dtFecha dtfp = construirFecha(rs.getString(8));
                int precio=0; int monto=0;
                precio=Integer.parseInt(rs.getString(6));
                monto=Integer.parseInt(rs.getString(7));
                dtPropuestasBD dt = new dtPropuestasBD(rs.getString(1), rs.getString(9), rs.getString(2), imagen, rs.getString(4), rs.getString(10), rs.getString(11), dtf, dtfp,precio,monto);
                propuestas.add(dt);

            }
          

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public static Map<String, propuesta> cargarPropuestasNOBorrar() {
        return null;
    }

}
