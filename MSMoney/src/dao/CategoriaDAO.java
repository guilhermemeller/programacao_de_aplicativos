package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.BancoDados;
import entities.Categoria;

public class CategoriaDAO {
	
	private Connection conn;

	public CategoriaDAO(Connection conn) {

		this.conn = conn;
	}
	
	public void inserirCategoria(Categoria categoria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {

			st = conn.prepareStatement(
					"INSERT INTO categoria (nome_categoria) VALUES (?)");

			st.setString(1, categoria.getNome());

			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}	
	}
	
	public int excluirCategoria(Integer id_categoria) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement("DELETE FROM categoria WHERE id_categoria = ?");
			
			st.setInt(1, id_categoria);
			
			int update = st.executeUpdate();
			
			return update;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
