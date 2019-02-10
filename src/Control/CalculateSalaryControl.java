/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.EmployeeEntity;
import Frontera.PrincipalFrame;

/**
 *
 * @author USUARIO
 */
public class CalculateSalaryControl {
    public static double calcular(String id){
        double sueldoFinal=0;
        EmployeeEntity aux = new EmployeeEntity();
        aux = PrincipalFrame.listaEmpleados.getEmpleado(id);
        if (aux.isActivo()){
            double salarioBase = aux.getCargo().getSueldo();
            double sbMenosSalud = salarioBase - (0.08*salarioBase);
            double horasNocturnas = ((double)aux.getNovedades().getHorasNocturnas() * (salarioBase*0.35));
            double horasDominicales = ((double)aux.getNovedades().getHorasDominicales()*(salarioBase*1.75));
            double horasExtra = ((double)aux.getNovedades().getHorasExtra()*(salarioBase*0.25));
            double bonus = (double)aux.getNovedades().getBonos();
            double faltas = ((double)aux.getNovedades().getFaltas()*(salarioBase*2.75));
            double vacacionesIncapacidad = 0;
            if((aux.getNovedades().getVacaciones()) + (aux.getNovedades().getIncapacidad()) > 3){
                vacacionesIncapacidad = ((double)((aux.getNovedades().getVacaciones()) + (aux.getNovedades().getIncapacidad()))*(0.25));
            }
            sueldoFinal = sbMenosSalud + horasNocturnas + horasDominicales + horasExtra + bonus - faltas -vacacionesIncapacidad;
        }
        return sueldoFinal;
    }
}
