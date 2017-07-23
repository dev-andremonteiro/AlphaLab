package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.util.Date;

import br.edu.ifmt.cba.alphalab.business.Professor;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumTipoReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ProfessorEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class FrmPedidosReserva {
	@FXML
	private Tab TABPedidos;

	@FXML
	private DatePicker dtpData;

	@FXML
	private ComboBox<?> cmbTipo;

	@FXML
	private ComboBox<?> cmbProfessor;

	@FXML
	private TableView<ReservaEntity> tblPedidos;

	@FXML
	private TableColumn<Long, String> tbcID;

	@FXML
	private TableColumn<Date, String> tbcHorario;

	@FXML
	private TableColumn<Date, String> tbcData;

	@FXML
	private TableColumn<EnumTipoReserva, String> tbcTipo;

	@FXML
	private TableColumn<Boolean, String> tbcFixo;

	@FXML
	private TableColumn<ServidorEntity, String> tbcDados;

	@FXML
	private TableColumn<String, String> tbcDescricao;

	@FXML
	private Tab TABDados;

	@FXML
	private Text texID;

	@FXML
	private Text txtDataPedido;

	@FXML
	private HBox HBXLaboratorio;

	@FXML
	private ComboBox<LaboratorioEntity> cmbLaboratorio;

	@FXML
	private HBox hbxRequisitos;

	@FXML
	private Text texProfessor;

	@FXML
	private Text texDepartamento;

	@FXML
	private Text texTurma;

	@FXML
	private Text texDescricao;

	@FXML
	private Text texDisciplina;

	@FXML
	private HBox hbxHorarios;

	@FXML
	private CheckBox ckbFixo;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnNegar;

	@FXML
	private Button btnPermitir;

	@FXML
	void initialize() {
		Professor professor = new Professor(DAOFactory.getDAOFactory().getProfessorDAO());

		tbcID = new TableColumn<Long, String>("ID");
		tbcHorario = new TableColumn<Date, String>("Horário");
		tbcTipo = new TableColumn<EnumTipoReserva, String>("Tipo");
		tbcFixo = new TableColumn<Boolean, String>("Fixo");
		tbcDados = new TableColumn<ServidorEntity, String>("Dados");
		tbcDescricao = new TableColumn<String, String>("Descrição");

		tbcDados.setCellValueFactory(
				new Callback<TableColumn.CellDataFeatures<ServidorEntity, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(CellDataFeatures<ServidorEntity, String> param) {
						return new ReadOnlyObjectWrapper<String>(param.getValue().getNome());
					}
				});
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
	void btnNegar_onAction(ActionEvent event) {

	}

	@FXML
	void btnNegar_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnNegar_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void btnPermitir_onAction(ActionEvent event) {

	}

	@FXML
	void btnPermitir_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnPermitir_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void cbkFixo_onAction(ActionEvent event) {

	}

	@FXML
	void ckbFixo_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void cmbLaboratorio_onAction(ActionEvent event) {

	}

	@FXML
	void cmbLaboratorio_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void cmbProfessor_onAction(ActionEvent event) {

	}

	@FXML
	void cmbTipo_onAction(ActionEvent event) {

	}

	@FXML
	void cmdLaboratorio_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void dtpData_onAction(ActionEvent event) {

	}

	@FXML
	void dtpData_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void tblPedidos_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void tblPedidos_onMouseClicked(MouseEvent event) {

	}
}