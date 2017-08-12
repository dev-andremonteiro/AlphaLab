package br.edu.ifmt.cba.alphalab.gui.javafx.controller.login;

/**
 * @author Stévillis Sousa
 */

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.ifmt.cba.alphalab.gui.javafx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FrmLogin implements Initializable {

	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField pswSenha;

	@FXML
	private Button btnSair;

	@FXML
	private Button btnEntrar;

	@FXML
	private Button btnCadastrar;

	@FXML
	void btnCadastrar_onAction(ActionEvent event) {

	}

	@FXML
	void btnCadastrar_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnCdastrar_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void btnEntrar_onAction(ActionEvent event) {
		if (txtLogin.getText().equals("admin") && pswSenha.getText().equals("admin")) {
			efetuarLogin();
			Main.login.close();// Fecha a Tela de Login

		} else {
			senhaInvalida();
		}
	}

	@FXML
	void btnEntrar_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnEntrar_onMousecClicked(MouseEvent event) {

	}

	@FXML
	void btnSair_onAction(ActionEvent event) {

	}

	@FXML
	void btnSair_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void btnSair_onMouseClicked(MouseEvent event) {

	}

	@FXML
	void pswSenha_onKeyPressed(KeyEvent event) {

	}

	@FXML
	void txtLogin_onKeyPressed(KeyEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void efetuarLogin() {
		BorderPane frmPrincipal = null;
		Stage primaryStage = new Stage();
		try {
			frmPrincipal = FXMLLoader.load(Main.class.getClassLoader().getResource("gui/FrmPrincipal.fxml"),
					ResourceBundle.getBundle("gui/i18N_pt_BR"));
		} catch (Exception ex) {
			System.out.println("Exception on FXMLLoader.load()");
			System.out.println(ex.getMessage());
		}

		primaryStage.setTitle("Tela Principal do Sistema");

		Scene scene = new Scene(frmPrincipal);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void senhaInvalida() {
		if (txtLogin.getText().equals("") && !pswSenha.getText().equals("")) {
			caixaAlerta(AlertType.ERROR, "Erro ao fazer login", "Login deve ser informado", "Informe o login!");
		}

		if (pswSenha.getText().equals("") && !txtLogin.getText().equals("")) {
			caixaAlerta(AlertType.ERROR, "Erro ao fazer login", "Senha deve ser informada", "Informe a senha!");
		}

		if (txtLogin.getText().equals("") && pswSenha.getText().equals("")) {
			caixaAlerta(AlertType.ERROR, "Erro ao fazer login", "Login e senha devem ser informados",
					"Informe o login e a senha!");

		}

		if (!txtLogin.getText().equals("") && !pswSenha.getText().equals("")) {
			caixaAlerta(AlertType.ERROR, "Erro ao fazer login", "Login e senha inválidos",
					"Informe login e senha válidos!");
		}
	}

	/**
	 * Caixa de diálogo Alert.
	 * 
	 * @param alertType
	 *            é o tipo to alerta.
	 * @param titulo
	 *            é o título da caixa de diálogo.
	 * @param headerText
	 *            é o cabeçalho da caixa de diálogo.
	 * @param contentText
	 *            é o conteúdo da caixa de diálogo.
	 */
	private void caixaAlerta(AlertType alertType, String titulo, String headerText, String contentText) {
		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setHeaderText(headerText);
		alerta.setContentText(contentText);
		alerta.showAndWait();
	}
}
