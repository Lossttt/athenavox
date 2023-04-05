package io.github.Lossttt.athenavox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoteCounterTest {

    private static final String FILENAME = "votes.txt";
    private VoteCounter voteCounter;

    @BeforeEach
    void setUp() throws Exception {
        voteCounter = new VoteCounter(FILENAME);
    }

    @Test
    void testIsValidVote() {
        assertTrue(voteCounter.isValidVote(25, 3));
        assertFalse(voteCounter.isValidVote(17, 2));
        assertFalse(voteCounter.isValidVote(90, 5));
        assertFalse(voteCounter.isValidVote(50, 8));
    }

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

    @Test
    void testGetCandidateVotes() {
        int[] expected = {91, 83, 71, 96, 64, 56, 52, 71};
        assertArrayEquals(expected, voteCounter.getCandidateVotes());
    }

    @Test
    void testGetMaleVotes() {
        int[] expected = {45, 46, 38, 50, 31, 25, 25, 34};
        assertArrayEquals(expected, voteCounter.getMaleVotes());
    }

    @Test
    void testGetFemaleVotes() {
        int[] expected = {46, 37, 33, 46, 33, 31, 27, 37};
        assertArrayEquals(expected, voteCounter.getFemaleVotes());
    }

    @Test
    void testGetAgeGroupVotes() {
        int[] expected = {23, 25, 19, 24, 19, 14, 13, 20, 20, 16, 15, 20, 16, 14, 13, 17,
                           12, 9, 10, 16, 13, 11, 10, 14, 10, 8, 9, 14, 11, 10, 8, 14};
        assertArrayEquals(expected, voteCounter.getAgeGroupVotes());
    }

    @Test
    void testGetAgeGroupCounts() {
        int[] expected = {101, 91, 77, 86};
        assertArrayEquals(expected, voteCounter.getAgeGroupCounts());
    }
}

