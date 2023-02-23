//The Donations class
public class Donations 
{
	//Instance Fields
	private int numIndividual;
	private double amtIndividual;
	private int numBusiness;
	private double amtBusiness;
	private int numOther;
	private double amtOther;
	
	public void processDonation(String cat, double donation)
	{
		if(cat.equals("<individual donation>"))
		{
			if(donation < 0)
				numIndividual--;
			else if(donation > 0)
				numIndividual++;
			else
			{
			}
			
			amtIndividual += donation;
			
			//System.out.println(cat + " donation amount: " + donation);
		}
		else if (cat.equals("<business donation>"))
		{
			if(donation < 0)
				numBusiness--;
			else if(donation > 0)
				numBusiness++;
			else
			{
			}

			amtBusiness += donation;
			
			//System.out.println(cat + " donation amount: " + donation);
		}
		else
		{
			if(donation < 0)
				numOther--;
			else if(donation > 0)
				numOther++;
			else
			{
			}
		
			amtOther += donation;
			
			//System.out.println(cat + " donation amount: " + donation);
		}
		
		
	}
	
	public void getStatistics()
	{
		System.out.println("Individual: #:" + numIndividual + " $" + amtIndividual);
		System.out.println("Business: #:" + numBusiness + " $" + amtBusiness);
		System.out.println("Other: #:" + numOther + " $" + amtOther);
	}
	
	
}
