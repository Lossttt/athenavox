// Package
package io.github.Lossttt.athenavox;

// Imports
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HistogramPrinterTest {

    private HistogramPrinter hp;


    @Test
    public void testGetMax() {
    // This test checks the getMax() method. It creates an array of integers,
        // passes it to the getMax() method, and asserts that the method returns the expected maximum value.
        hp = new HistogramPrinter();

        int[] arr = {1,3,5,2,4};
        int max = hp.getMax(arr);
        assertEquals(5, max);
    }

    @Test
    public void testPrintTotalVotesHistogram() {
    // This test checks the printTotalVotesHistogram method. It creates an array of integers and a title String
    // passes them to the method and simply verifies that the method executes successfully wihout any errors.
        int[] candidateVotes = {5, 2, 8, 3, 1};
        String title = "Total votes per candidate";
        hp = new HistogramPrinter();
        hp.printTotalVotesHistogram(candidateVotes, title);
        // Verify that the method executed successfully without errors
    }

    @Test
    public void testPrintMaleVotesHistogram() {
    // This test checks the printMaleVotesHistogram method. It creates an array of integers and a title String
    // passes them to the method and simply verifies that the method executes successfully wihout any errors.
        int[] maleVotes = {3, 7, 2, 6, 1};
        String title = "Male votes per candidate";
        hp = new HistogramPrinter();
        hp.printMaleVotesHistogram(maleVotes, title);
        // Verify that the method executed successfully without errors
    }

    @Test
    public void testPrintFemaleVotesHistogram() {
    // This test checks the PrintFemaleVotesHistogram method. It creates an array of integers and a title String
    // passes them to the method and simply verifies that the method executes successfully wihout any errors.
        int[] femaleVotes = {2, 6, 3, 5, 1};
        String title = "Female votes per candidate";
        hp = new HistogramPrinter();
        hp.printFemaleVotesHistogram(femaleVotes, title);
        // Verify that the method executed successfully without errors
    }
}