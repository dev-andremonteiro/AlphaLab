/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.software;

import br.edu.ifmt.cba.alphalab.business.SolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockLaboratorioDAO;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SituacaoSolicitacaoEnum;
import br.edu.ifmt.cba.alphalab.gui.javafx.util.Alertas;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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
            tbcSituacao,
            tbcId,
            tbcDataSolicitacao;
    @FXML TableColumn<SolicitacaoSoftwareView,Boolean> tbcInstalado;
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
        tbcId.setCellValueFactory(new PropertyValueFactory<>("idSolicitacao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcDataSolicitacao.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao"));
        
        tbcInstalado.setCellValueFactory(new PropertyValueFactory<>("instalado"));
        //tbcInstalado.setCellFactory();
        listaSolicitacao=FXCollections.observableArrayList((new SolicitacaoSoftwareView()).setSolicitacao(negocio.buscarTodas()).getList());
        
        tblSolicitacao.setItems(listaSolicitacao);
        /*Deve ser substituido pelo carregamento a partir da classe de negócio, porém esta não estava disponível até o momento da criação*/
        cbxLaboratorio.setItems(FXCollections.observableArrayList(MockLaboratorioDAO.getInstance().buscarTodos()));
        cbxSituacao.setItems(FXCollections.observableArrayList(SituacaoSolicitacaoEnum.values()));
    }
    
    @FXML
    public void btnPesquisarOnAction(ActionEvent evt){
        Calendar c = Calendar.getInstance();
        if(dtpDataPedido.getValue()!=null)
            c.set(dtpDataPedido.getValue().getYear(),dtpDataPedido.getValue().getMonthValue()-1,dtpDataPedido.getValue().getDayOfMonth());
        else
            c=null;
        listaSolicitacao=FXCollections.observableArrayList((new SolicitacaoSoftwareView()).setSolicitacao(negocio.buscaGeral(
                c,
                txtProfessor.getText(), 
                cbxLaboratorio.getSelectionModel().getSelectedItem(), 
                cbxSituacao.getSelectionModel().getSelectedItem())).getList());
        tblSolicitacao.setItems(listaSolicitacao);
        tblSolicitacao.refresh();
    }
    @FXML
    public void btnInstalarOnAction(ActionEvent e)
    {
        SolicitacaoSoftwareView tmp= tblSolicitacao.getSelectionModel().getSelectedItem();
        if(tmp!=null){
            negocio.confirmarInstalacao(tmp.getSolicitacao(), tmp.getSoftware(), MockServidorDAO.servidor4);
            btnPesquisarOnAction(e);
        }
        else{
            Alertas.exibirAlerta(Alert.AlertType.ERROR, "Erro", "Nenhuma solicitação selecionada", "Selecione uma solicitação de instalação para confirma-la");
        }
    }

}
