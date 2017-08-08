package br.edu.ifmt.cba.alphalab.entity.laboratorio;

/**
 * 
 * @author Stévillis
 *
 */
public enum EnumDisciplina {
	ALGORITMOS_I("Algoritmos 1"),
	CALCULO_I("Cálculo 1"),
	FISICA_I("Física 1"),
	VETORES_E_GEOMETRIA_ANALITICA("Vetores e Geometria Analítica"),
	COMUNICACAO_E_EXPRESSAO("Comunicação e Expressão");

	private String descricao;

	private EnumDisciplina(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}