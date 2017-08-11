/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.business;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.ISolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.entity.exception.SolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;

/**
 *
 * @author tcloss
 */
public class SolicitacaoSoftware extends ABusiness<SolicitacaoSoftwareEntity, SolicitacaoSoftwareException, ISolicitacaoSoftware>{
    
    public SolicitacaoSoftware(IDAO<SolicitacaoSoftwareEntity> dao) {
        super(dao);
    }
    
}
