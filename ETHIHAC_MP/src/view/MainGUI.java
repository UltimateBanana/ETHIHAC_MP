package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainGUI {

	private JFrame frame;
	private JTextArea txtrUserAccount;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public MainGUI(String output) 
	{
		initialize(output);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String output) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		txtrUserAccount = new JTextArea();
		txtrUserAccount.setText("User Account  -  Password\n--------------------------------\n" + output);
		txtrUserAccount.setEditable(false);
		txtrUserAccount.setBounds(6, 6, 488, 396);
		frame.getContentPane().add(txtrUserAccount);
	}
	
}
