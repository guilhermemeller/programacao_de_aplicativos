package dao;

import java.io.IOException;
import java.sql.Connection;
import service.CategoriaService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.BancoDados;

import java.util.ArrayList;

import entities.Financa;
import entities.Categoria;

public class FinancaDAO {

	private Connection conn;

	public FinancaDAO(Connection conn) {

		this.conn = conn;
	}

	public List<Financa> buscarRendimentoDespesaPorUsuario(int usuarioId, int mes, String tipoFinanca)
			throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, categoria, mensal_ocasional, total, tipo, mes "
					+ "FROM rendimento_despesa WHERE usuario_id = ? AND tipo = ? AND mes = ?");

			st.setInt(1, usuarioId);
			st.setString(2, tipoFinanca);
			st.setInt(3, mes);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				Categoria categoria = new Categoria(rs.getInt("categoria"));
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");

				Financa financa = new Financa(nome, categoria, mensalOcasional, total, tipo, mesAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public List<Financa> buscarInvestimentoPorUsuario(int usuarioId, int mes) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, mensal_ocasional, total, tipo, mes "
					+ "FROM investimento WHERE usuario_id = ? AND mes = ?");

			st.setInt(1, usuarioId);
			st.setInt(2, mes);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");

				Financa financa = new Financa(nome, mensalOcasional, total, tipo, mesAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public List<Financa> buscarFundoDespesasPorUsuario(int usuarioId, int mes) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, total, tipo, mes "
					+ "FROM fundo_despesas WHERE usuario_id = ? AND mes = ?");

			st.setInt(1, usuarioId);
			st.setInt(2, mes);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");

				Financa financa = new Financa(nome, total, tipo, mesAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public int buscarIdRendimentoDespesaPorNome(int usuarioId, String nome, int mes) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT id FROM rendimento_despesa WHERE usuario_id = ? AND nome LIKE ? AND mes = ?");

			st.setInt(1, usuarioId);
			st.setString(2, nome);
			st.setInt(3, mes);
			rs = st.executeQuery();

			if (rs.next()) {
				return rs.getInt("id");
			}

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
		return -1;
	}
	
	public int buscarIdInvestimentoPorNome(int usuarioId, String nome, int mes) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT id FROM investimento WHERE usuario_id = ? AND nome LIKE ? AND mes = ?");

			st.setInt(1, usuarioId);
			st.setString(2, nome);
			st.setInt(3, mes);
			rs = st.executeQuery();

			if (rs.next()) {
				return rs.getInt("id");
			}

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
		return -1;
	}
	
	public int buscarIdFundoDespesasPorNome(int usuarioId, String nome, int mes) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT id FROM fundo_despesas WHERE usuario_id = ? AND nome LIKE ? AND mes = ?");

			st.setInt(1, usuarioId);
			st.setString(2, nome);
			st.setInt(3, mes);
			rs = st.executeQuery();

			if (rs.next()) {
				return rs.getInt("id");
			}

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
		return -1;
	}

	public void inserirRedimentoDespesa(Financa financa, int usuarioId) throws SQLException {

		PreparedStatement st = null;

		if (financa.isMensal_Ocasional()) {

			for (int i = 0; i < 12; i++) {
				Financa aux = new Financa(financa.getNome(), financa.getCategoria(), financa.isMensal_Ocasional(),
						financa.getTotal(), financa.getTipo(), i + 1);

				try {

					st = conn.prepareStatement(
							"INSERT INTO rendimento_despesa (nome, categoria, mensal_ocasional, total, tipo, mes, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)");

					st.setString(1, aux.getNome());
					st.setInt(2, aux.getCategoria().getId_Categoria());
					st.setBoolean(3, aux.isMensal_Ocasional());
					st.setDouble(4, aux.getTotal());
					st.setString(5, aux.getTipo());
					st.setInt(6, aux.getMes());
					st.setInt(7, usuarioId);

					st.executeUpdate();

				} finally {

					BancoDados.finalizarStatement(st);
				}
			}
			BancoDados.desconectar();
		} else {

			try {

				st = conn.prepareStatement(
						"INSERT INTO rendimento_despesa (nome, categoria, mensal_ocasional, total, tipo, mes, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)");

				st.setString(1, financa.getNome());
				st.setInt(2, financa.getCategoria().getId_Categoria());
				st.setBoolean(3, financa.isMensal_Ocasional());
				st.setDouble(4, financa.getTotal());
				st.setString(5, financa.getTipo());
				st.setInt(6, financa.getMes());
				st.setInt(7, usuarioId);

				st.executeUpdate();

			} finally {

				BancoDados.finalizarStatement(st);
				BancoDados.desconectar();
			}
		}
	}

	public void inserirInvestimento(Financa financa, int usuarioId) throws SQLException {

		PreparedStatement st = null;

		if (financa.isMensal_Ocasional()) {

			for (int i = 0; i < 12; i++) {
				Financa aux = new Financa(financa.getNome(), financa.isMensal_Ocasional(), financa.getTotal(),
						financa.getTipo(), i + 1);

				try {

					st = conn.prepareStatement(
							"INSERT INTO investimento (nome, mensal_ocasional, total, tipo, mes, usuario_id) VALUES (?, ?, ?, ?, ?, ?)");

					st.setString(1, aux.getNome());
					st.setBoolean(2, aux.isMensal_Ocasional());
					st.setDouble(3, aux.getTotal());
					st.setString(4, aux.getTipo());
					st.setInt(5, aux.getMes());
					st.setInt(6, usuarioId);

					st.executeUpdate();

				} finally {

					BancoDados.finalizarStatement(st);
				}
			}
			BancoDados.desconectar();
		} else {

			try {

				st = conn.prepareStatement(
						"INSERT INTO investimento (nome, mensal_ocasional, total, tipo, mes, usuario_id) VALUES (?, ?, ?, ?, ?, ?)");

				st.setString(1, financa.getNome());
				st.setBoolean(2, financa.isMensal_Ocasional());
				st.setDouble(3, financa.getTotal());
				st.setString(4, financa.getTipo());
				st.setInt(5, financa.getMes());
				st.setInt(6, usuarioId);

				st.executeUpdate();

			} finally {

				BancoDados.finalizarStatement(st);
				BancoDados.desconectar();
			}
		}
	}

	public void inserirFundoParaDespesas(Financa financa, int usuarioId) throws SQLException {

		PreparedStatement st = null;

		for (int i = 0; i < 12; i++) {

			try {

				st = conn.prepareStatement(
						"INSERT INTO fundo_despesas (nome, total, tipo, mes, usuario_id) VALUES (?, ?, ?, ?, ?)");

				st.setString(1, financa.getNome());
				st.setDouble(2, financa.getTotal());
				st.setString(3, financa.getTipo());
				st.setInt(4, i + 1);
				st.setInt(5, usuarioId);

				st.executeUpdate();

			} finally {

				BancoDados.finalizarStatement(st);
			}
		}
		BancoDados.desconectar();
	}

	public void editarRendimentoDespesas(Financa financaNova, String nome) throws SQLException {
		PreparedStatement st = null;

		try {

			if (!financaNova.isMensal_Ocasional()) {
				st = conn.prepareStatement(
						"UPDATE rendimento_despesa SET nome = ?, categoria = ?, mensal_ocasional = ?, total = ?, mes = ? WHERE id = ?");

				st.setString(1, financaNova.getNome());
				st.setInt(2, financaNova.getCategoria().getId_Categoria());
				st.setBoolean(3, financaNova.isMensal_Ocasional());
				st.setDouble(4, financaNova.getTotal());

				st.setInt(5, financaNova.getMes());

				st.setInt(6, financaNova.getId());
				st.executeUpdate();
			} else {

				st = conn.prepareStatement(
						"UPDATE rendimento_despesa SET nome = ?, categoria = ?, mensal_ocasional = ?, total = ? WHERE nome = ? AND tipo = ?");

				st.setString(1, financaNova.getNome());
				st.setInt(2, financaNova.getCategoria().getId_Categoria());
				st.setBoolean(3, financaNova.isMensal_Ocasional());
				st.setDouble(4, financaNova.getTotal());

				st.setString(5, nome);
				st.setString(6, financaNova.getTipo());

				st.executeUpdate();
			}

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void editarInvestimento(Financa financaNova, String nome) throws SQLException {
		PreparedStatement st = null;

		try {

			if (!financaNova.isMensal_Ocasional()) {
				st = conn.prepareStatement(
						"UPDATE investimento SET nome = ?, mensal_ocasional = ?, total = ?, mes = ? WHERE id = ?");

				st.setString(1, financaNova.getNome());
				st.setBoolean(2, financaNova.isMensal_Ocasional());
				st.setDouble(3, financaNova.getTotal());
				st.setInt(4, financaNova.getMes());

				st.setInt(5, financaNova.getId());
				st.executeUpdate();
			} else {

				st = conn.prepareStatement(
						"UPDATE investimento SET nome = ?, mensal_ocasional = ?, total = ? WHERE nome = ? AND tipo = ?");

				st.setString(1, financaNova.getNome());
				st.setBoolean(2, financaNova.isMensal_Ocasional());
				st.setDouble(3, financaNova.getTotal());

				st.setString(4, nome);
				st.setString(5, financaNova.getTipo());

				st.executeUpdate();
			}

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public void editarFundoDespesas(Financa financaNova, String nome) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"UPDATE fundo_despesas SET nome = ?, total = ? WHERE nome = ? AND tipo = ?");

			st.setString(1, financaNova.getNome());
			st.setDouble(2, financaNova.getTotal());

			st.setString(3, nome);
			st.setString(4, financaNova.getTipo());

			st.executeUpdate();
			
		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public void excluirFinanca(Financa financa, String table) throws SQLException {
		PreparedStatement st = null;
		try {
			if((!financa.isMensal_Ocasional())&&(!table.equals("fundo_despesas"))) {
				st = conn.prepareStatement("DELETE FROM " + table + " WHERE id = ?");

				st.setInt(1, financa.getId());
			}else {
				st = conn.prepareStatement("DELETE FROM " + table + " WHERE nome = ? AND tipo = ?");
				st.setString(1, financa.getNome());
				st.setString(2, financa.getTipo());
			}
			

			st.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
