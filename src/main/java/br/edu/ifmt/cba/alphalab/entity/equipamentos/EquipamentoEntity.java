package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import java.util.Date;

public class EquipamentoEntity implements IEntity {

    private Long id;

    private String descricao;

    private String patrimonio;

    private Enum tipo;

    private Date dataAquisicao;

    private String observacao;

    private LaboratorioEntity laboratorio;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Object validar() {
        return null;
    }
}
