/****************************************************************************************************
 * This class will display a pop-up menu where the user can select which file
 * he wishes to open and will read the selected file
 *  Author: Ciprian Anton
 *  2017
 *********************************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileChooser 
{
	private ArrayList<String> all_Words; //ArrayList that will hold all the words without modifications
	private JFileChooser fileChooser; //FileChooser object used to access the files
	private File filePath; // Holds the file path in file format
	private String path; //used to convert the file path to a string for the use in the file manager
	private String fileName; // used to store the file name
	private File file; //Used to store the file connection
	
	/*
	 * The constructor creates the needed ArrayList, FileChooser and the two Strings that will be used
	 * to store the path and name of the file for later use
	 */
	public FileChooser()
	{
		this.all_Words = new ArrayList<String>();
		this.fileChooser = new JFileChooser("Z:\\Java\\College\\Robo-Reader\\src");
		this.setPath("");
		this.setName("");
	}
	
	/*
	 * The chooseFile method will prompt the user to select a file
	 * open it and perform the reading of the file
	 */
	public ArrayList<String> chooseFile() throws FileNotFoundException //FileNotFoundExeption is needed since it will attempt to open a file
	{ 
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) //Verify if the user has selected a file
		{ 
			
			file = fileChooser.getSelectedFile(); //Open the file selected in the file object
			filePath = file.getParentFile(); //Get the ParentFile path and add it to the filePath file object
			path = filePath.toString(); //Convert the path to a string
			setName(file.getName());// Set the filename to the selected file's name
			
			Scanner input = new Scanner(file); // Create scanner object to read the file	
				
			while (input.hasNext()) //while the file has a next word
			{      
				all_Words.add(input.next()); // add that word to the all_Words ArrayList
			}
				
			input.close(); //close the scanner
			return all_Words; // return all_Words ArrayList
			
		}
			
		else //if the user selects cancel instead of OK on the Pop-Up file selection
		{
			Project_Gui warning = new Project_Gui(); //Create a GUI object to access the panel
			JOptionPane.showMessageDialog(warning.getCenter(),"No File has been Opened.","No File Selected",JOptionPane.WARNING_MESSAGE); //Display an error message
		}
		
		//return all words which will be an empty ArrayList
		return all_Words;
	}

	//Setters and Getters for the Name
	public String getName() 
	{
		return fileName;
	}

	public void setName(String name) 
	{
		this.fileName = name;
	}
	
	//Setters and Getters for the Path
	public String getPath() 
	{
		return path;
	}

	public void setPath(String path) 
	{
		this.path = path;
	}
		
}

