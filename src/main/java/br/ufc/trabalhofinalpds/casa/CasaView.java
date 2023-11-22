package br.ufc.trabalhofinalpds.casa;

import java.util.Scanner;

public class CasaView {
    private Scanner terminal;
    public CasaView(){
        this.terminal = new Scanner(System.in);
    }

    public boolean perguntaSeQuerComprar(){
        String resposta = this.terminal.nextLine();
        System.out.println("Deseja comprar essa propriedade? s/n");
        if(resposta.equals("s")){
            return true;
        }else if(resposta.equals("n")){
            return true;
        }else{
            throw new IllegalArgumentException("Entrada invalida!");
        }
    }

    public void avisaQuePassouAVez(){
        System.out.println("O jogador atual passou a vez!");
    }
    
}
