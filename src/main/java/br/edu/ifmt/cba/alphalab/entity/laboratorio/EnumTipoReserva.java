package br.edu.ifmt.cba.alphalab.entity.laboratorio;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public enum EnumTipoReserva {
	SEMESTRAL("Semestral"), UNICA("Única");

	private final String descricao;

	private EnumTipoReserva(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}