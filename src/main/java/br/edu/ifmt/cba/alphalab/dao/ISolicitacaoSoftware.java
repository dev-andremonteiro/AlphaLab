/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.dao.mock.exception.MockSolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SituacaoSolicitacaoEnum;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareSolicitacaoEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author tcloss
 */
public interface ISolicitacaoSoftware extends IDAO<SolicitacaoSoftwareEntity>{
    
    public void confirmarInstalacaoDeSoftware(SolicitacaoSoftwareEntity solicitacaoSoftwareEntity, SoftwareSolicitacaoEntity softwareSolicitacaoEntity,ServidorEntity concluinte) throws MockSolicitacaoSoftwareException;
    public List<SolicitacaoSoftwareEntity> buscarTodos();
    public List<SolicitacaoSoftwareEntity> buscarPorData(Calendar data);
    public List<SolicitacaoSoftwareEntity> buscaPorServidor(String servidory);
    public List<SolicitacaoSoftwareEntity> buscaPorSituacao(SituacaoSolicitacaoEnum situacaoSolicitacaoEnum);
    public List<SolicitacaoSoftwareEntity> buscaPorLaboratorio(LaboratorioEntity laboratorio);
}
