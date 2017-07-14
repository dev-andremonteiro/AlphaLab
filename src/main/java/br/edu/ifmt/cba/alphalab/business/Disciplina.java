package br.edu.ifmt.cba.alphalab.business;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class Disciplina {
	private String nomeDisciplina;
	private Professor professor;

	/**
	 * @return the nomeDisciplina
	 */
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	/**
	 * @param nomeDisciplina
	 *            the nomeDisciplina to set
	 */
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}

	/**
	 * @param professor
	 *            the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
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
		result = prime * result + ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
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
		if (nomeDisciplina == null) {
			if (other.nomeDisciplina != null)
				return false;
		} else if (!nomeDisciplina.equals(other.nomeDisciplina))
			return false;
		return true;
	}
}
