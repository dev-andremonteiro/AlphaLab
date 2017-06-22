package br.edu.ifmt.cba.alphalab.dao;

import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.ClienteEntity;

public interface IClienteDAO extends IDAO<ClienteEntity>{
		
	List<ClienteEntity> getByNome(String nome);
	
}
