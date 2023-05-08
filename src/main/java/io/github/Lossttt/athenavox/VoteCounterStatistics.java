package io.github.Lossttt.athenavox;

public class VoteCounterStatistics extends VoteCounter 
{
    
    public VoteCounterStatistics(String filename) throws Exception 
    {
        super(filename);
    }
    
    @Override
    public void printResults() 
    {
        super.printResults();
        printCandidatePercentages();
        printAgeGroupWinners();
    }
    
    public void printCandidatePercentages() 
    {
        int totalVotes = getValidVotes().size();
        System.out.println("\n*** Percentage of votes for each candidate ***");
        int[] candidateVotes = getCandidateVotes(); // get candidate votes array
        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            double percentage = ((double) candidateVotes[i] / totalVotes) * 100;
            System.out.println("Candidate " + i + ": " + String.format("%.2f", percentage) + "%");
        }
        System.out.println();
    }
    
    public void printAgeGroupVotes() 
    {
        System.out.println("*** Number of votes per age group ***");
        for (int i = 0; i < getNumAgeGroups(); i++) 
        {
            int ageGroupStart = i * 15 + 18;
            int ageGroupEnd = ageGroupStart + 14;
            System.out.println("Age group " + i + " (" + ageGroupStart + " - " + ageGroupEnd + "): " + getAgeGroupCounts()[i]);
        }
        System.out.println();
    }
    
    public void printGenderDistribution() 
    {
        System.out.println("*** Gender distribution ***");
        System.out.println("Male: " + String.format("%.2f", getGenderPercentage(0)) + "%");
        System.out.println("Female: " + String.format("%.2f", getGenderPercentage(1)) + "%");
        System.out.println();
    }
    
    double getGenderPercentage(int gender) 
    {
        int totalVotes = getValidVotes().size();
        int genderVotes = 0;
        for (int vote : getValidVotes()) 
        {
            int voteGender = (vote & getGenderMask()) >> 7;
            if (voteGender == gender) 
            {
                genderVotes++;
            }
        }
        return ((double) genderVotes / totalVotes) * 100;
    }

    public void printAgeGroupWinners() 
    {
        int[] ageGroupWinners = getAgeGroupWinners();
        System.out.println("*** Winners per age group ***");
        for (int i = 0; i < NUM_AGE_GROUPS; i++) 
        {
            int ageGroupStart = i * 15;
            int ageGroupEnd = ageGroupStart + 14;

            System.out.printf("Age group %d (%d-%d): Candidate %d\n", i+1, ageGroupStart, ageGroupEnd, ageGroupWinners[i]);
        }
        System.out.println();
    }
}