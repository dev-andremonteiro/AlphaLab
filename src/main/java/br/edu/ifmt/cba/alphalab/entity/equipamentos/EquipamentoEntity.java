package br.edu.ifmt.cba.alphalab.entity.equipamentos;

import br.edu.ifmt.cba.alphalab.entity.IEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.EquipamentoException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import java.util.Date;

public class EquipamentoEntity implements IEntity<EquipamentoException> {

	private Long id;
        
        private EnumEquipamento status;

	private String descricao;
        
        private Long qtdeEstoque;
        private Long qtdeEmprestada;
    public EnumEquipamento getStatus() {
        return status;
    }

    public void setStatus(EnumEquipamento status) {
        this.status = status;
    }

	private String patrimonio;

	private Enum tipo;

	private Date dataAquisicao;

	private String observacao;

	private LaboratorioEntity laboratorio;
        
        private EmprestimoEntity emprestimo;

	public EquipamentoEntity() {
	}

	public EquipamentoEntity(Long id, String descricao, String patrimonio, Enum tipo, Date dataAquisicao,
			String observacao, LaboratorioEntity laboratorio) {
		this.id = id;
		this.descricao = descricao;
		this.patrimonio = patrimonio;
		this.tipo = tipo;
		this.dataAquisicao = dataAquisicao;
		this.observacao = observacao;
		this.laboratorio = laboratorio;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public EquipamentoException validar() {
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public Enum getTipo() {
		return tipo;
	}

	public void setTipo(Enum tipo) {
		this.tipo = tipo;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public LaboratorioEntity getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(LaboratorioEntity laboratorio) {
		this.laboratorio = laboratorio;
	}
        
         public EmprestimoEntity getEmprestimo() {
         return emprestimo;
        }

        public void setEmprestimo(EmprestimoEntity emprestimo) {
        this.emprestimo = emprestimo;
        }

    /**
     * @return the qtdeEstoque
     */
    public Long getQtdeEstoque() {
        return qtdeEstoque;
    }

    /**
     * @param qtdeEstoque the qtdeEstoque to set
     */
    public void setQtdeEstoque(Long qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    /**
     * @return the qtdeEmprestada
     */
    public Long getQtdeEmprestada() {
        return qtdeEmprestada;
    }

    /**
     * @param qtdeEmprestada the qtdeEmprestada to set
     */
    public void setQtdeEmprestada(Long qtdeEmprestada) {
        this.qtdeEmprestada = qtdeEmprestada;
    }
}
