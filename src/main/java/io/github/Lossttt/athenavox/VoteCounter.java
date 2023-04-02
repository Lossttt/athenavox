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

import javafx.scene.control.Tab;

public class VoteCounter 
{
    static final int NUM_CANDIDATES = 8;     // Constant that defines the number of candidates in the election.
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

    // Constructor
    public VoteCounter(String filename) throws Exception 
    {            
        validVotes = new ArrayList<>();              // Initialize list of valid votes.
        candidateVotes = new int[NUM_CANDIDATES];    // Initialize array of vote counts for each candidate.   
        maleVotes = new int[NUM_CANDIDATES];         // Initialize array of vote counts for each male voter.
        femaleVotes = new int[NUM_CANDIDATES];       // Initialize array of vote counts for each frmale voter.
        ageGroupVotes = new int[NUM_AGE_GROUPS * NUM_CANDIDATES];
        ageGroupCounts = new int[NUM_AGE_GROUPS];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
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
    }

    private void calculateStatistics() 
    {
        for (int vote : validVotes) 
        {
            int age = (vote & AGE_MASK) >> 9;
            int gender = (vote & GENDER_MASK) >> 7;
            int candidate = vote & CANDIDATE_MASK;

            candidateVotes[candidate]++;
            if (gender == 0) 
            {
                maleVotes[candidate]++;
            } else {
                femaleVotes[candidate]++;
            }

            int ageGroup = getAgeGroup(age);
            ageGroupVotes[ageGroup * NUM_CANDIDATES + candidate]++;
            ageGroupCounts[ageGroup]++;
        }
    }


    private int getTopCandidate(int[] votes, int startIndex, int endIndex) 
    {
        int topCandidate = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) 
        {
            if (votes[i] > votes[topCandidate]) 
            {
                topCandidate = i;
            }
        }
        return topCandidate;
    }

    public boolean isValidVote(int age, int candidate)
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

    public int getAgeGroup(int age)
    {
        if (age < 30) {
            return 0;
        } else if (age < 45) 
        
        {
            return 1;

        } else if (age < 60) 
        
        {
            return 2;

        } else 
        
        {
            return 3;
        }
    }

    public int[] getCandidateVotes() {
        return candidateVotes;
    }

    public int[] getMaleVotes() {
        return maleVotes;
    }

    public int[] getFemaleVotes() {
        return femaleVotes;
    }

    public static int getNumCandidates() {
        return NUM_CANDIDATES;
    }

    public static int getAgeMask() {
        return AGE_MASK;
    }

    public static int getGenderMask() {
        return GENDER_MASK;
    }

    public static int getCandidateMask() {
        return CANDIDATE_MASK;
    }

    public static int getNumAgeGroups() {
        return NUM_AGE_GROUPS;
    }

    public List<Integer> getValidVotes() {
        return validVotes;
    }

    public int[] getAgeGroupVotes() {
        return ageGroupVotes;
    }

    public int[] getAgeGroupCounts() {
        return ageGroupCounts;
    }

    public void printResults() 
    {

        int youthCandidate = getTopCandidate(candidateVotes, 0, 3);
        int elderCandidate = getTopCandidate(candidateVotes, 4, 7);
        System.out.println("*** Candidate with the most votes from the ***");
        System.out.println(" -Youth age group (age < 30): " + youthCandidate);
        System.out.println(" -Elder age group (age >= 60): " + elderCandidate);

        System.out.println("\n*** Total number of valid votes:  *** \n -" + validVotes.size());

    }

    public void printAgeGroupResults() 
    {
        final String[] ageGroups = { "18-29", "30-44", "45-59", "60-99" };

        System.out.println("*** Age group statistics: ***\n");

        for (int i = 0; i < NUM_AGE_GROUPS; i++) 
        {
            System.out.println("Age group " + i + " (" + ageGroups[i] + ")" + ":\n");
            for (int j = 0; j < NUM_CANDIDATES; j++) 
            {
                System.out.println("Candidate " + j + ": " + ageGroupVotes[i * NUM_CANDIDATES + j]);
            }

            System.out.println(
            "______________\n" + 
            "Total Votes: " + ageGroupCounts[i] + "\n");
        }
    }
}



