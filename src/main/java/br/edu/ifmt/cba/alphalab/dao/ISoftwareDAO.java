/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import java.util.List;

/**
 *
 * @author tcloss
 */
public interface ISoftwareDAO extends IDAO<SoftwareEntity> {
    public List<SoftwareEntity> buscarTodos();
}
