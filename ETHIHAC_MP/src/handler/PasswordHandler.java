package handler;

import java.util.ArrayList;

import org.apache.commons.codec.digest.Crypt;

import model.HashingAlgorithm;
import model.User;

public class PasswordHandler
{
	public static void findPassword( ArrayList<User> users, ArrayList<String> passwords )
	{
		for( int i = 0; i < users.size(); i++ )
		{
			if( users.get(i).getUserId() >= 1000 && users.get(i).getHashingAlgorithm() != HashingAlgorithm.Null )
			{
				long startTime = System.nanoTime();
				users.get(i).setPassword(matchEncrypt(users.get(i).getSalt(), users.get(i).getHashedPassword(), passwords));
				long endTime = System.nanoTime();
				
				users.get(i).setCrackingTime((endTime - startTime) / 1000000);
			}
		}
	}
	
	private static String matchEncrypt( String salt, String hashedPassword, ArrayList<String> passwords )
	{
		for( int i = 0; i < passwords.size(); i++ )
		{
			if( hashedPassword.equals(Crypt.crypt(passwords.get(i), salt)) )
			{
				return passwords.get(i);
			}
		}
		
		return null;
	}
}
