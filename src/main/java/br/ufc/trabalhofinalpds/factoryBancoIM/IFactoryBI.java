package br.ufc.trabalhofinalpds.factoryBancoIM;
import br.ufc.trabalhofinalpds.dado.DadoController;

public interface IFactoryBI {
    //para futuras implementações de novos tipos de tabuleiros.
    public ITabuleiroType createBI(int type, DadoController dado);
}
