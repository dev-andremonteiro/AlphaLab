package br.edu.ifmt.cba.alphalab.business;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.entity.exception.ReservaException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumTipoReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.EnumTipoServidor;

public class Reserva extends ABusiness<ReservaEntity, ReservaException, IReservaDAO> {

	public Reserva(IDAO<ReservaEntity> dao) {
		super(dao);
	}

	public ReservaEntity getByID(Long id) {
		return ((IReservaDAO) dao).getById(id);
	}

	public List<ReservaEntity> buscarTodasReservas() {
		return ((IReservaDAO) dao).buscarTodasReservas();
	}

	public List<ReservaEntity> getByData(Date data) {
		return ((IReservaDAO) dao).getByData(data);
	}

	public List<ReservaEntity> getAtivosNoDia(LocalDate data) {
		return ((IReservaDAO) dao).getAtivosNoDia(data);
	}

	public List<ReservaEntity> getAtivosNaSemana(LocalDate data) {
		return ((IReservaDAO) dao).getAtivosNaSemana(data);
	}

	public List<ReservaEntity> getByTipo(EnumTipoReserva enumTipoReserva) {
		return ((IReservaDAO) dao).getByTipo(enumTipoReserva);
	}

	public List<ReservaEntity> getByServidor(EnumTipoServidor enumTipoServidor) {
		return ((IReservaDAO) dao).getByServidor(enumTipoServidor);
	}
}