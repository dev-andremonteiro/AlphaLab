package br.edu.ifmt.cba.alphalab.entity.pessoa;

import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.Disciplina;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class ProfessorEntity extends ServidorEntity {
	private Long id;
	private List<Disciplina> disciplinas;

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
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * @param disciplinas
	 *            the disciplinas to set
	 */
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}