package core;

import utils.*;

public class ScrabbleWord
{
	/* ---------------------------------------------- *
	 * ----------------- Attributes ----------------- *
	 * ---------------------------------------------- */
	
	private int points;
	
	private String word;

	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	public ScrabbleWord(String scWord)
	{
		this(scWord, 0);
	}
	
	public ScrabbleWord(String scWord, int pointCount)
	{
		Toolbox.verifyString(scWord, "scWord");
		Toolbox.verifyNatural(pointCount, "pointCount");
		
		word = scWord;
		points = pointCount;
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Setter methods ----------------- *
	 * -------------------------------------------------- */
	
	public ScrabbleWord setWord(String scWord)
	{
		Toolbox.verifyString(scWord, "scWord");
		
		word = scWord;
		
		return this;
	}
	
	public ScrabbleWord setScore(int pointCount)
	{
		Toolbox.verifyNatural(pointCount, "pointCount");
		
		points = pointCount;
		
		return this;
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Getter methods ----------------- *
	 * -------------------------------------------------- */
	
	public int getScore()
	{
		return points;
	}
	
	public String getWord()
	{
		return word;
	}
	
	/* ------------------------------------------------------ *
	 * ----------------- Overriding methods ----------------- *
	 * ------------------------------------------------------ */
	
	@Override
	public String toString()
	{
		return word;
	}
}