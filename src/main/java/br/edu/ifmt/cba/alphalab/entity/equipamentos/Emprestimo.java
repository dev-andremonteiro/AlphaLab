package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import br.edu.ifmt.cba.alphalab.entity.pessoa.Servidor;
import java.util.ArrayList;
import java.util.Date;

public class Emprestimo {

	private Long id;

	private Enum status;

	private Date dataSolicitacao;

	private Date dataEmprestimo;

	private String observacaoEmprestimo;

	private Date dataDevolucao;

	private String observacaoDevolucao;

	private ArrayList<Recurso> recursos;
        
	private Servidor solicitante;

	private Servidor aprovador;

	private Servidor recebedor;

}
