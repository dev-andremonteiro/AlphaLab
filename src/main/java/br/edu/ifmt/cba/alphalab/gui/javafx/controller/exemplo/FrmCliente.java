package br.edu.ifmt.cba.alphalab.gui.javafx.controller.exemplo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.util.Optional;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.business.Cliente;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.DAOFactoryEnum;
import br.edu.ifmt.cba.alphalab.dao.IClienteDAO;
import br.edu.ifmt.cba.alphalab.entity.ClienteEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.ClienteException;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class FrmCliente {

	@FXML
	private ResourceBundle resources;
	
	@FXML
	private Button btnConfirmar;

	@FXML
	private TextField txtPesqNome;

	@FXML
	private Label lblPesqNome;

	@FXML
	private HBox hbxEditButtons;

	@FXML
	private Tab tabClientes;

	@FXML
	private Label lblCodigoValue;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtTelefone;

	@FXML
	private Label lblEmail;

	@FXML
	private VBox vbxBottom;

	@FXML
	private TableView<ClienteEntity> tblClientes;

	@FXML
	private Label lblStatus;

	@FXML
	private StackPane stkDialog;

	@FXML
	private GridPane grdEdicao;

	@FXML
	private Button btnProcurar;

	@FXML
	private Button btnAlterar;

	@FXML
	private Button btnCancelar;

	@FXML
	private TabPane tbpCliente;

	@FXML
	private Label lblTelefone;

	@FXML
	private Tab tabEdicao;

	@FXML
	private Button btnExcluir;

	@FXML
	private VBox vbxDialog;

	@FXML
	private Button btnOk;

	@FXML
	private Label lblCodigo;

	@FXML
	private Label lblNome;

	@FXML
	private Text lblMensagem;

	@FXML
	private Button btnNovo;

	@FXML
	private ContextMenu ctxMenu;

	@FXML
	private MenuItem mniEditar;

	@FXML
	private MenuItem mniExcluir;

	// Para a caixa de diálogo de avisos
	private ButtonType bttOk = new ButtonType("OK", ButtonData.OK_DONE);
	private Dialog<String> dlgMensagem = new Dialog<>();

	// Para a caixa de diálogo de confirmação
	private ButtonType bttSim = new ButtonType("Sim", ButtonData.OK_DONE);
	private ButtonType bttNao = new ButtonType("Não", ButtonData.CANCEL_CLOSE);
	private Dialog<ButtonType> dlgConfirmacao = new Dialog<>();

	Cliente cliente = new Cliente(DAOFactory.getDAOFactory().getClienteDAO());
	private boolean novo = true;

	@FXML
	void initialize() {
		TableColumn<ClienteEntity, String> tbcNome = new TableColumn<ClienteEntity, String>("Nome");
		tbcNome.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getNome());
			}
		});

		TableColumn<ClienteEntity, String> tbcEmail = new TableColumn<ClienteEntity, String>("E-mail");
		tbcEmail.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
				return new ReadOnlyObjectWrapper<String>(c.getValue().getEmail());
			}
		});

		TableColumn<ClienteEntity, String> tbcTelefone = new TableColumn<ClienteEntity, String>("Telefone");
		tbcTelefone
				.setCellValueFactory(new Callback<CellDataFeatures<ClienteEntity, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<ClienteEntity, String> c) {
						return new ReadOnlyObjectWrapper<String>(c.getValue().getTelefone());
					}
				});

		tbcNome.setMinWidth(300);
		tbcEmail.setMinWidth(300);
		tbcTelefone.setMinWidth(100);

		tblClientes.getColumns().add(tbcNome);
		tblClientes.getColumns().add(tbcEmail);
		tblClientes.getColumns().add(tbcTelefone);

		stkDialog.getChildren().remove(vbxDialog);

		dlgMensagem.getDialogPane().getButtonTypes().add(bttOk);
		dlgConfirmacao.getDialogPane().getButtonTypes().add(bttSim);
		dlgConfirmacao.getDialogPane().getButtonTypes().add(bttNao);

		txtPesqNome.requestFocus();
	}

	@FXML
	void btnNovo_onAction(ActionEvent event) {
		lblStatus.setText("Cadastrando novo cliente.");
		habilitarEdicao(true);
		tbpCliente.getSelectionModel().select(tabEdicao);
		limparFormulario();
		novo = true;
	}

	@FXML
	void btnConfirmar_onAction(ActionEvent event) {
		ClienteEntity ent;
		if (novo)
			ent = new ClienteEntity();
		else
			ent = tblClientes.getSelectionModel().getSelectedItem();
		ent.setNome(txtNome.getText());
		ent.setEmail(txtEmail.getText());
		ent.setTelefone(txtTelefone.getText());
		ClienteException exc = cliente.save(ent);
		if (exc == null) {
			lblStatus.setText("Cliente salvo com sucesso.");
			habilitarEdicao(false);
		} else {
			lblStatus.setText("Dados do cliente encontram-se inconsistentes.");
			lblMensagem.setText(exc.getMessage());
			stkDialog.getChildren().add(vbxDialog);
		}
	}

	@FXML
	void btnAlterar_onAction(ActionEvent event) {
		if (tblClientes.getSelectionModel().getSelectedIndex() >= 0) {
			lblStatus.setText("Alterando dados do cliente.");
			habilitarEdicao(true);
			tbpCliente.getSelectionModel().select(tabEdicao);
			novo = false;
		} else {
			dlgMensagem.setTitle("ERRO DE SELEÇÃO");
			dlgMensagem.setContentText("É preciso selecionar um cliente da tabela para poder realizar alteração.");
			dlgMensagem.showAndWait();
		}
	}

	@FXML
	void btnCancelar_onAction(ActionEvent event) {
		lblStatus.setText("Edição cancelada.");
		habilitarEdicao(false);
	}

	@FXML
	void btnExcluir_onAction(ActionEvent event) {
		if (tblClientes.getSelectionModel().getSelectedIndex() >= 0) {
			dlgConfirmacao.setTitle("CONFIRMAÇÃO");
			dlgConfirmacao.setContentText("Tem certeza que deseja excluir?\nEsta operação não poderá ser desfeita.");
			Optional<ButtonType> result = dlgConfirmacao.showAndWait();
			if (result.isPresent() && result.get() == bttSim) {
				cliente.delete(tblClientes.getSelectionModel().getSelectedItem());
				btnProcurar.fire();
				lblStatus.setText("Cliente excluído com sucesso.");
			}
		} else {
			dlgMensagem.setTitle("ERRO DE SELEÇÃO");
			dlgMensagem.setContentText("É preciso selecionar um cliente da tabela para poder realizar a exclusão.");
			dlgMensagem.showAndWait();
		}
	}

	@FXML
	void txtPesqNome_onKeyPressed(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER)
			btnProcurar.fire();
	}

	@FXML
	void btnProcurar_onAction(ActionEvent event) {
		final ObservableList<ClienteEntity> produtos = FXCollections
				.observableArrayList(cliente.getByNome(txtPesqNome.getText()));

		tblClientes.setItems(produtos);

		lblStatus.setText("Foram encontrados " + produtos.size() + " clientes.");

		tbpCliente.getSelectionModel().select(tabClientes);
	}

	@FXML
	void btnOk_onAction(ActionEvent event) {
		stkDialog.getChildren().remove(vbxDialog);
	}

	@FXML
	void tblClientes_mouseClicked(MouseEvent event) {
		ClienteEntity ent = tblClientes.getSelectionModel().getSelectedItem();
		if (ent != null) {
			txtNome.setText(ent.getNome());
			txtEmail.setText(ent.getEmail());
			txtTelefone.setText(ent.getTelefone());
			habilitarEdicao(false);
		}
		if (event.getClickCount() > 2)
			tbpCliente.getSelectionModel().select(tabEdicao);
	}

	@FXML
	void mniEditar_onAction(ActionEvent event) {
		btnAlterar.fire();
	}

	@FXML
	void mniExcluir_onAction(ActionEvent event) {
		btnExcluir.fire();
	}

	void habilitarEdicao(boolean sim) {
		btnNovo.setDisable(sim);
		btnConfirmar.setDisable((!sim));
		btnAlterar.setDisable(sim);
		btnCancelar.setDisable((!sim));
		btnExcluir.setDisable(sim);

		txtNome.setDisable(!sim);
		txtEmail.setDisable(!sim);
		txtTelefone.setDisable(!sim);
	}

	private void limparFormulario() {
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
	}
}
