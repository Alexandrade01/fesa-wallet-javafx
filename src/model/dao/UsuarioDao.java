package model.dao;

import java.util.List;

import model.entities.Usuario;

public interface UsuarioDao {

	void insert(Usuario obj);

	void update(Usuario obj);

	void deleteById(Integer id);

	Usuario findByEmailSenha(String user, String senha);

	List<Usuario> findAll();

}
