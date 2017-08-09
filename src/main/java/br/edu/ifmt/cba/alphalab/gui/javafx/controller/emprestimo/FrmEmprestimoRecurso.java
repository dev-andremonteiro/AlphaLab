
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.emprestimo;

/**
 *
 * @author Wesley
 */

 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FrmEmprestimoRecurso{

   
    @FXML
    private Button btnRecusar;

    @FXML
    private Label lblProfessor;

    @FXML
    private TableView<?> tblRecurso;

    @FXML
    private TextField txtData;

    @FXML
    private TableView<?> tblPedidos;

    @FXML
    private Button btnSair;

    @FXML
    private ComboBox<?> cbxProfessor;

    @FXML
    private Button btnEmprestar;

    @FXML
    private TextArea txaObservacao;

    @FXML
    private Label lblDataPedido;

    @FXML
    void tblPedido_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void tblRecurso_onKeyPressed(ActionEvent event) {

    }
}

 
    

