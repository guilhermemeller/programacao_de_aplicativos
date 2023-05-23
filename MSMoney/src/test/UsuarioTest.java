package test;

import entities.Financa;
import entities.Financa.FinancaEnum;
import entities.Usuario;


public class UsuarioTest {
	public static void main(String[] args) {
		Usuario usuario = new Usuario("jvchudek90@gmail.com", "1234", "João Chudek");
		Financa financa = new Financa("Salario Mensal", "Salário", true, 1500.0,FinancaEnum.REDIMENTO);
		usuario.usuarioUtils.inserirFinanca(usuario.getRendimentos(), financa);
		
		Financa financa2 = new Financa("13 Salario", "Salário", false, 1500.0,FinancaEnum.REDIMENTO);
		usuario.usuarioUtils.inserirFinanca(usuario.getRendimentos(), financa2);
		usuario.usuarioUtils.vizualizarListaFinanca(usuario.getRendimentos());

	}
}
