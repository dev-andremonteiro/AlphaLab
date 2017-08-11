package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.EmprestimoException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import java.util.Date;

public class EmprestimoEntity implements IEntity<EmprestimoException> {

    private Long id;

    private EnumEmprestimo status;

    private Date dataSolicitacao;

    private Date dataEmprestimo;

    private String observacaoEmprestimo;

    private Date dataDevolucao;

    private String observacaoDevolucao;

    private ArrayList<EquipamentoEntity> recursos;

    private ServidorEntity solicitante;

    private ServidorEntity aprovador;

    private ServidorEntity recebedor;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public EmprestimoException validar() {
        StringBuilder msg = new StringBuilder();
        
        
        if (this.solicitante==null && this.status.PEDIDO==EnumEmprestimo.PEDIDO){
            msg.append("Precisa informar servidor solicitante");
        }
        
        if (this.aprovador==null && this.status.EMPRESTADO==EnumEmprestimo.EMPRESTADO){
            msg.append("Precisa informar servidor aprovador");
        }
        
        if (this.recebedor==null && this.status.DEVOLVIDO==EnumEmprestimo.DEVOLVIDO){
            msg.append("Precisa informar servidor recebedor");
        }
        
        if (dataSolicitacao == null && this.status.PEDIDO==EnumEmprestimo.PEDIDO){
           msg.append("Data de solicitação do recurso deve ser informada!\n");   
        }
        
        if (dataEmprestimo == null && this.status.EMPRESTADO==EnumEmprestimo.EMPRESTADO){
           msg.append("Data do emprestimo do recurso deve ser informada!\n");   
        }
        
         if (dataDevolucao == null && this.status.DEVOLVIDO==EnumEmprestimo.DEVOLVIDO){
           msg.append("Data de devolução do recurso deve ser informada!\n");   
        }
        
        
       
        
        
        
        
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumEmprestimo getStatus() {
		return status;
	}

     public void setStatus(EnumEmprestimo status) {
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

    public ArrayList<EquipamentoEntity> getRecursos() {
        return recursos;
    }

    public void setRecursos(ArrayList<EquipamentoEntity> recursos) {
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
