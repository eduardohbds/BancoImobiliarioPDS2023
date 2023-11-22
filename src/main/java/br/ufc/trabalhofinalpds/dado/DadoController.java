package br.ufc.trabalhofinalpds.dado;

public class DadoController implements IDadoController {
	private IDadoModel dado1;
	private IDadoModel dado2;

	public DadoController() {
		this.dado1 = new DadoModel();
		this.dado2 = new DadoModel();
	}

	public String jogaDados() {
		int valorDado1 = this.dado1.jogarDado();
		int valorDado2 = this.dado2.jogarDado();
		return "Valor do dado 1 = " + valorDado1 + "\nValor do dado 2 = " + valorDado2;
	}

	public int[] retornaValorDados() {
		int[] valor = { -1, -1 };
		valor[0] = this.dado1.retornaUltimoValor();
		valor[1] = this.dado2.retornaUltimoValor();
		return valor;
	}

	public int retornaValorSomado() {
		return this.dado1.retornaUltimoValor() + this.dado2.retornaUltimoValor();
	}

}
