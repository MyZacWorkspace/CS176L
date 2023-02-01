//HousePainting Project
//Zaccery Tarver CS176L01 MonmouthEDU (23SP)
import java.util.Scanner;

public class HousePainting 
{
	
	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		
		//Values to read in
		System.out.print("Please enter the cost per square foot: ");
		double cperSqft = scnr.nextDouble();
		System.out.print("Please enter the length of the house: ");
		double l = scnr.nextDouble();
		System.out.print("Please enter the width of the house: ");
		double w = scnr.nextDouble();
		System.out.print("Please enter the height of the house: ");
		double h = scnr.nextDouble();
		System.out.print("Please enter the number of windows: ");
		double numWind  = scnr.nextDouble();
		System.out.print("Please enter the length of a window: ");
		double winLen = scnr.nextDouble();
		System.out.print("Please enter the width of a window: ");
		double winWid = scnr.nextDouble();
		System.out.print("Please enter the number of doors: ");
		double numDoor = scnr.nextDouble();
		System.out.print("Please enter the length of a door: ");
		double doorLen = scnr.nextDouble();
		System.out.print("Please enter the width of a door: ");
		double doorWid = scnr.nextDouble();
		
		
		//Processing to get surface area
		double paintSur = 2*(l*w + l*w + 0.5*l*(h-w)) - 
				(numWind*winLen*winWid + numDoor*doorLen*doorWid);
		//Outputs
		System.out.print("Your total paintable surface area is ");
		System.out.printf("%.0f", paintSur);
		System.out.println(" square feet.");
		
		System.out.print("Your estimate is "); 
		System.out.printf("%.0f", paintSur*cperSqft);
		System.out.println(" dollars.");
	}
}
