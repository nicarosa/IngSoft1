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
public class NoveltyEntity {

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

    public int getDiasDeVacaciones() {
        return DiasDeVacaciones;
    }

    public void setDiasDeVacaciones(int DiasDeVacaciones) {
        this.DiasDeVacaciones = DiasDeVacaciones;
    }

    public NoveltyEntity() {
        
    }

    public int getHorasSinVacaciones() {
        return HorasSinVacaciones;
    }

    public void setHorasSinVacaciones(int DiasSinVacaciones) {
        this.HorasSinVacaciones = DiasSinVacaciones;
    }

    public int getDiasSinPrima() {
        return HorasSinPrimaSemestral;
    }

    public void setDiasSinPrima(int DiasSinPrima) {
        this.HorasSinPrimaSemestral = DiasSinPrima;
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

    public int getHorasDominicales() {
        return horasDominicales;
    }

    public void setHorasDominicales(int horasDominicales) {
        this.horasDominicales = horasDominicales;
    }

    public void reset(){
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
    
    @Override
    public String toString() {
        return "Horas Nocturas :" + this.horasNocturnas + "Horas Dominicales :"
                + this.horasDominicales + "Bonificaciones :" + this.bonos + "Horas Extra :" + this.horasExtra
                + "Incapacidad :" + this.incapacidad + "Faltas :" + this.faltas + "Adelantos :" + this.adelanto
                + "Vacaciones :" + this.HorasSinVacaciones;
    }

}
