/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author apias
 */
public class ConexionDB {
    private static String host;
    private static String port;
    private static String db;
    private static String user;
    private static String pass;
    
   
    //Para hacer ConexionDB singleton descomentar
    //private static Connection conexion=null;
    private static Connection conexion=null;
    //Para hacer ConexionDB singleton descomentar
    //private ConexionDB(){};
    public ConexionDB(){};
    
    //Para hacer ConexionDB singleton descomentar
    //public static Connection getConexion() {
    public Connection getConn(){
        Connection con=null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
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
    
    public static void cerrar(){
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
