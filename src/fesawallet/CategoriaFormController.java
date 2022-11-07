package fesawallet;

import java.util.ArrayList;
import java.util.List;

import fesawallet.listener.DataChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Categoria;
import model.enumerations.TipoDeMovimento;
import model.service.CategoriaService;

public class CategoriaFormController {

	private Categoria entity;

	private CategoriaService service;

	// lista de componentes interessados em alterações
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();

	@FXML
	private TextField txtDescricao;

	@FXML
	private ComboBox<TipoDeMovimento> comboBoxTipo;

	@FXML
	private Label labelErrorDescricao;
	
	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;
	
	private ObservableList<Categoria> obsList;

	public void setCategoria(Categoria obj) {
		entity = obj;

	}

	public void setCategoriaService(CategoriaService categoriaService) {
		
		service = categoriaService;

	}

	public void subscribeDataChangeListener(DataChangeListener listener) {
		
		dataChangeListeners.add(listener);

	}
	
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		
		
	}

	public void updateFormData() {
		
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}

		txtDescricao.setText(entity.getDescricao());
		if (entity.getTipoDeMovimento() == null) {

			comboBoxTipo.getSelectionModel().selectFirst();
		}
		comboBoxTipo.setValue(entity.getTipoDeMovimento());

	}

}
