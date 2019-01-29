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

    public ListaEmpleados(ArrayList<EmpleadoEntidad> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ListaEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void AñadirEmpleado (EmpleadoEntidad emp){
        this.listaEmpleados.add(emp);
    }
    
    public EmpleadoEntidad mostrarEmpleado(String id){
        EmpleadoEntidad aux=new EmpleadoEntidad();
       for(int i=0;i < listaEmpleados.size();i++){
           if(id == (listaEmpleados.get(i).getId())){
               aux= listaEmpleados.get(i);
           }
       }
       return aux;
    }
}
