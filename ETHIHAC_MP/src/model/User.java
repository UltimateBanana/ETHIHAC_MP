package model;

public class User
{
	private int userId;
	private String username;
	private HashingAlgorithm hashingAlgorithm;
	private String salt;
	private String hashedPassword;
	private String password;
	private long crackingTime;
	
	public User(int userId, String username, HashingAlgorithm hashingAlgorithm, String salt, String hashedPassword, String password)
	{
		super();
		this.userId = userId;
		this.username = username;
		this.hashingAlgorithm = hashingAlgorithm;
		this.salt = salt;
		this.hashedPassword = hashedPassword;
		this.password = password;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public HashingAlgorithm getHashingAlgorithm()
	{
		return hashingAlgorithm;
	}

	public void setHashingAlgorithm(HashingAlgorithm hashingAlgorithm)
	{
		this.hashingAlgorithm = hashingAlgorithm;
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}

	public String getHashedPassword()
	{
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword)
	{
		this.hashedPassword = hashedPassword;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public long getCrackingTime()
	{
		return crackingTime;
	}

	public void setCrackingTime(long crackingTime)
	{
		this.crackingTime = crackingTime;
	}

	public String toString()
	{
		return userId + " : " + username + " : " + hashingAlgorithm.toString() + " : " + salt + " : " + hashedPassword + " : " + password;
	}
}
