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
	private ArrayList<String> punctuation;
	private ArrayList<String> words;
	
	//constructor
	public FilterWords(ArrayList<String> punctuation, ArrayList<String> words)
	{
		this.punctuation = punctuation;
		this.words = words;
	}
	
	/*This add the words from the filter to the punctuation marks that are isolated
	 * in order to remove both
	 */
	public ArrayList<String> readWords()
	{
		
		for(String temp: words){
			punctuation.add(temp);
		}
		
		return punctuation;
		
	}
}
