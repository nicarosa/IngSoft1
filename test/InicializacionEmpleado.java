/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entidad.CargoEntity;
import Entidad.EmployeeEntity;
import dao.EmpleadoDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USUARIO
 */
public class InicializacionEmpleado {
    
    public InicializacionEmpleado() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void initEmpleadoTable(){
        
        EmpleadoDAO dao = new EmpleadoDAO();
        
        EmployeeEntity uno = new EmployeeEntity();
        EmployeeEntity dos = new EmployeeEntity();
        EmployeeEntity tres = new EmployeeEntity();

        CargoEntity cargo1 = new CargoEntity();
        CargoEntity cargo2 = new CargoEntity();
        CargoEntity cargo3 = new CargoEntity();

        //Psicologia 
        //Ingenieria 
        //Economia 
        //Estadistca
        
        cargo1.setNombre("cargo 1");
        cargo1.setSueldo(2000000);
        cargo1.setCarreraOptima("Ingenieria");
        cargo1.añadirCarrerasAfines("Economia");
        cargo1.añadirCarrerasAfines("Estadistica");
        cargo1.setExperienciaRequerida(8);
        cargo1.setEstudiosRequeridos(4);
        
        cargo2.setNombre("cargo 2");
        cargo2.setSueldo(1000000);
        cargo2.setCarreraOptima("Economia");
        cargo2.añadirCarrerasAfines("Ingenieria");
        cargo2.añadirCarrerasAfines("Estadistica");
        cargo2.setExperienciaRequerida(8);
        cargo2.setEstudiosRequeridos(3);


        cargo3.setNombre("cargo 3");
        cargo3.setSueldo(800000);
        cargo3.setCarreraOptima("Estadistica");
        cargo3.añadirCarrerasAfines("Economia");
        cargo3.añadirCarrerasAfines("Psicologia");
        cargo3.setExperienciaRequerida(8);
        cargo3.setEstudiosRequeridos(1);

        
        
        uno.setARL("1020");
        uno.setActivo(true);
        uno.setApellido("CHAVES");
        uno.setContactoDeEmergencia(305612321);
        uno.setDireccion("Avenida calle 22#15-69");
        uno.setEPS("SaludCoop");
        uno.setEdad(21);
        uno.setIdentificacion("1030685411");
        uno.setNombre("ANDRES");
        uno.setPensiones(900000);
        uno.setHorasTrabajadas(1440);
        uno.setCargo(cargo3);

        dos.setARL("1030");
        dos.setActivo(true);
        dos.setApellido("CASTAÑEDA");
        dos.setCesantias(24);
        dos.setContactoDeEmergencia(306798545);
        dos.setDireccion("AVENIDA LAS FERIAS#70-05");
        dos.setEPS("SALUDTOTAL");
        dos.setEdad(19);
        dos.setIdentificacion("1019146963");
        dos.setNombre("SEBASTIAN");
        dos.setPensiones(900000);
        dos.setCargo(cargo2);

        tres.setARL("1040");
        tres.setActivo(true);
        tres.setApellido("CARO");
        tres.setCesantias(25);
        tres.setContactoDeEmergencia(10232131);
        tres.setDireccion("AV.PRIMERADEMAYO#70-22");
        tres.setEPS("VIVASALUD");
        tres.setEdad(25);
        tres.setIdentificacion("1013647467");
        tres.setNombre("NICOLAS");
        tres.setPensiones(1200000);
        tres.setCargo(cargo1);

        dao.crear(uno);
        dao.crear(dos);
        dao.crear(tres);

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}
