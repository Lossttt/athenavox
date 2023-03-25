package io.github.Lossttt.athenavox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TablePrinterTest {
    private TablePrinter tablePrinter;

    @BeforeEach
    public void setUp() {
        String[] candidates = {"Alice", "Bob", "Charlie"};
        tablePrinter = new TablePrinter("Election Results", 3, candidates);
    }

    @Test
    public void testAddData() {
        // Add some data
        tablePrinter.add_data(0, 100);
        tablePrinter.add_data(1, 200);
        tablePrinter.add_data(2, 50);

        // Check that the data was added correctly
        Assertions.assertEquals(100, tablePrinter.row_data[0]);
        Assertions.assertEquals(200, tablePrinter.row_data[1]);
        Assertions.assertEquals(50, tablePrinter.row_data[2]);

        // Try adding data to an invalid row index
        tablePrinter.add_data(3, 50);

        // Check that the invalid data was not added
        Assertions.assertEquals(100, tablePrinter.row_data[0]);
        Assertions.assertEquals(200, tablePrinter.row_data[1]);
        Assertions.assertEquals(50, tablePrinter.row_data[2]);
    }
}
// The testAddData() test case tests the add_data() method of the TablePrinter class
// It adds some data to the valid rows of the table and then checks that the data was added correctly.
// It then tries to add data to invalid row index and checks that the invalid data was not added :)