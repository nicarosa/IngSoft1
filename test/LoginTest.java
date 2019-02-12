/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Control.ValidarLogin;
import Entidad.CandidateEntity;
import Entidad.EmployeeEntity;
import Entidad.PositionEntity;
import Entidad.Usuario;
import static Frontera.LoginFrame.sistema;
import static Frontera.PrincipalFrame.listaCandidatos;
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
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();

        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");

        usuario.add(a);
        usuario.add(b);
        usuario.add(c);

        sistema.setUsuarios(usuario);

        for (Usuario u : sistema.getUsuarios()) {
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("---------------");
        }
        
        
        

        PositionEntity Chef = new PositionEntity();
        PositionEntity Janitor = new PositionEntity();
        PositionEntity Dishwasher = new PositionEntity();

        Chef.setNombre("Head Chef");
        Chef.setSueldo(2000000);

        Janitor.setNombre("Conserje");
        Janitor.setSueldo(1000000);

        Dishwasher.setNombre("Lava Platos");
        Dishwasher.setSueldo(800000);

        uno.setARL("1020");
        uno.setActivo(true);
        uno.setApellido("CHAVES");
        uno.setContactoDeEmergencia(305612321);
        uno.setDireccion("Avenida calle 22#15-69");
        uno.setEPS("SaludCoop");
        uno.setEdad(21);
        uno.setId("1030685411");
        uno.setNombre("ANDRES");
        uno.setPensiones(900000);
        uno.getNovedades().setHorasTrabajadas(1440);
        uno.setCargo(Dishwasher);

        dos.setARL("1030");
        dos.setActivo(true);
        dos.setApellido("CASTAÑEDA");
        dos.setCesantias(24);
        dos.setContactoDeEmergencia(306798545);
        dos.setDireccion("AVENIDA LAS FERIAS#70-05");
        dos.setEPS("SALUDTOTAL");
        dos.setEdad(19);
        dos.setId("1019146963");
        dos.setNombre("SEBASTIAN");
        dos.setPensiones(900000);
        dos.setCargo(Janitor);

        tres.setARL("1040");
        tres.setActivo(true);
        tres.setApellido("CARO");
        tres.setCesantias(25);
        tres.setContactoDeEmergencia(10232131);
        tres.setDireccion("AV.PRIMERADEMAYO#70-22");
        tres.setEPS("VIVASALUD");
        tres.setEdad(25);
        tres.setId("1013647467");
        tres.setNombre("NICOLAS");
        tres.setPensiones(1200000);
        tres.setCargo(Chef);

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
        aux.getNovedades().setHorasNocturnas(aux.getNovedades().getHorasNocturnas() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getHorasNocturnas(), aumento1);
        aux.getNovedades().setHorasNocturnas(aux.getNovedades().getHorasNocturnas() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getHorasNocturnas(), aumento1+aumento2);
        
    }
    @Test
    public void testDominicales(){
        String id = "1019146963";
        int aumento1 = 5;
        int aumento2 = 7;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.getNovedades().setHorasDominicales(aux.getNovedades().getHorasDominicales()+ aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getHorasDominicales(), aumento1);
        aux.getNovedades().setHorasDominicales(aux.getNovedades().getHorasDominicales()+ aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getHorasDominicales(), aumento1+aumento2);
        
    }
    @Test
    public void testBonos(){
        String id = "1019146963";
        int aumento1 = 4000;
        int aumento2 = 3000;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.getNovedades().setBonos(aux.getNovedades().getBonos()+ aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getBonos(), aumento1);
        aux.getNovedades().setBonos(aux.getNovedades().getBonos()+ aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getBonos(), aumento1+aumento2);
        
    }
    @Test
    public void testHorasExtra(){
        String id = "1019146963";
        int aumento1 = 20;
        int aumento2 = 30;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.getNovedades().setHorasExtra(aux.getNovedades().getHorasExtra() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getHorasExtra(), aumento1);
        aux.getNovedades().setHorasExtra(aux.getNovedades().getHorasExtra() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getHorasExtra(), aumento1+aumento2);
        
    }
    @Test
    public void testHorasTrabajadas(){
        String id = "1019146963";
        int aumento1 = 80;
        int aumento2 = 40;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.getNovedades().setHorasTrabajadas(aux.getNovedades().getHorasTrabajadas() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getHorasTrabajadas(), aumento1);
        aux.getNovedades().setHorasTrabajadas(aux.getNovedades().getHorasTrabajadas() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getHorasTrabajadas(), aumento1+aumento2);
        
    }
    @Test
    public void testIncapacidades(){
        String id = "1019146963";
        int aumento1 = 3;
        int aumento2 = 2;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.getNovedades().setIncapacidad(aux.getNovedades().getIncapacidad() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getIncapacidad(), aumento1);
        aux.getNovedades().setIncapacidad(aux.getNovedades().getIncapacidad() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getIncapacidad(), aumento1+aumento2);
        
    }
    @Test
    public void testFaltas(){
        String id = "1019146963";
        int aumento1 = 1;
        int aumento2 = 2;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.getNovedades().setFaltas(aux.getNovedades().getFaltas() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getFaltas(), aumento1);
        aux.getNovedades().setFaltas(aux.getNovedades().getFaltas() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getFaltas(), aumento1+aumento2);
        
    }
    @Test
    public void testAdelantos(){
        String id = "1019146963";
        int aumento1 = 10000;
        int aumento2 = 1000;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);
        aux.getNovedades().setAdelanto(aux.getNovedades().getAdelanto() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getAdelanto(), aumento1);
        aux.getNovedades().setAdelanto(aux.getNovedades().getAdelanto() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getAdelanto(), aumento1+aumento2);
        
    }
    @Test
    public void testVacaciones(){
        String id = "1019146963";
        int aumento1 = 7;
        int aumento2 = 8;
        EmployeeEntity aux = new EmployeeEntity();
        aux = listaEmpleados.getEmpleado(id);        
        aux.getNovedades().setDiasDeVacaciones(aux.getNovedades().getDiasDeVacaciones() + aumento1);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getDiasDeVacaciones(), aumento1);
        aux.getNovedades().setDiasDeVacaciones(aux.getNovedades().getDiasDeVacaciones() + aumento2);
        listaEmpleados.retirarEmpleado(id);
        listaEmpleados.AñadirEmpleado(aux);
        assertEquals(listaEmpleados.getEmpleado(id).getNovedades().getDiasDeVacaciones(), aumento1+aumento2);
        
    }
    @Test
    public void testNuevoCandidato(){
        CandidateEntity aux = new CandidateEntity();
        aux.setId("874361594");
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
        aux.setId("749173821");
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
            rowData[2] = listaEmpleados.sacar(i).getId();
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
    
    private void filter(String query) {
        
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
            rowData[2] = listaEmpleados.sacar(i).getId();
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
        sort.setRowFilter(RowFilter.regexFilter(query));
        assertEquals(query,model.getValueAt(0,2).toString() );     
    }  
}
