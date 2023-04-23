package edu.monmouth.CS176CS176L.s1338565.Connect4;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.util.Random;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;
import java.util.ArrayList;

public class Game
{
	public final static int ROWS = 6;
	public final static int COLS = 7;
	
	private final static int XLOC = 450;
	private final static int YLOC = 50;
	
	private HumanPlayer p1;

	private Player p2;

	public static Color currClr;
	
	private JTextField nameField;
	
	public static int win;
	
	private Timer t;
	
	private JFrame gameFrame;
	private JPanel primary;
	private JLabel northTitle;
	private JPanel northPanel;
	private JPanel southPanel;
	private JPanel southGrid;

	private JLabel p1Label;
	private JPanel p1Panel;
	private JLabel p2Label;
	private JPanel p2Panel;
	
	private DynamicGrid board;
	
	private Location[] moves;
	
	
	public Game()
	{
		win = 1;
		
		createComponents();
		configureComponents();
		mergeComponents();
		createPlayers();
		
		gameFrame.setVisible(true);
		
		//System.out.println(p1.getName() + " has the color" + p1.getColor().toString());
		//System.out.println(p2.getName() + " has the color" + p2.getColor().toString());
	
		playGame();	
	}

	//Private methods for building the game
	private void createComponents()
	{
		//Create
		gameFrame = new JFrame("Connect 4");
			
				
		primary = new JPanel(new BorderLayout());
		board = new DynamicGrid();
				
		//North Panel
		northTitle = new JLabel("Connect 4", JLabel.CENTER);
		northPanel = new JPanel();
				
		//South Panel
		southPanel = new JPanel();
		southGrid = new JPanel(new GridLayout(1,2, 100, 100));//1 row, 4 columns
		
		p1Label = new JLabel("P1" , JLabel.CENTER); 
		p1Panel = new JPanel();
		p2Label = new JLabel("P2" , JLabel.CENTER);
		p2Panel = new JPanel();
		
		//Grid Panel
		
	}
	
	private void configureComponents()
	{
		//Frame
		gameFrame.setSize(800, 750);
		gameFrame.setLocation(XLOC, YLOC);
		
		//Primary
		primary.setBackground(Color.BLUE);
		
		
		//SGrid
		southPanel.setBackground(Color.CYAN);
		southGrid.setBackground(Color.BLUE);
		
		p1Panel.setBackground(Color.LIGHT_GRAY);
		p2Panel.setBackground(Color.LIGHT_GRAY);
		
		
		//NorthPanel
		northPanel.setBackground(Color.CYAN);
		
	}
	
	private void mergeComponents()
	{
		//Frame
		gameFrame.add(primary);
		
		//DynamicGrid

		primary.add(board, BorderLayout.CENTER);

		//NorthPanel
		northPanel.add(northTitle);
		primary.add(northPanel, BorderLayout.NORTH);
		
		//SouthGrid
		southPanel.add(southGrid);
		primary.add(southPanel, BorderLayout.SOUTH);
		
		p1Panel.add(p1Label);
		southGrid.add(p1Panel);
		
		p2Panel.add(p2Label);
		southGrid.add(p2Panel);
	}
	
	private void createPlayers()
	{
		p1 = new HumanPlayer("Player 1 ");
		
		while(!p1.getInit())
		{
			System.out.flush();//Why does this work?
		}
		
		int choice = JOptionPane.showConfirmDialog(null,
				"Is the 2nd Player a Human?" ,
				"Player Type" , JOptionPane.YES_NO_OPTION , 
				JOptionPane.QUESTION_MESSAGE);
	
		
		if(choice == JOptionPane.YES_OPTION)
		{
			p2 = new HumanPlayer("Player 2");
		}
		else if(choice == JOptionPane.NO_OPTION)
		{
			choice = JOptionPane.showConfirmDialog(null,
					"Play against an easy CPU?" ,
					"CPU Strength" , JOptionPane.YES_NO_OPTION , 
					JOptionPane.QUESTION_MESSAGE);
			
			if(choice == JOptionPane.YES_OPTION)
			{
				p2 = new ComputerPlayer("Easy CPU ", 0.2);
			}
			else if(choice == JOptionPane.NO_OPTION)
			{
				p2 = new ComputerPlayer("Tough CPU ", 0.8);
			}
		}
		
		double rand = Math.random();
		
		//Generate Colors
		if(rand < 0.5)
		{
			p1.setColor(Color.RED); 
			p2.setColor(Color.YELLOW);
		}
		else
		{
			p1.setColor(Color.YELLOW);
			p2.setColor(Color.RED);
		}
		

		while(!p2.getInit())
		{
			System.out.flush();//Why does this work?
		}
		
		p1Label.setText(p1.getName());
		p2Label.setText(p2.getName());	
	}
	
	//The game
	private void playGame()
	{
		double rand = Math.random();
		boolean turn;
		boolean gameOver = false;
		
		//Random roll to determine first player
		if(rand < 0.5)
			turn = true;
		else
			turn = false;
		
		while(!board.isGameOver())
		{
			p1Panel.setBackground(Color.LIGHT_GRAY);
			p2Panel.setBackground(Color.LIGHT_GRAY);
			if(turn)//true, p1 moves
			{
				p1Panel.setBackground(p1.getColor());
				currClr = p1.getColor();
				
				DynamicGrid.computerMoving = false;

				while(!DynamicGrid.movePlayed)
				{
					System.out.flush();//Why does this work?
				}
				DynamicGrid.movePlayed = false;
				
				turn = !turn;
			}
			else//false, p2 moves
			{
				p2Panel.setBackground(p2.getColor());
				if(p2.getType().equals("h"))//Another person
				{
					currClr = p2.getColor();
					
					while(!DynamicGrid.movePlayed)
					{
						System.out.flush();//Why does this work?
					}

					DynamicGrid.movePlayed = false;
				}
				else if(p2.getType().equals("c"))//Computer
				{
					DynamicGrid.computerMoving = true;
					
					currClr = p2.getColor();
					
					ArrayList <Location> moves = board.getAvailableMoves();
				
					Location[] movesArr = new Location[moves.size()];
					
					for(int x = 0 ; x < moves.size(); x++)
					{
						movesArr[x] = moves.get(x);
					}
					
					Location best = board.getBestMove(p2.getColor() , movesArr);
				
					Location m = p2.makeMove(movesArr, best);
					
					board.updateGameBoard(m);
				}
				

				turn = !turn;
			}
			
		}
		
		if(DynamicGrid.tie == true)
		{
			JOptionPane.showMessageDialog(null, "Tie", "Oh no, no one has won! :("
					, JOptionPane.INFORMATION_MESSAGE);
		}
		else if(DynamicGrid.winningColor.equals(p1.getColor()))
		{
			JOptionPane.showMessageDialog(null, "Victory", p1.getName() + " has won! :)"
					, JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Victory", p2.getName() + " has won! :)"
					, JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
