/*************************************************************************
 * 
 * 
 *  This is the control class that holds the main method
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/

public class ProjectControl {

	 @SuppressWarnings("unused")
	public static void main(String[] args) {
		 //creating objects of th file manager to open the required files
	    	FileManager e = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\Example1.txt");
	    	FileManager e1 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\punctuation.txt");
	    	//creating connection to the files
	    	e.connectToFile();
	    	e1.connectToFile();
	    	//Reading the files
	    	String[] ana = e.readFile();
	    	String[] ana1 = e1.readFile();
	    	
	    	/*
	    	 *testing
	    	 *-----------------------------------
	    	 * for(int i = 0; i<ana.length; i++){
	    	 *System.out.println(ana[i]);
	    	 *}
	    	 *------------------------------------
	    	*/


	    	/*
	    	 * testing
	    	 *-----------------------------------
	    	 * for(int i = 0; i<ana1.length; i++){
	    	 *     System.out.println(ana1[i]);
	    	 *}
	    	 *-------------------------------------
	    	*/
	    	
	    	//closing the files
	    	e.closeReadFile();
	    	e1.closeReadFile();
	    	
	    	//Creating the object for the remove punctuation class
	    	RemovePunct t1 = new RemovePunct(ana1, ana);
	    	
	    	//Calling the fullRv(Remove) method to clean an array of punctuation marks
	    	String[] ana2 = t1.fullRv();
	    	
	    	//Display for testing
	    	/*for(int i = 0; i<ana2.length; i++){
	    		System.out.println(ana2[i]);
	    	}*/
	    	
	    	//Creating a obj for top 10 words
	    	AvgWords t2 = new AvgWords(ana2);
	    	//calling it's methond
	    	String[] topten = t2.topWords();
	    	
	    	/*
	    	 * Testing
	    	 * -------------------------------
	    	 *for(int i=0; i<10; i++){
	    		*System.out.println(topten[i]);
	    	 *}
	    	 *-------------------------------------
	    	*/
	   }

}

