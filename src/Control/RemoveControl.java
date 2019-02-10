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
    
    public static double RemoveEmployee(EmployeeEntity aux){
        
        double Monto;
    Monto=Liquidar(aux);
    EmployeesList.retirarEmpleado(aux.getId());
    return Monto;
    }
    
    public static double Liquidar (EmployeeEntity em){
        double liquidacion =em.getCesantias() ;
        //2.1
 
        //2.2 2,3
        liquidacion+=((em.getCesantias()*(em.getNovedades().getHorasTrabajadas()/8)*0.12)/360);

        
    return liquidacion;
    }
    
}
