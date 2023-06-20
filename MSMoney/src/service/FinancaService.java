package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.FinancaDAO;
import database.BancoDados;
import entities.Financa;

public class FinancaService {

	public void inserirRedimentoDespesa(Financa financa, int idUsuario) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).inserirRedimentoDespesa(financa, idUsuario);
	}
	
	public void inserirInvestimento(Financa financa, int idUsuario) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).inserirInvestimento(financa, idUsuario);
	}
	
	public void inserirFundoParaDespesas(Financa financa, int idUsuario) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).inserirFundoParaDespesas(financa, idUsuario);
	}


	public List<Financa> buscarRendimentoDespesaPorUsuario(int idUsuario, int mes, int ano, String tipoFinanca) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarRendimentoDespesaPorUsuario(idUsuario, mes, ano, tipoFinanca);
	}
	
	public List<Financa> buscarRendimentoDespesaPorUsuarioPorAno(int idUsuario, int ano, String tipoFinanca) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarRendimentoDespesaPorUsuarioPorAno(idUsuario, ano, tipoFinanca);
	}
	
	public List<Financa> buscarRendimentoDespesaPorUsuarioPorCategoria(int idUsuario, int mes, int ano, String tipoFinanca, int idCategoria) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarRendimentoDespesaPorUsuarioPorCategoria(idUsuario, mes, ano, tipoFinanca, idCategoria);
	}
	
	public List<Financa> buscarRendimentoDespesaPorUsuarioPorCategoriaPorAno(int idUsuario, int ano, String tipoFinanca, int idCategoria) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarRendimentoDespesaPorUsuarioPorCategoriaPorAno(idUsuario, ano, tipoFinanca, idCategoria);
	}
	
	public List<Financa> buscarInvestimentoPorUsuario(int idUsuario, int mes, int ano) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarInvestimentoPorUsuario(idUsuario, mes, ano);
	}
	
	public List<Financa> buscarInvestimentoPorUsuarioPorAno(int idUsuario, int ano) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarInvestimentoPorUsuarioPorAno(idUsuario, ano);
	}
	
	public List<Financa> buscarFundoDespesasPorUsuario(int idUsuario, int mes, int ano) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarFundoDespesasPorUsuario(idUsuario, mes, ano);
	}
	
	public List<Financa> buscarFundoDespesasPorUsuarioPorAno(int idUsuario, int ano) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarFundoDespesasPorUsuarioPorAno(idUsuario,  ano);
	}
	
	public int buscarIdRendimentoDespesaPorNome(int idUsuario, String nome, int mes, int ano) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarIdRendimentoDespesaPorNome(idUsuario, nome, mes, ano);
	}
	
	public int buscarIdInvestimentoPorNome(int idUsuario, String nome, int mes, int ano) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarIdInvestimentoPorNome(idUsuario, nome, mes, ano);
	}
	
	public int buscarIdFundoDespesasPorNome(int idUsuario, String nome, int mes, int ano) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarIdInvestimentoPorNome(idUsuario, nome, mes, ano);
	}
	
	public void editarRendimentoDespesas(Financa financa, String nome) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).editarRendimentoDespesas(financa, nome);
		
	}
	
	public void editarInvestimento(Financa financa, String nome) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).editarInvestimento(financa, nome);
		
	}
	
	public void editarFundoDespesas(Financa financa, String nome, int ano) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).editarFundoDespesas(financa, nome, ano);
		
	}
	
	public void excluirFinanca(Financa financa, String table) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		new FinancaDAO(conn).excluirFinanca(financa, table);
	}
	
	public Double buscarTotalporMes(int idUsuario, String table,String tipo,  int mes, int ano) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarTotalPorMes(idUsuario, table, tipo, mes, ano);
	}
	
	public List<Double> buscarTotalporAno(int idUsuario, String table,String tipo,  int mes) throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarTotalPorAno(idUsuario, table, tipo, mes);
	}
	
	public List<Integer> buscarAnoPorUsuario(int idUsuario, String table, String type)throws SQLException, IOException{
		Connection conn = BancoDados.conectar();
		return new FinancaDAO(conn).buscarAnoPorUsuario(idUsuario, table, type);
	}
	
}
