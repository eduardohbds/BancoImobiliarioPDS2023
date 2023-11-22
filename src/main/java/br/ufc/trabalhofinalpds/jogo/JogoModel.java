package br.ufc.trabalhofinalpds.jogo;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;
import br.ufc.trabalhofinalpds.jogadores.JogadoresAgregacaoController;
import br.ufc.trabalhofinalpds.observer.IObservador;
import br.ufc.trabalhofinalpds.observer.IObservavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.ufc.trabalhofinalpds.dado.DadoController;
import br.ufc.trabalhofinalpds.factoryBancoIM.*;

public class JogoModel implements IObservavel{
    private JogadoresAgregacaoController jogadorController;
    private  IFactoryBI fabrica;
    private ITabuleiroType tabuleiro;
    private int quantidadeJogadores;
    private ArrayList<IObservador> observados;

    public JogoModel (){
        this.jogadorController = new JogadoresAgregacaoController();

        this.fabrica = new FactoryBI();
        this.observados = new ArrayList<IObservador>();

        this.tabuleiro = this.fabrica.createBI(1, jogadorController.retornaDado());
    }

    // pre condições: precisar já estar com os jogadores definidos
    public String iniciaJogo() {
		this.jogadorController.definirJogadorInicial();
		if(this.jogadorController.retornaSePodeIniciarJogo()){
			this.jogadorController.criarIterador();
            JogadorModel jogadorAtual = this.jogadorController.retornaJogadorAtual();

			return jogadorAtual.retornaPecaDoJogador();
		}else{
			return "Algo impediu a criação do jogo, numero de jogadores invalido!";
		}
	}

    public void defineQuantidadeJogadores(int quantidade){
        this.quantidadeJogadores = quantidade;
    }

    public void adicionaJogadores() {
        String[] pecas = {"Verde", "Vermelho", "Amarelo", "Azul", "Roxo", "Laranja"};
        for (int i = 0; i < this.quantidadeJogadores; i++) {
            this.jogadorController.adicionarJogador(pecas[i]);
            JogadorModel jogadorNovo = this.jogadorController.retornaJogador(pecas[i]);
            this.adicionaObservador(jogadorNovo);
        }
    }

    public void avancarRodada(){

        JogadorModel jogadorAtual =  this.jogadorController.retornaJogadorAtual();
        DadoController dado =  this.jogadorController.retornaDado();
        dado.jogaDados();
        int valorDados = dado.retornaValorSomado();
        this.movimentaJogador(jogadorAtual, valorDados);

        this.tabuleiro.executarAcao(jogadorAtual.retornaLocalNoTabuleiro(), jogadorAtual);
        this.jogadorController.avancaJogadores();

    }

    public String retornaLocalJogadores(){
        String[] nomePecas = this.jogadorController.retornaNomesPecas();
        String ret = "";
        for (int i = 0; i < nomePecas.length; i++) {
            JogadorModel jogador = this.jogadorController.retornaJogador(nomePecas[i]);
            ret += jogador.retornaLocalNoTabuleiro() + " " + jogador.retornaPecaDoJogador() + "\n";
        }
        
        return ret;
    }

    public void movimentaJogador(JogadorModel jogador, int somaDados){
        int localAtual = jogador.retornaLocalNoTabuleiro();
        if(localAtual + somaDados >= 40){
            jogador.atualizaLocal(localAtual + somaDados % 40);
        }else{
            jogador.atualizaLocal(localAtual + somaDados);
        }
    }

    public void adicionaObservador(IObservador observador) {
        this.observados.add(observador);
        
    }

    public void removeObservador(IObservador observador) {
        this.observados.remove(observador);
        
    }

    public void notifique(String pecaAtual) {
        for (IObservador iObservador : observados) {
            iObservador.atualizaEstado(pecaAtual);
        }
        
    }


    
}
