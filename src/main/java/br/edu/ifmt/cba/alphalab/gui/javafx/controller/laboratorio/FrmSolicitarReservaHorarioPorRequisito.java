package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.business.Reserva;
import br.edu.ifmt.cba.alphalab.business.Software;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.software.SoftwareEntity;
import br.edu.ifmt.cba.alphalab.gui.javafx.controller.exemplo.FrmPrincipal;
import br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio.adapter.SoftwareCheckTableView;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * 
 * @author Stévillis Sousa & Yuri Nalin
 * 
 */

public class FrmSolicitarReservaHorarioPorRequisito implements Initializable {
	ResourceBundle resources = ResourceBundle.getBundle(FrmPrincipal.LINGUA_PORTUGUES);

	private Software software = new Software(DAOFactory.getDAOFactory().getSoftwareDAO());
	private Reserva reserva = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());

	private Date dtSolicitacaoReserva = new Date();
	private RequisitoEntity requisitos = new RequisitoEntity();
	private ArrayList<SoftwareEntity> listaSoftwaresSelecionados = new ArrayList<>();
	private ArrayList<ToggleButton> listaBotoes = new ArrayList<>();
	private ArrayList<ToggleButton> listaBotoesSelecionados = new ArrayList<>();
	private ArrayList<Horario> listaHorariosSelecionados = new ArrayList<>();
	private int numMaxAlunos = 0, idSoftwares = 100;

	@FXML
	private TabPane tabPaneDados;

	@FXML
	private Tab tabRequisitos;

	@FXML
	private DatePicker dtpData;

	@FXML
	private TableView<Horario> tblHorarioRequisitos;

	@FXML
	private TableColumn<Horario, String> tbcHorario;

	@FXML
	private TableColumn<Horario, ToggleButton> tbcDiaSemana;

	@FXML
	private TextField txtNomeSoftware;

	@FXML
	private Button btnBuscar;

	@FXML
	private TableView<SoftwareEntity> tblRequisitos;

	@FXML
	private TableColumn<SoftwareEntity, Boolean> tbcSelecionado;

	@FXML
	private TableColumn<SoftwareEntity, String> tbcNome;

	@FXML
	private TableColumn<SoftwareCheckTableView, String> tbcTipo;

	@FXML
	private TextField txtNumMaxAlunos;

	@FXML
	private Button btnProximoRequisitos;

	@FXML
	private Tab tabPreencherDados;

	@FXML
	private Text texRequisitos;

	@FXML
	private VBox vbxSoftwares;

	@FXML
	private HBox hbxHorarios;

	@FXML
	private ComboBox<EnumDisciplina> cmbDisciplina;

	@FXML
	private ComboBox<DepartamentoEntity> cmbDepartamento;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fillColumns();
		iniciarTableViewRequisitos();
		tabPreencherDados.setDisable(true);
		cmbDepartamento.getItems().setAll(DAOFactory.getDAOFactory().getDepartamentoDAO().buscarTodos());
		cmbDisciplina.getItems().setAll(EnumDisciplina.values());
		dtpData.requestFocus();
	}

	/**
	 * Constroi colunas de todos TableViews na aba tabRequisitos
	 */
	private void fillColumns() {
		String estilo = new String("-fx-alignment: CENTER;");

		// Inicializa coluna de horários
		tbcHorario.setStyle(estilo);
		tbcHorario.setCellValueFactory(conteudo -> new SimpleStringProperty(conteudo.getValue().getEstampa()));
		tblHorarioRequisitos.getItems().addAll(Horario.values());

		// Especifica rotina de criação de células para a coluna de botões
		tbcDiaSemana.setStyle(estilo);
		tbcDiaSemana.setCellFactory(col -> new TableCell<Horario, ToggleButton>() {
			@Override
			protected void updateItem(ToggleButton btn, boolean empty) {
				super.updateItem(btn, empty);

				if (empty) {
					setGraphic(null);
				} else if (listaBotoes.size() < 17) {
					btn = new ToggleButton(resources.getString("button.selecionar"));
					listaBotoes.add(btn);
					// Adiciona/retira botões selecionados na lista
					// listaBotoesSelecionados
					btn.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							ToggleButton tgbtn = (ToggleButton) event.getSource();
							if (tgbtn.isSelected()) {
								listaBotoesSelecionados.add(tgbtn);
							} else {
								listaBotoesSelecionados.remove(tgbtn);
							}
						}
					});
					setGraphic(btn);
				} else {
					btn = listaBotoes.get(this.getIndex());
					setGraphic(btn);
				}
			}
		});
	}

	private void iniciarTableViewRequisitos() {
		// 
		List<SoftwareEntity> listaSoftwareEntity = new ArrayList<>();
		listaSoftwareEntity = software.buscarTodosSoftwares();

		tbcNome.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

		tblRequisitos.getItems().clear();
		tblRequisitos.setItems(FXCollections.observableArrayList(listaSoftwareEntity));
		tblRequisitos.refresh();
	}

	/**
	 * Limpa e atualiza coluna de botões selecionáveis. Recebe uma lista das
	 * <b>reservas</b> existentes no dia escolhido para determinar horários
	 * indisponíveis.
	 * 
	 * @param reservas
	 */
	private void refreshColunaBotoes(List<ReservaEntity> reservas) {
		if (!listaBotoesSelecionados.isEmpty()) {
			for (ToggleButton btn : listaBotoesSelecionados) {
				btn.setSelected(false);
			}
			listaBotoesSelecionados.clear();
		}

		for (ToggleButton btn : listaBotoes) {
			if (btn.isDisabled()) {
				btn.setDisable(false);
				btn.setText(resources.getString("button.selecionar"));
			}
		}

		if (!reservas.isEmpty()) {
			for (ReservaEntity reservaEntity : reservas) {
				if (reservaEntity.getStatus() == EnumReserva.CONFIRMADO) {
					for (Horario horario : reservaEntity.getHorarios()) {
						listaBotoes.get(horario.ordinal()).setText(resources.getString("button.indisponivel"));
						listaBotoes.get(horario.ordinal()).setDisable(true);
					}
				}
			}
		}

		tblHorarioRequisitos.refresh();
	}

	/**
	 * Constroi a caixa de horário exibida na tabPreencherDados
	 * 
	 * @return
	 */
	private StackPane buildBoxHorario() {
		VBox vbox = new VBox(7);
		vbox.setAlignment(Pos.CENTER);

		Rectangle rect = new Rectangle(200, 150);
		rect.setStroke(Color.BLACK);
		rect.setStrokeWidth(2);
		rect.setFill(Color.TRANSPARENT);

		Text data = new Text(new SimpleDateFormat("dd/MM/yyyy").format(dtSolicitacaoReserva));
		data.setFont(Font.font("Verdana", FontWeight.BOLD, 12.0));
		vbox.getChildren().add(data);

		for (Horario horario : listaHorariosSelecionados) {
			vbox.getChildren().add(new Text(horario.getEstampa()));
		}

		StackPane caixa = new StackPane(rect, vbox);
		return caixa;
	}

	/**
	 * Id relacionado à cada software selecionado na lista de tblRequisitos.
	 * 
	 * @return um ID do objeto selecionado.
	 */
	private Integer getIdSoftwares() {
		idSoftwares++;
		return idSoftwares;
	}

	/**
	 * Mostra uma caixa de diálogo perguntando se o usuário realmente deseja
	 * cancelar a solicitação de reserva de horário.
	 */
	private void recusarPedidoReserva() {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		ButtonType sim = new ButtonType("Sim");
		ButtonType nao = new ButtonType("Não");
		alerta.setTitle("AlphaLab");
		alerta.setHeaderText("Cancelar pedido de Reserva de Horário");
		alerta.setContentText("Deseja cancelar o pedido de Reserva de Horário?");
		alerta.getButtonTypes().setAll(sim, nao);

		alerta.showAndWait().ifPresent(opcao -> {
			if (opcao == sim) {
				// this.tblRequisitos.getSelectionModel().getSelectedItem().setStatus(Enum.CANCELADA);
			}
			if (opcao == nao) {
			}
		});
	}

	/**
	 * Limpa os campos da tela.
	 */
	private void limparCampos() {
		tblHorarioRequisitos.setItems(null);
		txtNomeSoftware.setText("");
		tblRequisitos.setItems(null);
		txtNumMaxAlunos.setText("");
		texRequisitos.setText("");
		hbxHorarios.getChildren().remove(1, hbxHorarios.getChildren().size());
		cmbDisciplina.getSelectionModel().select(-1);
		cmbDepartamento.getSelectionModel().select(-1);
		txtTurma.setText("");
		txaObservacao.setText("");
		ckbFixo.setSelected(false);
	}

	/**
	 * Guarda os dados selecionados pelo usuário na Tab tabRequisitos.<br>
	 * <b>Dados:</b> Data, Horário, Softwares e Número Máximo de Alunos.
	 */
	private String getDadosTabRequisitos() {
		StringBuilder string = new StringBuilder();
		if (dtpData.getValue() == null) {
			string.append("Data da reserva precisa ser selecionada.\n");
		} else {
			dtSolicitacaoReserva = Date
					.from(dtpData.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		}

		if (listaBotoesSelecionados.isEmpty()) {
			string.append("Ao menos um horário disponível deve ser selecionado.\n");
		} else {
			listaHorariosSelecionados.clear();
			for (ToggleButton btn : listaBotoesSelecionados) {
				listaHorariosSelecionados.add(Horario.values()[listaBotoes.indexOf(btn)]);
			}
		}

		// lista de softwares selecionados

		if (txtNumMaxAlunos.getText() == null || txtNumMaxAlunos.getText() == "") {
			string.append("Número máx. de alunos precisa ser informado.\n");
		} else {
			try {
				numMaxAlunos = Integer.parseInt(txtNumMaxAlunos.getText());

				if (numMaxAlunos < 0) {
					string.append("Número máx. de alunos inválido.\n");
				}
			} catch (NumberFormatException nfe) {
				string.append("Número máx. de alunos inteiro precisa ser informado.\n");
			}
		}

		return string.toString();
	}

	/**
	 * Retorna um ReservaEntity completo com os dados da janela
	 * 
	 * @return
	 */
	private ReservaEntity getDadosTabPreencherDados() {
		ReservaEntity reservaEntity = new ReservaEntity();

		reservaEntity.setDataSolicitacao(dtSolicitacaoReserva);
		reservaEntity.setHorarios(listaHorariosSelecionados);
		requisitos.setQtdAlunos(numMaxAlunos);
		requisitos.setSoftwares(listaSoftwaresSelecionados);
		reservaEntity.setRequisitos(requisitos);
		reservaEntity.setDisciplina(cmbDisciplina.getSelectionModel().getSelectedItem());
		reservaEntity.setDepartamentoAula(cmbDepartamento.getSelectionModel().getSelectedItem());
		reservaEntity.setTurma(txtTurma.getText());
		reservaEntity.setObservacao(txaObservacao.getText());
		reservaEntity.setFixo(ckbFixo.isPressed());

		return reservaEntity;
	}

	@FXML
	void btnBuscar_onAction(ActionEvent event) {
		// buscarSoftwares();
	}

	@FXML
	void btnBuscar_onKeyPressed(KeyEvent event) {
		// if (event.getCode() == KeyCode.ENTER)
		// buscarSoftwares();
	}

	@FXML
	void btnBuscar_onMouseClicked(MouseEvent event) {
		// buscarSoftwares();
	}

	@FXML
	void btnCancelar_onAction(ActionEvent event) {
		tabPreencherDados.setDisable(true);
		tabRequisitos.setDisable(false);
		tabPaneDados.getSelectionModel().select(tabRequisitos);
		limparCampos();
		dtpData.requestFocus();
		// buscarSoftwares();
	}

	@FXML
	void btnCancelar_onKeyPressed(KeyEvent event) {
		// btnCancelar_onAction(new ActionEvent());
	}

	@FXML
	void btnCancelar_onMouseClicked(MouseEvent event) {
		// btnCancelar_onAction(new ActionEvent());
	}

	@FXML
	void btnConfirmar_onAction(ActionEvent event) {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		ButtonType sim = new ButtonType("Sim");
		ButtonType nao = new ButtonType("Não");
		alerta.setTitle("AlphaLab");
		alerta.setHeaderText("Confirmar Reserva de Horário");
		alerta.setContentText("Deseja confirmar a Reserva de Horário?");
		alerta.getButtonTypes().setAll(sim, nao);

		alerta.showAndWait().ifPresent(option -> {
			if (option == sim) {
				ReservaEntity reserva = this.getDadosTabPreencherDados();
				if (reserva.validar() == null) {
					Reserva salvarReserva = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());
					salvarReserva.save(reserva);
				} else {
					Alert alertaDadosInvalidos = new Alert(Alert.AlertType.INFORMATION);
					alertaDadosInvalidos.setTitle("AlphaLab");
					alertaDadosInvalidos.setHeaderText("Dados inconsistentes!");
					alertaDadosInvalidos.setContentText(reserva.validar().getMessage());

					alertaDadosInvalidos.show();
				}

			} else {
				alerta.close();
			}
		});

		tabPaneDados.getSelectionModel().select(tabRequisitos);
		tabPreencherDados.setDisable(true);
	}

	@FXML
	void btnConfirmar_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			btnConfirmar_onAction(new ActionEvent());
		}
	}

	@FXML
	void btnConfirmar_onMouseClicked(MouseEvent event) {
		// btnConfirmar_onAction(new ActionEvent());
	}

	@FXML
	void btnProximoRequisitos_onAction(ActionEvent event) {
		String string = getDadosTabRequisitos();

		if (string.length() > 0) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("AlphaLab");
			alerta.setHeaderText("Dados de Requisitos");
			alerta.setContentText(string);
			alerta.show();
		} else {
			tabPreencherDados.setDisable(false);
			tabRequisitos.setDisable(true);
			tabPaneDados.getSelectionModel().select(tabPreencherDados);
			cmbDisciplina.requestFocus();
			if (hbxHorarios.getChildren().size() > 1)
				hbxHorarios.getChildren().remove(1, hbxHorarios.getChildren().size());
			hbxHorarios.getChildren().add(buildBoxHorario());
			texRequisitos.setText(resources.getString("label.numMaxAlunos") + " " + numMaxAlunos);
			if (!listaSoftwaresSelecionados.isEmpty()) {
				for (SoftwareEntity software : listaSoftwaresSelecionados) {
					vbxSoftwares.getChildren().add(new Text(software.getDescricao()));
				}
			} else {
				// TODO Código de teste. Remover todo o else quando a lista de
				// software estiver
				// implementada.
				vbxSoftwares.getChildren().add(new Text("TESTE\nTESTE"));
			}
			// TabPreencherDados
		}
	}

	@FXML
	void btnProximoRequisitos_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			btnProximoRequisitos_onAction(new ActionEvent());
		}
	}

	@FXML
	void btnProximoRequisitos_onMouseClicked(MouseEvent event) {
		// btnProximoRequisitos_onAction(new ActionEvent());
	}

	@FXML
	void ckbFixo_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.TAB)
			btnConfirmar.requestFocus();
	}

	@FXML
	void cmbDepartamento_onAction(ActionEvent event) {
		txtTurma.requestFocus();
	}

	@FXML
	void dtpData_onAction(ActionEvent event) {
		String diaSemana = new String("column.");
		LocalDate data = dtpData.getValue();
		switch (data.getDayOfWeek()) {
		case MONDAY:
			diaSemana += "segunda";
			break;
		case TUESDAY:
			diaSemana += "terca";
			break;
		case WEDNESDAY:
			diaSemana += "quarta";
			break;
		case THURSDAY:
			diaSemana += "quinta";
			break;
		case FRIDAY:
			diaSemana += "sexta";
			break;
		case SATURDAY:
			diaSemana += "sabado";
			break;
		case SUNDAY:
			diaSemana += "domingo";
		}

		tbcDiaSemana.setText(resources.getString(diaSemana));
		List<ReservaEntity> reservas = new ArrayList<ReservaEntity>(reserva.getAtivosNoDia(data));
		refreshColunaBotoes(reservas);
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
		if (event.getClickCount() >= 2) {
			if (tblRequisitos.getSelectionModel().getSelectedItem() == null) {
				Alert alerta = new Alert(AlertType.INFORMATION);
				alerta.setTitle("AlphaLab");
				alerta.setHeaderText("Seleção de softwares");
				alerta.setContentText("Selecione um software na lista de requisitos!");
				alerta.show();
			} /*
				 * else { SoftwareCheckTableView softwareSelecionado =
				 * this.tblRequisitos.getSelectionModel().getSelectedItem();
				 * SoftwareEntity softwareEntity = new SoftwareEntity();
				 * 
				 * softwareEntity.setId(softwareSelecionado.getSoftwareEntity().
				 * getId()); softwareEntity.setDescricao(softwareSelecionado.
				 * getSoftwareEntity().getDescricao());
				 * softwareEntity.setTipo(softwareSelecionado.getSoftwareEntity(
				 * ).getTipo());
				 * softwareEntity.setConcluinte(softwareSelecionado.
				 * getSoftwareEntity().getConcluinte());
				 * softwareEntity.setLink(softwareSelecionado.getSoftwareEntity(
				 * ).getLink()); softwareEntity
				 * .setObservacao_Instalacao(softwareSelecionado.
				 * getSoftwareEntity().getObservacao_Instalacao());
				 * softwareEntity.setSolicitante(softwareSelecionado.
				 * getSoftwareEntity().getSolicitante());
				 * softwareEntity.setVersao(softwareSelecionado.
				 * getSoftwareEntity().getVersao());
				 * 
				 * if (listaSoftwaresSelecionados.contains(softwareEntity)) {
				 * listaSoftwaresSelecionados.remove(listaSoftwaresSelecionados.
				 * indexOf(softwareEntity)); } else {
				 * listaSoftwaresSelecionados.add(softwareSelecionado.
				 * getSoftwareEntity()); } }
				 */
		}

		for (SoftwareEntity lista : listaSoftwaresSelecionados) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setTitle("AlphaLab");
			alerta.setHeaderText("Softwares selecionados");
			alerta.setContentText(lista.getId() + "\n" + lista.getDescricao() + "\n" + lista.getTipo() + "\n"
					+ lista.getConcluinte() + "\n" + lista.getLink() + "\n" + lista.getObservacao_Instalacao() + "\n"
					+ lista.getSolicitante() + "\n" + lista.getVersao());

			alerta.show();
		}
	}

	@FXML
	void txaObservacao_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.TAB)
			ckbFixo.requestFocus();
	}

	@FXML
	void cmbDisciplina_onAction(ActionEvent event) {
		cmbDepartamento.requestFocus();
	}

	@FXML
	void txtNomeSoftware_onKeyPressed(KeyEvent event) {
		// buscarSoftwares();
	}

	@FXML
	void txtNumMaxAlunos_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER)
			btnProximoRequisitos_onAction(new ActionEvent());
	}

	@FXML
	void txtTurma_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER)
			txaObservacao.requestFocus();
	}
}