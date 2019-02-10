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
    
    public static double RemoveEmployee(String id){
        EmployeeEntity aux = Entidad.EmployeesList.getEmpleado(id);
        if(aux==null){System.out.println("No existe empleado");return -1;}
        double Monto;
    Monto=Liquidar(aux);
    EmployeesList.retirarEmpleado(id);
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
