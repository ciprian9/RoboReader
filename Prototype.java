import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.util.ArrayList;


public class Prototype {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototype window = new Prototype();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prototype() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 11, 595, 39);
		frame.getContentPane().add(toolBar);
		
		JButton OpenFile = new JButton("OpenFile");
		OpenFile.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\open_file-512 (1).png"));
		toolBar.add(OpenFile);
		
		JButton LangCheck = new JButton("Check Language");
		toolBar.add(LangCheck);
		LangCheck.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\lang.png"));
		
		JButton TopWords = new JButton("Top 10");
		toolBar.add(TopWords);
		TopWords.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\icon-top_10s.png"));
		
		JButton FullText = new JButton("Display Text");
		toolBar.add(FullText);
		FullText.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\desktop-512.png"));
		
		JButton Filter = new JButton("Filter");
		toolBar.add(Filter);
		Filter.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\filter_list_order_sequence_sor.png"));
		
		JButton Exit = new JButton("Exit");
		toolBar.add(Exit);
		Exit.setIcon(new ImageIcon("Z:\\Prototyping\\RoboReader\\Web Test\\exit1600 (1).png"));
		
		JLabel lblLanguage = new JLabel("Language:");
		lblLanguage.setBounds(20, 61, 73, 14);
		frame.getContentPane().add(lblLanguage);
		
		JLabel lblTopWords = new JLabel("Top 10 Words");
		lblTopWords.setBounds(20, 86, 98, 21);
		frame.getContentPane().add(lblTopWords);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 118, 256, 107);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
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
				"Number", "Word"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(90, 58, 151, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFilterWords = new JLabel("Filter Words");
		lblFilterWords.setBounds(322, 89, 98, 21);
		frame.getContentPane().add(lblFilterWords);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(322, 118, 264, 103);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDisplayText = new JLabel("Display Text");
		lblDisplayText.setBounds(238, 232, 73, 21);
		frame.getContentPane().add(lblDisplayText);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 257, 587, 77);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textFile_Full = new JTextArea("");
		textFile_Full.setEnabled(false);
		scrollPane_1.setViewportView(textFile_Full);
		
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		OpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFile_Full.setEnabled(true);
				textFile_Full.append("hELLO");
			}
		});
		
		LangCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(punctMarks);
	 			//FindLan t3 = new FindLan(ProjectControl.fileRead);
	 		 	//t3.cLang();
			}
		});
		
		FullText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileManager read_all = new FileManager("Z:\\Java\\College\\Robo-Reader\\src\\Example1.txt");
				ArrayList<String> values = new ArrayList<String>();
	 			read_all.connectToFile();
	 		
	 			values = read_all.readLines();
	 		
	 			read_all.closeReadFile();
	 			
	 			String tmp = "";
	 			
	 			for(String temp: values){
	 				tmp = tmp + temp + "\n";
	 			}
	 			
	 			textFile_Full.setEnabled(true);
				textFile_Full.append(tmp);
	 			//System.out.print(tmp);
			}
		});
		



	}
}
