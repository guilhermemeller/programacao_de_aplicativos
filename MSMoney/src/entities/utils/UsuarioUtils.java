package entities.utils;

import java.util.ArrayList;
import java.util.List;

import entities.Financa;
import entities.Financa.FinancaEnum;

public class UsuarioUtils {
	
	//Função para inserir uma finança na lista de finanças
	public List<Financa> inserirFinanca(List<Financa> listaFinanca,Financa financa) {
		if(financa.isMensal_Ocasional()){
			financa.setTotal(financa.getTotal()*12.0);
		}else {
			financa.setTotal(financa.getTotal());
		}
		
		listaFinanca.add(financa);
		return listaFinanca;
	}
	
	public void vizualizarListaFinanca(List<Financa> listaFinanca) {
		for(Financa financa : listaFinanca) {
			System.out.println(financa.toString());
		}
	}
	
	public List<List<Financa>> inserirListaResumo(List<List<Financa>> listaResumo, List<Financa> listaFinanca){
		listaResumo.add(listaFinanca);
		return listaResumo;
	}
	
	public void vizualizarResumo(List<List<Financa>> listaResumo) {
		Double totalResumo = 0.0;
		for(List<Financa> listaFinanca : listaResumo) {
			Double totalFinanca = 0.0;
			if(listaFinanca.get(0)!=null) {
				System.out.println(listaFinanca.get(0).getTipo());
			}
			for(Financa financa : listaFinanca) {
				totalFinanca += financa.getTotal();
			}
			
			System.out.println(" R$ "+totalFinanca);
			
			
			if(listaFinanca.get(0).getTipo() == FinancaEnum.REDIMENTO) {
				totalResumo += totalFinanca;
			}
			if(listaFinanca.get(0).getTipo() == FinancaEnum.DESPESAS) {
				totalResumo -= totalFinanca;
			}
			if(listaFinanca.get(0).getTipo() == FinancaEnum.LONGO_PRAZO) {
				totalResumo -= totalFinanca;
			}
		}
		System.out.println("TOTAL:\n"+" R$ "+totalResumo);
	}
	
	public List<List<Financa>> atualizarResumo(List<List<Financa>> listaResumo, List<Financa> listaRendimento, List<Financa> listaDespesas, List<Financa> listaLongoPrazo){
		listaResumo = new ArrayList<List<Financa>>();
		listaResumo.add(listaRendimento);
		listaResumo.add(listaDespesas);
		listaResumo.add(listaLongoPrazo);
		return listaResumo;
	}
	
	/*
	public List<Financa> inserirDespesas(List<Financa> listaDespesa,Financa financa) {
		listaDespesa.add(financa);
		return listaDespesa;
	}
	
	public List<Financa> inserirLongoPrazo(List<Financa> listaDespesa,Financa financa) {
		listaDespesa.add(financa);
		return listaDespesa;
	}
	
	public List<Financa> inserirDespesasOcasionais(List<Financa> listaDespesa,Financa financa) {
		listaDespesa.add(financa);
		return listaDespesa;
	}
	*/
}
