package io.github.Lossttt.athenavox;


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        stage.setScene(SceneRegistry.WELCOME_SCENE); // sets the LOGIN_SCENE
        stage.show(); // shows the LOGIN_SCENE
    }
    public static void main(String[] args) throws Exception {

        System.out.println("===========. BEGIN OF STATISTICS .===========");
        VoteCounterStatistics counter = new VoteCounterStatistics("Vote_data.txt");
        counter.printResults();
        counter.printAgeGroupVotes();
        counter.printGenderDistribution();
        counter.printAgeGroupResults();


        VoteCounter voteCounter = new VoteCounter("Vote_data.txt");
        int[] candidateVotes = voteCounter.getCandidateVotes();
        int[] maleVotes = voteCounter.getMaleVotes();
        int[] femaleVotes = voteCounter.getFemaleVotes();
    
        HistogramPrinter print = new HistogramPrinter();
    
        // print total votes histogram 
        print.printTotalVotesHistogram(candidateVotes, "Histogram of Total Votes per Candidate");
    
        // print male votes histogram 
        print.printMaleVotesHistogram(maleVotes, "Histogram of Male Votes per Candidate");
    
        // print female votes histogram 
        print.printFemaleVotesHistogram(femaleVotes, "Histogram of Female Votes per Candidate");
        System.out.println("===========. END OF STATISTICS .===========");
    }

        // launch(); // Comment this if you don't want to stage the scene
}    
    

