/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.business;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.ISolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.dao.mock.exception.MockSolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.entity.exception.SolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SituacaoSolicitacaoEnum;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareSolicitacaoEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;
import br.edu.ifmt.cba.alphalab.gui.javafx.controller.software.SolicitacaoSoftwareView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tcloss
 */
public class SolicitacaoSoftware extends ABusiness<SolicitacaoSoftwareEntity, SolicitacaoSoftwareException, ISolicitacaoSoftware> {

    public SolicitacaoSoftware(IDAO<SolicitacaoSoftwareEntity> dao) {
        super(dao);
    }

    public List<SolicitacaoSoftwareEntity> buscarTodas() {
        return ((ISolicitacaoSoftware) dao).buscarTodos();
    }

    public List<SolicitacaoSoftwareEntity> buscarPorData(Calendar data) {
        return ((ISolicitacaoSoftware) dao).buscarPorData(data);
    }

    public List<SolicitacaoSoftwareEntity> buscarPorSolicitante(String solicitante) {
        return ((ISolicitacaoSoftware) dao).buscaPorServidor(solicitante);
    }

    public List<SolicitacaoSoftwareEntity> buscarPorLaboratorio(LaboratorioEntity laboratorio) {
        return ((ISolicitacaoSoftware) dao).buscaPorLaboratorio(laboratorio);
    }

    public List<SolicitacaoSoftwareEntity> buscarPorSituacao(SituacaoSolicitacaoEnum situacao) {
        return ((ISolicitacaoSoftware) dao).buscaPorSituacao(situacao);
    }

    public List<SolicitacaoSoftwareEntity> buscaGeral(Calendar data, String solicitante, LaboratorioEntity laboratorio, SituacaoSolicitacaoEnum situacao) {
        List<SolicitacaoSoftwareEntity> retorno = new ArrayList<>(buscarTodas());
        if (data != null) {
            retorno.retainAll(buscarPorData(data));
        }
        if (!solicitante.trim().equals("")) {
            retorno.retainAll(buscarPorSolicitante(solicitante));
        }
        if (laboratorio!=null) {
            retorno.retainAll(buscarPorLaboratorio(laboratorio));
        }
        if (situacao != null) {
            retorno.retainAll(buscarPorSituacao(situacao));
        }
        return retorno;
    }
    public void confirmarInstalacao(SolicitacaoSoftwareEntity solicitacaoSoftwareEntity, SoftwareSolicitacaoEntity softwareSolicitacaoEntity,ServidorEntity concluinte){
        try {
            ((ISolicitacaoSoftware) dao).confirmarInstalacaoDeSoftware(solicitacaoSoftwareEntity, softwareSolicitacaoEntity, concluinte);
        } catch (MockSolicitacaoSoftwareException ex) {
            Logger.getLogger(SolicitacaoSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
