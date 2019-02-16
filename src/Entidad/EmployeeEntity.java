/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;
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
@Table(name="EmployeeEntity")
public class EmployeeEntity extends PersonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ARL;
    private String EPS;
    private CargoEntity cargo;
    private int pensiones;
    private double cesantias;
    private int contactoDeEmergencia;
    private String direccion;
    private boolean activo;    
    private int horasTrabajadas = 0;
    private int horasExtra =0;
    private int horasNocturnas = 0;
    private int horasDominicales = 0;
    private int bonos = 0;
    private int incapacidad = 0;//en dias mayor a 3 
    private int faltas = 0;//en dias
    private int adelanto = 0;
    private int HorasSinVacaciones = 0; //en dias
    private int HorasSinPrimaSemestral = 0;
    private int DiasDeVacaciones = 0;

    public EmployeeEntity() {
        cargo = new CargoEntity();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
            this.HorasSinVacaciones += (horasTrabajadas - this.horasTrabajadas);
        this.HorasSinPrimaSemestral += (horasTrabajadas - this.horasTrabajadas);
        this.horasTrabajadas = horasTrabajadas;
        if (this.HorasSinPrimaSemestral >= 1440) {
            while (HorasSinPrimaSemestral > 1440) {
                DarPrimaSemestral();
            }

        }

    }
    public void DarVacaciones() {
        this.HorasSinVacaciones = 0;
    }

    public void DarPrimaSemestral() {
        this.HorasSinPrimaSemestral -= 1440;
    }
    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public int getHorasNocturnas() {
        return horasNocturnas;
    }

    public void setHorasNocturnas(int horasNocturnas) {
        this.horasNocturnas = horasNocturnas;
    }

    public int getHorasDominicales() {
        return horasDominicales;
    }

    public void setHorasDominicales(int horasDominicales) {
        this.horasDominicales = horasDominicales;
    }

    public int getBonos() {
        return bonos;
    }

    public void setBonos(int bonos) {
        this.bonos = bonos;
    }

    public int getIncapacidad() {
        return incapacidad;
    }

    public void setIncapacidad(int incapacidad) {
        this.incapacidad = incapacidad;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(int adelanto) {
        this.adelanto = adelanto;
    }

    public int getHorasSinVacaciones() {
        return HorasSinVacaciones;
    }

    public void setHorasSinVacaciones(int HorasSinVacaciones) {
        this.HorasSinVacaciones = HorasSinVacaciones;
    }

    public int getHorasSinPrimaSemestral() {
        return HorasSinPrimaSemestral;
    }

    public void setHorasSinPrimaSemestral(int HorasSinPrimaSemestral) {
        this.HorasSinPrimaSemestral = HorasSinPrimaSemestral;
    }

    public int getDiasDeVacaciones() {
        return DiasDeVacaciones;
    }

    public void setDiasDeVacaciones(int DiasDeVacaciones) {
        this.DiasDeVacaciones = DiasDeVacaciones;
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

    public double getCesantias() {

        return calcularCesantias();
    }

    public void setCesantias(double cesantias) {
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

    public CargoEntity getCargo() {
        return cargo;
    }

    public void setCargo(CargoEntity cargo) {
        this.cargo = cargo;
    }


    public double calcularCesantias() {

        setCesantias((((horasTrabajadas / 8) * (getCargo().getSueldo())) / 360));

        return this.cesantias;
    }

    @Override
    public String toString() {
        return super.toString() + " " + ARL + " " + EPS + " " + pensiones + " " + cesantias + " " + contactoDeEmergencia + " " + direccion;
    }

    public void reset() {
    this.horasTrabajadas = 0;
    this.horasExtra =0;
    this.horasNocturnas = 0;
    this.horasDominicales = 0;
    this.bonos = 0;
    this.incapacidad = 0;//en dias mayor a 3 
    this.faltas = 0;//en dias
    this.adelanto = 0;
    this.HorasSinVacaciones = 0; //en dias
    this.HorasSinPrimaSemestral = 0;
    this.DiasDeVacaciones = 0;
    }

}
