package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.business.Reserva;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ProfessorEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class FrmConsultarHorario implements Initializable {

	@FXML
	private ComboBox<LaboratorioEntity> cmbLaboratorio;

	@FXML
	private ComboBox<ProfessorEntity> cmbProfessor;

	@FXML
	private ComboBox<EnumDisciplina> cmbDisciplina;

	@FXML
	private TableView<Horario> tblConsultarHorario;

	@FXML
	private TableColumn<Horario, String> tbcHorario;

	@FXML
	private TableColumn<ReservaEntity, Text> tbcSegunda;

	@FXML
	private TableColumn<ReservaEntity, Text> tbcTerca;

	@FXML
	private TableColumn<ReservaEntity, Text> tbcQuarta;

	@FXML
	private TableColumn<ReservaEntity, Text> tbcQuinta;

	@FXML
	private TableColumn<ReservaEntity, Text> tbcSexta;

	@FXML
	private TableColumn<ReservaEntity, Text> tbcSabado;

	@FXML
	private TableColumn<ReservaEntity, Text> tbcDomingo;

	@FXML
	private Button btnReset;

	private Reserva reservaDAO = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());

	private List<ReservaEntity> reservas = new ArrayList<ReservaEntity>(reservaDAO.getAtivosNaSemana(LocalDate.now()));

	@FXML
	void cmbDisciplina_onAction(ActionEvent event) {
		// tblConsultarHorario.refresh();
		// TODO Código de teste
		System.out.println("\t--" + cmbDisciplina.getSelectionModel().getSelectedIndex() + " "
				+ cmbDisciplina.getSelectionModel().isEmpty());
	}

	@FXML
	void cmbLaboratorio_onAction(ActionEvent event) {
		// tblConsultarHorario.refresh();
	}

	@FXML
	void cmbProfessor_onAction(ActionEvent event) {
		// tblConsultarHorario.refresh();
	}

	@FXML
	void btnReset_onAction(ActionEvent event) {
		cmbDisciplina.getSelectionModel().select(-1);
		cmbLaboratorio.getSelectionModel().select(-1);
		cmbProfessor.getSelectionModel().select(-1);
		tblConsultarHorario.refresh();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbDisciplina.getItems().setAll(EnumDisciplina.values());
		// cmbLaboratorio.getItems.setAll(DAOFactory.getDAOFactory().getLaboratorioDAO().buscarTodos());
		cmbProfessor.getItems().setAll(DAOFactory.getDAOFactory().getProfessorDAO().buscarTodos());
		fillColumns();
	}

	/**
	 * Preenche as colunas da tabela tblConsultarHorario
	 */
	private void fillColumns() {
		// TODO Lembrar que as células de horário deverão ser ocupadas por uma caixa
		// contendo Departamento e Código da Turma.

		// Inicializa coluna de horários
		tbcHorario.setCellValueFactory(conteudo -> new SimpleStringProperty(conteudo.getValue().getEstampa()));
		tbcHorario.setStyle("-fx-alignment: CENTER;");
		tblConsultarHorario.getItems().addAll(Horario.values());

		// Especifica rotina de criação de células para a matriz de horários
		tbcSegunda.setStyle("-fx-alignment: CENTER;");
		tbcSegunda.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcTerca.setStyle("-fx-alignment: CENTER;");
		tbcTerca.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcQuarta.setStyle("-fx-alignment: CENTER;");
		tbcQuarta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcQuinta.setStyle("-fx-alignment: CENTER;");
		tbcQuinta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcSexta.setStyle("-fx-alignment: CENTER;");
		tbcSexta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcSabado.setStyle("-fx-alignment: CENTER;");
		tbcSabado.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcDomingo.setStyle("-fx-alignment: CENTER;");
		tbcDomingo.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
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
	private void updateCelula(TableCell<ReservaEntity, Text> celula, Text txt, boolean empty) {
		if (empty) {
			celula.setGraphic(null);
		} else {
			if (!(cmbDisciplina.getSelectionModel().isEmpty() || cmbLaboratorio.getSelectionModel().isEmpty()
					|| cmbProfessor.getSelectionModel().isEmpty())) {
				
			} else {
				System.out.println("\t" + celula.getTableColumn().getText() + " x " + celula.getIndex());
				txt = new Text("Selecione um filtro");
			}
			celula.setGraphic(txt);
		}
	}
}