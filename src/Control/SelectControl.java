/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.CandidateEntity;
import Entidad.CargoEntity;

/**
 *
 * @author USUARIO
 */
public class SelectControl {
    
    public double CalcularAptitud(CandidateEntity candidato){
        double aptitud = 0;
        CargoEntity aux = candidato.getCargoaspirado();
        /*
        Bachiller = 1
        Tecnico = 2  
        Profesional =3
        Maestria = 4
        Doctorado = 5    
        */
        switch (aux.getEstudiosRequeridos()){
            case 1:
                aptitud++;
                break; 
            case 2:
                if(candidato.getNivelDeEstudios().equals("Bachiller")){
                    
                }
                else{
                    aptitud++;
                }
                break;
            case 3:
                if(candidato.getNivelDeEstudios().equals("Bachiller") || candidato.getNivelDeEstudios().equals("Tecnico")){
                    
                }
                else{
                    aptitud++;
                }
                break;
            case 4:
                if(candidato.getNivelDeEstudios().equals("Maestria") || candidato.getNivelDeEstudios().equals("Doctorado")){
                    aptitud++;
                }
                
                break;
            case 5:
                if(candidato.getNivelDeEstudios().equals("Maestria")){
                    aptitud++;
                }
                break;
        }
        if (aux.getCarreraOptima().equals(candidato.getProfesion())){
            aptitud += 3;
        }
        else{
            for(int i = 0; i < aux.getCarrerasAfines().size(); i++){
                if(candidato.getProfesion().equals(aux.getCarrerasAfines().get(i))){
                    aptitud++;
                    break;
                }
            }
        }
        
        if(!candidato.getUniversidad().equals("otras")){
            aptitud++;
        }
        if(candidato.getExperiencia() >= aux.getExperienciaRequerida()){
            aptitud += 3;
        }
        else{
            if (candidato.getExperiencia() >= aux.getExperienciaRequerida() - 2){
                aptitud++;
            }
        }
                    
        return aptitud/8;
    }
}
