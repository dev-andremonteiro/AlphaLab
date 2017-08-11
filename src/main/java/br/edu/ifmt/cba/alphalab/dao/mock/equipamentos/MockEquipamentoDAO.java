package br.edu.ifmt.cba.alphalab.dao.mock.equipamentos;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EnumEquipamento;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EnumEquipamento;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class MockEquipamentoDAO implements IEquipamentoDAO {
	private static List<EquipamentoEntity> equipamentos = new ArrayList();
	private static MockEquipamentoDAO singleton = null;
        
        private static final EquipamentoEntity equipamento1 = new EquipamentoEntity();
        private static final EquipamentoEntity equipamento2 = new EquipamentoEntity();
        private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        static{
         equipamento1.setId(1L);
         equipamento1.setDescricao("Osciloscópio");
         equipamento1.setObservacao("");
         equipamento1.setPatrimonio("");
         equipamento1.setStatus(EnumEquipamento.DISPONIVEL);
         equipamento1.setQtdeEstoque(10L);
         equipamento1.setQtdeEmprestada(5L);
         
         
            try {
                equipamento1.setDataAquisicao(sdf.parse("10/08/2017"));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
           equipamentos.add(equipamento1);
           
           
         equipamento2.setId(2L);
         equipamento2.setDescricao("Protoboard");
         equipamento2.setObservacao("");
         equipamento2.setPatrimonio("");
         equipamento2.setStatus(EnumEquipamento.DISPONIVEL);
         equipamento2.setQtdeEstoque(20L);
         equipamento2.setQtdeEmprestada(5L);
         
         
            try {
                equipamento2.setDataAquisicao(sdf.parse("10/08/2017"));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
           equipamentos.add(equipamento2);
            
        }
	public static MockEquipamentoDAO getInstance() {
		if (singleton == null)
			singleton = new MockEquipamentoDAO();

		return singleton;
	}

	@Override
	public void save(EquipamentoEntity entity) {
		if (equipamentos.indexOf(entity) < 0)
			equipamentos.add(entity);
	}

	@Override
	public void delete(EquipamentoEntity entity) {
		equipamentos.remove(entity);
	}

	@Override
	public EquipamentoEntity getById(Long id) {
		for (EquipamentoEntity vo : equipamentos)
			if (vo.getId().equals(id))
				return vo;
		return null;
	}

	@Override
	public EquipamentoEntity getByNome(String nome) {
		if (equipamentos.indexOf(nome) < 0)
			return null;
		else
			return equipamentos.get(equipamentos.indexOf(nome));
	}

	public List<EquipamentoEntity> buscarTodos() {
		return equipamentos;
	}
        // Busca equipamentos disponíveis
        @Override
        public List<EquipamentoEntity> buscarDisponivel() {
            
            ArrayList<EquipamentoEntity> resultado = new ArrayList<>();
            
            for(EquipamentoEntity vo : equipamentos){
              if(vo.getStatus() == EnumEquipamento.DISPONIVEL){
                  resultado.add(vo);
              }
               
            }
		return resultado;
	}
        public void removerEquipamento(){
            
        }
        
        public void AdicionarEquipamento(){
            
        }
}