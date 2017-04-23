/*************************************************************************
 * 
 * 
 *  
 *  This class will verify if the program is registered and if not then 
 *  it will check if the key is the necessary one
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/

import java.util.ArrayList;

public class Registration {
	
	private String code; //the code the user enters
	String pre_set; //The preset code that the user needs to activate the program
	private ArrayList<String> log; //The ArrayList containing all the keys present in the log file
	private int count; // counter to check any key present is right
	
	//constructor
	Registration(String code){
		this.code = code;  //code user needs to enter
		pre_set = "0000"; //preset code set in the program
	}
	
	//constructor without user input, for file checking
	Registration(){ 
		pre_set = "0000";
	}
	
	//checking if the code entered is right or not
	public boolean checkReg(){
		if (code.equals(pre_set)){
			return true;
		}
		else{
			return false;
		}
	}
	
	//check if the code in the file is right
	public boolean checkFile(){
		try{
			//create file manager object
			FileManager e = new FileManager("D:\\Programming\\workspace\\Robo2\\src\\log.txt");
			//connect to the file
			e.connectToFile();
			//read the file and save it to the ArrayList log
			log = e.readFile();
			//Close connection
			e.closeReadFile();
		}
		catch(Exception e){
			return false;
		}
		
		//check if the code is present in the ArrayList
		for(String temp: log){
			if(temp.equals(pre_set)){
				count++; //Increment the counter
			}
		}
		
		//check if the program is activeted or not
		if(count > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
