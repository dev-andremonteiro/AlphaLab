package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.util.ArrayList;

import br.edu.ifmt.cba.alphalab.dao.ILaboratorioDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockLaboratorioDAO implements ILaboratorioDAO {
	private static ArrayList<LaboratorioEntity> laboratorios = new ArrayList<>();
	private static MockLaboratorioDAO singleton = null;

	private static final LaboratorioEntity laboratorio1 = new LaboratorioEntity();

	static {
		laboratorio1.setId(1L);
		laboratorio1.setNome("Laboratório 1");
		laboratorio1.setSituacao(EnumSituacaoLaboratorio.DISPONIVEL);
		laboratorio1.setCapacidade(20);
		laboratorio1.setObservacao("Ar condicionado com defeito.");
		laboratorio1.setDepartamento((DepartamentoEntity) MockDepartamentoDAO.getInstance().buscarTodos().toArray()[0]);
		/*
		 * Esperando criação MockEquipamento...
		 */

	}

	public MockLaboratorioDAO() {
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
	public LaboratorioEntity getbySigla(String sigla) {
		if (laboratorios.indexOf(sigla) < 0)
			return null;
		else
			return laboratorios.get(laboratorios.indexOf(sigla));
	}
}