package entities;

public class Financa {
	private String nome;
	private Categoria categoria;
	private boolean mensal_Ocasional;
	private Double total;
	private String tipo;
	private int mes;
	private int id;

	
	public Financa() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Financa(String nome, Categoria categoria, boolean mensal_Ocasional, Double total, String tipo,
			int mes) {
		this.nome = nome;
		this.categoria = categoria;
		this.mensal_Ocasional = mensal_Ocasional;
		this.total = total;
		this.tipo = tipo;
		this.mes = mes;
	}
	
	public Financa(String nome, boolean mensal_Ocasional, Double total, String tipo, int mes) {
		super();
		this.nome = nome;
		this.mensal_Ocasional = mensal_Ocasional;
		this.total = total;
		this.tipo = tipo;
		this.mes = mes;
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
	



	

	
	
}
