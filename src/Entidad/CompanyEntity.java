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
public class CompanyEntity {

    private int NumeroDeEmpleados;
    private String RazonSocial;
    private String NIT;
    private String Nombre;

    public CompanyEntity() {
    }

    public int getNumeroDeEmpleados() {
        return NumeroDeEmpleados;
    }

    public void setNumeroDeEmpleados(int NumeroDeEmpleados) {
        this.NumeroDeEmpleados = NumeroDeEmpleados;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
