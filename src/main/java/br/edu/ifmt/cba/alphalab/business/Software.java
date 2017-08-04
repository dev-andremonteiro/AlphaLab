package br.edu.ifmt.cba.alphalab.business;

import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.ISoftwareDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.software.MockSoftwareDAO;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import javafx.util.Callback;

/**
 * 
 * @author Stévillis
 *
 */

public class Software extends ABusiness<SoftwareEntity, Exception, ISoftwareDAO> {
	public Software(IDAO<SoftwareEntity> dao) {
		super(dao);
	}

	public List<SoftwareEntity> buscarTodosSoftwares() {
		return ((ISoftwareDAO) dao).buscarTodos();
	}
	public List<SoftwareEntity> getByNome(String nome) {
		return MockSoftwareDAO.getInstance().getByNome(nome);
	}

	/*public List<SoftwareEntity> getByNome(String nome) {
		return ((ISoftwareDAO) dao).getByNome(nome);
	}*/
}