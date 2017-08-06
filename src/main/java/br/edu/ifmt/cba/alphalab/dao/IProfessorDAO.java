package br.edu.ifmt.cba.alphalab.dao;

import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.pessoa.ProfessorEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public interface IProfessorDAO extends IDAO<ProfessorEntity> {
	List<ProfessorEntity> getByNome(String nome);

	List<ProfessorEntity> buscarTodos();
}