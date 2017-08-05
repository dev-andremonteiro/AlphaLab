package br.edu.ifmt.cba.alphalab.business;

import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.entity.exception.ReservaException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;

public class Reserva extends ABusiness<ReservaEntity, ReservaException, IReservaDAO> {

	public Reserva(IDAO<ReservaEntity> dao) {
		super(dao);
	}

	public ReservaEntity getByID(Long id) {
		return ((IReservaDAO) dao).getById(id);
	}

	public List<ReservaEntity> getByNome(String nome) {
		return ((IReservaDAO) dao).getByNome();
	}

	public List<ReservaEntity> buscarTodasReservas() {
		return ((IReservaDAO) dao).buscarTodasReservas();

	}
}