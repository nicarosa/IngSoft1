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
public class EmployeeEntity extends PersonEntity{
    private String ARL;
    private String EPS;
    private PositionEntity cargo;
    private int pensiones;
    private int cesantias;
    private int contactoDeEmergencia;
    private String direccion;
    private boolean activo;     
    private NoveltyEntity novedades;


    public EmployeeEntity() {
        novedades = new NoveltyEntity();
        cargo = new PositionEntity();
    }
    

    public String getARL() {
        return ARL;
    }

    public void setARL(String ARL) {
        this.ARL = ARL;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public int getPensiones() {
        return pensiones;
    }

    public void setPensiones(int pensiones) {
        this.pensiones = pensiones;
    }

    public int getCesantias() {
        return cesantias;
    }

    public void setCesantias(int cesantias) {
        this.cesantias = cesantias;
    }

    public int getContactoDeEmergencia() {
        return contactoDeEmergencia;
    }

    public void setContactoDeEmergencia(int contactoDeEmergencia) {
        this.contactoDeEmergencia = contactoDeEmergencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public PositionEntity getCargo() {
        return cargo;
    }

    public void setCargo(PositionEntity cargo) {
        this.cargo = cargo;
    }

    public NoveltyEntity getNovedades() {
        return novedades;
    }

    public void setNovedades(NoveltyEntity novedades) {
        this.novedades = novedades;
    }

    
    @Override
    public String toString() {
        return super.toString() + " " + ARL + " " + EPS + " " + pensiones + " " + cesantias + " " + contactoDeEmergencia + " " + direccion; 
    }

 
    
}
