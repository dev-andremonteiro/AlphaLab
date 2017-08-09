package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class FrmGerenciarHorario implements Initializable{

    @FXML
    private Tab tabVisualizar;

    @FXML
    private ComboBox<?> cmbLaboratorio;

    @FXML
    private Button btnProximo;

    @FXML
    private TableView<?> tblGerenciarHorario;

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
    private Tab tabPreencherDados;

    @FXML
    private Text texLaboratorio;

    @FXML
    private ComboBox<?> cmbProfessor;

    @FXML
    private TextField txtDisciplina;

    @FXML
    private ComboBox<?> cmbDepartamento;

    @FXML
    private TextField txtTurma;

    @FXML
    private TextArea txaObservacoes;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnVoltar;

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {

    }

    @FXML
    void btnProximo_onAction(ActionEvent event) {

    }

    @FXML
    void btnProximo_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnVoltar_onAction(ActionEvent event) {

    }

    @FXML
    void cmbDepartamento_onAction(ActionEvent event) {

    }

    @FXML
    void cmbLaboratorio_onAction(ActionEvent event) {

    }

    @FXML
    void cmbProfessor_onAction(ActionEvent event) {

    }

    @FXML
    void cmbProfessor_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void tabPreencherDados_onSelectionChanged(ActionEvent event) {

    }

    @FXML
    void tabVisualizar_onSelectionChanged(ActionEvent event) {

    }

    @FXML
    void txaObservacoes_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtDisciplina_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void txtTurma_onKeyPressed(KeyEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}

