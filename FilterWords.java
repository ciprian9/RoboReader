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
import java.util.Scanner;

public class FilterWords {
	//attributes
	private ArrayList<String> punctuation;
	//constructor
	public FilterWords(ArrayList<String> punctuation)
	{
		this.punctuation = punctuation;
	}
	
	/*This method will read the words from the user
	 * and add them to the punctuation array that is used to remove isolated 
	 * punctuation marks
	 */
	public ArrayList<String> readWords()
	{
		String temp = "";
		//Suppressing the error for resources as closing the scanner causes further
		//problems
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		//Loop around until the user has finished entering words
		while(true)
		{
			System.out.print("Enter words to be excluded\nEnter 0  to stop : ");
			temp=input.next();
			
			//check for the exit requirement
			if(temp.equals("0"))
			{
				break;
			}
			else
			{
				//add the word to the ArrayList
				punctuation.add(temp);
			}
		}
		
		//input.close();
		return punctuation;
		
	}
}
