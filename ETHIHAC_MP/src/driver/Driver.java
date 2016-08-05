package driver;

import java.awt.EventQueue;

import view.MainGUI;

public class Driver {

	public static void main(String[] args) 
	{
		
		
		final String output = "BANANANA"; // output of the PasswordFinder
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainGUI window = new MainGUI(output);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
