package edu.monmouth.CS176CS176L.s1338565.Connect4;

import java.awt.Color;
import java.util.ArrayList;

public class HumanPlayer extends Player
{
	
	public HumanPlayer(String label)
	{
		super(label);
	}
	
	public String getType()
	{ 
		return "h";
	}
	
	public Location makeMove(Location[] movesArr, Location best)
	{
		//This is never used
		return new Location(0,0);
	}
}
