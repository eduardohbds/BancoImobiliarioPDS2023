package br.ufc.trabalhofinalpds.casa;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class CasaPassaVez implements ICasa{
	private CasaView view;

	public CasaPassaVez() {
		this.view = new CasaView();
	}

	public void executaAcao(JogadorModel jogadorAtual) {
		view.avisaQuePassouAVez();
	}
}
