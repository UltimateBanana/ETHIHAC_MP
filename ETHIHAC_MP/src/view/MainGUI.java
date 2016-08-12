package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class MainGUI extends JFrame implements ActionListener
{
	private Controller controller;
	
	private DefaultTableModel defaultTableModel;
	
	private JPanel jpanel;
	private JLabel labelLinuxPassword, labelShadowPassword, labelWorstPassword, labelInformation, labelExport;
	private JTextField textFieldLinuxPassword, textFieldShadowPassword, textFieldWorstPassword;
	private JButton buttonLinuxPassword, buttonShadowPassword, buttonWorstPassword, buttonReset, buttonCrackPassword;
	private JTable tableOutput;
	private JScrollPane scrollPaneOutput;
	
	String[] columns = {"UserID", "Username", "Password"};
	
	public MainGUI( Controller controller ) 
	{
		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
					UIDefaults defaults = lookAndFeel.getDefaults();
					defaults.put("ScrollBar.minimumThumbSize", new Dimension(30, 30));
					break;
				}
			}
		}
		catch (Exception e)
		{
			// If Nimbus is not available, you can set the GUI to another
			// look and feel.
		}
		
		this.controller = controller;
		
		jpanel =  new JPanel();
		jpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		jpanel.setSize(650, 350);
		jpanel.setLayout(null);		
		
		labelLinuxPassword = new JLabel("Linux Password File");
		labelLinuxPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		labelLinuxPassword.setBounds(10, 15, 170, 25);
		jpanel.add(labelLinuxPassword);
		
		textFieldLinuxPassword = new JTextField("src/files/passwd.txt");
		textFieldLinuxPassword.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldLinuxPassword.setColumns(10);
		textFieldLinuxPassword.setBounds(190, 15, 400, 25);
		textFieldLinuxPassword.setEditable(false);
		jpanel.add(textFieldLinuxPassword);
		
		buttonLinuxPassword = new JButton("...");
		buttonLinuxPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonLinuxPassword.setBounds(600, 15, 55, 25);
		buttonLinuxPassword.addActionListener(this);
		jpanel.add(buttonLinuxPassword);
		
		labelShadowPassword = new JLabel("Shadow Password File");
		labelShadowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		labelShadowPassword.setBounds(10, 46, 170, 25);
		jpanel.add(labelShadowPassword);
		
		textFieldShadowPassword = new JTextField("src/files/shadow.txt");
		textFieldShadowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldShadowPassword.setColumns(10);
		textFieldShadowPassword.setBounds(190, 46, 400, 25);
		textFieldShadowPassword.setEditable(false);
		jpanel.add(textFieldShadowPassword);
		
		buttonShadowPassword = new JButton("...");
		buttonShadowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonShadowPassword.setBounds(600, 46, 55, 25);
		buttonShadowPassword.addActionListener(this);
		jpanel.add(buttonShadowPassword);
		
		labelWorstPassword = new JLabel("Worst Password File");
		labelWorstPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		labelWorstPassword.setBounds(10, 77, 170, 25);
		jpanel.add(labelWorstPassword);
		
		textFieldWorstPassword = new JTextField("src/files/500-worst-passwords.txt");
		textFieldWorstPassword.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textFieldWorstPassword.setColumns(10);
		textFieldWorstPassword.setBounds(190, 77, 400, 25);
		textFieldWorstPassword.setEditable(false);
		jpanel.add(textFieldWorstPassword);
		
		buttonWorstPassword = new JButton("...");
		buttonWorstPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonWorstPassword.setBounds(600, 77, 55, 25);
		buttonWorstPassword.addActionListener(this);
		jpanel.add(buttonWorstPassword);
		
		buttonReset = new JButton("Reset");
		buttonReset.setHorizontalAlignment(SwingConstants.CENTER);
		buttonReset.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonReset.setBounds(665, 15, 119, 25);
		buttonReset.addActionListener(this);
		jpanel.add(buttonReset);
		
		buttonCrackPassword = new JButton("<html>Crack<br>Password</html>");
		buttonCrackPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		buttonCrackPassword.setHorizontalAlignment(SwingConstants.CENTER);
		buttonCrackPassword.setBounds(665, 46, 119, 54);
		buttonCrackPassword.addActionListener(this);
		jpanel.add(buttonCrackPassword);
		
		labelInformation = new JLabel("List of accounts with userid > 1000 and their passwords:");
		labelInformation.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		labelInformation.setBounds(10, 113, 380, 25);
		jpanel.add(labelInformation);
		
		defaultTableModel = new DefaultTableModel();
		tableOutput = new JTable(defaultTableModel);
		tableOutput.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tableOutput.setEnabled(false);
		scrollPaneOutput = new JScrollPane(tableOutput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneOutput.setBounds(9, 149, 774, 175);
		jpanel.add(scrollPaneOutput);
		
		labelExport = new JLabel("Output has been exported to src/files/output.txt");
		labelExport.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		labelExport.setBounds(10, 335, 380, 25);
		labelExport.setVisible(false);
		jpanel.add(labelExport);
		
		this.setTitle("ETHIHAC MP - PASSWORD CRACKER");
		this.setSize(800, 400);
		this.setContentPane(jpanel);		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		populateTable(null);
	}

	private void populateTable( Object[][] rows )
	{
		defaultTableModel = new DefaultTableModel(rows, columns);
		tableOutput.setModel(defaultTableModel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if( e.getSource() == buttonLinuxPassword )
		{
			chooseLinuxPasswordFile();
		}
		else if( e.getSource() == buttonShadowPassword )
		{
			chooseShadowPasswordFile();
		}
		else if( e.getSource() == buttonWorstPassword )
		{
			chooseWorstPasswordFile();
		}
		else if( e.getSource() == buttonReset )
		{
			textFieldLinuxPassword.setText("src/files/passwd.txt");
			textFieldShadowPassword.setText("src/files/shadow.txt");
			textFieldWorstPassword.setText("src/files/500-worst-passwords.txt");
			labelExport.setVisible(false);
		}
		else if( e.getSource() == buttonCrackPassword )
		{
			controller.readFile("Linux Password", textFieldLinuxPassword.getText().toString());
			controller.readFile("Shadow Password", textFieldShadowPassword.getText().toString());
			controller.readFile("Worst Password", textFieldWorstPassword.getText().toString());
			populateTable(controller.crackPassword());
			labelExport.setVisible(true);
		}
	}
	
	private boolean chooseLinuxPasswordFile()
	{
		JFileChooser chooser = new JFileChooser("src/files/");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(getParent());
		if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
			textFieldLinuxPassword.setText(chooser.getSelectedFile().getAbsolutePath());
			return true;
		}
		return false;
	}
	
	private boolean chooseShadowPasswordFile()
	{
		JFileChooser chooser = new JFileChooser("src/files/");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(getParent());
		if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
			textFieldShadowPassword.setText(chooser.getSelectedFile().getAbsolutePath());
			return true;
		}
		return false;
	}
	
	private boolean chooseWorstPasswordFile()
	{
		JFileChooser chooser = new JFileChooser("src/files/");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(getParent());
		if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
			textFieldWorstPassword.setText(chooser.getSelectedFile().getAbsolutePath());
			return true;
		}
		return false;
	}
}
