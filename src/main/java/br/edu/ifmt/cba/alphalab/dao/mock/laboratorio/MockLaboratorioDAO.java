package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.util.ArrayList;

import br.edu.ifmt.cba.alphalab.dao.ILaboratorioDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.equipamentos.MockEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.software.MockSoftwareDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;

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
		laboratorio1.setEquipamento((EquipamentoEntity) MockEquipamentoDAO.getInstance().buscarTodos().toArray()[0]);
		laboratorio1.setSoftwares((ArrayList<SoftwareEntity>) MockSoftwareDAO.getInstance().buscarTodos());
		laboratorio1.setEquipamentos((ArrayList<EquipamentoEntity>) MockEquipamentoDAO.getInstance().buscarTodos());
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
}