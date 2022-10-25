package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fesa_wallet/view/MainView.fxml"));
			AnchorPane anchorPane = loader.load();		
			
			Scene mainScene = new Scene(anchorPane);
			primaryStage.setScene(mainScene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Fesa Wallet");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
