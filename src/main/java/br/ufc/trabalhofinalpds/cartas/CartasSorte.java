package br.ufc.trabalhofinalpds.cartas;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;

import java.util.Random;

public class CartasSorte implements ICartasSorte {
    GenerateRandomMoney GRM = new GenerateRandomMoney(); // seleciona um valor aleatório dentre os especificados na
                                                         // classe. Falta capturar esse valor para mostrar na tela.
    int randomMoney = GRM.returnMoneyRandomly();

    public void efeitoEspecial(JogadorModel jogadorAtual){
        Random rand = new Random();
        int randomNumber = rand.nextInt(30); //o 29 foi escolhido pelo fato da carta que tira/coloca o jogador da prisão
                                                    // ter uma chance de 1 em 30 de ser selecionada.
        if(randomNumber == 0){
            //se o número selecionado for 0, tira o jogador da prisão, falta implementar.
        }
        else if (randomNumber == 29) {
            //coloca o jogador na prisão
        }
        else if (randomNumber%2 == 0) {
            //se sair um número par, ele tira sort
            jogadorAtual.adicionarDinheiro(randomMoney);
        }
        else if (randomNumber%2 == 1) {
            //se sair um número impar, ele tira reves
            jogadorAtual.debitarDinheiro(randomMoney);
        }
    }

}