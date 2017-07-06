package br.edu.ifmt.cba.alphalab.entity.software;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.ClienteException;
import br.edu.ifmt.cba.alphalab.entity.exception.SoftwareException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

public class SoftwareEntity implements IEntity<SoftwareException> {

    private Long id;

    private Enum status;

    private String descricao;

    private String link;

    private Enum tipo;

    private String observacao_Instalacao;

    private String versao;

    private ServidorEntity solicitante;

    private ServidorEntity concluinte;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public SoftwareException validar() {
       StringBuilder msg = new StringBuilder();
        if(descricao.equals(" ")) msg.append("Descricao nao pode ser vazio\n");
        
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

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
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

    public Enum getTipo() {
        return tipo;
    }

    public void setTipo(Enum tipo) {
        this.tipo = tipo;
    }

    public String getObservacao_Instalacao() {
        return observacao_Instalacao;
    }

    public void setObservacao_Instalacao(String observacao_Instalacao) {
        this.observacao_Instalacao = observacao_Instalacao;
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
}
