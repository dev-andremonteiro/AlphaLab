/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao.mock.software;

import static br.edu.ifmt.cba.alphalab.dao.mock.software.MockSoftwareDAO.getInstance;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareSolicitacaoEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;
import org.junit.Test;

/**
 *
 * @author tcloss
 */
public class MockSolicitacaoSoftwareTest {
    
    public MockSolicitacaoSoftwareTest() {
    }

    @Test
    public void testSomeMethod() {
        MockSolicitacaoSoftware instance=MockSolicitacaoSoftware.getInstance();
        instance.save(new SolicitacaoSoftwareEntity());
        instance.save(new SolicitacaoSoftwareEntity());
        instance.save(new SolicitacaoSoftwareEntity());
        instance.getById(2L);
        
    }
    
}
