/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao.mock.software;

import br.edu.ifmt.cba.alphalab.dao.ISoftwareDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tcloss
 */
public class MockSoftwareDAO implements ISoftwareDAO {
	private static MockSoftwareDAO instance;
	private static final List<SoftwareEntity> listaSoftware = new ArrayList<>();
	private static MockServidorDAO servidor = new MockServidorDAO();

	private static final SoftwareEntity software1 = new SoftwareEntity();
	private static final SoftwareEntity software2 = new SoftwareEntity();

	static {
		software1.setId(1L);
		software1.setDescricao("Word 2016");
		software1.setTipo(TipoSoftwareEnum.EDITOR_TEXTO);
		software1.setVersao("2.0");
		software1.setLink("http://www.microsoft.com.br");
		software1.setObservacao_Instalacao("Instalado");
		software1.setSolicitante(servidor.getById(1L));
		software1.setConcluinte(servidor.getById(2L));

		software2.setId(2L);
		software2.setDescricao("Pycharm");
		software2.setTipo(TipoSoftwareEnum.EDITOR_TEXTO);
		software2.setVersao("3.0");
		software2.setLink("http://www.jetbrains.com");
		software2.setObservacao_Instalacao("Instalado");
		software2.setSolicitante(servidor.getById(2L));
		software2.setConcluinte(servidor.getById(1L));

		listaSoftware.add(software1);
		listaSoftware.add(software2);
	}

	private MockSoftwareDAO() {
	}

	public static MockSoftwareDAO getInstance() {
		if (instance != null)
			return instance;
		else
			return new MockSoftwareDAO();
	}

	@Override
	public void save(SoftwareEntity entity) {
		if (listaSoftware.indexOf(entity) < 0) {
			listaSoftware.add(entity);
		}
                else
                {
                    listaSoftware.set(listaSoftware.indexOf(entity), entity);
                }
	}

	@Override
	public void delete(SoftwareEntity entity) {
		listaSoftware.remove(entity);

	}

	@Override
	public SoftwareEntity getById(Long id) {
		for (SoftwareEntity vo : listaSoftware) {
			if (vo.getId().equals(id))
				return vo;
		}
		return null;
	}

	@Override
	public List<SoftwareEntity> buscarPorNome(String nome) {
		List<SoftwareEntity> retorno = new ArrayList<>();
		listaSoftware.forEach(software -> {
			if (software.getDescricao().contains(nome))
				retorno.add(software);
		});
		return retorno;
	}

	@Override
	public List<SoftwareEntity> buscarPorTipoNome(TipoSoftwareEnum tipo, String nome) {
		List<SoftwareEntity> retorno = new ArrayList<>();
		List<SoftwareEntity> nomes = buscarPorNome(nome);
		nomes.forEach(software -> {
			if (software.getTipo().equals(tipo))
				retorno.add(software);
		});
		return retorno;
	}

	@Override
	public List<SoftwareEntity> buscarTodos() {
		return listaSoftware;
	}

}