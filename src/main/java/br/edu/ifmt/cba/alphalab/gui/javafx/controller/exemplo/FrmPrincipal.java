package br.edu.ifmt.cba.alphalab.gui.javafx.controller.exemplo;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class FrmPrincipal {

	public static final String LINGUA_INGLES = "gui/i18N";
	public static final String LINGUA_PORTUGUES = "gui/i18N_pt_BR";

	@FXML
	private BorderPane bdpPrincipal;

	@FXML
	private MenuBar mnbPrincipal;

	@FXML
	private MenuItem mniLogin;

	@FXML
	private MenuItem mniIngles;

	@FXML
	private MenuItem mniPortugues;

	@FXML
	private MenuItem mniSair;

	@FXML
	private MenuItem mniReservaPorHorario;

	@FXML
	private MenuItem mniReservaPorRequisito;

	@FXML
	private MenuItem mniAjuda;

	@FXML
	private MenuItem mniSobre;

	@FXML
	void mniIngles_onAction(ActionEvent event) {

	}

	@FXML
	void mniLogin_onAction(ActionEvent event) {

	}

	@FXML
	void mniPortugues_onAction(ActionEvent event) {

	}

	@FXML
	void mniReservaPorHorario_onAction(ActionEvent event) {

	}

	@FXML
	void mniReservaPorRequisito_onAction(ActionEvent event) {
		loadPane("FrmSolicitarReservaHorarioPorRequisito");

	}

	@FXML
	void mniAjuda_onAction(ActionEvent event) {
		loadPane("FrmCliente");
	}

	@FXML
	void mniSobre_onAction(ActionEvent event) {
		loadPane("FrmSobre");
	}

	@FXML
	void mniSair_onAction(ActionEvent event) {
		System.exit(0);
	}

	/**
	 * 
	 * @param string
	 *            é o caminho da tela a ser carregada. <b>Exemplo - carregar
	 *            tela FrmCliente.fxml:</b> loadPane(FrmCliente)
	 */
	private void loadPane(String string) {
		Node node = null;
		try {
			node = FXMLLoader.load(FrmPrincipal.class.getClassLoader().getResource("gui//" + string + ".fxml"),
            		ResourceBundle.getBundle(FrmPrincipal.LINGUA_PORTUGUES));
			bdpPrincipal.setCenter(node);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}