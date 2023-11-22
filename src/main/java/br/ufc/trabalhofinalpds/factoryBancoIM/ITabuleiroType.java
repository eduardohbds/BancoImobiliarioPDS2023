package br.ufc.trabalhofinalpds.factoryBancoIM;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public interface ITabuleiroType {
    //para futuras implementações de novos tipos de tabuleiros.

    void executarAcao(int numeroCasa, JogadorModel jogadroAtual);
    public int retornaTamanho();
}
