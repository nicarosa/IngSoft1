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
public class ListaCandidatos {
    private ArrayList <CandidatoEntidad> listaCandidatos;

    public ListaCandidatos() {
        this.listaCandidatos = new ArrayList<CandidatoEntidad>();
    }
    
    public void AñadirCandidato(CandidatoEntidad can){
        this.listaCandidatos.add(can);
    }
    
    public CandidatoEntidad getCandidato(String id){
       CandidatoEntidad aux=new CandidatoEntidad();
       for(int i=0;i < this.listaCandidatos.size();i++){
           if(id.equals(this.listaCandidatos.get(i).getId())){
               aux = this.listaCandidatos.get(i);
           }
       }
       return aux;    
    }
    
    public int size(){
        return listaCandidatos.size();
    }

    
    
}
