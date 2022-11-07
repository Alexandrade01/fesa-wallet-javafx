package model.dao;

import db.DB;
import model.dao.impl.CategoriaDaoJDBC;
import model.dao.impl.MeioPagamentoDaoJDBC;
import model.dao.impl.UsuarioDaoJDBC;

public class DaoFactory {

	public static UsuarioDao createUsuarioDao() {
		return new UsuarioDaoJDBC(DB.getConnection());
	}

	public static MeioPagamentoDao createMeioPagamentoDao() {
		return new MeioPagamentoDaoJDBC(DB.getConnection());
	}

	public static CategoriaDao createDepartmentDao() {
		
		return new CategoriaDaoJDBC(DB.getConnection());
	}
}
