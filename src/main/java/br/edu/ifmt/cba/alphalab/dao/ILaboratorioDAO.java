package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public interface ILaboratorioDAO extends IDAO<LaboratorioEntity> {
	LaboratorioEntity getByNome(String nome);
}