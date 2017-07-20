package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockReservaDAO implements IReservaDAO {
	private static List<ReservaEntity> reservas = new ArrayList<>();
	private static MockReservaDAO singleton = null;

	static {
		//
	}

	private MockReservaDAO() {
	}

	public static MockReservaDAO getInstance() {
		if (singleton == null)
			singleton = new MockReservaDAO();

		return singleton;
	}

	@Override
	public void save(ReservaEntity entity) {
		// Verifica se a reserva já foi realizada.
		if (reservas.indexOf(entity) < 0) {
			reservas.add(entity);
		}
	}

	@Override
	public void delete(ReservaEntity entity) {
		reservas.remove(entity);
	}

	@Override
	public ReservaEntity getById(Long id) {
		// Percorre a lista à procura de uma Reserva.
		for (ReservaEntity vo : reservas)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public List<ReservaEntity> buscarTodos() {
		return reservas;
	}
}
