/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao.mock.software;

import br.edu.ifmt.cba.alphalab.dao.ISolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoInstalacaoEntity;
import java.util.ArrayList;

/**
 *
 * @author tcloss
 */
public class MockSolicitacaoSoftware implements ISolicitacaoSoftware {
    private static final ArrayList<SolicitacaoInstalacaoEntity> listaSolicitacao = new ArrayList<>();
    

    @Override
    public void save(SolicitacaoInstalacaoEntity entity) {
        if(!listaSolicitacao.contains(entity)){
            listaSolicitacao.add(entity);
        }
        else{
            listaSolicitacao.set(listaSolicitacao.indexOf(entity),entity);
        }
    }

    @Override
    public void delete(SolicitacaoInstalacaoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolicitacaoInstalacaoEntity getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirmarInstalacaoDeSoftware(SolicitacaoInstalacaoEntity solicitacaoSoftwareEntity, SoftwareEntity softwareEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
