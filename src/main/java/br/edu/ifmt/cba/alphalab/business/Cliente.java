package br.edu.ifmt.cba.alphalab.business;

import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IClienteDAO;
import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.entity.ClienteEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.ClienteException;

public class Cliente extends ABusiness<ClienteEntity, ClienteException, IClienteDAO> {

	public Cliente(IDAO<ClienteEntity> dao) {
		super(dao);
	}

	public List<ClienteEntity> getByNome(String nome){
		return ((IClienteDAO)dao).getByNome(nome);
	}
	
}
