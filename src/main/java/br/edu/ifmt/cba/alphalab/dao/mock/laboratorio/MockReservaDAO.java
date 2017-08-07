package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockReservaDAO implements IReservaDAO {
	private static List<ReservaEntity> reservas = new ArrayList<>();
	private static MockReservaDAO singleton = null;

	private static MockLaboratorioDAO laboratorio = new MockLaboratorioDAO();
	private static MockDepartamentoDAO departamento = new MockDepartamentoDAO();
	private static MockServidorDAO servidor = new MockServidorDAO();
	private static MockRequisitoDAO requisito = new MockRequisitoDAO();

	private static final ReservaEntity reserva1 = new ReservaEntity();
	private static final ReservaEntity reserva2 = new ReservaEntity();
	private static final ReservaEntity reserva3 = new ReservaEntity();

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	static {
		reserva1.setId(1L);
		reserva1.setStatus(EnumReserva.RECUSADO);
		reserva1.setDisciplina("Algoritmos I");
		reserva1.setTurma("7844-1");
		reserva1.setObservacao("");
		reserva1.setFixo(false);
		try {
			reserva1.setDataSolicitacao(sdf.parse("10/05/2017"));
			reserva1.setDataInicio(sdf.parse("13/05/2017"));
			reserva1.setDataFim(sdf.parse("13/09/2017"));
			reserva1.setDataAprovacaoRecusa(sdf.parse("11/05/2017"));
			//System.out.println(sdf.format(sdf.parse("25/08/1979")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva1.setJustificativa("Laboratório sem ar condicionado!");
		reserva1.setLaboratorio(laboratorio.getById(1L));
		reserva1.setDepartamentoAula(departamento.getById(1L));
		reserva1.setSolicitante(servidor.getById(1L));
		reserva1.setAprovador(servidor.getById(1L));
		reserva1.setRequisitos(requisito.buscarTodos());
		reserva1.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.N1, Horario.N2, Horario.N3)));

		reserva2.setId(2L);
		reserva2.setStatus(EnumReserva.CONFIRMADO);
		reserva2.setDisciplina("Algoritmos II");
		reserva2.setTurma("7844-2");
		reserva2.setObservacao("Minicurso de Python");
		reserva2.setFixo(true);
		try {
			reserva2.setDataSolicitacao(sdf.parse("06/08/2017"));
			reserva2.setDataInicio(sdf.parse("07/08/2017"));
			reserva2.setDataFim(sdf.parse("12/12/2017"));
			reserva2.setDataAprovacaoRecusa(sdf.parse("07/08/2017"));
			//System.out.println(sdf.format(sdf.parse("07/08/2017")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva2.setJustificativa("");
		reserva2.setLaboratorio(laboratorio.getById(1L));
		reserva2.setDepartamentoAula(departamento.getById(1L));
		reserva2.setSolicitante(servidor.getById(1L));
		reserva2.setAprovador(servidor.getById(1L));
		reserva2.setRequisitos(requisito.buscarTodos());
		reserva2.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.M1, Horario.M2)));

		reserva3.setId(3L);
		reserva3.setStatus(EnumReserva.PEDIDO);
		reserva3.setDisciplina("Linguagem de Programação I");
		reserva3.setTurma("7844-5");
		reserva3.setObservacao("Urgência!");
		reserva3.setFixo(false);
		try {
			reserva3.setDataSolicitacao(sdf.parse("10/09/2017"));
			reserva3.setDataInicio(sdf.parse("13/09/2017"));
			reserva3.setDataFim(sdf.parse("28/09/2017"));
			reserva3.setDataAprovacaoRecusa(sdf.parse("11/09/2017"));
			//System.out.print(sdf.format(sdf.parse("11/09/2017")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva3.setJustificativa("");
		reserva3.setLaboratorio(laboratorio.getById(1L));
		reserva3.setDepartamentoAula(departamento.getById(1L));
		reserva3.setSolicitante(servidor.getById(1L));
		reserva3.setAprovador(servidor.getById(1L));
		reserva3.setRequisitos(requisito.buscarTodos());
		reserva3.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.V3, Horario.V4)));

		reservas.add(reserva1);
		reservas.add(reserva2);
		reservas.add(reserva3);
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
	public List<ReservaEntity> getByData(Date data) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			if (vo.getDataSolicitacao().equals(data)) {
				resultado.add(vo);
			}
		}
		return resultado;
	}

	@Override
	public List<ReservaEntity> buscarTodasReservas() {
		return reservas;
	}

	@Override
	public List<ReservaEntity> getAtivosNaData(LocalDate data) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			if (data.getDayOfWeek() == vo.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek()) {
				if (!data.isBefore(vo.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) && !data.isAfter(vo.getDataFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())) {
					resultado.add(vo);
				} 
			}
		}
		return resultado;
	}
}