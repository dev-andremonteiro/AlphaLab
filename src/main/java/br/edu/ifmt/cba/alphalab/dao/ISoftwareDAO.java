/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author tcloss
 */
public interface ISoftwareDAO extends IDAO<SoftwareEntity> {
    public List<SoftwareEntity> buscarTodos();
    public List<SoftwareEntity> buscarPorNome(String nome);
    public List<SoftwareEntity> buscarPorTipoNome(TipoSoftwareEnum tipo, String nome);
}
