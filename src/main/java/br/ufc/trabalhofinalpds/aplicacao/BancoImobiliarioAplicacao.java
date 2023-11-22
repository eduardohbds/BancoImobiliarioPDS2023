package br.ufc.trabalhofinalpds.aplicacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BancoImobiliarioAplicacao extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BancoImobiliarioAplicacao.class.getResource("bancoimobiliario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 752.84, 768);
        stage.setTitle("Banco Imobilariadasso");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}