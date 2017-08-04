/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.software;

import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.entity.software.TipoSoftwareEnum;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author tcloss
 */
public class ManutencaoSoftware implements Initializable{

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
    ChoiceBox<TipoSoftwareEnum> chbManutencaoTipoSoftware;
    @FXML
    ChoiceBox<TipoSoftwareEnum> chbSoftwareTipo;
    @FXML
    TableView<SoftwareEntity> tblManutencaoSoftware;
    @FXML
    TableColumn<SoftwareEntity,String> tbcDescricao;
    @FXML
    TableColumn<SoftwareEntity,Long> tbcId;
    @FXML
    TableColumn<SoftwareEntity,TipoSoftwareEnum> tbcTipo;
    @FXML
    TableColumn<SoftwareEntity,String> tbcObservacao;
    @FXML
    TableColumn<SoftwareEntity,String> tbcLink;
    @FXML
    TableColumn<SoftwareEntity,String> tbcVersao;
    @FXML
    TextField txtSoftwareVersao,txtSoftwareLink,txtSoftwareDescricao,txtSoftwareId,txtManutencaoSoftware;
    @FXML
    TextArea txaSoftwareObservacao;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcLink.setCellValueFactory(new PropertyValueFactory<>("link"));
        tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcObservacao.setCellValueFactory(new PropertyValueFactory<>("observacaoInstalacao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcVersao.setCellValueFactory(new PropertyValueFactory<>("versao"));
        }
    
    
}
