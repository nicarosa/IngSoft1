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
public class ListaEmpleados {
    private ArrayList <EmpleadoEntidad> listaEmpleados;



    public ListaEmpleados() {
       this.listaEmpleados = new ArrayList<EmpleadoEntidad>();
    }
    
    public void AñadirEmpleado (EmpleadoEntidad emp){
        this.listaEmpleados.add(emp);
    }
    
    public EmpleadoEntidad getEmpleado(String id){
        EmpleadoEntidad aux=new EmpleadoEntidad();
       for(int i=0;i < listaEmpleados.size();i++){
           if(id.equals(listaEmpleados.get(i).getId())){
               aux= listaEmpleados.get(i);
           }
       }
       return aux;
    }
    public int size(){
        return listaEmpleados.size();
    }
}
