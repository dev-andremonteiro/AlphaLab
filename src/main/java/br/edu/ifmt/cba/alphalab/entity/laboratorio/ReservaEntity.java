package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import java.util.Date;

public class ReservaEntity implements IEntity {

    private Long id;

    private Enum status;

    private Date dataSolicitacao;

    private String disciplina;

    private String turma;

    private String observacao;

    private boolean fixo;

    private Date dataInicio;

    private Date dataFim;

    private Date dataAprovacaoRecusa;

    private String justificativa;

    private LaboratorioEntity laboratorio;

    private DepartamentoEntity departamentoAula;

    private ServidorEntity solicitante;

    private ServidorEntity aprovador;

    private ArrayList<RequisitoEntity> requisitos;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Object validar() {
        return null;
    }
}
