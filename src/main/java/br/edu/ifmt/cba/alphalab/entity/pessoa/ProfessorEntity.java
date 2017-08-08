package br.edu.ifmt.cba.alphalab.entity.pessoa;

import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.exception.ServidorException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class ProfessorEntity extends ServidorEntity {
	private Long id;
	private List<EnumDisciplina> disciplinas;

	public ProfessorEntity() {
	}

	public ProfessorEntity(Long id, String nome, String email, String telefone, String login, String senha,
			EnumTipoServidor tipo, DepartamentoEntity departamento, List<EnumDisciplina> disciplinas) {
		super(id, nome, email, telefone, login, senha, tipo, departamento);
		this.id = id;
		this.disciplinas = disciplinas;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the disciplinas
	 */
	public List<EnumDisciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * @param disciplinas
	 *            the disciplinas to set
	 */
	public void setDisciplinas(List<EnumDisciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public ServidorException validar() {
		return null;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
}