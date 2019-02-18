/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Control.CalculateSalaryControl;
import Control.SelectControl;
import Entidad.CandidateEntity;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dao.CandidateDAO;
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
public class InicializacionCandidatos {
    
    public InicializacionCandidatos() {
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
    public void initTablaCandidatos(){
        CandidateDAO dao = new CandidateDAO();
        CargoDAO cdao = new CargoDAO();
        SelectControl sc = new SelectControl();
        CalculateSalaryControl cc = new CalculateSalaryControl();
        CandidateEntity candidate = new CandidateEntity();
        candidate.setNombre("Cesar");
        candidate.setApellido("Restrepo");
        candidate.setIdentificacion("1000628635");
        candidate.setEdad(18);
        candidate.setNivelDeEstudios("Bachiller");
        candidate.setProfesion("Ninguna");
        candidate.setUniversidad("otras");
        candidate.setExperiencia(0);
        candidate.setCargoaspirado(cdao.leer("cargo 1"));        
        candidate.setAptitud(sc.CalcularAptitud(candidate));

        dao.crear(candidate);
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
