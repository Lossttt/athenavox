package io.github.Lossttt.athenavox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VoteCounterTest {

    private static final String FILENAME = "B:\\Java\\athenavox\\Vote_data.txt";
    private VoteCounter voteCounter;

    @BeforeEach
    void setUp() throws Exception {
        voteCounter = new VoteCounter(FILENAME);
    }

    // This test checks if the isValidVote method returns the expected results for different age and candidate numbers
    @Test
    void testIsValidVote() {
        assertTrue(voteCounter.isValidVote(25, 3));
        assertFalse(voteCounter.isValidVote(17, 2));
        assertFalse(voteCounter.isValidVote(90, 5));
        assertFalse(voteCounter.isValidVote(50, 8));
    }

    // This test checks if isValidVote returns false when the age is below the legal voting age (which is 18).
    // It uses the assertFalse method to check the result.
    @Test
    public void testIsValidVote_invalidAge() throws Exception {
        voteCounter = new VoteCounter(FILENAME);
        boolean result = voteCounter.isValidVote(17, 3);
        assertFalse(result);
    }

    //  This test checks if the getAgeGroup method returns the correct age group index (0 to 3) for different ages.
    //  It uses the assertEquals method to compare the expected and actual results.
    @Test
    void testGetAgeGroup() {
        assertEquals(0, voteCounter.getAgeGroup(18));
        assertEquals(0, voteCounter.getAgeGroup(29));
        assertEquals(1, voteCounter.getAgeGroup(30));
        assertEquals(1, voteCounter.getAgeGroup(44));
        assertEquals(2, voteCounter.getAgeGroup(45));
        assertEquals(2, voteCounter.getAgeGroup(59));
        assertEquals(3, voteCounter.getAgeGroup(60));
        assertEquals(3, voteCounter.getAgeGroup(89));
    }

    // This test checks if the getNumCandidates method returns the expected number of candidates .
    // It uses the assertEquals method to compare the expected and actual results.
    @Test
    public void testGetNumCandidates() {
        assertEquals(8, VoteCounter.getNumCandidates());
    }

    // This test checks if the getAgeMask method returns the expected mask for age (which is 0xFE00).
    // It uses the assertEquals method to compare the expected and actual results.
    @Test
    public void testGetAgeMask() {
        assertEquals(0xFE00, VoteCounter.getAgeMask());
    }

    // This test checks if the getGenderMask method returns the expected mask for gender
    // (which is 0x0100). It uses the assertEquals method to compare the expected and actual results.
    @Test
    public void testGetGenderMask() {
        assertEquals(0x0100, VoteCounter.getGenderMask());
    }

    // This test checks if the getCandidateMask method returns the expected mask for candidate numbers
    // (which is 0xFF ). It uses the assertEquals method to compare the expected and actual results.
    @Test
    public void testGetCandidateMask() {
        assertEquals(0xFF, VoteCounter.getCandidateMask());
    }

    // This test checks if the getNumAgeGroups method returns the expected number of age groups
    // (which is 4). It uses the assertEquals method to compare the expected and actual results.
    @Test
    public void testGetNumAgeGroups() {
        assertEquals(4, VoteCounter.getNumAgeGroups());
    }
}
