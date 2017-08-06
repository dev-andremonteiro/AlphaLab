package br.edu.ifmt.cba.alphalab.entity.laboratorio;

/**
 * 
 * @author Stévillis
 *
 */
public enum EnumDisciplina {
	ALGORITMOS_I, CALCULO_I, FISICA_I, VETORES_E_GEOMETRIA_ANALITICA, COMUNICACAO_E_EXPRESSAO;

	private String descricao;

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}