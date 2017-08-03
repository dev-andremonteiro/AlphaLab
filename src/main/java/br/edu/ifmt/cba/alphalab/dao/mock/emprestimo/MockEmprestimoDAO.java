
package br.edu.ifmt.cba.alphalab.dao.mock.emprestimo;

import br.edu.ifmt.cba.alphalab.dao.IEmprestimoDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EmprestimoEntity;
import java.util.ArrayList;
import java.util.List;

public class MockEmprestimoDAO implements IEmprestimoDAO {
    
    
    private static ArrayList<EmprestimoEntity> listaEmprestimo = new ArrayList();
    
    
    private static MockEmprestimoDAO singleton = null;
    
    public MockEmprestimoDAO(){  }
    
    public MockEmprestimoDAO getInstance(){
        if (singleton == null)
            
               singleton = new MockEmprestimoDAO();
        
        return singleton;
        
    }
    
    
   @Override
	public void save(EmprestimoEntity entity) {
		if (listaEmprestimo.indexOf(entity) < 0)
			listaEmprestimo.add(entity);
	}

	@Override
	public void delete(EmprestimoEntity entity) {
		listaEmprestimo.remove(entity);
	}

	@Override
	public EmprestimoEntity getById(Long id) {
		for (EmprestimoEntity vo : listaEmprestimo)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public EmprestimoEntity getByNome(String nome) {
		if (listaEmprestimo.indexOf(nome) < 0)
			return null;
		else
			return listaEmprestimo.get(listaEmprestimo.indexOf(nome));
	}

	public List<EmprestimoEntity> buscarTodos() {
		return listaEmprestimo;
	}

    
    
}
