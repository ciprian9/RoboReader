/*************************************************************************
 * 
 * 
 *  This is the control class that holds the main method
 *  Author: Ciprian Anton
 *  2017
 *  
 *  
 ************************************************************************************/
import java.awt.EventQueue;

public class ProjectControl 
{
	public static void main(String[] args) 
	 {
		
		//allows processes to be moved to the end of GUI processing so GUI won't get stuck
		EventQueue.invokeLater(new Runnable()
		{
			//Run method to create the main window
			public void run() 
			{
				try 
				{
					//create a Project_Gui object
					Project_Gui window = new Project_Gui();
					//set the frame visible
					window.mainWindow.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	 }
}

