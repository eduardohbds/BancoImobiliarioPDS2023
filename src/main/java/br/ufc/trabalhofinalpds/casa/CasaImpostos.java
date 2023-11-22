package br.ufc.trabalhofinalpds.casa;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class CasaImpostos implements ICasa{
	private int valorImposto;
	public CasaImpostos(int valorImposto){
		this.valorImposto = valorImposto;
	}
	public void executaAcao(JogadorModel jogadorAtual) {
		jogadorAtual.debitarDinheiro(this.valorImposto);
	}
}
