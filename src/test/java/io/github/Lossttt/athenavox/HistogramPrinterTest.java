package io.github.Lossttt.athenavox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistogramPrinterTest {

    private HistogramPrinter hp;


    @Test
    public void testGetMax() {
        hp = new HistogramPrinter();

        int[] arr = {1,3,5,2,4};
        int max = hp.getMax(arr);
        assertEquals(5, max);
    }
}