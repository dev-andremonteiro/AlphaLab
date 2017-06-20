package br.edu.ifmt.cba.alphalab.entity;

import java.io.Serializable;

public interface IEntity<EXCEPTION> extends Serializable {
	
	Long getId();
	EXCEPTION validar();
	
}
