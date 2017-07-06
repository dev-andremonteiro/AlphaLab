package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.RequisitoException;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import java.util.ArrayList;

public class RequisitoEntity implements IEntity<RequisitoException> {

    private Long id;

    private int qtdAlunos;

    private ArrayList<SoftwareEntity> softwares;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public RequisitoException validar() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public ArrayList<SoftwareEntity> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(ArrayList<SoftwareEntity> softwares) {
        this.softwares = softwares;
    }
}
