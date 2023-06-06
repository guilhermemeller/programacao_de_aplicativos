package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.BancoDados;
import entities.Usuario;
import utils.DadosUsuario;

public class UsuarioDAO {

	private Connection conn;

	public UsuarioDAO(Connection conn) {

		this.conn = conn;
	}

	public void cadastrarUsuario(Usuario usuario) throws SQLException, IOException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("INSERT INTO usuario (login, senha, nome) values (?, ?, ?)");

			st.setString(1, usuario.getLogin());
			st.setString(2, usuario.getSenha());
			st.setString(3, usuario.getNome());

			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public void atualizarIdUsuario(String login, String senha) throws SQLException, IOException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT id from usuario where login = ? and senha = ?");

			st.setString(1, login);
			st.setString(2, senha);

			DadosUsuario dadosUsuario = DadosUsuario.getInstance();
			
			rs = st.executeQuery();

			if (rs.next()) {

				dadosUsuario.setId(rs.getInt("id"));
			}

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
	
	public boolean verificarLogin(String login, String senha) throws SQLException, IOException {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {

			st = conn.prepareStatement("SELECT * FROM usuario where login = ? and senha = ?");
			
			st.setString(1, login);
			st.setString(2, senha);
			
			rs = st.executeQuery();

			if (rs.next()) {

				return true;
			}
			
			return false;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}
}
