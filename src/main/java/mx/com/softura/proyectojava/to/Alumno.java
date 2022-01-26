/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.softura.proyectojava.to;

import java.util.Date;
import java.util.Objects;
import mx.com.softura.proyectojava.enums.Genero;

/**
 *
 * @author Froevel
 */
public class Alumno extends Persona{
    private String periodoIngreso;
    private String licenciatura;
    private String matricula;
    private String programa;
    private Integer id_persona;
    
    
    public Alumno(){
    }

    public Alumno(String periodoIngreso, String licenciatura, String matricula, String programa) {
        this.periodoIngreso = periodoIngreso;
        this.licenciatura = licenciatura;
        this.matricula = matricula;
        this.programa = programa;
        //this.id_persona = id_persona;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.getNombre());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.matricula, other.matricula);
    }
    /**
     * @return the periodoIngreso
     */
    public String getPeriodoIngreso() {
        return periodoIngreso;
    }

    /**
     * @param periodoIngreso the periodoIngreso to set
     */
    public void setPeriodoIngreso(String periodoIngreso) {
        this.periodoIngreso = periodoIngreso;
    }

    /**
     * @return the licenciatura
     */
    public String getLicenciatura() {
        return licenciatura;
    }

    /**
     * @param licenciatura the licenciatura to set
     */
    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    /**
     * @return the programa
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

   

   
    
    
}
