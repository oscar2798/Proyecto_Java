/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.softura.proyectojava.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.softura.proyectojava.Principal;
import mx.com.softura.proyectojava.interfaces.IOperacionesAlumno;
import mx.com.softura.proyectojava.negocio.dao.OperacionesPersonasDAO;
import mx.com.softura.proyectojava.to.Alumno;
import mx.com.softura.proyectojava.to.Persona;

/**
 *
 * @author Froevel
 */
public class OperacionesAlumnoBusiness implements IOperacionesAlumno{
    
    @Override
    public void listaAlumnos() {
        Alumno alumno1 = new Alumno();
        
        alumno1.setNombre("Oscar");
        alumno1.setLicenciatura("Ingenieria");
        alumno1.setMatricula("2022OEG");
        
        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Cristian");
        alumno2.setLicenciatura("Derecho");
        alumno2.setMatricula("2022CAH");
        
        Alumno alumno3 = new Alumno();
        alumno3.setNombre("Oliver");
        alumno3.setLicenciatura("Lenguas");
        alumno3.setMatricula("2022OMM");
        
        Alumno alumno4 = new Alumno();
        alumno4.setNombre("Rafael");
        alumno4.setLicenciatura("Turismo");
        alumno4.setMatricula("2022RHH");
        
        Alumno alumno5 = new Alumno();
        alumno5.setNombre("Oliversssss");
        alumno5.setLicenciatura("Lenguas");
        alumno5.setMatricula("2022OMM");
        
        Set<Alumno> alumnos = new HashSet<>();
        
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        alumnos.add(alumno4);
        
        alumnos.forEach(t -> System.out.println("Nombre: " + t.getNombre()+
                "," + " Matricula: " + t.getMatricula()));
    }


    @Override
    public void obtenerNombre(String matricula) {
        System.out.println("Obtener nombre...");
    }

    @Override
    public int obtenerPromedio(String matricula) {
        return 10;
    }

    @Override
    public int obtenerSemestre(String matricula) {
        return 5;
    }

    @Override
    public int numeroInscritos() {
        int i = 0;
        i++;
        return i;
    }
    
   
    public void obtenerPersonasNegocio(){
    
        OperacionesPersonasDAO o = new OperacionesPersonasDAO();
        o.obtenerPersonas();
    }
    
    public void actualizarPersonaNegocio(int id, String curp){
            OperacionesPersonasDAO o = new OperacionesPersonasDAO();
            o.actualizarPersona(id, curp);
    }
    
    public void insertarPersona(Persona persona){
        
        persona.setCurp("-"+persona.getCurp());
        
         OperacionesPersonasDAO o = new OperacionesPersonasDAO();
            o.insertarPersona(persona);
    }
    
    
    public void listaProgramaEducativo(String programa){
        
        Map<String, Integer> treeMap = new TreeMap<>();
         treeMap.put("Maria",2);
         treeMap.put("Jose",5);
         treeMap.put("Armando",4);
         treeMap.put("Maria",4);
         System.out.println(treeMap);
    }
    
    
    //************************ METODOS ALUMNOS *************************//
    
    public void listByPrograma(String programa){
      OperacionesPersonasDAO o = new OperacionesPersonasDAO();
            o.listarByPrograma(programa);      
    }
    
    public void obtenerAlumnos(){
        OperacionesPersonasDAO o = new OperacionesPersonasDAO();
        o.obtenerAlumnos();
    }
    
    public void insertarAlumno(Persona persona, Alumno alumno){
        OperacionesPersonasDAO o = new OperacionesPersonasDAO();
        o.insertarAlumno(persona, alumno);
    }
    
    public void actualizarAlumno(int id, Persona p, Alumno a){
        OperacionesPersonasDAO o = new OperacionesPersonasDAO();
            o.actualizarAlumno(id, p, a);
    }
    
    public void eliminarAlumno(String curp){
            OperacionesPersonasDAO o = new OperacionesPersonasDAO();
            o.eliminarAlumno(curp);
    }
    
    /*public void insertarAlumno(String nombreTabla, Object[] datos){
          
         OperacionesPersonasDAO o = new OperacionesPersonasDAO();
            o.insertarAlumno(nombreTabla,datos);
    }^*/
}
