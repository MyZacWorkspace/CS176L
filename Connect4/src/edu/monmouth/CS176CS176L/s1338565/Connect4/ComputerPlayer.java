package edu.monmouth.CS176CS176L.s1338565.Connect4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player
{
	private double strength;
	private Random randGen;
	
	
	public ComputerPlayer(String label, double power)
	{
		super(label);
		strength = power;
		randGen = new Random();
	}
	
	public String getType()
	{
		return "c";
	}
	
	public double getStrength()
	{
		return strength;
	}
	
	public Location makeMove(Location[] validMoves, Location bestMove)
	{
		Double randNum = Math.random();
		
		if(bestMove != null && randNum <= strength)
		{
			//System.out.println("Computer Just Played A Strong Move");
			return bestMove;
		}

		Location chosen = validMoves[randGen.nextInt(validMoves.length)];
		//System.out.println("Chosen Move: " + chosen.getRow() + " " + chosen.getCol());
		
		return chosen;
		
	}
}
