/*************************************************************************
 * 
 * 
 *  This is the control class that holds the main method
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/
import java.util.Scanner;
import java.util.ArrayList;

public class ProjectControl 
{

	 public static void main(String[] args) 
	 {
		Scanner option = new Scanner(System.in);
		int choice = 0;
		int filecount = 0;
		String filename = "";
		ArrayList<String> fileRead  = new ArrayList<String>();
		ArrayList<String> punctMarks = new ArrayList<String>();
		
		while(choice != 4){

		 System.out.print("Main Menu\n");
		 System.out.print("1. Open File\n");
		 System.out.print("2. Veify Language\n");
		 System.out.print("3. Display the top ten words\n");
		 System.out.print("4. Exit\n");
		 System.out.print("5. Display whole file\n");
		 System.out.print("6. Filter unwanted words\n");
		 System.out.print("Please select one of the following options: ");
		 
		 
		 choice = option.nextInt();

		 switch(choice)
		 {
		 	case 1:

		 		System.out.print("Please enter a filename: ");
		 		filename = option.next();
		 		
		 		FileManager read_1 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\punctuation.txt");
		 		FileManager read_2 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\" + filename + ".txt");
		 		
		 		read_1.connectToFile();
		 		read_2.connectToFile();
		 		
		 		punctMarks = read_1.readFile();
		 		fileRead = read_2.readFile();
		 		
		 		read_1.closeReadFile();
		 		read_2.closeReadFile();
		 		
		 		filecount++;
		 		System.out.println("File has been opened successfully");
		    	break;
		    
		 	case 2:
		 	
		 		if(filecount == 0)
		 		{
		 			System.out.println("No file was opened. Please open a file to correct this error:");
		 			
		 		}
		 		else
		 		{
		 			FindLan t3 = new FindLan(fileRead);
		 		 	t3.cLang();
		 		}
		 		break;
		 		
		 	case 3:
		 		if(filecount == 0)
		 		{
		 			System.out.println("No file was read. Please open a file to correct this error:");
		 			
		 		}
		 		else
		 		{
		 		
		 			//Creating the object for the remove punctuation class
		 			RemovePunct t1 = new RemovePunct(punctMarks, fileRead);
		    	
		 			//Calling the EndArray(Remove) method to clean an array of punctuation marks
		 			ArrayList<String> cleanWords = t1.EndArray();
		 			
		 			 for(int i=0; i<10; i++)
			    	 {
			    		System.out.println(cleanWords.get(i));
			    	 }
		 		}
		 		break;
		 	case 4:
		 		System.out.println("Thank You for Using Robo-Reader \n          Goodbye");
		 		break;
		 	default:
		 		System.out.println("Option is not available");
		 	}

		}
		option.close();

	 }
	 
}

