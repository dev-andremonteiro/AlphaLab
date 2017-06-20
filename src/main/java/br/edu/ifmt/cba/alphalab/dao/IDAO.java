package br.edu.ifmt.cba.alphalab.dao;

public interface IDAO<ENTITY> {

	void save(ENTITY entity);
	void delete(ENTITY entity);
	ENTITY getById(Long id);
	
}
