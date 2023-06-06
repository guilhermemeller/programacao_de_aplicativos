package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.BancoDados;

import java.util.ArrayList;

import entities.Financa;
import entities.Financa.FinancaEnum;
import entities.Categoria;

public class FinancaDAO {

	private Connection conn;

	public FinancaDAO(Connection conn) {

		this.conn = conn;
	}

	public List<Financa> buscarFinancasPorUsuario(int usuarioId) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT nome, categoria, mensal_ocasional, total, tipo, mes "
					+ "FROM Financa WHERE usuario_id = ?");

			st.setInt(1, usuarioId);

			rs = st.executeQuery();

			List<Financa> financas = new ArrayList<>();

			while (rs.next()) {

				String nome = rs.getString("nome");
				Categoria categoria = new Categoria(rs.getInt("categoria"));
				boolean mensalOcasional = rs.getBoolean("mensal_Ocasional");
				double total = rs.getDouble("total");
				String tipoString = rs.getString("tipo");
				int mes = rs.getInt("mes");

				FinancaEnum tipo = FinancaEnum.valueOf(tipoString);

				Financa financa = new Financa(nome, categoria, mensalOcasional, total, tipo, mes);

				financas.add(financa);

			}
			return financas;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public void inserirFinanca(Financa financa, int usuarioId) throws SQLException {

		PreparedStatement st = null;

		if (financa.isMensal_Ocasional()) {

			for (int i = 0; i < 12; i++) {
				Financa aux = new Financa(financa.getNome(), financa.getCategoria(), financa.isMensal_Ocasional(),
						financa.getTotal(), financa.getTipo(), i + 1);

				try {

					st = conn.prepareStatement(
							"INSERT INTO financa (nome, categoria, mensal_ocasional, total, tipo, mes, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)");

					st.setString(1, aux.getNome());
					st.setInt(2, aux.getCategoria().getId_Categoria());
					st.setBoolean(3, aux.isMensal_Ocasional());
					st.setDouble(4, aux.getTotal());
					st.setString(5, aux.getTipo().name());
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
						"INSERT INTO financa (nome, categoria, mensal_ocasional, total, tipo, mes, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?)");

				st.setString(1, financa.getNome());
				st.setInt(2, financa.getCategoria().getId_Categoria());
				st.setBoolean(3, financa.isMensal_Ocasional());
				st.setDouble(4, financa.getTotal());
				st.setString(5, financa.getTipo().name());
				st.setInt(6, financa.getMes());
				st.setInt(7, usuarioId);

				st.executeUpdate();

			} finally {

				BancoDados.finalizarStatement(st);
				BancoDados.desconectar();
			}
		}
	}
}
