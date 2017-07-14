/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao.mock.software;

import br.edu.ifmt.cba.alphalab.dao.ISoftwareDAO;
import br.edu.ifmt.cba.alphalab.entity.exception.SoftwareException;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tcloss
 */
public class MockSoftwareDAO implements ISoftwareDAO{
    
    private static final ArrayList<SoftwareEntity> listaSoftware = new ArrayList<>();
    {
     //listaSoftware.add(new SoftwareEntity());
    }

    @Override
    public void save(SoftwareEntity entity) {
        if(listaSoftware.indexOf(entity)<0){
            listaSoftware.add(entity);
        }
    }

    @Override
    public void delete(SoftwareEntity entity) {
        listaSoftware.remove(entity);
            
    }

    @Override
    public SoftwareEntity getById(Long id) {
        for(SoftwareEntity vo: listaSoftware){
            if(vo.getId().equals(id))
                return vo;
        }
        return null;
    }

    @Override
    public List<SoftwareEntity> buscarTodos() {
          return listaSoftware;
    }
    
}
