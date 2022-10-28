package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.UsuarioDao;
import model.entities.Familia;
import model.entities.Usuario;

public class UsuarioDaoJDBC implements UsuarioDao {

	private Connection conn;

	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Usuario obj) {
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO usuario "
					+ "(cpf, nome, sobrenome, usuario, senha, saldo, familiaId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getCPF());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getSobrenome());
			st.setString(4, obj.getUsuario());
			st.setString(5, obj.getSenha());
			st.setDouble(6, obj.getSaldo());
			st.setInt(7, 1);
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Usuario obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByUsuarioSenha(String user, String senha) {
		
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(
					"SELECT usuario.* " + "from usuario " + 
			"WHERE usuario.usuario = ? AND usuario.senha = ? ");
			
			st.setString(1, user);
			st.setString(2, senha);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				
				Usuario usuario = instantiateUsuario(rs);
				return usuario;
			}
			
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}
	
	private Usuario instantiateUsuario(ResultSet rs) throws SQLException {
		
		Usuario user = new Usuario(rs.getInt("id"), 
									rs.getString("CPF"),
									rs.getString("nome"), 
									rs.getString("sobrenome"), 
									rs.getString("usuario"), 
									rs.getString("senha"),
									rs.getDouble("saldo"),
									new Familia()
									);
		return user;
	}

}
