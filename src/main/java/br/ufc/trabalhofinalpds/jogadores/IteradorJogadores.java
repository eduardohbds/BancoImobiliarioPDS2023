package br.ufc.trabalhofinalpds.jogadores;

import java.util.ArrayList;

public class IteradorJogadores implements IIteradorJogadores{
	private int quantidadeJogadores;
	private ArrayList<JogadorModel> listaJogadores;
	private int jogadorInicial;
	private int interador;

	public IteradorJogadores(int quantidadeJogadores, ArrayList<JogadorModel> listaJogadores, int jogadorInicial) {
		this.quantidadeJogadores = quantidadeJogadores;
		this.listaJogadores = listaJogadores;
		this.jogadorInicial = jogadorInicial;
		this.interador = jogadorInicial;
	}
	
	public JogadorModel primeiroJogador() {
		JogadorModel temp = this.listaJogadores.get(jogadorInicial);
		return temp;
	}

	public JogadorModel proximoJogador() {
		if(this.interador == this.quantidadeJogadores - 1) {
			this.interador = 0;
		}else {
			this.interador++;
		}
		JogadorModel ret = this.listaJogadores.get(this.interador);
		return ret;
	}
	
	// retorna próximo jogador do que foi enviado
	// Lala: Acho q a verificação de "jogador na prisão" poderia ser feita aqui, só uma ideia.
	public JogadorModel proximoJogador(JogadorModel jogador) {
		int interador = 0;
		for (JogadorModel jogadorModel : listaJogadores) {
			if(jogadorModel.retornaPecaDoJogador() == jogador.retornaPecaDoJogador()) {
				break;
			}else {
				interador++;
			}
		}
		if(interador <= 0) {
			throw new IllegalArgumentException("Erro interno, o IteradorJogadores.proximoJogador está errado!");
		}
		if(interador == this.quantidadeJogadores - 1) {
			interador = 0;
		}else {
			interador++;
		}
		JogadorModel ret = this.listaJogadores.get(interador);
		return ret;
	}

	public boolean existeProximoJogador() {
		return true;
	}
	
	public JogadorModel jogadorAtual() {
		JogadorModel ret = this.listaJogadores.get(this.interador);
		return ret;
	}
	
	
}
