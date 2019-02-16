/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;

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
@Table(name="CargoEntity")
public class CargoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Nombre;
    private String carreraOptima = null;
    private ArrayList <String> carrerasAfines = new ArrayList<>();
    private int experienciaRequerida = 0;
    private int estudiosRequeridos = 0;
    private double sueldo;
    /*
    Bachiller = 1
    Tecnico = 2  
    Profesional =3
    Maestria = 4
    Doctorado = 5    
    */

    public CargoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getCarreraOptima() {
        return carreraOptima;
    }

    public void setCarreraOptima(String carreraOptima) {
        this.carreraOptima = carreraOptima;
    }

    public ArrayList<String> getCarrerasAfines() {
        return carrerasAfines;
    }

    public void añadirCarrerasAfines(String carrera) {
        this.carrerasAfines.add(carrera);
    }

    public int getExperienciaRequerida() {
        return experienciaRequerida;
    }

    public void setExperienciaRequerida(int experienciaRequerida) {
        this.experienciaRequerida = experienciaRequerida;
    }

    public int getEstudiosRequeridos() {
        return estudiosRequeridos;
    }

    public void setEstudiosRequeridos(int estudiosRequeridos) {
        this.estudiosRequeridos = estudiosRequeridos;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
