package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;

import core.MasterControlProgram;
import core.Game;

import utils.Toolbox;

/**
 * 
 * @author Daniel Lerps
 * @version v1.1
 */
public class PlayerPanel extends JPanel
{
	/* ---------------------------------------------------- *
	 * ----------------- Static Constants ----------------- *
	 * ---------------------------------------------------- */
	
	/**
	 * For Serialisation.
	 */
	private static final long serialVersionUID = -2342054254577701L;
	
	/* --------------------------------------------- *
	 * ----------------- Constants ----------------- *
	 * --------------------------------------------- */

	private final MasterControlProgram MCP;
	
	/* ---------------------------------------------- *
	 * ----------------- Attributes ----------------- *
	 * ---------------------------------------------- */
	
	private DefaultListModel<Game.Player> players;

	private JButton btnAddPlayer;
	private JButton btnRemovePlayer;
	private JButton btnStart;
	
	private JList<Game.Player> playerList;
	
	/* ------------------------------------------------ *
	 * ----------------- Constructors ----------------- *
	 * ------------------------------------------------ */
	
	public PlayerPanel(MasterControlProgram mcp)
	{
		Toolbox.verifyMasterControlProgram(mcp);
		
		MCP = mcp;
		
		setLayout(new BorderLayout());
		
		initButtonArea();
		initPlayerList();
		
		setPreferredSize(new Dimension(175, 300));
	}
	
	/* -------------------------------------------------- *
	 * ----------------- Public methods ----------------- *
	 * -------------------------------------------------- */
	
	public PlayerPanel setButtonsEnabled(boolean b)
	{
		btnRemovePlayer.setEnabled(b);
		btnAddPlayer.setEnabled(b);
		btnStart.setEnabled(b);
		
		return this;
	}
	
	/* --------------------------------------------------- *
	 * ----------------- Private methods ----------------- *
	 * --------------------------------------------------- */
	
	private void initButtonArea()
	{
		JPanel buttonArea = new JPanel();
		
		btnAddPlayer = new JButton("+");
		btnRemovePlayer = new JButton("-");
		btnStart = new JButton("Start");
		
		buttonArea.add(btnAddPlayer, BorderLayout.WEST);
		buttonArea.add(btnStart, BorderLayout.CENTER);
		buttonArea.add(btnRemovePlayer, BorderLayout.EAST);
		
		// remove button listener
		btnRemovePlayer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				// only if there is a selection
				if(playerList.getSelectedIndex() != -1)
				{
					Game.Player onDeathRow = playerList.getSelectedValue();
					
					if(onDeathRow != Game.ALL_PLAYERS)
					{
						MCP.getGame().remove(onDeathRow);
						players.removeElement(onDeathRow);
					}
				}
			}
		});
		
		// add button listener
		btnAddPlayer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				createPlayer();
			}
		});
		
		btnStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				setButtonsEnabled(false);
				MCP.getGame().startGame();
			}
		});
		
		// add to panel
		add(buttonArea, BorderLayout.SOUTH);
	}
	
	private void initPlayerList()
	{
		players = new DefaultListModel<Game.Player>();
		players.addElement(Game.ALL_PLAYERS);
		
		playerList = new JList<Game.Player>();
		playerList.setModel(players);
		
		// set selection listener
		playerList.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent lse)
			{
				MCP.getMainFrame().setSelectedPlayer(playerList.getSelectedValue());
			}
		});
		
		// add to panel
		add(new JScrollPane(playerList), BorderLayout.CENTER);
	}
	
	private void createPlayer()
	{
		String name = JOptionPane.showInputDialog(MCP.getMainFrame(), "Enter Player Name", 
				"New Player", JOptionPane.PLAIN_MESSAGE);
		
		if(name != null && !name.equals(""))
		{
			Game.Player player = new Game.Player(name);
			
			if(!MCP.getGame().contains(player))
			{
				MCP.getGame().add(player);
				players.addElement(player);
			}
			else
			{
				JOptionPane.showMessageDialog(MCP.getMainFrame(), "Player already exists!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(MCP.getMainFrame(), "Please enter a name!", "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
}