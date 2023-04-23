package edu.monmouth.CS176CS176L.s1338565.Connect4;

import java.util.ArrayList;
import java.awt.Dimension;

public class Location 
{
	private int r;
	private int c;
	/**
	 * Creates object given row r and column c
	 */
	
	public Location(int r, int c)
	{
		this.r = r;
		this.c = c;
	}
	
	/**
	 * @return r
	 */
	public int getRow()
	{
		return r;
	}
	
	/**
	 * @return c
	 */
	public int getCol()
	{
		return c;
	}
	/**
	 * 
	 * @param x
	 * @return list of valid locations adjacent to an in-game location
	 */
	public Location[] getValidAdjLocs(Location x)
	{
		ArrayList <Location> validAdjLocs =  new <Location> ArrayList();
		
		int a = r;
		int b = c;
		
		//Get adj loc
		for(a = a - 1 ; a <= a + 1 ; a++)
		{
			for(b = c - 1 ; b <= b + 1 ; b++)
			{
				if(a != r || b != c)
				{
					validAdjLocs.add(new Location(a, b));
				}
			}
		}
		
		//Extract illegal locations, ones less than zero and ones greater than the game boundaries
		for(int i = 0 ; i < validAdjLocs.size() ; i++)
		{
			
			if(validAdjLocs.get(i).getRow() < 0 || validAdjLocs.get(i).getRow() >= Game.ROWS ||
						validAdjLocs.get(i).getCol() < 0 || validAdjLocs.get(i).getCol() >= Game.COLS)
			{
				validAdjLocs.remove(i);
			}
		}
		
		//Copy and return in an array object
		Location[] returnedList = new Location[validAdjLocs.size()];
		
		for(int j = 0 ; j < validAdjLocs.size() ; j++)
		{
			returnedList[j] = validAdjLocs.get(j);
		}
		
		return returnedList;
	}
}
