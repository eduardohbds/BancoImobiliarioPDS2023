package br.ufc.trabalhofinalpds.aplicacao;

// import br.ufc.trabalhofinalpds.dado.DadoView;
// import br.ufc.trabalhofinalpds.jogadores.JogadoresAgregacaoView;
// import br.ufc.trabalhofinalpds.casa.*;
import br.ufc.trabalhofinalpds.jogo.JogoModel;

public class Index {
	public static void main(String[] args) {

		try {
			
			JogoModel jogo = new JogoModel();
			jogo.defineQuantidadeJogadores(3);
			jogo.adicionaJogadores();
			jogo.iniciaJogo();
			System.out.println(jogo.retornaLocalJogadores());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
