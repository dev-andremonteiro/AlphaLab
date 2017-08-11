/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;

/**
 *
 * @author harri
 */
import br.edu.ifmt.cba.alphalab.business.Cliente;
import br.edu.ifmt.cba.alphalab.business.laboratorio.Departamento;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.ClienteEntity;
import br.edu.ifmt.cba.alphalab.entity.exception.ClienteException;
import br.edu.ifmt.cba.alphalab.entity.exception.DepartamentoException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.print.DocFlavor.URL;
import javax.swing.JOptionPane;

public class FrmCadastroDepartamento implements Initializable {
    
    @FXML
    private TabPane tbpDepartamento;
    
    @FXML
    private Tab tabConsultarDepartamento;
    
    @FXML
    private TextField txtPesqSiglaDep;
    
    @FXML
    private TextField txtPesqNomeDep;
    
    @FXML
    private Button btnProcurar;
    
    @FXML
    private TableView<DepartamentoEntity> tbvDepartamentos;
    
    @FXML
    private TableColumn<DepartamentoEntity, String> tbcSigla;
    
    @FXML
    private TableColumn<DepartamentoEntity, String> tbcNome;
    
    @FXML
    private TableColumn<DepartamentoEntity, String> tbcChefe;
    
    @FXML
    private Button btnNovoDep;
    
    @FXML
    private Button btnAlterar;
    
    @FXML
    private Button btnExcluir;
    
    @FXML
    private Button btnSair;
    
    @FXML
    private Tab tabGerenciarDepartamento;
    
    @FXML
    private TextField txtNovaSiglaDep;
    
    @FXML
    private TextField txtNovoNomeDep;
    
    @FXML
    private ChoiceBox<ServidorEntity> chbChefeDep;
    
    @FXML
    private Button btnNovoChefeDep;
    
    @FXML
    private TextArea txtObs;
    
    @FXML
    private Button btnConfirmar;
    
    @FXML
    private Button btnSair2;
    
    private Dialog<String> dlgMensagem = new Dialog<>();
    private ButtonType bttOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
    
    private ButtonType bttSim = new ButtonType("Sim", ButtonBar.ButtonData.OK_DONE);
    private ButtonType bttNao = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
    private Dialog<ButtonType> dlgConfirmacao = new Dialog<>();
    
    Departamento departamento = new Departamento(DAOFactory.getDAOFactory().getDepartamentoDAO());
    private boolean novo = true;
    
    @FXML
    void btnAlterar_onAction(ActionEvent event) {
        if (tbvDepartamentos.getSelectionModel().getSelectedIndex() >= 0) {
            
            habilitarEdicao(true);
            tbpDepartamento.getSelectionModel().select(tabGerenciarDepartamento);
            novo = false;
        } else {
            dlgMensagem.setTitle("ERRO DE SELEÇÃO");
            dlgMensagem.setContentText("É preciso selecionar um cliente da tabela para poder realizar alteração.");
            dlgMensagem.showAndWait();
        }
    }
    
    @FXML
    void btnAlterar_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnAlterar.fire();
        }
    }
    
    @FXML
    void btnConfirmar_onAction(ActionEvent event) {
        DepartamentoEntity ent;
        if (novo) {
            ent = new DepartamentoEntity();
        } else {
            ent = (DepartamentoEntity) tbvDepartamentos.getSelectionModel().getSelectedItem();
        }
        ent.setNome(txtNovoNomeDep.getText());
        ent.setSigla(txtNovaSiglaDep.getText());
        ent.setChefe((ServidorEntity) chbChefeDep.getSelectionModel().getSelectedItem());
        DepartamentoException exc = (DepartamentoException) departamento.save(ent);
        if (exc == null) {
            dlgMensagem.setTitle("Departamento Salvo com Sucesso");
            dlgMensagem.setContentText("Departamento Salvo com Sucesso");
            dlgMensagem.showAndWait();
            
            habilitarEdicao(false);
        } else {
            dlgMensagem.setTitle("ERRO AO SALVAR DEPARTAMENTO");
            dlgMensagem.setContentText("Dados Inconsistentes, favor revisar");
            dlgMensagem.showAndWait();
        }
    }
    
    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {
        
    }
    
    @FXML
    void btnExcluir_onAction(ActionEvent event) {
        if (tbvDepartamentos.getSelectionModel().getSelectedIndex() >= 0) {
            dlgConfirmacao.setTitle("CONFIRMAÇÃO");
            dlgConfirmacao.setContentText("Tem certeza que deseja excluir?\nEsta operação não poderá ser desfeita.");
            Optional<ButtonType> result = dlgConfirmacao.showAndWait();
            if (result.isPresent() && result.get() == bttSim) {
                departamento.delete(tbvDepartamentos.getSelectionModel().getSelectedItem());
                btnProcurar.fire();
                dlgMensagem.setTitle("Sucesso na Exclus�o");
                dlgMensagem.setContentText("Departamento Excluido com Sucesso!!");
                dlgMensagem.showAndWait();
            }
        } else {
            dlgMensagem.setTitle("ERRO DE SELEÇÃO");
            dlgMensagem.setContentText("� preciso selecionar um departamentoe da tabela para poder realizar a exclusão.");
            dlgMensagem.showAndWait();
        }
    }
    
    @FXML
    void btnExcluir_onKeyPressed(KeyEvent event) {
        
    }
    
    @FXML
    void btnNovoChefeDep_onAction(ActionEvent event) {
        
    }
    
    @FXML
    void btnNovoChefeDep_onKeyPressed(KeyEvent event) {
        
    }
    
    @FXML
    void btnNovoDep_onAction(ActionEvent event) {
        habilitarEdicao(true);
        tbpDepartamento.getSelectionModel().select(tabGerenciarDepartamento);
        limparFormulario();
        novo = true;
    }
    
    @FXML
    void btnNovoDep_onKeyPressed(KeyEvent event) {
        
    }
    
    @FXML
    void btnProcurar_onAction(ActionEvent event) {
//        ObservableList<DepartamentoEntity> produtos;
//        produtos = FXCollections
//                .observableArrayList(departamento.getByNome(txtPesqNomeDep.getText()));
//
//		tbvDepartamentos.setItems(produtos);
//
//		
//
//		tbpDepartamento.getSelectionModel().select(tabConsultarDepartamento);
    }
    
    @FXML
    void btnSair2_onAction(ActionEvent event) {
        
    }
    
    @FXML
    void btnSair2_onKeyPressed(KeyEvent event) {
        
    }
    
    @FXML
    void btnSair_onAction(ActionEvent event) {
        
    }
    
    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        
    }
    
    @FXML
    void tbvDepartamentos_onMouseClicked(MouseEvent event) {
        DepartamentoEntity ent = (DepartamentoEntity) tbvDepartamentos.getSelectionModel().getSelectedItem();
        if (ent != null) {
            txtNovoNomeDep.setText(ent.getNome());
            txtNovaSiglaDep.setText(ent.getSigla());
            chbChefeDep.setItems((ObservableList<ServidorEntity>) ent.getChefe());
            //txtTelefone.setText(ent.getTelefone());
            habilitarEdicao(false);
        }
        if (event.getClickCount() > 2) {
            tbpDepartamento.getSelectionModel().select(tabGerenciarDepartamento);
        }
    }
    
    void habilitarEdicao(boolean sim) {
        btnNovoDep.setDisable(sim);
        btnConfirmar.setDisable((!sim));
        btnAlterar.setDisable(sim);
        btnSair.setDisable((!sim));
        btnExcluir.setDisable(sim);
        
        txtNovoNomeDep.setDisable(!sim);
        txtNovaSiglaDep.setDisable(!sim);
        chbChefeDep.setDisable(!sim);
    }
    
    private void limparFormulario() {
        txtNovoNomeDep.setText("");
        txtNovaSiglaDep.setText("");
        //txtTelefone.setText("");
    }
    
    public void initialize(URL location, ResourceBundle resources) {
        tbcChefe.setCellValueFactory(new PropertyValueFactory<>("chefe"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcSigla.setCellValueFactory(new PropertyValueFactory<>("sigla"));
        tbvDepartamentos.setItems(FXCollections.observableArrayList(new Departamento(DAOFactory.getDAOFactory().getDepartamentoDAO()).buscarTodos()));
        
    }

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
