package br.edu.ifmt.cba.alphalab.business;

import java.util.List;

import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.ISoftwareDAO;
import br.edu.ifmt.cba.alphalab.entity.exception.SoftwareException;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;

/**
 * 
 * @author St�villis
 *
 */

public class Software extends ABusiness<SoftwareEntity, SoftwareException, ISoftwareDAO> {
	public Software(IDAO<SoftwareEntity> dao) {
		super(dao);
	}

	public List<SoftwareEntity> buscarTodosSoftwares() {
		return ((ISoftwareDAO) dao).buscarTodos();
	}
        

	public List<SoftwareEntity> getByNome(String text) {
                return ((ISoftwareDAO) dao).buscarPorNome(text);
	}
        
        public List<SoftwareEntity> buscarPorTipoNome(TipoSoftwareEnum tipo, String nome){
            return ((ISoftwareDAO) dao).buscarPorTipoNome(tipo, nome);
        }
}