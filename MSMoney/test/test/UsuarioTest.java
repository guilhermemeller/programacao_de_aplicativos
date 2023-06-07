package test;

import java.io.IOException;
import java.sql.SQLException;

import entities.Financa;
import entities.Usuario;
import service.FinancaService;
import service.UsuarioService;

public class UsuarioTest {

	public static void main(String[] args) {

		/*Usuario usuario = new Usuario("matheus@mitz.com", "12345", "Matheus Mitz");

		UsuarioService user = new UsuarioService();
		FinancaService financaService = new FinancaService();

		/*
		 * try { user.cadastrarUsuario(usuario); } catch (Exception e) {
		 * System.out.println("Erro");// TODO: handle exception }
		 

		try {
			user.atualizarIdUsuario(usuario);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());// TODO: handle exception
		}

		System.out.println(usuario.getId());

		Financa financa = new Financa("Salario Mensal", "Salário", true, 1500.0, FinancaEnum.REDIMENTO);

		try {
			financaService.inserirFinanca(financa, usuario.getId());
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		usuario.setRendimentos(usuario.usuarioUtils.inserirFinanca(usuario.getRendimentos(), financa));

		Financa financa2 = new Financa("13 Salario", "Salário", false, 1500.0, FinancaEnum.REDIMENTO, 2);

		try {
			financaService.inserirFinanca(financa2, usuario.getId());
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		/*
		 * usuario.setRendimentos(usuario.usuarioUtils.inserirFinanca(usuario.
		 * getRendimentos(), financa2));
		 * 
		 * 
		 * Financa financa3 = new Financa("Combustivel","Automovel", true,
		 * 400.0,FinancaEnum.DESPESAS);
		 * usuario.setDespesas(usuario.usuarioUtils.inserirFinanca(usuario.getDespesas()
		 * , financa3));
		 * 
		 * Financa financa4 = new Financa("Poupança", true,
		 * 500.0,FinancaEnum.LONGO_PRAZO);
		 * usuario.setLongoPrazo(usuario.usuarioUtils.inserirFinanca(usuario.
		 * getLongoPrazo(), financa4));
		 * 
		 * Financa financa5 = new Financa("IPVA", true,
		 * 300.0,FinancaEnum.DESPESAS_OCASIONAIS,1);
		 * usuario.setDespesasOcasionais(usuario.usuarioUtils.inserirFinanca(usuario.
		 * getDespesasOcasionais(), financa5));
		 * 
		 * //usuario.usuarioUtils.vizualizarListaFinanca(usuario.getRendimentos());
		 * //usuario.usuarioUtils.vizualizarListaFinanca(usuario.getDespesas());
		 * //usuario.usuarioUtils.vizualizarListaFinanca(usuario.getLongoPrazo());
		 * 
		 * usuario.setResumo(usuario.usuarioUtils.atualizarResumo(usuario.getResumo(),
		 * usuario.getRendimentos(), usuario.getDespesas(),
		 * usuario.getLongoPrazo(),usuario.getDespesasOcasionais())); for(int
		 * i=0;i<12;i++) {
		 * usuario.usuarioUtils.vizualizarResumoMes(usuario.getResumo(),i+1); }
		 */

	}
}
