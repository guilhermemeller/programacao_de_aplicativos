package database;

import entities.Financa;
import service.FinancaService;

import java.io.IOException;
import java.sql.SQLException;

import entities.Categoria;

public class TesteFinanca {
	
	public static void cadastrarTeste() {
		
		FinancaService service = new FinancaService();
		
		Categoria categoria = new Categoria(1);
		
		Financa financa = new Financa("Combustivel", categoria, false, 240.00, "Despesa", 3);
		
		try {
			service.inserirFinanca(financa, 10);
			System.out.println("Deu certo");
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	public static void main(String[] args) {
		
		cadastrarTeste();
	}
}
