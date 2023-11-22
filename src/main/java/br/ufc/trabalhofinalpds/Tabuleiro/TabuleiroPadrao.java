package br.ufc.trabalhofinalpds.Tabuleiro;

import br.ufc.trabalhofinalpds.casa.*;
import br.ufc.trabalhofinalpds.dado.DadoController;
import br.ufc.trabalhofinalpds.factoryBancoIM.ITabuleiroType;
import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class TabuleiroPadrao implements ITabuleiroType {
    //para futuras implementações de novos tipos de tabuleiros.
    private final CasaAgregacao casas;
    private final int tamanho;

    public TabuleiroPadrao(DadoController dado){
        //aqui cria as casas:
        this.casas = new CasaAgregacao();

        casas.addCasa(new CasaPassaVez());
        casas.addCasa(new CasaPropriedade("Leblon", 100, 6));
        casas.addCasa(new CasaSorte());
        casas.addCasa(new CasaPropriedade("Av. Presidente Vargas", 60, 2));
        casas.addCasa(new CasaPropriedade("Av. Nossa Sr. de Copacabana", 60, 4));
        casas.addCasa(new CasaCompanhia(dado, "Companhia ferroviária", 200, 50));
        casas.addCasa(new CasaPropriedade("Av. Brigadeiro Faria Lima", 240, 20));
        casas.addCasa(new CasaCompanhia(dado, "Companhia de aviação", 200, 50));
        casas.addCasa(new CasaPropriedade("Av. Rebouças", 220, 18));
        casas.addCasa(new CasaPropriedade("Av. 9 de julho", 220, 18));
        casas.addCasa(new CasaPassaVez());
        casas.addCasa(new CasaPropriedade("Av. Europa", 200, 16));
        casas.addCasa(new CasaSorte());
        casas.addCasa(new CasaPropriedade("Rua Algusta", 180, 14));
        casas.addCasa(new CasaPropriedade("Av. Pacaembú", 180, 14));
        casas.addCasa(new CasaCompanhia(dado, "Companhia de taxi", 150, 40));
        casas.addCasa(new CasaSorte());
        casas.addCasa(new CasaPropriedade("Interlados", 350, 35));
        casas.addCasa(new CasaSorte());
        casas.addCasa(new CasaPropriedade("Morumbi", 400, 50));
        casas.addCasa(new CasaPassaVez());
        casas.addCasa(new CasaPropriedade("Flamengo", 120, 8));
        casas.addCasa(new CasaSorte());
        casas.addCasa(new CasaPropriedade("Botafogo", 100, 6));
        casas.addCasa(new CasaImpostos(200));
        casas.addCasa(new CasaCompanhia(dado, "Companhia de navegação", 150, 40));
        casas.addCasa(new CasaPropriedade("Av. Brasil", 160, 12));
        casas.addCasa(new CasaSorte());
        casas.addCasa(new CasaPropriedade("Av. Paulista", 140, 10));
        casas.addCasa(new CasaPropriedade("Jardim Europa", 140, 10));
        casas.addCasa(new CasaVaParaPrisao());
        casas.addCasa(new CasaPropriedade("Copacabana", 260, 22));
        casas.addCasa(new CasaCompanhia(dado, "Companhia de aviação", 200, 50));
        casas.addCasa(new CasaPropriedade("Av. Vieira Souto", 160, 12));
        casas.addCasa(new CasaPropriedade("Av. Brasil", 320, 28));
        casas.addCasa(new CasaCompanhia(dado, "Companhia de taxi aereo", 200, 50));
        casas.addCasa(new CasaPropriedade("Ipanema", 300, 26));
        casas.addCasa(new CasaSorte());
        casas.addCasa(new CasaPropriedade("Jardin Paulista", 280, 24));
        casas.addCasa(new CasaPropriedade("Brooklin", 260, 22));
        
        this.tamanho = 40;
    }

    public void executarAcao(int numeroCasa, JogadorModel jogadroAtual){
        this.casas.executaAcao(numeroCasa, jogadroAtual);
    }

    public int retornaTamanho(){
        return this.tamanho;
    }
}
