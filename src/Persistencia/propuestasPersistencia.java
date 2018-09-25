/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtFecha;
import Logica.dtPropuestasBD;
import Logica.utilidades;
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
utilidades util = new utilidades();
    public static void altaPropuesta(dtPropuestasBD dtp) throws SQLException {
        try {
            String sql = null;
            sql = "INSERT INTO `cultuRarte`.`Propuesta`(`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`)"
                    + " VALUES ('" + dtp.getTitulo() + "','" + dtp.getDescripcion() + "','" + dtp.getImagen() + "','" + dtp.getLugar() + "','" + dtp.getFecha().getFecha() + "','" + Integer.toString(dtp.getPrecio_entrada()) + "','" + Integer.toString(dtp.getMonto_necesario()) + "','" + dtp.getFecha_publicacion().getFecha() + "','" + dtp.getNickproponente() + "','" + dtp.getCategoria() + "','" + dtp.getRetorno() + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            System.out.println(sql);
            st.executeUpdate(sql);
            //   conexion.cerrar(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }
    
    

  

    public void cargarPropuestas(ArrayList<dtPropuestasBD> propuestas) {
        try {
            String sql = "SELECT * FROM cultuRarte.Propuesta";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String imagen = rs.getString(3);
                dtFecha dtf = (dtFecha)util.construirFecha(rs.getString(5));
                dtFecha dtfp = (dtFecha)util.construirFecha(rs.getString(8));
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

    public static Map<String, String> cargarPropuestasNOBorrar() {
        Map<String,String> retorno=new HashMap<>();
        try {
            String sql = null;
            Connection con = conexion.getConexion();
            Statement st = (Statement) con.createStatement();         
            sql="SELECT * FROM `cultuRarte`.`propPer`";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String nick = rs.getString(1); 
                retorno.put(nick, nick);
            } 
            
            return retorno;
            
            
            
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
            return null;
        }         
    }
    
    public static void actualizarPropuesta(dtPropuestasBD dtp) throws SQLException {
        try {
            String sql = null;
            sql = "UPDATE `cultuRarte`.`Propuesta` SET `descripcion`='"+dtp.getDescripcion()+"', `imagen`='"+dtp.getImagen()+"', `lugar`='"+dtp.getLugar()+"', `fecha`='"+dtp.getFecha().getFecha()+"', `precio_entrada`='"+Integer.toString(dtp.getPrecio_entrada())+"', `monto_necesario`='"+Integer.toString(dtp.getMonto_necesario())+"', `fecha_publicacion`='"+dtp.getFecha_publicacion().getFecha()+"', `proponente`='"+dtp.getNickproponente()+"', `categoria`='"+dtp.getCategoria()+"', `retorno`='"+dtp.getRetorno()+"' WHERE `titulo`='"+dtp.getTitulo()+"'";
                    
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            System.out.println(sql);
            st.executeUpdate(sql);
            //   conexion.cerrar(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

}
