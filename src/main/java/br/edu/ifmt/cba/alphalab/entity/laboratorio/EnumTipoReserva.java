package br.edu.ifmt.cba.alphalab.entity.laboratorio;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public enum EnumTipoReserva {
	SEMANAL("Semanal"), MENSAL("Mensal"), SEMESTRAL("Semestral"), ANUAL("Anual");

	private final String descricao;

	private EnumTipoReserva(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}