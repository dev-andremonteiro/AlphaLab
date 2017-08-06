package br.edu.ifmt.cba.alphalab.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import br.edu.ifmt.cba.alphalab.dao.mock.MockDAOFactory;

public interface DAOFactory {
	public static Properties props = new Properties();

	public abstract IDepartamentoDAO getDepartamentoDAO();

	public abstract IClienteDAO getClienteDAO();

	public abstract IReservaDAO getReservaDAO();

	public abstract ISoftwareDAO getSoftwareDAO();

	public abstract IRequisitoDAO getRequisitoDAO();

	public abstract ILaboratorioDAO getLaboratorioDAO();

	public abstract IEquipamentoDAO getEquipamentoDAO();

	public abstract IServidorDAO getServidorDAO();

	public abstract IProfessorDAO getProfessorDAO();

	public static DAOFactory getDAOFactory() {
		if (props.isEmpty()) {
			try {
				FileInputStream file = new FileInputStream(
						DAOFactory.class.getClassLoader().getResource("datasource.properties").getPath());
				props.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			props.getProperty("datasource");
		}

		DAOFactoryEnum datasource = DAOFactoryEnum.valueOf(props.getProperty("datasource"));
		switch (datasource) {
		case MOCK:
			return MockDAOFactory.getInstance();
		/*
		 * case JPA: return JPADAOFactory.getInstance(); case XML: return
		 * XMLDAOFactory.getInstance();
		 */
		default:
			return null;
		}
	}
	// public abstract boolean isSessionClosed();
	// public abstract void closeSession();
}