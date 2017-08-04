package br.edu.ifmt.cba.alphalab.dao.mock.equipamentos;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockEquipamentoDAO implements IEquipamentoDAO {
	private static ArrayList<EquipamentoEntity> equipamentos = new ArrayList<>();
	private static MockEquipamentoDAO singleton = null;

	public static MockEquipamentoDAO getInstance() {
		if (singleton == null)
			singleton = new MockEquipamentoDAO();

		return singleton;
	}

	@Override
	public void save(EquipamentoEntity entity) {
		if (equipamentos.indexOf(entity) < 0)
			equipamentos.add(entity);
	}

	@Override
	public void delete(EquipamentoEntity entity) {
		equipamentos.remove(entity);
	}

	@Override
	public EquipamentoEntity getById(Long id) {
		for (EquipamentoEntity vo : equipamentos)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public EquipamentoEntity getByNome(String nome) {
		if (equipamentos.indexOf(nome) < 0)
			return null;
		else
			return equipamentos.get(equipamentos.indexOf(nome));
	}

	public List<EquipamentoEntity> buscarTodos() {
		return equipamentos;
	}
}