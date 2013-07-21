package gui;

import utils.*;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.GridLayout;

import core.MasterControlProgram;
import core.Game;

/**
 * 
 * 
 * @author Daniel Lerps
 * @version v1.0
 */
public class ScrabbliserMainFrame extends JFrame
{
	/* --------------------------------------------- *
	 * ----------------- Static Constants ----------------- *
	 * --------------------------------------------- */

	/**
	 * For serialisation.
	 */
	private static final long serialVersionUID = 4086530624667658020L;
	
	/* --------------------------------------------- *
	 * ----------------- Constants ----------------- *
	 * --------------------------------------------- */

	private final MasterControlProgram MCP;
	
	/* ---------------------------------------------- *
	 * ----------------- Attributes ----------------- *
	 * ---------------------------------------------- */
	
	private JMenuItem menuNewGame;
	private JMenuItem menuExportXLS;
	private JMenuItem menuExportText;
	private JMenuItem menuExit;
	private JMenuItem menuAbout;
	
	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	public ScrabbliserMainFrame(MasterControlProgram mcp)
	{
		Toolbox.verifyMasterControlProgram(mcp);
		
		MCP = mcp;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(MasterControlProgram.APP_NAME + " " + MasterControlProgram.APP_VERSION);
		setLayout(new GridLayout(1, 3));
		
		initMenu();
		
		add(new PlayerPanel(MCP));
		
		pack();
		setVisible(true);
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Public methods ----------------- *
	 * -------------------------------------------------- */
	
	public ScrabbliserMainFrame setSelectedPlayer(Game.Player player)
	{
		if(player != null)
		{
			// TODO update lists
		}
		
		return this;
	}
	
	/* --------------------------------------------------- *
	 * ----------------- Private methods ----------------- *
	 * --------------------------------------------------- */
	
	private void initMenu()
	{
		// menu items
		menuNewGame = new JMenuItem("New Game");
		menuExportXLS = new JMenuItem("Export XLS");
		menuExportText = new JMenuItem("Export Text File");
		menuExit = new JMenuItem("Exit");
		menuAbout = new JMenuItem("About");
		
		// menus
		JMenu menuFile = new JMenu("File");
		JMenu menuHelp = new JMenu("Help");
		
		menuFile.add(menuNewGame);
		menuFile.addSeparator();
		menuFile.add(menuExportText);
		menuFile.add(menuExportXLS);
		menuFile.addSeparator();
		menuFile.add(menuExit);
		
		menuHelp.add(menuAbout);
		
		// menu bar
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		
		// mnemonics
		menuFile.setMnemonic('f');
		menuNewGame.setMnemonic('n');
		menuExportText.setMnemonic('t');
		menuExportXLS.setMnemonic('x');
		menuExit.setMnemonic('e');
		menuHelp.setMnemonic('h');
		menuAbout.setMnemonic('a');
		
		setJMenuBar(menuBar);
	}
}