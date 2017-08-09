package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockLaboratorioDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class FrmGerenciarHorario implements Initializable {

	@FXML
	private Tab tabVisualizar;

	@FXML
	private ComboBox<LaboratorioEntity> cmbLaboratorio;

	@FXML
	private Button btnProximo;

	@FXML
	private TableView<Horario> tblGerenciarHorario;

	@FXML
	private TableColumn<Horario, String> tbcHorario;

	@FXML
	private TableColumn<ReservaEntity, StackPane> tbcSegunda;

	@FXML
	private TableColumn<ReservaEntity, StackPane> tbcTerca;

	@FXML
	private TableColumn<ReservaEntity, StackPane> tbcQuarta;

	@FXML
	private TableColumn<ReservaEntity, StackPane> tbcQuinta;

	@FXML
	private TableColumn<ReservaEntity, StackPane> tbcSexta;

	@FXML
	private TableColumn<ReservaEntity, StackPane> tbcSabado;

	@FXML
	private TableColumn<ReservaEntity, StackPane> tbcDomingo;

	@FXML
	private Tab tabPreencherDados;

	@FXML
	private Text texLaboratorio;

	@FXML
	private ComboBox<ServidorEntity> cmbProfessor;

	@FXML
	private ComboBox<EnumDisciplina> cmbDisciplina;

	@FXML
	private ComboBox<DepartamentoEntity> cmbDepartamento;

	@FXML
	private HBox hbxHorario;

	@FXML
	private TextField txtTurma;

	@FXML
	private TextArea txaObservacoes;

	@FXML
	private Button btnConfirmar;

	@FXML
	private Button btnVoltar;
	
	private ArrayList<ToggleButton> listaBotoes = new ArrayList<>();
	
	private ArrayList<ToggleButton> listaBotoesSelecionados = new ArrayList<>();

	private List<ReservaEntity> reservas = new ArrayList<ReservaEntity>(
			DAOFactory.getDAOFactory().getReservaDAO().getAtivosNaSemana(LocalDate.now()));

	private List<ReservaEntity> reservasFiltradas = new ArrayList<>();

	@FXML
	void btnConfirmar_onAction(ActionEvent event) {

	}

	@FXML
	void btnProximo_onAction(ActionEvent event) {
		String string = getDadosTabVisualizar();

		if (string.length() > 0) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("AlphaLab");
			alerta.setHeaderText("Dados de Requisitos");
			alerta.setContentText(string);
			alerta.show();
		}
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
	void cmbDisciplina_onAction(ActionEvent event) {

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
		tabPreencherDados.setDisable(true);

		cmbDisciplina.getItems().setAll(EnumDisciplina.values());
		MockLaboratorioDAO laboratorio = new MockLaboratorioDAO();
		cmbLaboratorio.getItems().setAll(laboratorio.buscarTodos());
		// TODO Camada de negocio para Laboratorio ainda não foi implementada...
		// cmbLaboratorio.getItems().setAll(DAOFactory.getDAOFactory().getLaboratorioDAO().buscarTodos());
		cmbProfessor.getItems().setAll(DAOFactory.getDAOFactory().getServidorDAO().buscarTodosProfessores());
		cmbDepartamento.getItems().setAll(DAOFactory.getDAOFactory().getDepartamentoDAO().buscarTodos());

		fillColumns();
	}

	private void fillColumns() {
		String estilo = new String("-fx-alignment: CENTER;");

		// Inicializa coluna de horários
		tbcHorario.setCellValueFactory(conteudo -> new SimpleStringProperty(conteudo.getValue().getEstampa()));
		tbcHorario.setStyle(estilo);
		tblGerenciarHorario.getItems().addAll(Horario.values());

		// Implementação da rotina de criação de células para a matriz de horários
		tbcSegunda.setStyle(estilo);
		tbcSegunda.setCellFactory(col -> new TableCell<ReservaEntity, StackPane>() {
			@Override
			protected void updateItem(StackPane pane, boolean empty) {
				super.updateItem(pane, empty);
				updateCelula(this, pane, empty);
			}
		});
		tbcTerca.setStyle(estilo);
		tbcTerca.setCellFactory(col -> new TableCell<ReservaEntity, StackPane>() {
			@Override
			protected void updateItem(StackPane pane, boolean empty) {
				super.updateItem(pane, empty);
				updateCelula(this, pane, empty);
			}
		});
		tbcQuarta.setStyle(estilo);
		tbcQuarta.setCellFactory(col -> new TableCell<ReservaEntity, StackPane>() {
			@Override
			protected void updateItem(StackPane pane, boolean empty) {
				super.updateItem(pane, empty);
				updateCelula(this, pane, empty);
			}
		});
		tbcQuinta.setStyle(estilo);
		tbcQuinta.setCellFactory(col -> new TableCell<ReservaEntity, StackPane>() {
			@Override
			protected void updateItem(StackPane pane, boolean empty) {
				super.updateItem(pane, empty);
				updateCelula(this, pane, empty);
			}
		});
		tbcSexta.setStyle(estilo);
		tbcSexta.setCellFactory(col -> new TableCell<ReservaEntity, StackPane>() {
			@Override
			protected void updateItem(StackPane pane, boolean empty) {
				super.updateItem(pane, empty);
				updateCelula(this, pane, empty);
			}
		});
		tbcSabado.setStyle(estilo);
		tbcSabado.setCellFactory(col -> new TableCell<ReservaEntity, StackPane>() {
			@Override
			protected void updateItem(StackPane pane, boolean empty) {
				super.updateItem(pane, empty);
				updateCelula(this, pane, empty);
			}
		});
		tbcDomingo.setStyle(estilo);
		tbcDomingo.setCellFactory(col -> new TableCell<ReservaEntity, StackPane>() {
			@Override
			protected void updateItem(StackPane pane, boolean empty) {
				super.updateItem(pane, empty);
				updateCelula(this, pane, empty);
			}
		});
	}

	/**
	 * O único propósito deste método é evitar a repetição de código dentro das
	 * implementações de updateItem das células da matriz
	 * 
	 * @param celula
	 * @param txt
	 * @param empty
	 */
	private void updateCelula(TableCell<ReservaEntity, StackPane> celula, StackPane pane, boolean empty) {
		pane = new StackPane();
		if (empty) {
			celula.setGraphic(null);
		} else {
			if (reservasFiltradas.isEmpty()) {
				pane.getChildren().add(new Text("Selecione um lab."));
			} else {

			}
			celula.setGraphic(pane);
		}
	}

	/**
	 * Povoa a lista reservasFiltradas de acordo com o filtro selecionado
	 */
	private void filtrarReservas() {
		reservasFiltradas.clear();
		if (!cmbLaboratorio.getSelectionModel().isEmpty())
			for (ReservaEntity reservaEntity : reservas) {
				if (reservaEntity.getLaboratorio().equals(cmbLaboratorio.getSelectionModel().getSelectedItem()))
					reservasFiltradas.add(reservaEntity);
			}
	}
	
	private String getDadosTabVisualizar() {
		StringBuilder string = new StringBuilder();
		if (cmbLaboratorio.getSelectionModel().isEmpty()) {
			string.append("Selecione um laboratório para ver os horário a gerenciar.\n");
		} else if (listaBotoesSelecionados.isEmpty()){
			string.append("Ao menos um horário disponível deve ser selecionado!\n");
		}

		return string.toString();
	}
}
