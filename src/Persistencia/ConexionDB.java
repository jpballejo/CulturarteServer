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
    private String host="localhost";
    private String port="3306";
    private String db="cultuRarte";
    private String user="admin";
    private String pass="pao2930";
    
    public void setHost(String h){
        this.host=h;
    }
    
    public void setPort(String p){
        this.port=p;
    }
    
    public void setDB(String db){
        this.db=db;
    }
    
    public void setUser(String u){
        this.user=u;
    }
        
    public void setPass(String pas){
        this.pass=pas;
    }
        
    
    //Para hacer ConexionDB singleton descomentar
    //private static Connection conexion=null;
    private Connection conexion=null;
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
    
    public void cerrar(){
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
