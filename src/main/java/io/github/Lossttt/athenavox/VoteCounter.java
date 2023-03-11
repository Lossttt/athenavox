// Package
package io.github.Lossttt.athenavox;

// Imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class VoteCounter 
{
    private static final int NUM_CANDIDATES = 8;     // Constant that defines the number of candidates in the election.
    private static final int AGE_MASK = 0xFE00;      // Constant that masks the age bits in a vote.
    private static final int GENDER_MASK = 0x0100;   // Constant that masks the gender bit in a vote.
    private static final int CANDIDATE_MASK = 0xFF;  // Constant the masks the candidate bit in a vote.
    private static final int NUM_AGE_GROUPS = 4;     // Constant that defines the number of age groups in the election.

    private List<Integer> validVotes;                // List of valid votes.
    private int[] candidateVotes;                    // Array of vote counts for each candidate.
    private int[] maleVotes;                         // Array of vote counts for male voters.
    private int[] femaleVotes;                       // Array of vote counts for female voters.
    private int[] ageGroupVotes;                     // Array of vote counts for each voter in age group.
    private int[] ageGroupCounts;                    // Array of counts of voters in each age group.

    public VoteCounter(String filename) 
    {            
        validVotes = new ArrayList<>();              // Initialize list of valid votes.
        candidateVotes = new int[NUM_CANDIDATES];    // Initialize array of vote counts for each candidate.   
        maleVotes = new int[NUM_CANDIDATES];         // Initialize array of vote counts for each male voter.
        femaleVotes = new int[NUM_CANDIDATES];       // Initialize array of vote counts for each frmale voter.
        ageGroupVotes = new int[NUM_AGE_GROUPS * NUM_CANDIDATES];
        ageGroupCounts = new int[NUM_AGE_GROUPS];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                int vote = Integer.parseInt(line, 16); // For each line, the code converts it from a hexadecimal string to an integer using Integer.parseInt 
                int age = (vote & AGE_MASK) >> 9;
                int gender = (vote & GENDER_MASK) >> 7;
                int candidate = vote & CANDIDATE_MASK;

                if (isValidVote(age, candidate)) 
                {
                    validVotes.add(vote);
                    // The code checks if the vote is valid by calling the isValidVote() method, 
                    // passing in the age and candidate as arguments. 
                    // ** If the vote is valid, it adds the vote to the validVotes. **
                }
            }

        } catch (IOException e) 
        {
            System.err.println("Failed to read file: " + e.getMessage());
            System.exit(1);
        }

        calculateStatistics();
        // After all votes have been processed, the code call the method below to calculate statistics on the valid votes.
    }

    public void printCandidateHistograms() 
    {
        System.out.println("Histogram of total votes per candidate:");
        // System.out.println("--- BEGIN of HISTOGRAM ---");
        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            System.out.print("Candidate " + i + "\t| ");
            for (int j = 0; j < candidateVotes[i]; j++) 
            {
                System.out.print("*");
            }
            System.out.println();
        }
        // System.out.println("--- END of HISTOGRAM ---");
        System.out.println();

        System.out.println("Histogram of male votes per candidate:");
        // System.out.println("--- BEGIN of HISTOGRAM ---");
        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            System.out.print("Candidate " + i + "\t| ");
            for (int j = 0; j < maleVotes[i]; j++) 
            {
                System.out.print("*");
            }
            System.out.println();
        }
        // System.out.println("--- END of HISTOGRAM ---");
        System.out.println();

        System.out.println("Histogram of female votes per candidate:");
        // System.out.println("--- BEGIN of HISTOGRAM ---");
        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            System.out.print("Candidate " + i + "\t| ");
            for (int j = 0; j < femaleVotes[i]; j++) 
            {
                System.out.print("*");
            }
            System.out.println();
        }
        // System.out.println("--- END of HISTOGRAM ---");
        System.out.println();

    }

    private void calculateStatistics() 
    {
        for (int vote : validVotes) {
            int age = (vote & AGE_MASK) >> 9;
            int gender = (vote & GENDER_MASK) >> 7;
            int candidate = vote & CANDIDATE_MASK;

            candidateVotes[candidate]++;
            if (gender == 0) {
                maleVotes[candidate]++;
            } else {
                femaleVotes[candidate]++;
            }

            int ageGroup = getAgeGroup(age);
            ageGroupVotes[ageGroup * NUM_CANDIDATES + candidate]++;
            ageGroupCounts[ageGroup]++;
        }
    }

    public void printResults() 
    {
        System.out.println("*** Total number of valid votes: " + validVotes.size() + " ***");
        System.out.println("");
        System.out.println("--- Candidate statistics: ---");
        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            System.out.println();
            System.out.println("Candidate " + i + ": " + candidateVotes[i] + " votes");
            System.out.println("  Male votes:\t" + maleVotes[i]);
            System.out.println("  Female votes:\t" + femaleVotes[i]);
            for (int j = 0; j < NUM_AGE_GROUPS; j++) 
            {
                int ageGroupVoteCount = ageGroupVotes[j * NUM_CANDIDATES + i];
                int ageGroupCount = ageGroupCounts[j];
                double ageGroupVotePercent = 100.0 * ageGroupVoteCount / ageGroupCount;
                System.out.printf("  Age group %d: %d votes\t(%.2f%%)\n", j, ageGroupVoteCount, ageGroupVotePercent);
            }
        }

        int youthCandidate = getTopCandidate(candidateVotes, 0, 3);
        int elderCandidate = getTopCandidate(candidateVotes, 4, 7);
        System.out.println();
        System.out.println("Candidate with the most votes from the youth age group (age < 30): " + youthCandidate);
        System.out.println("Candidate with the most votes from the elder age group (age >= 60): " + elderCandidate);
        System.out.println();
    }

    private int getTopCandidate(int[] votes, int startIndex, int endIndex) 
    {
        int topCandidate = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) 
        {
            if (votes[i] > votes[topCandidate]) {
                topCandidate = i;
            }
        }
        return topCandidate;
    }

    private boolean isValidVote(int age, int candidate) 
    {
        if (age < 18 || age >= 90) 
        {
            return false;
        }
        if (candidate < 0 || candidate >= NUM_CANDIDATES) 
        {
            return false;
        }
        return true;
    }

    private int getAgeGroup(int age) 
    {
        if (age < 30) {
            return 0;
        } else if (age < 45) {
            return 1;
        } else if (age < 60) {
            return 2;
        } else {
            return 3;
        }
    }

    public void printToFile(String filename) 
    {
        final String[] ageGroups = {"18-29", "30-44", "45-59", "60-99"};


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) 
        {
            writer.write("Histogram of total votes per candidate:\n");
            for (int i = 0; i < NUM_CANDIDATES; i++) 
            {
                writer.write("Candidate " + i + "\t| ");
                for (int j = 0; j < candidateVotes[i]; j++) 
                {
                    writer.write("*");
                }
                writer.write("\n");
            }
            writer.write("\n");

            writer.write("Histogram of male votes per candidate:\n");
            for (int i = 0; i < NUM_CANDIDATES; i++) 
            {
                writer.write("Candidate " + i + "\t| ");
                for (int j = 0; j < maleVotes[i]; j++) 
                {
                    writer.write("*");
                }
                writer.write("\n");
            }
            writer.write("\n");

            writer.write("Histogram of female votes per candidate:\n");
            for (int i = 0; i < NUM_CANDIDATES; i++) 
            {
                writer.write("Candidate " + i + "\t| ");
                for (int j = 0; j < femaleVotes[i]; j++) 
                {
                    writer.write("*");
                }
                writer.write("\n");
            }
            writer.write("\n");

            writer.write("*** Total number of valid votes: " + validVotes.size() + " ***\n");
            writer.write("\n");

            writer.write("--- Candidate statistics: ---\n");
            for (int i = 0; i < NUM_CANDIDATES; i++) 
            {
                writer.write("\n");
                writer.write("- Candidate " + i +" -\n");
                writer.write("Total votes: " + "\t" + candidateVotes[i] + "\n");
                writer.write("Male votes: " + "\t" + maleVotes[i] + "\n");
                writer.write("Female votes: " + "\t" + femaleVotes[i] + "\n");
                writer.write("\n");
            }

            writer.write("--- Age group statistics: ---\n");
            for (int i = 0; i < NUM_AGE_GROUPS; i++) 
            {
                writer.write("\n");
                writer.write("Age group " + i + " (" + ageGroups[i] +")"+ ":\n");
                writer.write("______________\n");
                writer.write("Total votes: " + ageGroupCounts[i] + "\n");
                for (int k = 0; k < NUM_CANDIDATES; k++) 
                {
                    writer.write("Candidate " + k + ": " + ageGroupVotes[i * NUM_CANDIDATES + k] + "\n");
                }
                writer.write("\n");
            }

        } catch (IOException e) 
        {
            System.err.println("Failed to write file: " + e.getMessage());
            System.exit(1);
        }
    }
}


