package br.edu.ifmt.cba.alphalab.business;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.entity.IEntity;

public abstract class ABusiness<ENTITY,EXCEPTION,DAO> implements IBusiness<ENTITY,EXCEPTION>{

	public IDAO<ENTITY> dao;
	
	public ABusiness(IDAO<ENTITY> dao) {
		this.dao = dao;
	}
	
	@Override
	public EXCEPTION save(ENTITY entity) {
		@SuppressWarnings("unchecked")
		EXCEPTION exc = (EXCEPTION) ((IEntity<EXCEPTION>)entity).validar();
		if (exc!=null)
			return exc;
		dao.save(entity);
		return null;
	}

	@Override
	public EXCEPTION delete(ENTITY entity) {
		dao.delete(entity);
		return null;
	}

	@Override
	public ENTITY getById(Long id) {
		return (ENTITY) dao.getById(id);
	}
	
	
	
}
