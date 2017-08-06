package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.business.Professor;
import br.edu.ifmt.cba.alphalab.business.Reserva;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumTipoReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ProfessorEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * 
 * @author Stévillis Sousa
 *
 */

public class FrmPedidosReserva implements Initializable {
	private List<RequisitoEntity> listaRequisitos = new ArrayList<>();
	private Reserva reserva = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());
	private Professor professor = new Professor(DAOFactory.getDAOFactory().getProfessorDAO());

	@FXML
	private TabPane tbpDados;

	@FXML
	private Tab tabPedidos;

	@FXML
	private DatePicker dtpData;

	@FXML
	private ComboBox<EnumTipoReserva> cmbTipo;

	@FXML
	private ComboBox<ProfessorEntity> cmbProfessor;

	@FXML
	private TableView<ReservaEntity> tblPedidos;

	@FXML
	private TableColumn<ReservaEntity, Long> tbcID;

	@FXML
	private TableColumn<ReservaEntity, Date> tbcHorario;

	@FXML
	private TableColumn<ReservaEntity, Date> tbcData;

	@FXML
	private TableColumn<ReservaEntity, Boolean> tbcTipo;

	@FXML
	private TableColumn<ReservaEntity, Boolean> tbcFixo;

	@FXML
	private TableColumn<ReservaEntity, String> tbcDados;

	@FXML
	private TableColumn<ReservaEntity, String> tbcDescricao;

	@FXML
	private Tab tabDados;

	@FXML
	private Text texID;

	@FXML
	private Text txtDataPedido;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tblPedidos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		limparDados();
		dtpData.requestFocus();

		tabPedidos.setDisable(false);
		// tabDados.setDisable(true);

		ObservableList<EnumTipoReserva> comboTipo = FXCollections.observableArrayList(EnumTipoReserva.ANUAL,
				EnumTipoReserva.MENSAL, EnumTipoReserva.SEMANAL, EnumTipoReserva.SEMESTRAL);
		cmbTipo.setItems(comboTipo);

		ObservableList<ProfessorEntity> professores = FXCollections.observableArrayList(professor.buscarTodos());
		cmbProfessor.setItems(professores);

		preencherDadosTblPedidos(reserva.buscarTodasReservas());
	}

	/**
	 * Limpa o formulário da tela.
	 */
	private void limparDados() {
		dtpData.setValue(null);
		dtpData.setPromptText("Data");
		cmbTipo.getSelectionModel().select(null);
		cmbTipo.setPromptText("Tipo");
		cmbProfessor.getSelectionModel().select(null);
		cmbProfessor.setPromptText("Professor");
		tblPedidos.setItems(null);
		texID.setText("");
		txtDataPedido.setText("");
		cmbLaboratorio.getSelectionModel().select(null);
		cmbLaboratorio.setPromptText("Laboratório");
		hbxRequisitos.getChildren().remove(1, hbxRequisitos.getChildren().size());
		texProfessor.setText("");
		texDisciplina.setText("");
		texDepartamento.setText("");
		texTurma.setText("");
		texDescricao.setText("");
		hbxHorarios.getChildren().remove(1, hbxHorarios.getChildren().size());
		ckbFixo.setSelected(false);
	}

	/**
	 * Cancela a operação de Gerenciar Pedidos de Reserva e\n retorna à aba
	 * inicial.
	 */
	private void cancelarGerenciarPedido() {
		limparDados();
		tabDados.setDisable(true);
		tabPedidos.setDisable(false);
		tbpDados.getSelectionModel().select(tabPedidos);
		preencherDadosTblPedidos(reserva.buscarTodasReservas());
	}

	/**
	 * Preenche o formulário da aba Visualizar Dados com os dados\n do pedido
	 * selecionado na aba Pedidos.
	 */
	private void preencherVisualizarDados(ReservaEntity reservaEntity) {
		limparDados();

		tabPedidos.setDisable(true);
		tabDados.setDisable(false);

		texID.setText(reservaEntity.getId().toString());
		txtDataPedido.setText(reservaEntity.getDataSolicitacao().toString());
		// hbxRequisitos
		texProfessor.setText(reservaEntity.getSolicitante().getNome());
		texDisciplina.setText(reservaEntity.getDisciplina());
		texDepartamento.setText(reservaEntity.getDepartamentoAula().getNome());
		texTurma.setText(reservaEntity.getTurma());
		texDescricao.setText(reservaEntity.getObservacao());
		// hbxHorarios
		ckbFixo.setSelected(false);
	}

	private void preencherDadosTblPedidos(List<ReservaEntity> listaReserva) {

		tbcID.setCellValueFactory(new PropertyValueFactory<>("id"));
		// Em andamento: lista de horários solicitados para a reserva
		tbcHorario.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao"));
		tbcData.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao"));
		// Em andamento: dedicir o que colocar aqui
		tbcTipo.setCellValueFactory(new PropertyValueFactory<>("fixo"));
		tbcFixo.setCellValueFactory(new PropertyValueFactory<>("fixo"));
		tbcDados.setCellValueFactory(new PropertyValueFactory<>("solicitante"));
		tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("observacao"));

		tblPedidos.setItems(FXCollections.observableArrayList(listaReserva));
		tblPedidos.refresh();
	}

	@FXML
	void btnCancelar_onAction(ActionEvent event) {
	}

	@FXML
	void btnCancelar_onKeyPressed(KeyEvent event) {
		cancelarGerenciarPedido();

	}

	@FXML
	void btnCancelar_onMouseClicked(MouseEvent event) {
		cancelarGerenciarPedido();

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
		if (dtpData.getValue() != null) {
			preencherDadosTblPedidos(reserva.getByData(java.sql.Date.valueOf(dtpData.getValue())));
		}
	}

	@FXML
	void dtpData_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER && dtpData.getValue() != null) {
			preencherDadosTblPedidos(reserva.getByData(java.sql.Date.valueOf(dtpData.getValue())));
		}
	}

	@FXML
	void tblPedidos_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			if (tblPedidos.getSelectionModel().getSelectedItem() != null) {
				preencherVisualizarDados(tblPedidos.getSelectionModel().getSelectedItem());
				tbpDados.getSelectionModel().select(tabDados);
			}
		}
	}

	@FXML
	void tblPedidos_onMouseClicked(MouseEvent event) {
		if (event.getClickCount() >= 2) {
			if (tblPedidos.getSelectionModel().getSelectedItem() != null) {
				preencherVisualizarDados(tblPedidos.getSelectionModel().getSelectedItem());

				tbpDados.getSelectionModel().select(tabDados);
			}
		}
	}
}