package core;

import utils.*;

import java.util.Map;
import java.util.HashMap;

public class Game
{
	/* ---------------------------------------------- *
	 * ----------------- Attributes ----------------- *
	 * ---------------------------------------------- */
	
	private boolean started;
	
	private Map<Player, Round> scoreTable;

	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
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