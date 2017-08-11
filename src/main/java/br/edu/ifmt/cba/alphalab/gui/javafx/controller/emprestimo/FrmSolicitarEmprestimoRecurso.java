
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
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
import javafx.scene.input.MouseEvent;

public class FrmSolicitarEmprestimoRecurso implements Initializable {
    
  private Emprestimo Emprestimo = new Emprestimo(DAOFactory.getDAOFactory().getEmprestimoDAO());
  private Equipamento equipamento = new Equipamento(DAOFactory.getDAOFactory().getEquipamentoDAO());
  
  private  ArrayList<EmprestimoEntity> listaPedido = new ArrayList<>();
  
  private  ArrayList<EquipamentoEntity> listaEquipamento = new ArrayList<>();
  
  private EquipamentoEntity equipamentoSelecionado = null;
 
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
    private TableView<EquipamentoEntity> tblRecursoPedido;
    
    @FXML
    private TableView<EquipamentoEntity> tblRecursoDisponivel;
    
    @FXML
    private TableColumn<EmprestimoEntity, Long> tbcQtdeDisponivel;

    @FXML
    private TableColumn<EmprestimoEntity, String> tbcDescricao;
    
    @FXML
    private TableColumn<EmprestimoEntity, String> tbcDescricao2;
    
    @FXML
    private TableColumn<EmprestimoEntity, Long> tbcQtdePedida;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnSolicitar;
    
    private  EmprestimoEntity emprestimoEntity;

    @FXML
    void tblDisponivel_onKeyPressed(ActionEvent event) {

    }

    @FXML
    void btnAdicionarAction(ActionEvent event) {
      // preencherDadosTblPedido(listaPedido);
      AdicionarEquipamento();
       
    }

    @FXML
    void btnRemoverAction(ActionEvent event) {
     RemoverEquipamento();
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
    
    @FXML
    void tblDisponivel_onMouseClicked(MouseEvent event) {
     if (event.getClickCount() >= 2) {
	AdicionarEquipamento();		
    }
    }
    
    @FXML
    void tblPedida_onMouseClicked(MouseEvent event) {
      if (event.getClickCount() >= 2) {
	RemoverEquipamento();	
    }
    
    }
    
    private void AdicionarEquipamento(){
        
        equipamentoSelecionado = tblRecursoDisponivel.getSelectionModel().getSelectedItem();
			if (equipamentoSelecionado != null) {
                              if(equipamentoSelecionado.getQtdeEstoque()!=0){
                                   equipamentoSelecionado.setQtdeEstoque( equipamentoSelecionado.getQtdeEstoque()-1L);
                                   listaEquipamento.add(equipamentoSelecionado);
                              }
                                
				 preencherDadosTblPedido(listaEquipamento);
				
			}
        
    }
    
    private void RemoverEquipamento(){
        equipamentoSelecionado = tblRecursoPedido.getSelectionModel().getSelectedItem();
			if (equipamentoSelecionado != null) {
                                 
                                 listaEquipamento.remove(equipamentoSelecionado);
				 preencherDadosTblPedido(listaEquipamento);
				 
			}
        
    }
    
    private void preencherDadosTblPedido(List<EquipamentoEntity>  listaPedida){
        
        tbcDescricao2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcQtdePedida.setCellValueFactory(new PropertyValueFactory<>("qtdeEmprestada"));
        
        tblRecursoPedido.setItems(FXCollections.observableArrayList(listaPedida));
        
        tblRecursoDisponivel.refresh();
        tblRecursoPedido.refresh();
    }
    
    private void preencherDadosTblDisponivel(List<EquipamentoEntity> listaDiponivel){
        
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tbcQtdeDisponivel.setCellValueFactory(new PropertyValueFactory<>("qtdeEstoque"));
        
        tblRecursoDisponivel.setItems(FXCollections.observableArrayList(listaDiponivel));
        
        
        tblRecursoDisponivel.refresh();
        tblRecursoPedido.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblRecursoPedido.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tblRecursoDisponivel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        preencherDadosTblDisponivel(equipamento.buscarEquipamentosDisponiveis());
        
        GregorianCalendar calendar = new GregorianCalendar();
			
        dtpData.setUserData(calendar.getTime());
        
        
     //   preencherDadosTblPedido(equipamento.buscarEquipamentosDisponiveis());

        
    }

    

}

