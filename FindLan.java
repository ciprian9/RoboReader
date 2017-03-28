/**************************************************************************************************************************************
 * 
 * This is a class that finds the language
 * @author Ciprian Anton
 * 2017
 *
 *
 **************************************************************************************************************************************/
import java.util.ArrayList;
// Making class
public class FindLan
{
	// Attributes
	private ArrayList<String> words;
	private ArrayList<String> english;
	private ArrayList<String> spanish;
	private ArrayList<String> french;
	private FileManager e2;
	private FileManager e3;
	private FileManager e4;

	// constructor
	FindLan(ArrayList<String> words)
	{
		this.words = words;
		e2 = new FileManager(System.getProperty("user.dir") + "\\src\\english.txt");
		e3 = new FileManager(System.getProperty("user.dir") + "\\src\\spanish.txt");
		e4 = new FileManager(System.getProperty("user.dir") + "\\src\\french.txt");
	}
	
	//This will verify for stop words in the file
	public int[] findLan()
	{                                                
		// Creating connection to the file and reading all the stop words
		
    	e2.connectToFile();
    	e3.connectToFile();
    	e4.connectToFile();
    	int[] counters = new int[3];
    	//counters to decide which language is it most likely
    	int count = 0, count2 = 0, count3 = 0;
    	
    	english = e2.readFile();
    	spanish = e3.readFile();
    	french = e4.readFile();
    	
    	e2.closeReadFile();
    	e3.closeReadFile();
    	e4.closeReadFile();
    	 
		
		//checking if any English stop words in words if yes then count is incremented
		for(int i=0;i<words.size();i++){
			for(int j=0;j<english.size();j++){
				if(words.get(i).equals(english.get(j))){
					count++;
					break;
				}
			}
		}	
		
		//checking if any Spanish stop words in words if yes then count2  is incremented
		for(int i=0;i<words.size();i++){
			for(int j=0;j<spanish.size();j++){
				if(words.get(i).equals(spanish.get(j))){
					count2++;
					break;
				}
			}
		}
		
		//checking if any French stop words in words if yes then count3  is incremented
		for(int i=0;i<words.size();i++){
			for(int j=0;j<french.size();j++){
				if(words.get(i).equals(french.get(j))){
					count3++;
					break;
				}
			}
		}	
		
		//Use an array to hold the counters
		counters[0] = count;
		counters[1] = count2;
		counters[2] = count3;
		
		return counters;
		
}
	
	//verify which language does the file hold
	public String cLang()
	{
		int[] counters = findLan();
		String lang = "";
		
		//determining if it is English
		if(counters[0] > counters[1] && counters[0] > counters[2]){
			lang="English";
			//System.out.println(lang);
		}
				
		//Spanish
		if(counters[1] > counters[0] && counters[1] > counters[2]){
			lang="Spanish";
			//System.out.println(lang);
		}
		//or French
		if(counters[2] > counters[0] && counters[2] > counters[1]){
			lang="French";
		}
		
		return lang;
		
		
	}
}

