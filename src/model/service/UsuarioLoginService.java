package model.service;

import model.dao.DaoFactory;
import model.dao.UsuarioDao;
import model.entities.Usuario;

public class UsuarioLoginService {
	
	private UsuarioDao dao = DaoFactory.createUsuarioDao();
	
	public Usuario findUser(String user, String senha) {
		
		return dao.findByUsuarioSenha(user, senha);
	};

}
