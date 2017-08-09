package br.edu.ifmt.cba.alphalab.dao;

import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */
public interface IServidorDAO extends IDAO<ServidorEntity> {
	public List<ServidorEntity> getByNome(String nome);

	public List<ServidorEntity> buscarTodosServidores();
	
	public List<ServidorEntity> buscarTodosProfessores();
}