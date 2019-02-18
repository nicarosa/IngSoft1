/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author User
 */
/*

Esta clase es la que le da formato a la tabla de candidatos existentes, para probar la tabla se añade
un candidato en nuevo perfil de candidato y se verifican los datos ingresados en la tabla.


 */
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CandidatesTableModel extends AbstractTableModel {

    private String[] columnNames = {"Identificacion","Nombre", "Apellido", "Carrera", "Aptitud", "Cargo deaseado"};
    private ArrayList<CandidateEntity> candidatos;

    public CandidatesTableModel(ArrayList<CandidateEntity> candidateList) {
        candidatos = candidateList;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        int size;
        if (candidatos == null) {
            size = 0;
        } else {
            size = candidatos.size();
        }
        return size;
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 1) {
            temp = candidatos.get(row).getNombre();
        } else if (col == 2) {
            temp = candidatos.get(row).getApellido();
        } else if (col == 3) {
            temp = candidatos.get(row).getProfesion();
        } else if (col == 4) {
            temp = new Double(candidatos.get(row).getAptitud());
        } else if (col == 5) {
            temp = candidatos.get(row).getCargoaspirado().getNombre();
        }else if (col == 0) {
            temp = candidatos.get(row).getIdentificacion();
        }
        //Acá haría falta si es ex-empleado o no, pero toca hacer el método para eso
        return temp;
    }
    // needed to show column names in JTable 

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        if (col == 4) {
            return Double.class;
        } else {
            return String.class;
        }
    }
}
