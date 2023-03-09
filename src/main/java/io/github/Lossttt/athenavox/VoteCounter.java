package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteCounter {
    private static final int NUM_CANDIDATES = 8;
    private static final int AGE_MASK = 0xFE00;
    private static final int GENDER_MASK = 0x0100;
    private static final int CANDIDATE_MASK = 0xFF;
    private static final int NUM_AGE_GROUPS = 4;

    private List<Integer> validVotes;
    private int[] candidateVotes;
    private int[] maleVotes;
    private int[] femaleVotes;
    private int[] ageGroupVotes;
    private int[] ageGroupCounts;

    public VoteCounter(String filename) {
        validVotes = new ArrayList<>();
        candidateVotes = new int[NUM_CANDIDATES];
        maleVotes = new int[NUM_CANDIDATES];
        femaleVotes = new int[NUM_CANDIDATES];
        ageGroupVotes = new int[NUM_AGE_GROUPS * NUM_CANDIDATES];
        ageGroupCounts = new int[NUM_AGE_GROUPS];

        try (BufferedReader reader = new BufferedReader(new FileReader("B:\\Java\\athenavox\\athenavox\\AthenaVox\\src\\main\\java\\Vote_data.text"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int vote = Integer.parseInt(line, 16);
                int age = (vote & AGE_MASK) >> 9;
                int gender = (vote & GENDER_MASK) >> 7;
                int candidate = vote & CANDIDATE_MASK;

                if (isValidVote(age, candidate)) {
                    validVotes.add(vote);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read file: " + e.getMessage());
            System.exit(1);
        }

        calculateStatistics();
    }

    public void printCandidateHistograms() {
        System.out.println("Histogram of total votes per candidate:");
        System.out.println("--- BEGIN of HISTOGRAM ---");
        for (int i = 0; i < NUM_CANDIDATES; i++) {
            System.out.print("Kandidaat " + i + "\t| ");
            for (int j = 0; j < candidateVotes[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("--- END of HISTOGRAM ---");
        System.out.println();

        System.out.println("Histogram of male votes per candidate:");
        System.out.println("--- BEGIN of HISTOGRAM ---");
        for (int i = 0; i < NUM_CANDIDATES; i++) {
            System.out.print("Kandidaat " + i + "\t| ");
            for (int j = 0; j < maleVotes[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("--- END of HISTOGRAM ---");
        System.out.println();

        System.out.println("Histogram of female votes per candidate:");
        System.out.println("--- BEGIN of HISTOGRAM ---");
        for (int i = 0; i < NUM_CANDIDATES; i++) {
            System.out.print("Kandidaat " + i + "\t| ");
            for (int j = 0; j < femaleVotes[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("--- END of HISTOGRAM ---");
        System.out.println();

    }

    private void calculateStatistics() {
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

    public void printResults() {
        System.out.println("*** Total number of valid votes: " + validVotes.size() + " ***");
        System.out.println("");
        System.out.println("--- Candidate statistics: ---");
        for (int i = 0; i < NUM_CANDIDATES; i++) {
            System.out.println();
            System.out.println("Candidate " + i + ": " + candidateVotes[i] + " votes");
            System.out.println("  Male votes: " + maleVotes[i]);
            System.out.println("  Female votes: " + femaleVotes[i]);
            for (int j = 0; j < NUM_AGE_GROUPS; j++) {
                int ageGroupVoteCount = ageGroupVotes[j * NUM_CANDIDATES + i];
                int ageGroupCount = ageGroupCounts[j];
                double ageGroupVotePercent = 100.0 * ageGroupVoteCount / ageGroupCount;
                System.out.printf("  Age group %d: %d votes (%.2f%%)\n", j, ageGroupVoteCount, ageGroupVotePercent);
            }
        }

        int youthCandidate = getTopCandidate(candidateVotes, 0, 3);
        int elderCandidate = getTopCandidate(candidateVotes, 4, 7);
        System.out.println();
        System.out.println("Candidate with the most votes from the youth age group (age < 30): " + youthCandidate);
        System.out.println("Candidate with the most votes from the elder age group (age >= 60): " + elderCandidate);
        System.out.println();
    }

    private int getTopCandidate(int[] votes, int startIndex, int endIndex) {
        int topCandidate = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (votes[i] > votes[topCandidate]) {
                topCandidate = i;
            }
        }
        return topCandidate;
    }

    private boolean isValidVote(int age, int candidate) {
        if (age < 18 || age >= 90) {
            return false;
        }
        if (candidate < 0 || candidate >= NUM_CANDIDATES) {
            return false;
        }
        return true;
    }

    private int getAgeGroup(int age) {
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
}
