import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class FileChooser {
	ArrayList<String> sb;
	JFileChooser txtFile;
	File str;
	String path;
	String name;
	
	public FileChooser(){
		this.sb = new ArrayList<String>();
		this.txtFile = new JFileChooser("Z:\\Java\\College\\Robo-Reader\\src");
		this.path = "";
		this.name = "";
		
		
	}
	
	public ArrayList<String> ChooseFile(int num) throws FileNotFoundException{
		if (txtFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			java.io.File file = txtFile.getSelectedFile();
			str = file.getParentFile();
			path = str.toString();
			name = file.getName();
			System.out.println(path);
			
			Scanner input = new Scanner(file);
			
			if(num == 1){
				
				while (input.hasNext())
				{      
					sb.add(input.nextLine());
				}
				input.close();
				return sb;
				
			}
			else if(num == 2){
				while (input.hasNext())
				{      
					sb.add(input.next());
				}
				
				input.close();
				return sb;
			}
			input.close();
		}
			
		else{
					System.out.print("No file has been selected");
		}
		
		return sb;
	}
		
}

