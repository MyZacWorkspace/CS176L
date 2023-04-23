package edu.monmouth.CS176CS176L.s1338565.Connect4;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class DynamicPiece extends Ellipse2D.Double
{
	private static final double  SIDE = 90;

	private Color pieceClr;
	
	public DynamicPiece(Location l, Color clr)
	{
		super((l.getCol()*100) + 45 ,(l.getRow() * 100) + 25 , SIDE, SIDE);
		
		pieceClr = clr;
	}
	
	public void setColor(Color clr)
	{
		pieceClr = clr;
	}
	
	public Color getColor()
	{
		return pieceClr;
	}
}
