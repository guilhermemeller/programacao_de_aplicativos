package entities;

import java.util.List;

public class Usuario {
	
	private String login;
	private String senha;
	private String nome;
	
	private List<Financa> rendimentos;
	private List<Financa> despesas;
	private List<Financa> longoPrazo;
	private List<Financa> despesasOcasionais;
	
	private List<List<Financa>> resumo;
	
	public Usuario() {
		
	}
	
	
	
}
