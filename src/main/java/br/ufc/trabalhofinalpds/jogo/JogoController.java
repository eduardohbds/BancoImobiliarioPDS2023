package br.ufc.trabalhofinalpds.jogo;

public class JogoController {
    private JogoModel jogo;

    public JogoController(){
        this.jogo = new JogoModel();
    }

    public String iniciaJogo(){
        return this.jogo.iniciaJogo();
    }

    public void defineQuantidadeJogadores(int quantidade){
        this.jogo.defineQuantidadeJogadores(quantidade);
    }

    public void adicionaJogadores() {
        this.jogo.adicionaJogadores();
    }

    public void avancarRodada(){
        this.jogo.avancarRodada();
    }
}
