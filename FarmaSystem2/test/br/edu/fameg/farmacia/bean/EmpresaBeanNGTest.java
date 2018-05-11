/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fameg.farmacia.bean;

import br.edu.fameg.farmacia.dao.EmpresaDAO;
import br.edu.fameg.farmacia.domain.Empresa;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author pazak
 */
public class EmpresaBeanNGTest {
    
    public EmpresaBeanNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Teste de método getDAO, da classe EmpresaBean.
     */
    @Test
    public void testGetDAO() {
        System.out.println("getDAO");
        EmpresaBean instance = new EmpresaBean();
        EmpresaDAO expResult = null;
        EmpresaDAO result = instance.getDAO();
        assertEquals(result, expResult);
        // TODO verifica o código de teste gerado e remove a chamada default para falha.
        fail("O caso de teste \u00e9 um prot\u00f3tipo.");
    }

    /**
     * Teste de método criarNovaEntidade, da classe EmpresaBean.
     */
    @Test
    public void testCriarNovaEntidade() {
        System.out.println("criarNovaEntidade");
        EmpresaBean instance = new EmpresaBean();
        Empresa expResult = null;
        Empresa result = instance.criarNovaEntidade();
        assertEquals(result, expResult);
        // TODO verifica o código de teste gerado e remove a chamada default para falha.
        fail("O caso de teste \u00e9 um prot\u00f3tipo.");
    }
    
}
