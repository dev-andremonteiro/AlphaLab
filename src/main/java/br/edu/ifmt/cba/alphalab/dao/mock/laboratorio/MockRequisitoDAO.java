package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IRequisitoDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;

public class MockRequisitoDAO implements IRequisitoDAO {

	private static MockRequisitoDAO singleton = null;

	private MockRequisitoDAO(){	}

	public static MockRequisitoDAO getInstance() {
		if (singleton == null)
			singleton = new MockRequisitoDAO();

		return singleton;
	}

	@Override
	public void save(RequisitoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(RequisitoEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public RequisitoEntity getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
