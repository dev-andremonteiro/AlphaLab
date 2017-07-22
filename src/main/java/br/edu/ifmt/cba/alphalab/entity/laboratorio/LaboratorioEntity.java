package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.LaboratorioException;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import java.util.ArrayList;

public class LaboratorioEntity implements IEntity<LaboratorioException> {

	private Long id;

	private String nome;

	private Enum situacao;

	private int capacidade;

	private String observacao;

	private DepartamentoEntity departamento;

	private EquipamentoEntity equipamento;

	private ArrayList<SoftwareEntity> softwares;

	private ArrayList<EquipamentoEntity> equipamentos;

	public LaboratorioEntity() {
	}

	public LaboratorioEntity(Long id, String nome, Enum situacao, int capacidade, String observacao,
			DepartamentoEntity departamento, EquipamentoEntity equipamento, ArrayList<SoftwareEntity> softwares,
			ArrayList<EquipamentoEntity> equipamentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.situacao = situacao;
		this.capacidade = capacidade;
		this.observacao = observacao;
		this.departamento = departamento;
		this.equipamento = equipamento;
		this.softwares = softwares;
		this.equipamentos = equipamentos;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public LaboratorioException validar() {
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Enum getSituacao() {
		return situacao;
	}

	public void setSituacao(Enum situacao) {
		this.situacao = situacao;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public DepartamentoEntity getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoEntity departamento) {
		this.departamento = departamento;
	}

	public EquipamentoEntity getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(EquipamentoEntity equipamento) {
		this.equipamento = equipamento;
	}

	public ArrayList<SoftwareEntity> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(ArrayList<SoftwareEntity> softwares) {
		this.softwares = softwares;
	}

	public ArrayList<EquipamentoEntity> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(ArrayList<EquipamentoEntity> equipamentos) {
		this.equipamentos = equipamentos;
	}
}