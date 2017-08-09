
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.emprestimo;

/**
 *
 * @author Wesley
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FrmSolicitarEmprestimoRecurso {

    @FXML
    private Label lblProfessor;

    @FXML
    private Button btnAdicionar;

    @FXML
    private TextField txtData;

    @FXML
    private TableColumn<?, ?> tblRecursoDisponivel;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField txtHora;

    @FXML
    private TextField txtDescricao;

    @FXML
    private Label lblHora;

    @FXML
    private TextField txtDescricao1;

    @FXML
    private TableView<?> tblRecursoPedido;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnSolicitar;

    @FXML
    void tblDisponivel_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnAdicionar(ActionEvent event) {

    }

    @FXML
    void btnRemover(ActionEvent event) {

    }

    @FXML
    void tblPedidos_onKeyPressed(ActionEvent event) {

    }

}

