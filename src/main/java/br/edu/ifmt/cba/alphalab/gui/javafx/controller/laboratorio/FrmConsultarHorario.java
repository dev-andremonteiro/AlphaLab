package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FrmConsultarHorario {

    @FXML
    private ComboBox<?> cmbLaboratorio;

    @FXML
    private ComboBox<?> cmbProfessor;

    @FXML
    private ComboBox<?> cmbDisciplina;

    @FXML
    private TableView<?> tblConsultarHorario;

    @FXML
    private TableColumn<?, ?> tbcHorario;

    @FXML
    private TableColumn<?, ?> tbcSegunda;

    @FXML
    private TableColumn<?, ?> tbcTerca;

    @FXML
    private TableColumn<?, ?> tbcQuarta;

    @FXML
    private TableColumn<?, ?> tbcQuinta;

    @FXML
    private TableColumn<?, ?> tbcSexta;

    @FXML
    private TableColumn<?, ?> tbcSabado;

    @FXML
    private TableColumn<?, ?> tbcDomingo;

    @FXML
    void cmbDisciplina_onAction(ActionEvent event) {

    }

    @FXML
    void cmbLaboratorio_onAction(ActionEvent event) {

    }

    @FXML
    void cmbProfessor_onAction(ActionEvent event) {

    }

}