/**************************************************************************************************************************************
 * 
 * This is a class that finds the language
 * Author: Ciprian Anton
 * 2017
 *
 *
 **************************************************************************************************************************************/
import java.util.ArrayList;

public class FindLan
{
	// Attributes
	private ArrayList<String> words; //list of all words
	private ArrayList<String> english; //list of English stop words
	private ArrayList<String> spanish; //list of Spanish stop words
	private ArrayList<String> french; //list of French stop words
	private FileManager e2;  //e1, e2 and e3 are all file manager objects used to access the three stop words files
	private FileManager e3;
	private FileManager e4;

	// constructor
	FindLan(ArrayList<String> words)
	{
		this.words = words;
		//Initialize all the file manager objects
		e2 = new FileManager("D:\\Programming\\workspace\\Robo2\\src\\english.txt");
		e3 = new FileManager("D:\\Programming\\workspace\\Robo2\\src\\spanish.txt");
		e4 = new FileManager("D:\\Programming\\workspace\\Robo2\\src\\french.txt");
	}
	
	//This will verify for stop words in the file
	public int[] findLan()
	{                                                
		// Creating connection to the files
    	e2.connectToFile();
    	e3.connectToFile();
    	e4.connectToFile();
    	
    	//int Array for the counters used for checking the stop words
    	int[] counters = new int[3];
    	
    	//counters to decide which language is it most likely
    	int count = 0, count2 = 0, count3 = 0;
    	
    	//read all the files
    	english = e2.readFile();
    	spanish = e3.readFile();
    	french = e4.readFile();
    	
    	//close all the connections
    	e2.closeReadFile();
    	e3.closeReadFile();
    	e4.closeReadFile();
    	 
		
		//checking if any English stop words in words if yes then count is incremented
		for(int i=0;i<words.size();i++){
			for(int j=0;j<english.size();j++){
				if(words.get(i).equals(english.get(j))){
					count++;
					break;
				}
			}
		}	
		
		//checking if any Spanish stop words in words if yes then count2  is incremented
		for(int i=0;i<words.size();i++){
			for(int j=0;j<spanish.size();j++){
				if(words.get(i).equals(spanish.get(j))){
					count2++;
					break;
				}
			}
		}
		
		//checking if any French stop words in words if yes then count3  is incremented
		for(int i=0;i<words.size();i++){
			for(int j=0;j<french.size();j++){
				if(words.get(i).equals(french.get(j))){
					count3++;
					break;
				}
			}
		}	
		
		//Use an array to hold the counters
		counters[0] = count;
		counters[1] = count2;
		counters[2] = count3;
		
		return counters;
		
}
	
	//verify which language does the file hold
	public String cLang()
	{
		//get the counters from findLan
		int[] counters = findLan();

		
		//determining if it is English
		if(counters[0] > counters[1] && counters[0] > counters[2])
			return "English";

				
		//Spanish
		else if(counters[1] > counters[0] && counters[1] > counters[2])
			return "Spanish";

		//or French (Since we don't check for extra languages and some languages do overlap when it comes to words
		//the default will be French in this case)
		else
			return "French";

	
	}
}

