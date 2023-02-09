
public class Microwave 
{
	//Instance variables
	private int time = 0;
	private int power = 1;
//--------------------------------------------------------------	
	/**
	 *Cycles between power settings 1 and 2 on the microwave.
	 *Power is always initially at 1.
	 */
	public void power()
	{
		if(power == 1)
			System.out.println("Power Button was pressed. "
				+ "Power level is " + (++power));
		else if (power == 2)
			System.out.println("Power Button was pressed. "
					+ "Power level is " + (--power));
	}
//--------------------------------------------------------------	
	/**
	 *Increases time on the microwave by increments of 30.
	 */
	public void time()
	{
		time += 30;
		System.out.println("Time Button was pressed. Time is "
				+ time + " seconds");
	}
//--------------------------------------------------------------
	/**
	 *Sets the power to 1 and the time to 0.
	 */
	public void reset()
	{
		time = 0;
		power = 1;
		System.out.println("Reset Button was pressed. "
				+ "Power level is " + power + "."
				+	" Time is " + time + " seconds.");
	}
//--------------------------------------------------------------
	/**
	 *Starts cooking with the set configurations of time and power.
	 */
	public void start()
	{
		System.out.println("Cooking for " + time + " seconds"
				+ " at level " + power + ".");
	}
//--------------------------------------------------------------
}
