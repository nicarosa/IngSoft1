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
public class CargoEntidad {
    private String nombre;
    private String carreraOptima;
    private String carrerasAfines;
    private double sueldo;

    public CargoEntidad() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarreraOptima() {
        return carreraOptima;
    }

    public void setCarreraOptima(String carreraOptima) {
        this.carreraOptima = carreraOptima;
    }

    public String getCarrerasAfines() {
        return carrerasAfines;
    }

    public void setCarrerasAfines(String carrerasAfines) {
        this.carrerasAfines = carrerasAfines;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
