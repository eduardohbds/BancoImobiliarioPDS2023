package br.ufc.trabalhofinalpds.aplicacao;

import br.ufc.trabalhofinalpds.jogadores.JogadorModel;
import br.ufc.trabalhofinalpds.jogadores.JogadoresAgregacaoController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class BancoImobiliarioView {

    @FXML
    private Label erroquant;

    @FXML
    private TextField quant;

    @FXML
    private VBox menu;

    @FXML
    private HBox tabuleirocima;

    @FXML
    private HBox tabuleirobaixo;

    @FXML
    private VBox tabuleiroesquerda;

    @FXML
    private VBox tabuleirodireita;

    @FXML
    private ImageView casaview;

    @FXML
    private AnchorPane centroTab;

    @FXML
    private HBox jogadores;

    @FXML
    private HBox dado;

    @FXML
    private Label saldoVerde;

    @FXML
    private Label saldoVermelho;

    @FXML
    private Label saldoAmarelo;

    @FXML
    private Label saldoAzul;

    @FXML
    private Label saldoRoxo;

    @FXML
    private Label saldoLaranja;

    @FXML
    private AnchorPane centroView;

    private List<Node> casas;
    private JogadoresAgregacaoController jogadoresAgregacaoController;
    private JogadorModel jogadorModel;


    @FXML
    public void initialize() {
        casas = new ArrayList<>();
        System.out.println("Iniciando interface...");
    }

    public void onIniciar(){
        String texto = quant.getText();
        try {
            int quant = Integer.parseInt(texto);
            if(quant < 2 || quant > 6){
                throw new NumberFormatException();
            }
            menu.setVisible(false);
            jogadores.setVisible(true);
            dado.setVisible(true);
            centroView.setVisible(true);
            prepararCasas();
            centroTab.setVisible(true);
        } catch (NumberFormatException e){
            erroquant.setVisible(true);
        }
    }

    private void prepararCasas(){
        casas.addAll(tabuleirobaixo.getChildren());
        casas.addAll(tabuleiroesquerda.getChildren());
        casas.addAll(tabuleirocima.getChildren());
        casas.addAll(tabuleirodireita.getChildren());

        casas.sort(Comparator.comparingInt(c -> Integer.parseInt(c.getId())));

        casas.forEach(c -> {
            Pane cp = (Pane) c;
            ImageView img = (ImageView) cp.getChildren().get(0);
            img.setMouseTransparent(true);

            AtomicReference<Image> ultimaImagem = new AtomicReference<>();
            c.setOnMouseEntered(e -> {
                ultimaImagem.set(casaview.getImage());
                casaview.setImage(img.getImage());
            });

            c.setOnMouseExited(e -> {
                casaview.setImage(ultimaImagem.get());
                ultimaImagem.set(null);
            });
        });

        mostrarCasa(0);
    }

    public void mostrarCasa(int i){
        Pane casa = (Pane) casas.get(i);
        ImageView imagemCasa = (ImageView) casa.getChildren().get(0);
        casaview.setImage(imagemCasa.getImage());
    }

    public void valorInicial(){

    }

    public void calcularPosicoes(){
        String[] nomes = jogadoresAgregacaoController.retornaNomesPecas();

        for (int i = 0; i < nomes.length; i++) {
            JogadorModel j = jogadoresAgregacaoController.retornaJogador(nomes[i]);
            int pos = j.retornaLocalNoTabuleiro();

            Pane casa = (Pane) casas.get(pos);
            FlowPane jPane = (FlowPane) casa.getChildren().get(1);
            jPane.getChildren().get(i).setVisible(true);

            final int ii = i;
            casas.forEach(c -> {
                FlowPane op = ((FlowPane) ((Pane) c).getChildren().get(1));
                op.getChildren().get(ii).setVisible(false);
            });
        }
    }
}
