package edu.monmouth.CS176CS176L.s1338565.Connect4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * DynamicGrid
 */

public class DynamicGrid extends JComponent implements MouseListener
{
	private final int AVGDELTAX = 88;
	private final int AVGDELTAY = 84;
	private final int XBOUND = 45;
	private final int YBOUND = 27;
	
	public static boolean movePlayed = false;
	public static boolean computerMoving = false;
	public static boolean tie = false;
	public static Color winningColor;
	
	
	DynamicPiece[][] board = new 
			DynamicPiece[Game.ROWS][Game.COLS];
	
	
	public DynamicGrid()
	{	
		for(int r = 0 ; r < Game.ROWS ; r++)
		{
			for(int c = 0 ; c < Game.COLS ; c++)
			{	
				board[r][c] = new DynamicPiece(new Location(r,c), Color.WHITE);
			}
		}
		addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		int yMod = 0;
		int xMod = 0;
		
		for(int r = 0 ; r < Game.ROWS ; r++)
		{
			
			for(int c = 0 ; c < Game.COLS ; c++)
			{		
				g2.setColor(Color.BLACK);
				g2.draw(board[r][c]);
				g2.setColor(board[r][c].getColor());
				g2.fill(board[r][c]);
			}
		}
	}
	
	
	public void updateGameBoard(Location l)
	{
		//Have game method to return current player, get current color
		board[l.getRow()][l.getCol()].setColor(Game.currClr);
		repaint();
	}

	//Mouse Methods
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(!computerMoving)
		{
			int x = e.getX();
			int y = e.getY();
			// TODO Auto-generated method stub
			//System.out.println("[" + e.getX() + ", " +  e.getY() + "]");
			
			//c controls the x, r controls the y
			for(int r = 0 ; r < Game.ROWS ; r++)
			{
				for(int c = 0 ; c < Game.COLS ; c++)
				{
					if(x > (XBOUND + (c*100)) && x < (XBOUND + (c+1)*100) && y >
						(YBOUND + (r*100)) && y < YBOUND + (r+1)*100)
					{
						if(isValidMove(new Location(r,c)))
						{
							movePlayed = true;
							updateGameBoard(new Location(r,c));
						}
					}
				}
		
			}
		}
	}
	
	//FIXME create another condition that accounts for gravity
	public boolean isValidMove(Location l)
	{
		if(!(board[l.getRow()][l.getCol()].getColor().equals(Color.WHITE)))
				return false;
		if(l.getRow() == Game.ROWS - 1)//On bottom row
			return true;
		if(l.getRow() < Game.ROWS - 1)//Other pieces below it
		{
			if(!(board[l.getRow() + 1][l.getCol()].getColor().equals(Color.WHITE)))
				return true;
		}
		return false;
	}
	
	public boolean isWithinBounds(int tempR, int tempC)
	{
		if(tempR >= 0 && tempR < Game.ROWS && tempC >= 0 && tempC < Game.COLS)
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean colorsMatch(Color c1, Color c2)
	{
		return c1.equals(c2);
	}
	
	public boolean isGameOver()
	{	
		int modR;//Row modifications
		int modC;//Column modifications
		
		
		for(int r = 0 ; r < Game.ROWS ; r++)
		{
			for(int c  = 0 ; c < Game.COLS ; c++)
			{
				if(!((board[r][c].getColor()).equals(Color.WHITE)))
				{
					for(modR = -1; modR <= 1 ; modR++)
					{
					
						for(modC = -1 ; modC <= 1 ; modC++)
						{
							if(modR == 0 && modC == 0)
							{}
							else
							{
								for(int i = 1, j = 1 ; isWithinBounds(r + (i*modR) , c + (j*modC)) ; i ++ , j++)
								{

									if(colorsMatch(board[r + (i*modR)][c + (j*modC)].getColor()
											, board[r + ((i-1)*modR)][c + ((j-1)*modC)].getColor()))
									{
										Game.win++;
									}	
									else
									{
										break;
									}
									
									if(Game.win == 4)
									{
										winningColor = board[r][c].getColor();
										removeMouseListener(this);
										return true;
									}
								}
							}
							
							Game.win = 1;
						}
					}	
				}
		
			}
		}
		
		int tie = 0;
		for(int r = 0 ; r < Game.ROWS ; r++)
		{
			for(int c  = 0 ; c < Game.COLS ; c++)
			{
				if(!((board[r][c].getColor()).equals(Color.WHITE)))
				{
					tie++;
				}
			}
		}
		
		if(tie == Game.ROWS*Game.COLS)
		{
			this.tie = true;
			return true;
		}
		
		return false;
	}
	
	
	public ArrayList<Location> getAvailableMoves()
	{
		ArrayList<Location> moves = new <Location>ArrayList();
		
		for(int r = 0 ; r < Game.ROWS ; r++)
		{
			for(int c = 0 ; c < Game.COLS ; c++)
			{
				Location l = new Location(r,c);
				if(board[r][c].getColor().equals(Color.WHITE) && isValidMove(l))
				{
					moves.add(l);
				}
			}
		}
		
		return moves;
	}
	
	public Location getBestMove(Color p2Clr, Location[] aM)
	{
		int bonusCount = 0;
		int maxBonus = 0;
		Location bestMove = null;
		
		int r;
		int c;
		int modR;
		int modC;
		
		for(int x = 0 ; x < aM.length ; x++)
		{
			r = aM[x].getRow();
			c = aM[x].getCol();
			
			for(modR = -1; modR <= 1 ; modR++)
			{
			
				for(modC = -1 ; modC <= 1 ; modC++)
				{
					if(modR == 0 && modC == 0)
					{}
					else
					{
						for(int i = 1, j = 1 ; isWithinBounds(r + ((i+1)*modR) , c + ((j+1)*modC)) && 
								colorsMatch(board[r + (i*modR)][c + (j*modC)].getColor()
										, board[r + ((i + 1)*modR)][c + ((j + 1)*modC)].getColor()); i ++ , j++)
						{

							if(colorsMatch(board[r + (i*modR)][c + (j*modC)].getColor(), p2Clr) &&
									colorsMatch(board[r + (i*modR)][c + (j*modC)].getColor()
									, board[r + ((i + 1)*modR)][c + ((j + 1)*modC)].getColor()))
							{
								bonusCount++;
							}	
						}
					}
					
					if(bonusCount > maxBonus)
					{
						maxBonus = bonusCount;
						bestMove = aM[x];
					}
					
					bonusCount = 0;
				}
			}	
		}
		
		
		
		return bestMove;
	}
	
	public void mousePressed(MouseEvent e) 
	{}

	public void mouseReleased(MouseEvent e) 
	{}

	public void mouseEntered(MouseEvent e) 
	{}

	public void mouseExited(MouseEvent e) 
	{}
	
}
