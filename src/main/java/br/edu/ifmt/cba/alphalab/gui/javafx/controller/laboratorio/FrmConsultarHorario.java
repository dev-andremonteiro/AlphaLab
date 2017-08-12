package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockLaboratorioDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class FrmConsultarHorario implements Initializable {

	@FXML
	private ComboBox<LaboratorioEntity> cmbLaboratorio;

	@FXML
	private ComboBox<ServidorEntity> cmbProfessor;

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

	private List<ReservaEntity> reservas = new ArrayList<ReservaEntity>(DAOFactory.getDAOFactory().getReservaDAO().getAtivosNaSemana(LocalDate.now()));

	private List<ReservaEntity> reservasFiltradas = new ArrayList<>();

	@FXML
	void cmbDisciplina_onAction(ActionEvent event) {
		if (!cmbDisciplina.getSelectionModel().isEmpty()) {
			cmbLaboratorio.getSelectionModel().select(-1);
			cmbProfessor.getSelectionModel().select(-1);
			filtrarReservas();
			tblConsultarHorario.refresh();
		}
	}

	@FXML
	void cmbLaboratorio_onAction(ActionEvent event) {
		if (!cmbLaboratorio.getSelectionModel().isEmpty()) {
			cmbDisciplina.getSelectionModel().select(-1);
			cmbProfessor.getSelectionModel().select(-1);
			filtrarReservas();
			tblConsultarHorario.refresh();
		}
	}

	@FXML
	void cmbProfessor_onAction(ActionEvent event) {
		if (!cmbProfessor.getSelectionModel().isEmpty()) {
			cmbDisciplina.getSelectionModel().select(-1);
			cmbLaboratorio.getSelectionModel().select(-1);
			filtrarReservas();
			tblConsultarHorario.refresh();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cmbDisciplina.getItems().setAll(EnumDisciplina.values());
		cmbLaboratorio.getItems().setAll(DAOFactory.getDAOFactory().getLaboratorioDAO().buscarTodos());
		cmbProfessor.getItems().setAll(DAOFactory.getDAOFactory().getServidorDAO().buscarTodosProfessores());

		fillColumns();
	}

	/**
	 * Preenche as colunas da tabela tblConsultarHorario
	 */
	private void fillColumns() {
		String estilo = new String("-fx-alignment: CENTER;");

		// Inicializa coluna de horários
		tbcHorario.setCellValueFactory(conteudo -> new SimpleStringProperty(conteudo.getValue().getEstampa()));
		tbcHorario.setStyle(estilo);
		tblConsultarHorario.getItems().addAll(Horario.values());

		// Implementação da rotina de criação de células para a matriz de horários
		tbcSegunda.setStyle(estilo);
		tbcSegunda.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcTerca.setStyle(estilo);
		tbcTerca.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcQuarta.setStyle(estilo);
		tbcQuarta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcQuinta.setStyle(estilo);
		tbcQuinta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcSexta.setStyle(estilo);
		tbcSexta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcSabado.setStyle(estilo);
		tbcSabado.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) {
				super.updateItem(txt, empty);
				updateCelula(this, txt, empty);
			}
		});
		tbcDomingo.setStyle(estilo);
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
		txt = new Text(" ");
		if (empty) {
			celula.setGraphic(null);
		} else {
			if (reservasFiltradas.isEmpty()) {
				txt.setText("Selecione um filtro");
			} else {
				for (ReservaEntity reservaEntity : reservasFiltradas) {
					if (reservaEntity.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
							.getDayOfWeek()
							.getValue() == celula.getTableView().getColumns().indexOf(celula.getTableColumn()))
						for (Horario horario : reservaEntity.getHorarios()) {
							if (horario.ordinal() == celula.getIndex())
								txt.setText(criarLabel(reservaEntity) + "\n" + reservaEntity.getTurma());
						}
				}
			}
			celula.setGraphic(txt);
		}
	}

	/**
	 * Povoa a lista reservasFiltradas de acordo com o filtro selecionado
	 */
	private void filtrarReservas() {
		reservasFiltradas.clear();
		if (!cmbDisciplina.getSelectionModel().isEmpty())
			for (ReservaEntity reservaEntity : reservas) {
				if (reservaEntity.getDisciplina().equals(cmbDisciplina.getSelectionModel().getSelectedItem()))
					reservasFiltradas.add(reservaEntity);
			}
		else if (!cmbLaboratorio.getSelectionModel().isEmpty())
			for (ReservaEntity reservaEntity : reservas) {
				if (reservaEntity.getLaboratorio().equals(cmbLaboratorio.getSelectionModel().getSelectedItem()))
					reservasFiltradas.add(reservaEntity);
			}
		else if (!cmbProfessor.getSelectionModel().isEmpty())
			for (ReservaEntity reservaEntity : reservas) {
				if (reservaEntity.getSolicitante().equals(cmbProfessor.getSelectionModel().getSelectedItem()))
					reservasFiltradas.add(reservaEntity);
			}
	}
	
	private String criarLabel(ReservaEntity reservaEntity) {
		if (!cmbDisciplina.getSelectionModel().isEmpty()) {
			return new String(reservaEntity.getSolicitante().getNome() + "\n" + reservaEntity.getLaboratorio().getNome());
		} else if (!cmbLaboratorio.getSelectionModel().isEmpty()){
			return new String(reservaEntity.getSolicitante().getNome() + "\n" + reservaEntity.getDisciplina().toString());
		} else if (!cmbProfessor.getSelectionModel().isEmpty()) {
			return new String(reservaEntity.getDisciplina().toString() + "\n" + reservaEntity.getLaboratorio().getNome());
		}
		
		return null;
	}
}