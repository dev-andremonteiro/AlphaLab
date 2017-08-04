
package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.equipamentos.EmprestimoEntity;

/**
 *
 * @author Wesley
 */
public interface IEmprestimoDAO extends IDAO<EmprestimoEntity> {
    
    EmprestimoEntity getByNome(String nome);
}
