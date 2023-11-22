package br.ufc.trabalhofinalpds.casa;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class CasaInicio implements ICasa{

    private CasaView view;

    
    public CasaInicio() {
		this.view = new CasaView();
	}

    public void executaAcao(JogadorModel jogadorAtual) {
        view.avisaQuePassouAVez();
    }
}
