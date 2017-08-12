
package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.equipamentos.EmprestimoEntity;
import java.util.List;

/**
 *
 * @author Wesley
 */
public interface IEmprestimoDAO extends IDAO<EmprestimoEntity> {
    
    EmprestimoEntity getByNome(String nome);
    public List<EmprestimoEntity> buscarTodos();
    public List<EmprestimoEntity> BuscarPedidosEmprestimo();
}
