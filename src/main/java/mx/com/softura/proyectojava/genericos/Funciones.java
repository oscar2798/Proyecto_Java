/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.softura.proyectojava.genericos;

/**
 *
 * @author Froevel
 */
public class Funciones <F, T>{
    
    F dato;

    public Funciones(F dato) {
        this.dato = dato;
    }
    
    public Funciones() {
        
    }
    
    public void junta (T daton){
        System.out.println("Junta: "+dato+daton);
    }
    
}
