package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordFinder {

	public static void main(String[] args)
	{
		// Hashed MD2
		char[] hexed = DigestUtils.md2Hex("16265").toCharArray();
		System.out.println(DigestUtils.md2Hex("16265"));
		
		// Unhashed Md2
		try 
		{
//			byte[] temp = Hex.decodeHex(hexed);
			byte[] temp = DigestUtils.md2("16265".getBytes());
			String temp1 = new String(temp);
			
			System.out.println("md2 Hash: " + temp1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// BASE 64
		String toEncode = "This text will be encoded in base64 and then decoded back again";
        
        Base64 base64 = new Base64();
        String encoded = new String(base64.encode(toEncode.getBytes()));
        
        System.out.println(encoded);
        
        String decoded = new String(base64.decode(encoded.getBytes()));
        
        System.out.println(decoded);
        
        
        
        //MessageDigest
	}
	
	public void FileReader()
	{
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader("500-worst-passwords.txt"));
			
			String line;
			while((line = in.readLine()) != null)
			{
			    System.out.println(line);
			}
			in.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void HashingDecrypt()
	{
		
	}
}
