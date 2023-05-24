package entities.utils;

import java.util.ArrayList;
import java.util.List;

import entities.Financa;
import entities.Financa.FinancaEnum;

public class UsuarioUtils {
	
	//Função para inserir uma finança na lista de finanças
	public List<Financa> inserirFinanca(List<Financa> listaFinanca,Financa financa) {
		if(listaFinanca==null) {
			listaFinanca= new ArrayList<Financa>();
		}
		if(financa.isMensal_Ocasional()){
			for(int i=0; i<12 ; i++) {
				Financa aux = new Financa(financa.getNome(),financa.getCategoria(),financa.isMensal_Ocasional(),financa.getTotal(),financa.getTipo(),i+1);
				listaFinanca.add(aux);
			}

		}else {
			listaFinanca.add(financa);
		}
		//System.out.println("Final :"+listaFinanca);
		return listaFinanca;
	}
	
	//Função para vizializar a lista de finanças
	public void vizualizarListaFinanca(List<Financa> listaFinanca) {
		for(Financa financa : listaFinanca) {
			System.out.println(financa.toString());
		}
	}
	
	//Função para inserir as listas na lista Resumo
	public List<List<Financa>> inserirListaResumo(List<List<Financa>> listaResumo, List<Financa> listaFinanca){
		listaResumo.add(listaFinanca);
		return listaResumo;
	}
	
	// Função para vizualizar o resumo do mes
	public void vizualizarResumoMes(List<List<Financa>> listaResumo, int mes) {
		System.out.println("Resumo do mes "+mes);
		Double totalResumo = 0.0;
		for(List<Financa> listaFinanca : listaResumo) {
			Double totalFinanca = 0.0;
			if(listaFinanca!=null) {
				System.out.println(listaFinanca.get(0).getTipo());
					
				for(Financa financa : listaFinanca) {
					if(financa.getMes() == mes) {
						totalFinanca += financa.getTotal();
					}
				}
				
				
				System.out.println(" R$ "+totalFinanca+"\n");
				
				
				if(listaFinanca.get(0).getTipo() == FinancaEnum.REDIMENTO) {
					totalResumo += totalFinanca;
				}
				if(listaFinanca.get(0).getTipo() == FinancaEnum.DESPESAS) {
					totalResumo -= totalFinanca;
				}
				if(listaFinanca.get(0).getTipo() == FinancaEnum.LONGO_PRAZO) {
					totalResumo -= totalFinanca;
				}
				if(listaFinanca.get(0).getTipo() == FinancaEnum.DESPESAS_OCASIONAIS) {
					totalResumo -= totalFinanca;
				}
			}
		}
		System.out.println("TOTAL:\n"+" R$ "+totalResumo);
	}
	
	public List<List<Financa>> atualizarResumo(List<List<Financa>> listaResumo, List<Financa> listaRendimento, List<Financa> listaDespesas, List<Financa> listaLongoPrazo, List<Financa> listaDespesasOcasionais){
		listaResumo = new ArrayList<List<Financa>>();
		listaResumo.add(listaRendimento);
		listaResumo.add(listaDespesas);
		listaResumo.add(listaLongoPrazo);
		listaResumo.add(listaDespesasOcasionais);
		return listaResumo;
	}
	
}
