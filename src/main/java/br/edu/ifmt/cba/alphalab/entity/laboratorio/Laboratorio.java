package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.equipamentos.Equipamento;
import br.edu.ifmt.cba.alphalab.entity.software.Software;
import java.util.ArrayList;


public class Laboratorio {

	private Long id;

	private String nome;

	private Enum situacao;

	private int capacidade;

	private String observacao;

	private Departamento departamento;

	private Equipamento equipamento;

	private ArrayList<Software> software;

	private ArrayList<Equipamento> equipamentos;


}
