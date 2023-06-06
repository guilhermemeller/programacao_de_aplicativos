package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.FinancaDAO;
import database.BancoDados;
import entities.Financa;

public class FinancaService {

	public void inserirFinanca(Financa financa, int usuarioId) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).inserirFinanca(financa, usuarioId);
	}

	public List<Financa> buscarFinancasPorUsuario(int usuarioId) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarFinancasPorUsuario(usuarioId);
	}
}
