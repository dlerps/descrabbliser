package core;

import gui.ScrabbliserMainFrame;

public class MasterControlProgram
{
	/* ---------------------------------------------------- *
	 * ----------------- Static Constants ----------------- *
	 * ---------------------------------------------------- */
	
	public static String APP_NAME = "De-Scrabbliser";
	public static String APP_VERSION = "v0.1 beta";
	
	/* ---------------------------------------------- *
	 * ----------------- Attributes ----------------- *
	 * ---------------------------------------------- */
	
	private Game game;
	
	private ScrabbliserMainFrame mainFrame;
	
	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	private MasterControlProgram()
	{
		game = new Game();
		mainFrame = new ScrabbliserMainFrame(this);
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Getter methods ----------------- *
	 * -------------------------------------------------- */
	
	public Game getGame()
	{
		return game;
	}
	
	public ScrabbliserMainFrame getMainFrame()
	{
		return mainFrame;
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Static methods ----------------- *
	 * -------------------------------------------------- */
	
	public static void main(String[] args)
	{
		new MasterControlProgram();
	}
}