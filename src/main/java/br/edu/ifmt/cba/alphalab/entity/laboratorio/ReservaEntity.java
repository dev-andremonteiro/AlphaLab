package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import java.util.ArrayList;
import java.util.Date;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.ReservaException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

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
		StringBuilder msg = new StringBuilder();
		if (status == null)
			msg.append("Status do laboratório deve ser informado!\n");

		if (dataSolicitacao == null)
			msg.append("Data de solicitação da reserva deve ser informada!\n");

		if (disciplina == null || disciplina.trim().length() == 0)
			msg.append("Nome da disciplina é obrigatório!\n");
		if (disciplina != null || disciplina.trim().length() < 5)
			msg.append("Nome da disciplina deve possuir pelo menos 5 caracteres!\n");

		if (turma == null || turma.trim().length() == 0)
			msg.append("Nome da turma é obrigatório!\n");
		if (turma != null || turma.trim().length() < 6)
			msg.append("Nome da turma deve possuir pelo menos 6 caracteres!\n");

		if (observacao != null || observacao.trim().length() < 10)
			msg.append("Observação deve possuir pelo menos 10 caracteres!\n");

		if (dataInicio == null)
			msg.append("Data de início da reserva deve ser informada!\n");

		if (dataFim == null)
			msg.append("Data final da reserva deve ser informada!\n");

		if (dataInicio != null && dataFim != null) {
			if (dataInicio.before(dataFim)) {
				msg.append("Data de início precisa ser menor que a data de final da reserva");
			}
		}

		if (dataAprovacaoRecusa == null)
			msg.append("Data de Aprovação ou Recusa deve ser informada!\n");

		if (justificativa != null || justificativa.trim().length() < 10)
			msg.append("Justificativa deve possuir pelo menos 10 caracteres!\n");

		if (laboratorio == null)
			msg.append("Laboratório precisa ser informado!\n");

		if (departamentoAula == null)
			msg.append("Departamento precisa ser informado!\n");

		if (solicitante == null)
			msg.append("Servidor solicitante da reserva precisa ser informado!\n");

		if (aprovador == null)
			msg.append("Servidor aprovador da reserva precisa ser informado!\n");

		if (msg.length() > 0)
			return new ReservaException(msg.toString());
		else
			return null;
	}
}