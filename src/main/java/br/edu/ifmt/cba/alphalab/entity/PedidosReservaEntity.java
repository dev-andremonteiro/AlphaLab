package br.edu.ifmt.cba.alphalab.entity;

import java.util.Date;
import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.exception.PedidosReservaException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumTipoReserva;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class PedidosReservaEntity implements IEntity<PedidosReservaException> {
	private Long id;
	private List<Date> horario;
	private EnumTipoReserva tipo;
	private String dados;
	private String descricao;

	public PedidosReservaEntity() {
	}

	public PedidosReservaEntity(Long id, List<Date> horario, EnumTipoReserva tipo, String dados, String descricao) {
		super();
		this.id = id;
		this.horario = horario;
		this.tipo = tipo;
		this.dados = dados;
		this.descricao = descricao;
	}

	/**
	 * @return the horario
	 */
	public List<Date> getHorario() {
		return horario;
	}

	/**
	 * @param horario
	 *            the horario to set
	 */
	public void setHorario(List<Date> horario) {
		this.horario = horario;
	}

	/**
	 * @return the tipo
	 */
	public EnumTipoReserva getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(EnumTipoReserva tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the dados
	 */
	public String getDados() {
		return dados;
	}

	/**
	 * @param dados
	 *            the dados to set
	 */
	public void setDados(String dados) {
		this.dados = dados;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidosReservaEntity other = (PedidosReservaEntity) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public PedidosReservaException validar() {
		StringBuilder msg = new StringBuilder();

		if (horario == null)
			msg.append("Horário da Reserva precisa ser informado!");
		if (tipo == null)
			msg.append("Tipo de Reserva de Horário precisa ser informado!");
		if (dados != null && dados.trim().length() < 10)
			msg.append("Informe os dados do Pedido de Reserva");
		if (descricao != null && descricao.trim().length() < 15)
			msg.append("Informe uma descrição mais detalhada do Pedido de Reserva");

		if (msg.length() < 0)
			return new PedidosReservaException(msg.toString());
		else
			return null;
	}
}
