/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.colaborador;
import Persistencia.ConexionDB;
import Logica.dtColaborador;
import Logica.dtFecha;
import Logica.dtProponente;
import Logica.dtUsuario;
import Logica.estado;
import Logica.proponente;
import Logica.usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class usuariosPersistencia {
    static ConexionDB conexion = new ConexionDB();

    public void altaUsuario(dtUsuario dtUsu) throws Exception{
        try {
            String sqlUsu=null,sqlProp=null,sqlCol=null;
            Connection con= conexion.getConexion();
            Statement st= (Statement)con.createStatement();
            if (dtUsu instanceof dtProponente){
                dtProponente dtProp = (dtProponente)dtUsu;
                sqlUsu = "INSERT INTO `usuario`(`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`)VALUES('"+dtProp.getNickname()+"','"+dtProp.getNombre()+"','"+dtProp.getApellido()+"','"+dtProp.getEmail()+"','"+dtProp.getFechaNac().getFecha()+"','"+dtProp.getImagen()+"')";
                sqlProp ="INSERT INTO `Proponente` (`id_usuario`,`direccion`,`pag_web`,`biografia`) VALUES ('"+dtProp.getNickname()+"','"+dtProp.getDireccion()+"','"+dtProp.getSitioWeb()+"','"+dtProp.getBiografia()+"')";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlProp);
                conexion.cerrar(con);
            }
            
            
            if(dtUsu instanceof dtColaborador){
                dtColaborador dtCol = (dtColaborador)dtUsu;
                sqlUsu = "INSERT INTO `usuario`(`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`)VALUES('"+dtCol.getNickname()+"','"+dtCol.getNombre()+"','"+dtCol.getApellido()+"','"+dtCol.getEmail()+"','"+dtCol.getFechaNac().getFecha()+"','"+dtCol.getImagen()+"')";
                sqlCol="INSERT INTO colaborador (`idUsuario`) VALUES ('"+dtCol.getNickname()+"')";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlCol);
                conexion.cerrar(con);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           // throw new Exception("Error al insertar los datos en la BD");
            
        }
    
    }
    
    public ArrayList<dtUsuario>cargaUsuarios(){
        //conexion y arreglo de usuarios
           ArrayList<dtUsuario> usuarios = new ArrayList<dtUsuario>();
          
          
          
           
           armarProponentes(usuarios);
           armarColaboradores(usuarios);
    
    return usuarios;
    }
    /* while (rs2.next()){
                String codigo=rs2.getString("idUsuario");
                String[] splited=rs2.getString("fechaNacimiento").split("/");                
                dtFecha dtf2=new dtFecha(splited[0],splited[1],splited[2]);*/
    public dtFecha construirFecha(String fecha){
        String [] splited = fecha.split("/");
        dtFecha fec =new dtFecha(splited[0], splited[1], splited[2]);
        return fec;
    }
    
    public void armarProponentes(ArrayList<dtUsuario> usuarios){
        Connection conn = conexion.getConexion();
        String sqlUsu = "SELECT * FROM cultuRarte.usuario";
        String sqlProp = "SELECT * FROM cultuRarte.Proponente";
        try {
           Statement stUsu= (Statement)conn.createStatement();
           Statement stprop= (Statement)conn.createStatement();
           ResultSet usu= stUsu.executeQuery(sqlUsu);
           ResultSet prop=stprop.executeQuery(sqlProp);
            int seguir=0;
            while(prop.next()){
                seguir=0;
                while(usu.next() && seguir==0){
                    if(prop.getString(1).equals(usu.getString(1))==true){
                    dtProponente dtProp = new dtProponente(usu.getString(2), usu.getString(3), usu.getString(3),usu.getString(6), usu.getString(4), construirFecha(usu.getString(5)), prop.getString(2), prop.getString(3), prop.getString(4));
                    usuarios.add(dtProp);
                    usu.beforeFirst();
                    seguir=1;
                }
              
                }
                
            } 
        conexion.cerrar(conn);
        } catch (SQLException ex) {
              System.err.println(ex.getMessage());
        }
    
    }
    public void armarColaboradores(ArrayList<dtUsuario> usuarios){
        Connection conn = conexion.getConexion();
        String sqlCol = "SELECT * FROM cultuRarte.colaborador";
        String sqlUsu = "SELECT * FROM cultuRarte.usuario";
        try {
            int seguir=0;
            Statement stUsu= (Statement) conn.createStatement();
            Statement stcol= (Statement)conn.createStatement();
            ResultSet usu= stUsu.executeQuery(sqlUsu);
            ResultSet col= stcol.executeQuery(sqlCol);
            while(col.next()){
                seguir=0;
            while(usu.next()&&seguir==0){
                if(col.getString(1).equals(usu.getString(1))){
                dtColaborador dtCol = new dtColaborador(usu.getString(2), usu.getString(3), usu.getString(3),usu.getString(6), usu.getString(4), construirFecha(usu.getString(5)));
                usuarios.add(dtCol);
                seguir=1;
                usu.beforeFirst();
                }
                
            }}
            conexion.cerrar(conn);
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
    
    } 
            
            
    public static Map<String, usuario> usuariosANoBorrar(){
        return null;
    }
    
    
}