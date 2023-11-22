package br.ufc.trabalhofinalpds.factoryBancoIM;

import br.ufc.trabalhofinalpds.Tabuleiro.TabuleiroPadrao;
import br.ufc.trabalhofinalpds.dado.DadoController;

public class FactoryBI implements IFactoryBI{
    //para futuras implementações de novos tipos de tabuleiros.

    public ITabuleiroType createBI(int type, DadoController dado){
        ITabuleiroType tabuleiro;
        if(type == 1){
            tabuleiro = new TabuleiroPadrao(dado);
        }
        else {
            return null;
        }
        return tabuleiro;
    }
}
