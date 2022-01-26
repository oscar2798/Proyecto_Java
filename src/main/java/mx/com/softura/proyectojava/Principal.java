/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.softura.proyectojava;

import exepcionespropias.ClaseLanzaExcepcion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import static jdk.internal.joptsimple.internal.Messages.message;
import mx.com.softura.proyectojava.enums.Genero;
import mx.com.softura.proyectojava.genericos.Funciones;
import mx.com.softura.proyectojava.interfaces.IFuncionalOperacionesGenerales;
import mx.com.softura.proyectojava.negocio.OperacionesAlumnoBusiness;
import mx.com.softura.proyectojava.to.Alumno;
import mx.com.softura.proyectojava.to.Persona;


/**
 *
 * @author Froevel
 */
public class Principal {
    
    
    
     public static void main(String[] args) {         
      
       // TODO code application logic here
        /*
         System.out.println("Hola mundo");
         Alumno nuevoAlumno = new Alumno();
         nuevoAlumno.setNombre("froevel");
         
         IFuncionalOperacionesGenerales oga = new IFuncionalOperacionesGenerales() {
             @Override
             public String saludarA(String curp, int edad) {
                 //System.out.println("Hola alumno:"+curp);
                 String curpRegreso = curp+"-";
                 curpRegreso = curpRegreso + "+"+ edad;
                 return "hola alumno: "+curpRegreso;
             }
         };
         
         String saludo = oga.saludarA("MOLF",10);
         System.out.println(saludo);
         
         
         IFuncionalOperacionesGenerales ogd = (curp,edad) -> {
                 String curpRegreso = curp+"-";
                 curpRegreso = curpRegreso + "+"+edad;
                 return "hola docente: "+curpRegreso;
         };
         
         String saludoD = ogd.saludarA("FML",20);
         System.out.println(saludoD);
         
         /*
         System.out.println("GENERICOS");
         
         Funciones<String,String> f1 = new Funciones<>("Froevel");
         f1.junta(" MONTIEL");
         
         
         Funciones<Integer,Integer> f2 = new Funciones<>(1);
         f2.junta(6);
         
         Funciones<Integer,String> f3 = new Funciones<>(1);
         f3.junta(" hola");
         *
        
        
         IFuncionalRoles r = rol -> "ROL: " + rol;
         
         
         String addRol = r.Rol("ROLE_ADMIN");
         System.out.println(addRol);
         
 /*************************************************************************************
    System.out.println("TAREA DE ALUMNOS CON FORECH\n");
    OperacionesAlumnoBusiness alumnos = new OperacionesAlumnoBusiness();
         alumnos.listaAlumnos();
  */
         
//**************************** PROYECTO CON BASE DE DATOS ******************************
        System.out.println("\n");
        System.out.println("PROYECTO BASE DE DATOS ALUMNOS\n");
        
        OperacionesAlumnoBusiness oab = new OperacionesAlumnoBusiness();
        
        
        oab.listByPrograma("Java");
        
     //---- Insertar registro alumno y persona ----/
        
       /* Persona persona = new Persona("Diego", "Garcia", "Portillo", "DGP20", "Puebla");
        Alumno alumno = new Alumno("2022", "Ingenieria", "2022DGP", "Kotlin");
        oab.insertarAlumno(persona, alumno);
        
    /* METODO 2 DE INSERTAR (OPCIONAL):
         Object[] datosPersona =  new Object[5];
         datosPersona[0]=5;
         datosPersona[1]="Brandon";
         datosPersona[2]="Lee";
         datosPersona[3]="Olvera";
         datosPersona[4]="BRANDB";
         oab.insertarAlumno("mspersonas",datosPersona);
         
         Object[] datosAlumno =  new Object[5];
         datosAlumno[0]=5;
         datosAlumno[1]="2022";
         datosAlumno[2]="Derecho";
         datosAlumno[3]="5BRANDS";
         datosAlumno[4]=5;
         oab.insertarAlumno("alumnos",datosAlumno); */
    
    
     // ------- Actualizar Alumno -------- //
      /*  Persona persona = new Persona("Juan", "Hernandez", "Perez", "JHP27", "Tlaxcala");
        Alumno alumno = new Alumno("2022", "Ingenieria", "2022AGH", "Java y Spring");
        oab.actualizarAlumno(1, persona, alumno);
     */
           
     // ---- Eliminar alumno por curp ---- //
        
        //oab.eliminarAlumno("RAFAFA");
        
    // ---- Listar todos los alumnos ---- //
          oab.obtenerAlumnos();
        
        
 
 /*************************************************************************************
         System.out.println("COLECCIONES");
         
         HashSet<String> lista = new HashSet();
         lista.add("Juan");
         lista.add("Adrian");
         lista.add("Juan");
                 
         System.out.println(lista); */
        
/*******************************************************************************************
         Set<Persona> listaPersona = new HashSet<>();
         Persona per1 = new Persona();
         per1.setNombre("Juan");
         per1.setCurp("JuanCURP");
         
         
         Persona per2 = new Persona();
         per2.setNombre("Adrian");
         per2.setCurp("AdrianCURP");
         
         
         Persona per3 = new Persona();
         per3.setNombre("Juan");
         per3.setCurp("JuanCURP");
         
         
         listaPersona.add(per1);
         listaPersona.add(per2);
         listaPersona.add(per3);
         
         System.out.println(per1.hashCode());
         System.out.println(per2.hashCode());
         System.out.println(per3.hashCode());
         
         System.out.println(listaPersona);
         

/***************************************************************************************       
         ArrayList<String> listaNombres = new ArrayList<>();
         listaNombres.add("hola");
         listaNombres.add("Maria");
         listaNombres.add("Adrian");
         listaNombres.add("Sonia");
         listaNombres.add("Gabriel");
         listaNombres.add("Adrian");
         listaNombres.add("Adrian");
         listaNombres.add(null);
         
         System.out.println(listaNombres);
         
         System.out.println(listaNombres.get(1));
         
         listaNombres.remove(1);
         listaNombres.remove("Adrian");
         
         System.out.println(listaNombres);
         
         for(String temp:listaNombres){
             System.out.println("Nombre con for: "+temp);
         }
         
         listaNombres.forEach(t -> System.out.println("Nombre sin for:"+t));  


/****************************************************************************************         
         Map<String, Integer> treeMap = new TreeMap<>();
         treeMap.put("Maria",2);
         treeMap.put("Jose",5);
         treeMap.put("Armando",4);
         treeMap.put("Maria",4);
         System.out.println(treeMap);  
         
/*****************************************************************************************
         Persona per1 = new Persona();
         per1.setNombre("Juan");
         per1.setCurp("JuanCURP");
         
         
         Persona per2 = new Persona();
         per2.setNombre("Adrian");
         per2.setCurp("AdrianCURP");
         
         
         Persona per3 = new Persona();
         per3.setNombre("Juan");
         per3.setCurp("JuanCURP");
         
         
         TreeMap<Persona, Integer> treeMapPersonas = new TreeMap<>();
         treeMapPersonas.put(per1,2);
         treeMapPersonas.put(per2,5);
         treeMapPersonas.put(per3,4);
         System.out.println(treeMapPersonas); */
         
/************************************************************************************
         ArrayDeque<String> deque = new ArrayDeque<>();
         deque.add("elemento1");
         deque.add("elemento2");
         deque.add("elemento3");
         deque.add("elemento4");
         deque.add("elemento5");
         
         System.out.println(deque);
         
         deque.pop();
         System.out.println(deque);
         
         deque.push("elemento7");
         deque.remove();
         System.out.println(deque);
    
   
************************************************************************************
         
         ArrayList<Persona> listaPersonas = new ArrayList<>();
         Persona per1 = new Persona("Juan", "Flores", "Sanchez", new Date(),"JUANCURP" , Genero.HOMBRE, "CDMX");
         Persona per2 = new Persona("Juan", "Gutierrez", "Hernandez", new Date(),"JUANGCURP" , Genero.HOMBRE,"TLX");
         Persona per3 = new Persona("Marisol", "Martinez", "Gonzalez", new Date(),"MARISOLCURP" , Genero.MUJER, "CDMX");
         Persona per4 = new Persona("Salvador", "Gutierrez", "Rosas", new Date(),"SALVADORCURP" , Genero.HOMBRE, "MTY");
         Persona per5 = new Persona("Julieta", "Hernandez", "Garcia", new Date(),"JULIETACURP" , Genero.MUJER, "TLX");
         
         listaPersonas.add(per1);
         listaPersonas.add(per2);
         listaPersonas.add(per3);
         listaPersonas.add(per4);
         listaPersonas.add(per5);
         
         //System.out.println(listaPersonas);
         
         listaPersonas.forEach(t -> System.out.println("Persona: "+t));
         
         System.out.println(listaPersonas.stream().count());
         
         listaPersonas.stream().filter(p -> p.getPrimerApellido().equalsIgnoreCase("Gutierrez")).forEach(t->System.out.println(t));
         
         listaPersonas.stream().filter(p->p.getCiudadNacimiento().equalsIgnoreCase("MTY")).filter(t->t.getPrimerApellido().equalsIgnoreCase("Gutierrez")).forEach(s->System.out.println(s));
         
         long cuantos = listaPersonas.stream().filter(p->p.getCiudadNacimiento().equalsIgnoreCase("MTY")).filter(t->t.getPrimerApellido().equalsIgnoreCase("Gutierrez")).count();
         System.out.println(cuantos);
         
         System.out.println(listaPersonas.stream().noneMatch(p->p.getNombre().equalsIgnoreCase("Juan")));
         
        
         
         
          int numerador = 10;
            
          Integer denominador = null;
    
          float division = 0;
          
          
         System.out.println("Antes de los errores");
         
         try{
         
             division = numerador / denominador;
         
         
            System.out.println("OTRAS LINEAS");
         
         }catch(NullPointerException np){
             System.out.println("Ocurrio un error de nulos");
             denominador = 1;
             division = numerador / denominador;
         
         
            System.out.println("OTRAS LINEAS EN CATCH");
         }catch(ArithmeticException ae){
             System.out.println("Ocurrio un error de aritmetica");
         }catch(Exception e){
             //System.out.println("Ocurrio un error");
             e.printStackTrace();
         }finally{
             System.out.println("Terminando la ejecucion");
         }
         
         
         ClaseLanzaExcepcion clase = new ClaseLanzaExcepcion();
         
         try {
             clase.personaAdulta(10);
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         
          
        
        
        ArrayList<String> lista = new ArrayList<>();
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");
         
        
//        assert lista.size() == 2:"correeeeee";
        
         System.out.println(lista);

*/

/*      oab.obtenerPersonasNegocio();
         
        oab.actualizarPersonaNegocio(4, "CURPMARIANUEVO"); */
         
         /*Persona persona = new Persona("Jesus", "Perez", "Lopez", new Date(), "CURPJESUS", Genero.MUJER, "TLAX");
         oab.insertarPersona(persona); */
        
        
    }


}
