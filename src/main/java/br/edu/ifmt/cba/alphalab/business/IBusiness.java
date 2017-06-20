package br.edu.ifmt.cba.alphalab.business;

public interface IBusiness<ENTITY, EXCEPTION> {

	EXCEPTION save(ENTITY entity);
	EXCEPTION delete(ENTITY entity);
	ENTITY getById(Long id);
	
}
