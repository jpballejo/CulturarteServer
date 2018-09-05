/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtCategoria;
import Logica.dtColaboraciones;
import Logica.dtColaborador;
import Logica.dtEstado;
import Logica.dtEstadosPropuestas;
import Logica.dtFecha;
import Logica.dtProponente;
import Logica.dtPropuestasBD;
import Logica.dtUsuario;
import static Persistencia.categoriaPersistencia.conexion;
import static Persistencia.estadoPersistencia.conexion;
import static Persistencia.propuestasPersistencia.conexion;
import static Persistencia.usuariosPersistencia.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nicolasgutierrez
 */
public class BDCulturarte {

    static ConexionDB conexion = new ConexionDB();

    public dtFecha construirFecha(String fecha) {
        String[] splited = fecha.split("/");
        dtFecha fec = new dtFecha(splited[0], splited[1], splited[2]);
        return fec;
    }

    public void levantaUsusOrigin(ArrayList<String> usus) {
        String sql = null;
        Connection conn = conexion.getConexion();

        try {
            sql = "SELECT * FROM cultuRarte.usuPer";
            Statement stusu = conn.createStatement();
            ResultSet rsusu = stusu.executeQuery(sql);
            while (rsusu.next()) {
                String nomUsu = rsusu.getString(1);
                if (nomUsu.isEmpty() != true) {
                    usus.add(nomUsu);
                }

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public void levantarPropuestasOrigin(ArrayList<String> prop) {
        String sql = null;
        try {
            Connection conn = conexion.getConexion();
            sql = "SELECT * FROM cultuRarte.propPer";
            Statement st = conn.createStatement();
            ResultSet rsprop = st.executeQuery(sql);
            while (rsprop.next()) {
                prop.add(rsprop.getString(1));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void levantarColaboracionesOrigin(ArrayList<dtColaboraciones> dtcol) {
        String sql = null;
        try {
            Connection conn = conexion.getConexion();
            sql = "SELECT * FROM cultuRarte.colPersitencia";
            Statement st = conn.createStatement();
            ResultSet rsCol = st.executeQuery(sql);
            while (rsCol.next()) {
                dtFecha fecha = construirFecha(rsCol.getString(3));
                dtColaboraciones dtcola = new dtColaboraciones(rsCol.getString(1), rsCol.getString(2), fecha);
                dtcol.add(dtcola);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void levantarEstadosOrigin(ArrayList<dtEstadosPropuestas> estadosProp) {
        String sql = null;
        try {
            Connection conn = conexion.getConexion();
            sql = "SELECT * FROM cultuRarte.propEstPer";
            Statement st = conn.createStatement();
            ResultSet rsEstado = st.executeQuery(sql);
            while (rsEstado.next()) {
                dtFecha fecha = construirFecha(rsEstado.getString(3));
                String propid = rsEstado.getString(1);
                String estado = rsEstado.getString(2);
                dtEstadosPropuestas nuevo = new dtEstadosPropuestas(propid, estado, fecha, null);

                estadosProp.add(nuevo);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage()
            );

        }

    }

    public boolean cargarUsusOrigin(dtUsuario usuOrigen) {
        return true;
    }

    public boolean cargarPropuestasOrigin(dtPropuestasBD prop) {
        return true;
    }

    public void altaUsuario(dtUsuario dtUsu) throws Exception {
        try {
            String sqlUsu = null, sqlProp = null, sqlCol = null;
            Connection con = conexion.getConexion();
            Statement st = (Statement) con.createStatement();
            if (dtUsu instanceof dtProponente) {
                dtProponente dtProp = (dtProponente) dtUsu;
                sqlUsu = "INSERT INTO `usuario`(`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`)VALUES('" + dtProp.getNickname() + "','" + dtProp.getNombre() + "','" + dtProp.getApellido() + "','" + dtProp.getEmail() + "','" + dtProp.getFechaNac().getFecha() + "','" + dtProp.getImagen() + "')";
                sqlProp = "INSERT INTO `Proponente` (`id_usuario`,`direccion`,`pag_web`,`biografia`) VALUES ('" + dtProp.getNickname() + "','" + dtProp.getDireccion() + "','" + dtProp.getSitioWeb() + "','" + dtProp.getBiografia() + "')";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlProp);

            }

            if (dtUsu instanceof dtColaborador) {
                dtColaborador dtCol = (dtColaborador) dtUsu;
                sqlUsu = "INSERT INTO `usuario`(`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`)VALUES('" + dtCol.getNickname() + "','" + dtCol.getNombre() + "','" + dtCol.getApellido() + "','" + dtCol.getEmail() + "','" + dtCol.getFechaNac().getFecha() + "','" + dtCol.getImagen() + "')";
                sqlCol = "INSERT INTO colaborador (`idUsuario`) VALUES ('" + dtCol.getNickname() + "')";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlCol);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            // throw new Exception("Error al insertar los datos en la BD");

        }

    }

    public boolean agregarEstadoCD(dtEstado esta) {
        try {
            String sql = "INSERT INTO `cultuRarte`.`estado` (`estado`,`numero`)VALUES('" + esta.getNombre() + "'," + esta.getNumero() + ")";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            //conexion.cerrar(conn);

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean altaPropuestaCD(dtPropuestasBD dtp) {
        try {
            String sql = null;
            sql = "INSERT INTO `Propuesta`(`titulo`, `descripcion`, `imagen`, `lugar`, `fecha`, `precio_entrada`, `monto_necesario`, `fecha_publicacion`, `proponente`, `categoria`, `retorno`)"
                    + " VALUES ('" + dtp.getTitulo() + "','" + dtp.getDescripcion() + "','" + dtp.getImagen() + "','" + dtp.getLugar() + "','" + dtp.getFecha().getFecha() + "','" + Integer.toString(dtp.getPrecio_entrada()) + "','" + Integer.toString(dtp.getMonto_necesario()) + "','" + dtp.getFecha_publicacion().getFecha() + "','" + dtp.getNickproponente() + "," + dtp.getCategoria() + "','" + dtp.getRetorno() + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            return true;
            //   conexion.cerrar(conn);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

        return false;
    }
    public boolean altaCategoriaCD(dtCategoria cat) {
        try {
            String sql = null;
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            if (!cat.getPadre().isEmpty()) {
                sql = "INSERT INTO `cultuRarte`.`Categoria`(`nombre`,`padre`)VALUES ('" + cat.getNombre() + "','" + cat.getPadre() + "')";
                st.executeUpdate(sql);
            }
            if (cat.getPadre().isEmpty()) {
                sql = "INSERT INTO `cultuRarte`.`Categoria`(`nombre`)VALUES('" + cat.getNombre() + "')";
                st.executeUpdate(sql);
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

    }
}
