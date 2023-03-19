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


        public void printHistogram() throws Exception {
        String[] row_names = new String[] { "Candidate 0", "Candidate 1", "Candidate 2", "Candidate 3", 
                "Candidate 4", "Candidate 5", "Candidate 6", "Candidate 7" };

        HistogramPrinter h_candidates = new HistogramPrinter("Histogram of total votes per candidate:", NUM_CANDIDATES, row_names);
        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            h_candidates.add_data(i, candidateVotes[i]);
        }

        h_candidates.print(true);

        HistogramPrinter h_male = new HistogramPrinter("Histogram of male votes per candidate:", NUM_CANDIDATES, row_names);

        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            h_male.add_data(i, maleVotes[i]);
        }

        h_male.print(true);

        HistogramPrinter h_female = new HistogramPrinter("Histogram of female votes per candidate:", NUM_CANDIDATES, row_names);

        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            h_female.add_data(i, femaleVotes[i]);
        }

        h_female.print(true);
    }

    public void printTables() throws Exception {
        String[] row_names = new String[] { "Candidate 0", "Candidate 1", "Candidate 2", "Candidate 3", 
                "Candidate 4", "Candidate 5", "Candidate 6", "Candidate 7" };

        TablePrinter t_candidates = new TablePrinter("Histogram of total votes per candidate:", NUM_CANDIDATES, row_names);
        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            t_candidates.add_data(i, candidateVotes[i]);
        }

        t_candidates.print(true);

        TablePrinter t_male = new TablePrinter("Histogram of male votes per candidate:", NUM_CANDIDATES, row_names);

        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            t_male.add_data(i, maleVotes[i]);
        }

        t_male.print(true);

        TablePrinter t_female = new TablePrinter("Histogram of female votes per candidate:", NUM_CANDIDATES, row_names);

        for (int i = 0; i < NUM_CANDIDATES; i++) 
        {
            t_female.add_data(i, femaleVotes[i]);
        }

        t_female.print(true);
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

    public void printResults() 
    {
        System.out.println("*** Total number of valid votes: " + validVotes.size() + " *** \n");

        int youthCandidate = getTopCandidate(candidateVotes, 0, 3);
        int elderCandidate = getTopCandidate(candidateVotes, 4, 7);
        System.out.println();
        System.out.println("Candidate with the most votes from the youth age group (age < 30): " + youthCandidate);
        System.out.println("Candidate with the most votes from the elder age group (age >= 60): " + elderCandidate);
        System.out.println();

        printAgeGroupResults();
    }

    public void printAgeGroupResults() 
    {
        final String[] ageGroups = { "18-29", "30-44", "45-59", "60-99" };

        System.out.println("--- Age group statistics: ---");

        for (int i = 0; i < NUM_AGE_GROUPS; i++) 
        {
            System.out.println("\n");
            System.out.println("Age group " + i + " (" + ageGroups[i] + ")" + ":\n");
            for (int j = 0; j < NUM_CANDIDATES; j++) 
            {
                System.out.println("Candidate " + j + ": " + ageGroupVotes[i * NUM_CANDIDATES + j]);
            }

            System.out.println(
            "______________\n" + 
            "Total Votes: " + ageGroupCounts[i]);
        }
    }
    public boolean getHistogramData() {
        return false;
    }
}



