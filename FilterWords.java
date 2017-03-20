import java.util.ArrayList;
import java.util.Scanner;

public class FilterWords {
	private ArrayList<String> punctuation;
	private ArrayList<String> words;
	
	public FilterWords(ArrayList<String> punctuation, ArrayList<String> words)
	{
		this.punctuation = punctuation;
		this.words = words;
	}
	
	public ArrayList<String> readWords()
	{
		String temp = "";
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Enter words to be excluded\nEnter 0  to stop : ");
			temp=input.next();
			
			if(temp.equals("0"))
			{
				break;
			}
			else
			{
				punctuation.add(temp);
			}
		}
		
		System.out.print(punctuation.toString());
		
		input.close();
		return words;
		
	}
}
