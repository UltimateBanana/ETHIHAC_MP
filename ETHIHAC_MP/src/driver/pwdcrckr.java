package driver;

import controller.Controller;
import view.MainGUI;

public class pwdcrckr
{
	public static void main(String[] args)
	{
		Controller controller = new Controller();
		MainGUI mainGUI = new MainGUI(controller);
	}
}
