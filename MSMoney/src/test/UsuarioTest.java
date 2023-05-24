package test;

import entities.Financa;
import entities.Financa.FinancaEnum;
import entities.Usuario;


public class UsuarioTest {
	public static void main(String[] args) {
		Usuario usuario = new Usuario("jvchudek90@gmail.com", "1234", "João Chudek");
		Financa financa = new Financa("Salario Mensal", "Salário", true, 1500.0,FinancaEnum.REDIMENTO,1);
		usuario.setRendimentos(usuario.usuarioUtils.inserirFinanca(usuario.getRendimentos(), financa));
		
		Financa financa2 = new Financa("13 Salario", "Salário", false, 1500.0,FinancaEnum.REDIMENTO,1);
		usuario.setRendimentos(usuario.usuarioUtils.inserirFinanca(usuario.getRendimentos(), financa2));
		
		Financa financa3 = new Financa("Combustivel","Automovel", true, 400.0,FinancaEnum.DESPESAS,1);
		usuario.setDespesas(usuario.usuarioUtils.inserirFinanca(usuario.getDespesas(), financa3));
		
		Financa financa4 = new Financa("Poupança", true, 500.0,FinancaEnum.LONGO_PRAZO,1);
		usuario.setLongoPrazo(usuario.usuarioUtils.inserirFinanca(usuario.getLongoPrazo(), financa4));
		
		
		usuario.usuarioUtils.vizualizarListaFinanca(usuario.getRendimentos());
		usuario.usuarioUtils.vizualizarListaFinanca(usuario.getDespesas());
		usuario.usuarioUtils.vizualizarListaFinanca(usuario.getLongoPrazo());
		
		usuario.setResumo(usuario.usuarioUtils.atualizarResumo(usuario.getResumo(), usuario.getRendimentos(), usuario.getDespesas(), usuario.getLongoPrazo()));
		usuario.usuarioUtils.vizualizarResumo(usuario.getResumo());
	}
}
