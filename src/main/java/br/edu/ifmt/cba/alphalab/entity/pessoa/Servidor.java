package br.edu.ifmt.cba.alphalab.entity.pessoa;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.Departamento;

public class Servidor {

	private Long id;

	private String nome;

	private String email;

	private String telefone;

	private String login;

	private String senha;

	private Enum tipo;

	private Departamento departamento;
}
