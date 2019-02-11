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

    private static ArrayList<EmployeeEntity> listaEmpleados;

    public EmployeesList() {
        this.listaEmpleados = new ArrayList<EmployeeEntity>();
    }

    public void AñadirEmpleado(EmployeeEntity emp) {
        this.listaEmpleados.add(emp);
    }

    public EmployeeEntity sacar(int indice) {
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.get(indice);
        return aux;
    }

    public EmployeeEntity getEmpleado(String id) {
        EmployeeEntity aux = new EmployeeEntity();
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (id.equals(listaEmpleados.get(i).getId())) {

                aux = listaEmpleados.get(i);
                break;
            } else {
                aux = null;
            }
        }
        return aux;
    }

    public void retirarEmpleado(String id) {
        EmployeeEntity aux = new EmployeeEntity();
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (id.equals(listaEmpleados.get(i).getId())) {

                listaEmpleados.remove(i);
            }

        }
    }

    public int size() {
        return listaEmpleados.size();
    }
}
