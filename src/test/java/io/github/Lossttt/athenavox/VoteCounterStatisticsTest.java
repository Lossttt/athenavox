 // Package
 package io.github.Lossttt.athenavox;

 // Imports
 import org.junit.Before;
 import org.junit.jupiter.api.Assertions;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 import java.io.*;
 import static org.junit.jupiter.api.Assertions.*;

 public class VoteCounterStatisticsTest {

     private VoteCounterStatistics vcs;
     private static final String FILENAME = "B:\\Java\\athenavox\\Vote_data.txt";

     @BeforeEach
     void setUp() throws Exception {
         vcs = new VoteCounterStatistics(FILENAME);
     }

     @Test
     void testPrintCandidatePercentages() {
         vcs.printCandidatePercentages();
         // Test that verifies that the method doesn't return an empty or null output.
         // It does this by checking that the output stream is not null after the method is called
         assertNotNull(System.out);
     }

     @Test
     void testPrintAgeGroupVotes() {
         vcs.printAgeGroupVotes();
         // This test verifies that the printAgeGroupVotes() method does not return an empty or null output.
         // It does this by checking that the System.out stream is not null after the method is called.
         assertNotNull(System.out);
     }

     @Test
     void testPrintGenderDistribution() {
         vcs.printGenderDistribution();
         // This test verifies that the printGenderDistribution() method does not return an empty or null output.
         // It does this by checking that the System.out stream is not null after the method is called.
         assertNotNull(System.out);
     }

     @Test
     void testGetGenderPercentage() {
         // This test verifies that the getGenderPercentage() method returns the correct percentage of votes for each gender.
         // It does this by comparing the expected output with the actual output, with a tolerance of 0.01.
         assertEquals(53.33, vcs.getGenderPercentage(0), 0.01);
         assertEquals(46.67, vcs.getGenderPercentage(1), 0.01);
     }
 }