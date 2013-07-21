package core;

import utils.*;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * <p>A Game represents a single game with multiple Rounds and
 * a number of Players.</p>
 * 
 * @author Daniel Lerps
 * @version v1.0
 */
public class Game
{
	/* ---------------------------------------------------- *
	 * ----------------- Static Constants ----------------- *
	 * ---------------------------------------------------- */
	
	public static Player ALL_PLAYERS = new Player("All Players");
	
	/* ---------------------------------------------- *
	 * ----------------- Attributes ----------------- *
	 * ---------------------------------------------- */
	
	private boolean started;
	
	private Map<Player, List<Round>> scoreTable;

	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	public Game()
	{
		started = false;
		scoreTable = new HashMap<Player, List<Round>>(3);
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Setter methods ----------------- *
	 * -------------------------------------------------- */
	
	public Game startGame()
	{
		started = true;
		
		return this;
	}
	
	public Game add(Player player, Round round)
	{
		if(started && scoreTable.containsKey(player) && round != null)
		{
			scoreTable.get(player).add(round);
		}
		
		return this;
	}
	
	public Game add(Player player)
	{
		if(!started && !scoreTable.containsKey(player) && 
				player != null && player != ALL_PLAYERS)
		{
			scoreTable.put(player, new LinkedList<Round>());
		}
		
		return this;
	}
	
	public Game remove(Player cursed)
	{
		if(!started && cursed != null)
		{
			scoreTable.remove(cursed);
		}
		
		return this;
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Getter methods ----------------- *
	 * -------------------------------------------------- */
	
	public boolean isStarted()
	{
		return started;
	}
	
	public boolean contains(Player player)
	{
		return scoreTable.containsKey(player);
	}
	
	public int getPlayerScore(Player player)
	{
		int score = 0;
		
		if(scoreTable.containsKey(player))
		{
			for(Round round : scoreTable.get(player))
			{
				score += round.getRoundScore();
			}
		}
		
		return score;
	}
	
	public List<ScrabbleWord> getAllWords(Player player)
	{
		List<ScrabbleWord> playerWords = null;
		
		if(started && scoreTable.containsKey(player))
		{
			playerWords = new ArrayList<ScrabbleWord>(scoreTable.get(player).size() * 2);
			
			for(Round round : scoreTable.get(player))
			{
				for(ScrabbleWord word : round)
				{
					playerWords.add(word);
				}
			}
		}
		
		return playerWords;
	}
	
	public List<ScrabbleWord> getAllWords()
	{
		List<ScrabbleWord> allWords = new ArrayList<ScrabbleWord>();
		
		if(started)
		{
			for(Player player : scoreTable.keySet())
			{
				allWords.addAll(getAllWords(player));
			}
		}
		
		return allWords;
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Nested Classes ----------------- *
	 * -------------------------------------------------- */
	
	public static class Player
	{
		public final String NAME;
		
		public Player(String playerName)
		{
			Toolbox.verifyString(playerName, "playerName");
			NAME = playerName;
		}
		
		@Override
		public int hashCode()
		{
			return NAME.hashCode();
		}
		
		@Override
		public boolean equals(Object o)
		{
			return (o != null && o instanceof Player) ? ((Player) o).NAME.equals(NAME) : false;
		}
		
		@Override
		public String toString()
		{
			return NAME;
		}
	}
}