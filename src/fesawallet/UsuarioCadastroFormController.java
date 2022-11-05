package fesawallet;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import db.DbException;
import fesa_wallet.util.AlertUtil;
import fesa_wallet.util.Util;
import fesa_wallet.util.ValidationUtil;
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
	private TextField txtNome;

	@FXML
	private TextField txtSobrenome;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtSenha;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	@FXML
	private Label labelErrorNome;

	@FXML
	private Label labelErrorSobrenome;

	@FXML
	private Label labelErrorEmail;

	@FXML
	private Label labelErrorSenha;

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

		try {
			entity = new Usuario();
			entity = getFormData();
			usuarioService = new UsuarioService();
			usuarioService.saveOrUpdate(entity);
			clearFields();
			clearErrors();
			AlertUtil.showAlert("Cadastro feito", "Sucesso ! ", null, AlertType.INFORMATION);
			
			
		} catch (ValidationException e) {

			setErrorMessages(e.getErrors());
		}

		catch (DbException e) {

			AlertUtil.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private Usuario getFormData() {

		Usuario obj = new Usuario();
		
		validationException = new ValidationException("Validation error");

		// Validacao nome
		if (txtNome.getText() == null || txtNome.getText().trim().equals("") || !ValidationUtil.validacaoTamanho(txtNome.getText())) {
			validationException.addError("nome", "O nome precisa de dois ou mais caracteres alfa !");
		}
		obj.setNome(txtNome.getText());

		// Validacao sobrenome
		if (txtSobrenome.getText() == null || txtSobrenome.getText().trim().equals("") ||  !ValidationUtil.validacaoTamanho(txtSobrenome.getText())) {
			validationException.addError("sobrenome", "O sobrenome precisa de dois ou mais caracteres alfa !");
		}
		obj.setSobrenome(txtSobrenome.getText());

		// Validacao Email
		if (txtEmail.getText() == null || txtEmail.getText().trim().equals("") || !ValidationUtil.validacaoEmail(txtEmail.getText())) {
			validationException.addError("email", "O email esta invalido !");
		}
		obj.setEmail(txtEmail.getText());

		// Validacao senha
		if (txtSenha.getText() == null || txtSenha.getText().trim().equals("") || !ValidationUtil.validacaoSenha(txtSenha.getText())) {
			validationException.addError("senha", "A senha precisa de 6 caracteres, sendo 1 maiusculo, 1 minusculo, 1 caracter especial, 1 número !");
		}
		obj.setSenha(txtSenha.getText());

		if (validationException.getErrors().size() > 0) {

			throw validationException;
		}

		return obj;
	}

	private void clearFields() {

		txtNome.clear();
		txtSobrenome.clear();
		txtEmail.clear();
		txtSenha.clear();
	}
	
	private void clearErrors() {
		
		labelErrorNome.setText("");
		labelErrorSobrenome.setText("");
		labelErrorEmail.setText("");
		labelErrorSenha.setText("");

	}


	@FXML
	public void onBtCancelAction(ActionEvent event) {

		Util.currentStage(event).close();

	}
	
	private void setErrorMessages(Map<String, String> errors) {

		Set<String> fields = errors.keySet();
		
		labelErrorNome.setText(fields.contains("nome") ? errors.get("nome") : "");
		labelErrorSobrenome.setText(fields.contains("sobrenome") ? errors.get("sobrenome") : "");
		labelErrorEmail.setText(fields.contains("email") ? errors.get("email") : "");
		labelErrorSenha.setText(fields.contains("senha") ? errors.get("senha") : "");

		
	}

}
