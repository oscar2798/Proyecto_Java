/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exepcionespropias;

/**
 *
 * @author Froevel
 */
public class ClaseLanzaExcepcion {
    
    public void personaAdulta (int edad) throws Exception{
    
        if(edad < 18){
            throw new Exception("No es adulto, tan solo tiene: "+edad);
        }
    }
    
}
