package br.edu.ifmt.cba.alphalab.entity.pessoa;

/**
 * 
 * @author St�villis Sousa
 *
 */

public enum EnumTipoServidor {
	PROFESSOR("Professor"), ESTAGIARIO("Estagi�rio"), TEC_LABORATORIO("T�cnico de Laborat�rio"), TEC_ADM(
			"T�cnico Administrativo");

	private final String descricao;

	private EnumTipoServidor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}