/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.software;

import br.edu.ifmt.cba.alphalab.business.SolicitacaoSoftware;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareSolicitacaoEntity;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author tcloss
 */
public class TelaSoftware implements Initializable{
    @FXML
    private TableView<SoftwareSolicitacaoEntity> tblSoftware;
    @FXML
    private TableColumn<SoftwareSolicitacaoEntity,String> tbcDescricao,tbcVersao,tbcTipo,tbcObservacaoInstalacao;
    private ObservableList<SoftwareSolicitacaoEntity> listaSoftwares;
    private  SolicitacaoSoftware negocio;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        negocio=new SolicitacaoSoftware(DAOFactory.getDAOFactory().getSolicitacaoSoftwareDAO());
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcVersao.setCellValueFactory(new PropertyValueFactory<>("versao"));
        tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tbcObservacaoInstalacao.setCellValueFactory(new PropertyValueFactory<>("observacaoInstalacao"));
        tblSoftware.setItems(listaSoftwares);
    }
    
}
