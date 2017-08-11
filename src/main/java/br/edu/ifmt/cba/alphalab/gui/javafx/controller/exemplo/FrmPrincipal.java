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
	private MenuItem mniPedidosReservaHorario;

	@FXML
	private MenuItem mniGerenciarHorario;

	@FXML
	private MenuItem mniAjuda;

	@FXML
	private MenuItem mniSobre;

	@FXML
	private MenuItem mniConsultarHorario;

	@FXML
	private MenuItem mniSolicitarEmprestimo;

	@FXML
	private MenuItem mniDevolucaoRecursos;

	@FXML
	private MenuItem mniEmprestimoRecursos;
        
        @FXML
        private MenuItem mniGerenciarSoftware;
        
        @FXML
        private MenuItem mniConsultarDepartamento;
        
        
        @FXML
        private MenuItem mniGerenciarDepartamento;
        
        @FXML
        private MenuItem mniSolicitarSoftware,mniGerenciarSolicitacaoSoftware;
        @FXML
        void mniGerenciarSolicitacaoSoftwareOnAction(ActionEvent e){
            loadPane("GerenciarInstalacaoSoftware");
        }
        
        @FXML
        void mniSolicitarSoftwareOnAction(ActionEvent evt){
            loadPane("TelaSoftware");
        }
        
        @FXML 
        void mniGerenciarSoftwareOnAction(ActionEvent event){
            loadPane("ManutencaoSoftware");
        }
        
	@FXML
	void mniConsultarHorario_onAction(ActionEvent event) {
		loadPane("FrmConsultarHorario");
	}

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
	void mniPedidosReservaHorario(ActionEvent event) {
		loadPane("FrmPedidosReserva");
	}

	@FXML
	void mniGerenciarReserva_onAction(ActionEvent event) {
		loadPane("FrmPedidosReserva");

	}
	
	@FXML
    void mniGerenciarHorario_onAction(ActionEvent event) {
		loadPane("FrmGerenciarHorario");
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
	void mniSolicitarEmprestimo_onAction(ActionEvent event) {
		loadPane("FrmSolicitarEmprestimoRecurso");
	}

	@FXML
	void mniEmprestimoRecursos_onAction(ActionEvent event) {
		loadPane("FrmEmprestimoRecurso");
	}

	@FXML
	void mniDevolucaoRecursos_onAction(ActionEvent event) {
		loadPane("FrmDevolucaoRecurso");
	}
        
        @FXML
        void mniConsultarDepartamento_onAction(ActionEvent event) {
                loadPane("FrmCadastroDepartamento");
        }
        
        @FXML
        void mniGerenciarDepartamento_onAction(ActionEvent event) {
                loadPane("FrmCadastroDepartamento");
        }

	@FXML
	void mniSair_onAction(ActionEvent event) {
		System.exit(0);
	}

	/**
	 * 
	 * @param string
	 *            � o caminho da tela a ser carregada. <b>Exemplo - carregar tela
	 *            FrmCliente.fxml:</b> loadPane(FrmCliente)
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
