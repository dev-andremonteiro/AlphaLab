package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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

	private List<ReservaEntity> reservas = new ArrayList<>();

	@FXML
	void cmbDisciplina_onAction(ActionEvent event) {

	}

	@FXML
	void cmbLaboratorio_onAction(ActionEvent event) {

	}

	@FXML
	void cmbProfessor_onAction(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Inicializar os ComboBox
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
		tblConsultarHorario.getItems().addAll(Horario.values());

		// Especifica rotina de criação de células para a matriz de horários
		tbcSegunda.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) { super.updateItem(txt, empty); updateCelula(this, txt, empty); }
		});
		tbcTerca.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) { super.updateItem(txt, empty); updateCelula(this, txt, empty); }
		});
		tbcQuarta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) { super.updateItem(txt, empty); updateCelula(this, txt, empty); }
		});
		tbcQuinta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) { super.updateItem(txt, empty); updateCelula(this, txt, empty); }
		});
		tbcSexta.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) { super.updateItem(txt, empty); updateCelula(this, txt, empty); }
		});
		tbcSabado.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) { super.updateItem(txt, empty); updateCelula(this, txt, empty); }
		});
		tbcDomingo.setCellFactory(col -> new TableCell<ReservaEntity, Text>() {
			@Override
			protected void updateItem(Text txt, boolean empty) { super.updateItem(txt, empty); updateCelula(this, txt, empty); }
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
	private void updateCelula(TableCell<?, ?> celula, Text txt, boolean empty) {
		if (empty) {
			celula.setGraphic(null);
		} else {
			txt = new Text("teste");
			celula.setGraphic(txt);
		}
	}
}