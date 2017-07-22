package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.DepartamentoException;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;

public class DepartamentoEntity implements IEntity<DepartamentoException> {

	private Long id;

	private String sigla;

	private String nome;

	private String observacao;

	private ServidorEntity chefe;

	public DepartamentoEntity() {
	}

	public DepartamentoEntity(Long id, String sigla, String nome, String observacao, ServidorEntity chefe) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.observacao = observacao;
		this.chefe = chefe;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public DepartamentoException validar() {
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ServidorEntity getChefe() {
		return chefe;
	}

	public void setChefe(ServidorEntity chefe) {
		this.chefe = chefe;
	}
}
