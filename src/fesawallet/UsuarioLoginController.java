package fesawallet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fesa_wallet.util.AlertUtil;
import fesa_wallet.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Usuario;
import model.service.UsuarioService;

public class UsuarioLoginController implements Initializable {

	private Usuario user;
	private UsuarioService service = new UsuarioService();

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtSenha;

	@FXML
	private Button btEntrar;

	@FXML
	private MenuItem menuItemCadastroUsuario;

	@FXML
	public void onBtFindUserAction(ActionEvent event) {

		user = service.findUser(txtEmail.getText(), txtSenha.getText());
		if (user == null) {

			AlertUtil.showAlert("Acesso não permitido ", null, "usuario e/ou senha não foram encontrado(s)",
					AlertType.ERROR);
		} else {

			Util.currentStage(event).close();
			createDialogForm(user, "/fesawallet/MainView.fxml", new Stage());

		}
	}

	@FXML
	void onBtNewUser(ActionEvent event) {

		Usuario obj = new Usuario();

		createDialogForm(obj, "/fesawallet/UsuarioForm.fxml", new Stage());
	

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

	private void createDialogForm(Usuario obj, String absoluteName, Stage parentStage) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));

			Pane pane = loader.load();
			
			Scene mainScene = new Scene(pane);
			
			Stage primaryStage = new Stage();
			primaryStage.setScene(mainScene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Fesa Wallet");
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			primaryStage.showAndWait();

		} catch (IOException e) {

			e.printStackTrace();

			AlertUtil.showAlert("Io Exception", "Error loading view", e.getMessage(), AlertType.ERROR);

		}

	}

}
