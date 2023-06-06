package entities;

import java.util.ArrayList;
import java.util.List;

import entities.utils.UsuarioUtils;


public class Usuario {
	
	private Integer id;
	private String login;
	private String senha;
	private String nome;
	public UsuarioUtils usuarioUtils;
	
	private List<Financa> rendimentos;
	private List<Financa> despesas;
	private List<Financa> longoPrazo;
	private List<Financa> despesasOcasionais;
	
	public String getLogin() {
		return login;
	}
	public static void main(String[] args) {

	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Financa> getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(List<Financa> rendimentos) {
		this.rendimentos = rendimentos;
	}

	public List<Financa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Financa> despesas) {
		this.despesas = despesas;
	}

	public List<Financa> getLongoPrazo() {
		return longoPrazo;
	}

	public void setLongoPrazo(List<Financa> longoPrazo) {
		this.longoPrazo = longoPrazo;
	}

	public List<Financa> getDespesasOcasionais() {
		return despesasOcasionais;
	}

	public void setDespesasOcasionais(List<Financa> despesasOcasionais) {
		this.despesasOcasionais = despesasOcasionais;
	}

	public List<List<Financa>> getResumo() {
		return resumo;
	}

	public void setResumo(List<List<Financa>> resumo) {
		this.resumo = resumo;
	}

	private List<List<Financa>> resumo;
	
	
	
	public Usuario(String login, String senha, String nome) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.rendimentos = null;
		this.despesas = null;
		this.longoPrazo = null;
		this.despesasOcasionais = null;
		this.resumo = new ArrayList<List<Financa>>();
		this.usuarioUtils = new UsuarioUtils();
	}

	public Usuario() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
