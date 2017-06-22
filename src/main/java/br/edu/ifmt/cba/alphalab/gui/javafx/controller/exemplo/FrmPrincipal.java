package br.edu.ifmt.cba.alphalab.gui.javafx.controller.exemplo;


import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FrmPrincipal {

    @FXML
    private MenuItem mniVenda;

    @FXML
    private MenuItem mniSair;

    @FXML
    private Menu mnuOperacoes;

    @FXML
    private BorderPane bdpPrincipal;

    @FXML
    private MenuBar mnbPrincipal;

    @FXML
    private MenuItem mniCliente;

    @FXML
    private MenuItem mniSobre;

    @FXML
    private Menu mnuCadastro;

    @FXML
    private Menu mnuAjuda;

    @FXML
    void mniCliente_onAction(ActionEvent event) {
        BorderPane frmCliente = null;
        
        try{
            frmCliente = FXMLLoader.load(FrmCliente.class.getClassLoader().getResource("gui//FrmCliente.fxml"),ResourceBundle.getBundle("gui/i18N"));
            bdpPrincipal.setCenter(frmCliente);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }    	
    }
   
    
    @FXML
    void mniSobre_onAction(ActionEvent event) {
        VBox frmSobre = null;
        try{
            frmSobre = FXMLLoader.load(FrmPrincipal.class.getClassLoader().getResource("gui//FrmSobre.fxml"),ResourceBundle.getBundle("gui/i18N"));
            bdpPrincipal.setCenter(frmSobre);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }    	
    }    


    @FXML
    void mniSair_onAction(ActionEvent event) {
    	System.exit(0);
    }

}
