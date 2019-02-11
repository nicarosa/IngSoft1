/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Control.ValidarLogin;
import Entidad.Usuario;
import static Frontera.LoginFrame.sistema;
import java.util.ArrayList;
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
    
    private String datosIncorrectos = "Datos incorrectos";
    
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
    
}
