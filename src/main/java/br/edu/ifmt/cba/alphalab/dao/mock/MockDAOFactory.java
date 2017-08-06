package br.edu.ifmt.cba.alphalab.dao.mock;

import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.IClienteDAO;
import br.edu.ifmt.cba.alphalab.dao.IDepartamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.IEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.ILaboratorioDAO;
import br.edu.ifmt.cba.alphalab.dao.IProfessorDAO;
import br.edu.ifmt.cba.alphalab.dao.IRequisitoDAO;
import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.dao.IServidorDAO;
import br.edu.ifmt.cba.alphalab.dao.ISoftwareDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.equipamentos.MockEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockDepartamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockLaboratorioDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockRequisitoDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockReservaDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.software.MockSoftwareDAO;

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

	@Override
	public IReservaDAO getReservaDAO() {
		return MockReservaDAO.getInstance();
	}

	@Override
	public ISoftwareDAO getSoftwareDAO() {
		return MockSoftwareDAO.getInstance();
	}

	@Override
	public IRequisitoDAO getRequisitoDAO() {
		return MockRequisitoDAO.getInstance();
	}

	@Override
	public ILaboratorioDAO getLaboratorioDAO() {
		return MockLaboratorioDAO.getInstance();
	}

	@Override
	public IEquipamentoDAO getEquipamentoDAO() {
		return MockEquipamentoDAO.getInstance();
	}

	@Override
	public IServidorDAO getServidorDAO() {
		return MockServidorDAO.getInstance();
	}

	/*
	 * @Override public boolean isSessionClosed() { return false; }
	 * 
	 * @Override public void closeSession() {
	 * 
	 * }
	 */
}