// // Package
// package io.github.Lossttt.athenavox;

// // Imports
// import org.junit.Before;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import java.io.*;
// import static org.junit.jupiter.api.Assertions.*;

// public class VoteCounterStatisticsTest {

//     private VoteCounterStatistics voteCounter;

//     @Before
//     public void setUp() throws Exception {
//         voteCounter = new VoteCounterStatistics("test_votes.txt");
//     }

//     // Test that printResults() does not throw an exception
//     @Test
//     public void testPrintResults() {
//         voteCounter.printResults();
//     }

//     // Test that printCandidatePercentages() does not throw an exception
//     @Test
//     public void testPrintCandidatePercentages() {
//         voteCounter.printCandidatePercentages();
//     }

//     // Test that printAgeGroupVotes() does not throw an exception
//     @Test
//     public void testPrintAgeGroupVotes() {
//         voteCounter.printAgeGroupVotes();
//     }

//     // Test that printGenderDistribution() does not throw an exception
//     @Test
//     public void testPrintGenderDistribution() {
//         voteCounter.printGenderDistribution();
//     }

//     @Test
//     public void testGetGenderPercentage() {
//         // Test with sample data
//         double malePercentage = voteCounter.getGenderPercentage(0);
//         double femalePercentage = voteCounter.getGenderPercentage(1);
//         assertEquals(60.0, malePercentage, 0.1);
//         assertEquals(40.0, femalePercentage, 0.1);
//     }

// }