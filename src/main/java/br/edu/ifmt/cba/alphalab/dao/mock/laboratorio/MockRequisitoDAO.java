package br.edu.ifmt.cba.alphalab.dao.mock.laboratorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IRequisitoDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockRequisitoDAO implements IRequisitoDAO {

	private static List<RequisitoEntity> requisitos = new ArrayList<>();
	
	static {
		Enum<?> status = null;
		Enum<?> tipo = null;
		requisitos.add(new RequisitoEntity(1L, 15, Arrays.asList(new SoftwareEntity("OpenOffice", tipo, "1.0", "http:\\domain.org", "Nada a declarar", status, new ServidorEntity()), new SoftwareEntity("MS Paint", tipo, "3.5.7", "http:\\domain.org", "Nada a declarar", status, new ServidorEntity()), new SoftwareEntity("PostgreSQL", tipo, "0.7", "http:\\domain.org", "Requer usuário", status, new ServidorEntity()))));
		requisitos.add(new RequisitoEntity(2L, 30, Arrays.asList(new SoftwareEntity("OpenOffice", tipo, "1.0", "http:\\domain.org", "Nada a declarar", status, new ServidorEntity()))));
		requisitos.add(new RequisitoEntity(3L, 10, Arrays.asList(new SoftwareEntity("OpenOffice", tipo, "1.0", "http:\\domain.org", "Nada a declarar", status, new ServidorEntity()), new SoftwareEntity("MS Paint", tipo, "3.5.7", "http:\\domain.org", "Nada a declarar", status, new ServidorEntity()))));
	}
	
	private static MockRequisitoDAO singleton = null;

	public static MockRequisitoDAO getInstance() {
		if (singleton == null)
			singleton = new MockRequisitoDAO();

		return singleton;
	}

	@Override
	public void save(RequisitoEntity entity) {
		if (requisitos.indexOf(entity) < 0) {
			requisitos.add(entity);
		}
	}

	@Override
	public void delete(RequisitoEntity entity) {
		requisitos.remove(entity);
	}

	@Override
	public RequisitoEntity getById(Long id) {
		for (RequisitoEntity vo : requisitos)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public List<RequisitoEntity> buscarTodos() {
		return requisitos;
	}
}