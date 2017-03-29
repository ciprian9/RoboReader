/*************************************************************************
 * 
 * 
 *  This class will separate, count and create a list of the 10 most
 *  common words in the file
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/

//Imports
import java.util.HashMap;
import java.util.ArrayList;

public class AvgWords 
{
	//attributes
	private ArrayList<String> words; //contains all the words with no modifications
	private ArrayList<String> no_Copies; //will record all the words without isolated punctuation or copies
	private RemoveStop wordstop; //Object to call Remove stop words
	
	/*
	 * The constructor receives the array with the words and creates an
	 *Array list that will contain only one copy of each words, this is done in the 
	 *following method
	 */
	public AvgWords(ArrayList<String> words)
	{
		this.words = words;
		this.no_Copies = new ArrayList<String>();
		this.wordstop= new RemoveStop();
	}
	
	/*
	 * HashMaps are used and returned in here to create a dictionary that will hold
	 *Key/value pairs of the words. These will then be used to create the list of mostly used words
	 */
	public HashMap<String, Integer> dictCreate()
	{
		//creating new HashMap dictionary
		HashMap<String, Integer> allWords = new HashMap<String, Integer>();
		HashMap<String, Integer> noStopWords = new HashMap<String, Integer>();
		
		//Loop around all the words in the file
        for (int i = 0; i < words.size(); i++)
        {
            //If the key is present then increase the value by one
            if(allWords.containsKey(words.get(i)))
            {
                allWords.put(words.get(i), allWords.get(words.get(i)) + 1);
            }
            //else add the key and set value to one also add the key to the array list no_Copies
            else
            {
                allWords.put(words.get(i),1);
                no_Copies.add(words.get(i));
            }
        }
        
        //Calling the removeStop class to remove stop words
        noStopWords = wordstop.removeStop(allWords);
        
       //Return the HashMap
       return noStopWords;
	}
	
	
	
	/*
	 * This method will sort the words in decreasing oder and
	 * create an arrayList top_10Words that will hold the ordered strings
	 * */
	public ArrayList<String> topWords()
	{
		
		//Initialize the HashMap in this method
		HashMap<String, Integer> noStopWords = dictCreate();
		
		//This ArrayList will hold the words in decreasing order based on noStopWords keys
		ArrayList<String> top_10Words = new ArrayList<String>();
		
		String key =""; //String to hold the key of the noStopWords
		int value = 0; //int to hold the value associated with the key
		
		/*The following nested loop is used to pick the highest value for each
		 * element in the dictionary
		 */
		for(int j = 0; j<no_Copies.size(); j++) //compare each item of no_Copies with every other element using sequential search
		{
			for (int i=0; i<no_Copies.size(); i++)
			{
				//the highest value is selected and the key and value are saved
				if(value < noStopWords.get(no_Copies.get(i)))
				{
					key = no_Copies.get(i);
					value = noStopWords.get(no_Copies.get(i));
				}
			}
			
			//adding the key and value to the ArrayList for storing
			top_10Words.add(key + " : " + value + " repeats");
			
			//The value of the highest key is reseted
			value = 0; 
			//then added to the HashMap
			noStopWords.put(key, value); 		
		}
		
		//The ArrayList is then returned
		return top_10Words;
	}
}

