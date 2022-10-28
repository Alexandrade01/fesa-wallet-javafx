package model.service;

import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioService {
	
	private UsuarioDao dao = DaoFactory.createUsuarioDao();
	
	public Usuario findUser(String user, String senha) {
		
		return dao.findByUsuarioSenha(user, senha);
	};
	
	public void saveOrUpdate(Usuario obj) {

		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}

}
