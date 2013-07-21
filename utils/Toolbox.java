package utils;

import core.MasterControlProgram;

public class Toolbox
{

	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	private Toolbox(){}
	
	/* -------------------------------------------------- *
	 * ----------------- Static methods ----------------- *
	 * -------------------------------------------------- */
	
	public static void verifyObject(Object o, String objectName) throws ScrabbleException
	{
		if(o == null)
		{
			throw new ScrabbleException(objectName + " is null!");
		}
	}
	
	public static void verifyString(String s, String stringName) throws ScrabbleException
	{
		if(s == null)
		{
			throw new ScrabbleException(stringName + " is null!");
		}
		else if(s.length() == 0)
		{
			throw new ScrabbleException(stringName + " is empty!");
		}
	}
	
	public static void verifyNatural(int n, String numberName) throws ScrabbleException
	{
		if(n <= 0)
		{
			throw new ScrabbleException(numberName + " is not natural");
		}
	}
	
	public static void verifyMasterControlProgram(MasterControlProgram mcp)
	{
		if(mcp == null)
		{
			System.exit(1);
		}
	}
}