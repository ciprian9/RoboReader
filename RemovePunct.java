/*************************************************************************
 * 
 * 
 *  This class removes all punctuation from an array of words. the process is almost
 *  automatic since methods call themselves
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/
import java.util.ArrayList;
public class RemovePunct 
{
	//Attributes 
	private ArrayList<String> punctuation; //All isolated punctuation to be removed
	private ArrayList<String> words; //all words not modified
	
	//Constructor
	public RemovePunct(ArrayList<String> punctuation, ArrayList<String> words)
	{
		this.punctuation = punctuation;
		this.words = words;
	}
	
	
	//The RV(Remove) Punctuation method creates a new arrayList without punctuation or capital letters
	public ArrayList<String> RvPunct(ArrayList<String> all_wordsNoMod)
	{		
		ArrayList<String> words_NoIPunct = new ArrayList<String>(); //No isolated punctuation
		ArrayList<String> word_NoCaps = new ArrayList<String>(); //List of all the words without capital letters
		//Loop around turn them to lower case
		for(int i = 0; i<all_wordsNoMod.size(); i++)
		{
			word_NoCaps.add(all_wordsNoMod.get(i).toLowerCase()); //turn words to lower case
		}
		
		int count = 0;
		
		//Similarly to the first method the two loops check the two arrays
		for(int i=0; i< word_NoCaps.size(); i++)
		{
			for(int j=0; j<punctuation.size(); j++)
			{
				//The first 'if' uses a counter 
				//to verify that the current word is not a punctuation mark
				if(word_NoCaps.get(i).equals(punctuation.get(j)))
				{
					count--;
				}
				count++;
				
				//The second if statement copies all the words to a new array
				//ignoring the punctuation marks
				if(count == punctuation.size())
				{
				
					words_NoIPunct.add(word_NoCaps.get(i));
					count = 0;
				}
			}
			//reseting count for the next element of the array
			count=0;
		}
		//returning the new array
		return words_NoIPunct;
	}
	
	//This method finishes off the punctuation removal through the use of Regex
	public ArrayList<String> fullRv()
	{
		ArrayList<String> noPunct = RvPunct(words); //Array of Strings that holds the words without isolated punctuation
		ArrayList<String> no_PunctWords = new ArrayList<String>(); //New array to hold all the words with no punctuation left
		ArrayList<String> rem_PunctStop = new ArrayList<String>(); //Remove punctuation and stop words
		
		//This loop goes around all the words and uses regex in order to substitute all 
		//punctuation marks with an empty space
		for(int j=0; j<noPunct.size(); j++)
		{
			//the word cleaned of non-use characters is then placed in the new array
			no_PunctWords.add(noPunct.get(j).replaceAll("[,.!?:;()[]]'\"\\/ &]", ""));
		}
		
		//Similarly a regex is used to substitute the UniCode apostrophe to a binary one  
		for(int j=0; j<no_PunctWords.size(); j++)
		{
			//the new words are placed in the new ArrayList
			rem_PunctStop.add(no_PunctWords.get(j).replaceAll("[’]", "'"));
		}
		
		//The Arary is then passed back to the RvPunct to remove all the stop words added to punctuation by FilterWords class
		rem_PunctStop = RvPunct(rem_PunctStop);
		//return to EndArray method
		return rem_PunctStop;
	}
	
	public ArrayList<String> EndArray()
	{
		//Creating the arrayList for the finished words
		ArrayList<String> mod_Words = fullRv();
		
		
		//call Average words
		AvgWords t2 = new AvgWords(mod_Words);
		
		//receive the result of topWords
		ArrayList<String> organised_ListWords = t2.topWords();
		//Return the array List
		return organised_ListWords;
	}
	
}