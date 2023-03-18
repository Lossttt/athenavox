package io.github.Lossttt.athenavox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

public class HistogramPrinter {
    private static char HIST_CHAR = '*'; 
    private String histogram_name;
    private int row_count;
    private String[] row_names;
    private int[] row_data;
    
    public HistogramPrinter (String histogram_name, int row_count, String[] row_names) 
    {

        this.histogram_name = histogram_name;
        
        this.row_count = row_count;
        this.row_names = row_names;
        
        this.row_data = new int[row_count];
    }
    
    public void add_data(int row, int data) 
    {
        if (row >= row_count)
        {
            System.out.println("add_data: Index out of bounds!");
            return;
        }
        
        row_data[row] += data;
    }
    
    public void print(boolean print_to_console) throws Exception
    {
        BufferedWriter writer;
	    
	    if (print_to_console) writer = new BufferedWriter(new OutputStreamWriter(System.out));
	    else writer = new BufferedWriter(new FileWriter("vote_results.txt"));
	    
	    writer.write(histogram_name); writer.newLine();
	    writer.write("--------------------------------"); writer.newLine();
	    
	    for (int i = 0; i < row_count; i++)
	    {
	        writer.write(String.format("%s | " + "\t(%d)\t", row_names[i], row_data[i]));
	        
	        for (int j = 0; j < row_data[i]; j++) writer.write(HIST_CHAR);
	        
	        writer.newLine();
	    }
	    
	    writer.newLine();
	    writer.flush();
    }
}
