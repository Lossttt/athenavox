package main.java;

public class Main {
    public static <String> void main(String[] args) {

        VoteCounter counter = new VoteCounter("B:\\Java\\athenavox\\athenavox\\AthenaVox\\src\\main\\java\\Vote_data.text");
        System.out.println("------ BEGIN of STATISTICS ------");
        counter.printResults();
        counter.printCandidateHistograms();
        System.out.println("------ END of STATISTICS ------");

    }
}
