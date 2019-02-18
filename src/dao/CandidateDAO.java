/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidad.CandidateEntity;
import Entidad.CargoEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class CandidateDAO {
 public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("RRhhPU");
    
    public CandidateDAO() {
    }

    public void crear(CandidateEntity object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public boolean eliminar(CandidateEntity object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            em.remove(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }

    public CandidateEntity leer(String identificacion) {
        EntityManager em = emf.createEntityManager();
        CandidateEntity candidato = null;
        Query q = em.createQuery("SELECT u FROM CandidateEntity u " +
                "WHERE u.identificacion LIKE :identificacion" )
                .setParameter("identificacion", identificacion)
                ;
        try{
            candidato = (CandidateEntity) q.getSingleResult();
        }
        catch (NonUniqueResultException e){
            candidato = (CandidateEntity) q.getResultList().get(0);
        }
        catch (Exception e){
            //e.printStackTrace();
        }
        finally{
            em.close();
            return candidato;
        }
    }
    
    public boolean actualizar(String nombre, CandidateEntity nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        CandidateEntity object;
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leer(nombre);
            object.setNombre(nuevoObjeto.getNombre());
            object.setApellido(nuevoObjeto.getApellido());
            object.setIdentificacion(nuevoObjeto.getIdentificacion());
            object.setEdad(nuevoObjeto.getEdad());
            object.setNivelDeEstudios(nuevoObjeto.getNivelDeEstudios());
            object.setProfesion(nuevoObjeto.getProfesion());
            object.setUniversidad(nuevoObjeto.getUniversidad());
            object.setExperiencia(nuevoObjeto.getExperiencia());
            object.setAptitud(nuevoObjeto.getAptitud());
            object.setSalario_proyectado(nuevoObjeto.getSalario_proyectado());
            object.setCargoaspirado(nuevoObjeto.getCargoaspirado());
            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        }
        catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally{
            em.close();
            return ret;
        }
    }
   
}
