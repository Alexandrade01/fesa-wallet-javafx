package fesawallet;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import fesa_wallet.util.Alerts;
import fesa_wallet.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Usuario;
import model.exception.ValidationException;
import model.service.UsuarioService;

public class UsuarioCadastroFormController implements Initializable {

	private Usuario entity;

	private UsuarioService usuarioService;
	
	ValidationException validationException;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtCPF;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtSobrenome;

	@FXML
	private TextField txtUsuario;

	@FXML
	private TextField txtSenha;

	@FXML
	private TextField txtSaldo;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	@FXML
	private Label labelErrorCPF;

	@FXML
	private Label labelErrorNome;

	@FXML
	private Label labelErrorSobrenome;

	@FXML
	private Label labelErrorUsuario;

	@FXML
	private Label labelErrorSenha;

	@FXML
	private Label labelErrorSaldo;

	public void setServices(UsuarioService service) {

		usuarioService = service;
	}

	public void setUsuario(Usuario user) {

		entity = user;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void onBtSaveAction(ActionEvent event) {

		if (entity == null) {
			throw new IllegalStateException();
		}

		if (usuarioService == null) {
			throw new IllegalStateException();
		}

		try {
			entity = getFormData();
			usuarioService.saveOrUpdate(entity);
			clearFields();
			clearErrors();
			Alerts.showAlert("Cadastro feito", "Sucesso ! ", null, AlertType.INFORMATION);
			
			
		} catch (ValidationException e) {

			setErrorMessages(e.getErrors());
		}

		catch (DbException e) {

			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private Usuario getFormData() {

		Usuario obj = new Usuario();
		
		validationException = new ValidationException("Validation error");

		// Validacao ID
		obj.setId(Utils.tryParseToInt(txtId.getText()));

		// Validacao CPF
		if (txtCPF.getText() == null || txtCPF.getText().trim().equals("")) {
			validationException.addError("CPF", "O campo não pode ser vazio ! ");
		}
		obj.setCPF(txtCPF.getText());

		// Validacao nome
		if (txtNome.getText() == null || txtNome.getText().trim().equals("")) {
			validationException.addError("nome", "O campo não pode ser vazio ! ");
		}
		obj.setNome(txtNome.getText());

		// Validacao sobrenome
		if (txtSobrenome.getText() == null || txtSobrenome.getText().trim().equals("")) {
			validationException.addError("sobrenome", "O campo não pode ser vazio ! ");
		}
		obj.setSobrenome(txtSobrenome.getText());

		// Validacao usuario
		if (txtUsuario.getText() == null || txtUsuario.getText().trim().equals("")) {
			validationException.addError("usuario", "O campo não pode ser vazio ! ");
		}
		obj.setUsuario(txtUsuario.getText());

		// Validacao senha
		if (txtSenha.getText() == null || txtSenha.getText().trim().equals("")) {
			validationException.addError("senha", "O campo não pode ser vazio ! ");
		}
		obj.setSenha(txtSenha.getText());

		// inicialmente o plano familia sera vazio
		obj.setPlanoFamilia(null);

		// validacao saldo
		if (txtSaldo.getText() == null || txtSaldo.getText().trim().equals("")) {
			validationException.addError("saldo", "O campo não pode ser vazio ! ");
		}
		obj.setSaldo(Utils.tryParseToDouble(txtSaldo.getText()));

		if (validationException.getErrors().size() > 0) {

			throw validationException;
		}

		return obj;
	}

	private void clearFields() {

		txtId.clear();
		txtCPF.clear();
		txtNome.clear();
		txtSobrenome.clear();
		txtUsuario.clear();
		txtSenha.clear();
		txtSaldo.clear();
	}
	
	private void clearErrors() {
		
		labelErrorCPF.setText("");
		labelErrorNome.setText("");
		labelErrorSobrenome.setText("");
		labelErrorUsuario.setText("");
		labelErrorSenha.setText("");
		labelErrorSaldo.setText("");
	}


	@FXML
	public void onBtCancelAction(ActionEvent event) {

		Utils.currentStage(event).close();

	}
	
	private void setErrorMessages(Map<String, String> errors) {

		Set<String> fields = errors.keySet();
		
		labelErrorCPF.setText(fields.contains("CPF") ? errors.get("CPF"):"");
		labelErrorNome.setText(fields.contains("nome") ? errors.get("nome") : "");
		labelErrorSobrenome.setText(fields.contains("sobrenome") ? errors.get("sobrenome") : "");
		labelErrorUsuario.setText(fields.contains("usuario") ? errors.get("usuario") : "");
		labelErrorSenha.setText(fields.contains("senha") ? errors.get("senha") : "");
		labelErrorSaldo.setText(fields.contains("saldo") ? errors.get("saldo") : "");
		
	}

}
