package model.service;

import model.dao.DaoFactory;
import model.dao.MeioPagamentoDao;
import model.entities.MeioPagamento;

public class MeioPagamentoService {
	
	private MeioPagamentoDao dao = DaoFactory.createMeioPagamentoDao();

	public void saveOrUpdate(MeioPagamento obj) {

		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}
	
	public void remove(MeioPagamento department) {
		
		dao.deleteById(department.getId());
		
	}
}
