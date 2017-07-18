/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.entity.software;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.SoftwareException;
import br.edu.ifmt.cba.alphalab.entity.exception.SolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author tcloss
 */
public class SolicitacaoSoftwareEntity implements IEntity<SolicitacaoSoftwareException>{
    private long id;
    private ArrayList<SoftwareEntity> softwares;
    private LaboratorioEntity laboratorio;
    private Calendar dataPedido;
    private situacaoInstalacaoEnum situacaoInstalacao;
    private boolean instalado;
    private ServidorEntity solicitante, concluinte;

    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isInstalado() {
        return instalado;
    }

    public void setInstalado(boolean instalado) {
        this.instalado = instalado;
    }
    public ArrayList<SoftwareEntity> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(ArrayList<SoftwareEntity> softwares) {
        this.softwares = softwares;
    }

    public LaboratorioEntity getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(LaboratorioEntity laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public situacaoInstalacaoEnum getSituacaoInstalacao() {
        return situacaoInstalacao;
    }

    public void setSituacaoInstalacao(situacaoInstalacaoEnum situacaoInstalacao) {
        this.situacaoInstalacao = situacaoInstalacao;
    } 
        

    @Override
    public SolicitacaoSoftwareException validar() {
        return null;
    }

    public ServidorEntity getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(ServidorEntity solicitante) {
        this.solicitante = solicitante;
    }

    public ServidorEntity getConcluinte() {
        return concluinte;
    }

    public void setConcluinte(ServidorEntity concluinte) {
        this.concluinte = concluinte;
    }
    
    
}
