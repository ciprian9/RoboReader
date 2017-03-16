import java.util.HashMap;

public class RemoveStop
{
	//Attributes
	FileManager e2;
	
	//Constructor gets the stop words file ready
	public RemoveStop()
	{
		e2 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\stopwords.txt");

	}
	
	//Remove stop does exactly that it removes all the stop words from the count so
	//the top 10 will be more meaningful
	public HashMap<String, Integer> removeStop(HashMap<String, Integer> map)
	{
		//basic file operations
    	e2.connectToFile();
    	String[] stop = e2.readFile();
    	e2.closeReadFile();
		
    	//reseting the count for the stop words so they will be ignored
		for (int i = 0; i<stop.length; i++)
		{
			if(map.containsKey(stop[i]))
				map.put(stop[i], 0);
		}
		//Return the updated dictionary
		return map;
	}
}
