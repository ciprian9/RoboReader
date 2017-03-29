/*************************************************************************
 * 
 * 
 *  This class removes Stop words from the list to allow better and more accurate top words 
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveStop
{
	//Attributes
	FileManager e2;
	FindLan l;
	
	//Constructor gets the stop words file ready
	public RemoveStop()
	{
		//Access the list of stop words
		e2 = new FileManager(System.getProperty("user.dir") + "\\src\\stopwords.txt");

	}
	
	//Remove stop does exactly that it removes all the stop words from the count so
	//the top 10 will be more meaningful
	public HashMap<String, Integer> removeStop(HashMap<String, Integer> key_ValWords)
	{
		//basic file operations
    	e2.connectToFile();
    	ArrayList<String> stop = e2.readFile();
    	e2.closeReadFile();
		
    	//reseting the count for the stop words so they will be ignored
		for (int i = 0; i<stop.size(); i++)
		{
			if(key_ValWords.containsKey(stop.get(i)))
				key_ValWords.put(stop.get(i), 0);
		}
		//Return the updated dictionary
		return key_ValWords;
	}
}
