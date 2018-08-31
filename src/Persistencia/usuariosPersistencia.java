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
            Connection con= conexion.getConn();
            Statement st= (Statement)con.createStatement();
        
            if (dtUsu instanceof dtProponente){
                dtProponente dtProp = (dtProponente)dtUsu;
                sqlUsu = "INSERT INTO `usuario`(`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`)VALUES('"+dtProp.getNickname()+"','"+dtProp.getNombre()+"','"+dtProp.getApellido()+"','"+dtProp.getEmail()+"','"+dtProp.getFechaNac().getFecha()+"','"+dtProp.getImagen()+"')";
                sqlProp ="INSERT INTO `Proponente` (`id_usuario`,`direccion`,`pag_web`,`biografia`) VALUES ('"+dtProp.getNickname()+"','"+dtProp.getDireccion()+"','"+dtProp.getSitioWeb()+"','"+dtProp.getBiografia()+"')";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlProp);
                con.close();
            }
            
            
            if(dtUsu instanceof dtColaborador){
                dtColaborador dtCol = (dtColaborador)dtUsu;
                
                sqlUsu = "INSERT INTO `usuario`(`idUsuario`, `nombre`, `apellido`, `email`, `fechaNacimiento`, `imagen`)VALUES('"+dtCol.getNickname()+"','"+dtCol.getNombre()+"','"+dtCol.getApellido()+"','"+dtCol.getEmail()+"','"+dtCol.getFechaNac().getFecha()+"','"+dtCol.getImagen()+"')";
                sqlCol="INSERT INTO colaborador (`idUsuario`) VALUES ('"+dtCol.getNickname()+"')";
                st.executeUpdate(sqlUsu);
                st.executeUpdate(sqlCol);
                conexion.getConn().close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           // throw new Exception("Error al insertar los datos en la BD");
            
        }
    
    }
    
    public static Map<String, proponente> CargarProponentes(){
                try {
            String sqlproponentes=null, sqlusuarios=null;
            dtFecha dtf=new dtFecha("1","1","2000");
            Connection conn;
                    conn = conexion.getConexion();
            Map<String, proponente> lista=new HashMap<String, proponente>();
            Map<String, proponente> listaproponentes=new HashMap<String, proponente>();
            Map<String, usuario> listausuarios=new HashMap<String, usuario>();
            Statement st1 = conn.createStatement();  
            sqlproponentes=("SELECT * FROM 'Proponente'"); 
            ResultSet rs=st1.executeQuery(sqlproponentes);
            while (rs.next()){
                String codigo=rs.getString("id_usuario");
                proponente p=new proponente(codigo,"","","","",dtf,rs.getString("direccion"),rs.getString("biografia"),rs.getString("par_web"));
                listaproponentes.put(codigo, p);
            }
            
           
            
            Statement st2 = conexion.getConn().createStatement();  
            sqlusuarios=("SELECT * FROM 'usuario'"); 
            ResultSet rs2=st2.executeQuery(sqlusuarios);
            while (rs2.next()){
                String codigo=rs2.getString("idUsuario");
                String[] splited=rs2.getString("fechaNacimiento").split("/");                
                dtFecha dtf2=new dtFecha(splited[0],splited[1],splited[2]);
                usuario u=new usuario(codigo,rs2.getString("nombre"),rs2.getString("apellido"),rs2.getString("email"),rs2.getString("imagen"),dtf2);
                listausuarios.put(codigo, u);
            }
            
            
            
            for(String key : listaproponentes.keySet()){
                proponente aux=(proponente)listaproponentes.get(key);
                usuario uaux=(usuario)listausuarios.get(key);
                aux.setNombre(uaux.getNombre());
                aux.setApellido(uaux.getApellido());
                aux.setEmail(uaux.getEmail());
                aux.setImagen(uaux.getImagen());
                aux.setNacimiento(uaux.getNacimiento());
                
                lista.put(key, aux);
            }
            
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }  
    }
    
    
   public static Map<String, colaborador> CargarColaboradores(){
                try {
            String sqlproponentes=null, sqlusuarios=null;
            dtFecha dtf=new dtFecha("1","1","2000");
            Map<String, colaborador> lista=new HashMap<String, colaborador>();
            Map<String, colaborador> listacolaboradores=new HashMap<String, colaborador>();
            Map<String, usuario> listausuarios=new HashMap<String, usuario>();
            Statement st = conexion.getConn().createStatement();  
            sqlproponentes=("SELECT * FROM 'colaborador'"); 
            ResultSet rs=st.executeQuery(sqlproponentes);
            while (rs.next()){
                String codigo=rs.getString("idUsuario");
                colaborador p=new colaborador(codigo,"","","","",dtf);
                listacolaboradores.put(codigo, p);
            }
            rs.close();
            st.close();
            
            Statement st2 = conexion.getConn().createStatement();  
            sqlusuarios=("SELECT * FROM 'usuario'"); 
            ResultSet rs2=st2.executeQuery(sqlusuarios);
            while (rs2.next()){
                String codigo=rs2.getString("idUsuario");
                String[] splited=rs2.getString("fechaNacimiento").split("/");                
                dtFecha dtf2=new dtFecha(splited[0],splited[1],splited[2]);
                usuario u=new usuario(codigo,rs2.getString("nombre"),rs2.getString("apellido"),rs2.getString("email"),rs2.getString("imagen"),dtf2);
                listausuarios.put(codigo, u);
            }
            rs.close();
            st.close();
            
            for(String key : listacolaboradores.keySet()){
                colaborador aux=(colaborador)listacolaboradores.get(key);
                usuario uaux=(usuario)listausuarios.get(key);
                aux.setNombre(uaux.getNombre());
                aux.setApellido(uaux.getApellido());
                aux.setEmail(uaux.getEmail());
                aux.setImagen(uaux.getImagen());
                aux.setNacimiento(uaux.getNacimiento());
                
                lista.put(key, aux);
            }
            
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }  
    }    
    
    
}
