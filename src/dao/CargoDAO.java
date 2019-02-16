/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidad.CargoEntity;
import Entidad.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
public class CargoDAO {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("RRhhPU");
    
    public CargoDAO() {
    }

    public void crear(CargoEntity object) {
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

    public boolean eliminar(CargoEntity object) {
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

    public CargoEntity leer(String nombre) {
        EntityManager em = emf.createEntityManager();
        CargoEntity cargo = null;
        Query q = em.createQuery("SELECT u FROM CargoEntity u " +
                "WHERE u.Nombre LIKE :Nombre" )
                .setParameter("Nombre", nombre)
                ;
        try{
            cargo = (CargoEntity) q.getSingleResult();
        }
        catch (NonUniqueResultException e){
            cargo = (CargoEntity) q.getResultList().get(0);
        }
        catch (Exception e){
            //e.printStackTrace();
        }
        finally{
            em.close();
            return cargo;
        }
    }
    
    public boolean actualizar(String nombre, CargoEntity nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        CargoEntity object;
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leer(nombre);
            object.setNombre(nuevoObjeto.getNombre());
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
