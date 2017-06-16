package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.pessoa.Servidor;
import java.util.Date;

public class Problema {

	private Long id;
        
        private Enum status;

	private String observacao;

	private Date dataLancamento;

	private Date dataCorrecao;

	private String justificativa;

	private Laboratorio laboratorio;
        
	private Servidor solicitante;

	private Servidor concluinte;

}
