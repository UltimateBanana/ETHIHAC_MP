package controller;

import java.util.ArrayList;

import handler.PasswordHandler;
import handler.UserHandler;
import model.User;
import reader.InputFileReader;
import writer.OutputWriter;

public class Controller
{
	ArrayList<String> usernames;
	ArrayList<String> passwords;
	ArrayList<String> worstPasswords;
	ArrayList<User> userAccounts;
	
	public Controller()
	{
		usernames = new ArrayList<>(0);
		passwords = new ArrayList<>(0);
		worstPasswords = new ArrayList<>(0);
		userAccounts = new ArrayList<>(0);
	}
	
	public void readFile( String source, String filename )
	{
		if( source.equalsIgnoreCase("Linux Password") )
		{
			usernames = InputFileReader.read(filename);
		}
		else if( source.equalsIgnoreCase("Shadow Password") )
		{
			passwords = InputFileReader.read(filename);
		}
		else if( source.equalsIgnoreCase("Worst Password") )
		{
			worstPasswords = InputFileReader.read(filename);
		}
	}
	
	public Object[][] crackPassword()
	{
		ArrayList<User> crackedAccounts = new ArrayList<>(0);
		
		assembleUserAccounts();
		PasswordHandler.findPassword(userAccounts, worstPasswords);
		
		for( int i = 0; i < userAccounts.size(); i++ )
		{
			if( userAccounts.get(i).getUserId() >= 1000  )
			{
				if( userAccounts.get(i).getPassword() == null )
				{
					User user = userAccounts.get(i);
					user.setPassword("Password Not Found");
				}
				
				crackedAccounts.add(userAccounts.get(i));
			}
		}
		
		write(crackedAccounts);
		
		return convertTo2dObjectArray(crackedAccounts);
	}
	
	public void write( ArrayList<User> accounts )
	{
		OutputWriter.write(accounts);
	}
	
	private void assembleUserAccounts()
	{
		for( int i = 0; i < usernames.size(); i++ )
		{
			userAccounts.add(UserHandler.createUser(usernames.get(i), passwords.get(i)));
		}
	}
	
	private Object[][] convertTo2dObjectArray( ArrayList<User> crackedAccounts )
	{
		Object[][] rows = new Object[crackedAccounts.size()][4];
		
		for( int i = 0; i < crackedAccounts.size(); i++ )
		{
			rows[i][0] = crackedAccounts.get(i).getUserId();
			rows[i][1] = crackedAccounts.get(i).getUsername();
			rows[i][2] = crackedAccounts.get(i).getPassword();
			rows[i][3] = crackedAccounts.get(i).getCrackingTime() + " ms";
		}
		
		return rows;
	}
}
