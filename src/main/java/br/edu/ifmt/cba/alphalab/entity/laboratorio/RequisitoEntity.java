package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import java.util.ArrayList;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.RequisitoException;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;

public class RequisitoEntity implements IEntity<RequisitoException> {

	private Long id;

	private int qtdAlunos;

	private ArrayList<SoftwareEntity> softwares;

	public RequisitoEntity(Long id, int qtdAlunos, ArrayList<SoftwareEntity> softwares) {
		super();
		this.id = id;
		this.qtdAlunos = qtdAlunos;
		this.softwares = softwares;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public RequisitoException validar() {
		StringBuilder msg = new StringBuilder();
		if (qtdAlunos <= 0)
			msg.append("Quantidade de alunos inválida!\n");

		if (msg.length() > 0)
			return new RequisitoException(msg.toString());
		else
			return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtdAlunos() {
		return qtdAlunos;
	}

	public void setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public ArrayList<SoftwareEntity> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(ArrayList<SoftwareEntity> softwares) {
		this.softwares = softwares;
	}
}
