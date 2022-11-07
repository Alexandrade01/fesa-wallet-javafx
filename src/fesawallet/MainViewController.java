package fesawallet;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import model.service.MeioPagamentoService;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemPrincipal;
	@FXML
	private MenuItem menuItemCadastroMeiosDePagamento;
	@FXML
	private MenuItem menuItemEntradas;
	@FXML
	private MenuItem menuItemSaidas;
	@FXML
	private MenuItem menuItemRelatorio;
	@FXML
	private MenuItem menuItemCategorias;
	
	@FXML
	public void onMenuPrincipalAction() {
	}
	
	@FXML
	public void onMenuItemCadastroMeiosAction() {
		
//		loadView("/fesawallet/PagamentoList.fxml", 
//				(PagamentoListController controller) -> {  
//					
//					controller.setDepartmentService(new MeioPagamentoService());
//					controller.updateTableView();
//					
//				}
//				
//				);
	}
	
	@FXML
	public void onMenuItemEntradasAction() {
	}
	
	@FXML
	public void onMenuItemSaidasAction() {
		
	}
	
	@FXML
	public void onMenuItemVisualizacaoFamiliaAction() {
		
	}
	
	@FXML
	public void onMenuRelatorioAction() {
		
	}
	
	@FXML
	public void onMenuItemCategorias() {
		
	}
	
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {

//		try {
//
//			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
//			VBox newVBox = loader.load();
//
//			// instancia a tela principal em um objeto
//			Scene mainScene = Main.getMainScene();
//			// guarda o Vbox da tela principal
//			VBox mainVBox = (VBox) (((ScrollPane) mainScene.getRoot()).getContent());
//			// guarda os filhos da Vbox principal no caso o primeiro que é a barra superior
//			Node mainMenu = mainVBox.getChildren().get(0);
//			// limpa todos os childrens da tela
//			mainVBox.getChildren().clear();
//			// remonta os childrens com os da tela principal e em seguida da tela about.fxml
//			mainVBox.getChildren().add(mainMenu);
//			mainVBox.getChildren().addAll(newVBox.getChildren());
//
//			T controller = loader.getController();
//			initializingAction.accept(controller);
//
//		} catch (IOException e) {
//
//			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
//		}
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
