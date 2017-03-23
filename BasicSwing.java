import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class BasicSwing extends JFrame{
	JPanel p = new JPanel();
	JButton b = new JButton("Hello World!");
	JTextField t= new JTextField("Hi", 20);
	JTextArea ta = new JTextArea("How\nAre\nYou", 5, 20);
	JLabel l = new JLabel("Random");
	String[] choices = {"Winter", "Summer", "Spring"};
	JComboBox c = new JComboBox(choices);
	public static void main(String[] args) {
		new BasicSwing();
	}
	
	public BasicSwing(){
		super("Basic Swing App");
		setSize(800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		
		p.add(b);
		p.add(t);
		p.add(ta);
		p.add(l);
		p.add(c);
		add(p);
		setVisible(true);
	}

}
