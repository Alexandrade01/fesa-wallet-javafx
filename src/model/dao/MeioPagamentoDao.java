package model.dao;

import model.entities.MeioPagamento;

public interface MeioPagamentoDao {
	
	void insert (MeioPagamento obj);
	void update (MeioPagamento obj);
	void deleteById(Integer id);
}
