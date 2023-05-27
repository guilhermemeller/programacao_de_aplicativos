package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.BancoDados;
import entities.Usuario;

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
}
