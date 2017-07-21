package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.ReservaException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import java.util.Date;

public class ReservaEntity implements IEntity<ReservaException> {

    private Long id;

    private EnumReserva status;

    private Date dataSolicitacao;

    private String disciplina;

    private String turma;

    private String observacao;

    private boolean fixo;

    private Date dataInicio;

    private Date dataFim;

    private Date dataAprovacaoRecusa;

    private String justificativa;

    private LaboratorioEntity laboratorio;

    private DepartamentoEntity departamentoAula;

    private ServidorEntity solicitante;

    private ServidorEntity aprovador;

    private ArrayList<RequisitoEntity> requisitos;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(EnumReserva status) {
        this.status = status;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isFixo() {
        return fixo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataAprovacaoRecusa() {
        return dataAprovacaoRecusa;
    }

    public void setDataAprovacaoRecusa(Date dataAprovacaoRecusa) {
        this.dataAprovacaoRecusa = dataAprovacaoRecusa;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public LaboratorioEntity getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(LaboratorioEntity laboratorio) {
        this.laboratorio = laboratorio;
    }

    public DepartamentoEntity getDepartamentoAula() {
        return departamentoAula;
    }

    public void setDepartamentoAula(DepartamentoEntity departamentoAula) {
        this.departamentoAula = departamentoAula;
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

    public ArrayList<RequisitoEntity> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(ArrayList<RequisitoEntity> requisitos) {
        this.requisitos = requisitos;
    }
    
    
    @Override
    public ReservaException validar() {
        return null;
    }   
}
