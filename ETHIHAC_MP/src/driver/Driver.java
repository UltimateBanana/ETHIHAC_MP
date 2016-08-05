package driver;

import java.util.ArrayList;

import model.InputFileReader;
import model.User;
import model.UserHandler;

public class Driver
{
	public static void main(String[] args)
	{
		ArrayList<String> worstPasswords = InputFileReader.read("500-worst-passwords.txt");
		ArrayList<String> usernames = InputFileReader.read("passwd.txt");
		ArrayList<String> passwords = InputFileReader.read("shadow.txt");
		ArrayList<User> userAccounts = new ArrayList<>(0);
		
		for( int i = 0; i < usernames.size(); i++ )
		{
			userAccounts.add(UserHandler.createUser(usernames.get(i), passwords.get(i)));
		}
		
		for( int i = 0; i < userAccounts.size(); i++ )
		{
			System.out.println(userAccounts.get(i));
		}
	}
}
