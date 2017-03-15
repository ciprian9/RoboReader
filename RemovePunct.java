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

public class RemovePunct {
	//Attributes 
	private String[] punctuation;
	private String[] words;
	
	//Constructor
	public RemovePunct(String[] punctuation, String[] words){
		this.punctuation = punctuation;
		this.words = words;
	}
	
	//This method counts the number of words and decides the new size of the array
	//if a punctuation mark is considered a word by the program it is removed
	public int countNew(){
		int count=0, count1=0;
		
		//The nested loops go through the original array of words and
		//the array containing the punctuation marks from the file
		for(int i=0; i< words.length; i++){
			for(int j=0; j<punctuation.length; j++){
				
				//The if statement then verifies if the word has passed all the
				//punctuation marks in the array by keeping a counter
				if(words[i].equals(punctuation[j])){
					count--;
				}
				count++;
				
				//if the current word did not match any of the punctuation marks 
				//then the counter for the new array is incremented by one
				if(count == punctuation.length){
					count1++;
					count = 0;
				}
			}
			//the original counter is reset to zero to test for the next word
			count=0;
		}
		//testing functionality
		//System.out.println(count1);
	return count1;
	}
	
	//The RV(Remove) Punctuation method creates the new array similarly as the previous
	//did
	public String[] RvPunct(){
		
		//calling the CountNew method to calculate the needed size for the array
		int arraysize = countNew();
		
		//Creating the new array with the required size
		String[] newvalue = new String[arraysize];
		
		int count = 0, count1 = 0;
		
		//Similarly to the first method the two loops check the two arrays
		for(int i=0; i< words.length; i++){
			for(int j=0; j<punctuation.length; j++){
				//The first if just as the one in the other method uses a counter 
				//to verify that the current word is not a punctuation mark
				if(words[i].equals(punctuation[j])){
					count--;
				}
				count++;
				
				//The second if statement copies all the words to a new array
				//ignoring the punctuation marks
				if(count == punctuation.length){
				
					newvalue[count1] = words[i];
					count1++;
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
	public String[] fullRv(){
		//Array of Strings that holds the words without separate punctuation
		String[] noPunct = RvPunct();
		//New array to hold all the words with no punctuation left
		String[] finished = new String[noPunct.length];
		
		//This loop goes around all the words and uses regex in order to substitute all 
		//punctuation marks with an empty space
		for(int j=0; j<noPunct.length; j++){
			//the word cleaned of non-use characters is then placed in the new array
			finished[j] = noPunct[j].replaceAll("[,.!?:;()[]]'\"\\/ ]", "");
		}
		//Finally the array is returned to control
		return finished;
	}
	
}
