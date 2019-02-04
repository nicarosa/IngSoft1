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
public class CandidatesList {
    private ArrayList <CandidateEntity> listaCandidatos;
    
    public ArrayList<CandidateEntity> getCandidatos(){
        return listaCandidatos;
    }

    public CandidatesList() {
        this.listaCandidatos = new ArrayList<CandidateEntity>();
    }
    
    public void AñadirCandidato(CandidateEntity can){
        this.listaCandidatos.add(can);
    }
    
    public CandidateEntity getCandidato(String id){
       CandidateEntity aux=new CandidateEntity();
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
