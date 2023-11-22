package br.ufc.trabalhofinalpds.casa;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class CasaPropriedade implements ICasa{
	private String nomePropriedade;
	private int valorPropriedade;
	private int valorAluguel;
	private JogadorModel donoDaPropriedade;
	private CasaView view;

	public CasaPropriedade(String nome, int valorPropriedade, int valorAluguel) {
		this.nomePropriedade = nome;
		this.valorPropriedade = valorPropriedade;
		this.valorAluguel = valorAluguel;
		this.donoDaPropriedade = null;
		this.view = new CasaView();
	}

	public void executaAcao(JogadorModel jogadorAtual) {
		// ou paga aluguel para o dono, ou pode comprar essa propriedade
		if(this.donoDaPropriedade == null){
			// pergunta se quer comprar
			boolean resposta = this.view.perguntaSeQuerComprar();			
			if(resposta){
				jogadorAtual.debitarDinheiro(valorPropriedade);
				this.donoDaPropriedade = jogadorAtual;
			}else{
				this.view.avisaQuePassouAVez();
			}
		}else{
			// paga aluguel
			jogadorAtual.debitarDinheiro(valorAluguel);
			this.donoDaPropriedade.adicionarDinheiro(valorAluguel);
		}
	}
}
