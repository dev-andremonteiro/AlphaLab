package br.edu.ifmt.cba.alphalab.dao.mock;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IClienteDAO;
import br.edu.ifmt.cba.alphalab.entity.ClienteEntity;

public class MockClienteDAO implements IClienteDAO {
	
	private static List<ClienteEntity> clientes = new ArrayList<>();
	
	static {
		clientes.add(new ClienteEntity(1L,"JOAO PAULO","jppreti@gmail.com","6581232323"));
		clientes.add(new ClienteEntity(1L,"MARIA CRISTINA","mariac@terra.com.br","6612345678"));
		clientes.add(new ClienteEntity(1L,"JOSE PEDRO","jose.pedro@microsoft.com","8343214321"));
		clientes.add(new ClienteEntity(1L,"ANA PAULA","anapaula@hotmail.com","1122223333"));
		clientes.add(new ClienteEntity(1L,"CRISTIANE","cristiane@ifmt.edu.br","2167891234"));
	}
	
	private static MockClienteDAO singleton = null;
	
	private MockClienteDAO(){	}
	
	public static MockClienteDAO getInstance() {
		if (singleton == null)
			singleton = new MockClienteDAO();
		
		return singleton;
	}
	
	@Override
	public void save(ClienteEntity entity) {
		if (clientes.indexOf(entity)<0)
			clientes.add(entity);
	}

	@Override
	public void delete(ClienteEntity entity) {
		clientes.remove(entity);
	}

	@Override
	public ClienteEntity getById(Long id) {
		for (ClienteEntity vo : clientes)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public List<ClienteEntity> getByNome(String nome) {
		ArrayList<ClienteEntity> resultado = new ArrayList<>();
		for (ClienteEntity vo : clientes)
			if (vo.getNome().toUpperCase().contains(nome.toUpperCase()))
				resultado.add(vo);		
		return resultado;
	}

}
