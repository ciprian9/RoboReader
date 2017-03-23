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


import java.util.HashMap;
import java.util.ArrayList;

public class AvgWords 
{
	//attributes
	private ArrayList<String> words;
	private ArrayList<String> obj;
	private RemoveStop wordstop;
	
	/*
	 * The constructor receives the array with the words and creates an
	 *Array list that will contain only one copy of each words, this is done in the 
	 *following method
	 */
	public AvgWords(ArrayList<String> words)
	{
		this.words = words;
		this.obj = new ArrayList<String>();
		this.wordstop= new RemoveStop();
	}
	
	/*
	 * HashMaps are used and returned in here to create a dictionary that will hold
	 *Key/value pairs of the words. These will then be used to create the list
	 *Some of the code was inspired from ideas on stackoverflow as i needed to learn
	 *how to use hashmaps
	 */
	public HashMap<String, Integer> dictCreate()
	{
		//creating new hashmap dictionary
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		
		//Loop around all the words in the file
        for (int i = 0; i < words.size(); i++)
        {
            //If the key is present then increase the value by one
            if(map.containsKey(words.get(i)))
            {
                map.put(words.get(i), map.get(words.get(i)) + 1);
            }
            //else add the key and set value to one also add the key to the array list obj
            else
            {
                map.put(words.get(i),1);
                obj.add(words.get(i));
            }
        }
        
        //Calling the removeStop class to remove stop words
        map1 = wordstop.removeStop(map);
        
       //Return the hashmap
       return map1;
	}
	
	
	
	/*
	 * This method will sort the words by how many times they were used and create an 
	 * arrayList that will be used for displaying
	 * */
	public ArrayList<String> topWords()
	{
		
		//Initialize the hashmap in this method
		HashMap<String, Integer> map = dictCreate();
		
		//This array will hold the words in decreasing order based on dict keys
		ArrayList<String> high = new ArrayList<String>();
		
		//these two variables will allow the dictionary to be modified
		//so that the elements of the array can be arranged
		String key ="";
		int value = 0;
		
		/*The following nested loop is used to pick the highest value for each
		 * element in the dictionary
		 */
		for(int j = 0; j<obj.size(); j++)
		{
			for (int i=0; i<obj.size(); i++)
			{
				//the highest value is selected and the key is held
				if(value < map.get(obj.get(i)))
				{
					key = obj.get(i);
					value = map.get(obj.get(i));
				}
			}
			
			high.add(key + " : " + value + " repeats"); // Add the values to the array
			/*
			 * The value is subtracted from the dictionary
			 * this way the highest repeated element will not be the only one populating
			 * the array
			 */
			value = 0; // reseting the value
			map.put(key, value); 		
		}
		
		return high;
	}
}

