/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.softura.proyectojava.negocio.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.softura.proyectojava.conexion.Conexion;
import mx.com.softura.proyectojava.to.Alumno;
import mx.com.softura.proyectojava.to.Persona;

/**
 *
 * @author Froevel
 */
public class OperacionesPersonasDAO {

    Conexion con = new Conexion();

    public void obtenerPersonas() {
        //System.out.println(con.getConexion());
        try {
            Statement stmt = con.getConexion().createStatement();
            String query = "select id, nombre, curp from personas";
            ResultSet rset = stmt.executeQuery(query);
            int cuanto = 0;

            while (rset.next()) {
                Integer id = rset.getInt("id");
                String curp = rset.getString("curp");
                String nombre = rset.getString("nombre");
                cuanto++;

                System.out.println("ID:" + id + " - " + nombre + "  -  CURP: " + curp);

            }
            System.out.println("TOTAL DE REGISTROS:" + cuanto);

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesPersonasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarPersona(int id, String curp) {
        con.getConexion();

        try {
            Statement stmt = con.getConexion().createStatement();
            String query = "update personas set curp = \'" + curp + "\' where id= " + id;
            int resultado = stmt.executeUpdate(query);

        } catch (SQLException ee) {
            ee.printStackTrace();
        }

    }

    public void insertarPersona(Persona persona) {

        try {
            String query = "insert into personas (nombre,primerapellido,segundoapellido,curp) values (?,?,?,?)";

            PreparedStatement stmt = con.getConexion().prepareStatement(query);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getPrimerApellido());
            stmt.setString(3, persona.getSegundoApellido());
            stmt.setString(4, persona.getCurp());
            stmt.execute();

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public void listarByPrograma(String programa) {
        System.out.println("[---------- Lista por programa educativo ----------]\n");

       // Map<String, Alumno> map = new HashMap<String, Alumno>();
       
        try {
            Statement stmt = con.getConexion().createStatement();
            String query = "SELECT programa, personas.nombre FROM alumnos INNER JOIN personas " + 
                    "ON alumnos.id_persona = personas.id WHERE programa = '"+programa+"'";
            ResultSet rset = stmt.executeQuery(query);
            int cuanto = 0;

            while (rset.next()) {
                String p = rset.getString("programa");
                String nombre = rset.getString("personas.nombre");
                cuanto++;
                System.out.println("NOMBRE DEL ALUMNO: "+ nombre +"  - POGRAMA EDUCATIVO: " + p + "\n");
            }
            
            System.out.println("TOTAL DE REGISTROS POR PROGRAMA:" + cuanto +"\n");

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesPersonasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //*********************  PROYECTO METODOS ALUMNOS ********************************//
    
    public void obtenerAlumnos() {
        System.out.println("[---------- Lista de Alumnos ----------]\n");
        try {
            Statement stmt = con.getConexion().createStatement();
            String query = "SELECT alumnos.id, nombre, curp, matricula, licenciatura, "
                    + "programa FROM alumnos, personas WHERE alumnos.id_persona = personas.id;";
            ResultSet rset = stmt.executeQuery(query);
            int cuanto = 0;

            while (rset.next()) {
                Integer id = rset.getInt("alumnos.id");
                String nombre = rset.getString("nombre");
                String curp = rset.getString("curp");
                String matricula = rset.getString("matricula");
                String lic = rset.getString("licenciatura");
                String programa = rset.getString("programa");
                cuanto++;

                System.out.println("ID:" + id + " -  NOMBRE: " + nombre + " -  CURP: " + curp + ""
                        + " -  MATRICULA: " + matricula +" -  LICENCIATURA: " + lic +
                        " -  PROGRAMA: "+ programa +"\n");
            }
            System.out.println("TOTAL DE REGISTROS:" + cuanto);

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesPersonasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertarAlumno(Persona persona, Alumno alumno) {

        int id = 0;
        try {
            String query = "insert into personas (nombre,primerapellido,segundoapellido, "
                    + "curp, ciudadNacimiento) VALUES (?,?,?,?,?)";

            PreparedStatement p = con.getConexion().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            p.setString(1, persona.getNombre());
            p.setString(2, persona.getPrimerApellido());
            p.setString(3, persona.getSegundoApellido());
            p.setString(4, persona.getCurp());
            //p.setString(5, persona.getGenero());
            p.setString(5, persona.getCiudadNacimiento());
            //p.setDate(4, (Date) persona.getFechaNacimiento());
            p.execute();

            ResultSet r = p.getGeneratedKeys();

            if (r.next()) {
                id = r.getInt(1);
            }

            PreparedStatement a = con.getConexion().prepareStatement("insert into alumnos(periodoIngreso, "
                    + "licenciatura, matricula, programa, id_persona) VALUES (?,?,?,?,?)");
            a.setString(1, alumno.getPeriodoIngreso());
            a.setString(2, alumno.getLicenciatura());
            a.setString(3, alumno.getMatricula());
            a.setString(4, alumno.getPrograma());
            a.setInt(5, id);
            a.execute();

            System.out.println("Registros insertados correctamente!!\n");
            //System.out.println("ID GENERADO: " + id);
            return id;

        } catch (SQLException ee) {
            ee.printStackTrace();
            return -1;
        }
    }

    public void actualizarAlumno(int id, Persona p, Alumno a) {
        try {
            String query = "UPDATE personas INNER JOIN alumnos ON alumnos.id_persona = personas.id "
                    + "SET personas.nombre = ?, personas.primerapellido = ?, personas.segundoapellido = ?, "
                    + "personas.curp = ?, personas.ciudadNacimiento = ?, alumnos.periodoIngreso = ?, "
                    + "alumnos.licenciatura = ?, alumnos.matricula = ?, alumnos.programa = ? WHERE personas.id= " + id;
           
            PreparedStatement pre = con.getConexion().prepareStatement(query);
            pre.setString(1, p.getNombre());
            pre.setString(2, p.getPrimerApellido());
            pre.setString(3, p.getSegundoApellido());
            pre.setString(4, p.getCurp());
            //pre.setString(5, persona.getGenero());
            pre.setString(5, p.getCiudadNacimiento());
            //pre.setDate(4, (Date) persona.getFechaNacimiento());
            pre.setString(6, a.getPeriodoIngreso());
            pre.setString(7, a.getLicenciatura());
            pre.setString(8, a.getMatricula());
            pre.setString(9, a.getPrograma());
            
            pre.executeUpdate();
            
            System.out.println("Registros actualizados correctamente!!\n");

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public void eliminarAlumno(String curp) {
        try {
            Statement stmt = con.getConexion().createStatement();
            String query = "delete alumnos from alumnos JOIN mspersonas ON alumnos.id_persona = mspersonas.id where mspersonas.curp=\'" + curp + "\'";
            int resultado = stmt.executeUpdate(query);

            System.out.println("Se elimino correctamente el alumno!!\n");
        } catch (SQLException ee) {
            ee.printStackTrace();
        }

    }

    //------------ METODO 2 DE INSERTAR OPCIONAL -------------------/
    /*public int insertarAlumno(String nombreTabla, Object[] datos){
        int filas = 0;
         try{
             
         String query = "insert into "+nombreTabla+" values ("+"'"+datos[0]+"'";
         
         for(int i=1; i<=datos.length; i++){
             if(i < datos.length){
                 query+=",'"+datos[i]+"'";
             }else{
                 query+=")";
             }
         }
        
            PreparedStatement  stmt = con.getConexion().prepareStatement(query);
            filas = stmt.executeUpdate(query);
            System.out.println("Datos insertados correctamente");
            
        }catch(SQLException ee){
            ee.printStackTrace();
        }
         return filas;
    } */
}
