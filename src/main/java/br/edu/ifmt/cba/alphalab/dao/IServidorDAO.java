package br.edu.ifmt.cba.alphalab.dao;

import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

/**
 * 
 * @author StÚvillis Sousa
 *
 */
public interface IServidorDAO extends IDAO<ServidorEntity> {
	public List<ServidorEntity> buscarTodos(String nome);
}