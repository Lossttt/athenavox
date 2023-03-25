package io.github.Lossttt.athenavox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class VoteCounterTest {

    @Test
    void testPrintHistogram() throws Exception {
        String inputFile = "B:\\Java\\athenavox\\Vote_data.text";
        String outputFile = "B:\\Java\\athenavox\\vote_results.txt";
        HistogramPrinter printer = new HistogramPrinter(outputFile, 7, new String[0]);
        VoteCounter counter = new VoteCounter(inputFile);
        counter.printHistogram();
        // Check that the output file exists and contains the expected content
        // ...
    }

    @Test
    void testPrintResults() throws Exception {
        String inputFile = "B:\\Java\\athenavox\\Vote_data.text";
        VoteCounter counter = new VoteCounter(inputFile);
        counter.printResults();
        // Check that the console output contains the expected content
        // ...
    }

    @Test
    void testPrintTables() throws Exception {
        String inputFile = "B:\\Java\\athenavox\\Vote_data.text";
        VoteCounter counter = new VoteCounter(inputFile);
        counter.printTables();
        // Check that the console output contains the expected content
        // ...
    }
}

