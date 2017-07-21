package br.edu.ifmt.cba.alphalab.dao.mock.servidor;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IServidorDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.EnumTipoServidor;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockDepartamentoDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockServidorDAO implements IServidorDAO {
	private static List<ServidorEntity> servidores = new ArrayList<>();
	private static MockServidorDAO singleton = null;
	private static final ServidorEntity servidor1 = new ServidorEntity();

	static {
		servidor1.setId(1L);
		servidor1.setNome("Augusto César de Olivera");
		servidor1.setEmail("augustocesar.oliveira@cba.ifmt.edu.br");
		servidor1.setTelefone("(65) 9 8455-2211");
		servidor1.setLogin("augustocesar.oliveira@cba.ifmt.edu.br");
		servidor1.setSenha("kjs8@11");
		servidor1.setTipo(EnumTipoServidor.PROFESSOR);
		servidor1.setDepartamento((DepartamentoEntity) MockDepartamentoDAO.getInstance().buscarTodos().toArray()[0]);

		servidores.add(servidor1);
	}

	public MockServidorDAO() {
	}

	public static MockServidorDAO getInstance() {
		if (singleton == null)
			singleton = new MockServidorDAO();

		return singleton;
	}

	@Override
	public void save(ServidorEntity entity) {
		if (servidores.indexOf(entity) < 0)
			servidores.add(entity);
	}

	@Override
	public void delete(ServidorEntity entity) {
		servidores.remove(entity);
	}

	@Override
	public ServidorEntity getById(Long id) {
		for (ServidorEntity vo : servidores)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public List<ServidorEntity> getByNome(String nome) {
		ArrayList<ServidorEntity> resultado = new ArrayList<>();
		for (ServidorEntity vo : servidores)
			if (vo.getNome().toUpperCase().contains(nome.toUpperCase()))
				resultado.add(vo);

		return resultado;
	}
}