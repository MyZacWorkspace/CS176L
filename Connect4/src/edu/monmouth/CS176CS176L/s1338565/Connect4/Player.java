package edu.monmouth.CS176CS176L.s1338565.Connect4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * abstract layout of a player
 */
abstract class Player implements KeyListener
{
	private String name;
	private JTextField nameField;
	private JFrame promptFrame;
	boolean init = false;
	
	Color clr;
	
	private final static int XLOC = 450;
	private final static int YLOC = 50;
	
	public Player(String label)
	{
		generateNameField(label);
	}
	
	public boolean getInit()
	{
		return init;
	}
	
	
	public void setColor(Color c)
	{
		clr = c;
	}
	public Color getColor()
	{
		return clr;
	}
	
	public String getName()
	{
		return name;
	}
	
	private void generateNameField(String s)
	{
		promptFrame = new JFrame("Enter a name for " + s);
		promptFrame.setSize(600, 200);
		promptFrame.setLocation(XLOC + 200, YLOC + 200);
		
		JPanel promptPanel = new JPanel(new GridLayout(1,2));
		nameField = new JTextField();
		JTextField promptField = new JTextField("Press 'Enter' to continue");
		
		promptField.setEditable(false);
		nameField.addKeyListener(this);
		promptPanel.add(nameField);
		promptPanel.add(promptField);
		promptFrame.add(promptPanel);
		promptFrame.setVisible(true);
	}
	
	
	
	//Key Events
	public void keyPressed(KeyEvent e)
	{
		int type = e.getKeyCode();
		
		if(type == KeyEvent.VK_ENTER)
		{
			name = nameField.getText();
			
			promptFrame.setEnabled(false);
			promptFrame.setVisible(false);
			init = true;
		}
	}
	public void keyReleased(KeyEvent e)
	{

	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	public abstract String getType();

	public abstract Location makeMove(Location[] movesArr, Location best);
}
