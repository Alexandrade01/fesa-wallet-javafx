package fesawallet;

import java.net.URL;
import java.util.ResourceBundle;

import fesawallet.listener.DataChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.entities.MeioPagamento;
import model.service.MeioPagamentoService;

public class PagamentoListController implements Initializable, DataChangeListener {

	private MeioPagamentoService service;

	@FXML
	private TableView<MeioPagamento> tableViewMeioPagamento;

	@FXML
	private TableColumn<MeioPagamento, String> tableColumnDescricao;

	@FXML
	private TableColumn<MeioPagamento, Double> tableColumnSaldo;

	@FXML
	private TableColumn<MeioPagamento, MeioPagamento> tableColumnEdit;

	@FXML
	private Button buttonNew;

	@FXML
	private TableColumn<MeioPagamento, MeioPagamento> tableColumnRemove;

	private ObservableList<MeioPagamento> obsList;

	@FXML
	public void onBtNewAction(ActionEvent event) {
//		Stage parentStage = Utils.currentStage(event);
//		Department obj = new Department();
//		createDialogForm(obj, "/gui/DepartmentForm.fxml", parentStage);
//		System.out.println("onBtNewAction");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initializeNodes();

	}
	
	// setando as colunas de acordo com o nome dos atributos das classes
	private void initializeNodes() {
//
//		tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
//		tableColumnSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
//
//		// serve para que a lista acompanhe ate o final da tela
//		Stage stage = (Stage) Main.getMainScene().getWindow();
//		tableViewMeioPagamento.prefHeightProperty().bind(stage.heightProperty());

	}
	
	public void setMeioPagamentoService(MeioPagamentoService meioPagamentoService) {

		service = meioPagamentoService;

	}

	public void updateTableView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDataChanged() {
		// TODO Auto-generated method stub

	}

	

}
