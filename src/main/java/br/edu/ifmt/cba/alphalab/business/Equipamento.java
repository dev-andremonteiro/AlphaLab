
package br.edu.ifmt.cba.alphalab.business;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.IEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.EquipamentoException;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class Equipamento extends ABusiness<EquipamentoEntity, EquipamentoException, IEquipamentoDAO> {
    
    public Equipamento(IDAO<EquipamentoEntity> dao) {
        super(dao);
    }
    
    public List<EquipamentoEntity> buscarEquipamentosDisponiveis() {
		return ((IEquipamentoDAO) dao).buscarDisponivel();
	}
    
   // public  RemoverEstoqueEquipamento(Long a, EquipamentoEntity equipamento);
      
}
