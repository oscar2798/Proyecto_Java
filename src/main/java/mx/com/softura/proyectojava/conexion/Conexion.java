/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.softura.proyectojava.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Froevel
 */
public class Conexion {
    
    public static final String URL = "jdbc:mysql://localhost:3306/curso?zeroDateTimeBehavior=CONVERT_TO_NULL";
    public static final String USUARIO = "root";
    public static final String CLAVE = "";
    
    public Connection getConexion(){
    
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL,USUARIO, CLAVE);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar:"+ ex.getMessage());
        } catch (SQLException ee){
            System.out.println("Error al conectar:"+ ee.getMessage());
        }
        return con;
        
    }
    
    
}
