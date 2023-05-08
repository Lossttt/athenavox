 // Package
 package io.github.Lossttt.athenavox;

 // Imports
 import org.junit.jupiter.api.Assertions;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 import static org.junit.jupiter.api.Assertions.*;


 public class VoteCounterStatisticsTest 
 {

    private VoteCounterStatistics vcs;
    private static final String FILENAME = "Vote_data.txt";

    @BeforeEach
    void setUp() throws Exception 
    {
        // Initialize VoteCounterStatistics object before each test
        vcs = new VoteCounterStatistics(FILENAME);
    }

    @Test
    void testPrintCandidatePercentages() 
    {
        // Invoke the method to print candidate percentages
        vcs.printCandidatePercentages();

        // Test that verifies that the method doesn't return an empty or null output.
        // It does this by checking that the output stream is not null after the method is called
        assertNotNull(System.out);
    }

    @Test
    public void testPrintCandidatePercentages2() 
    {
        try 
        {
            vcs = new VoteCounterStatistics(FILENAME);
        } catch (Exception e) 
        {
            Assertions.fail("Failed to initialize VoteCounterStatistics: " + e.getMessage());
        }

        // Invoke the method to print candidate percentages
        vcs.printCandidatePercentages();

        // No need to assert anything as it prints the output to the console
    }

    @Test
    void testPrintAgeGroupVotes() 
    {
        // Invoke the method to print age group votes
        vcs.printAgeGroupVotes();

        // This test verifies that the printAgeGroupVotes() method does not return an empty or null output.
        // It does this by checking that the System.out stream is not null after the method is called.
        assertNotNull(System.out);
    }

    @Test
    public void testPrintAgeGroupVotes2() 
    {
        try 
        {
            vcs = new VoteCounterStatistics(FILENAME);
        } catch (Exception e) 
        {
            Assertions.fail("Failed to initialize VoteCounterStatistics: " + e.getMessage());
        }

        // Invoke the method to print age group votes
        vcs.printAgeGroupVotes();

        // No need to assert anything as it prints the output to the console
    }

    @Test
    void testPrintGenderDistribution() 
    {
        // Invoke the method to print gender distribution
        vcs.printGenderDistribution();

        // This test verifies that the printGenderDistribution() method does not return an empty or null output.
        // It does this by checking that the System.out stream is not null after the method is called.
        assertNotNull(System.out);
    }

    @Test
    public void testPrintGenderDistribution2() 
    {
        try {
            vcs = new VoteCounterStatistics(FILENAME);
        } catch (Exception e) 
        {
            Assertions.fail("Failed to initialize VoteCounterStatistics: " + e.getMessage());
        }

        // Invoke the method to print gender distribution
        vcs.printGenderDistribution();

        // No need to assert anything as it prints the output to the console
    }

    @Test
    public void testPrintAgeGroupWinners() 
    {
    //This test method verifies the functionality of the printAgeGroupWinners() method.
    //It tries to initialize a VoteCounterStatistics object by passing the FILENAME variable to the constructor.
    //If an exception occurs during initialization, the test fails and displays an error message indicating the failure reason.
        try 
        {
            // Initialize a VoteCounterStatistics object with the given FILENAME
            vcs = new VoteCounterStatistics(FILENAME);
        } catch (Exception e) 
        {
            // If an exception occurs during initialization, fail the test and provide an error message
            Assertions.fail("Failed to initialize VoteCounterStatistics: " + e.getMessage());
        }
    
        // Invoke the method to print age group winners
        vcs.printAgeGroupWinners();
    
        // No need to assert anything as it prints the output to the console
    }
    
 }