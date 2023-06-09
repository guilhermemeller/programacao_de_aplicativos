package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import database.BancoDados;
import entities.Categoria;

public class CategoriaService {
	
	public void inserirCategoria(Categoria categoria, int idUsuario) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new CategoriaDAO(conn).inserirCategoria(categoria, idUsuario);
	}
	
	public void editarCategoria(Categoria categoria) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new CategoriaDAO(conn).editarCategoria(categoria);
	}
	
	public int excluirCategoria(Integer idCategoria) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new CategoriaDAO(conn).excluirCategoria(idCategoria);
	}
	
	public List<Categoria> buscarCategorias(int idUsuario) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new CategoriaDAO(conn).buscarCategorias(idUsuario);
	}
	
	public String buscarNomeCategoria(int idCategoria) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new CategoriaDAO(conn).buscarNomeCategoria(idCategoria);
	}
	
	public int buscarIdCategoria(String nomeCategoria) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new CategoriaDAO(conn).buscarIdCategoria(nomeCategoria);
	}
}
