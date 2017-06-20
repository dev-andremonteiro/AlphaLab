package br.edu.ifmt.cba.alphalab.entity.pessoa;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;

public class ServidorEntity implements IEntity {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String login;

    private String senha;

    private Enum tipo;

    private DepartamentoEntity departamento;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Object validar() {
        return null;
    }
}
