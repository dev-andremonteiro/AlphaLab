package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import br.edu.ifmt.cba.alphalab.business.Reserva;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.mock.laboratorio.MockLaboratorioDAO;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumDisciplina;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumTipoReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.gui.javafx.controller.exemplo.FrmPrincipal;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	private TableColumn<Horario, HorarioAdapter> tbcSegunda;

	@FXML
	private TableColumn<Horario, HorarioAdapter> tbcTerca;

	@FXML
	private TableColumn<Horario, HorarioAdapter> tbcQuarta;

	@FXML
	private TableColumn<Horario, HorarioAdapter> tbcQuinta;

	@FXML
	private TableColumn<Horario, HorarioAdapter> tbcSexta;

	@FXML
	private TableColumn<Horario, HorarioAdapter> tbcSabado;

	@FXML
	private TableColumn<Horario, HorarioAdapter> tbcDomingo;

	@FXML
	private TabPane tbpDados;

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
	private HBox hbxHorarios;

	@FXML
	private TextField txtTurma;

	@FXML
	private TextArea txaObservacoes;

	@FXML
	private Button btnConfirmar;

	@FXML
	private Button btnVoltar;

	ResourceBundle resources = ResourceBundle.getBundle(FrmPrincipal.LINGUA_PORTUGUES);

	private List<ReservaEntity> reservas = new ArrayList<ReservaEntity>(
			DAOFactory.getDAOFactory().getReservaDAO().getAtivosNaSemana(LocalDate.now()));

	private List<ReservaEntity> reservasFiltradas = new ArrayList<>();

	private ArrayList<HorarioAdapter> matriz = new ArrayList<>();

	private ArrayList<StackPane> listaSelecionados = new ArrayList<>();

	private Set<TableColumn<Horario, HorarioAdapter>> diasAReservar = new HashSet<>();

	private List<ReservaEntity> novasReservas = new ArrayList<>();

	static final Comparator<ReservaEntity> DATA_INICIO = new Comparator<ReservaEntity>() {
		public int compare(ReservaEntity r1, ReservaEntity r2) {
			return r1.getDataInicio().compareTo(r2.getDataInicio());
		}
	};

	@FXML
	void btnConfirmar_onAction(ActionEvent event) {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		ButtonType sim = new ButtonType("Sim");
		ButtonType nao = new ButtonType("Não");
		alerta.setTitle("AlphaLab");
		alerta.setHeaderText("Confirmar Reserva de Horário");
		alerta.setContentText("Deseja confirmar as Reservas de Horário?");
		alerta.getButtonTypes().setAll(sim, nao);

		alerta.showAndWait().ifPresent(option -> {
			if (option == sim) {
				Reserva salvarReserva = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());
				for (ReservaEntity reserva : novasReservas) {
					setDados(reserva);

					if (reserva.validar() == null) {
						salvarReserva.save(reserva);
					} else {
						Alert alertaDadosInvalidos = new Alert(Alert.AlertType.INFORMATION);
						alertaDadosInvalidos.setTitle("AlphaLab");
						alertaDadosInvalidos.setHeaderText("Dados inconsistentes!");
						alertaDadosInvalidos.setContentText(reserva.validar().getMessage());

						alertaDadosInvalidos.show();
						break;
					}
				}
				tbpDados.getSelectionModel().select(tabVisualizar);
				tabPreencherDados.setDisable(true);
				tabVisualizar.setDisable(false);
				atualizarReservas();
				cmbLaboratorio_onAction(new ActionEvent());
			} else {
				alerta.close();
			}
		});
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
		} else {
			tabVisualizar.setDisable(true);
			tabPreencherDados.setDisable(false);
			tbpDados.getSelectionModel().select(tabPreencherDados);
			texLaboratorio.setText(cmbLaboratorio.getValue().getNome());
			if (hbxHorarios.getChildren() != null)
				hbxHorarios.getChildren().clear();
			criarNovasReservas();
			hbxHorarios.getChildren().addAll(buildBoxHorario());
			cmbProfessor.requestFocus();
		}
	}

	@FXML
	void btnProximo_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnVoltar_onAction(ActionEvent event) {
		tabPreencherDados.setDisable(true);
		tabVisualizar.setDisable(false);
		tbpDados.getSelectionModel().select(tabVisualizar);
		cmbLaboratorio.requestFocus();
	}

	@FXML
	void cmbDepartamento_onAction(ActionEvent event) {

	}

	@FXML
	void cmbDisciplina_onAction(ActionEvent event) {

	}

	@FXML
	void cmbLaboratorio_onAction(ActionEvent event) {
		if (!listaSelecionados.isEmpty())
			listaSelecionados.clear();
		filtrarReservas();
		tblGerenciarHorario.refresh();
	}

	@FXML
	void cmbProfessor_onAction(ActionEvent event) {

	}

	@FXML
	void cmbProfessor_onKeyPressed(KeyEvent event) {

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
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < 16; j++) {
				matriz.add(new HorarioAdapter(i, j, new StackPane(), null));
			}
		}
		tabPreencherDados.setDisable(true);

		cmbDisciplina.getItems().setAll(EnumDisciplina.values());
		cmbLaboratorio.getItems().setAll(DAOFactory.getDAOFactory().getLaboratorioDAO().buscarTodos());
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
		tbcSegunda.setCellFactory(col -> new TableCell<Horario, HorarioAdapter>() {
			@Override
			protected void updateItem(HorarioAdapter adapter, boolean empty) {
				super.updateItem(adapter, empty);
				updateCelula(this, adapter, empty);
			}
		});
		tbcTerca.setStyle(estilo);
		tbcTerca.setCellFactory(col -> new TableCell<Horario, HorarioAdapter>() {
			@Override
			protected void updateItem(HorarioAdapter adapter, boolean empty) {
				super.updateItem(adapter, empty);
				updateCelula(this, adapter, empty);
			}
		});
		tbcQuarta.setStyle(estilo);
		tbcQuarta.setCellFactory(col -> new TableCell<Horario, HorarioAdapter>() {
			@Override
			protected void updateItem(HorarioAdapter adapter, boolean empty) {
				super.updateItem(adapter, empty);
				updateCelula(this, adapter, empty);
			}
		});
		tbcQuinta.setStyle(estilo);
		tbcQuinta.setCellFactory(col -> new TableCell<Horario, HorarioAdapter>() {
			@Override
			protected void updateItem(HorarioAdapter adapter, boolean empty) {
				super.updateItem(adapter, empty);
				updateCelula(this, adapter, empty);
			}
		});
		tbcSexta.setStyle(estilo);
		tbcSexta.setCellFactory(col -> new TableCell<Horario, HorarioAdapter>() {
			@Override
			protected void updateItem(HorarioAdapter adapter, boolean empty) {
				super.updateItem(adapter, empty);
				updateCelula(this, adapter, empty);
			}
		});
		tbcSabado.setStyle(estilo);
		tbcSabado.setCellFactory(col -> new TableCell<Horario, HorarioAdapter>() {
			@Override
			protected void updateItem(HorarioAdapter adapter, boolean empty) {
				super.updateItem(adapter, empty);
				updateCelula(this, adapter, empty);
			}
		});
		tbcDomingo.setStyle(estilo);
		tbcDomingo.setCellFactory(col -> new TableCell<Horario, HorarioAdapter>() {
			@Override
			protected void updateItem(HorarioAdapter adapter, boolean empty) {
				super.updateItem(adapter, empty);
				updateCelula(this, adapter, empty);
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
	private void updateCelula(TableCell<Horario, HorarioAdapter> celula, HorarioAdapter adapter, boolean empty) {

		if (empty) {
			celula.setGraphic(null);
		} else {
			adapter = matriz.get(
					((tblGerenciarHorario.getColumns().indexOf(celula.getTableColumn()) - 1) << 4) + celula.getIndex());
			adapter.clearPane();

			if (cmbLaboratorio.getSelectionModel().isEmpty()) {
				adapter.addNode(new Text("Selecione um lab."));
			} else {
				if (!reservasFiltradas.isEmpty()) {
					for (ReservaEntity reservaEntity : reservasFiltradas) {
						if (reservaEntity.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
								.getDayOfWeek().getValue() == adapter.getColuna())
							for (Horario horario : reservaEntity.getHorarios()) {
								if (horario.ordinal() == adapter.getLinha()) {
									adapter.setReserva(reservaEntity);
									adapter.setHorario(horario);

									Button btn = new Button("X");
									btn.setTextFill(Color.RED);

									btn.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent event) {
											HorarioAdapter adapter = new HorarioAdapter();
											for (HorarioAdapter hAdapter : matriz) {
												if (hAdapter.getPane().equals(btn.getParent())) {
													adapter = hAdapter;
													break;
												}
											}

											SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
											String conteudo = new String(
													formatter.format(adapter.getReserva().getDataInicio())
															+ "\n-------------\n");
											for (Horario horario : adapter.getReserva().getHorarios()) {
												conteudo += (horario.getEstampa() + "\n");
											}

											Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
											ButtonType confirmar = new ButtonType(
													resources.getString("button.confirmar"));
											ButtonType cancelar = new ButtonType(
													resources.getString("button.cancelar"));
											alerta.setTitle("AlphaLab");
											alerta.setHeaderText("Cancelar de Reserva de Horário");
											alerta.setContentText(
													"Tem certeza que deseja cancelar esta Reserva de Horário?\n\n"
															+ conteudo);
											alerta.getButtonTypes().setAll(confirmar, cancelar);

											alerta.showAndWait().ifPresent(opcao -> {
												if (opcao == confirmar) {
													for (HorarioAdapter hAdapter : matriz) {
														if (hAdapter.getPane().equals(btn.getParent())) {
															hAdapter.getReserva().setStatus(EnumReserva.CANCELADA);
															atualizarReservas();
															tblGerenciarHorario.refresh();
															break;
														}
													}
												}
												if (opcao == cancelar) {
												}
											});
										}
									});

									adapter.addNode(new Text(reservaEntity.getSolicitante().getNome() + "\n"
											+ reservaEntity.getDisciplina().toString() + "\n"
											+ reservaEntity.getDepartamentoAula().getSigla() + " "
											+ reservaEntity.getTurma()));
									adapter.addNode(btn);
									StackPane.setAlignment(btn, Pos.CENTER_RIGHT);
								}
							}
					}
				}

				if (adapter.getPane().getChildren().isEmpty()) {
					ToggleButton btn = new ToggleButton(resources.getString("button.selecionar"));

					btn.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							ToggleButton btn = (ToggleButton) event.getSource();
							if (btn.isSelected()) {
								listaSelecionados.add((StackPane) btn.getParent());
							} else {
								listaSelecionados.remove((StackPane) btn.getParent());
							}
						}
					});

					adapter.addNode(btn);
				}
			}
			celula.setGraphic(adapter.getPane());
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
		} else if (listaSelecionados.isEmpty()) {
			string.append("Ao menos um horário disponível deve ser selecionado!\n");
		}

		return string.toString();
	}

	private List<StackPane> buildBoxHorario() {
		List<StackPane> boxHorarios = new ArrayList<>();

		for (ReservaEntity reservaEntity : novasReservas) {

			VBox vbox = new VBox(7);
			vbox.setAlignment(Pos.CENTER);

			Rectangle rect = new Rectangle(100, 150);
			rect.setStroke(Color.BLACK);
			rect.setStrokeWidth(2);
			rect.setFill(Color.TRANSPARENT);

			Text data = new Text(new SimpleDateFormat("dd/MM/yyyy").format(reservaEntity.getDataInicio()));
			data.setFont(Font.font("Verdana", FontWeight.BOLD, 12.0));
			vbox.getChildren().add(data);

			for (Horario horario : reservaEntity.getHorarios()) {
				vbox.getChildren().add(new Text(horario.getEstampa()));
			}

			boxHorarios.add(new StackPane(rect, vbox));
		}

		return boxHorarios;
	}

	/**
	 * Inicializa as reservas para cada dia selecionado
	 */
	private void criarNovasReservas() {
		diasAReservar.clear();
		for (StackPane pane : listaSelecionados) {
			for (HorarioAdapter adapter : matriz) {
				if (adapter.getPane().equals(pane))
					diasAReservar.add((TableColumn<Horario, HorarioAdapter>) tblGerenciarHorario.getColumns()
							.get(adapter.getColuna()));
			}
		}

		LocalDate dtAux = LocalDate.now();
		if (!dtAux.getDayOfWeek().equals(DayOfWeek.MONDAY))
			dtAux = dtAux.minusDays((long) dtAux.getDayOfWeek().getValue() - 1);

		novasReservas.clear();
		for (TableColumn<Horario, HorarioAdapter> tableColumn : diasAReservar) {
			ReservaEntity novaReserva = new ReservaEntity();
			novaReserva
					.setDataInicio(Date.from((dtAux.plusDays(tblGerenciarHorario.getColumns().indexOf(tableColumn) - 1)
							.atStartOfDay(ZoneId.systemDefault()).toInstant())));
			novasReservas.add(novaReserva);
		}

		for (ReservaEntity reserva : novasReservas) {

			int k = ((reserva.getDataInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek()
					.getValue() - 1) << 4);
			if (reserva.getHorarios() != null) {
				reserva.getHorarios().clear();
			} else {
				reserva.setHorarios(new ArrayList<>());
			}

			for (int i = k; i < (k + 16); i++) {
				if (listaSelecionados.contains(matriz.get(i).getPane()))
					reserva.getHorarios().add(Horario.values()[matriz.get(i).getLinha()]);
			}
		}
		Collections.sort(novasReservas, DATA_INICIO);
	}

	private void setDados(ReservaEntity reserva) {
		reserva.setId(
				Long.parseLong("" + (DAOFactory.getDAOFactory().getReservaDAO().buscarTodasReservas().size() + 1)));
		reserva.setSolicitante(cmbProfessor.getValue());
		reserva.setDisciplina(cmbDisciplina.getValue());
		reserva.setDepartamentoAula(cmbDepartamento.getValue());
		reserva.setTurma(txtTurma.getText());
		reserva.setObservacao(txaObservacoes.getText());
		reserva.setDataSolicitacao(reserva.getDataInicio());
		reserva.setDataFim(reserva.getDataInicio());
		reserva.setDataAprovacaoRecusa(reserva.getDataInicio());
		reserva.setLaboratorio(cmbLaboratorio.getValue());
		// TODO Aprovador deve ser obtido automaticamente quando a funcionalidade de
		// login for implementada
		reserva.setAprovador(DAOFactory.getDAOFactory().getServidorDAO().getById(1L));
		reserva.setStatus(EnumReserva.CONFIRMADO);
		reserva.setTipo(EnumTipoReserva.UNICA);
	}

	private void atualizarReservas() {
		reservas.clear();
		reservas.addAll(DAOFactory.getDAOFactory().getReservaDAO().getAtivosNaSemana(LocalDate.now()));
		filtrarReservas();
	}

	private class HorarioAdapter {
		private int coluna, linha;
		private StackPane pane;
		private ReservaEntity reserva;
		private Horario horario;

		public HorarioAdapter() {
			super();
		}

		public HorarioAdapter(int coluna, int linha, StackPane pane, ReservaEntity reserva) {
			super();
			this.coluna = coluna;
			this.linha = linha;
			this.pane = pane;
			this.reserva = reserva;
			this.horario = Horario.values()[linha];
		}

		public void clearPane() {
			this.pane.getChildren().clear();
		}

		public void addNode(Node no) {
			this.pane.getChildren().add(no);
		}

		public int getColuna() {
			return coluna;
		}

		public void setColuna(int coluna) {
			this.coluna = coluna;
		}

		public int getLinha() {
			return linha;
		}

		public void setLinha(int linha) {
			this.linha = linha;
		}

		public StackPane getPane() {
			return pane;
		}

		public void setPane(StackPane pane) {
			this.pane = pane;
		}

		public ReservaEntity getReserva() {
			return reserva;
		}

		public void setReserva(ReservaEntity reserva) {
			this.reserva = reserva;
		}

		public Horario getHorario() {
			return horario;
		}

		public void setHorario(Horario horario) {
			this.horario = horario;
		}
	}
}