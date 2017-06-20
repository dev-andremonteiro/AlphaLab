package br.edu.ifmt.cba.alphalab.entity.laboratorio;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import java.util.ArrayList;

public class LaboratorioEntity implements IEntity {

    private Long id;

    private String nome;

    private Enum situacao;

    private int capacidade;

    private String observacao;

    private DepartamentoEntity departamento;

    private EquipamentoEntity equipamento;

    private ArrayList<SoftwareEntity> software;

    private ArrayList<EquipamentoEntity> equipamentos;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Object validar() {
        return null;
    }

}
