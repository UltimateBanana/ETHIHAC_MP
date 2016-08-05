package model;

public enum HashingAlgorithm
{
	Null, MD5, BlowFish, SHA256, SHA512;
	
	public static HashingAlgorithm getHashingAlgorithm( String hashType )
	{
		switch( hashType )
		{
			case "1": return MD5;
			case "2":
			case "2a": return BlowFish;
			case "5": return SHA256;
			case "6": return SHA512;
			default: return Null;
		}
	}
}
