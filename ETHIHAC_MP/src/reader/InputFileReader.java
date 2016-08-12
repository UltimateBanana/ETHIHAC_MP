package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFileReader
{
	public static ArrayList<String> read( String filename )
	{
		ArrayList<String> fileContents = new ArrayList<>(0);
		
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			
			String line = in.readLine();
			while( line != null )
			{
				fileContents.add(line);
				line = in.readLine();
			}
			
			in.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileContents;
	}
}
