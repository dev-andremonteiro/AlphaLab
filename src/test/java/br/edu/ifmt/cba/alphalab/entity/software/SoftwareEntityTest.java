/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.entity.software;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aluno
 */

public class SoftwareEntityTest {
    
   private static SoftwareEntity softwareTeste;
   private String link;
   private String descricao;

    public SoftwareEntityTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception{
        softwareTeste = new SoftwareEntity();
    }

    @AfterClass
    public static void tearDownClass() {
        softwareTeste = null;
    }

    @Before
    public void setUp() {        
        link  = "http://preti.compdevbooks.com/p/junit.html";
        descricao = "NetBens 4.8";
    }

    @After
    public void tearDown() {
        link = null;
        descricao = null;
    }
    
    @Test
    public void TestarLinkDoSoftware(){
        assertEquals("NetBens", softwareTeste.validar());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
