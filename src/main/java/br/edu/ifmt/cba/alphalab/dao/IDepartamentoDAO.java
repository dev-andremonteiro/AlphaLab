package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import java.util.List;

public interface IDepartamentoDAO extends IDAO<DepartamentoEntity> {
	public List<DepartamentoEntity> buscarTodos();

	public DepartamentoEntity getbySigla(String sigla);
}
