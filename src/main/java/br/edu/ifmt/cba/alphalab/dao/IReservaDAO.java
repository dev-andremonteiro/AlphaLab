package br.edu.ifmt.cba.alphalab.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumTipoReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.EnumTipoServidor;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public interface IReservaDAO extends IDAO<ReservaEntity> {

	public List<ReservaEntity> buscarTodasReservas();

	public List<ReservaEntity> getByData(Date data);

	public List<ReservaEntity> getAtivosNoDia(LocalDate data);

	public List<ReservaEntity> getAtivosNaSemana(LocalDate data);

	public List<ReservaEntity> getByTipo(EnumTipoReserva enumTipoReserva);

	public List<ReservaEntity> getByServidor(EnumTipoServidor enumTipoServidor);
}
