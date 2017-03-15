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

public class AvgWords {
	//attributes
	private String[] words;
	private ArrayList<String> obj;
	
	/*
	 * The constructor receives the array with the words and creates an
	 *Array list that will contain only one copy of each words, this is done in the 
	 *following method
	 */
	public AvgWords(String[] words){
		this.words = words;
		this.obj = new ArrayList<String>();;
	}
	
	
	/*
	 * HashMaps are used and returned in here to create a dictionary that will hold
	 *Key/value pairs of the words. These will then be used to create the list
	 *Some of the code was inspired from ideas on stackoverflow as i needed to learn
	 *how to use hashmaps
	 */
	HashMap<String, Integer> dictCreate(){
		//creating new hashmap dictionary
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//Loop around all the words in the file
        for (int i = 0; i < words.length; i++)
        {
            //If the key is present then increase the value by one
            if(map.containsKey(words[i]))
            {
                map.put(words[i], map.get(words[i]) + 1);
            }
            //else add the key and set value to one also add the key to the array list obj
            else
            {
                map.put(words[i],1);
                obj.add(words[i]);
            }
        }
        /*Testing
        -----------------------------------
       	-System.out.println(map.toString());
        -System.out.println(obj.toString());
        ------------------------------------*/
       //Return the hashmap
       return map;
	}
	
	/*This method will sort the words by how many times they were used and create an array
	that will be used for displaying*/
	public String[] topWords(){
		
		//Initialize the hashmap in this method
		HashMap<String, Integer> map = dictCreate();
		//This array will hold the words in decreasing order based on dict keys
		String[] high = new String[obj.size()];
		//these two variables will allow the dictionary to be modified
		//so that the elements of the array can be arranged
		String key ="";
		int value = 0;
		
		/*The following nested loop is used to pick the highest value for each
		 * element in the dictionary
		 */
		for(int j = 0; j<obj.size(); j++){
			for (int i=0; i<obj.size(); i++){
				//the highest value is selected and the key is held
				if(value < map.get(obj.get(i))){
					key = obj.get(i);
					value = map.get(obj.get(i));
					/*
					 * Testing
					 * ------------------------------------------
					 * System.out.println(high[0] + "---" + num);
					 * ------------------------------------------
					 */
				}
			}
			
			high[j] = key + " = " + value; // Add the values to the array
			/*
			 * The value is subtracted from the dictionary
			 * this way the highest repeated element will not be the only one populating
			 * the array
			 */
			map.put(key, value - value); 
			/*
			 * Testing
			 * ------------------------------------
			 * System.out.println(map.toString());
			 * ------------------------------------
			 */
			
			value = 0; // reseting the value
		}
		
		/*
		 * Testing
		 * ------------------------------
		 * for(int i = 0; i<10; i++){
		
			*System.out.println(high[i]);
		 *}
		 *---------------------------------
		 */
		return high;
	}
}

