package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.ReservaException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

public class ReservaEntity implements IEntity<ReservaException> {

	private Long id;

	private EnumReserva status;

	private Date dataSolicitacao;

	private EnumDisciplina disciplina;

	private String turma;

	private String observacao;

	private EnumTipoReserva tipo;

	private Date dataInicio;

	private Date dataFim;

	private Date dataAprovacaoRecusa;

	private String justificativa;

	private LaboratorioEntity laboratorio;

	private DepartamentoEntity departamentoAula;

	private ServidorEntity solicitante;

	private ServidorEntity aprovador;

	private ArrayList<Horario> horarios;
	// TODO Esse atributo deveria ser um único RequisitoEntity, não List
	private RequisitoEntity requisitos;

	public ReservaEntity() {
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnumReserva getStatus() {
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

	public EnumDisciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(EnumDisciplina disciplina) {
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

	/**
	 * @return the tipo
	 */
	public EnumTipoReserva getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(EnumTipoReserva tipo) {
		this.tipo = tipo;
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

	public RequisitoEntity getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(RequisitoEntity requisitos) {
		this.requisitos = requisitos;
	}

	public ArrayList<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<Horario> horarios) {
		this.horarios = horarios;
	}

	@Override
	public ReservaException validar() {
		StringBuilder msg = new StringBuilder();
		if (status == null)
			msg.append("Status da reserva deve ser informado!\n");

		if (dataSolicitacao == null)
			msg.append("Data de solicitação da reserva deve ser informada!\n");

		if (departamentoAula == null)
			msg.append("Departamento da aula deve ser informado!\n");

		if (dataInicio == null)
			msg.append("Data de início da reserva deve ser informada!\n");

		if (dataFim == null)
			msg.append("Data final da reserva deve ser informada!\n");

		if (solicitante == null)
			msg.append("O solicitante deve ser informada!\n");

		if (horarios.isEmpty())
			msg.append("O horário de reserva deve ser informado!\n");

		if (disciplina == null)
			msg.append("É obrigatório escolher uma disciplina!\n");
		/*
		 * if (disciplina != null && (disciplina.trim().length() < 5 ||
		 * disciplina.trim().length() > 50)) msg.append(
		 * "Nome da disciplina deve possuir entre 5 e 50 caracteres!\n");
		 */

		if (turma == null || turma.trim().length() == 0)
			msg.append("Nome da turma é obrigatório!\n");
		if (turma != null && (turma.trim().length() < 5 || turma.trim().length() > 50))
			msg.append("Nome da turma deve possuir entre 5 e 50 caracteres!\n");

		if (observacao != null && observacao.trim().length() > 200)
			msg.append("Observação deve possuir no máximo 200 caracteres!\n");

		if (status == EnumReserva.CONFIRMADO && laboratorio == null)
			msg.append("O laboratorio deve ser informado!\n");

		if ((status == EnumReserva.CONFIRMADO || status == EnumReserva.RECUSADO) && aprovador == null)
			msg.append("O aprovador deve ser informado!\n");

		if (status == EnumReserva.RECUSADO && (justificativa == null || justificativa.trim().length() == 0))
			msg.append("Justificativa deve ser informada!\n");
		if (status == EnumReserva.RECUSADO
				&& (justificativa != null && (justificativa.trim().length() < 5 || justificativa.trim().length() > 50)))
			msg.append("A justificativa deve possuir entre 5 e 50 caracteres!\n");

		if ((status == EnumReserva.CONFIRMADO || status == EnumReserva.RECUSADO) && dataAprovacaoRecusa == null)
			msg.append("Data de Aprovação ou Recusa deve ser informada!\n");

		if ((status == EnumReserva.CONFIRMADO || status == EnumReserva.RECUSADO)
				&& (dataAprovacaoRecusa != null && dataAprovacaoRecusa.before(dataSolicitacao)))
			msg.append("Data de Aprovação ou Recusa deve ser maior do que a data de solicitação!\n");

		if (dataInicio != null && dataFim != null && dataInicio.before(dataFim))
			msg.append("Data de início precisa ser menor que a data de final da reserva");

		if (msg.length() > 0)
			return new ReservaException(msg.toString());
		else
			return null;
	}
}