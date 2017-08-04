/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao.mock.software;

import br.edu.ifmt.cba.alphalab.dao.ISolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;
import java.util.ArrayList;

/**
 *
 * @author tcloss
 */
public class MockSolicitacaoSoftware implements ISolicitacaoSoftware {
    private static final ArrayList<SolicitacaoSoftwareEntity> listaSolicitacao = new ArrayList<>();
    

    @Override
    public void save(SolicitacaoSoftwareEntity entity) {
        if(!listaSolicitacao.contains(entity)){
            entity.setId(listaSolicitacao.size()+1);
            listaSolicitacao.add(entity);
        }
        else{
            listaSolicitacao.set(listaSolicitacao.indexOf(entity),entity);
        }
    }

    @Override
    public void delete(SolicitacaoSoftwareEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolicitacaoSoftwareEntity getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirmarInstalacaoDeSoftware(SolicitacaoSoftwareEntity solicitacaoSoftwareEntity, SoftwareEntity softwareEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
