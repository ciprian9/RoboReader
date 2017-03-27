//All the imports for all the components needed
import java.awt.BorderLayout;
import java.awt.EventQueue;
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
	
	//Constructor
	public Project_Gui() {
		readNecessaryFiles(); //Calling Files method
		RegistrationCheck(); //Calling Registration Method
		initialize(); //Calling the initialisation fo the GUI method
		
	}
	
	public void readNecessaryFiles(){
		e1 = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\punctuation.txt"); //Open the punctuation file
		e1.connectToFile(); //Connection to the file
		punctMarks = e1.readFile(); //Reading the File and saving it into PunctMarks
		e1.closeReadFile(); //Closing the File
	}
	
	public void RegistrationCheck(){
		r = new Registration(); //Creating the registration object
		reg = r.checkFile();  //accessing the checkFile method to verify if the product was already registered.
	}
	
	//Initialize the contents of the frame.
	private void initialize() {
		//creating main frame
		mainWindow = new JFrame();
		//setting the size
		mainWindow.setBounds(100, 100, 623, 484);
		//Exit when the x button is pressed
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setResizable(false);
		//Creating central panel
		JPanel center = new JPanel();
		//Adding the panel to the mainWindow
		mainWindow.getContentPane().add(center, BorderLayout.CENTER);
		//Setting it up as a border Layout
		center.setLayout(new BorderLayout(0, 0));
		
/************************************************************************************************
 * This is the Western Part of the GUI		
 ************************************************************************************************/
		
		//Creating panel for the Left
				JPanel west = new JPanel();
				center.add(west, BorderLayout.WEST);
				
				//Creating labels for the Western side of the app
				JLabel l_Languages = new JLabel("Languages");
				l_Languages.setHorizontalAlignment(SwingConstants.CENTER);
				
				//Creating text field to display the language
				JTextField text_lang = new JTextField();
				text_lang.setEditable(false);
				text_lang.setColumns(20);

				
				//Set label for Top Words
				JLabel l_TopWords = new JLabel("Top 10 Words");
				l_TopWords.setHorizontalAlignment(SwingConstants.CENTER);
				
				//Set the scroll area for the table
				JScrollPane table_scrollPane = new JScrollPane();
				
				//Creating a group layout for the west panel
				GroupLayout gl_west = new GroupLayout(west);
				//Group will use horizontal alignment
				gl_west.setHorizontalGroup(
						
						//From here on I am adding the different elements to the group : Some of the code have been taken from StockOverflow such as .addGroup(gl_west.createParallelGroup(Alignment.LEADING)
					gl_west.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_west.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_west.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_west.createSequentialGroup()
										.addGap(10)
										.addComponent(table_scrollPane, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
									.addGroup(gl_west.createSequentialGroup()
										.addComponent(l_Languages, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(text_lang, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
							.addGroup(gl_west.createSequentialGroup()
								.addGap(76)
								.addComponent(l_TopWords, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(105))
					);
					gl_west.setVerticalGroup(
						gl_west.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_west.createSequentialGroup()
								.addGap(8)
								.addGroup(gl_west.createParallelGroup(Alignment.BASELINE)
									.addComponent(l_Languages, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(text_lang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addComponent(l_TopWords, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(table_scrollPane, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addGap(29))
					);
					
				//Creating the table for top 10 words
				JTable table = new JTable();
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
				
				table_scrollPane.setViewportView(table);
				west.setLayout(gl_west);
				
				
				
								
/*********************************************************************************
 * This is the Eastern part of the GUI				
 ********************************************************************************/
				
				//Creating panel for the Right
				JPanel east = new JPanel();
				center.add(east, BorderLayout.EAST);
				
				//Creating a GridBagLayout for the Easter side of the app
				GridBagLayout gbl_east = new GridBagLayout();
				//Setting up all the necessry measuremeants and component distribution
				gbl_east.columnWidths = new int[]{89, 0, 86, 0, 0};
				gbl_east.rowHeights = new int[]{23, 0, 0, 0, 0};
				gbl_east.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_east.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				east.setLayout(gbl_east);
				
				//Setting up the constraints for each component
				JButton reg_Button = new JButton("Register");
				if(reg){
					reg_Button.setEnabled(false);
				}
				GridBagConstraints gbc_reg_Button = new GridBagConstraints();
				gbc_reg_Button.anchor = GridBagConstraints.NORTHWEST; //Place it to the top-left
				gbc_reg_Button.insets = new Insets(0, 0, 5, 5); //Specify the space between the component and the edge of the panel
				gbc_reg_Button.gridx = 0; //Column
				gbc_reg_Button.gridy = 0; //Row
				east.add(reg_Button, gbc_reg_Button); //Add to the panel
				
				JPasswordField reg_Field = new JPasswordField();
				if(reg){
					reg_Field.setEnabled(false);
				}
				GridBagConstraints gbc_reg_Field = new GridBagConstraints();
				gbc_reg_Field.insets = new Insets(0, 0, 5, 5);
				gbc_reg_Field.fill = GridBagConstraints.HORIZONTAL;
				gbc_reg_Field.gridx = 1;
				gbc_reg_Field.gridy = 0;
				gbc_reg_Field.gridwidth = 2; //span over 2 columns
				east.add(reg_Field, gbc_reg_Field);
				reg_Field.setColumns(10);
				
				JButton tb_Filter = new JButton("Exclude");
				tb_Filter.setEnabled(reg);
				GridBagConstraints gbc_tb_Filter = new GridBagConstraints();
				gbc_tb_Filter.insets = new Insets(10, 0, 5, 5);
				gbc_tb_Filter.gridx = 1;
				gbc_tb_Filter.gridy = 2;
				east.add(tb_Filter, gbc_tb_Filter);
				
				//Add a scroll pane for the border of the text area
				JScrollPane Filter_scrollPane = new JScrollPane();
				GridBagConstraints gbc_Filter_scrollPane = new GridBagConstraints();
				gbc_Filter_scrollPane.insets = new Insets(5, 0, 0, 5);
				gbc_Filter_scrollPane.anchor = GridBagConstraints.NORTH;
				gbc_Filter_scrollPane.fill = GridBagConstraints.HORIZONTAL;
				gbc_Filter_scrollPane.gridx = 0;
				gbc_Filter_scrollPane.gridy = 3;
				gbc_Filter_scrollPane.gridwidth = 3;
				gbc_Filter_scrollPane.ipady = 120; //height
				east.add(Filter_scrollPane, gbc_Filter_scrollPane);
				
				filter_TextArea = new JTextArea();
				Filter_scrollPane.setViewportView(filter_TextArea);
				filter_TextArea.setLineWrap(true);
				filter_TextArea.setEditable(false);
				
				tb_Filter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String[] s = filter_TextArea.getText().split(",");
						ArrayList<String> exclude1 = new ArrayList<>(Arrays.asList(s)) ;
						ArrayList<String> exclude = new ArrayList<String>();
						for(int i=0; i<exclude1.size(); i++){
							exclude.add(exclude1.get(i).replaceAll("[\n\\s]", ""));
						}
						//System.out.print(exclude.toString());
						FilterWords filter = new FilterWords(punctMarks, exclude);
				 		punctMarks=filter.readWords();
				 		//System.out.print(punctMarks.toString());
				 		but_Top.doClick();
					}
				});
				

				
/*********************************************************************************
 * This is the Southern part of the GUI
 **********************************************************************************/
				//Creating panel for the bottom
				JPanel south = new JPanel();
				center.add(south, BorderLayout.SOUTH);
				GridBagLayout gbl_south = new GridBagLayout();
				gbl_south.columnWidths = new int[]{225, 46, 89, 0, 0};
				gbl_south.rowHeights = new int[]{0, 0, 0, 0, 23, 0};
				gbl_south.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_south.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				south.setLayout(gbl_south);
				
				JScrollPane fullText_Pane = new JScrollPane();
				GridBagConstraints gbc_fullText_Pane = new GridBagConstraints();
				gbc_fullText_Pane.insets = new Insets(5, 10, 5, 10);
				gbc_fullText_Pane.fill = GridBagConstraints.BOTH;
				gbc_fullText_Pane.gridx = 0;
				gbc_fullText_Pane.gridy = 0;
				gbc_fullText_Pane.gridwidth = 3;
				gbc_fullText_Pane.gridheight = 4;
				gbc_fullText_Pane.ipady = 80;
				south.add(fullText_Pane, gbc_fullText_Pane);
				
				JTextArea fullText_Area = new JTextArea();
				fullText_Pane.setViewportView(fullText_Area);
				fullText_Area.setEditable(false);
				
				JButton but_FullText = new JButton("Display Full Text");
				but_FullText.setEnabled(reg);
				GridBagConstraints gbc_but_FullText = new GridBagConstraints();
				gbc_but_FullText.insets = new Insets(0, 0, 5, 5);
				gbc_but_FullText.gridx = 0;
				gbc_but_FullText.gridy = 4;
				gbc_but_FullText.gridwidth = 3;
				gbc_but_FullText.ipadx = 200;
				south.add(but_FullText, gbc_but_FullText);
				
				but_FullText.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {	
						if(isFileOpen){
							FileManager e = new FileManager(j.path + "\\" + j.name);
							e.connectToFile();
							fullText = e.readLines();
							e.closeReadFile();
							
							String tmp = "";
				 			
				 			for(String temp: fullText){
				 				tmp = tmp + temp + "\n";
				 			}
				 			
				 			fullText_Area.setEnabled(true);
							fullText_Area.append(tmp);
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
				
				
				
		
				
/**************************************************************************************************************
 * This is the North or Top part of the GUI		
 ****************************************************************************************************************/
		//Creating panel for the top
		JPanel north = new JPanel();
		center.add(north, BorderLayout.NORTH);
		
		//Creating a tool bar in the north panel
		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		north.add(toolBar);
		
		//Creating all needed buttons to populate the tool bar
		but_OpenFile = new JButton("");
		but_OpenFile.setEnabled(reg);
		//All buttons use an icon instead of text
		but_OpenFile.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\open_file-512 (1).png"));
		toolBar.add(but_OpenFile);
		
		JButton but_FindLang = new JButton("");
		but_FindLang.setEnabled(reg);
		toolBar.add(but_FindLang);
		but_FindLang.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\lang.png"));
		
		but_Top = new JButton("");
		but_Top.setEnabled(reg);
		but_Top.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\icon-top_10s.png"));
		toolBar.add(but_Top);
		
		JButton but_Text = new JButton("");
		but_Text.setEnabled(reg);
		but_Text.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\desktop-512.png"));
		toolBar.add(but_Text);
		
		JButton but_Filter = new JButton("");
		but_Filter.setEnabled(reg);
		but_Filter.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\filter_list_order_sequence_sor.png"));
		toolBar.add(but_Filter);
		
		JButton but_Exit = new JButton("");
		but_Exit.setEnabled(reg);
		but_Exit.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\exit1600 (1).png"));
		toolBar.add(but_Exit);
		
		//Creating all the Action Listeners for each button
		but_OpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				isFileOpen = true;
				j = new FileChooser();
				
				try {
					fileRead = j.ChooseFile(2);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		but_FindLang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(isFileOpen){
				
					//System.out.print(fileRead);
					FindLan l = new FindLan(fileRead);
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
					
					table.setModel(new DefaultTableModel(
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
 * This is the man menu added directly to the frame
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
		
		
		JMenuItem item_Reset = new JMenuItem("Reset");
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
				isFileOpen = true;
				j = new FileChooser();
				
				try {
					fileRead = j.ChooseFile(2);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
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
		
		reg_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {					
				String code = new String(reg_Field.getPassword());
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
}
