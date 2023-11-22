package br.ufc.trabalhofinalpds.jogadores;

import java.util.ArrayList;
import br.ufc.trabalhofinalpds.dado.DadoController;

public class JogadoresAgregacaoController implements IJogadoresAgregacaoController{
	private IJogadoresAgregacao jogadores;
	private IIteradorJogadores iterador;
	
	public JogadoresAgregacaoController() {
		this.jogadores = new JogadoresAgregacao(0, new ArrayList<JogadorModel>());
	}
	
	public void adicionarJogador(String peca) {
		this.jogadores.adicionarJogador(2458, peca);
	}
	
	public boolean removerJogador(String peca) {
		return this.jogadores.removerJogador(peca);
	}
	
	public String verJogadores() {
		return this.jogadores.verJogadores();
	}

	public JogadorModel retornaJogador(String peca) {
		return this.jogadores.retornaJogador(peca);
	}

	public String[] retornaNomesPecas(){
		String[] ret = jogadores.retornaNomesPecas();
		return ret;
	}

	public JogadorModel retornaJogadorAtual(){
		return this.jogadores.retornaJogadorAtual();
	}

	public JogadorModel avancaJogadores(){
		return this.iterador.proximoJogador();
	}

	public boolean retornaSePodeIniciarJogo(){
		return this.jogadores.retornaSePodeIniciarJogo();
	}

	public void criarIterador(){
		this.iterador = this.jogadores.criarIterador();
	}
	
	public void definirJogadorInicial(){
		this.jogadores.definirJogadorInicial();
	}

	public DadoController retornaDado(){
		return this.jogadores.retornaDado();
	}
}
