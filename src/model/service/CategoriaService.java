package model.service;

import java.util.List;

import model.dao.CategoriaDao;
import model.dao.DaoFactory;
import model.entities.Categoria;

public class CategoriaService {
	
	private CategoriaDao dao = DaoFactory.createDepartmentDao();
	
	public List<Categoria> findAll() {
		
		return dao.findAll();
	}

	public void remove(Categoria obj) {
		// TODO Auto-generated method stub
		
	}

}
