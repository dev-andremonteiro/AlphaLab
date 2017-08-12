package br.edu.ifmt.cba.alphalab.entity.pessoa;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public enum EnumTipoServidor {
	PROFESSOR("Professor"), ESTAGIARIO("Estagiário"), TEC_LABORATORIO("Técnico de Laboratório"), TEC_ADM(
			"Técnico Administrativo");

	private final String descricao;

	private EnumTipoServidor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}