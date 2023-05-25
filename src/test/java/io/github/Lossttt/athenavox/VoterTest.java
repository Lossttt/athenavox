package io.github.Lossttt.athenavox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoterTest {

    // MODIFIED CONDITION/DECISION COVERAGE (JUNIT)

    @Test
    public void testEligibleToVote_AFalseBFalseCFalse() {
        Voter v = new Voter();
        assertFalse(v.eligibleToVote(17, false, false));
    }
    @Test
    public void testEligibleToVote_AFalseBFalseCTrue() {
        Voter v = new Voter();
        assertFalse(v.eligibleToVote(17, false, true));
    }
    @Test
    public void testEligibleToVote_AFalseBTrueCFalse() {
        Voter v = new Voter();
        assertFalse(v.eligibleToVote(17, true, false));
    }
    @Test
    public void testEligibleToVote_AFalseBTrueCTrue() {
        Voter v = new Voter();
        assertFalse(v.eligibleToVote(17, true, true));
    }
    @Test
    public void testEligibleToVote_ATrueBFalseCFalse() {
        Voter v = new Voter();
        assertFalse(v.eligibleToVote(18, false, false));
    }
    @Test
    public void testEligibleToVote_ATrueBFalseCTrue() {
        Voter v = new Voter();
        assertTrue(v.eligibleToVote(18, false, true));
    }
    @Test
    public void testEligibleToVote_ATrueBTrueCFalse() {
        Voter v = new Voter();
        assertTrue(v.eligibleToVote(18, true, false));
    }
    @Test
    public void testEligibleToVote_ATrueBTrueCTrue() {
        Voter v = new Voter();
        assertTrue(v.eligibleToVote(18, true, true));
    }    



    // EQUIVALENTIEKLASEN EN RANDWAARDEN (JUNIT)

    @Test
    public void testGetAgeGroup_Adult() {
        Voter v = new Voter("Alfa", "25", true, true);
        assertEquals("Adult", v.getAgeGroup(25));
    }
    @Test
    public void testGetAgeGroup_Adult2() {
        Voter v = new Voter("Alfa", "40", true, true);
        assertEquals("Adult", v.getAgeGroup(40));
    }
    @Test
    public void testGetAgeGroup_MiddleAged() {
        Voter v = new Voter("Alfa", "25", true, true);
        assertEquals("Middle-aged", v.getAgeGroup(41));
    }
    @Test
    public void testGetAgeGroup_MiddleAged2() {
        Voter v = new Voter("Alfa", "25", true, true);
        assertEquals("Middle-aged", v.getAgeGroup(65));
    }
    @Test
    public void testGetAgeGroup_Elderly() {
        Voter v = new Voter("Alfa", "25", true, true);
        assertEquals("Elderly", v.getAgeGroup(66));
    }


    
    // PAIRWISE TESTING (JUNIT)

    @Test
    public void geslaagdVerkiezingen_TC1() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(0, 0, 0, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC2() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(0, 0, 0, true);
        assertTrue(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC3() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(1, 0, 3, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC4() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(1, 0, 3, true);
        assertTrue(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC5() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(1, 3, 0, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC6() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(1, 3, 0, true);
        assertTrue(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC7() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(1, 3, 3, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC8() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(1, 3, 3, true);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC9() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(2, 0, 0, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC10() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(2, 0, 0, true);
        assertTrue(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC11() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(2, 0, 3, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC12() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(2, 0, 3, true);
        assertTrue(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC13() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(2, 0, 0, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC14() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(2, 0, 0, true);
        assertTrue(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC15() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(2, 0, 3, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC16() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(2, 0, 3, true);
        assertTrue(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC17() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(3, 0, 0, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC18() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(3, 0, 0, true);
        assertTrue(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC19() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(3, 0, 3, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC20() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(3, 0, 3, true);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC21() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(3, 3, 0, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC22() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(3, 3, 0, true);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC23() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(3, 3, 3, false);
        assertFalse(result);
    }


    @Test
    public void geslaagdVerkiezingen_TC24() {
        Voter v = new Voter();
        boolean result = v.geslaagdVerkiezingen(3, 3, 3, true);
        assertFalse(result);
    }

 }
 
