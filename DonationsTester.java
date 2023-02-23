import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* *
 * @author ZT
 * @version 2.16.23
 * CS176L 
 * Donations Project
 */
public class DonationsTester 
{
	public static void main (String[] args) throws FileNotFoundException
	{
		//Setup Objects
		File don = new File("Donations.txt");
		//File don = new File("extraDonations.txt"); A second test case with rearranged information.
		Scanner sc = new Scanner(don);
		Scanner in = new Scanner(System.in);
		Donations giveToMe = new Donations();
		
		//Prompt
		System.out.println("Would you like to process donations now? (enter 'Yes' to continue): ");
		String choice = in.next();
		
		//Process
		if(choice.equals("Yes"))
		{
			String data = "";
			
			while(sc.hasNextLine())
			{
				
				data = sc.nextLine();
				if(!(data.equals("<EOF>")))
				{
					String seg1 = data.substring(0, data.indexOf(">") + 1);
					String seg2 = data.substring(data.indexOf(">") + 1);
					
					Double donAmt = Double.parseDouble(seg2);
				
					giveToMe.processDonation(seg1, donAmt);
					//System.out.println(data);
				}
				
			}
			
			
			giveToMe.getStatistics();
		}
		else
			System.out.println("Ending now without processing donations");
		
		sc.close();
		in.close();
		
	}
}
