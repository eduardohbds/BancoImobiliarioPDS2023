package br.ufc.trabalhofinalpds.jogadores;

import java.util.Scanner;
import br.ufc.trabalhofinalpds.dado.DadoController;

public class JogadoresAgregacaoView {
	private IJogadoresAgregacaoController jogadorController;
	private Scanner terminal;
	
	public JogadoresAgregacaoView() {
		this.terminal = new Scanner(System.in);
	}
	public void prepararJogo() {
		this.jogadorController = new JogadoresAgregacaoController();
		System.out.println("Preparação de novo jogo iniciada com sucesso");
	}

	public void iniciaJogo() {
		this.defineJogadorInicial();
		if(this.jogadorController.retornaSePodeIniciarJogo()){
			this.jogadorController.criarIterador();
			System.out.println("Jogo iniciado com sucesso!");
		}else{
			System.out.println("Algo impediu a criação do jogo, numero de jogadores invalido!");
		}
	}
	
	public void adicionarJogador() {
		System.out.println("Por favor, adicionar nome da peça do jogador");
		String peca = terminal.nextLine();
		try {
			this.jogadorController.adicionarJogador(peca);
		} catch (Exception e) {
			System.out.println("Não foi possível adicionar jogador, pois: " + e.getMessage());
		}
	}
	
	public void removerJogador() {
		System.out.println("Por favor, digite o nome da peça do jogador que deseja remover");
		String peca = terminal.nextLine();
		try {
			boolean ret = this.jogadorController.removerJogador(peca);
			if(ret == true) System.out.println("jogador de peça " + peca + " foi removido com sucesso!");
		} catch (Exception e) {
			System.out.println("Não foi possível remover jogador, pois: " + e.getMessage());
		}
	}
	
	public void verJogadores() {
		try {
			System.out.println(this.jogadorController.verJogadores());
		} catch (Exception e) {
			System.out.println("Não foi possível visualizar jogadores, pois: " + e.getMessage());
		}
	}

	public JogadorModel retornaJogador(String peca){
		return this.jogadorController.retornaJogador(peca);
	}
	
	public IJogadoresAgregacaoController retronaControllerJogador() {
		return this.jogadorController;
	}

	public JogadorModel retornaJogadorAtual(){
		return this.jogadorController.retornaJogadorAtual();
	}

	public void imprimeDadosJogadorAtual(){
		JogadorModel jogadorAtual = this.jogadorController.retornaJogadorAtual();
		System.out.println("Jogador atual tem a peça " + jogadorAtual.retornaPecaDoJogador() + " e tem " + jogadorAtual.retornaQuantidadeDinheiroJogador() + " de dinheiro!");
		System.out.println();
	}
	
	public void avancaJogadores(){
		this.jogadorController.avancaJogadores();
	}

	public void defineJogadorInicial(){
		this.jogadorController.definirJogadorInicial();
	}

	public DadoController retornaDado(){
		return this.jogadorController.retornaDado();
	}
}
