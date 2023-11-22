package br.ufc.trabalhofinalpds.casa;
import br.ufc.trabalhofinalpds.dado.DadoController;
import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

public class CasaCompanhia implements ICasa {
    private JogadorModel dono;
    private DadoController dados;
    private int valorMultiplicado;
    private int valorCompanhia;
    private String nomePropriedade;
    private CasaView view;

    public CasaCompanhia(DadoController dados, String nomePropriedade, int valorCompanhia, int valorMultiplicado){
        this.dono = null;
        this.dados = dados;
        this.valorCompanhia = valorCompanhia;
        this.valorMultiplicado = valorMultiplicado;
        this.nomePropriedade = nomePropriedade;
        this.view = new CasaView();
    }
    public void executaAcao(JogadorModel jogadorAtual){
        if(this.dono == null){
            boolean resposta = this.view.perguntaSeQuerComprar();			
			if(resposta){
				jogadorAtual.debitarDinheiro(valorCompanhia);
				this.dono = jogadorAtual;
			}else{
				this.view.avisaQuePassouAVez();
			}
        }else{
            int valorDados = dados.retornaValorSomado();
            jogadorAtual.debitarDinheiro(valorDados * this.valorMultiplicado);
            dono.adicionarDinheiro(valorDados * this.valorMultiplicado);
        }
        
    }
}
