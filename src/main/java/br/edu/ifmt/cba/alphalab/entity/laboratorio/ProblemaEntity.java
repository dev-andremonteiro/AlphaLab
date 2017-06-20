package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.Date;

public class ProblemaEntity implements IEntity {

    private Long id;

    private Enum status;

    private String observacao;

    private Date dataLancamento;

    private Date dataCorrecao;

    private String justificativa;

    private LaboratorioEntity laboratorio;

    private ServidorEntity solicitante;

    private ServidorEntity concluinte;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Object validar() {
        return null;
    }
}
