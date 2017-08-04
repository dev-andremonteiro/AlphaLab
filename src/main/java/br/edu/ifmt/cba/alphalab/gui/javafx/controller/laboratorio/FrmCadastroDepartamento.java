/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifmt.cba.alphalab.gui.javafx.controller.laboratorio;
import br.edu.ifmt.cba.alphalab.business.laboratorio.Departamento;
import br.edu.ifmt.cba.alphalab.dao.DAOFactory;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.DepartamentoEntity;
import br.edu.ifmt.cba.alphalab.entity.laboratorio.ReservaEntity;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Harriman 1697
 */



public class FrmCadastroDepartamento implements Initializable {

    @FXML
    private TextField txtSiglaDep;

    @FXML
    private TextField txtNomeDep;

    @FXML
    private Button btnProcurarDep;

    @FXML
    private TableColumn<?, ?> lblcSigla;

    @FXML
    private TableColumn<?, ?> lblcNome;

    @FXML
    private TableColumn<DepartamentoEntity, String> lblcChefe;

    @FXML
    private Button btnNovoDep;

    @FXML
    private Button btnEditarDep;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtNewSiglaDep;

    @FXML
    private TextField txtNewNome;

    @FXML
    private ChoiceBox<?> chbChefeDep;

    @FXML
    private Button btnNovoChef;

    @FXML
    private TextArea txtAreaObs;

    @FXML
    private Button btnConfirmar;

    @FXML
    void btnConfirmar_onAction(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		ButtonType sim = new ButtonType("Sim");
		ButtonType nao = new ButtonType("Não");
		alerta.setTitle("AlphaLab");
		alerta.setHeaderText("Confirmar Departamento de Horário");
		alerta.setContentText("Deseja confirmar a Departamento de Horário?");
		alerta.getButtonTypes().setAll(sim, nao);

		alerta.showAndWait().ifPresent(option -> {
			if (option == sim) {
				DepartamentoEntity dep = this.getDadosTabPreencherDados();
				if (dep.validar() == null) {
					Departamento salvarDepartamento = new Departamento(DAOFactory.getDAOFactory().getDepartamentoDAO());
					salvarDepartamento.save(dep);
				} else {
					Alert alertaDadosInvalidos = new Alert(Alert.AlertType.INFORMATION);
					alertaDadosInvalidos.setTitle("AlphaLab");
					alertaDadosInvalidos.setHeaderText("Dados inconsistentes!");
					alertaDadosInvalidos.setContentText(dep.validar().getMessage());

					alertaDadosInvalidos.show();
				}

			} else {
				alerta.close();
			}
		});

    }

    @FXML
    void btnConfirmar_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnConfirmar_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnEditarDep_onAction(ActionEvent event) {

    }

    @FXML
    void btnEditarDep_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnEditarDep_onMouseCliked(MouseEvent event) {

    }

    @FXML
    void btnExcluir_onAction(ActionEvent event) {

    }

    @FXML
    void btnExcluir_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnExcluir_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnNovoDep_onAction(ActionEvent event) {

    }

    @FXML
    void btnNovoDep_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnNovoDep_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnNovo_onAction(ActionEvent event) {

    }

    @FXML
    void btnNovo_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnNovo_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnPesquisar_onMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnProcurar_onAction(ActionEvent event) {

    }

    @FXML
    void btnProcurar_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnSair_onAction(ActionEvent event) {

    }

    @FXML
    void btnSair_onKeyPressd(KeyEvent event) {

    }

    @FXML
    void btnSair_onKeyPressed(KeyEvent event) {

    }

    @FXML
    void btnSair_onMouseClicked(MouseEvent event) {

    }



private DepartamentoEntity getDadosTabPreencherDados() {
		DepartamentoEntity depEntity = new DepartamentoEntity();

		
		// Horários da reserva
		// Requisitos da reserva
		// Num máx. de alunos
		/*depEntity.setSigla(txtSiglaDep.getText());
		depEntity.setNome(txtNomeDep.getText());
		depEntity.setChefe(lblcChefe.getColumns().);
		depEntity.setObservacao(txaObservacao.getText());
		depEntity.setFixo(ckbFixo.isPressed());
*/
		return depEntity;
	}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblcChefe.setCellValueFactory(new PropertyValueFactory<>("chefe"));
        
    }

}

