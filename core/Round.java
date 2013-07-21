package core;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import utils.*;

/**
 * <p>One round in a Scrabble game.</p>
 * 
 * <p>A round can contain several ScrableWords and always belongs to 
 * the Player.</p>
 * 
 * @author Daniel Lerps
 * @version v1.11
 */
public class Round implements Iterable<ScrabbleWord>
{
	/* ---------------------------------------------- *
	 * ----------------- Attributes ----------------- *
	 * ---------------------------------------------- */
	
	private List<ScrabbleWord> words;

	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	/**
	 * Initialises a new blank Round.
	 */
	public Round()
	{
		words = new LinkedList<ScrabbleWord>();
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Setter methods ----------------- *
	 * -------------------------------------------------- */
	
	/**
	 * <p>Adds a new ScrabbleWord to the Round</p>
	 * 
	 * <p>The input must not be <code>null</code></p>
	 * 
	 * @param word The ScrabbleWord
	 * @return <code>this</code>
	 */
	public Round add(ScrabbleWord word)
	{
		Toolbox.verifyObject(word, "word");
		
		words.add(word);
		
		return this;
	}
	
	/**
	 * <p>Removes a given ScrabbleWord from the Round.</p>
	 * 
	 * @param walkingDead The ScrabbleWord which will be removed
	 * @return <code>this</code>
	 */
	public Round remove(ScrabbleWord walkingDead)
	{
		words.remove(walkingDead);
		
		return this;
	}
	
	/**
	 * <p>Removes a given ScrabbleWord from the Round at a given index.</p>
	 * 
	 * @param walkingDead The indexof the word which will be removed
	 * @return <code>this</code>
	 */
	public Round remove(int markedForDeath)
	{
		words.remove(markedForDeath);
		
		return this;
	}
	
	/**
	 * <p>Removes all ScrabbleWords from the round</p>
	 * 
	 * @return Empties the Round
	 */
	public Round clear()
	{
		words.clear();
		
		return this;
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Getter methods ----------------- *
	 * -------------------------------------------------- */
	
	/**
	 * <p>Tells if the Round contains a specific ScrabbleWord.</p>
	 * 
	 * @param word The woord
	 * @return Is the word in the Round?
	 */
	public boolean contains(ScrabbleWord word)
	{
		return words.contains(word);
	}
	
	/**
	 * <p>Sums up all single scores of the ScrabbleWords in this 
	 * Round.</p>
	 * 
	 * @return The overall score of this round
	 */
	public int getRoundScore()
	{
		int score = 0;
		
		for(ScrabbleWord word : words)
		{
			score += word.getScore();
		}
		
		return score;
	}
	
	/**
	 * <p>Gives the ScrabbleWord at a specific index of this 
	 * Round.</p>
	 * 
	 * <p>If an invalid index is given <code>null</code> is 
	 * retuned.</p>
	 * 
	 * @param index The index of the ScrabbleWord
	 * @return The word
	 */
	public ScrabbleWord get(int index)
	{
		try
		{
			return words.get(index);
		}
		catch(IndexOutOfBoundsException ioobe)
		{
			System.err.println(ioobe.getMessage());
		}
		
		return null;
	}
	
	/* ------------------------------------------------------ *
	 * ----------------- Overriding methods ----------------- *
	 * ------------------------------------------------------ */
	
	/**
	 * Gives an iterator of all ScrabbleWords.
	 * 
	 * @return Iterator of ScrabbleWords
	 * @see java.lang.Iterable
	 * @see java.util.Iterator
	 */
	@Override
	public Iterator<ScrabbleWord> iterator()
	{
		return words.iterator();
	}
	
	/**
	 * <p>Gives a descriptive String of the Round.</p>
	 * 
	 * <p>The String contains all ScrabbleWords in separate 
	 * rows.</p>
	 * 
	 * @return String with words
	 * @see java.lang.Object#toString()
	 */
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