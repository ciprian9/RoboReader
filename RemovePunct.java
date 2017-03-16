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
	private ArrayList<String> punctuation;
	private ArrayList<String> words;
	
	//Constructor
	public RemovePunct(ArrayList<String> punctuation, ArrayList<String> words)
	{
		this.punctuation = punctuation;
		this.words = words;
	}
	
	
	//The RV(Remove) Punctuation method creates the new array similarly as the previous
	//did
	public ArrayList<String> RvPunct()
	{
		
		//calling the CountNew method to calculate the needed size for the array
		
		
		//Creating the new array with the required size
		ArrayList<String> newvalue = new ArrayList<String>();
		
		int count = 0;
		
		//Similarly to the first method the two loops check the two arrays
		for(int i=0; i< words.size(); i++)
		{
			for(int j=0; j<punctuation.size(); j++)
			{
				//The first if just as the one in the other method uses a counter 
				//to verify that the current word is not a punctuation mark
				if(words.get(i).equals(punctuation.get(j)))
				{
					count--;
				}
				count++;
				
				//The second if statement copies all the words to a new array
				//ignoring the punctuation marks
				if(count == punctuation.size())
				{
				
					newvalue.add(words.get(i));
					count = 0;
				}
			}
			//reseting count for the next element of the array
			count=0;
		}
		//returning the new array
		return newvalue;
	}
	
	//This method finishes off the punctuation removal thorugh the use of regex
	public ArrayList<String> fullRv()
	{
		//Array of Strings that holds the words without separate punctuation
		ArrayList<String> noPunct = RvPunct();
		//New array to hold all the words with no punctuation left
		ArrayList<String> finished = new ArrayList<String>();
		
		//This loop goes around all the words and uses regex in order to substitute all 
		//punctuation marks with an empty space
		for(int j=0; j<noPunct.size(); j++)
		{
			//the word cleaned of non-use characters is then placed in the new array
			finished.add(noPunct.get(j).replaceAll("[,.!?:;()[]]'\"\\/ ]", ""));
		}
		//Finally the array is returned to control
		return finished;
	}
	
	public ArrayList<String> EndArray()
	{
		//Creating the arrayList for the finished words
		ArrayList<String> finished = fullRv();
		ArrayList<String> endArray = new ArrayList<String>();
		
		//Loop around turn them to lower case
		for(int i = 0; i<finished.size(); i++)
		{
			endArray.add(finished.get(i).toLowerCase());
		}
		
		//call Average words
		AvgWords t2 = new AvgWords(endArray);
		
		//receive the result of topWords
		ArrayList<String> topten = t2.topWords();
		//Return the array List
		return topten;
	}
	
}
