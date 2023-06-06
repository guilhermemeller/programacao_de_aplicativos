package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.CategoriaDAO;
import database.BancoDados;
import entities.Categoria;

public class CategoriaService {
	
	public void inserirCategoria(Categoria categoria) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new CategoriaDAO(conn).inserirCategoria(categoria);
	}
}
