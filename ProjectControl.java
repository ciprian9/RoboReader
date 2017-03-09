public class ProjectControl {

	 public static void main(String[] args) {
	    	FileManager e = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\Example1.txt");
	    	FileManager e1 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\log.txt");
	    	e.connectToFile();
	    	String[] ana = e.readFile();
	    	
	    	for(int i = 0; i<ana.length; i++){
	    		System.out.println(ana[i]);
	    	}
	    	e1.connectToFile();
	    	e1.getFileWriter();
	    	e1.writeLineToFile("Nicholas how are you");
	    	e.closeReadFile();
	    	e1.closeWriteFile();
	    	
	   }

}

