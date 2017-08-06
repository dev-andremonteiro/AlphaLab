package br.edu.ifmt.cba.alphalab.dao.mock.servidor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IProfessorDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ProfessorEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */
public class MockProfessorDAO implements IProfessorDAO {
	private static List<ProfessorEntity> professores = new ArrayList<>();
	private static MockProfessorDAO singleton = null;

	private static final ProfessorEntity professor1 = new ProfessorEntity(1L,
			Arrays.asList(EnumDisciplina.VETORES_E_GEOMETRIA_ANALITICA, EnumDisciplina.CALCULO_I));
	private static final ProfessorEntity professor2 = new ProfessorEntity(2L,
			Arrays.asList(EnumDisciplina.COMUNICACAO_E_EXPRESSAO, EnumDisciplina.FISICA_I));
	private static final ProfessorEntity professor3 = new ProfessorEntity(3L, Arrays.asList(EnumDisciplina.CALCULO_I));

	static {
		professores.add(professor1);
		professores.add(professor2);
		professores.add(professor3);
	}

	private MockProfessorDAO() {
	}

	public static MockProfessorDAO getInstance() {
		if (singleton == null)
			singleton = new MockProfessorDAO();

		return singleton;
	}

	@Override
	public void save(ProfessorEntity entity) {
		if (professores.indexOf(entity) < 0)
			professores.add(entity);
	}

	@Override
	public void delete(ProfessorEntity entity) {
		professores.remove(entity);
	}

	@Override
	public ProfessorEntity getById(Long id) {
		for (ProfessorEntity vo : professores)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public List<ProfessorEntity> getByNome(String nome) {
		ArrayList<ProfessorEntity> resultado = new ArrayList<>();
		for (ProfessorEntity vo : professores) {
			if (vo.getNome().equals(nome))
				resultado.add(vo);
		}
		return resultado;
	}

	@Override
	public List<ProfessorEntity> buscarTodos() {
		return professores;
	}
}