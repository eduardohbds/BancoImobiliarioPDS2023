package br.ufc.trabalhofinalpds.jogadores;
import br.ufc.trabalhofinalpds.dado.DadoController;

public interface IJogadoresAgregacao extends IAgregadorJogadores{
	public boolean adicionarJogador(int quantidadeInicial, String peca);
	public boolean removerJogador(String peca);
	public String verJogadores();
	public JogadorModel retornaJogador(String peca);
	public String[] retornaNomesPecas();
	public JogadorModel retornaJogadorAtual();
	public boolean retornaSePodeIniciarJogo();
	public void definirJogadorInicial();
	public DadoController retornaDado();
}
