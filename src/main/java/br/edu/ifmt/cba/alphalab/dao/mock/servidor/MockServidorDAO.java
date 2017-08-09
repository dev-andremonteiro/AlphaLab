package br.edu.ifmt.cba.alphalab.dao.mock.servidor;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IServidorDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockDepartamentoDAO;
import br.edu.ifmt.cba.alphalab.entity.pessoa.EnumTipoServidor;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockServidorDAO implements IServidorDAO {
	private static List<ServidorEntity> servidores = new ArrayList<>();

	private static MockServidorDAO singleton = null;

	private static MockDepartamentoDAO departamentoDAO = new MockDepartamentoDAO();

	public static final ServidorEntity servidor1 = new ServidorEntity();
	public static final ServidorEntity servidor2 = new ServidorEntity();
	public static final ServidorEntity servidor3 = new ServidorEntity();
	public static final ServidorEntity servidor4 = new ServidorEntity();

	static {
		servidor1.setId(1L);
		servidor1.setNome("Augusto Oliveira da Silva");
		servidor1.setEmail("augustocesar.oliveira@cba.ifmt.edu.br");
		servidor1.setTelefone("(65) 9 8455-2211");
		servidor1.setLogin("augustocesar.oliveira@cba.ifmt.edu.br");
		servidor1.setSenha("kim123");
		servidor1.setTipo(EnumTipoServidor.TEC_LABORATORIO);
		servidor1.setDepartamento(departamentoDAO.getById((long) 1));

		servidor2.setId(2L);
		servidor2.setNome("Silvano Sales Costa");
		servidor2.setEmail("silvano.sales@cba.ifmt.edu.br");
		servidor2.setTelefone("(65) 9 8435-4251");
		servidor2.setLogin("silvano.sales");
		servidor2.setSenha("trump000");
		servidor2.setTipo(EnumTipoServidor.ESTAGIARIO);
		servidor2.setDepartamento(departamentoDAO.getById((long) 2));

		servidor3.setId(3L);
		servidor3.setNome("Aline Rubens Pires");
		servidor3.setEmail("alinerp@cba.ifmt.edu.br");
		servidor3.setTelefone("(65) 9 8415-2234");
		servidor3.setLogin("alinerp");
		servidor3.setSenha("kassiko");
		servidor3.setTipo(EnumTipoServidor.TEC_ADM);
		servidor3.setDepartamento(departamentoDAO.getById((long) 3));

		servidor4.setId(4L);
		servidor4.setNome("Samara Monteiro Lobato");
		servidor4.setEmail("samaraml@cba.ifmt.edu.br");
		servidor4.setTelefone("(65) 9 9495-2816");
		servidor4.setLogin("samaraml");
		servidor4.setSenha("2@@0box");
		servidor4.setTipo(EnumTipoServidor.PROFESSOR);
		servidor4.setDepartamento(departamentoDAO.getById((long) 4));

		servidores.add(servidor1);
		servidores.add(servidor2);
		servidores.add(servidor3);
		servidores.add(servidor4);
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
			if (vo.getNome().toUpperCase().contains(nome.toUpperCase())) {
				System.out.println(vo.getNome());
				resultado.add(vo);
			}

		return resultado;
	}

	@Override
	public List<ServidorEntity> buscarTodosServidores() {
		return servidores;
	}

	@Override
	public List<ServidorEntity> buscarTodosProfessores() {
		List<ServidorEntity> resultado = new ArrayList<>();
		for (ServidorEntity vo : servidores) {
			if (vo.getTipo().equals(EnumTipoServidor.PROFESSOR))
				resultado.add(vo);
		}
		return resultado;
	}
}