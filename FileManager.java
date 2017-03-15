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

public class FileManager 
{
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
	//Method to simulate dynamic memory allocation for the array
	int fileCount(){
		int arraySize = 0;
		try
		{
			input = new Scanner(choice);
			//Condition verifies to make sure the file ends after the last word and gets the size of the needed array
			while(input.hasNext() && (input.next()) != null){
				arraySize++;
			}
			return arraySize;

		}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}
		//System.out.print("no");
		return arraySize;

	}

   	
	// Method to read a  file, returning a string of lines
	String[] readFile()
	{
		int arraySize = fileCount();
		String[] values = new String[arraySize];
	    try
		{
	    	//Initialize your array
	    	int i = 0;
	    	
	    	//get a scanner object
	    	input = new Scanner(choice);
	    	
	    	//use the scanner to scroll through the lines of the file
			 while (input.hasNext())
	         {
			      
				 values[i] = input.next();
 		         i++;
			   }
		      return values;
			 
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