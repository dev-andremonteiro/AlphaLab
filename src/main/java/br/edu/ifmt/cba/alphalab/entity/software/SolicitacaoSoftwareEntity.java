/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.entity.software;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.SolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author tcloss
 */
public class SolicitacaoSoftwareEntity implements IEntity<SolicitacaoSoftwareException>{
    private long id;
    private ArrayList<SoftwareSolicitacaoEntity> softwares;
    private LaboratorioEntity laboratorio;
    private Calendar dataPedido;
    private SituacaoSolicitacaoEnum situacaoSolicitacao;
    private ServidorEntity solicitante, concluinte;

    public SolicitacaoSoftwareEntity(ArrayList<SoftwareSolicitacaoEntity> softwares, LaboratorioEntity laboratorio, Calendar dataPedido, SituacaoSolicitacaoEnum situacaoSolicitacao, ServidorEntity solicitante, ServidorEntity concluinte) {
        this.softwares = softwares;
        this.laboratorio = laboratorio;
        this.dataPedido = dataPedido;
        this.situacaoSolicitacao = situacaoSolicitacao;
        this.solicitante = solicitante;
        this.concluinte = concluinte;
    }

    public SolicitacaoSoftwareEntity(long id, ArrayList<SoftwareSolicitacaoEntity> softwares, LaboratorioEntity laboratorio, Calendar dataPedido, SituacaoSolicitacaoEnum situacaoSolicitacao, ServidorEntity solicitante, ServidorEntity concluinte) {
        this.id = id;
        this.softwares = softwares;
        this.laboratorio = laboratorio;
        this.dataPedido = dataPedido;
        this.situacaoSolicitacao = situacaoSolicitacao;
        this.solicitante = solicitante;
        this.concluinte = concluinte;
    }

    public SolicitacaoSoftwareEntity(LaboratorioEntity laboratorio, Calendar dataPedido, ServidorEntity solicitante, ServidorEntity concluinte) {
        this.laboratorio = laboratorio;
        this.dataPedido = dataPedido;
        this.solicitante = solicitante;
        this.concluinte = concluinte;
    }

    public SolicitacaoSoftwareEntity() {
        softwares=new ArrayList<>();
    }

    
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<SoftwareSolicitacaoEntity> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(ArrayList<SoftwareSolicitacaoEntity> softwares) {
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

    public SituacaoSolicitacaoEnum getSituacaoInstalacao() {

        return situacaoSolicitacao;
    }

    public void setSituacaoInstalacao(SituacaoSolicitacaoEnum situacaoSolicitacao) {
        this.situacaoSolicitacao = situacaoSolicitacao;
    }
    public void addSoftware(SoftwareSolicitacaoEntity softwareSolicitacaoEntity){
        if(!this.softwares.contains(softwareSolicitacaoEntity)){
            this.softwares.add(softwareSolicitacaoEntity);
        }
        else{
            this.softwares.set(this.softwares.indexOf(softwareSolicitacaoEntity), softwareSolicitacaoEntity);
        }
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + Objects.hashCode(this.laboratorio);
        hash = 61 * hash + Objects.hashCode(this.dataPedido);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SolicitacaoSoftwareEntity other = (SolicitacaoSoftwareEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.laboratorio, other.laboratorio)) {
            return false;
        }
        if (!Objects.equals(this.dataPedido, other.dataPedido)) {
            return false;
        }
        return true;
    }
    
    
}
