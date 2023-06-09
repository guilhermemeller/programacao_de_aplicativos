package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.FinancaDAO;
import database.BancoDados;
import entities.Financa;

public class FinancaService {

	public void inserirRedimentoDespesa(Financa financa, int usuarioId) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).inserirRedimentoDespesa(financa, usuarioId);
	}
	
	public void inserirInvestimento(Financa financa, int usuarioId) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).inserirInvestimento(financa, usuarioId);
	}
	
	public void inserirFundoParaDespesas(Financa financa, int usuarioId) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).inserirFundoParaDespesas(financa, usuarioId);
	}


	public List<Financa> buscarRendimentoDespesaPorUsuario(int usuarioId, int mes, String tipoFinanca) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarRendimentoDespesaPorUsuario(usuarioId, mes, tipoFinanca);
	}
	
	public List<Financa> buscarInvestimentoPorUsuario(int usuarioId, int mes) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarInvestimentoPorUsuario(usuarioId, mes);
	}
	
	public int buscarIdRendimentoDespesaPorNome(int usuarioId, String nome, int mes) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarIdRendimentoDespesaPorNome(usuarioId, nome, mes);
	}
	
	public int buscarIdInvestimentoPorNome(int usuarioId, String nome, int mes) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarIdInvestimentoPorNome(usuarioId, nome, mes);
	}
	
	public void editarRendimentoDespesas(Financa financa, String nome) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).editarRendimentoDespesas(financa, nome);
		
	}
	
	public void editarInvestimento(Financa financa, String nome) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).editarInvestimento(financa, nome);
		
	}
	
	public void excluirFinanca(Financa financa, String table) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).excluirFinanca(financa, table);
	}
	
}
