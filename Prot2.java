import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;


public class Prot2 {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prot2 window = new Prot2();
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
	public Prot2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 648, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		JLabel lblLanguages = new JLabel("Languages");
		lblLanguages.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		
		JLabel lblTopWords = new JLabel("Top 10 Words");
		lblTopWords.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblLanguages, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(78)
					.addComponent(lblTopWords, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(103))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLanguages, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addComponent(lblTopWords, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Numbers", "Words"
			}
		));
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToolBar toolBar = new JToolBar();
		panel.add(toolBar);
		
		JButton btnNewButton = new JButton("New button");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		toolBar.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		toolBar.add(btnNewButton_5);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.EAST);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{89, 0, 86, 0, 0};
		gbl_panel_3.rowHeights = new int[]{23, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnNewButton_6 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 0;
		panel_3.add(btnNewButton_6, gbc_btnNewButton_6);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		gbc_textField_1.gridwidth = 2;
		panel_3.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JToggleButton tglbtnFilter = new JToggleButton("Filter");
		GridBagConstraints gbc_tglbtnFilter = new GridBagConstraints();
		gbc_tglbtnFilter.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnFilter.gridx = 0;
		gbc_tglbtnFilter.gridy = 2;
		panel_3.add(tglbtnFilter, gbc_tglbtnFilter);
		
		JLabel lblNewLabel = new JLabel("Filter Words");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 3;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.ipady = 120;
		gbc_scrollPane_1.ipadx = 30;
		panel_3.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{225, 46, 89, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 23, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(5, 10, 5, 10);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 0;
		gbc_scrollPane_2.gridwidth = 3;
		gbc_scrollPane_2.gridheight = 4;
		gbc_scrollPane_2.ipady = 80;
		panel_2.add(scrollPane_2, gbc_scrollPane_2);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		
		JButton btnNewButton_8 = new JButton("Display Full Text");
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 0;
		gbc_btnNewButton_8.gridy = 4;
		gbc_btnNewButton_8.gridwidth = 3;
		gbc_btnNewButton_8.ipadx = 200;
		panel_2.add(btnNewButton_8, gbc_btnNewButton_8);
	
		

	}
}
