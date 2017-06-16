package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.pessoa.Servidor;
import java.util.ArrayList;
import java.util.Date;

public class Reserva {

	private Long id;

	private Enum status;

	private Date dataSolicitacao;

	private String disciplina;

	private String turma;

	private String observacao;

	private boolean fixo;

	private Date dataInicio;

	private Date dataFim;
        
        private Date dataAprovacaoRecusa;

	private String justificativa;

	private Laboratorio laboratorio;

	private Departamento departamentoAula;

        private Servidor solicitante;
        
	private Servidor aprovador;

	private ArrayList<Requisito> requisitos;

}
