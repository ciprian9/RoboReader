/**************************************************************************************************************************************
 * 
 * This class will be used to create and display the whole gui, it also takes care of all action detection
 * Author: Ciprian Anton
 * 2017
 *
 *
 **************************************************************************************************************************************/

//All the imports for all the components needed
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;



public class Project_Gui extends JFrame {
	/**
	 * The serialVersion UID is used to make sure a class has a serial in order to allow knowladge of the version that is in use
	 */
	private static final long serialVersionUID = 1L;
	//Attributes
	JFrame mainWindow; //the main window for the GUI
	private JTextArea filter_TextArea; //Text area for the words that will be filtered
	private ArrayList<String> fileRead; //ArrayList of all the words in the File
	private ArrayList<String> fullText; //ArrayList of all the lines in the File
	private ArrayList<String> punctMarks; //ArrayList of all the Punctuation Marks that should be removed
	private JButton but_Top; //Button to display the top ten words
	private FileChooser j; //FileChooser object to interact with the FieChooser Class
	private boolean isFileOpen = false; //Boolean value to check if a file has been loaded or not
	private boolean reg; //boolean checking if the product is registered or not
	private FileManager e1; //FileManager to deal with automated files such as punctuation or log
	private Registration r; //Registration object used to access the registration methods
	private JButton but_OpenFile; //Open File Button to access the FileChooser
	private JPanel center; //center panel where everything is placed
	JMenuItem item_Reset;
	String code;
	
	//Constructor
	public Project_Gui() {
		readNecessaryFiles(); //Calling Files method
		RegistrationCheck(); //Calling Registration Method
		initialize(); //Calling the initialization fo the GUI method
		
	}
	
	public void readNecessaryFiles(){
		e1 = new FileManager(System.getProperty("user.dir") + "\\src\\punctuation.txt"); //Open the punctuation file
		e1.connectToFile(); //Connection to the file
		punctMarks = e1.readFile(); //Reading the File and saving it into PunctMarks
		e1.closeReadFile(); //Closing the File
	}
	
	public void RegistrationCheck(){
		r = new Registration(); //Creating the registration object
		reg = r.checkFile();  //accessing the checkFile method to verify if the product was already registered.
		if(reg)
			code = r.pre_set;
	}
	
	//Initialize the contents of the frame.
	private void initialize() {	
		mainWindow = new JFrame(); //creating main frame
		mainWindow.setBounds(100, 100, 623, 484); //setting the size
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit when the x button is pressed
		mainWindow.setResizable(false); //Disable resizable windows
		JPanel center = new JPanel(); //Creating central panel
		mainWindow.getContentPane().add(center, BorderLayout.CENTER); //Adding the panel to the mainWindow
		center.setLayout(new BorderLayout(0, 0)); //Setting it up as a border Layout
		
/************************************************************************************************
 * This is the Western Part of the GUI		
 ************************************************************************************************/
		
		
				JPanel west = new JPanel(); //Creating panel for the Left side of the GUI
				center.add(west, BorderLayout.WEST); //Add the Panel to the center Panel
				
				
				JLabel l_Languages = new JLabel("Languages"); //Creating A Label to display the language
				l_Languages.setHorizontalAlignment(SwingConstants.CENTER); //Add the label to the panel and center it
				
				
				JTextField text_lang = new JTextField(); //Creating text field to display the language
				text_lang.setEditable(false); //Disable editing in the text field
				text_lang.setColumns(20); //set it 20 columns long

				
				
				JLabel l_TopWords = new JLabel("Top 10 Words"); //Set label for Top Words
				l_TopWords.setHorizontalAlignment(SwingConstants.CENTER); //Place it and center it
				
				
				JScrollPane table_scrollPane = new JScrollPane(); //Set the scroll area for the table
				
				
				GroupLayout gl_west = new GroupLayout(west); //Creating a group layout for the west panel
				
				gl_west.setHorizontalGroup( //Group will use horizontal alignment
						
		
					gl_west.createParallelGroup(Alignment.LEADING) //Creating parallel grouping and placing the components to the origin (Leading)
						.addGroup(gl_west.createSequentialGroup() //Adding the group sequentially
							.addGap(5) //Add a 5 pixel gap
							.addGroup(gl_west.createParallelGroup(Alignment.LEADING) //Add the following component also leading Parallel to the previous one
									.addGroup(gl_west.createSequentialGroup() 
										.addGap(10) // add a 10 pixel gap
										.addComponent(table_scrollPane, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)) //Add the table, use the table's default size
									.addGroup(gl_west.createSequentialGroup() //Add it to the group
										.addComponent(l_Languages, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE) //Add the language label
										.addPreferredGap(ComponentPlacement.RELATED) //Add a gap to the two components based on their relation
										.addComponent(text_lang, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))) //Add the text field
								.addContainerGap()) //Add a gap in between containers
							.addGroup(gl_west.createSequentialGroup() //Create another group
								.addGap(76) //Add a 76 pixel gap
								.addComponent(l_TopWords, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) //add the top 10 label
								.addGap(105)) //add a gap
					);
					gl_west.setVerticalGroup( //creating the vertical group
						gl_west.createParallelGroup(Alignment.LEADING) //Create the parallel group
							.addGroup(gl_west.createSequentialGroup() //Create the sequential group
								.addGap(8) //Add the gap
								.addGroup(gl_west.createParallelGroup(Alignment.BASELINE) // Create a parallel group along the baseline
									.addComponent(l_Languages, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) //place the language label
									.addComponent(text_lang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)) //Add the language text field
								.addGap(26) //Add a Gap
								.addComponent(l_TopWords, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE) // Place top 10 label
								.addPreferredGap(ComponentPlacement.RELATED) // Add a gap from the relation of the components
								.addComponent(table_scrollPane, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE) //Add the table
								.addGap(29)) //Add a gap
					);
					
				
				JTable table = new JTable(); //Creating the table for top 10 words
				table.setModel(new DefaultTableModel( //Setting the table to the Default Table Model
					new Object[][] { //The table is a 2D array 
						{1, null},
						{2, null},
						{3, null},
						{4, null},
						{5, null},
						{6, null},
						{7, null},
						{8, null},
						{9, null},
						{10, null},
					},
					new String[] { //The string Array holds the columns names
						"Numbers", "Words"
					}
				));
				
				table_scrollPane.setViewportView(table); // set what the view in the scroll pane will display
				west.setLayout(gl_west); //Set the layout of the panel to the group layout above
				
				
				
								
/*********************************************************************************
 * This is the Eastern part of the GUI				
 ********************************************************************************/
				
				
				JPanel east = new JPanel(); //Creating panel for the Right//Creating panel for the Right
				center.add(east, BorderLayout.EAST); //Adding it to the eastern (right) side of the center panel
				
				
				GridBagLayout gbl_east = new GridBagLayout(); //Creating a GridBagLayout for the Easter side of the app
				gbl_east.columnWidths = new int[]{89, 0, 86, 0, 0}; //setting up the column widths
				gbl_east.rowHeights = new int[]{23, 0, 0, 0, 0}; //setting the row heights
				gbl_east.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE}; //setting the column weights, deciding on the ammount of elements
				gbl_east.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE}; // setting the row weights 
				east.setLayout(gbl_east);
				
				
				JButton reg_Button = new JButton("Register"); //setting up the Registration button
				if(reg){ //Veifying if the product is registered disable the button
					reg_Button.setEnabled(false);
				}
				GridBagConstraints gbc_reg_Button = new GridBagConstraints(); //Adding constraints for the button
				gbc_reg_Button.anchor = GridBagConstraints.NORTHWEST; //Place it to the top-left
				gbc_reg_Button.insets = new Insets(0, 0, 5, 5); //Specify the space between the component and the edge of the panel
				gbc_reg_Button.gridx = 0; //Column
				gbc_reg_Button.gridy = 0; //Row
				east.add(reg_Button, gbc_reg_Button); //Add to the panel
				
				JPasswordField reg_Field = new JPasswordField(); //Create a password field where we will write the activation code
				if(reg){ //if the product is activated disable it
					reg_Field.setEnabled(false);
				}
				GridBagConstraints gbc_reg_Field = new GridBagConstraints(); //Constraints
				gbc_reg_Field.insets = new Insets(0, 0, 5, 5);
				gbc_reg_Field.fill = GridBagConstraints.HORIZONTAL;
				gbc_reg_Field.gridx = 1;
				gbc_reg_Field.gridy = 0;
				gbc_reg_Field.gridwidth = 2; //span over 2 columns
				east.add(reg_Field, gbc_reg_Field);
				reg_Field.setColumns(10);
				
				JButton tb_Filter = new JButton("Exclude"); //The exclude Button is used to eliminate all the unwanted words
				tb_Filter.setEnabled(reg); //if product is not activated disable it
				GridBagConstraints gbc_tb_Filter = new GridBagConstraints();
				gbc_tb_Filter.insets = new Insets(10, 0, 5, 5);
				gbc_tb_Filter.gridx = 1;
				gbc_tb_Filter.gridy = 2;
				east.add(tb_Filter, gbc_tb_Filter);
				
				
				JScrollPane Filter_scrollPane = new JScrollPane(); //Add a scroll pane for the border of the text area
				GridBagConstraints gbc_Filter_scrollPane = new GridBagConstraints();
				gbc_Filter_scrollPane.insets = new Insets(5, 0, 0, 5);
				gbc_Filter_scrollPane.anchor = GridBagConstraints.NORTH; //Place it to the north
				gbc_Filter_scrollPane.fill = GridBagConstraints.HORIZONTAL; // Fill the screen Horizontally
				gbc_Filter_scrollPane.gridx = 0;
				gbc_Filter_scrollPane.gridy = 3;
				gbc_Filter_scrollPane.gridwidth = 3; // span over columns
				gbc_Filter_scrollPane.ipady = 120; //height
				east.add(Filter_scrollPane, gbc_Filter_scrollPane);
				
				filter_TextArea = new JTextArea(); //Text area to enter all the excluded words
				Filter_scrollPane.setViewportView(filter_TextArea); //set the viewport to the text area
				filter_TextArea.setLineWrap(true); //Wrap the lines for no horizontal scrolling
				filter_TextArea.setEditable(false); //Disable the field
				
				tb_Filter.addActionListener(new ActionListener() { //Action listener for the Filter button
					public void actionPerformed(ActionEvent arg0) {
						String[] s = filter_TextArea.getText().split(","); //Split the content of the text area and add it to the String array
						ArrayList<String> exclude1 = new ArrayList<>(Arrays.asList(s)) ; //turn the string array into a ArrayList
						ArrayList<String> exclude = new ArrayList<String>();  //Create a new array list that remove all the spaces and linebreaks
						for(int i=0; i<exclude1.size(); i++){ //loop over all elements of exclude1
							exclude.add(exclude1.get(i).replaceAll("[\n\\s]", "")); //removing the linebreaks and spaces
						}
						FilterWords filter = new FilterWords(punctMarks, exclude); //Create an object of Filter Words class  passing the necessary arrayLists
				 		punctMarks=filter.readWords(); //Call the method read words and return the new arrayList of punctuation to be removed (including the excluded words)
				 		but_Top.doClick(); //perform a click on top 10 button to update the display
					}
				});
				

				
/*********************************************************************************
 * This is the Southern part of the GUI
 **********************************************************************************/
				
				JPanel south = new JPanel(); //Creating panel for the bottom
				center.add(south, BorderLayout.SOUTH); //Adding it to the bottom of the center panel
				GridBagLayout gbl_south = new GridBagLayout(); //Setting up necessary measuremeants
				gbl_south.columnWidths = new int[]{225, 46, 89, 0, 0};
				gbl_south.rowHeights = new int[]{0, 0, 0, 0, 23, 0};
				gbl_south.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_south.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				south.setLayout(gbl_south);
				
				JScrollPane fullText_Pane = new JScrollPane(); //creating a scroll pane for the full Text displays
				GridBagConstraints gbc_fullText_Pane = new GridBagConstraints();
				gbc_fullText_Pane.insets = new Insets(5, 10, 5, 10);
				gbc_fullText_Pane.fill = GridBagConstraints.BOTH;
				gbc_fullText_Pane.gridx = 0;
				gbc_fullText_Pane.gridy = 0;
				gbc_fullText_Pane.gridwidth = 3;
				gbc_fullText_Pane.gridheight = 4; //Spanning over 4 rows
				gbc_fullText_Pane.ipady = 80;
				south.add(fullText_Pane, gbc_fullText_Pane);
				
				JTextArea fullText_Area = new JTextArea(); //Text area where the data will be displayed 
				fullText_Pane.setViewportView(fullText_Area); //setting the view
				fullText_Area.setEditable(false); //disable editing
				fullText_Area.setLineWrap(true);
				
				JButton but_FullText = new JButton("Display Full Text"); //Button that will print the contents of the file
				but_FullText.setEnabled(reg);
				GridBagConstraints gbc_but_FullText = new GridBagConstraints();
				gbc_but_FullText.insets = new Insets(0, 0, 5, 5);
				gbc_but_FullText.gridx = 0;
				gbc_but_FullText.gridy = 4;
				gbc_but_FullText.gridwidth = 3;
				gbc_but_FullText.ipadx = 200; //Make it wider
				south.add(but_FullText, gbc_but_FullText);
				
				but_FullText.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {	
						if(isFileOpen){
							e1 = new FileManager(j.getPath() + "\\" + j.getName()); // Opening the fileManager to get the data line by line
							e1.connectToFile(); //Connecting to File
							fullText = e1.readLines(); //Reading all the lines
							e1.closeReadFile(); //closing the file
							
							String tmp = ""; //Empty string that will gather the data
				 			
				 			for(String temp: fullText){ //loop using iterator
				 				tmp = tmp + temp + "\n"; //adding the data to the empty string
				 			}
				 			
				 			fullText_Area.setEnabled(true); //Enable the TextArea
							fullText_Area.append(tmp); //Add the data
						}
						else{
							//0 for yes 1 for no Display an Error message showing th efile is not opened
							JOptionPane.showMessageDialog(center,"No File has been Opened.","FileNotFound Error",JOptionPane.ERROR_MESSAGE);
							//Ask if the user would like to open a file
							int n = JOptionPane.showConfirmDialog(center,"Would You Like to Pick A File?", "Open File?", JOptionPane.YES_NO_OPTION);
							
							if(n == 0){ 
								but_OpenFile.doClick(); //if yes access file chooser
							}
							else{
								System.exit(0); //of no close the program
							}
						}
					}
				});
				
				
				
		
				
/**************************************************************************************************************
 * This is the North or Top part of the GUI		
 ****************************************************************************************************************/

		JPanel north = new JPanel(); //Creating panel for the top
		center.add(north, BorderLayout.NORTH); //Place it at the top of the center panel
		
		
		JToolBar toolBar = new JToolBar(); //Creating a tool bar in the north panel
		toolBar.setEnabled(false); //Disable tool bar so it will not be moved
		north.add(toolBar); // Add it to the panel
		
		
		but_OpenFile = new JButton("");// Creating the OpenFile Button
		but_OpenFile.setEnabled(reg); 
		toolBar.add(but_OpenFile);
		but_OpenFile.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\Images\\open_file.png")); //Adding an icon to it
		
		
		JButton but_FindLang = new JButton(""); //Find Language Button
		but_FindLang.setEnabled(reg);
		toolBar.add(but_FindLang);
		but_FindLang.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\Images\\lang.png"));
		
		but_Top = new JButton(""); //Top 10 Button
		but_Top.setEnabled(reg);
		but_Top.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\Images\\icon-top_10s.png"));
		toolBar.add(but_Top);
		
		JButton but_Text = new JButton(""); //Dispaly Full Text Button
		but_Text.setEnabled(reg);
		but_Text.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\Images\\desktop-512.png"));
		toolBar.add(but_Text);
		
		JButton but_Filter = new JButton(""); //Filter Button
		but_Filter.setEnabled(reg);
		but_Filter.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\Images\\filter_list_order_sequence_sor.png"));
		toolBar.add(but_Filter);
		
		JButton but_Exit = new JButton(""); //Exit Button
		but_Exit.setEnabled(reg);
		but_Exit.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\Images\\exit1600 (1).png"));
		toolBar.add(but_Exit);
		
	
		but_OpenFile.addActionListener(new ActionListener() { //Action Listener for Open File

			public void actionPerformed(ActionEvent arg0) {
				if(isFileOpen){
					item_Reset.doClick();
				}
				isFileOpen = true; //set isFileOpen to true
				j = new FileChooser(); //Create a FileChooser object
				
				try {
					fileRead = j.chooseFile(); //Try to access FileChooser
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		but_FindLang.addActionListener(new ActionListener() { //Find Language Action Listener
			public void actionPerformed(ActionEvent arg0) {
				
				if(isFileOpen){
				
					//System.out.print(fileRead);
					FindLan l = new FindLan(fileRead); //Create FindLang object
					String lang = l.cLang();
					text_lang.setText(lang);				
				}
				else{
					//0 for yes 1 for no
					JOptionPane.showMessageDialog(center,"No File has been Opened.","FileNotFound Error",JOptionPane.ERROR_MESSAGE);
					int n = JOptionPane.showConfirmDialog(center,"Would You Like to Pick A File?", "Open File?", JOptionPane.YES_NO_OPTION);
					
					if(n == 0){
						but_OpenFile.doClick();
					}
					else{
						System.exit(0);
					}
				}
			}
		});
		
		but_Top.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isFileOpen){
					RemovePunct t1 = new RemovePunct(punctMarks, fileRead);
					ArrayList<String> cleanWords = t1.EndArray();
					
					table.setModel(new DefaultTableModel( //Setting the values for the table
							new Object[][] {
								{1, cleanWords.get(0)},
								{2, cleanWords.get(1)},
								{3, cleanWords.get(2)},
								{4, cleanWords.get(3)},
								{5, cleanWords.get(4)},
								{6, cleanWords.get(5)},
								{7, cleanWords.get(6)},
								{8, cleanWords.get(7)},
								{9, cleanWords.get(8)},
								{10, cleanWords.get(9)},
							},
							new String[] {
								"Numbers", "Words"
							}
						));
				
				}
				else{
					//0 for yes 1 for no
					JOptionPane.showMessageDialog(center,"No File has been Opened.","FileNotFound Error",JOptionPane.ERROR_MESSAGE);
					int n = JOptionPane.showConfirmDialog(center,"Would You Like to Pick A File?", "Open File?", JOptionPane.YES_NO_OPTION);
					
					if(n == 0){
						but_OpenFile.doClick();
					}
					else{
						System.exit(0);
					}
				}
			}
		});
		
		but_Text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isFileOpen){
					but_FullText.doClick();
				}
				else{
					//0 for yes 1 for no
					JOptionPane.showMessageDialog(center,"No File has been Opened.","FileNotFound Error",JOptionPane.ERROR_MESSAGE);
					int n = JOptionPane.showConfirmDialog(center,"Would You Like to Pick A File?", "Open File?", JOptionPane.YES_NO_OPTION);
						
					if(n == 0){
						but_OpenFile.doClick();
					}
					else{
						System.exit(0);
					}
				}
			}
		});
		
		but_Filter.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				filter_TextArea.setEditable(true);
				filter_TextArea.grabFocus();
			}
		});
		
		but_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//closing the program when exit button is click
				System.exit(0);
			}
		});
		
		
		
/*************************************************************************************
 * This is the main menu added directly to the frame
 ***************************************************************************************/
		
		
		//Creating a menu bar
		JMenuBar menuBar = new JMenuBar();
		mainWindow.setJMenuBar(menuBar);
		
		//Creating menu option File
		JMenu option_File = new JMenu("File");
		option_File.setEnabled(reg);
		menuBar.add(option_File);
		
		//Creating menu option item Open File
		JMenuItem item_Openfile = new JMenuItem("Open File");
		option_File.add(item_Openfile);
		
		
		item_Reset = new JMenuItem("Reset");
		option_File.add(item_Reset);
		
		
		
		
		JMenu option_Analyse = new JMenu("Analyse");
		option_Analyse.setEnabled(reg);
		menuBar.add(option_Analyse);
		
		JMenuItem item_VerifyLanguage = new JMenuItem("Verify Language");
		option_Analyse.add(item_VerifyLanguage);

		
		JMenuItem item_DisplayTop = new JMenuItem("Display Top 10");
		option_Analyse.add(item_DisplayTop);

		
		JMenuItem item_DisplayText = new JMenuItem("Display Text");
		option_Analyse.add(item_DisplayText);

		
		JMenu option_Filter = new JMenu("Filter");
		option_Filter.setEnabled(reg);
		menuBar.add(option_Filter);
		
		JMenuItem item_TurnOnFilter = new JMenuItem("Turn On Filter");
		option_Filter.add(item_TurnOnFilter);

		JMenu option_Help = new JMenu("Help");
		option_Help.setEnabled(reg);
		menuBar.add(option_Help);
		
		JMenuItem item_Faq = new JMenuItem("FAQ");
		option_Help.add(item_Faq);
		
		JMenuItem item_Registration = new JMenuItem("Registration");
		option_Help.add(item_Registration);
		
		item_Openfile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(isFileOpen){
					item_Reset.doClick();
				}
				isFileOpen = true;
				j = new FileChooser();
				
				try {
					fileRead = j.chooseFile();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		item_Reset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	fileRead.clear();
				text_lang.setText("");
				filter_TextArea.setText("");
				filter_TextArea.setEditable(false);
				fullText_Area.setText("");
				fullText.clear();
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{1, null},
							{2, null},
							{3, null},
							{4, null},
							{5, null},
							{6, null},
							{7, null},
							{8, null},
							{9, null},
							{10, null},
						},
						new String[] {
							"Numbers", "Words"
						}
					));

		    }
		});
		
		item_VerifyLanguage.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
				but_FindLang.doClick();
		    }
		});
		
		item_DisplayTop.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
				but_Top.doClick();
		    }
		});
		
		item_DisplayText.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	but_FullText.doClick();
		    }
		});
		
		item_TurnOnFilter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
				but_Filter.doClick();
		    }
		});
		
		item_Faq.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	JOptionPane.showMessageDialog(center,"1.Why are all buttons disabled?\n"
		    			+ "The buttons are disabled until the Registration code is entered.\n\n"
		    			+ "2.How does the exclude option work?\n"
		    			+ "The exclude option has to be firstly activated by \n accessing the filter button in the toolbar\n next type the words separated by commas\n and press exclude. All done!");
		    }
		});
		
		item_Registration.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ev) {
		    	JOptionPane.showMessageDialog(center,"The product is registered to the " + code + "serial code");
		    }
		});
		
		reg_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				code = new String(reg_Field.getPassword());
				Registration r = new Registration(code);
				boolean isReg = r.checkReg();
				
				if(isReg){
					tb_Filter.setEnabled(isReg);
					but_FullText.setEnabled(isReg);
					but_OpenFile.setEnabled(isReg);
					but_FindLang.setEnabled(isReg);
					but_Top.setEnabled(isReg);
					but_Filter.setEnabled(isReg);
					but_Text.setEnabled(isReg);
					but_Exit.setEnabled(isReg);
					option_File.setEnabled(isReg);
					option_Analyse.setEnabled(isReg);
					option_Filter.setEnabled(isReg);
					option_Help.setEnabled(isReg);
					reg_Field.setEnabled(false);
					reg_Button.setEnabled(false);
					
				}
				reg_Field.setText("");
				FileManager e = new FileManager(System.getProperty("user.dir") + "\\log.txt");
				e.connectToFile();
				e.getFileWriter();
				e.writeLineToFile(code);
				e.closeWriteFile();
				

			}
		});
		
	}

	public JPanel getCenter() {
		return center;
	}

	public void setCenter(JPanel center) {
		this.center = center;
	}
}
