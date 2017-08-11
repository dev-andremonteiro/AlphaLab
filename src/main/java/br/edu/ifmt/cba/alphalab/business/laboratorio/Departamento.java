package br.edu.ifmt.cba.alphalab.business.laboratorio;

import br.edu.ifmt.cba.alphalab.business.ABusiness;
import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.IDepartamentoDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import java.util.List;


public class Departamento extends ABusiness<DepartamentoEntity, Exception, IDepartamentoDAO>{
    
     public Departamento(IDAO<DepartamentoEntity> dao) {
        super(dao);
    }
    
     public List<DepartamentoEntity> buscarTodos(){
         return ((IDepartamentoDAO)dao).buscarTodos();
     }
     
     public List<DepartamentoEntity> getByNome(String nome){
		return ((IDepartamentoDAO)dao).getByNome(nome);
	}
    public List<DepartamentoEntity> getBySigla(String sigla){
		return ((IDepartamentoDAO)dao).getBySigla(sigla);
    }
}
