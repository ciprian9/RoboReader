import java.util.ArrayList;

public class Registration {
	
	private String code;
	private String pre_set;
	private ArrayList<String> log;
	private int count;
	
	
	Registration(String code){
		this.code = code;
		pre_set = "1111-1111-1111";
	}
	
	Registration(){
		pre_set = "1111-1111-1111";
	}
	public boolean checkReg(){
		if (code.equals(pre_set)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean checkFile(){
		try{
			FileManager e = new FileManager(System.getProperty("user.dir") + "\\log.txt");
			e.connectToFile();
			log = e.readFile();
			e.closeReadFile();
		}
		catch(Exception e){
			return false;
		}
		
		for(String temp: log){
			if(temp.equals(pre_set)){
				count++;
			}
		}
		
		if(count > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
