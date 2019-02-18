/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidad.EmployeeEntity;
import Frontera.RosterView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class EmpleadoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("RRhhPU");
    
    public EmpleadoDAO() {
        
    }

    public void crear(EmployeeEntity object) {
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

    public boolean eliminar(EmployeeEntity object) {
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

    public EmployeeEntity obtener(String identificacion ) {
        EntityManager em = emf.createEntityManager();
        EmployeeEntity empleado = null;
        Query q = em.createQuery("SELECT u FROM EmployeeEntity u " +
                "WHERE u.identificacion LIKE :identificacion")
                .setParameter("identificacion", identificacion);                
                
        try{
            empleado = (EmployeeEntity)q.getSingleResult();
        }
        catch (NonUniqueResultException e){
            empleado = (EmployeeEntity) q.getResultList().get(0);
        }
        catch (Exception e){
            //e.printStackTrace();
        }
        finally{
            em.close();
            return empleado;
        }
    }
    
    
    public boolean actualizar(String identificacion, EmployeeEntity nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        EmployeeEntity object;
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = obtener(identificacion);
            object.setNombre(nuevoObjeto.getNombre());
            object.setApellido(nuevoObjeto.getApellido());
            object.setIdentificacion(nuevoObjeto.getIdentificacion());
            object.setEdad(nuevoObjeto.getEdad());
            object.setARL(nuevoObjeto.getARL());
            object.setEPS(nuevoObjeto.getEPS());
            object.setCargo(nuevoObjeto.getCargo());
            object.setPensiones(nuevoObjeto.getPensiones());
            object.setCesantias(nuevoObjeto.getCesantias());
            object.setContactoDeEmergencia(nuevoObjeto.getContactoDeEmergencia());
            object.setDireccion(nuevoObjeto.getDireccion());
            object.setActivo(nuevoObjeto.isActivo());
            object.setHorasTrabajadas(nuevoObjeto.getHorasTrabajadas());
            object.setHorasExtra(nuevoObjeto.getHorasExtra());
            object.setHorasNocturnas(nuevoObjeto.getHorasNocturnas());
            object.setHorasDominicales(nuevoObjeto.getHorasDominicales());
            object.setBonos(nuevoObjeto.getBonos());
            object.setIncapacidad(nuevoObjeto.getIncapacidad());
            object.setFaltas(nuevoObjeto.getFaltas());
            object.setAdelanto(nuevoObjeto.getAdelanto());
            object.setHorasSinVacaciones(nuevoObjeto.getHorasSinVacaciones());
            object.setHorasSinPrimaSemestral(nuevoObjeto.getHorasSinPrimaSemestral());
            object.setDiasDeVacaciones(nuevoObjeto.getDiasDeVacaciones());
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
