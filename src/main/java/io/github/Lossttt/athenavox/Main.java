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
        String inputFile = "B:\\Java\\athenavox\\Vote_data.text";
        String outputFile = "vote_results";
        HistogramPrinter printer = new HistogramPrinter(outputFile, 7, args);

        VoteCounter counter = new VoteCounter(inputFile);
        System.out.println("------ BEGIN of STATISTICS ------\n");
        counter.printHistogram();
        counter.printResults();
        System.out.println("");
        counter.printTables();
        System.out.println("\n------ END of STATISTICS ------");;

        }

        // launch(); // Comment this if you don't want to stage the scene
    
    }

