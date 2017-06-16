package br.edu.ifmt.cba.alphalab.entity.software;

import br.edu.ifmt.cba.alphalab.entity.pessoa.Servidor;

public class Software {

	private Long id;
        
        private Enum status;

	private String descricao;

	private String link;

	private Enum tipo;

	private String observacao_Instalacao;

	private String versao;

	private Servidor solicitante;

	private Servidor concluinte;

}
