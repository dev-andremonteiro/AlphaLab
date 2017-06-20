package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import java.util.ArrayList;

public class RequisitoEntity implements IEntity {

    private Long id;

    private int qtdAlunos;

    private ArrayList<SoftwareEntity> softwares;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Object validar() {
        return null;
    }
}
