package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumTipoReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.EnumTipoServidor;

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
	private static final ReservaEntity reserva4 = new ReservaEntity();
	private static final ReservaEntity reserva5 = new ReservaEntity();

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	static {
		reserva1.setId(1L);
		reserva1.setStatus(EnumReserva.RECUSADO);
		reserva1.setDisciplina(EnumDisciplina.COMUNICACAO_E_EXPRESSAO);
		reserva1.setTurma("7844-1");
		reserva1.setObservacao("");
		reserva1.setTipo(EnumTipoReserva.SEMESTRAL);
		try {
			reserva1.setDataSolicitacao((Date) sdf.parse("25/12/2010"));
			reserva1.setDataInicio(sdf.parse("13/05/2017"));
			reserva1.setDataFim(sdf.parse("13/09/2017"));
			reserva1.setDataAprovacaoRecusa(sdf.parse("11/05/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva1.setJustificativa("Laboratório sem ar condicionado!");
		reserva1.setLaboratorio(laboratorio.getById(1L));
		reserva1.setDepartamentoAula(departamento.getById(1L));
		reserva1.setSolicitante(servidor.getById(4L));
		reserva1.setAprovador(servidor.getById(1L));
		reserva1.setRequisitos(requisito.getRequisitos(1));
		reserva1.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.N1, Horario.N2, Horario.N3)));

		reserva2.setId(2L);
		reserva2.setStatus(EnumReserva.CONFIRMADO);
		reserva2.setDisciplina(EnumDisciplina.ALGORITMOS_I);
		reserva2.setTurma("7844-2");
		reserva2.setObservacao("Reserva para semestre letivo.");
		reserva2.setTipo(EnumTipoReserva.UNICA);
		try {
			reserva2.setDataSolicitacao(sdf.parse("06/08/2017"));
			reserva2.setDataInicio(sdf.parse("07/08/2017"));
			reserva2.setDataFim(sdf.parse("12/12/2017"));
			reserva2.setDataAprovacaoRecusa(sdf.parse("07/08/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva2.setJustificativa("");
		reserva2.setLaboratorio(laboratorio.getById(1L));
		reserva2.setDepartamentoAula(departamento.getById(1L));
		reserva2.setSolicitante(servidor.getById(4L));
		reserva2.setAprovador(servidor.getById(1L));
		reserva2.setRequisitos(requisito.getRequisitos(2));
		reserva2.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.M1, Horario.M2)));

		reserva3.setId(3L);
		reserva3.setStatus(EnumReserva.PEDIDO);
		reserva3.setDisciplina(EnumDisciplina.CALCULO_I);
		reserva3.setTurma("7844-5");
		reserva3.setObservacao("Urgência!");
		reserva3.setTipo(EnumTipoReserva.SEMESTRAL);
		try {
			reserva3.setDataSolicitacao(sdf.parse("14/08/2017"));
			reserva3.setDataInicio(sdf.parse("15/08/2017"));
			reserva3.setDataFim(sdf.parse("16/08/2017"));
			reserva3.setDataAprovacaoRecusa(sdf.parse("14/08/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva3.setJustificativa("");
		reserva3.setLaboratorio(laboratorio.getById(1L));
		reserva3.setDepartamentoAula(departamento.getById(1L));
		reserva3.setSolicitante(servidor.getById(4L));
		reserva3.setAprovador(servidor.getById(1L));
		reserva3.setRequisitos(requisito.getRequisitos(3));
		reserva3.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.V3, Horario.V4)));

		reserva4.setId(4L);
		reserva4.setStatus(EnumReserva.CONFIRMADO);
		reserva4.setDisciplina(EnumDisciplina.ALGORITMOS_I);
		reserva4.setTurma("7844-2");
		reserva4.setObservacao("Reserva para semestre letivo.");
		reserva4.setTipo(EnumTipoReserva.UNICA);
		try {
			reserva4.setDataSolicitacao(sdf.parse("06/08/2017"));
			reserva4.setDataInicio(sdf.parse("09/08/2017"));
			reserva4.setDataFim(sdf.parse("12/12/2017"));
			reserva4.setDataAprovacaoRecusa(sdf.parse("07/08/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva4.setJustificativa("");
		reserva4.setLaboratorio(laboratorio.getById(1L));
		reserva4.setDepartamentoAula(departamento.getById(1L));
		reserva4.setSolicitante(servidor.getById(4L));
		reserva4.setAprovador(servidor.getById(1L));
		reserva4.setRequisitos(requisito.getRequisitos(4));
		reserva4.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.M2, Horario.M3)));

		reserva5.setId(5L);
		reserva5.setStatus(EnumReserva.CONFIRMADO);
		reserva5.setDisciplina(EnumDisciplina.COMUNICACAO_E_EXPRESSAO);
		reserva5.setTurma("7844-2");
		reserva5.setObservacao("Minicurso de Arte para vender na praia");
		reserva5.setTipo(EnumTipoReserva.SEMESTRAL);
		try {
			reserva5.setDataSolicitacao(sdf.parse("06/08/2017"));
			reserva5.setDataInicio(sdf.parse("10/08/2017"));
			reserva5.setDataFim(sdf.parse("12/12/2017"));
			reserva5.setDataAprovacaoRecusa(sdf.parse("07/08/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva5.setJustificativa("");
		reserva5.setLaboratorio(laboratorio.getById(3L));
		reserva5.setDepartamentoAula(departamento.getById(1L));
		reserva5.setSolicitante(servidor.getById(4L));
		reserva5.setAprovador(servidor.getById(1L));
		reserva5.setRequisitos(requisito.getRequisitos(4));
		reserva5.setHorarios(new ArrayList<Horario>(Arrays.asList(Horario.V4, Horario.V5, Horario.V6)));

		reservas.add(reserva1);
		reservas.add(reserva2);
		reservas.add(reserva3);
		reservas.add(reserva4);
		reservas.add(reserva5);
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
				System.out.println(vo.getDataSolicitacao());
				System.out.println(data);
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
	public List<ReservaEntity> getAtivosNoDia(LocalDate data) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			if (data.getDayOfWeek().equals(
					vo.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek())) {
				if (!data.isBefore(vo.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
						&& !data.isAfter(vo.getDataFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
						&& vo.getStatus().equals(EnumReserva.CONFIRMADO)) {
					resultado.add(vo);
				}
			}
		}
		return resultado;
	}

	@Override
	public List<ReservaEntity> getAtivosNaSemana(LocalDate data) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();

		if (!data.getDayOfWeek().equals(DayOfWeek.MONDAY))
			data = data.minusDays(data.getDayOfWeek().getValue() - 1);
		do {
			resultado.addAll(getAtivosNoDia(data));
			data = data.plusDays(1);
		} while (!data.getDayOfWeek().equals(DayOfWeek.SUNDAY));

		return resultado;
	}

	@Override
	public List<ReservaEntity> getByTipo(EnumTipoReserva enumTipoReserva) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			if (vo.getTipo().equals(enumTipoReserva) && vo.getStatus() == EnumReserva.PEDIDO) {
				resultado.add(vo);
			}
		}
		return resultado;
	}

	@Override
	public List<ReservaEntity> getByServidor(EnumTipoServidor enumTipoServidor) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			if (vo.getSolicitante().getTipo().equals(enumTipoServidor) && vo.getStatus() == EnumReserva.PEDIDO) {
				resultado.add(vo);
			}
		}
		System.out.println("Tamanho da lista: " + resultado.size());
		return resultado;
	}

	@Override
	public List<ReservaEntity> getByTipoEServidor(EnumTipoReserva enumTipoReserva, EnumTipoServidor enumTipoServidor) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			System.out.println(vo.getTipo() + " == " + enumTipoReserva);
			System.out.println(vo.getSolicitante() + " == " + enumTipoServidor);
			System.out.println("********************************************\n\n");
			if (vo.getTipo().equals(enumTipoReserva) && vo.getSolicitante().getTipo().equals(enumTipoServidor)) {
				resultado.add(vo);
			}
		}
		return resultado;
	}

	@Override
	public List<ReservaEntity> buscarReservasPedidas() {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			if (vo.getStatus() == (EnumReserva.PEDIDO)) {
				resultado.add(vo);
			}
		}
		return resultado;
	}

	@Override
	public List<ReservaEntity> getByTipoEServidorEPedido(EnumTipoReserva enumTipoReserva,
			EnumTipoServidor enumTipoServidor) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			System.out.println(vo.getTipo() + " == " + enumTipoReserva);
			System.out.println(vo.getSolicitante() + " == " + enumTipoServidor);
			System.out.println("********************************************\n\n");
			if (vo.getTipo().equals(enumTipoReserva) && vo.getSolicitante().getTipo().equals(enumTipoServidor)
					&& vo.getStatus() == (EnumReserva.PEDIDO)) {
				resultado.add(vo);
			}
		}
		return resultado;
	}

	@Override
	public List<ReservaEntity> getReservasEmAbertoNoDia(LocalDate data) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();
		for (ReservaEntity vo : reservas) {
			if (data.getDayOfWeek().equals(
					vo.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek())) {
				if (!data.isBefore(vo.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
						&& !data.isAfter(vo.getDataFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
						&& vo.getStatus().equals(EnumReserva.PEDIDO)) {
					resultado.add(vo);
				}
			}
		}
		return resultado;
	}

	@Override
	public List<ReservaEntity> getReservasEmAbertoNaSemana(LocalDate data) {
		ArrayList<ReservaEntity> resultado = new ArrayList<>();

		if (!data.getDayOfWeek().equals(DayOfWeek.MONDAY))
			data = data.minusDays(data.getDayOfWeek().getValue() - 1);
		do {
			resultado.addAll(getReservasEmAbertoNoDia(data));
			data = data.plusDays(1);
		} while (!data.getDayOfWeek().equals(DayOfWeek.SUNDAY));

		for (ReservaEntity reservaEntity : resultado) {
			System.out.println(reservaEntity.getDataSolicitacao() + " " + reservaEntity.getStatus());
		}

		return resultado;
	}
}