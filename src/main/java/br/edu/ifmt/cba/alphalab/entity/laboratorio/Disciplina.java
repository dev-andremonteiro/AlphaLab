package br.edu.ifmt.cba.alphalab.entity.laboratorio;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class Disciplina {
	private String nome;
	private String turma;
	private Integer vagas;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the turma
	 */
	public String getTurma() {
		return turma;
	}

	/**
	 * @param turma
	 *            the turma to set
	 */
	public void setTurma(String turma) {
		this.turma = turma;
	}

	/**
	 * @return the vagas
	 */
	public Integer getVagas() {
		return vagas;
	}

	/**
	 * @param vagas
	 *            the vagas to set
	 */
	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}