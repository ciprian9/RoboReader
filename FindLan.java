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
		e2 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\english.txt");
		e3 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\spanish.txt");
		e4 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\french.txt");
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
    	 
		
		//checking if any english stopwords in words if yes then count is incremeanted
		for(int i=0;i<words.size();i++){
			for(int j=0;j<english.size();j++){
				if(words.get(i).equals(english.get(j))){
					count++;
					break;
				}
			}
		}	
		
		//checking if any spanish stopwords in words if yes then count2  is incremeanted
		for(int i=0;i<words.size();i++){
			for(int j=0;j<spanish.size();j++){
				if(words.get(i).equals(spanish.get(j))){
					count2++;
					break;
				}
			}
		}
		
		//checking if any french stopwords in words if yes then count3  is incremeanted
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
		
		//determining if it is english
		if(counters[0] > counters[1] && counters[0] > counters[2]){
			lang="English";
			//System.out.println(lang);
		}
				
		//spanish
		if(counters[1] > counters[0] && counters[1] > counters[2]){
			lang="Spanish";
			//System.out.println(lang);
		}
		//or french
		if(counters[2] > counters[0] && counters[2] > counters[1]){
			lang="French";
			//System.out.println(lang);
		}
		
		System.out.println(lang);
		return lang;
		
		
	}

	public ArrayList<String> getEnglish() {
		return english;
	}

	public void setEnglish(ArrayList<String> english) {
		this.english = english;
	}

	public ArrayList<String> getSpanish() {
		return spanish;
	}

	public void setSpanish(ArrayList<String> spanish) {
		this.spanish = spanish;
	}

	public ArrayList<String> getFrench() {
		return french;
	}

	public void setFrench(ArrayList<String> french) {
		this.french = french;
	}
}

