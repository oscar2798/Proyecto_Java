/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.softura.proyectojava.interfaces;

/**
 *
 * @author Froevel
 */

@FunctionalInterface
public interface IFuncionalOperacionesGenerales {
    
    public String saludarA(String curp, int edad);
    
    public default String saludar(){
        return "Hola...";
    }
    
    public default String despedirse(){
        return "Adios...";
    }
    
}
