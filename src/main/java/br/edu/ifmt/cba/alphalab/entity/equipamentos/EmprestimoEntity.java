package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.ArrayList;
import java.util.Date;

public class EmprestimoEntity implements IEntity {

    private Long id;

    private Enum status;

    private Date dataSolicitacao;

    private Date dataEmprestimo;

    private String observacaoEmprestimo;

    private Date dataDevolucao;

    private String observacaoDevolucao;

    private ArrayList<RecursoEntity> recursos;

    private ServidorEntity solicitante;

    private ServidorEntity aprovador;

    private ServidorEntity recebedor;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Object validar() {
        return null;
    }

}
