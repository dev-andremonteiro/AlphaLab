package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.business.Reserva;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.LaboratorioEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.RequisitoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ProfessorEntity;
import javafx.collections.FXCollections;
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

	@FXML
	private TabPane tbpDados;

	@FXML
	private Tab tabPedidos;

	@FXML
	private DatePicker dtpData;

	@FXML
	private ComboBox<?> cmbTipo;

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
		limparDados();
		dtpData.requestFocus();

		//preencherDadosTblPedidos(reserva.buscarTodasReservas());
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
	}

	/**
	 * Preenche o formulário da aba Visualizar Dados com os dados\n do pedido
	 * selecionado na aba Pedidos.
	 */
	/*private void preencherDados() {
		limparDados();

		tabPedidos.setDisable(true);
		tabDados.setDisable(false);

		texID.setText(value);
		txtDataPedido.setText(value);
		// hbxRequisitos
		texProfessor.setText(value);
		texDisciplina.setText(value);
		texDepartamento.setText(value);
		texTurma.setText(value);
		texDescricao.setText(value);
		// hbxHorarios
		ckbFixo.setSelected(value);
	}*/

	private void preencherDadosTblPedidos(List<ReservaEntity> listaReserva) {
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

	}

	@FXML
	void dtpData_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void tblPedidos_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void tblPedidos_onMouseClicked(MouseEvent event) {
		if (event.getClickCount() >= 2) {
			//preencherDados();
		}
	}
}