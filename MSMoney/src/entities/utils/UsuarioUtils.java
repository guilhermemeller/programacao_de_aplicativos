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
		Double totalResumo;
		FinancaEnum finEnum[] = FinancaEnum.values();		
		for(int i = 0; i< listaResumo.size(); i++) {
			for(FinancaEnum financaEnum : finEnum) {
				System.out.println(financaEnum.toString());
				for(Financa financa : listaResumo.get(i)) {
					System.out.println(financa.toString());
				}
			}
			
		}
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
