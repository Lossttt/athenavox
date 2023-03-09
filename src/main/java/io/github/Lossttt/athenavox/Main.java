package io.github.Lossttt.athenavox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {

        VoteCounter counter = new VoteCounter("B:\\Java\\athenavox\\Vote_data.text");
        System.out.println("------ BEGIN of STATISTICS ------");
        counter.printResults();
        counter.printCandidateHistograms();
        System.out.println("------ END of STATISTICS ------");

        //launch();
    }
}
