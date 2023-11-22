package br.ufc.trabalhofinalpds.casa;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class CasaLucros implements ICasa{
	private int valorAdicional;
	
	public CasaLucros(int valorAdicional){
		this.valorAdicional = valorAdicional;
	}

	public void executaAcao(JogadorModel jogadorAtual) {
		jogadorAtual.adicionarDinheiro(this.valorAdicional);
	}
}
