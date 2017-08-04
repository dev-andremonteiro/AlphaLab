
package br.edu.ifmt.cba.alphalab.dao.mock.emprestimo;

import br.edu.ifmt.cba.alphalab.dao.IRecursoDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.RecursoEntity;
import java.util.ArrayList;
import java.util.List;

public class MockRecursoDAO implements IRecursoDAO{
    
    private static ArrayList<RecursoEntity> listaRecurso= new ArrayList();
    private static MockRecursoDAO singleton = null;
    
    public static MockRecursoDAO getInstace(){
        
      if (singleton == null)
          
          singleton = new MockRecursoDAO();
      return singleton;
    }
    

    @Override
	public void save(RecursoEntity entity) {
		if (listaRecurso.indexOf(entity) < 0)
			listaRecurso.add(entity);
	}

	@Override
	public void delete(RecursoEntity entity) {
		listaRecurso.remove(entity);
	}

	@Override
	public RecursoEntity getById(Long id) {
		for (RecursoEntity vo : listaRecurso)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public RecursoEntity getByNome(String nome) {
		if (listaRecurso.indexOf(nome) < 0)
			return null;
		else
			return listaRecurso.get(listaRecurso.indexOf(nome));
	}

	public List<RecursoEntity> buscarTodos() {
		return listaRecurso;
	}

    
    
    
}
