package br.ufc.trabalhofinalpds.jogadores;

import br.ufc.trabalhofinalpds.observer.IObservador;

public class JogadorModel implements IObservador{
	private int quantidadeDinheiro;
	private int localNoTabuleiro;
	private String pecaDoJogo;
	
	public JogadorModel(int quantidadeInicial, String peca) {
		this.quantidadeDinheiro = quantidadeInicial;
		this.localNoTabuleiro = 0;
		this.pecaDoJogo = peca;
	}
	
	public int retornaQuantidadeDinheiroJogador() {
		return this.quantidadeDinheiro;
	}
	
	public int retornaLocalNoTabuleiro() {
		return this.localNoTabuleiro;
	}
	
	public String retornaPecaDoJogador() {
		return this.pecaDoJogo;
	}

	public int retornarDinheiro(){
		return this.quantidadeDinheiro;
	}

	public void adicionarDinheiro(int quantidadeAdicional){
		this.quantidadeDinheiro += quantidadeAdicional;
	}

	public void debitarDinheiro(int quantidadeDebido){
		if(this.quantidadeDinheiro <= quantidadeDebido){
			throw new IllegalArgumentException("O jogador não tem dinheiro o bastante para esse débito!");
		}else{
			this.quantidadeDinheiro -= quantidadeDebido;
		}
	}

	public void atualizaEstado(String pecaAtual){
		if(pecaAtual.equals(this.pecaDoJogo)){
			this.quantidadeDinheiro += 200;
		}
	}

	public void atualizaLocal(int novoLocal){
		this.localNoTabuleiro = novoLocal;
	}
}
