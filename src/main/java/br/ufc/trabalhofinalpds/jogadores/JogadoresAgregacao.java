package br.ufc.trabalhofinalpds.jogadores;

import java.util.ArrayList;
import java.util.Iterator;
import br.ufc.trabalhofinalpds.dado.DadoController;
import br.ufc.trabalhofinalpds.dado.DadoView;

public class JogadoresAgregacao implements IJogadoresAgregacao {
	private IIteradorJogadores interadorJogadores;
	private ArrayList<JogadorModel> listaJogadores;
	private int quantidadeJogadores;
	private int jogadorInicial;
	private DadoController dado;
	private DadoView viewDado;
	
	public JogadoresAgregacao(int quantidadeJogadores, ArrayList<JogadorModel> listaJogadores) {
		this.quantidadeJogadores = quantidadeJogadores;
		this.listaJogadores = listaJogadores;
		this.jogadorInicial = -1;
		this.interadorJogadores = null;
		
		this.dado = new DadoController();
		this.viewDado = new DadoView(this.dado);
	}

	public IIteradorJogadores criarIterador() {
		if(this.retornaSePodeIniciarJogo()) {
			this.interadorJogadores = new IteradorJogadores(this.quantidadeJogadores, this.listaJogadores, this.jogadorInicial);
			return this.interadorJogadores;
		}else {
			throw new IllegalArgumentException("O jogo não pode ser iniciado");
		}
	}
	
	// tem que ser de 0 até numero de jogadores
	public void definirJogadorInicial() {
		int somaMaior = -1, indexJogador = -1;
		for (JogadorModel jogadorModel : listaJogadores) {
			this.viewDado.jogaDados();
			int valorSomado = dado.retornaValorSomado();
			if(valorSomado >= somaMaior){
				somaMaior = valorSomado;
				indexJogador = this.listaJogadores.indexOf(jogadorModel);
			}
		}
		
		this.jogadorInicial = indexJogador;
	}
	
	public boolean adicionarJogador(int quantidadeInicial, String peca) {
		// se interador já criado, não pode mudar os jogadores
		if(this.interadorJogadores != null) {
			throw new IllegalArgumentException("Jogo já iniciado, se quiser adicionar novo jogador, reinicie o jogo!");
		}
		if(this.quantidadeJogadores < 6) {
			for (JogadorModel jogadorModel : this.listaJogadores) {
				if(jogadorModel.retornaPecaDoJogador().equals(peca)) {
					throw new IllegalArgumentException("Algum jogador já escolheu essa peça!");
				}
			}
			this.listaJogadores.add(new JogadorModel(quantidadeInicial, peca));
			this.quantidadeJogadores++;
			return true;
		}else {
			throw new IllegalArgumentException("Quantidade máxima de jogadores atingida!");
		}
	}
	
	public boolean removerJogador(String peca) {
		// se interador já criado, não pode mudar os jogadores
		if(this.interadorJogadores != null) {
			throw new IllegalArgumentException("Jogo já iniciado, se quiser remover um jogador, reinicie o jogo!");
		}
		
		if(this.quantidadeJogadores > 1) {
			Iterator<JogadorModel> itr = this.listaJogadores.iterator();
			
	        while (itr.hasNext()){
	            JogadorModel x = itr.next();
	            if (x.retornaPecaDoJogador().equals(peca)) {
	            	itr.remove();
	            	return true;
	            }
	        }
	        throw new IllegalArgumentException("Jogador não encontrado!");
		}else {
			throw new IllegalArgumentException("Sem jogadores no jogo atual!");
		}
	}
	
	public String verJogadores() {
		if(this.quantidadeJogadores <= 0) {
			throw new IllegalArgumentException("Sem jogadores no jogo atual!");
		}
		String temp = "";
		for (JogadorModel jogadorModel : this.listaJogadores) {
			temp += "Jogador de peça " + jogadorModel.retornaPecaDoJogador() + " tem " + jogadorModel.retornaQuantidadeDinheiroJogador() + "\n";
		}
		return temp;
	}
	
	public String verJogadoresDuranteJogo() {
		if(this.quantidadeJogadores <= 0) {
			throw new IllegalArgumentException("Sem jogadores no jogo atual!");
		}
		String temp = "";
		for(int i = 0; i < this.quantidadeJogadores; i++) {
			
		}
		for (JogadorModel jogadorModel : this.listaJogadores) {
			temp += "Jogador de peça " + jogadorModel.retornaPecaDoJogador() + "\n";
		}
		return temp;
	}

	public JogadorModel retornaJogador(String peca){
		for (JogadorModel jogadorModel : listaJogadores) {
			if(jogadorModel.retornaPecaDoJogador().equals(peca)){
				return jogadorModel;
			}
		}
		throw new IllegalArgumentException("Jogador não encontrado!");
	}

	public String[] retornaNomesPecas(){
		String[] ret = new String[this.quantidadeJogadores];
		int i = 0;
		for (JogadorModel jogadorModel : listaJogadores) {
			ret[i] = jogadorModel.retornaPecaDoJogador();
			i++;
		}
		return ret;
	}

	public JogadorModel retornaJogadorAtual(){
		return this.interadorJogadores.jogadorAtual();
	}

	public boolean retornaSePodeIniciarJogo(){
		if(this.jogadorInicial != -1 || this.quantidadeJogadores < 2 || this.quantidadeJogadores > 6) {
			return true;
		}else {
			return false;
		}
	}

	public DadoController retornaDado(){
		return this.dado;
	}

	public void movimentaJogador(String peca, int novaCasa){
		this.retornaJogador(peca).atualizaLocal(novaCasa);
	}
}
