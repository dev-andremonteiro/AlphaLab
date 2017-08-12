/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.software;

import br.edu.ifmt.cba.alphalab.business.Software;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.exception.SoftwareException;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;
import br.edu.ifmt.cba.alphalab.gui.javafx.util.Alertas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author tcloss
 */
public class ManutencaoSoftware implements Initializable {

    @FXML
    Tab tabSoftware;
    @FXML
    TabPane tbpGerenciaSoftware;
    @FXML
    Button btnAdicionar;
    @FXML
    Button btnCancelar;
    @FXML
    Button btnExcluir;
    @FXML
    Button btnManutencaoPesquisar;
    @FXML
    Button btnSalvar;
    @FXML
    ComboBox<TipoSoftwareEnum> cbxManutencaoTipoSoftware;
    @FXML
    ComboBox<TipoSoftwareEnum> cbxSoftwareTipo;
    @FXML
    TableView<SoftwareEntity> tblManutencaoSoftware;
    @FXML
    TableColumn<SoftwareEntity, String> tbcDescricao;
    @FXML
    TableColumn<SoftwareEntity, Long> tbcId;
    @FXML
    TableColumn<SoftwareEntity, TipoSoftwareEnum> tbcTipo;
    @FXML
    TableColumn<SoftwareEntity, String> tbcObservacao;
    @FXML
    TableColumn<SoftwareEntity, String> tbcLink;
    @FXML
    TableColumn<SoftwareEntity, String> tbcVersao;
    @FXML
    TextField txtSoftwareVersao;
    @FXML
    TextField txtSoftwareLink;
    @FXML
    TextField txtSoftwareDescricao;
    @FXML
    TextField txtSoftwareId;
    @FXML
    TextField txtManutencaoSoftware;
    @FXML
    TextArea txaSoftwareObservacao;

    private ObservableList<SoftwareEntity> listaSoftwares;
    private Software negocio;
    private SoftwareEntity software;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        software = new SoftwareEntity();
        negocio = new Software(DAOFactory.getDAOFactory().getSoftwareDAO());
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcLink.setCellValueFactory(new PropertyValueFactory<>("link"));
        tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcObservacao.setCellValueFactory(new PropertyValueFactory<>("observacaoInstalacao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcVersao.setCellValueFactory(new PropertyValueFactory<>("versao"));
        cbxManutencaoTipoSoftware.getItems().addAll(TipoSoftwareEnum.values());
        cbxManutencaoTipoSoftware.getSelectionModel().selectFirst();
        cbxSoftwareTipo.getItems().addAll(TipoSoftwareEnum.values());
        listaSoftwares = FXCollections.observableArrayList();
        listaSoftwares.addAll(negocio.buscarTodosSoftwares());
        tblManutencaoSoftware.setItems(listaSoftwares);
        tbpGerenciaSoftware.getSelectionModel().selectLast();
    }

    @FXML
    void btnManutencaoPesquisarOnAction(ActionEvent evt) {
        software = tblManutencaoSoftware.getSelectionModel().getSelectedItem();
        listaSoftwares.clear();
        listaSoftwares.addAll(negocio.buscarPorTipoNome(
                cbxManutencaoTipoSoftware.getSelectionModel().getSelectedItem(),
                txtManutencaoSoftware.getText()
        ));

    }

    public void setSoftware(SoftwareEntity softwareEntity) {
        software = softwareEntity;
        txtSoftwareId.setText(software.getId() != null ? software.getId().toString() : "");
        txtSoftwareDescricao.setText(software.getDescricao());
        txtSoftwareLink.setText(software.getLink());
        txtSoftwareVersao.setText(software.getVersao());
        txaSoftwareObservacao.setText(software.getObservacaoInstalacao());
        cbxSoftwareTipo.getSelectionModel().select(software.getTipo());
    }

    private SoftwareEntity getSoftwareSelected() {
        SoftwareEntity retorno = tblManutencaoSoftware.getSelectionModel().getSelectedItem();
        if (retorno == null) {
            Alertas.exibirAlerta(Alert.AlertType.ERROR, "Erro", "Selecione um software", "Nenhum software foi selecionado na tabela");
        }
        return retorno;

    }

    @FXML
    public void btnEditarOnAction(ActionEvent evt) {
        SoftwareEntity tmpSoftware = getSoftwareSelected();
        if (tmpSoftware != null) {
            setSoftware(tmpSoftware);
            tbpGerenciaSoftware.getSelectionModel().select(tabSoftware);
        }
    }

    @FXML
    public void btnExcluirOnAction(ActionEvent evt) {
        SoftwareEntity tmpSoftware = getSoftwareSelected();
        if (tmpSoftware != null) {
            if (Alertas.exibirAlerta(Alert.AlertType.CONFIRMATION, "Excluir", "Confirmar exclusão?", "Deseja mesmo excluir o software " + tmpSoftware.getDescricao() + "?", Alertas.SIM_NAO_BOTOES).get() == ButtonType.YES) {
                SoftwareException delete = negocio.delete(software);
                if (delete != null) {
                    Alertas.exibirAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao excluir o software", delete.getLocalizedMessage());
                } else {
                    listaSoftwares.remove(tmpSoftware);
                }
            }
        }

    }

    public void limparSoftware() {
        software = null;
        setSoftware(new SoftwareEntity());
    }

    @FXML
    void btnSalvarOnAction(ActionEvent evt) {
        software.setDescricao(txtSoftwareDescricao.getText());
        software.setLink(txtSoftwareLink.getText());
        software.setObservacaoInstalacao(txaSoftwareObservacao.getText());
        software.setVersao(txtSoftwareVersao.getText());
        software.setTipo(cbxSoftwareTipo.getSelectionModel().getSelectedItem());
        SoftwareException save = negocio.save(software);
        if (save == null) {
            limparSoftware();
            listaSoftwares.clear();
            listaSoftwares.addAll(negocio.buscarTodosSoftwares());
            tbpGerenciaSoftware.getSelectionModel().selectNext();
        } else {
            Alertas.exibirAlerta(Alert.AlertType.ERROR, "Erro", "Erro ao inserir software", save.getLocalizedMessage());
        }
    }

    @FXML
    void btnCancelar(ActionEvent evt) {
        limparSoftware();
    }

    @FXML
    void btnNovoOnAction(ActionEvent evt) {
        limparSoftware();
        tbpGerenciaSoftware.getSelectionModel().selectFirst();
    }

}
