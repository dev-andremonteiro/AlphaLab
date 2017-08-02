package br.edu.ifmt.cba.alphalab.dao.mock;

import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.IClienteDAO;
import br.edu.ifmt.cba.alphalab.dao.IDepartamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.IProfessorDAO;
import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockDepartamentoDAO;

public class MockDAOFactory implements DAOFactory {

	private static MockDAOFactory factory = null;

	public static MockDAOFactory getInstance() {
		if (factory == null)
			factory = new MockDAOFactory();
		return factory;
	}

	@Override
	public IDepartamentoDAO getDepartamentoDAO() {
		return MockDepartamentoDAO.getInstance();
	}

	@Override
	public IClienteDAO getClienteDAO() {
		return MockClienteDAO.getInstance();
	}
	/*
	 * @Override public boolean isSessionClosed() { return false; }
	 * 
	 * @Override public void closeSession() {
	 * 
	 * }
	 */

	@Override
	public IProfessorDAO getProfessorDAO() {
		return null;
	}

	@Override
	public IReservaDAO getReservaDAO() {
		return null;
	}
}