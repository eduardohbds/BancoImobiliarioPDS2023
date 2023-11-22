package br.ufc.trabalhofinalpds.dado;

public class DadoView {
	private IDadoController dadoController;

	public DadoView() {
		this.dadoController = new DadoController();
	}

	public DadoView(IDadoController dadoController){
		this.dadoController = dadoController;
	}

	public void jogaDados() {
		System.out.println(this.dadoController.jogaDados());
	}
}
