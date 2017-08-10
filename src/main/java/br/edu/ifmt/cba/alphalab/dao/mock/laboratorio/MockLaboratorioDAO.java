package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.ILaboratorioDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.equipamentos.MockEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.software.MockSoftwareDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;

/**
 * 
 * @author St�villis Sousa
 *
 */

public class MockLaboratorioDAO implements ILaboratorioDAO {
	private static List<LaboratorioEntity> laboratorios = new ArrayList<>();
	private static MockLaboratorioDAO singleton = null;

	private static MockDepartamentoDAO departamento = new MockDepartamentoDAO();
	private static MockEquipamentoDAO equipamento = new MockEquipamentoDAO();
	private static MockSoftwareDAO software = MockSoftwareDAO.getInstance();
	private static MockEquipamentoDAO equipamentos = new MockEquipamentoDAO();

	private static final LaboratorioEntity laboratorio1 = new LaboratorioEntity();
	private static final LaboratorioEntity laboratorio2 = new LaboratorioEntity();
	private static final LaboratorioEntity laboratorio3 = new LaboratorioEntity();
	private static final LaboratorioEntity laboratorio4 = new LaboratorioEntity();
	private static final LaboratorioEntity laboratorio5 = new LaboratorioEntity();
	private static final LaboratorioEntity laboratorio6 = new LaboratorioEntity();
	private static final LaboratorioEntity laboratorio7 = new LaboratorioEntity();

	static {
		laboratorio1.setId(1L);
		laboratorio1.setNome("Laborat�rio 1");
		laboratorio1.setSituacao(EnumSituacaoLaboratorio.DISPONIVEL);
		laboratorio1.setCapacidade(20);
		laboratorio1.setObservacao("Ar condicionado com defeito.");
		laboratorio1.setDepartamento(departamento.getById((long) 1));
		laboratorio1.setEquipamento(equipamento.getById((long) 1));
		laboratorio1.setSoftwares(software.buscarTodos());
		laboratorio1.setEquipamentos(equipamentos.buscarTodos());

		laboratorio2.setId(2L);
		laboratorio2.setNome("Laborat�rio 2");
		laboratorio2.setSituacao(EnumSituacaoLaboratorio.INTERDITADO);
		laboratorio2.setCapacidade(30);
		laboratorio2.setObservacao("Reforma interna.");
		laboratorio2.setDepartamento(departamento.getById((long) 1));
		laboratorio2.setEquipamento(equipamento.getById((long) 1));
		laboratorio2.setSoftwares(software.buscarTodos());
		laboratorio2.setEquipamentos(equipamentos.buscarTodos());

		laboratorio3.setId(3L);
		laboratorio3.setNome("Laborat�rio 3");
		laboratorio3.setSituacao(EnumSituacaoLaboratorio.RESERVADO);
		laboratorio3.setCapacidade(15);
		laboratorio3.setObservacao("Avalia��o institutional");
		laboratorio3.setDepartamento(departamento.getById((long) 1));
		laboratorio3.setEquipamento(equipamento.getById((long) 1));
		laboratorio3.setSoftwares(software.buscarTodos());
		laboratorio3.setEquipamentos(equipamentos.buscarTodos());

		laboratorio4.setId(4L);
		laboratorio4.setNome("Laborat�rio 4");
		laboratorio4.setSituacao(EnumSituacaoLaboratorio.DISPONIVEL);
		laboratorio4.setCapacidade(20);
		laboratorio4.setObservacao("Quadro com defeito.");
		laboratorio4.setDepartamento(departamento.getById((long) 1));
		laboratorio4.setEquipamento(equipamento.getById((long) 1));
		laboratorio4.setSoftwares(software.buscarTodos());
		laboratorio4.setEquipamentos(equipamentos.buscarTodos());

		laboratorio5.setId(5L);
		laboratorio5.setNome("Laborat�rio 5");
		laboratorio5.setSituacao(EnumSituacaoLaboratorio.INTERDITADO);
		laboratorio5.setCapacidade(40);
		laboratorio5.setObservacao("Reformando o piso.");
		laboratorio5.setDepartamento(departamento.getById((long) 1));
		laboratorio5.setEquipamento(equipamento.getById((long) 1));
		laboratorio5.setSoftwares(software.buscarTodos());
		laboratorio5.setEquipamentos(equipamentos.buscarTodos());

		laboratorio6.setId(6L);
		laboratorio6.setNome("Laborat�rio 6");
		laboratorio6.setSituacao(EnumSituacaoLaboratorio.RESERVADO);
		laboratorio6.setCapacidade(20);
		laboratorio6.setObservacao("ENADE");
		laboratorio6.setDepartamento(departamento.getById((long) 1));
		laboratorio6.setEquipamento(equipamento.getById((long) 1));
		laboratorio6.setSoftwares(software.buscarTodos());
		laboratorio6.setEquipamentos(equipamentos.buscarTodos());

		laboratorio7.setId(7L);
		laboratorio7.setNome("Laborat�rio 7");
		laboratorio7.setSituacao(EnumSituacaoLaboratorio.DISPONIVEL);
		laboratorio7.setCapacidade(40);
		laboratorio7.setObservacao("");
		laboratorio7.setDepartamento(departamento.getById((long) 1));
		laboratorio7.setEquipamento(equipamento.getById((long) 1));
		laboratorio7.setSoftwares(software.buscarTodos());
		laboratorio7.setEquipamentos(equipamentos.buscarTodos());

		laboratorios.add(laboratorio1);
		laboratorios.add(laboratorio2);
		laboratorios.add(laboratorio3);
		laboratorios.add(laboratorio4);
		laboratorios.add(laboratorio5);
		laboratorios.add(laboratorio6);
		laboratorios.add(laboratorio7);
	}

	public static MockLaboratorioDAO getInstance() {
		if (singleton == null)
			singleton = new MockLaboratorioDAO();

		return singleton;
	}

	@Override
	public void save(LaboratorioEntity entity) {
		if (laboratorios.indexOf(entity) < 0)
			laboratorios.add(entity);
	}

	@Override
	public void delete(LaboratorioEntity entity) {
		laboratorios.remove(entity);
	}

	@Override
	public LaboratorioEntity getById(Long id) {
		for (LaboratorioEntity vo : laboratorios)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public LaboratorioEntity getByNome(String nome) {
		if (laboratorios.indexOf(nome) < 0)
			return null;
		else
			return laboratorios.get(laboratorios.indexOf(nome));
	}

	@Override
	public List<LaboratorioEntity> buscarTodos() {
		return laboratorios;
	}
}