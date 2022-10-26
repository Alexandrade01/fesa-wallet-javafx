package fesawallet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fesa_wallet.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.entities.Usuario;
import model.service.UsuarioLoginService;

public class UsuarioLoginController implements Initializable {

	private Usuario user;
	private UsuarioLoginService service = new UsuarioLoginService();

	@FXML
	private TextField txtUsuario;

	@FXML
	private TextField txtSenha;

	@FXML
	private Button btEntrar;

	@FXML
	public void onBtFindUserAction(ActionEvent event) {

		user = service.findUser(txtUsuario.getText(), txtSenha.getText());
		if (user == null) {

			Alerts.showAlert("Usuario não encontrado ! ", null, "usuario nao encontrado message", AlertType.ERROR);

		} else {

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fesawallet/MainView.fxml"));
				AnchorPane anchorPane = loader.load();
				Scene mainScene = new Scene(anchorPane);
				Stage primaryStage = new Stage();
				primaryStage.setScene(mainScene);
				primaryStage.setResizable(false);
				primaryStage.setTitle("Fesa Wallet");
				primaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
