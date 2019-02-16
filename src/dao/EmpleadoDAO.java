/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidad.EmployeeEntity;
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

    public EmployeeEntity leer(EmployeeEntity par) {
        EntityManager em = emf.createEntityManager();
        EmployeeEntity empleado = null;
        Query q = em.createQuery("SELECT u FROM EmployeeEntity u " +
                "WHERE u.nombre LIKE :nombre" +
                " AND u.apellido LIKE :apellido" +
                " AND u.identificacion LIKE :identificacion" +
                " AND u.ARL LIKE :ARL" +
                " AND u.EPS LIKE :EPS" +
                " AND u.cargo LIKE :cargo" +
                " AND u.pensiones LIKE :pensiones" +
                " AND u.cesantias LIKE :cesantias" +
                " AND u.contactoDeEmergencia LIKE :contactoDeEmergencia" +
                " AND u.direccion LIKE :direccion" +
                " AND u.activo LIKE :activo" +
                " AND u.horasTrabajadas LIKE :horasTrabajadas" +
                " AND u.horasExtra LIKE :horasExtra" +
                " AND u.horasNocturnas LIKE :horasNocturnas" +
                " AND u.horasDominicales LIKE :horasDominicales" +
                " AND u.bonos LIKE :bonos" +
                " AND u.incapacidad LIKE :incapacidad" +
                " AND u.faltas LIKE :faltas" +
                " AND u.adelanto LIKE :adelanto" +
                " AND u.HorasSinVacaciones LIKE :HorasSinVacaciones" +
                " AND u.HorasSinPrimaSemestral LIKE :HorasSinPrimaSemestral" +
                " AND u.DiasDeVacaciones LIKE :DiasDeVacaciones" )
                .setParameter("nombre", par.getNombre())
                .setParameter("apellido", par.getApellido())
                .setParameter("identificacion", par.getIdentificacion())
                .setParameter("edad", par.getEdad())
                .setParameter("ARL", par.getARL())
                .setParameter("EPS", par.getEPS())
                .setParameter("cargo", par.getCargo())
                .setParameter("pensiones", par.getPensiones())
                .setParameter("cesantias", par.getCesantias())
                .setParameter("contactoDeEmergencia", par.getContactoDeEmergencia())
                .setParameter("direccion", par.getDireccion())
                .setParameter("activo", par.isActivo())              
                .setParameter("horasTrabajadas", par.getHorasTrabajadas())
                .setParameter("horasExtra", par.getHorasExtra())
                .setParameter("horasNocturnas", par.getHorasNocturnas())
                .setParameter("horasDominicales", par.getHorasDominicales())
                .setParameter("bonos", par.getBonos())
                .setParameter("incapacidad", par.getIncapacidad())
                .setParameter("faltas", par.getFaltas())
                .setParameter("adelanto", par.getFaltas())
                .setParameter("HorasSinVacaciones", par.getHorasSinVacaciones())
                .setParameter("HorasSinPrimaSemestral", par.getHorasSinPrimaSemestral())
                .setParameter("DiasDeVacaciones", par.getDiasDeVacaciones())
                ;
                
        try{
            empleado = (EmployeeEntity) q.getSingleResult();
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
    public EmployeeEntity obtener(String identificacion ) {
        EntityManager em = emf.createEntityManager();
        EmployeeEntity empleado = null;
        Query q = em.createQuery("SELECT u FROM EmployeeEntity u " +
                "WHERE u.identificacion LIKE :identificacion")
                .setParameter("identificacion", identificacion);
                
                /*"WHERE u.nombre LIKE :nombre" +
                " AND u.apellido LIKE :apellido" +
                " AND u.identificacion LIKE :identificacion" +
                " AND u.ARL LIKE :ARL" +
                " AND u.EPS LIKE :EPS" +
                " AND u.cargo LIKE :cargo" +
                " AND u.pensiones LIKE :pensiones" +
                " AND u.cesantias LIKE :cesantias" +
                " AND u.contactoDeEmergencia LIKE :contactoDeEmergencia" +
                " AND u.direccion LIKE :direccion" +
                " AND u.activo LIKE :activo" +
                " AND u.horasTrabajadas LIKE :horasTrabajadas" +
                " AND u.horasExtra LIKE :horasExtra" +
                " AND u.horasNocturnas LIKE :horasNocturnas" +
                " AND u.horasDominicales LIKE :horasDominicales" +
                " AND u.bonos LIKE :bonos" +
                " AND u.incapacidad LIKE :incapacidad" +
                " AND u.faltas LIKE :faltas" +
                " AND u.adelanto LIKE :adelanto" +
                " AND u.HorasSinVacaciones LIKE :HorasSinVacaciones" +
                " AND u.HorasSinPrimaSemestral LIKE :HorasSinPrimaSemestral" +
                " AND u.DiasDeVacaciones LIKE :DiasDeVacaciones" )
                .setParameter("nombre", par.getNombre())
                .setParameter("apellido", par.getApellido())
                .setParameter("identificacion", par.getIdentificacion())
                .setParameter("edad", par.getEdad())
                .setParameter("ARL", par.getARL())
                .setParameter("EPS", par.getEPS())
                .setParameter("cargo", par.getCargo())
                .setParameter("pensiones", par.getPensiones())
                .setParameter("cesantias", par.getCesantias())
                .setParameter("contactoDeEmergencia", par.getContactoDeEmergencia())
                .setParameter("direccion", par.getDireccion())
                .setParameter("activo", par.isActivo())              
                .setParameter("horasTrabajadas", par.getHorasTrabajadas())
                .setParameter("horasExtra", par.getHorasExtra())
                .setParameter("horasNocturnas", par.getHorasNocturnas())
                .setParameter("horasDominicales", par.getHorasDominicales())
                .setParameter("bonos", par.getBonos())
                .setParameter("incapacidad", par.getIncapacidad())
                .setParameter("faltas", par.getFaltas())
                .setParameter("adelanto", par.getFaltas())
                .setParameter("HorasSinVacaciones", par.getHorasSinVacaciones())
                .setParameter("HorasSinPrimaSemestral", par.getHorasSinPrimaSemestral())
                .setParameter("DiasDeVacaciones", par.getDiasDeVacaciones())
                ;*/
                
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
    
    
    public boolean actualizar(EmployeeEntity object, EmployeeEntity nuevoObjeto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            object = leer(object);
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
