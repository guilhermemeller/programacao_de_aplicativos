package database;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entities.Categoria;
import service.CategoriaService;

public class TesteCategoria {
	
	public static void cadastrarTeste() {
		
		CategoriaService service =  new CategoriaService();
		
		Categoria categoria = new Categoria("13 Salario");
		
		try {
			service.inserirCategoria(categoria);
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void buscarTeste() {
		
		CategoriaService service =  new CategoriaService();
		
		try {
			List<Categoria> categorias = service.buscarCategorias();
			
			for(Categoria categoria : categorias) {
				System.out.println(categoria.getNome());
			}
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		cadastrarTeste();
		buscarTeste();
	}
}
