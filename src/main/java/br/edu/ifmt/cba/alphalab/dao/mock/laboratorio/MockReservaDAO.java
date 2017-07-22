package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IReservaDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import groovyjarjarasm.asm.tree.TryCatchBlockNode;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockReservaDAO implements IReservaDAO {
	private static List<ReservaEntity> reservas = new ArrayList<>();
	private static MockReservaDAO singleton = null;

	private static final ReservaEntity reserva1 = new ReservaEntity();

	static {
		reserva1.setId(1L);
		reserva1.setStatus(EnumReserva.Recusado);
		try {
			reserva1.setDataSolicitacao(new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2017"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		reserva1.setDisciplina("Algoritmos I");
		reserva1.setTurma("7844-1");
		reserva1.setObservacao("");
		reserva1.setFixo(false);
		try {
			reserva1.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse("13/05/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			reserva1.setDataFim(new SimpleDateFormat("dd/MM/yyyy").parse("13/09/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			reserva1.setDataAprovacaoRecusa(new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reserva1.setJustificativa("Laboratório sem ar condicionado!");
		reserva1.setLaboratorio((LaboratorioEntity) MockLaboratorioDAO.getInstance().getById(1L));
		reserva1.setDepartamentoAula((DepartamentoEntity) MockDepartamentoDAO.getInstance().getbySigla("DAI"));
		reserva1.setSolicitante((ServidorEntity) MockServidorDAO.getInstance().getByNome("Augusto César de Oliveira"));
		reserva1.setAprovador((ServidorEntity) MockServidorDAO.getInstance().getById(1L));
		reserva1.setRequisitos((ArrayList<RequisitoEntity>) MockRequisitoDAO.getInstance().buscarTodos());
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
	public List<ReservaEntity> buscarTodos() {
		return reservas;
	}
}