package entities;

public class Financa {
	private String nome;
	private Categoria categoria;
	private boolean mensal_Ocasional;
	private Double total;
	private FinancaEnum tipo;
	private int mes;

	
	public Financa() {
	}
	
	public Financa(String nome, Categoria categoria, boolean mensal_Ocasional, Double total, FinancaEnum tipo,
			int mes) {
		this.nome = nome;
		this.categoria = categoria;
		this.mensal_Ocasional = mensal_Ocasional;
		this.total = total;
		this.tipo = tipo;
		this.mes = mes;
	}

	public enum FinancaEnum {
		REDIMENTO,
		DESPESAS,
		LONGO_PRAZO,
		DESPESAS_OCASIONAIS
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

	public FinancaEnum getTipo() {
		return tipo;
	}

	public void setTipo(FinancaEnum tipo) {
		this.tipo = tipo;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	



	

	
	
}
