package br.com.ncisaude.gr.dominio.instituicao;

import java.util.Arrays;
import java.util.List;

public enum Regiao {
	NORTE(UF.AM, UF.RR, UF.AP, UF.PA, UF.TO, UF.RO, UF.AC),
	NORDESTE(UF.MA, UF.PI, UF.CE, UF.RN, UF.PE, UF.PB, UF.SE, UF.AL, UF.BA),
	CENTROOESTE(UF.MT, UF.MS, UF.GO, UF.DF),
	SUDESTE(UF.SP, UF.RJ, UF.ES, UF.MG),
	SUL(UF.PR, UF.RS, UF.SC);

	private List<UF> estados;

	private Regiao(UF... estados) {
		this.estados = Arrays.asList(estados);
	}

	public static Regiao findByUF(UF uf) {
		if (uf == null) {
			return null;
		}
		return Arrays.asList(Regiao.values()).stream().filter(r -> r.estados.contains(uf)).findFirst().get();
	}


}
