package br.edu.ifmt.cba.alphalab.business;

import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.IServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.exception.ServidorException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

public class Servidor extends ABusiness<ServidorEntity, ServidorException, IServidorDAO> {

	public Servidor(IDAO<ServidorEntity> dao) {
		super(dao);
	}

	public ServidorEntity getByID(Long id) {
		return ((IServidorDAO) dao).getById(id);
	}

	public List<ServidorEntity> buscarTodosServidores() {
		return ((IServidorDAO) dao).buscarTodosServidores();
	}

	public List<ServidorEntity> getByNome(String nome) {
		return ((IServidorDAO) dao).getByNome(nome);
	}
}