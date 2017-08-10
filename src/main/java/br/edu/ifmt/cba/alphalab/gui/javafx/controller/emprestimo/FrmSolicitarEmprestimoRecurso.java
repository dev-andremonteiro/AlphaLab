
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.emprestimo;

/**
 *
 * @author Wesley
 */
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EmprestimoEntity;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
    private DatePicker dtpData;

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
    private TableView<EmprestimoEntity> tblRecursoDisponivel;
    
    @FXML
    private TableColumn<EmprestimoEntity, String> tbcQtdeDisponivel;

    @FXML
    private TableColumn<EmprestimoEntity, Long> tbcDescricao;
    
    @FXML
    private TableColumn<EmprestimoEntity, String> tbcDescricao2;
    
    @FXML
    private TableColumn<EmprestimoEntity, Long> tbcQtdePedida;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnSolicitar;

    @FXML
    void tblDisponivel_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnAdicionarAction(ActionEvent event) {

    }

    @FXML
    void btnRemoverAction(ActionEvent event) {

    }

    @FXML
    void tblPedidos_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnSolicitarAction(ActionEvent event) {

    }

    @FXML
    void btnVoltarAction(ActionEvent event) {

    }

    

}

