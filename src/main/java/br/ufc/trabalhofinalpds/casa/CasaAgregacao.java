package br.ufc.trabalhofinalpds.casa;

import java.util.ArrayList;
import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class CasaAgregacao {
	private ArrayList<ICasa> casas;

	public CasaAgregacao() {
		this.casas = new ArrayList<ICasa>();
	}

	public void executaAcao(int numeroDaCasa, JogadorModel jogadorAtual) {
		this.casas.get(numeroDaCasa).executaAcao(jogadorAtual);
	}

	public void addCasa(ICasa casa) {
		this.casas.add(casa);
	}
}
