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
public class CargoListEntity {
    private ArrayList <CargoEntity> listacargos = new ArrayList<>();
        public CargoListEntity() {
    }

    public void AñadirCargo(CargoEntity emp) {
        this.listacargos.add(emp);
    }

    public CargoEntity sacar(int indice) {
        CargoEntity aux = new CargoEntity();
        aux = listacargos.get(indice);
        return aux;
    }

    public CargoEntity getCargo(String cargo) {
        CargoEntity aux = new CargoEntity();
        for (int i = 0; i < listacargos.size(); i++) {
            if (cargo.equals(listacargos.get(i).getNombre())) {

                aux = listacargos.get(i);
                break;
            } else {
                aux = null;
            }
        }
        return aux;
    }

}
