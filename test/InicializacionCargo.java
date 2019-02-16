/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entidad.CargoEntity;
import dao.CargoDAO;
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
public class InicializacionCargo {
    
    public InicializacionCargo() {
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
    public void Inicializarcargo(){
        
        CargoDAO dao = new CargoDAO();
                
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
        
        dao.crear(cargo1);
        dao.crear(cargo2);
        dao.crear(cargo3);

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
