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

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class FileManager {
	
	// attributes 

	private String fileName; //The file path
	private File file; // file object to connect to the real file
	private Scanner input; //scanner object to read the file
	private PrintWriter pwInput; //PrintWriter Object to write to a file

		
	// Constructor
	FileManager (String fileName)
	{
			
		this.fileName = fileName; //Filename is provided by calling class
			
	}
		
	// Method to get a connection to the file, before reading or writing 
	void connectToFile()
	{
		file = new File(fileName);
	}
	   	
	/*
	 * Method to read a  file word by word
	 * This is used for files such as punctuation
	 * stop words etc..
	 */
	ArrayList<String> readFile() 
	{
		ArrayList<String> words = new ArrayList<String>(); //It will store all unmodified words
		try
		{
		    	
			//get a scanner object
			input = new Scanner(file);
		    	
			//use the scanner to scroll through the words of the file
			while (input.hasNext())
			{      
				words.add(input.next()); //add the words to the ArrayList
			}
			
			return words;
				 
		}
		catch (FileNotFoundException e) //If an errors occurs display an error message
		{
			Project_Gui warning = new Project_Gui(); //Create a GUI object to access the panel
			JOptionPane.showMessageDialog(warning.getCenter(),"run time error " + e.getMessage(),
					"No File Selected",JOptionPane.ERROR_MESSAGE); //Display an error message
		}
		
		return words;

	}
	
	
	// Method to read a  file line by line
		ArrayList<String> readLines()
		{
			
			ArrayList<String> lines = new ArrayList<String>(); //ArrayList to store all the lines
			try //Try the following code unless an exception occurs 
			{  	
				//get a scanner object
				input = new Scanner(file);
			    	
				//use the scanner to scroll through the lines of the file
				while (input.hasNextLine())
				{      
					lines.add(input.nextLine());
				}
			}
			catch (FileNotFoundException e)
			{
				Project_Gui warning = new Project_Gui(); //Create a GUI object to access the panel
				JOptionPane.showMessageDialog(warning.getCenter(),"run time error " + e.getMessage(),
						"No File Selected",JOptionPane.ERROR_MESSAGE); //Display an error message	
			}
			return lines;
		}
	    

	// File writing: method to get hold of a Print writer object
	void getFileWriter()
	{
		try
		{
	    	pwInput = new PrintWriter(file);
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

