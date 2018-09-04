/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author apias
 */
public class ConexionDB {
    private  final String host="192.168.64.2";
    private  final String port="3306";
    private  final String db="cultuRarte";
    private  final String user="administrador";
    private  final String pass="1234";
    private static Connection conexion=null;
    private Connection con = null;



    
//    public Connection getConn(){
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return con;
//    }
    
    public static Connection getConexionConfigurada(String h, String p, String db, String u, String pas) {
        if (conexion == null) {
            try {              
                                
                conexion = DriverManager.getConnection("jdbc:mysql://"+h+":"+p+"/"+db, u, pas);
                } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    
    
    public Connection getConexion() {
        if (conexion == null) {
            try {              
                                
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
                } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    public void closeConn(Connection con){
        if(con!=null){
                try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    }

    public static void cerrar(Connection conexion){

        if (conexion != null) {

            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    
    
}
