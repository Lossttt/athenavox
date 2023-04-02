package io.github.Lossttt.athenavox;



public class HistogramPrinter extends HistogramGenerator 
{

    private static char HIST_CHAR = '*';
    private static String line = "--------------------------------------";

    public HistogramPrinter() {
    }

    private int getMax(int[] arr) 
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) 
        {
            if (arr[i] > max) 
            {
                max = arr[i];
            }
        }
        return max;
    }

    @Override
    public void printTotalVotesHistogram(int[] candidateVotes, String title) 
    {
        System.out.println(title);
        System.out.println(line);
        
        // Generate histogram for total votes per candidate
        for (int i = 0; i < candidateVotes.length; i++) 
        {
            String histogramBar = "";
            for (int j = 0; j < candidateVotes[i]; j++) 
            {
                histogramBar += HIST_CHAR;
            }
            System.out.printf("Candidate %d | %s  \t\t(%d)%n", i, histogramBar, candidateVotes[i]);
        }
        System.out.println("");
    }

    @Override
    public void printMaleVotesHistogram(int[] maleVotes, String title) 
    {
        System.out.println(title);
        System.out.println(line);

        // Generate histogram for male votes per candidate
        for (int i = 0; i < maleVotes.length; i++) 
        {
            String histogramBar = "";
            for (int j = 0; j < maleVotes[i]; j++) 
            {
                histogramBar += HIST_CHAR;
            }
            System.out.printf("Candidate %d | %s  \t\t(%d)%n", i, histogramBar, maleVotes[i]);
        }
        System.out.println("");
    }

    @Override
    public void printFemaleVotesHistogram(int[] femaleVotes, String title) 
    {
        System.out.println(title);
        System.out.println(line);

        // Generate histogram for female votes per candidate
        for (int i = 0; i < femaleVotes.length; i++) 
        {
            String histogramBar = "";
            for (int j = 0; j < femaleVotes[i]; j++) 
            {
                histogramBar += HIST_CHAR;
            }
            System.out.printf("Candidate %d | %s  \t\t(%d)%n", i, histogramBar, femaleVotes[i]);
        }
        System.out.println("");
    }
}


