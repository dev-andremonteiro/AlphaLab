package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.business.Reserva;
import br.edu.ifmt.cba.alphalab.business.Servidor;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.EnumTipoReserva;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.Horario;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.EnumTipoServidor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * 
 * @author St�villis Sousa
 *
 */

public class FrmPedidosReserva implements Initializable {
	private List<RequisitoEntity> listaRequisitos = new ArrayList<>();
	private Reserva reserva = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());
	private Servidor servidor = new Servidor(DAOFactory.getDAOFactory().getServidorDAO());

	private ReservaEntity reservaSelecionada = null;

	@FXML
	private TabPane tbpDados;

	@FXML
	private Tab tabPedidos;

	@FXML
	private DatePicker dtpData;

	@FXML
	private ComboBox<EnumTipoReserva> cmbTipo;

	@FXML
	private ComboBox<EnumTipoServidor> cmbServidor;

	@FXML
	private TableView<ReservaEntity> tblPedidos;

	@FXML
	private TableColumn<ReservaEntity, Long> tbcID;

	@FXML
	private TableColumn<ReservaEntity, Horario> tbcHorario;

	@FXML
	private TableColumn<ReservaEntity, Date> tbcData;

	@FXML
	private TableColumn<ReservaEntity, String> tbcTipo;

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
	private Text texTipoReserva;

	@FXML
	private HBox hbxHorarios;

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

		tabDados.setDisable(true);

		/*
		 * TODO Sugest�o: Como esse campo n�o existe mais, voc� pode transformar
		 * ele em SEMESTRAL e UNICA (al�m de tirar esse atributo da entidade) e
		 * a� filtra pelas reservas que tem mesmo dia de come�o e fim (isso d�
		 * pra fazer em uma linha usando LocalDate).
		 */
		ObservableList<EnumTipoReserva> comboTipo = FXCollections.observableArrayList(EnumTipoReserva.UNICA,
				EnumTipoReserva.SEMESTRAL);
		cmbTipo.setItems(comboTipo);

		ObservableList<EnumTipoServidor> servidores = FXCollections.observableArrayList(EnumTipoServidor.ESTAGIARIO,
				EnumTipoServidor.PROFESSOR, EnumTipoServidor.TEC_ADM, EnumTipoServidor.TEC_LABORATORIO);
		cmbServidor.setItems(servidores);

		preencherDadosTblPedidos(reserva.buscarTodasReservas());
	}

	/**
	 * Limpa o formul�rio da tela.
	 */
	private void limparDados() {
		dtpData.setValue(null);
		dtpData.setPromptText("Data");
		cmbTipo.getSelectionModel().select(-1);
		cmbServidor.getSelectionModel().select(-1);
		tblPedidos.setItems(null);
		texID.setText("");
		txtDataPedido.setText("");
		cmbLaboratorio.getSelectionModel().select(-1);
		hbxRequisitos.getChildren().remove(1, hbxRequisitos.getChildren().size());
		texProfessor.setText("");
		texDisciplina.setText("");
		texDepartamento.setText("");
		texTurma.setText("");
		texDescricao.setText("");
		hbxHorarios.getChildren().remove(1, hbxHorarios.getChildren().size());
		texTipoReserva.setText("");
	}

	/**
	 * Cancela a opera��o de Gerenciar Pedidos de Reserva e\n retorna � aba
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
	 * Preenche o formul�rio da aba Visualizar Dados com os dados\n do pedido
	 * selecionado na aba Pedidos.
	 */
	private void preencherVisualizarDados(ReservaEntity reservaEntity) {
		limparDados();

		tabPedidos.setDisable(true);
		tabDados.setDisable(false);

		cmbLaboratorio.getItems().setAll(DAOFactory.getDAOFactory().getLaboratorioDAO().buscarTodos());

		texID.setText(reservaEntity.getId().toString());
		txtDataPedido.setText(reservaEntity.getDataSolicitacao().toString());
		if (hbxRequisitos.getChildren().size() > 1)
			hbxRequisitos.getChildren().remove(1, hbxRequisitos.getChildren().size());
		hbxRequisitos.getChildren().add(buildBoxRequisitos(reservaEntity.getRequisitos()));
		texProfessor.setText(reservaEntity.getSolicitante().getNome());
		texDisciplina.setText(reservaEntity.getDisciplina().toString());
		texDepartamento.setText(reservaEntity.getDepartamentoAula().getNome());
		texTurma.setText(reservaEntity.getTurma());
		texDescricao.setText(reservaEntity.getObservacao());
		if (hbxHorarios.getChildren().size() > 1)
			hbxHorarios.getChildren().remove(1, hbxHorarios.getChildren().size());
		hbxHorarios.getChildren().add(buildBoxHorarios(reservaEntity.getHorarios()));
		texTipoReserva.setText(reservaEntity.getTipo().name());
	}

	private void preencherDadosTblPedidos(List<ReservaEntity> listaReserva) {

		tbcID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tbcHorario.setCellValueFactory(new PropertyValueFactory<>("horarios"));
		tbcData.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao"));
		tbcTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tbcDados.setCellValueFactory(new PropertyValueFactory<>("solicitante"));
		tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("observacao"));

		tblPedidos.setItems(FXCollections.observableArrayList(listaReserva));
		tblPedidos.refresh();
	}

	private StackPane buildBoxRequisitos(RequisitoEntity requisito) {
		VBox vbox = new VBox(7);
		vbox.setAlignment(Pos.CENTER);

		vbox.getChildren().add(new Text(requisito.toString()));

		StackPane caixa = new StackPane(vbox);
		return caixa;
	}

	private StackPane buildBoxHorarios(List<Horario> horarios) {
		VBox vbox = new VBox(7);
		vbox.setAlignment(Pos.CENTER);

		Rectangle rect = new Rectangle(150, 100);
		rect.setStroke(Color.BLACK);
		rect.setStrokeWidth(2);
		rect.setFill(Color.TRANSPARENT);

		for (Horario horario : horarios) {
			vbox.getChildren().add(new Text(horario.getEstampa()));
		}

		StackPane caixa = new StackPane(rect, vbox);
		return caixa;
	}

	private void negarPedidoReserva() {
		if (reservaSelecionada != null) {
			Locale locale = new Locale("pt", "BR");
			GregorianCalendar calendar = new GregorianCalendar();
			SimpleDateFormat formato = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
			System.out.println(formato.format(calendar.getTime()));

			reservaSelecionada.setStatus(EnumReserva.RECUSADO);
			reservaSelecionada.setDataAprovacaoRecusa(calendar.getTime());

			Reserva salvarReserva = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());
			salvarReserva.save(reservaSelecionada);
		}
		limparDados();
		tabPedidos.setDisable(false);
		tabDados.setDisable(true);
		tbpDados.getSelectionModel().select(tabPedidos);
		preencherDadosTblPedidos(reserva.buscarTodasReservas());
	}

	private void permitirPedidoReserva() {
		if (reservaSelecionada != null) {
			Locale locale = new Locale("pt", "BR");
			GregorianCalendar calendar = new GregorianCalendar();
			SimpleDateFormat formato = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
			System.out.println(formato.format(calendar.getTime()));

			reservaSelecionada.setStatus(EnumReserva.CONFIRMADO);
			reservaSelecionada.setDataAprovacaoRecusa(calendar.getTime());

			Reserva salvarReserva = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());
			salvarReserva.save(reservaSelecionada);
		}
		limparDados();
		tabPedidos.setDisable(false);
		tabDados.setDisable(true);
		tbpDados.getSelectionModel().select(tabPedidos);
		preencherDadosTblPedidos(reserva.buscarTodasReservas());
	}

	/**
	 * Caixa de di�logo Alert.
	 * 
	 * @param alertType
	 *            � o tipo to alerta.
	 * @param titulo
	 *            � o t�tulo da caixa de di�logo.
	 * @param headerText
	 *            � o cabe�alho da caixa de di�logo.
	 * @param contentText
	 *            � o conte�do da caixa de di�logo.
	 */
	private void caixaAlerta(AlertType alertType, String titulo, String headerText, String contentText) {
		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setHeaderText(headerText);
		alerta.setContentText(contentText);
		alerta.show();
	}

	private void caixaConfirmacaoPedidoReserva(AlertType alertType, String titulo, String headerText,
			String contentText) {
		Alert alerta = new Alert(alertType);
		ButtonType sim = new ButtonType("Sim");
		ButtonType nao = new ButtonType("N�o");
		alerta.setTitle(titulo);
		alerta.setHeaderText(headerText);
		alerta.setContentText(contentText);
		alerta.getButtonTypes().setAll(sim, nao);

		alerta.showAndWait().ifPresent(p -> {
			if (p == sim) {
				if (reservaSelecionada != null && cmbLaboratorio.getSelectionModel().getSelectedItem() != null) {
					Locale locale = new Locale("pt", "BR");
					GregorianCalendar calendar = new GregorianCalendar();
					SimpleDateFormat formato = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
					System.out.println(formato.format(calendar.getTime()));

					reservaSelecionada.setStatus(EnumReserva.CONFIRMADO);
					reservaSelecionada.setDataAprovacaoRecusa(calendar.getTime());
					alerta.close();

					Reserva salvarReserva = new Reserva(DAOFactory.getDAOFactory().getReservaDAO());
					salvarReserva.save(reservaSelecionada);

					limparDados();
					tabPedidos.setDisable(false);
					tabDados.setDisable(true);
					tbpDados.getSelectionModel().select(tabPedidos);
					preencherDadosTblPedidos(reserva.buscarTodasReservas());
				} else if (reservaSelecionada != null && cmbLaboratorio.getSelectionModel().getSelectedItem() == null) {
					caixaAlerta(AlertType.INFORMATION, "AlphaLab", "Permitir Reserva de Hor�rio",
							"� preciso selecionar um laborat�rio para a reserva!");
				}
			}
			if (p == nao) {
			}
		});
	}

	@FXML
	void btnCancelar_onAction(ActionEvent event) {
		cancelarGerenciarPedido();
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
		negarPedidoReserva();
	}

	@FXML
	void btnNegar_onKeyPressed(KeyEvent event) {
		negarPedidoReserva();
	}

	@FXML
	void btnNegar_onMouseClicked(MouseEvent event) {
		negarPedidoReserva();
	}

	@FXML
	void btnPermitir_onAction(ActionEvent event) {
		caixaConfirmacaoPedidoReserva(AlertType.CONFIRMATION, "AlphaLab", "Permitir reserva",
				"Deseja permitir a reserva de laborat�rio?");
	}

	@FXML
	void btnPermitir_onKeyPressed(KeyEvent event) {
		caixaConfirmacaoPedidoReserva(AlertType.CONFIRMATION, "AlphaLab", "Permitir reserva",
				"Deseja permitir a reserva de laborat�rio?");
	}

	@FXML
	void btnPermitir_onMouseClicked(MouseEvent event) {
		caixaConfirmacaoPedidoReserva(AlertType.CONFIRMATION, "AlphaLab", "Permitir reserva",
				"Deseja permitir a reserva de laborat�rio?");
	}

	@FXML
	void cmbLaboratorio_onAction(ActionEvent event) {
		if (cmbLaboratorio.getSelectionModel().getSelectedItem() != null) {
			reservaSelecionada.setLaboratorio(cmbLaboratorio.getSelectionModel().getSelectedItem());
		}
	}

	@FXML
	void cmbLaboratorio_onMouseClicked(MouseEvent event) {
		if (cmbLaboratorio.getSelectionModel().getSelectedItem() != null) {
			reservaSelecionada.setLaboratorio(cmbLaboratorio.getSelectionModel().getSelectedItem());
		}
	}

	@FXML
	void cmdLaboratorio_onKeyPressed(KeyEvent event) {
		if (cmbLaboratorio.getSelectionModel().getSelectedItem() != null) {
			reservaSelecionada.setLaboratorio(cmbLaboratorio.getSelectionModel().getSelectedItem());
		}
	}

	@FXML
	void cmbServidor_onAction(ActionEvent event) {
		if (cmbServidor.getSelectionModel().getSelectedItem() != null) {
			preencherDadosTblPedidos(reserva.getByServidor(cmbServidor.getSelectionModel().getSelectedItem()));

			if (cmbServidor.getSelectionModel().getSelectedItem() != null
					&& cmbTipo.getSelectionModel().getSelectedItem() != null) {
				preencherDadosTblPedidos(reserva.getByTipoEServidor(cmbTipo.getSelectionModel().getSelectedItem(),
						cmbServidor.getSelectionModel().getSelectedItem()));
			}
		}
	}

	@FXML
	void cmbTipo_onAction(ActionEvent event) {
		if (cmbTipo.getSelectionModel().getSelectedItem() != null) {
			preencherDadosTblPedidos(reserva.getByTipo(cmbTipo.getSelectionModel().getSelectedItem()));

			if (cmbServidor.getSelectionModel().getSelectedItem() != null
					&& cmbTipo.getSelectionModel().getSelectedItem() != null) {
				preencherDadosTblPedidos(reserva.getByTipoEServidor(cmbTipo.getSelectionModel().getSelectedItem(),
						cmbServidor.getSelectionModel().getSelectedItem()));
			}
		}
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
			reservaSelecionada = tblPedidos.getSelectionModel().getSelectedItem();
			if (reservaSelecionada != null) {
				preencherVisualizarDados(reservaSelecionada);
				tbpDados.getSelectionModel().select(tabDados);
			}
		}
	}
}