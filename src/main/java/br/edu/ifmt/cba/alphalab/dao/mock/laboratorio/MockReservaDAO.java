package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockReservaDAO implements IReservaDAO {
	public static List<ReservaEntity> reservas = new ArrayList<>();
	private static MockReservaDAO singleton = null;

	private static MockLaboratorioDAO laboratorio = new MockLaboratorioDAO();
	private static MockDepartamentoDAO departamento = new MockDepartamentoDAO();
	private static MockServidorDAO servidor = new MockServidorDAO();
	private static MockRequisitoDAO requisito = new MockRequisitoDAO();

	private static final ReservaEntity reserva1 = new ReservaEntity();

	private static final String formatoData = "dd/MM/yyyy";

	static {
		reserva1.setId(1L);
		reserva1.setStatus(EnumReserva.RECUSADO);
		try {
			reserva1.setDataSolicitacao(new SimpleDateFormat(formatoData).parse("10/05/2017"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		reserva1.setDisciplina("Algoritmos I");
		reserva1.setTurma("7844-1");
		reserva1.setObservacao("");
		reserva1.setFixo(false);
		try {
			reserva1.setDataInicio(new SimpleDateFormat(formatoData).parse("13/05/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			reserva1.setDataFim(new SimpleDateFormat(formatoData).parse("13/09/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			reserva1.setDataAprovacaoRecusa(new SimpleDateFormat(formatoData).parse("11/05/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva1.setJustificativa("Laboratório sem ar condicionado!");
		reserva1.setLaboratorio(laboratorio.getById((long) 1));
		reserva1.setDepartamentoAula(departamento.getById((long) 1));
		reserva1.setSolicitante(servidor.getById((long) 1));
		reserva1.setAprovador(servidor.getById((long) 1));
		reserva1.setRequisitos((ArrayList<RequisitoEntity>) requisito.buscarTodos());
		reserva1.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.M1, Horario.M2)));
		
		reservas.add(reserva1);
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
		for (ReservaEntity vo : reservas)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public List<ReservaEntity> getByNome() {
		return reservas;
	}

	@Override
	public List<ReservaEntity> buscarTodasReservas() {
		return reservas;
	}
}