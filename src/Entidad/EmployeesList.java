/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class EmployeesList {
    private ArrayList <EmployeeEntity> listaEmpleados;



    public EmployeesList() {
       this.listaEmpleados = new ArrayList<EmployeeEntity>();
    }
    
    public void AñadirEmpleado (EmployeeEntity emp){
        this.listaEmpleados.add(emp);
    }
    
    public EmployeeEntity getEmpleado(String id){
       EmployeeEntity aux = new EmployeeEntity();
       for(int i=0;i < listaEmpleados.size();i++){
           if(id.equals(listaEmpleados.get(i).getId())){
               aux= listaEmpleados.get(i);
               break;
           }
           else{
               aux = null;
           }
       }
       return aux;
    }
    public void retiarEmpleado(String id){
       EmployeeEntity aux = new EmployeeEntity();
       for(int i=0;i < listaEmpleados.size();i++){
           if(id.equals(listaEmpleados.get(i).getId())){
               listaEmpleados.remove(i);
           }
           
       } 
    }
    public int size(){
        return listaEmpleados.size();
    }
}
