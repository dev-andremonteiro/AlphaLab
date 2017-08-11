/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.software;

import br.edu.ifmt.cba.alphalab.business.SolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockLaboratorioDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SituacaoSolicitacaoEnum;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author tcloss
 */
public class GerenciarInstalacaoSoftware implements Initializable {

    @FXML
    private TableColumn<SolicitacaoSoftwareView, String> tbcProfessor,
            tbcSoftware,
            tbcObservacaoInstalacao,
            tbcLaboratorio,
            tbcTipo,
            tbcSituacao;
    @FXML
    private TableView<SolicitacaoSoftwareView> tblSolicitacao;
    @FXML
    private DatePicker dtpDataPedido;
    @FXML
    private TextField txtProfessor;
    @FXML
    private ComboBox<LaboratorioEntity> cbxLaboratorio;
    @FXML
    private ComboBox<SituacaoSolicitacaoEnum> cbxSituacao;
    private ObservableList listaSolicitacao;
    private SolicitacaoSoftware negocio;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        negocio=new SolicitacaoSoftware(DAOFactory.getDAOFactory().getSolicitacaoSoftwareDAO());
        tbcSituacao.setCellValueFactory(new PropertyValueFactory<>("situacaoInstalacao"));
        tbcProfessor.setCellValueFactory(new PropertyValueFactory<>("solicitante"));
        tbcSoftware.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcObservacaoInstalacao.setCellValueFactory(new PropertyValueFactory<>("observacaoInstalacao"));
        tbcLaboratorio.setCellValueFactory(new PropertyValueFactory<>("laboratorio"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        listaSolicitacao=FXCollections.observableArrayList((new SolicitacaoSoftwareView()).setSolicitacao(negocio.buscarTodas()).getList());
        tblSolicitacao.setItems(listaSolicitacao);
        /*Deve ser substituido pelo carregamento a partir da classe de negócio, porém esta não estava disponível até o momento da criação*/
        cbxLaboratorio.setItems(FXCollections.observableArrayList(MockLaboratorioDAO.getInstance().buscarTodos()));
        cbxSituacao.setItems(FXCollections.observableArrayList(SituacaoSolicitacaoEnum.values()));
    }
    
    @FXML
    public void btnPesquisarOnAction(ActionEvent evt){
        listaSolicitacao=FXCollections.observableArrayList((new SolicitacaoSoftwareView()).setSolicitacao(negocio.buscarPorSolicitante(txtProfessor.getText())).getList());
        tblSolicitacao.setItems(listaSolicitacao);
    }

}
