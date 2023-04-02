// package io.github.Lossttt.athenavox;

// import org.junit.jupiter.api.Test;

// import java.io.*;

// import static org.junit.jupiter.api.Assertions.*;

// class HistogramPrinterTest {
//     @Test
//     public void testAddData() {
//         HistogramPrinter printer = new HistogramPrinter("Test", 3, new String[] {"A", "B", "C"});
//         printer.add_data(0, 2);
//         printer.add_data(1, 3);
//         printer.add_data(2, 4);

//         int[] expectedData = {2, 3, 4};
//         assertArrayEquals(expectedData, printer.row_data);
//     }

//     @Test
//     public void testAddDataWithValidInput() {
//         HistogramPrinter printer = new HistogramPrinter("Test Histogram", 3, new String[] {"A", "B", "C"});
//         printer.add_data(0, 10);
//         printer.add_data(1, 20);
//         printer.add_data(2, 30);
//         int[] expectedData = {10, 20, 30};
//         assertArrayEquals(expectedData, printer.row_data);
//     }

//     @Test
//     public void testAddDataWithInvalidIndex() {
//         HistogramPrinter histogram = new HistogramPrinter("Test Histogram", 3, new String[]{"A", "B", "C"});
//         histogram.add_data(3, 5); // This should throw an ArrayIndexOutOfBoundsException
//     }

//     @Test
//     public void testPrintToConsole() throws Exception {
//         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//         System.setOut(new PrintStream(outputStream));

//         HistogramPrinter printer = new HistogramPrinter("Test", 3   , new String[]{"A", "B", "C"});
//         printer.add_data(0, 2);
//         printer.add_data(1, 3);
//         printer.add_data(2, 4);

//         printer.print(true);

//         String expectedOutput = String.format("Test%n--------------------------------%nA | \t(2)\t**%nB | \t(3)\t***%nC | \t(4)\t****%n%n");
//         assertEquals(expectedOutput, outputStream.toString());
//     }
// }

// // Test 1: Test the add_data() method by adding some data to the rows and verifying that the data has been added correctly.
// // Test 2: Test add_data method by adding valid input.
// // Test 3: Test add_data method by adding invalid input.
// // Test 4: Test the print() method by printing the histogram to the console and verifying that the output matches the expected output.