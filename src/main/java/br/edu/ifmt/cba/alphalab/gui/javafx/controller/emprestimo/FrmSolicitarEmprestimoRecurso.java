
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.emprestimo;

/**
 *
 * @author Wesley
 */
import br.edu.ifmt.cba.alphalab.business.Emprestimo;
import br.edu.ifmt.cba.alphalab.business.Equipamento;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EmprestimoEntity;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EquipamentoEntity;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FrmSolicitarEmprestimoRecurso implements Initializable {
    
  // private Emprestimo equipamento = new Emprestimo(DAOFactory.getDAOFactory().getEmprestimoDAO());
  private Equipamento equipamento = new Equipamento(DAOFactory.getDAOFactory().getEquipamentoDAO());
   
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
    private TableView<EmprestimoEntity> tblRecursoPedido;
    
    @FXML
    private TableView<EquipamentoEntity> tblRecursoDisponivel;
    
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
    
    private void preencherDadosTblDisponivel(List<EquipamentoEntity> listaDiponivel){
        
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        
        tblRecursoDisponivel.setItems(FXCollections.observableArrayList(listaDiponivel));
        
        tblRecursoDisponivel.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblRecursoPedido.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tblRecursoDisponivel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        preencherDadosTblDisponivel(equipamento.buscarEquipamentosDisponiveis());
        
        
    }

    

}

