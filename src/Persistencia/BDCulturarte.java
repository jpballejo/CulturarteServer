/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.dtCategoria;
import Logica.dtColaboracionCompleto;
import Logica.dtColaboraciones;
import Logica.dtColaborador;
import Logica.dtEstado;
import Logica.dtEstadosPropuestas;
import Logica.dtFecha;
import Logica.dtHora;
import Logica.dtProponente;
import Logica.dtPropuestasBD;
import Logica.dtSeguidores;
import Logica.dtUsuario;
import static Persistencia.categoriaPersistencia.conexion;
import static Persistencia.colaboracionesPersistencia.conexion;
import static Persistencia.estadoPersistencia.conexion;
import static Persistencia.estadoPropuestaPersistencia.conexion;
import static Persistencia.propuestasPersistencia.conexion;
import static Persistencia.seguirdejardeseguirPersistencia.conexion;
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

    public dtHora construirHora(String hora) {

        String[] h = hora.split(":");
        dtHora dth = new dtHora(Integer.parseInt(h[0]), Integer.parseInt(h[1]));
        return dth;
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
            System.err.println(e.getMessage());

        }

    }

    public void levantarSeguidoresOrigin(ArrayList<dtSeguidores> segiresPer) {
        try {
            Connection conn = conexion.getConexion();
            String sql = "SELECT * FROM cultuRarte.SeguidoresPer";
            Statement st = conn.createStatement();
            ResultSet rsSeg = st.executeQuery(sql);
            while (rsSeg.next()) {
                dtSeguidores dtseg = new dtSeguidores(rsSeg.getString(1), rsSeg.getString(2));
                segiresPer.add(dtseg);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    

    public boolean cargaUsuariosOrigin(String usu) {
        return false;
    }

    public boolean cargaPropuestasOrigin(String prop) {
        return false;
    }

    public boolean cargaEstadoPropuestasOrigin(dtEstadosPropuestas estaprop) {
        return false;
    }

    public boolean cargaSeguidoresOrigin(dtSeguidores sig) {
        return false;
    }

    public boolean cargaColaboracionesOrigin() {
        return false;
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

    public boolean altaColaboracionCD(dtColaboracionCompleto dtcola) {
        try {

            String colaborador = null, titulo = null, fecha = null, hora = null, monto = null, retorno = null;
            colaborador = dtcola.getNickname();
            titulo = dtcola.getTitulo();
            fecha = dtcola.getFecha().getFecha();
            hora = dtcola.getHora().getHora();
            monto = Integer.toString(dtcola.getMonto());
            retorno = dtcola.getRetorno();
            String sql = null;
            sql = "INSERT INTO `cultuRarte`.`Colaboraciones` (`nickusuario`, `tituloprop`, `fecha`, `hora`, `monto`, `retorno`) VALUES ('" + colaborador + "','" + titulo + "','" + fecha + "','" + hora + "','" + monto + "','" + retorno + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            // conexion.cerrar(conn);

            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public boolean agregarPropEstadoCD(dtEstadosPropuestas dtestaprop) {
        try {
            String titulo = null, estado = null, fecha = null, hora = null, sql = null;
            titulo = dtestaprop.getTituloprop();
            estado = dtestaprop.getEstado();
            fecha = dtestaprop.getFecha().getFecha();
            hora = dtestaprop.getHora().getHora();
            sql = "INSERT INTO `cultuRarte`.`estadoPropuesta`(`propuesta`, `estado`, `fecha`, `hora`) VALUES ('" + titulo + "','" + estado + "','" + fecha + "','" + hora + "')";
            Connection conn = conexion.getConexion();
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            //     conexion.cerrar(conn);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean agregarSeguidoresCD(dtSeguidores dts) {
        try {
            Connection conn = conexion.getConexion();
            String sql = "INSERT INTO `cultuRarte`.`Seguidores`(`nickusuario`,`nickaseguir`) VALUES ('" + dts.getNickusuario() + "','" + dts.getNickaseguir() + "')";
            Statement st = conn.createStatement();
            System.out.println(sql);
            st.executeUpdate(sql);

            //   conexion.cerrar(conn);
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
