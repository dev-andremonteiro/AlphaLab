package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.EmprestimoException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import java.util.Date;

public class EmprestimoEntity implements IEntity<EmprestimoException> {

    private Long id;

    private Enum status;

    private Date dataSolicitacao;

    private Date dataEmprestimo;

    private String observacaoEmprestimo;

    private Date dataDevolucao;

    private String observacaoDevolucao;

    private ArrayList<RecursoEntity> recursos;

    private ServidorEntity solicitante;

    private ServidorEntity aprovador;

    private ServidorEntity recebedor;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public EmprestimoException validar() {
        return null;
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

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getObservacaoEmprestimo() {
        return observacaoEmprestimo;
    }

    public void setObservacaoEmprestimo(String observacaoEmprestimo) {
        this.observacaoEmprestimo = observacaoEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getObservacaoDevolucao() {
        return observacaoDevolucao;
    }

    public void setObservacaoDevolucao(String observacaoDevolucao) {
        this.observacaoDevolucao = observacaoDevolucao;
    }

    public ArrayList<RecursoEntity> getRecursos() {
        return recursos;
    }

    public void setRecursos(ArrayList<RecursoEntity> recursos) {
        this.recursos = recursos;
    }

    public ServidorEntity getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(ServidorEntity solicitante) {
        this.solicitante = solicitante;
    }

    public ServidorEntity getAprovador() {
        return aprovador;
    }

    public void setAprovador(ServidorEntity aprovador) {
        this.aprovador = aprovador;
    }

    public ServidorEntity getRecebedor() {
        return recebedor;
    }

    public void setRecebedor(ServidorEntity recebedor) {
        this.recebedor = recebedor;
    }

    

}
