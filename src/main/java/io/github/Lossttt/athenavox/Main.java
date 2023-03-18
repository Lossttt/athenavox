package io.github.Lossttt.athenavox;

import java.security.Principal;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        stage.setScene(SceneRegistry.WELCOME_SCENE); // sets the LOGIN_SCENE
        stage.show(); // shows the LOGIN_SCENE
    }
    public static void main(String[] args) throws Exception {

        VoteCounter counter = new VoteCounter("B:\\Java\\athenavox\\Vote_data.text");
        System.out.println("------ BEGIN of STATISTICS ------");
        counter.printHistogram();
        counter.printResults();
        System.out.println("------ END of STATISTICS ------");;
        
        // launch(); // Comment this if you don't want to stage the scene
    
    }
}
