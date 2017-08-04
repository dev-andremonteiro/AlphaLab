package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio.adapter;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;

public class SoftwareCheckTableView {
	private Boolean check;
	private SoftwareEntity softwareEntity;

	public SoftwareCheckTableView(SoftwareEntity entity) {
		this.check = false;
		softwareEntity = entity;
	}

	public static List<SoftwareCheckTableView> convert(List<SoftwareEntity> lista) {
		List<SoftwareCheckTableView> result = new ArrayList<>();
		for (SoftwareEntity s : lista)
			result.add(new SoftwareCheckTableView(s));
		return result;
	}

	public String getDescricao() {
		return softwareEntity.getDescricao();
	}

	public Enum getTipo() {
		return softwareEntity.getTipo();
	}

	public void setSelecionado(Boolean bool) {
		this.check = bool;
	}

	public boolean getSelecionado() {
		return this.check;
	}

	/**
	 * @return the softwareEntity
	 */
	public SoftwareEntity getSoftwareEntity() {
		return softwareEntity;
	}

	/**
	 * @param softwareEntity the softwareEntity to set
	 */
	public void setSoftwareEntity(SoftwareEntity softwareEntity) {
		this.softwareEntity = softwareEntity;
	}
	
}
