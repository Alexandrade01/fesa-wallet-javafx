package fesawallet;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
import fesa_wallet.util.AlertUtil;
import fesa_wallet.util.Util;
import fesawallet.listener.DataChangeListener;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Categoria;
import model.enumerations.TipoDeMovimento;
import model.service.CategoriaService;

public class CategoriaListController implements Initializable, DataChangeListener {

	private CategoriaService service;

	@FXML
	private TableView<Categoria> tableViewCategoria;

	@FXML
	private TableColumn<Categoria, Integer> tableColumnId;

	@FXML
	private TableColumn<Categoria, String> tableColumnDescricao;

	@FXML
	private TableColumn<Categoria, TipoDeMovimento> tableColumnTipodeMovimento;

	@FXML
	private TableColumn<Categoria, Integer> tableColumnIdUsuario;

	@FXML
	private TableColumn<Categoria, Categoria> tableColumnEdit;

	@FXML
	private TableColumn<Categoria, Categoria> tableColumnRemove;

	@FXML
	private Button buttonNew;

	private ObservableList<Categoria> obsList;

	public void setService(CategoriaService service) {
		this.service = service;
	}

	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = Util.currentStage(event);
		Categoria obj = new Categoria();
		createDialogForm(obj, "/gui/CategoriaForm.fxml", parentStage);
	}

	@Override
	public void onDataChanged() {

		updateTableView();

	}

	public void updateTableView() {

		if (service == null) {

			throw new IllegalStateException("Service was null");
		}
		List<Categoria> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewCategoria.setItems(obsList);
		initEditButtons();
		initRemoveButtons();
	}
	
	private void createDialogForm(Categoria obj, String absoluteName, Stage parentStage) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));

			// carrega a view
			Pane pane = loader.load();

			// populando o form department com o obj Department
			CategoriaFormController controller = loader.getController();
			controller.setCategoria(obj);
			controller.setCategoriaService(new CategoriaService());
			// adiciona um item na lista de listeners portanto sera chamado para atualizar a
			// lista
			controller.subscribeDataChangeListener(this);
			controller.updateFormData();

			// quando quero abrir uma janela nova preciso instanciar um novo stage
			Stage dialogStage = new Stage();

			// setando o titulo do stage
			dialogStage.setTitle("Entre com uma nova categoria");
			//
			dialogStage.setScene(new Scene(pane));
			// propriedade quem diz se a janela PODE OU NAO ser redimensionada
			dialogStage.setResizable(false);
			// indica quem é o stage pai dessa janela
			dialogStage.initOwner(parentStage);
			// window modal trava o app e so podemos usar o stage atual
			dialogStage.initModality(Modality.WINDOW_MODAL);
			// abre e espera a conclusao
			dialogStage.showAndWait();
		} catch (IOException e) {
			
			e.printStackTrace();
			
			AlertUtil.showAlert("Io Exception", "Error loading view", e.getMessage(), AlertType.ERROR);

		}

	}

	private void initRemoveButtons() {
		tableColumnRemove.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnRemove.setCellFactory(param -> new TableCell<Categoria, Categoria>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(Categoria obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setPrefWidth(80);
				button.setOnAction(event -> removeEntity(obj));
			}
		});

	}

	private void initEditButtons() {
		tableColumnEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEdit.setCellFactory(param -> new TableCell<Categoria, Categoria>() {
			private final Button button = new Button("Edit");

			@Override
			protected void updateItem(Categoria obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setPrefWidth(80);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/CategoriaForm.fxml", Util.currentStage(event)));

			}
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initializeNodes();

	}

	// setando as colunas de acordo com o nome dos atributos das classes
	private void initializeNodes() {
		

		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tableColumnTipodeMovimento.setCellValueFactory(new PropertyValueFactory<>("tipodemovimento"));
		tableColumnIdUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));

		// serve para que a lista acompanhe ate o final da tela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewCategoria.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	private void removeEntity(Categoria obj) {
		Optional<ButtonType> result = AlertUtil.showConfirmation("Confirmation", "Tem certeza que você quer deletar ?");

		if (result.get() == ButtonType.OK) {
			if (service == null) {
				throw new IllegalStateException("Service é nulo !");
			}

			try {
				service.remove(obj);
				updateTableView();
			} catch (DbIntegrityException e) {

				AlertUtil.showAlert("Error para mover objeto", null, e.getMessage(), AlertType.ERROR);
			}
		}
	}

}
