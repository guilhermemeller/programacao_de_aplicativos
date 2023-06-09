package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.UsuarioDAO;
import database.BancoDados;
import entities.Usuario;

public class UsuarioService {
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new UsuarioDAO(conn).cadastrarUsuario(usuario);
	}
	
	public void atualizarIdUsuario(String login, String senha) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new UsuarioDAO(conn).atualizarIdUsuario(login, senha);
	}
	
	public boolean verificarLogin(String login, String senha) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new UsuarioDAO(conn).verificarLogin(login, senha);
	}
	
	public boolean verificarExistenciaUsuario(String nomeUsuario) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new UsuarioDAO(conn).verificarExistenciaUsuario(nomeUsuario);
	}
}
