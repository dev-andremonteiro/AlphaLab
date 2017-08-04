package br.edu.ifmt.cba.alphalab.dao;

import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;

public interface IDAO<ENTITY> {

	void save(ENTITY entity);
	void delete(ENTITY entity);
	ENTITY getById(Long id);	
}
