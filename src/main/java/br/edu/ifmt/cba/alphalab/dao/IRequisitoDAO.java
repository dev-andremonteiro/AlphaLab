package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public interface IRequisitoDAO extends IDAO<RequisitoEntity> {

	RequisitoEntity getRequisitos(int id);
}