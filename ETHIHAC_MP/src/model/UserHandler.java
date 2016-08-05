package model;

public class UserHandler
{
	public static User createUser( String usernameUnprocessed, String passwordUnprocessed )
	{
		String[] username = usernameUnprocessed.split(":");
		String[] password = passwordUnprocessed.split(":");
		String[] passwordHash = password[1].split(java.util.regex.Pattern.quote("$"));
		String salt = "";
		String hashedPassword = "";
		HashingAlgorithm hash;
		
		if( passwordHash.length == 1 )
		{
			salt = hashedPassword = passwordHash[0];
			hash = HashingAlgorithm.Null;
		}
		else
		{
			hash = HashingAlgorithm.getHashingAlgorithm(passwordHash[1]);
			salt = passwordHash[2];
			hashedPassword = passwordHash[3];
		}
		
		return new User(Integer.parseInt(username[2]), 
			           username[0], 
			           hash, 
			           salt, 
			           hashedPassword, 
			           "");
	}
}
