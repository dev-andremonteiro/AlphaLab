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
import br.edu.ifmt.cba.alphalab.business.laboratorio.Departamento;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.dao.mock.servidor.MockServidorDAO;
import br.edu.ifmt.cba.alphalab.entity.exception.DepartamentoException;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.pessoa.ServidorEntity;
import br.edu.ifmt.cba.alphalab.gui.javafx.controller.exemplo.FrmPrincipal;
import br.edu.ifmt.cba.alphalab.gui.javafx.util.Alertas;
import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.print.DocFlavor.URL;

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
    private ButtonType bttNao = new ButtonType("NÃ£o", ButtonBar.ButtonData.CANCEL_CLOSE);
    private Dialog<ButtonType> dlgConfirmacao = new Dialog<>();

    Departamento departamento = new Departamento(DAOFactory.getDAOFactory().getDepartamentoDAO());
    private boolean novo = true;

    @FXML
    void btnAlterar_onAction(ActionEvent event) {
        if (tbvDepartamentos.getSelectionModel().getSelectedIndex() >= 0) {
            txtObs.setDisable(false);
            habilitarEdicao(true);

            tbpDepartamento.getSelectionModel().select(tabGerenciarDepartamento);
            novo = false;
        } else {
            Alertas.exibirAlerta(Alert.AlertType.INFORMATION, "Erro", "Erro de Seleção", "Selecione um Departamento para Alterar");
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
            Alertas.exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Departamento Salvo", "Departamento Salvo com Sucesso");

            habilitarEdicao(false);
            inicializarForm();
            tbpDepartamento.getSelectionModel().select(tabConsultarDepartamento);

        } else {
            Alertas.exibirAlerta(Alert.AlertType.INFORMATION, "Erro", "Erro ao Salvar Departamento", "Dados Inconsistentes, favor revisar");
        }
    }

    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnConfirmar.fire();
        }
    }

    @FXML
    void btnExcluir_onAction(ActionEvent event) {
        if (tbvDepartamentos.getSelectionModel().getSelectedIndex() >= 0) {
            Alertas.exibirAlerta(Alert.AlertType.CONFIRMATION, "Confirmação", "Confirmar a Exclusão", "Confirmar a exclusão?/n A Ação Não Poderá Ser Revertida");
            if (Alert.AlertType.CONFIRMATION.equals(true)) {
                departamento.delete(tbvDepartamentos.getSelectionModel().getSelectedItem());
                Alertas.exibirAlerta(Alert.AlertType.INFORMATION, "Sucesso", "Departamento Excluído", "Departamento Excluido com Sucesso");
                inicializarForm();
            }
        } else {
            Alertas.exibirAlerta(Alert.AlertType.INFORMATION, "Erro", "Erro de Seleção", "Selecione um Departamento para Excluir");
        }
    }

    @FXML
    void btnExcluir_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnExcluir.fire();
        }
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
        if (event.getCode() == KeyCode.ENTER) {
            btnNovoDep.fire();
        }
    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {
        if (txtPesqNomeDep.getText().trim().equals("") && !txtPesqSiglaDep.getText().trim().equals("")) {
            tbvDepartamentos.setItems(FXCollections.observableArrayList(new Departamento(DAOFactory.getDAOFactory().getDepartamentoDAO()).getBySigla(txtPesqSiglaDep.getText())));
        } else if (!txtPesqNomeDep.getText().trim().equals("") && txtPesqSiglaDep.getText().trim().equals("")) {
            tbvDepartamentos.setItems(FXCollections.observableArrayList(new Departamento(DAOFactory.getDAOFactory().getDepartamentoDAO()).getByNome(txtPesqNomeDep.getText())));
        } else {
            Alertas.exibirAlerta(Alert.AlertType.INFORMATION, "Busca", "Pesquisa não pode ser vazio", "Digite a Sigla ou o Nome do Departamento para Prosseguir com a Busca");
        }
        // tbvDepartamentos.setItems(FXCollections.observableArrayList(new Departamento(DAOFactory.getDAOFactory().getDepartamentoDAO()).getBySigla("sigla")));

        tbpDepartamento.getSelectionModel().select(tabConsultarDepartamento);
    }

    @FXML
    void btnSair2_onAction(ActionEvent event) {
        limparFormulario();
        inicializarForm();
    }

    @FXML
    void btnSair2_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnSair2.fire();
        }
    }

    @FXML
    void btnSair_onAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            btnSair.fire();
        }
    }

    @FXML
    void tbvDepartamentos_onMouseClicked(MouseEvent event) {
        DepartamentoEntity ent = (DepartamentoEntity) tbvDepartamentos.getSelectionModel().getSelectedItem();
        if (ent != null) {
            txtNovoNomeDep.setText(ent.getNome());
            txtNovaSiglaDep.setText(ent.getSigla());
            chbChefeDep.getSelectionModel().select(ent.getChefe());
            txtObs.setText(ent.getObservacao());
            btnAlterar.setDisable(false);
            btnExcluir.setDisable(false);

        }
        if (event.getClickCount() > 1) {
            tbpDepartamento.getSelectionModel().select(tabGerenciarDepartamento);
            txtNovaSiglaDep.setDisable(true);
            txtNovoNomeDep.setDisable(true);
            chbChefeDep.setDisable(true);
            txtObs.setDisable(true);
            btnNovoChefeDep.setDisable(true);
            btnConfirmar.setDisable(true);

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
        txtObs.setDisable(!sim);
        chbChefeDep.setDisable(!sim);
    }

    void inicializarForm() {
        tbvDepartamentos.setItems(FXCollections.observableArrayList(new Departamento(DAOFactory.getDAOFactory().getDepartamentoDAO()).buscarTodos()));
        btnNovoDep.setDisable(false);
        btnExcluir.setDisable(true);
        btnAlterar.setDisable(true);
        btnProcurar.setDisable(false);
        btnSair.setDisable(false);
        btnConfirmar.setDisable(false);

        
    }

    private void limparFormulario() {
        txtNovoNomeDep.setText("");
        txtNovaSiglaDep.setText("");
        txtObs.setText("");
        //txtTelefone.setText("");
    }

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        tbcChefe.setCellValueFactory(new PropertyValueFactory<>("chefe"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcSigla.setCellValueFactory(new PropertyValueFactory<>("sigla"));
        chbChefeDep.setItems(FXCollections.observableArrayList(MockServidorDAO.getInstance().buscarTodosServidores()));
        inicializarForm();
    }

}
