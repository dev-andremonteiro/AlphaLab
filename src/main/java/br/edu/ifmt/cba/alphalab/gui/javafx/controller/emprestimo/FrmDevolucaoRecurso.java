
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.emprestimo;

/**
 *
 * @author Wesley
 */
// FrmDevolucaoRecurso 
    
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class FrmDevolucaoRecurso  {

    @FXML
    private Button btnRecusar;

    @FXML
    private Label lblProfessor;

    @FXML
    private DatePicker dtpData;

    @FXML
    private Button btnDevolver;

    @FXML
    private Label lblResponsavel;

    @FXML
    private Button btnSair;

    @FXML
    private ComboBox<?> cbxProfessor;

    @FXML
    private Label lblDataDevolver;

    @FXML
    private TableView<?> tblRecursosEmprestado;

    @FXML
    private TextArea txaObservacao;

    @FXML
    private TableView<?> tblProfessorData;

    @FXML
    void btnDevolverAction(ActionEvent event) {

    }

    @FXML
    void btnRecusarAction(ActionEvent event) {

    }

    @FXML
    void btnSairAction(ActionEvent event) {

    }

    @FXML
    void tblProfessorData_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void tblRecursosEmprestado_onKeyPressed(ActionEvent event) {

    }

}
