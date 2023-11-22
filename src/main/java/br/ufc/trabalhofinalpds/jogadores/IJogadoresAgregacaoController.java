package br.ufc.trabalhofinalpds.jogadores;
import br.ufc.trabalhofinalpds.dado.DadoController;

public interface IJogadoresAgregacaoController {
	public void adicionarJogador(String peca);
	public boolean removerJogador(String peca);
	public String verJogadores();
	public JogadorModel retornaJogador(String peca);
	public String[] retornaNomesPecas();
	public JogadorModel retornaJogadorAtual();
	public JogadorModel avancaJogadores();
	public boolean retornaSePodeIniciarJogo();
	public void criarIterador();
	public void definirJogadorInicial();
	public DadoController retornaDado();
}
