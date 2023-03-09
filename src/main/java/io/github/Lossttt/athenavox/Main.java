package io.github.Lossttt.athenavox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        stage.setScene(SceneRegistry.LOGIN_SCENE); // sets the LOGIN_SCENE
        stage.show(); // shows the LOGIN_SCENE
    }
    public static void main(String[] args) {

        VoteCounter counter = new VoteCounter("B:\\Java\\athenavox\\Vote_data.text");
        System.out.println("------ BEGIN of STATISTICS ------");
        counter.printResults();
        counter.printCandidateHistograms();
        System.out.println("------ END of STATISTICS ------");
        
        launch();
    
    }
}
