package io.github.Lossttt.athenavox;

public abstract class HistogramGenerator 
{
    public abstract void printTotalVotesHistogram(int[] candidateVotes, String title);

    public abstract void printMaleVotesHistogram(int[] maleVotes, String title);
    
    public abstract void printFemaleVotesHistogram(int[] femaleVotes, String title);
}
