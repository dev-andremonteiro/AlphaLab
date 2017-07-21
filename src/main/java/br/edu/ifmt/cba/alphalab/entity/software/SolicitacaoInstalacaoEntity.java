/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.entity.software;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.SoftwareException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author tcloss
 */
public class SolicitacaoInstalacaoEntity implements IEntity<SolicitacaoInstalacaoEntity>{
    private long id;
    private ArrayList<SoftwareEntity> softwaresPendendtes, softwaresInstalados;
    private LaboratorioEntity laboratorio;
    private Calendar dataPedido;
    private SituacaoInstalacaoEnum situacaoInstalacao;
    private ServidorEntity solicitante, concluinte;

    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public SituacaoInstalacaoEnum getSituacaoInstalacao() {
        return situacaoInstalacao;
    }

    public void setSituacaoInstalacao(SituacaoInstalacaoEnum situacaoInstalacao) {
        this.situacaoInstalacao = situacaoInstalacao;
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

    public ArrayList<SoftwareEntity> getSoftwaresPendendtes() {
        return softwaresPendendtes;
    }

    public void setSoftwaresPendendtes(ArrayList<SoftwareEntity> softwaresPendendtes) {
        this.softwaresPendendtes = softwaresPendendtes;
    }

    public ArrayList<SoftwareEntity> getSoftwaresInstalados() {
        return softwaresInstalados;
    }

    public void setSoftwaresInstalados(ArrayList<SoftwareEntity> softwaresInstalados) {
        this.softwaresInstalados = softwaresInstalados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.laboratorio);
        hash = 71 * hash + Objects.hashCode(this.dataPedido);
        hash = 71 * hash + Objects.hashCode(this.solicitante);
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
        final SolicitacaoInstalacaoEntity other = (SolicitacaoInstalacaoEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.laboratorio, other.laboratorio)) {
            return false;
        }
        if (!Objects.equals(this.dataPedido, other.dataPedido)) {
            return false;
        }
        if (!Objects.equals(this.solicitante, other.solicitante)) {
            return false;
        }
        return true;
    }

    @Override
    public SolicitacaoInstalacaoEntity validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
