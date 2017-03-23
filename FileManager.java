	/*************************************************************************
	 * 
	 * 
	 *  File manager class taken from webcourses and modified to suit the program
	 *  Author: Ciprian Anton
	 *  2017
	 *  
	 *  
	 ************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class FileManager {
	
	// attributes 

	private String fileName;
	private File choice;
	private Scanner input;
	private PrintWriter pwInput;

		
	// Constructor
	FileManager (String fileName)
	{
			
		this.fileName = fileName;
			
	}
		
	// Method to get a connection to the file, before reading or writing 
	void connectToFile()
	{
		choice = new File(fileName);
	}
	   	
	// Method to read a  file word by word
	ArrayList<String> readFile()
	{
		ArrayList<String> values = new ArrayList<String>();
		try
		{
		    	
			//get a scanner object
			input = new Scanner(choice);
		    	
			//use the scanner to scroll through the words of the file
			while (input.hasNext())
			{      
				values.add(input.next());
			}
			return values;
				 
		}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}

		return values;

	}
	
	
	// Method to read a  file, printing it line by line
		ArrayList<String> readLines()
		{
			
			ArrayList<String> values = new ArrayList<String>();
			try
			{
			    	
				//get a scanner object
				input = new Scanner(choice);
			    	
				//use the scanner to scroll through the lines of the file
				while (input.hasNextLine())
				{      
					values.add(input.nextLine());
					//System.out.println(input.nextLine());
				}
				//System.out.println(values.toString());
			}
			catch (FileNotFoundException e)
			{
				System.out.println("run time error " + e.getMessage());		
			}
			return values;
		}
	    

	// File writing: method to get hold of a Print writer object
	void getFileWriter()
	{
		try
		{
	    	pwInput = new PrintWriter(choice);
	    }
	    catch (FileNotFoundException e)
	    {
	    	System.out.println("run time error " + e.getMessage());
	    }
	    	
	}	
	 
	// File writing: method to write a string to the file
    void writeLineToFile(String line)
	{
    	System.out.println(line);
	  	pwInput.println(line);    	
	}	

	    
	// Method to close a file that was read
	void closeReadFile()
	{
		input.close();
	}

	// Method to close a file that was written to..
	void closeWriteFile()
	{
		pwInput.close();
	}  
}

