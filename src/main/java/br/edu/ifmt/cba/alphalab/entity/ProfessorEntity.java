package br.edu.ifmt.cba.alphalab.entity;

import java.util.List;

import br.edu.ifmt.cba.alphalab.business.Disciplina;
import br.edu.ifmt.cba.alphalab.business.laboratorio.Departamento;
import br.edu.ifmt.cba.alphalab.entity.exception.ProfessorException;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class ProfessorEntity implements IEntity<ProfessorException> {
	private String nome;
	private Departamento departamento;
	private List<Disciplina> listDisciplina;

	public ProfessorEntity() {
	}

	public ProfessorEntity(String nome, Departamento departamento, List<Disciplina> listDisciplina) {
		super();
		this.nome = nome;
		this.departamento = departamento;
		this.listDisciplina = listDisciplina;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento
	 *            the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the disciplina
	 */
	public List<Disciplina> getDisciplina() {
		return listDisciplina;
	}

	/**
	 * @param disciplina
	 *            the disciplina to set
	 */
	public void setDisciplina(List<Disciplina> listDisciplina) {
		this.listDisciplina = listDisciplina;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorEntity other = (ProfessorEntity) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public ProfessorException validar() {
		StringBuilder msg = new StringBuilder();

		if (nome == null || nome.trim().length() == 0)
			msg.append("Nome têm preenchimento obrigatório!\n");
		/*if (departamento.getNomeDepartamento != null && departamento.getNomeDepartamento.length() < 3)
			msg.append("Nome do departamento têm preenchimento obrigatório!\n");
		if (listDisciplinha.isEmpty())
			msg.append("O professor precisa ter pelo menos uma Disciplina!\n");
		*/

		if (msg.length() > 0)
			return new ProfessorException(msg.toString());
		else
			return null;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
