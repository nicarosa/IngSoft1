/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author USUARIO
 */
public class CandidateEntity extends PersonEntity {

    private String nivelDeEstudios;
    private String profesion;
    private String universidad;
    private int experiencia;
    private Double aptitud;
    private Double salario_proyectado;

    public Double getSalario_proyectado() {
        return salario_proyectado;
    }

    public void setSalario_proyectado(Double salario_proyectado) {
        this.salario_proyectado = salario_proyectado;
    }

    public Double getAptitud() {
        return aptitud;
    }

    public void setAptitud(Double aptitud) {
        this.aptitud = aptitud;
    }

    public CandidateEntity() {
    }

    public String getNivelDeEstudios() {
        return nivelDeEstudios;
    }

    public void setNivelDeEstudios(String nivelDeEstudios) {
        this.nivelDeEstudios = nivelDeEstudios;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.nivelDeEstudios + " " + this.profesion + " " + this.universidad + " " + experiencia;
    }

}
