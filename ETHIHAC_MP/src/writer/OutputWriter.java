package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.User;

public class OutputWriter
{
	public static void write( ArrayList<User> accounts )
	{
		BufferedWriter bufferedWriter = null;
		
		try
		{
			bufferedWriter = new BufferedWriter(new FileWriter("src/files/output.txt"));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for( int i = 0; i < accounts.size(); i++ )
		{
			try
			{
				bufferedWriter.write("UserID   : " + accounts.get(i).getUserId() + " ");
				bufferedWriter.newLine();
				bufferedWriter.write("Username : " + accounts.get(i).getUsername() + " ");
				bufferedWriter.newLine();
				bufferedWriter.write("Password : " + accounts.get(i).getPassword() + " ");
				bufferedWriter.newLine();
				bufferedWriter.newLine();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		try
		{
			bufferedWriter.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
