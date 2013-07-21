package core;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import utils.*;

public class Round implements Iterable<ScrabbleWord>
{
	/* ---------------------------------------------- *
	 * ----------------- Attributes ----------------- *
	 * ---------------------------------------------- */
	
	private List<ScrabbleWord> words;

	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	public Round()
	{
		words = new LinkedList<ScrabbleWord>();
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Setter methods ----------------- *
	 * -------------------------------------------------- */
	
	public Round add(ScrabbleWord word)
	{
		Toolbox.verifyObject(word, "word");
		
		words.add(word);
		
		return this;
	}
	
	public Round remove(ScrabbleWord word)
	{
		words.remove(word);
		
		return this;
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Getter methods ----------------- *
	 * -------------------------------------------------- */
	
	/* ------------------------------------------------------ *
	 * ----------------- Overriding methods ----------------- *
	 * ------------------------------------------------------ */
	
	@Override
	public Iterator<ScrabbleWord> iterator()
	{
		return words.iterator();
	}
	
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		
		for(ScrabbleWord word : words)
		{
			s.append(word);
		}
		
		return s.substring(0, s.length() - 2);
	}
}