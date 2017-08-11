package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import java.util.List;

/**
 * 
 * @author St�villis Sousa
 *
 */

public interface IEquipamentoDAO extends IDAO<EquipamentoEntity> {
	EquipamentoEntity getByNome(String nome);
        
        public List<EquipamentoEntity> buscarDisponivel();
        public void removerEquipamento();
        public void AdicionarEquipamento();
}