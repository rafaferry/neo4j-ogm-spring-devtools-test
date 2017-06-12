package br.com.ncisaude.gr.dominio.instituicao;

public enum IntervaloLeitos {
	ATE_50, ATE_150, ATE_500, MAIS_DE_500;


	public static IntervaloLeitos getIntervaloLeitos(int quantidadeLeitos) {
		if (quantidadeLeitos <= 50) {
			return ATE_50;
		} else if (quantidadeLeitos > 50 && quantidadeLeitos <= 150) {
			return ATE_150;
		} else if (quantidadeLeitos > 150 && quantidadeLeitos <= 500) {
			return ATE_500;
		} else {
			return MAIS_DE_500;
		}
	}
}
