package br.edu.ifmt.cba.alphalab.entity.software;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.SoftwareException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;

public class SoftwareEntity implements IEntity<SoftwareException> {

    private Long id;
    private String descricao;
    private TipoSoftwareEnum tipo;
    private String versao;
    private String link;
    private String observacaoInstalacao;
    private ServidorEntity solicitante;
    private ServidorEntity concluinte;
    
    public SoftwareEntity(String descricao, TipoSoftwareEnum tipo, String versao, String link, String observacaoInstalacao, ServidorEntity solicitante) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.versao = versao;
        this.link = link;
        this.observacaoInstalacao = observacaoInstalacao;
        this.solicitante = solicitante;
    }

    public SoftwareEntity() {
       
    }
       
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public SoftwareException validar() {
       StringBuilder msg = new StringBuilder();
        if(descricao.trim().length()==0) msg.append("Descricao nao pode ser vazio\n");
        
        if( msg.length() >0) {
            return new SoftwareException(msg.toString());
        }
        else{
            return null;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public TipoSoftwareEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoSoftwareEnum tipo) {
        this.tipo = tipo;
    }

    public String getObservacaoInstalacao() {
        return observacaoInstalacao;
    }

    public void setObservacaoInstalacao(String observacaoInstalacao) {
        this.observacaoInstalacao = observacaoInstalacao;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
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
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + Objects.hashCode(this.tipo);
        hash = 53 * hash + Objects.hashCode(this.versao);
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
        final SoftwareEntity other = (SoftwareEntity) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.versao, other.versao)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }
    

}
