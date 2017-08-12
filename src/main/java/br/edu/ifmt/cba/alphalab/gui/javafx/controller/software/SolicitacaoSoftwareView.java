/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.software;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SituacaoSolicitacaoEnum;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareSolicitacaoEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tcloss
 */
public class SolicitacaoSoftwareView {

    private SolicitacaoSoftwareEntity solicitacao;
    private SoftwareSolicitacaoEntity software;
    
    private List<SolicitacaoSoftwareView> lista;

    public SolicitacaoSoftwareView() {
        lista=new ArrayList<>();
    }
    public String getIdSolicitacao(){
        return solicitacao.getId().toString();
    }
    
    public String getDataSolicitacao(){
        return new SimpleDateFormat("dd/M/Y").format(solicitacao.getDataPedido().getTime());
    }
    public boolean isInstalado(){
        return software.isInstalado();
    }

    public SolicitacaoSoftwareEntity getSolicitacao() {
        return solicitacao;
    }

    public SoftwareSolicitacaoEntity getSoftware() {
        return software;
    }
    

    public String getDescricao() {
        return software.getDescricao();
    }

    public String getTipo() {
        return software.getTipo().getDescricao();
    }

    public String getObservacaoInstalacao() {
        return software.getObservacaoInstalacao();
    }

    public String getVersao() {
        return software.getVersao();
    }

    public String getLaboratorio() {
        return solicitacao.getLaboratorio().getNome();
    }

    public String getSituacaoInstalacao() {
        return solicitacao.getSituacaoInstalacao().getDescricao();
    }

    public String getSolicitante() {
        return solicitacao.getSolicitante().getNome();
    }
    
    
    public SolicitacaoSoftwareView(SolicitacaoSoftwareEntity solicitacao, SoftwareSolicitacaoEntity software) {
        this.software=software;
        this.solicitacao=solicitacao;
    }

    public SolicitacaoSoftwareView setSolicitacao(List<SolicitacaoSoftwareEntity> lista) {
        lista.forEach(solicitacao->{
        ((SolicitacaoSoftwareEntity)solicitacao).getSoftwares().forEach(software -> {
            this.lista.add(new SolicitacaoSoftwareView(solicitacao, software));
        });
        });
        return this;
    }

    public List<SolicitacaoSoftwareView> getList() {
        return lista;
    }
}
