package br.edu.ifmt.cba.alphalab.entity.pessoa;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.ServidorException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;

public class ServidorEntity implements IEntity<ServidorException> {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String login;

    private String senha;

    private EnumTipoServidor tipo;

    private DepartamentoEntity departamento;

    public ServidorEntity() {
		super();
	}

	public ServidorEntity(Long id, String nome, String email, String telefone, String login, String senha,
			EnumTipoServidor tipo, DepartamentoEntity departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
		this.departamento = departamento;
	}

	@Override
    public Long getId() {
        return id;
    }

    @Override
    public ServidorException validar() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EnumTipoServidor getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoServidor tipo) {
        this.tipo = tipo;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }
}