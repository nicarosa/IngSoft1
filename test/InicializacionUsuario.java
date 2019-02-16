/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entidad.Usuario;
import dao.UsuarioDAO;
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
public class InicializacionUsuario {
    
    public InicializacionUsuario() {
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
    public void initUsuiariTable(){
        
        UsuarioDAO dao = new UsuarioDAO();
        
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

        

        for (Usuario u : usuario) {
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("---------------");
            dao.crear(u);
        }
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
