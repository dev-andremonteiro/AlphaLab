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

public class FrmSolicitarReservaHorarioPorRequisito {
	@FXML
	private TabPane tabPaneDados;

	@FXML
	private Tab tabRequisitos;

	@FXML
	private DatePicker dtpData;

	@FXML
	private TableView<?> tblHorarioRequisitos;

	@FXML
	private TableColumn<?, ?> tbcHorario;

	@FXML
	private TableColumn<?, ?> tbcDiaSemana;

	@FXML
	private TextField txtNomeSoftware;

	@FXML
	private Button btnBuscar;

	@FXML
	private TableView<?> tblRequisitos;

	@FXML
	private TableColumn<?, ?> tbcSelecionado;

	@FXML
	private TableColumn<?, ?> tbcNome;

	@FXML
	private TableColumn<?, ?> tbcTipo;

	@FXML
	private TextField txtNumMaxAlunos;

	@FXML
	private Button btnProximoRequisitos;

	@FXML
	private Tab tabPreencherDados;

	@FXML
	private Text texRequisitos;

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
	void btnBuscar_onAction(ActionEvent event) {

	}

	@FXML
	void btnBuscar_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnBuscar_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void btnCancelar_onAction(ActionEvent event) {

	}

	@FXML
	void btnCancelar_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnCancelar_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void btnConfirmar_onAction(ActionEvent event) {

	}

	@FXML
	void btnConfirmar_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnConfirmar_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void btnProximoRequisitos_onAction(ActionEvent event) {

	}

	@FXML
	void btnProximoRequisitos_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnProximoRequisitos_onMouseClicked(MouseEvent event) {

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
	void tblHorarioRequisitos_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void tblHorarioRequisitos_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void tblRequisitos_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void tblRequisitos_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void txaObservacao_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void txtDisciplina_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void txtNomeSoftware_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void txtNumMaxAlunos_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void txtTurma_onKeyPressed(KeyEvent event) {

	}
}