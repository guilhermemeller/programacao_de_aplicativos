package entities;

public class Financa {
	private String nome;
	private Categoria categoria;
	private boolean mensal_Ocasional;
	private Double total;
	private String tipo;
	private int mes;
	private int id;
	private int ano;

	
	public Financa() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Financa(String nome, Categoria categoria, boolean mensal_Ocasional, Double total, String tipo, int mes, int ano) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.mensal_Ocasional = mensal_Ocasional;
		this.total = total;
		this.tipo = tipo;
		this.mes = mes;
		this.ano = ano;
	}
	
	public Financa(String nome, boolean mensal_Ocasional, Double total, String tipo, int mes, int ano) {
		super();
		this.nome = nome;
		this.mensal_Ocasional = mensal_Ocasional;
		this.total = total;
		this.tipo = tipo;
		this.mes = mes;
		this.ano = ano;
	}
	
	public Financa(String nome, Double total, String tipo, int mes, int ano) {
		super();
		this.nome = nome;
		this.total = total;
		this.tipo = tipo;
		this.mes = mes;
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isMensal_Ocasional() {
		return mensal_Ocasional;
	}

	public void setMensal_Ocasional(boolean mensal_Ocasional) {
		this.mensal_Ocasional = mensal_Ocasional;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	



	

	
	
}
