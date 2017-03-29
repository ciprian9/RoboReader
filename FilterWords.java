/*************************************************************************
 * 
 * 
 *  This class will allow the user to enter words that will be removed from the file
 *  when the top ten list is created
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/

import java.util.ArrayList;

public class FilterWords {
	//attributes
	private ArrayList<String> punctuation; //list of punctuation that will removes isolated punctuation
	private ArrayList<String> words; //list of all words to exclude
	
	//constructor
	public FilterWords(ArrayList<String> punctuation, ArrayList<String> words) //both are passed by another class
	{
		this.punctuation = punctuation;
		this.words = words;
	}
	
	/*This adds the words from the filter to the punctuation marks that are isolated
	 * in order to remove both on the next run
	 */
	public ArrayList<String> readWords()
	{
		
		for(String temp: words){ //for each word in the ArrayList words
			punctuation.add(temp); //add the words to the punctuation ArrayList
		}
		
		return punctuation;
		
	}
}
