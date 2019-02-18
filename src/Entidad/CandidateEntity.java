/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author USUARIO
 */
@Entity
@Table(name="CandidateEntity")
public class CandidateEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nivelDeEstudios;
    private String profesion;
    private String universidad;
    private int experiencia;
    private Double aptitud;
    private Double salario_proyectado;
    private CargoEntity cargoaspirado;
    private String nombre;
    private String apellido;
    private String identificacion;
    private int edad;

    

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String id) {
        this.identificacion = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public CargoEntity getCargoaspirado() {
        return cargoaspirado;
    }

    public void setCargoaspirado(CargoEntity cargoaspirado) {
        this.cargoaspirado = cargoaspirado;
    }
    
    

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
