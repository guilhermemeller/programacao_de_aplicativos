package entities;

public class Categoria {

	private int id_Categoria;
	private String nome;
	
	public Categoria(int id_Categoria, String nome) {
		super();
		this.id_Categoria = id_Categoria;
		this.nome = nome;
	}

	public Categoria(int id_Categoria) {
		super();
		this.id_Categoria = id_Categoria;
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Categoria(String nome, int id_Categoria) {
		super();
		this.nome = nome;
		this.id_Categoria = id_Categoria;
	}
	
	public int getId_Categoria() {
		return id_Categoria;
	}
	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
