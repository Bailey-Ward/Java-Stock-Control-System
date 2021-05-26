package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A helper class to enable input of data from the keyboard ensuring exceptions are handled here.
 * 
 * @author 253737
 *
 */
public class KeyboardReader {
	
	private Scanner kbr;
	
	/**
	 * Constructor -  instantiate a scanner
	 */
	public KeyboardReader()
	{
		kbr = new Scanner(System.in);
	}
	
	
	/**
	 * Should only be used when we no longer need the reader
	 */
	public void close()
	{
		kbr.close();
	}
	
	/**
	 * Parses the input string to an integer - only accepts valid integers.
	 * 
	 * @param mes - message to display to the user
	 * @return - Integer entered by the user
	 */
	public int getInt(String mes)
	{
		int retv = 0;
		boolean valid = false;
		
		
		while (!valid)
		{
			try
			{
				System.out.print(mes +": ");
				String input = kbr.nextLine();
				retv = Integer.parseInt(input);
				valid = true;
			}
			catch (NumberFormatException ex)
			{
				//ex.printStackTrace();
				//System.out.println(ex.getMessage());
				System.out.println("Please enter a valid Integer");
			}
		}
		
		return retv;
	}
	
	
	/**
	 * Ensures an integer is between the specified ranges.
	 * 
	 * @param mes - message to display to the user
	 * @param min - minimum accepted integer
	 * @param max - maximum accepted integer
	 * @return - Integer entered by the user
	 */
	public int getInt(String mes, int min, int max)
	{
		int retv = 0;
		boolean valid = false;
		
		while (!valid)
		{
			retv = getInt(mes);
			if (retv >= min && retv <= max)
				valid = true;
			else
			{
				System.out.println("Please enter an Integer between " + min + " and " + max);
			}
		}	
		return retv;
	}
	
	/**
	 * Get an option entered by the user from a selection of valid options.
	 * 
	 * @param mes - Message to display.
	 * @param options - List of valid options
	 * @return - Option entered by the user, can only be those in the options list
	 */
	public String getChoice(String mes, ArrayList<String> options)
	{
		String retv = null;
		boolean valid = false;
		
		// could sort the options so they are easier to read
		Collections.sort(options);
		
		while (!valid)
		{
			System.out.println(mes);
			
			for (String s : options)
			{
				System.out.println("\t" + s);
			}
			System.out.print("Choice : ");
			retv = kbr.nextLine();
			if (options.contains(retv))
			{
				valid = true;
			}
			else
			{
				System.out.println("### Please ensure you select a valid option from the list ###");
			}
		}
		return retv;
	}

	public String getString(String mes)
	{
		System.out.print(mes +": ");
		// note this allows empty strings!
		return kbr.nextLine();
	}


public float getFloat(String mes)
{
	float retv = 0;
	boolean valid = false;
	
	
	while (!valid)
	{
		try
		{
			System.out.print(mes +": ");
			String input = kbr.nextLine();
			retv = Float.parseFloat(input);
			valid = true;
		}
		catch (NumberFormatException ex)
		{
			//ex.printStackTrace();
			//System.out.println(ex.getMessage());
			System.out.println("Please enter a valid decimal number");
		}
	}
	
	return retv;
}
}