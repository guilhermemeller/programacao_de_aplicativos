package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void editarCategoria(Categoria categoria) throws SQLException {
		PreparedStatement st = null;
		
		try {

			st = conn.prepareStatement(
					"UPDATE categoria SET nome_categoria = ? WHERE id_categoria = ?");

			st.setString(1, categoria.getNome());
			st.setInt(2, categoria.getId_Categoria());
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
	
	public List<Categoria> buscarCategorias() throws SQLException, IOException {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT nome_categoria, id_categoria FROM categoria");
			
			rs = st.executeQuery();
			
			List<Categoria> categorias = new ArrayList<>();
			
			while (rs.next()) {

				String nome = rs.getString("nome_categoria");
				int id_categoria = rs.getInt("id_categoria");

				Categoria categoria = new Categoria(nome, id_categoria);

				categorias.add(categoria);
			}
			
			return categorias;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public String buscarNomeCategoria(int id) throws SQLException, IOException {
		String categoria = "";
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT nome_categoria FROM categoria WHERE id_categoria = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			if(rs.next()) {
				categoria = rs.getString("nome_categoria");
			}
			
			return categoria;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public int buscarIdCategoria(String nomeCategoria) throws SQLException, IOException {
		int idCategoria = -1;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT id_categoria FROM categoria WHERE nome_categoria = ?");
			
			st.setString(1, nomeCategoria);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				idCategoria = rs.getInt("id_categoria");
			}
			
			return idCategoria;
			
		} finally {
			
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}
