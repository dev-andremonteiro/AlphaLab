
package br.edu.ifmt.cba.alphalab.dao.mock.emprestimo;

import br.edu.ifmt.cba.alphalab.dao.IEmprestimoDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.equipamentos.MockEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EmprestimoEntity;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EnumEmprestimo;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MockEmprestimoDAO implements IEmprestimoDAO {
    
    
    private static ArrayList<EmprestimoEntity> listaEmprestimo = new ArrayList();
    private static MockEmprestimoDAO singleton = null;
    
   private static  MockEquipamentoDAO equipamento = new MockEquipamentoDAO();
   private static MockServidorDAO servidor = new MockServidorDAO();
   
   private static final EmprestimoEntity emprestimo1 = new EmprestimoEntity();
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    static{
        emprestimo1.setId(1L);
        emprestimo1.setStatus(EnumEmprestimo.PEDIDO);
        try {
            emprestimo1.setDataSolicitacao(sdf.parse("09/05/2017"));
            emprestimo1.setDataEmprestimo(sdf.parse("09/05/2017"));
            emprestimo1.setDataDevolucao(sdf.parse("10/05/2017"));
            
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        emprestimo1.setObservacaoEmprestimo("Equipamento em perfeito estado");
        emprestimo1.setObservacaoDevolucao("Equipamento devolvido em perfeito estado");
        emprestimo1.setSolicitante(servidor.getById(1L));
        emprestimo1.setAprovador(servidor.getById(1L));
        emprestimo1.setRecebedor(servidor.getById(1L));
        //emprestimo1.setRecursos(equipamento.getById(1L));
        
        listaEmprestimo.add(emprestimo1);
       
        
    }
    
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
