/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.business;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.ISolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.entity.exception.SolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.entity.software.SituacaoSolicitacaoEnum;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;
import br.edu.ifmt.cba.alphalab.gui.javafx.controller.software.SolicitacaoSoftwareView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author tcloss
 */
public class SolicitacaoSoftware extends ABusiness<SolicitacaoSoftwareEntity, SolicitacaoSoftwareException, ISolicitacaoSoftware>{
    
    public SolicitacaoSoftware(IDAO<SolicitacaoSoftwareEntity> dao) {
        super(dao);
    }
    public List<SolicitacaoSoftwareEntity> buscarTodas(){
        return ((ISolicitacaoSoftware) dao).buscarTodos();
    }
    
    public List<SolicitacaoSoftwareEntity> buscarPorData(Calendar data){
        return ((ISolicitacaoSoftware) dao).buscarPorData(data);
    }
    public List<SolicitacaoSoftwareEntity> buscarPorSolicitante(String solicitante){
        return ((ISolicitacaoSoftware) dao).buscaPorServidor(solicitante);
    }
    public List<SolicitacaoSoftwareEntity> buscarPorLaboratorio(String laboratorio){
        return ((ISolicitacaoSoftware) dao).buscaPorLaboratorio(laboratorio);
    }
    public List<SolicitacaoSoftwareEntity> buscarPorSituacao(SituacaoSolicitacaoEnum situacao){
        return ((ISolicitacaoSoftware)dao).buscaPorSituacao(situacao);
    }
    public List<SolicitacaoSoftwareEntity> buscaGeral(Calendar data,String solicitante,String laboratorio, SituacaoSolicitacaoEnum situacao){
        List<SolicitacaoSoftwareEntity> retorno = new ArrayList<>();
        if(data!=null){
            if(retorno.isEmpty())
                retorno=buscarPorData(data);
        }
        if(solicitante.trim().equals("")){
            if(retorno.isEmpty())
                retorno=buscarPorSolicitante(solicitante);
            else
                retorno.retainAll(buscarPorSolicitante(solicitante));
        }
        if(laboratorio.trim().equals("")){
            if(retorno.isEmpty())
                retorno=buscarPorLaboratorio(laboratorio);
            else
                retorno.retainAll(buscarPorLaboratorio(laboratorio));
        }
        if(situacao!=null){
            if(retorno.isEmpty())
                retorno=buscarPorSituacao(situacao);
            else
                retorno.retainAll(buscarPorSituacao(situacao));
        }
        return retorno;
    }
    
    
    
    
}
