package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CategoriaDao;
import model.entities.Categoria;
import model.enumerations.TipoDeMovimento;

public class CategoriaDaoJDBC implements CategoriaDao {
	
	private Connection conn;

	public CategoriaDaoJDBC(Connection connection) {
		connection = conn;
	}

	@Override
	public void insert(Categoria dao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Categoria dao) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Categoria dao) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categoria> findAll() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM categoria ORDER BY id");
			
			rs = st.executeQuery();
			
			List<Categoria> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Categoria obj = new Categoria();
				obj.setId(rs.getInt("id"));
				obj.setDescricao(rs.getString("descricao"));
				obj.setTipoDeMovimento(TipoDeMovimento.valueOf(rs.getString("tipoDeMovimento")));
				obj.setIdUsuario(rs.getInt("idUsuario"));
				list.add(obj);
			}
			
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
