package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class FrmSolicitarReservaHorarioPorHorario {
	@FXML
	private TabPane tbpPainel;

	@FXML
	private Tab tabHorarios;

	@FXML
	private ComboBox<?> cmbLaboratorio;

	@FXML
	private DatePicker dtpData;

	@FXML
	private Button btnProximoHorarios;

	@FXML
	private TableView<?> tblHorarios;

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
	private HBox hbxHorarios;

	@FXML
	private TextField txtDisciplina;

	@FXML
	private ComboBox<?> cmbDepartamento;

	@FXML
	private TextField txtTurma;

	@FXML
	private TextArea txaObservacao;

	@FXML
	private CheckBox ckbFixo;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnConfirmar;

	@FXML
	void btnCancelar_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnCancelar_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void btnConfirmar_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnConfirmar_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void btnProximoHorarios_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnProximoHorarios_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void ckbFixo_onAction(MouseEvent event) {

	}

	@FXML
	void cmbDepartamento_onAction(ActionEvent event) {

	}

	@FXML
	void dtpData_onAction(ActionEvent event) {

	}

	@FXML
	void dtpData_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void tblHorarios_onKeyPressed(MouseEvent event) {

	}

	@FXML
	void txaObservacao_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void txtDisciplina_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void txtTurma_onKeyPressed(KeyEvent event) {

	}
}