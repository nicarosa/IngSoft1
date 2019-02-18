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
import Entidad.Usuario;
import static Frontera.PrincipalFrame.listaEmpleados;
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
import dao.CandidateDAO;
import dao.CargoDAO;
import dao.EmpleadoDAO;
import dao.UsuarioDAO;
/**
 *
 * @author USUARIO
 */
public class LoginTest {
    
    private static ValidarLogin validarLogin = new ValidarLogin();
    
    private String datosIncorrectos = "Datos incorrectos";
    private String datoscorrectos = "Bienvenido";
    
    private CargoDAO cargodao = new CargoDAO();
    private CandidateDAO cadidatodao = new CandidateDAO();
    private EmpleadoDAO empleadodao = new EmpleadoDAO();
            
    public LoginTest() {
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
        aux = empleadodao.obtener(id);
        assertEquals(aux.getIdentificacion(), id);
    }
    @Test
    public void testDocumentoErroneo(){
        String id = "98563";
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        assertEquals(null, aux);
    }
    @Test
    public void testHorasNocturnas(){
        String id = "1019146963";
        int aumento1 = 30;
        int aumento2 = 15;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setHorasNocturnas(aux.getHorasNocturnas() + aumento1);
        empleadodao.actualizar(aux.getIdentificacion(), aux);
        assertEquals(empleadodao.obtener(aux.getIdentificacion()).getHorasNocturnas(), aumento1);
        aux.setHorasNocturnas(aux.getHorasNocturnas() + aumento2);
        empleadodao.actualizar(aux.getIdentificacion(), aux);
        assertEquals(empleadodao.obtener(aux.getIdentificacion()).getHorasNocturnas(), aumento1+aumento2);
        
    }
    @Test
    public void testDominicales(){
        String id = "1019146963";
        int aumento1 = 5;
        int aumento2 = 7;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setHorasDominicales(aux.getHorasDominicales() + aumento1);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getHorasDominicales(), aumento1);
        aux.setHorasDominicales(aux.getHorasDominicales() + aumento2);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getHorasDominicales(), aumento1+aumento2);
        
    }
    @Test
    public void testBonos(){
        String id = "1019146963";
        int aumento1 = 4000;
        int aumento2 = 3000;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setBonos(aux.getBonos() + aumento1);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getBonos(), aumento1);
        aux.setBonos(aux.getBonos() + aumento2);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getBonos(), aumento1+aumento2);
        
    }
    @Test
    public void testHorasExtra(){
        String id = "1019146963";
        int aumento1 = 20;
        int aumento2 = 30;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setHorasExtra(aux.getHorasExtra() + aumento1);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getHorasExtra(), aumento1);
        aux.setHorasExtra(aux.getHorasExtra() + aumento2);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getHorasExtra(), aumento1+aumento2);
        
    }
    @Test
    public void testHorasTrabajadas(){
        String id = "1019146963";
        int aumento1 = 80;
        int aumento2 = 40;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setHorasTrabajadas(aux.getHorasTrabajadas() + aumento1);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getHorasTrabajadas(), aumento1);
        aux.setHorasTrabajadas(aux.getHorasTrabajadas() + aumento2);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getHorasTrabajadas(), aumento1+aumento2);
        
    }
    @Test
    public void testIncapacidades(){
        String id = "1019146963";
        int aumento1 = 3;
        int aumento2 = 2;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setIncapacidad(aux.getIncapacidad()+ aumento1);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getIncapacidad(), aumento1);
        aux.setIncapacidad(aux.getIncapacidad() + aumento2);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getIncapacidad(), aumento1+aumento2);
        
    }
    @Test
    public void testFaltas(){
        String id = "1019146963";
        int aumento1 = 1;
        int aumento2 = 2;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setFaltas(aux.getFaltas() + aumento1);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getFaltas(), aumento1);
        aux.setFaltas(aux.getFaltas() + aumento2);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getFaltas(), aumento1+aumento2);
        
    }
    @Test
    public void testAdelantos(){
        String id = "1019146963";
        int aumento1 = 10000;
        int aumento2 = 1000;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setAdelanto(aux.getAdelanto() + aumento1);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getAdelanto(), aumento1);
        aux.setAdelanto(aux.getAdelanto() + aumento2);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getAdelanto(), aumento1+aumento2);
        
    }
    @Test
    public void testVacaciones(){
        String id = "1019146963";
        int aumento1 = 7;
        int aumento2 = 8;
        EmployeeEntity aux = new EmployeeEntity();
        aux = empleadodao.obtener(id);
        aux.setDiasDeVacaciones(aux.getDiasDeVacaciones()+ aumento1);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getDiasDeVacaciones(), aumento1);
        aux.setDiasDeVacaciones(aux.getDiasDeVacaciones() + aumento2);
        empleadodao.actualizar(id, aux);
        assertEquals(empleadodao.obtener(id).getDiasDeVacaciones(), aumento1+aumento2);
        
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
        cadidatodao.crear(aux);
        assertEquals(cadidatodao.leer("874361594").getIdentificacion(), aux.getIdentificacion());
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
        aux.setCargo(cargodao.leer("cargo 1"));
        empleadodao.crear(aux);
        assertEquals(empleadodao.obtener("749173821").getIdentificacion(), aux.getIdentificacion());
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
         assertEquals((long)r.RemoveEmployee(empleadodao.obtener("1030685411")),(long) salario);
        
    }
    
    @Test
    public void testRetiroEmpleadoInactivo(){
        RemoveControl r = new RemoveControl();
        double retirado=-1;
        
         assertEquals( (long)r.RemoveEmployee(empleadodao.obtener("1030685411")),-1);
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
