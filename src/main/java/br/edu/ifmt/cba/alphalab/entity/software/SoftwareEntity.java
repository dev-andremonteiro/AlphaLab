package br.edu.ifmt.cba.alphalab.entity.software;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

public class SoftwareEntity implements IEntity {

    private Long id;

    private Enum status;

    private String descricao;

    private String link;

    private Enum tipo;

    private String observacao_Instalacao;

    private String versao;

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
