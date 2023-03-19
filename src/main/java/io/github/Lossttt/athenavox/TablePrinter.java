package io.github.Lossttt.athenavox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class TablePrinter extends HistogramPrinter 
{

    public TablePrinter(String table_name, int row_count, String[] row_names) 
    {
        super(table_name, row_count, row_names);
    }

    @Override
    public void print(boolean print_to_console) throws Exception {
        BufferedWriter writer;

        if (print_to_console) writer = new BufferedWriter(new OutputStreamWriter(System.out));
        else writer = new BufferedWriter(new FileWriter("vote_results.txt"));

        writer.write("Table Name: " + histogram_name);
        writer.newLine();
        writer.write("--------------------------------");
        writer.newLine();

        // Print table headers
        writer.write("Candidate\t      Votes");
        writer.newLine();
        writer.write("--------------------------------");
        writer.newLine();

        // Print table data
        for (int i = 0; i < row_count; i++) {
            writer.write(row_names[i] + "\t\t" + row_data[i]);
            writer.newLine();
        }

        writer.newLine();
        writer.flush();
    }
}
