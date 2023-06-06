package database;

import java.io.IOException;
import java.sql.SQLException;

import entities.Categoria;
import service.CategoriaService;

public class TesteCategoria {
	
	public static void cadastrarTeste() {
		
		CategoriaService service =  new CategoriaService();
		
		Categoria categoria = new Categoria("Salario");
		
		try {
			service.inserirCategoria(categoria);
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		
		cadastrarTeste();
	}
}
