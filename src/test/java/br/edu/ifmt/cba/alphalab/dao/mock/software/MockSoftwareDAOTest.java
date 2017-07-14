/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao.mock.software;

import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tcloss
 */
public class MockSoftwareDAOTest {
    
    public MockSoftwareDAOTest() {
    }

    /**
     * Test of save method, of class MockSoftwareDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        SoftwareEntity entity = new SoftwareEntity();
        entity.setDescricao("teste");
        entity.setId(1L);
        MockSoftwareDAO instance = MockSoftwareDAO.getInstance();
        instance.save(entity);
    }

    /**
     * Test of getById method, of class MockSoftwareDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Long id = 1L;
        MockSoftwareDAO instance = MockSoftwareDAO.getInstance();
        SoftwareEntity expResult = null;
        SoftwareEntity result = instance.getById(id);
        assertEquals(id, result.getId());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of buscarTodos method, of class MockSoftwareDAO.
     */
    @Test
    public void testBuscarTodos() {
        System.out.println("buscarTodos");
        MockSoftwareDAO instance = MockSoftwareDAO.getInstance();
        List<SoftwareEntity> expResult = null;
        List<SoftwareEntity> result = instance.buscarTodos();
        result.forEach(action->System.out.println(action.getDescricao()));
        assertEquals(1, result.size());
    }
    

    /**
     * Test of delete method, of class MockSoftwareDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        SoftwareEntity entity = null;
        MockSoftwareDAO instance = MockSoftwareDAO.getInstance();
        instance.delete(entity);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
