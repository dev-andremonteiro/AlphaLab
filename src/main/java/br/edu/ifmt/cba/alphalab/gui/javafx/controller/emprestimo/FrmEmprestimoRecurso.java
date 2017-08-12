
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.emprestimo;

/**
 *
 * @author Wesley
 */

 
import br.edu.ifmt.cba.alphalab.business.Emprestimo;
import br.edu.ifmt.cba.alphalab.business.Equipamento;
import br.edu.ifmt.cba.alphalab.business.Servidor;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.equipamentos.EmprestimoEntity;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class FrmEmprestimoRecurso implements Initializable{
  private Emprestimo Emprestimo = new Emprestimo(DAOFactory.getDAOFactory().getEmprestimoDAO());
  private Equipamento equipamento = new Equipamento(DAOFactory.getDAOFactory().getEquipamentoDAO());
  private Servidor servidor = new Servidor(DAOFactory.getDAOFactory().getServidorDAO());
     @FXML
    private Button btnRecusar;
     
    @FXML
    private TableColumn<EmprestimoEntity, String> tbcProfessor;
    
    @FXML
    private TableColumn<EmprestimoEntity, Date> tbcDataPedido;
    
    @FXML
    private TableColumn<EmprestimoEntity, String> tbcPatrimonio;
    
    @FXML
    private TableColumn<EmprestimoEntity, String> tbcDescricao;

    @FXML
    private TableColumn<EmprestimoEntity, Long> tbcQtde;

    @FXML
    private Label lblProfessor;

    @FXML
    private TableView<EmprestimoEntity> tblRecurso;

    @FXML
    private DatePicker dtpData;

    @FXML
    private TableView<EmprestimoEntity> tblPedidos;

    @FXML
    private Button btnSair;

    @FXML
    private ComboBox<Servidor> cbxProfessor;

    @FXML
    private Button btnEmprestar;

    @FXML
    private TextArea txaObservacao;

    @FXML
    private Label lblDataPedido;

    @FXML
    void btnEmprestarAction(ActionEvent event) {

    }

    @FXML
    void btnRecusarAction(ActionEvent event) {

    }

    @FXML
    void btnSairAction(ActionEvent event) {
      System.exit(0);
    }

    @FXML
    void tblPedido_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void tblRecurso_onKeyPressed(ActionEvent event) {

    }
    
    @FXML
    void tblPedido_onMouseClicked(MouseEvent event) {
      if (event.getClickCount() >= 2) {
	
    }
    }
    
     @FXML
    void tblRecursos_onMouseClicked(MouseEvent event) {
     if (event.getClickCount() >= 2) {
	
    }
    }
    
    
    private void preencherDadosTblPedidos(List<EmprestimoEntity> listaPedidos){
       tbcProfessor.setCellValueFactory(new PropertyValueFactory<>("solicitante")); 
       tbcDataPedido.setCellValueFactory(new PropertyValueFactory<>("dataSolicitacao")); 
       tblPedidos.setItems(FXCollections.observableArrayList(listaPedidos));
       tblRecurso.setItems(FXCollections.observableArrayList(listaPedidos));
       tblPedidos.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       tblPedidos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       tblRecurso.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       preencherDadosTblPedidos(Emprestimo.BuscarPedidosEmprestimo());
       lblProfessor.setText(servidor.getByID(2L).getNome()); 
    }
   
}

 
    

