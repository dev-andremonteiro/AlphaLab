package br.edu.ifmt.cba.alphalab.dao.mock.equipamentos;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IEquipamentoDAO;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EnumEquipamento;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EnumEquipamento;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author St�villis Sousa
 *
 */

public class MockEquipamentoDAO implements IEquipamentoDAO {
	private static List<EquipamentoEntity> equipamentos = new ArrayList();
	private static MockEquipamentoDAO singleton = null;
        
        private static final EquipamentoEntity equipamento1 = new EquipamentoEntity();
        private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        static{
         equipamento1.setId(1L);
         equipamento1.setDescricao("Oscilosc�pio");
         equipamento1.setObservacao("");
         equipamento1.setPatrimonio("");
         equipamento1.setStatus(EnumEquipamento.DISPONIVEL);
         
            try {
                equipamento1.setDataAquisicao(sdf.parse("10/08/2017"));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
           equipamentos.add(equipamento1);
            
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
}