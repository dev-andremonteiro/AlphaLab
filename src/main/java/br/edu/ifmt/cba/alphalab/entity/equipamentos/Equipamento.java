package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.Laboratorio;
import java.util.Date;

public class Equipamento {

	private Long id;

	private String descricao;

	private String patrimonio;

	private Enum tipo;

	private Date dataAquisicao;

	private String observacao;

	private Laboratorio laboratorio;

}
