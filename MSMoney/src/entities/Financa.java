package entities;

public class Financa {
	private String nome;
	private String categoria;
	private boolean mensal_Ocasional;
	private Double total;
	private FinancaEnum tipo;
	
	public enum FinancaEnum {
		REDIMENTO,
		DESPESAS,
		LONGO_PRAZO,
		DESPESAS_OCASIONAIS
	}
	
	public Financa(String nome, String categoria, boolean mensal_Ocasional, Double total, FinancaEnum tipo) {
		this.nome = nome;
		this.categoria = categoria;
		this.mensal_Ocasional = mensal_Ocasional;
		this.total = total;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
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

	@Override
	public String toString() {
		return "Financa [nome=" + nome + ", categoria=" + categoria + ", mensal_Ocasional=" + mensal_Ocasional
				+ ", total=" + total + "]";
	}
	
	
}
