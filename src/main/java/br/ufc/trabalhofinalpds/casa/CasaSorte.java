package br.ufc.trabalhofinalpds.casa;

import br.ufc.trabalhofinalpds.cartas.CartasSorte;
import br.ufc.trabalhofinalpds.cartas.ICartasSorte;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class CasaSorte implements ICasa{
	ICartasSorte cartaSortReves = new CartasSorte();

	public void executaAcao(JogadorModel jogadorAtual) {
		cartaSortReves.efeitoEspecial(jogadorAtual);

	}
}
