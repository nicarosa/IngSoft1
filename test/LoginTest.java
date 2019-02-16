/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Control.CalculateSalaryControl;
import Control.RemoveControl;
import Control.ValidarLogin;
import Entidad.CandidateEntity;
import Entidad.EmployeeEntity;
import Entidad.CargoEntity;
import Entidad.Usuario;
import static Frontera.PrincipalFrame.listaCandidatos;
import static Frontera.PrincipalFrame.listaCargos;
import static Frontera.PrincipalFrame.listaEmpleados;
import Frontera.RosterView;
import static Frontera.RosterView.listaT;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
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
public class LoginTest {
    
    private static ValidarLogin validarLogin = new ValidarLogin();
    
    private static EmployeeEntity uno = new EmployeeEntity();
    private static EmployeeEntity dos = new EmployeeEntity();
    private static EmployeeEntity tres = new EmployeeEntity();
    private String datosIncorrectos = "Datos incorrectos";
    private String datoscorrectos = "Bienvenido";
    
    public LoginTest() {
    }
    
    
    
    @BeforeClass
    public static void setUpClass() {
        
        
        

        
        

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

        listaCargos.AñadirCargo(cargo1);
        listaCargos.AñadirCargo(cargo2);
        listaCargos.AñadirCargo(cargo3);
        
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

        listaEmpleados.AñadirEmpleado(uno);
        listaEmpleados.AñadirEmpleado(dos);
        listaEmpleados.AñadirEmpleado(tres);

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testUsuario(){
        Usuario u = new Usuario();
        u.setNombre("carlos");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u),datosIncorrectos );
        
    }
    @Test
    public void testContraseña(){
        Usuario u = new Usuario();
        u.setNombre("juan");
        u.setPassword("823");
        assertEquals(validarLogin.verificarLogin(u),datosIncorrectos );
        
    }
    @Test
    public void testCorrecto(){
        Usuario u = new Usuario();
        u.setNombre("juan");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u),datoscorrectos );
        
    }
    @Test
    public void testDocumentoCorrecto(){
        String id = "1019146963";
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        assertEquals(dos, aux);
    }
    @Test
    public void testDocumentoErroneo(){
        String id = "98563";
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        assertEquals(null, aux);
    }
    @Test
    public void testHorasNocturnas(){
        String id = "1019146963";
        int aumento1 = 30;
        int aumento2 = 15;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.setHorasNocturnas(aux.getHorasNocturnas() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getHorasNocturnas(), aumento1);
        aux.setHorasNocturnas(aux.getHorasNocturnas() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getHorasNocturnas(), aumento1+aumento2);
        
    }
    @Test
    public void testDominicales(){
        String id = "1019146963";
        int aumento1 = 5;
        int aumento2 = 7;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.setHorasDominicales(aux.getHorasDominicales()+ aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getHorasDominicales(), aumento1);
        aux.setHorasDominicales(aux.getHorasDominicales()+ aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getHorasDominicales(), aumento1+aumento2);
        
    }
    @Test
    public void testBonos(){
        String id = "1019146963";
        int aumento1 = 4000;
        int aumento2 = 3000;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.setBonos(aux.getBonos()+ aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getBonos(), aumento1);
        aux.setBonos(aux.getBonos()+ aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getBonos(), aumento1+aumento2);
        
    }
    @Test
    public void testHorasExtra(){
        String id = "1019146963";
        int aumento1 = 20;
        int aumento2 = 30;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.setHorasExtra(aux.getHorasExtra() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getHorasExtra(), aumento1);
        aux.setHorasExtra(aux.getHorasExtra() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getHorasExtra(), aumento1+aumento2);
        
    }
    @Test
    public void testHorasTrabajadas(){
        String id = "1019146963";
        int aumento1 = 80;
        int aumento2 = 40;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.setHorasTrabajadas(aux.getHorasTrabajadas() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getHorasTrabajadas(), aumento1);
        aux.setHorasTrabajadas(aux.getHorasTrabajadas() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getHorasTrabajadas(), aumento1+aumento2);
        
    }
    @Test
    public void testIncapacidades(){
        String id = "1019146963";
        int aumento1 = 3;
        int aumento2 = 2;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.setIncapacidad(aux.getIncapacidad() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getIncapacidad(), aumento1);
        aux.setIncapacidad(aux.getIncapacidad() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getIncapacidad(), aumento1+aumento2);
        
    }
    @Test
    public void testFaltas(){
        String id = "1019146963";
        int aumento1 = 1;
        int aumento2 = 2;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.setFaltas(aux.getFaltas() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getFaltas(), aumento1);
        aux.setFaltas(aux.getFaltas() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getFaltas(), aumento1+aumento2);
        
    }
    @Test
    public void testAdelantos(){
        String id = "1019146963";
        int aumento1 = 10000;
        int aumento2 = 1000;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.setAdelanto(aux.getAdelanto() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getAdelanto(), aumento1);
        aux.setAdelanto(aux.getAdelanto() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getAdelanto(), aumento1+aumento2);
        
    }
    @Test
    public void testVacaciones(){
        String id = "1019146963";
        int aumento1 = 7;
        int aumento2 = 8;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);        
        aux.setDiasDeVacaciones(aux.getDiasDeVacaciones() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getDiasDeVacaciones(), aumento1);
        aux.setDiasDeVacaciones(aux.getDiasDeVacaciones() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getDiasDeVacaciones(), aumento1+aumento2);
        
    }
    @Test
    public void testNuevoCandidato(){
        CandidateEntity aux = new CandidateEntity();
        aux.setIdentificacion("874361594");
        aux.setNombre("carlos");
        aux.setApellido("muños");
        aux.setNivelDeEstudios("Profesional");
        aux.setProfesion("Economia");
        aux.setUniversidad("Nacional");
        aux.setExperiencia(5);
        listaCandidatos.AñadirCandidato(aux);
        assertEquals(listaCandidatos.getCandidato("874361594"), aux);
    }
    @Test
    public void testNuevoEmpleado(){
        EmployeeEntity aux = new EmployeeEntity();
        aux.setIdentificacion("749173821");
        aux.setNombre("maria");
        aux.setApellido("garzon");
        aux.setARL("sura");
        aux.setEdad(20);
        aux.setEPS("compensar");
        aux.setContactoDeEmergencia(313534964);
        aux.setDireccion("calle80 #60-30");
        aux.setActivo(true);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado("749173821"), aux);
    }
    
    @Test
    public void testTablaLista(){
        JTable tabla = new JTable();
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setColumnCount(11);
        Object rowData[] = new Object[11];
        
        for (int i = 0; i < listaEmpleados.size(); i++) {
            rowData[0] = listaEmpleados.sacar(i).getNombre();
            rowData[1] = listaEmpleados.sacar(i).getApellido();
            rowData[2] = listaEmpleados.sacar(i).getIdentificacion();
            rowData[3] = listaEmpleados.sacar(i).getEdad();
            rowData[4] = listaEmpleados.sacar(i).getARL();
            rowData[5] = listaEmpleados.sacar(i).getEPS();
            rowData[6] = listaEmpleados.sacar(i).getContactoDeEmergencia();
            rowData[7] = listaEmpleados.sacar(i).getDireccion();
            rowData[8] = listaEmpleados.sacar(i).getCargo().getNombre();
            rowData[9] = listaEmpleados.sacar(i).getCargo().getSueldo();
            rowData[10] = listaEmpleados.sacar(i).isActivo();
            model.addRow(rowData);
        }
        for (int count = 0; count < model.getRowCount(); count++){
 
        assertEquals(listaEmpleados.sacar(count).getNombre(),model.getValueAt(count,0).toString() );
        }
    }
    
    
    @Test
    public void testTablaSort(){
        
        
        JTable tabla = new JTable();
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setColumnCount(11);
        Object rowData[] = new Object[11];
        
        for (int i = 0; i < listaEmpleados.size(); i++) {
            rowData[0] = listaEmpleados.sacar(i).getNombre();
            rowData[1] = listaEmpleados.sacar(i).getApellido();
            rowData[2] = listaEmpleados.sacar(i).getIdentificacion();
            rowData[3] = listaEmpleados.sacar(i).getEdad();
            rowData[4] = listaEmpleados.sacar(i).getARL();
            rowData[5] = listaEmpleados.sacar(i).getEPS();
            rowData[6] = listaEmpleados.sacar(i).getContactoDeEmergencia();
            rowData[7] = listaEmpleados.sacar(i).getDireccion();
            rowData[8] = listaEmpleados.sacar(i).getCargo().getNombre();
            rowData[9] = listaEmpleados.sacar(i).getCargo().getSueldo();
            rowData[10] = listaEmpleados.sacar(i).isActivo();
            model.addRow(rowData);
        }
        TableRowSorter<DefaultTableModel> sort = new TableRowSorter<DefaultTableModel>(model);
        tabla.setRowSorter(sort);
        String query = "1030685411";
        String query2 = "1013647467";
        String query3 = "1019146963";
        sort.setRowFilter(RowFilter.regexFilter(query));
        assertEquals(query,model.getValueAt(0,2).toString() );
        sort.setRowFilter(RowFilter.regexFilter(query));
        assertEquals(query2,model.getValueAt(1,2).toString() );
        sort.setRowFilter(RowFilter.regexFilter(query));
        assertEquals(query3,model.getValueAt(2,2).toString() );
    }  
    
    @Test
    public void testRetiroEmpleadoExitoso(){
        EmployeeEntity aux = new EmployeeEntity();
        
        double salario=1024000.0;
 
         RemoveControl r = new RemoveControl();
         assertEquals((long)r.RemoveEmployee(listaEmpleados.getEmpleado("1030685411")),(long) salario);
        
    }
    
    @Test
    public void testRetiroEmpleadoInactivo(){
        RemoveControl r = new RemoveControl();
        double retirado=-1;
        listaEmpleados.getEmpleado("1030685411").setActivo(false);
        r.RemoveEmployee(listaEmpleados.getEmpleado("1030685411"));
        
         assertEquals( (long)r.RemoveEmployee(listaEmpleados.getEmpleado("1030685411")),-1);
    }
    
    @Test
    public void testCalcularSalario(){
        CalculateSalaryControl c = new CalculateSalaryControl();
        double salario = c.calcular("1019146963");
        assertEquals((long)c.calcular("1019146963"), (long)salario);
    }
    
    @Test
    public void testRetiroEmpleadoinexistente(){
        EmployeeEntity aux = new EmployeeEntity();
        RemoveControl r = new RemoveControl();
        aux.setIdentificacion("749173821");
        aux.setNombre("maria");
        aux.setApellido("garzon");
        aux.setARL("sura");
        aux.setEdad(20);
        aux.setEPS("compensar");
        aux.setContactoDeEmergencia(313534964);
        aux.setDireccion("calle80 #60-30");
        aux.setActivo(true);
        
        
        assertEquals( (long)r.RemoveEmployee(aux),-2);
    }
}
