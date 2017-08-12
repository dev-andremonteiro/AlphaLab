/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.dao.mock.software;

import br.edu.ifmt.cba.alphalab.dao.ISoftwareDAO;
import br.edu.ifmt.cba.alphalab.dao.ISolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.dao.mock.exception.MockSolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockLaboratorioDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.EnumTipoServidor;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SituacaoSolicitacaoEnum;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareSolicitacaoEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author tcloss
 */
public class MockSolicitacaoSoftware implements ISolicitacaoSoftware {

    private static MockSolicitacaoSoftware instancia;
    private static final ArrayList<SolicitacaoSoftwareEntity> listaSolicitacao = new ArrayList<>();
    private static List<SoftwareSolicitacaoEntity> sfts = new ArrayList<>();

    {
        sfts.add(new SoftwareSolicitacaoEntity("Sft1", TipoSoftwareEnum.IDE, "1", "lk", "obs", MockServidorDAO.servidor1));
        sfts.add(new SoftwareSolicitacaoEntity("Sft2", TipoSoftwareEnum.IDE, "1", "lk", "obs", MockServidorDAO.servidor2));
        sfts.add(new SoftwareSolicitacaoEntity("Sft3", TipoSoftwareEnum.COMPILADOR, "1", "lk", "obs", MockServidorDAO.servidor1));
    }

    {
        listaSolicitacao.add(new SolicitacaoSoftwareEntity(1L, sfts,
                MockLaboratorioDAO.getInstance().getById(1L),
                Calendar.getInstance(),
                SituacaoSolicitacaoEnum.AGUARDANDO_ATRIBUICAO,
                MockServidorDAO.servidor1,
                MockServidorDAO.servidor2)
        );
        listaSolicitacao.add(new SolicitacaoSoftwareEntity(2L, sfts,
                MockLaboratorioDAO.getInstance().getById(2L),
                Calendar.getInstance(),
                SituacaoSolicitacaoEnum.ATRIBUIDO,
                MockServidorDAO.servidor2,
                MockServidorDAO.servidor2)
        );
    }

    private MockSolicitacaoSoftware() {
    }

    public static MockSolicitacaoSoftware getInstance() {
        if (instancia == null) {
            instancia = new MockSolicitacaoSoftware();
        }
        return instancia;
    }

    @Override
    public void save(SolicitacaoSoftwareEntity entity) {
        if (!listaSolicitacao.contains(entity)) {
            entity.setId(listaSolicitacao.size() + 1);
            listaSolicitacao.add(entity);
        } else {
            listaSolicitacao.set(listaSolicitacao.indexOf(entity), entity);
        }
    }

    @Override
    public void delete(SolicitacaoSoftwareEntity entity) {
        listaSolicitacao.remove(entity);
    }

    @Override
    public SolicitacaoSoftwareEntity getById(Long id) {
        SolicitacaoSoftwareEntity retorno = null;
        for (SolicitacaoSoftwareEntity solicitacao : listaSolicitacao) {
            if (solicitacao.getId().equals(id)) {
                retorno = solicitacao;
                break;
            }
        }
        return retorno;
    }

    @Override
    public void confirmarInstalacaoDeSoftware(SolicitacaoSoftwareEntity solicitacaoSoftwareEntity, SoftwareSolicitacaoEntity softwareSolicitacaoEntity, ServidorEntity concluinte) throws MockSolicitacaoSoftwareException {
        if (listaSolicitacao.contains(solicitacaoSoftwareEntity)) {
            try {
                SolicitacaoSoftwareEntity solicitacao = listaSolicitacao.get(listaSolicitacao.indexOf(solicitacaoSoftwareEntity));
                SoftwareSolicitacaoEntity software = solicitacao.getSoftwares().get(solicitacao.getSoftwares().indexOf(softwareSolicitacaoEntity));
                software.setInstalado(true);
                software.setConcluinte(concluinte);
                solicitacao.getSoftwares().set(solicitacao.getSoftwares().indexOf(softwareSolicitacaoEntity), software);
                save(solicitacao);
            } catch (IndexOutOfBoundsException ex) {
                throw new MockSolicitacaoSoftwareException("Software não encontrado nesta solicitação para confirmação de instalação", ex.getCause());
            }

        }
    }

    @Override
    public List<SolicitacaoSoftwareEntity> buscarTodos() {
        return listaSolicitacao;
    }

    @Override
    public List<SolicitacaoSoftwareEntity> buscarPorData(Calendar data) {
        ArrayList<SolicitacaoSoftwareEntity> retorno = new ArrayList<>();
        listaSolicitacao.forEach(solicitacao -> {
            if (((SolicitacaoSoftwareEntity) solicitacao).getDataPedido().get(Calendar.MONTH) == data.get(Calendar.MONTH)
                    && ((SolicitacaoSoftwareEntity) solicitacao).getDataPedido().get(Calendar.YEAR) == data.get(Calendar.YEAR)
                    && ((SolicitacaoSoftwareEntity) solicitacao).getDataPedido().get(Calendar.DATE) == data.get(Calendar.DATE)) {
                retorno.add(solicitacao);
            }
        });
        return retorno;
    }

    @Override
    public List<SolicitacaoSoftwareEntity> buscaPorServidor(String servidor) {
        ArrayList<SolicitacaoSoftwareEntity> retorno = new ArrayList<>();
        listaSolicitacao.forEach(solicitacao -> {
            if (((SolicitacaoSoftwareEntity) solicitacao).getSolicitante().getNome().toLowerCase().contains(servidor)) {
                retorno.add(solicitacao);
            }
        });
        return retorno;
    }

    @Override
    public List<SolicitacaoSoftwareEntity> buscaPorSituacao(SituacaoSolicitacaoEnum situacaoSolicitacaoEnum) {
        ArrayList<SolicitacaoSoftwareEntity> retorno = new ArrayList<>();
        listaSolicitacao.forEach(solicitacao -> {
            if (((SolicitacaoSoftwareEntity) solicitacao).getSituacaoInstalacao().equals(situacaoSolicitacaoEnum)) {
                retorno.add(solicitacao);
            }
        });
        return retorno;
    }

    @Override
    public List<SolicitacaoSoftwareEntity> buscaPorLaboratorio(LaboratorioEntity laboratorio) {
        ArrayList<SolicitacaoSoftwareEntity> retorno = new ArrayList<>();
        listaSolicitacao.forEach(solicitacao -> {
            if (((SolicitacaoSoftwareEntity) solicitacao).getLaboratorio().getId().equals(laboratorio.getId())) {
                retorno.add(solicitacao);
            }
        });
        return retorno;
    }

}
