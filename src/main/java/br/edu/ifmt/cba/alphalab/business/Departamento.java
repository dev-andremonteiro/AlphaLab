/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.business;

import br.edu.ifmt.cba.alphalab.dao.IClienteDAO;
import br.edu.ifmt.cba.alphalab.dao.IDAO;
import br.edu.ifmt.cba.alphalab.dao.IDepartamentoDAO;
import br.edu.ifmt.cba.alphalab.dao.ISoftwareDAO;
import br.edu.ifmt.cba.alphalab.entity.ClienteEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.DepartamentoException;
import br.edu.ifmt.cba.alphalab.entity.exception.SoftwareException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import java.util.List;

/**
 *
 * @author harri
 */
public class Departamento extends ABusiness<DepartamentoEntity, DepartamentoException, IDepartamentoDAO> {

    public Departamento(IDAO<DepartamentoEntity> dao) {
        super(dao);
    }
    
    public List<DepartamentoEntity> getByNome(String nome){
		return ((IDepartamentoDAO)dao).getByNome(nome);
	}
    public List<DepartamentoEntity> getBySigla(String sigla){
		return ((IDepartamentoDAO)dao).getBySigla(sigla);
	}
    
}
