/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.equipamentos.RecursoEntity;

/**
 *
 * @author Wesley
 */
public interface IRecursoDAO extends IDAO<RecursoEntity> {
  
  RecursoEntity getByNome(String nome);  
}
