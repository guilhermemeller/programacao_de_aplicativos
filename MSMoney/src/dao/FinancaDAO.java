package dao;

import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;
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

	public List<Financa> buscarRendimentoDespesaPorUsuario(int usuarioId, int mes, int ano, String tipoFinanca)
			throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, categoria, mensal_ocasional, total, tipo, mes, ano "
					+ "FROM rendimento_despesa WHERE usuario_id = ? AND tipo = ? AND mes = ? AND ano = ?");

			st.setInt(1, usuarioId);
			st.setString(2, tipoFinanca);
			st.setInt(3, mes);
			st.setInt(4, ano);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				Categoria categoria = new Categoria(rs.getInt("categoria"));
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");
				int anoAux = rs.getInt("ano");
				Financa financa = new Financa(nome, categoria, mensalOcasional, total, tipo, mesAux, anoAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public List<Financa> buscarRendimentoDespesaPorUsuarioPorAno(int usuarioId, int ano, String tipoFinanca)
			throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, categoria, mensal_ocasional, total, tipo, mes, ano "
					+ "FROM rendimento_despesa WHERE usuario_id = ? AND tipo = ? AND ano = ? GROUP BY nome");

			st.setInt(1, usuarioId);
			st.setString(2, tipoFinanca);
			st.setInt(3, ano);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				Categoria categoria = new Categoria(rs.getInt("categoria"));
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");
				int anoAux = rs.getInt("ano");
				Financa financa = new Financa(nome, categoria, mensalOcasional, total, tipo, mesAux, anoAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public List<Financa> buscarRendimentoDespesaPorUsuarioPorCategoria(int usuarioId, int mes, int ano, String tipoFinanca, int idCategoria)
			throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, categoria, mensal_ocasional, total, tipo, mes, ano "
					+ "FROM rendimento_despesa WHERE usuario_id = ? AND tipo = ? AND mes = ? AND ano = ? AND categoria = ?");

			st.setInt(1, usuarioId);
			st.setString(2, tipoFinanca);
			st.setInt(3, mes);
			st.setInt(4, ano);
			st.setInt(5, idCategoria);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				Categoria categoria = new Categoria(rs.getInt("categoria"));
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");
				int anoAux = rs.getInt("ano");
				Financa financa = new Financa(nome, categoria, mensalOcasional, total, tipo, mesAux, anoAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public List<Financa> buscarRendimentoDespesaPorUsuarioPorCategoriaPorAno(int usuarioId, int ano, String tipoFinanca, int idCategoria)
			throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, categoria, mensal_ocasional, total, tipo, mes, ano "
					+ "FROM rendimento_despesa WHERE usuario_id = ? AND tipo = ? AND ano = ? AND categoria = ? GROUP BY nome");

			st.setInt(1, usuarioId);
			st.setString(2, tipoFinanca);
			st.setInt(3, ano);
			st.setInt(4, idCategoria);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				Categoria categoria = new Categoria(rs.getInt("categoria"));
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");
				int anoAux = rs.getInt("ano");
				Financa financa = new Financa(nome, categoria, mensalOcasional, total, tipo, mesAux, anoAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public List<Financa> buscarInvestimentoPorUsuario(int usuarioId, int mes, int ano) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, mensal_ocasional, total, tipo, mes, ano "
					+ "FROM investimento WHERE usuario_id = ? AND mes = ? AND ano = ?");

			st.setInt(1, usuarioId);
			st.setInt(2, mes);
			st.setInt(3, ano);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");
				int anoAux = rs.getInt("ano");

				Financa financa = new Financa(nome, mensalOcasional, total, tipo, mesAux, anoAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public List<Financa> buscarInvestimentoPorUsuarioPorAno(int usuarioId, int ano) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, mensal_ocasional, total, tipo, mes, ano "
					+ "FROM investimento WHERE usuario_id = ? AND ano = ? GROUP BY nome");

			st.setInt(1, usuarioId);
			st.setInt(2, ano);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");
				int anoAux = rs.getInt("ano");

				Financa financa = new Financa(nome, mensalOcasional, total, tipo, mesAux, anoAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public List<Financa> buscarFundoDespesasPorUsuario(int usuarioId, int mes, int ano) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT nome, total, tipo, mes, ano FROM fundo_despesas WHERE usuario_id = ? AND mes = ? AND ano = ?");

			st.setInt(1, usuarioId);
			st.setInt(2, mes);
			st.setInt(3, ano);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");
				int anoAux = rs.getInt("ano");

				Financa financa = new Financa(nome, total, tipo, mesAux, anoAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public List<Financa> buscarFundoDespesasPorUsuarioPorAno(int usuarioId, int ano) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT nome, total, tipo, mes, ano FROM fundo_despesas WHERE usuario_id = ? AND ano = ? GROUP BY nome");

			st.setInt(1, usuarioId);
			st.setInt(2, ano);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				double total = rs.getDouble("total");
				String tipo = rs.getString("tipo");
				int mesAux = rs.getInt("mes");
				int anoAux = rs.getInt("ano");

				Financa financa = new Financa(nome, total, tipo, mesAux, anoAux);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public int buscarIdRendimentoDespesaPorNome(int usuarioId, String nome, int mes, int ano) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT id FROM rendimento_despesa WHERE usuario_id = ? AND nome LIKE ? AND mes = ? AND ano = ?");

			st.setInt(1, usuarioId);
			st.setString(2, nome);
			st.setInt(3, mes);
			st.setInt(4, ano);
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

	public Double buscarTotalporMes(int usuarioId, String table, String tipo, int mes, int ano) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;
		Double totalFinal = 0.0;

		try {

			st = conn.prepareStatement(
					"SELECT total FROM " + table + " WHERE usuario_id = ? AND mes = ? AND ano = ? AND tipo LIKE ?");

			st.setInt(1, usuarioId);
			st.setInt(2, mes);
			st.setInt(3, ano);
			st.setString(4, tipo);

			rs = st.executeQuery();

			while (rs.next()) {
				totalFinal += rs.getDouble("total");
			}

			return totalFinal;

		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public List<Double> buscarTotalporAno(int usuarioId, String table, String tipo, int ano) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Double totalFinalMensal = 0.0;
		Double totalFinalOcasional = 0.0;
		List<Double> listaTotalFinal = new ArrayList<>();
		
		try {
			if (!tipo.equals("Fundo para Despesas Ocasionais")) {
				st = conn.prepareStatement(
						"SELECT total, mensal_ocasional FROM " + table + " WHERE usuario_id = ? AND ano = ? AND tipo LIKE ?");

				st.setInt(1, usuarioId);
				st.setInt(2, ano);
				st.setString(3, tipo);

				rs = st.executeQuery();

				while (rs.next()) {
					if(rs.getBoolean("mensal_ocasional")) {
						totalFinalMensal += rs.getDouble("total");
					}else {
						totalFinalOcasional += rs.getDouble("total");
					}
				}
				listaTotalFinal.add(totalFinalMensal);
				listaTotalFinal.add(totalFinalOcasional);
				listaTotalFinal.add(totalFinalOcasional+totalFinalMensal);
			}else {
				st = conn.prepareStatement(
						"SELECT total FROM " + table + " WHERE usuario_id = ? AND ano = ? AND tipo LIKE ?");

				st.setInt(1, usuarioId);
				st.setInt(2, ano);
				st.setString(3, tipo);

				rs = st.executeQuery();

				while (rs.next()) {
					totalFinalMensal += rs.getDouble("total");
				}
				listaTotalFinal.add(totalFinalMensal);
			}
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}

		return listaTotalFinal;
	}

	public int buscarIdInvestimentoPorNome(int usuarioId, String nome, int mes, int ano) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT id FROM investimento WHERE usuario_id = ? AND nome LIKE ? AND mes = ? AND ano = ?");

			st.setInt(1, usuarioId);
			st.setString(2, nome);
			st.setInt(3, mes);
			st.setInt(4, ano);
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

	public int buscarIdFundoDespesasPorNome(int usuarioId, String nome, int mes, int ano) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement(
					"SELECT id FROM fundo_despesas WHERE usuario_id = ? AND nome LIKE ? AND mes = ? AND ano = ?");

			st.setInt(1, usuarioId);
			st.setString(2, nome);
			st.setInt(3, mes);
			st.setInt(4, ano);
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
						financa.getTotal(), financa.getTipo(), i + 1, financa.getAno());

				try {

					st = conn.prepareStatement(
							"INSERT INTO rendimento_despesa (nome, categoria, mensal_ocasional, total, tipo, mes, ano, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

					st.setString(1, aux.getNome());
					st.setInt(2, aux.getCategoria().getId_Categoria());
					st.setBoolean(3, aux.isMensal_Ocasional());
					st.setDouble(4, aux.getTotal());
					st.setString(5, aux.getTipo());
					st.setInt(6, aux.getMes());
					st.setInt(7, aux.getAno());
					st.setInt(8, usuarioId);

					st.executeUpdate();

				} finally {

					BancoDados.finalizarStatement(st);
				}
			}
			BancoDados.desconectar();
		} else {

			try {

				st = conn.prepareStatement(
						"INSERT INTO rendimento_despesa (nome, categoria, mensal_ocasional, total, tipo, mes, ano, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

				st.setString(1, financa.getNome());
				st.setInt(2, financa.getCategoria().getId_Categoria());
				st.setBoolean(3, financa.isMensal_Ocasional());
				st.setDouble(4, financa.getTotal());
				st.setString(5, financa.getTipo());
				st.setInt(6, financa.getMes());
				st.setInt(7, financa.getAno());
				st.setInt(8, usuarioId);

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
						financa.getTipo(), i + 1, financa.getAno());

				try {

					st = conn.prepareStatement(
							"INSERT INTO investimento (nome, mensal_ocasional, total, tipo, mes, ano, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)");

					st.setString(1, aux.getNome());
					st.setBoolean(2, aux.isMensal_Ocasional());
					st.setDouble(3, aux.getTotal());
					st.setString(4, aux.getTipo());
					st.setInt(5, aux.getMes());
					st.setInt(6, aux.getAno());
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
						"INSERT INTO investimento (nome, mensal_ocasional, total, tipo, mes, ano, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)");

				st.setString(1, financa.getNome());
				st.setBoolean(2, financa.isMensal_Ocasional());
				st.setDouble(3, financa.getTotal());
				st.setString(4, financa.getTipo());
				st.setInt(5, financa.getMes());
				st.setInt(6, financa.getAno());
				st.setInt(7, usuarioId);

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
						"INSERT INTO fundo_despesas (nome, total, tipo, mes, ano, usuario_id) VALUES (?, ?, ?, ?, ?, ?)");

				st.setString(1, financa.getNome());
				st.setDouble(2, financa.getTotal());
				st.setString(3, financa.getTipo());
				st.setInt(4, i + 1);
				st.setInt(5, financa.getAno());
				st.setInt(6, usuarioId);

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
						"UPDATE rendimento_despesa SET nome = ?, categoria = ?, mensal_ocasional = ?, total = ?, mes = ? , ano = ? WHERE id = ?");

				st.setString(1, financaNova.getNome());
				st.setInt(2, financaNova.getCategoria().getId_Categoria());
				st.setBoolean(3, financaNova.isMensal_Ocasional());
				st.setDouble(4, financaNova.getTotal());
				st.setInt(5, financaNova.getMes());
				st.setInt(6, financaNova.getAno());
				st.setInt(7, financaNova.getId());
				st.executeUpdate();
			} else {

				st = conn.prepareStatement(
						"UPDATE rendimento_despesa SET nome = ?, categoria = ?, mensal_ocasional = ?, total = ?, ano = ? WHERE nome = ? AND tipo = ? AND ano = ?");

				st.setString(1, financaNova.getNome());
				st.setInt(2, financaNova.getCategoria().getId_Categoria());
				st.setBoolean(3, financaNova.isMensal_Ocasional());
				st.setDouble(4, financaNova.getTotal());
				st.setInt(5, financaNova.getAno());
				st.setString(6, nome);
				st.setString(7, financaNova.getTipo());
				st.setInt(8, financaNova.getAno());

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
						"UPDATE investimento SET nome = ?, mensal_ocasional = ?, total = ?, mes = ?, ano = ? WHERE id = ?");

				st.setString(1, financaNova.getNome());
				st.setBoolean(2, financaNova.isMensal_Ocasional());
				st.setDouble(3, financaNova.getTotal());
				st.setInt(4, financaNova.getMes());
				st.setInt(5, financaNova.getAno());
				st.setInt(6, financaNova.getId());
				st.executeUpdate();
			} else {

				st = conn.prepareStatement(
						"UPDATE investimento SET nome = ?, mensal_ocasional = ?, total = ?, ano = ? WHERE nome = ? AND tipo = ? AND ano = ?");

				st.setString(1, financaNova.getNome());
				st.setBoolean(2, financaNova.isMensal_Ocasional());
				st.setDouble(3, financaNova.getTotal());
				st.setInt(4, financaNova.getAno());
				st.setString(5, nome);
				st.setString(6, financaNova.getTipo());
				st.setInt(7, financaNova.getAno());

				st.executeUpdate();
			}

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public void editarFundoDespesas(Financa financaNova, String nome, int ano) throws SQLException {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"UPDATE fundo_despesas SET nome = ?, total = ?, ano = ? WHERE nome = ? AND tipo = ? AND ano = ?");

			st.setString(1, financaNova.getNome());
			st.setDouble(2, financaNova.getTotal());
			st.setInt(3, financaNova.getAno());
			st.setString(4, nome);
			st.setString(5, financaNova.getTipo());
			st.setInt(6, ano);

			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public void excluirFinanca(Financa financa, String table) throws SQLException {
		PreparedStatement st = null;
		try {
			if ((!financa.isMensal_Ocasional()) && (!table.equals("fundo_despesas"))) {
				st = conn.prepareStatement("DELETE FROM " + table + " WHERE id = ?");

				st.setInt(1, financa.getId());
			} else {
				st = conn.prepareStatement("DELETE FROM " + table + " WHERE nome = ? AND tipo = ? AND ano = ?");
				st.setString(1, financa.getNome());
				st.setString(2, financa.getTipo());
				st.setInt(3, financa.getAno());
			}

			st.executeUpdate();

		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<Integer> buscarAnoPorUsuario(int usuario_id, String table, String type) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Integer> listaAnos = new ArrayList<>();

		try {
			st = conn.prepareStatement("SELECT ano FROM " + table + " WHERE usuario_id = ? AND tipo = ? GROUP BY ano");
			st.setInt(1, usuario_id);
			st.setString(2, type);
			rs = st.executeQuery();

			while (rs.next()) {
				int ano = rs.getInt("ano");
				listaAnos.add(ano);
			}
		} finally {
			// Certifique-se de fechar os recursos adequadamente
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
		return listaAnos;
	}
}
