package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import java.util.Date;

public class RecursoEntity implements IEntity {

    private Long id;

    private String descricao;

    private String patrimonio;

    private Enum tipo;

    private Date dataAquisicao;

    private String observacao;

    private EmprestimoEntity emprestimo;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Object validar() {
        return null;
    }

}
