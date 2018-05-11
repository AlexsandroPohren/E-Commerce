/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.bean;

import br.edu.fameg.farmacia.dao.EmpresaDAO;
import br.edu.fameg.farmacia.domain.Empresa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pazak
 */
public class EmpresaBeanTest {
    
    public EmpresaBeanTest() {
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

    /**
     * Test of getDAO method, of class EmpresaBean.
     */
    @Test
    public void testGetDAO() {
        System.out.println("getDAO");
        EmpresaBean instance = new EmpresaBean();
        EmpresaDAO expResult = null;
        EmpresaDAO result = instance.getDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarNovaEntidade method, of class EmpresaBean.
     */
    @Test
    public void testCriarNovaEntidade() {
        System.out.println("criarNovaEntidade");
        EmpresaBean instance = new EmpresaBean();
        Empresa expResult = null;
        Empresa result = instance.criarNovaEntidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
