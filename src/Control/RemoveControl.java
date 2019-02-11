/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.EmployeeEntity;
import Entidad.EmployeesList;

/**
 *
 * @author USUARIO
 */
public class RemoveControl {

    public double RemoveEmployee(EmployeeEntity aux) {

        double Monto;
        Monto = Liquidar(aux);
        Frontera.PrincipalFrame.listaEmpleados.retirarEmpleado(aux.getId());
        return Monto;
    }

    public double Liquidar(EmployeeEntity em) {
        double liquidacion = 0;
        //2.1
        liquidacion += (((em.getNovedades().getDiasSinPrima() / 8) * em.getCargo().getSueldo()) / 360);
        System.out.println(em.getNovedades().getDiasSinPrima());

        //2.2 
        liquidacion += em.getCesantias();

        //2,3
        liquidacion += ((em.getCesantias() * (em.getNovedades().getHorasTrabajadas() / 8) * 0.12) / 360);
        System.out.println(liquidacion);
        //2,4
        liquidacion += (em.getCargo().getSueldo() * em.getNovedades().getHorasSinVacaciones() / 8) / 720;

        return liquidacion;
    }

}
