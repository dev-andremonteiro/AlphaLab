/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.software;

import br.edu.ifmt.cba.alphalab.business.SolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockLaboratorioDAO;
import br.edu.ifmt.cba.alphalab.entity.exception.SolicitacaoSoftwareException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.EnumTipoServidor;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SituacaoSolicitacaoEnum;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareSolicitacaoEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SolicitacaoSoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;
import br.edu.ifmt.cba.alphalab.gui.javafx.util.Alertas;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author tcloss
 */
public class TelaSoftware implements Initializable {

    @FXML
    private TableView<SoftwareSolicitacaoEntity> tblSoftware;
    @FXML
    private TableColumn<SoftwareSolicitacaoEntity, String> tbcDescricao, tbcVersao, tbcTipo, tbcObservacaoInstalacao;
    private ObservableList<SoftwareSolicitacaoEntity> listaSoftwares;
    private SolicitacaoSoftwareEntity solicitacao;
    private SolicitacaoSoftware negocio;
    @FXML
    private TextField txtDescricao, txtLink, txtVersao;
    @FXML
    private TextArea txaObservacao;
    @FXML
    private ComboBox<TipoSoftwareEnum> cbxTipo;
    @FXML
    private ComboBox<LaboratorioEntity> cbxLaboratorio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaSoftwares = FXCollections.observableArrayList();
        solicitacao = new SolicitacaoSoftwareEntity();
        negocio = new SolicitacaoSoftware(DAOFactory.getDAOFactory().getSolicitacaoSoftwareDAO());
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcVersao.setCellValueFactory(new PropertyValueFactory<>("versao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcObservacaoInstalacao.setCellValueFactory(new PropertyValueFactory<>("observacaoInstalacao"));
        tblSoftware.setItems(listaSoftwares);
        cbxTipo.getItems().addAll(TipoSoftwareEnum.values());
        cbxTipo.getSelectionModel().selectFirst();
        /*Deve ser substituido pelo carregamento a partir da classe de negócio, porém esta não estava disponível até o momento da criação*/
        cbxLaboratorio.setItems(FXCollections.observableArrayList(MockLaboratorioDAO.getInstance().buscarTodos()));
    }

    @FXML
    public void btnAddOnAction(ActionEvent evt) {
        listaSoftwares.add(new SoftwareSolicitacaoEntity(txtDescricao.getText(),
                cbxTipo.getSelectionModel().getSelectedItem(),
                txtVersao.getText(),
                txtLink.getText(),
                txaObservacao.getText(),
                null));
    }

    @FXML
    public void btnSalvarOnAction(ActionEvent evt) {
        if (listaSoftwares.size() > 0) {
            solicitacao.setLaboratorio(cbxLaboratorio.getSelectionModel().getSelectedItem());
            solicitacao.setDataPedido(Calendar.getInstance());
            solicitacao.setSituacaoInstalacao(SituacaoSolicitacaoEnum.AGUARDANDO_ATRIBUICAO);
            solicitacao.setSoftwares(new ArrayList<>(listaSoftwares));
            solicitacao.setSolicitante(new ServidorEntity(1L, "Servidor 01", "e-maill","fone", "lg","", EnumTipoServidor.TEC_ADM, null));
            SolicitacaoSoftwareException save = negocio.save(solicitacao);
            if (save == null) {
                Alertas.exibirAlerta(Alert.AlertType.INFORMATION, "Salvar", "Solicitação gravada com sucesso", "Sua solicitação foi gravada com o código " + solicitacao.getId().toString() + " e sua situação atual é " + solicitacao.getSituacaoInstalacao().getDescricao());
            } else {
                Alertas.exibirAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao gravar a solicitação", save.getLocalizedMessage());
            }
        } else {
            Alertas.exibirAlerta(Alert.AlertType.ERROR, "Erro", "Nenhum software adicionado", "Nenhum software foi adicionado a solicitação");
        }

    }

    @FXML
    public void btnCancelarOnAction(ActionEvent e) {
        setSolicitacao(new SolicitacaoSoftwareEntity());
    }
    
    public void setSolicitacao(SolicitacaoSoftwareEntity solicitacaoSoftwareEntity){
        solicitacao=solicitacaoSoftwareEntity;
        listaSoftwares.clear();
        listaSoftwares.addAll(FXCollections.observableArrayList(solicitacao.getSoftwares()));
        cbxLaboratorio.getSelectionModel().select(solicitacao.getLaboratorio());
    }

}
