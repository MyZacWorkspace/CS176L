package customPackage;

//Simple Array Assignment, 2.27
//zac

public class ArrayAssignment1 
{
	
	public static void main (String[] args)
	{
		double[] values = {25.3, 100, -10, -1.5, 13, 98.6, 17, 123.145, 125.6, 123.146};
		
		//Task 1 Print Values
		for(double val : values)
		{
			System.out.print(val + " ");
		}
		System.out.println("");
		
		//Task 2 Compute and print largest element
		double max = values[0]; 
		for(int x = 1 ; x < values.length ; x++)
		{
			if(!(max >= values[x]))
			{
				max = values[x];
			}
		}
		System.out.println("The largest element in the array is " + max);
		
		//Task 3 -- Computing and Printing # of negative numbers
		int counter = 0;
		for(double val : values)
		{
			if(val < 0.0)
				counter++;
		}
		
	
		if(counter == 0)
		{
			System.out.println("There are no negative numbers in the array");
		}
		else if(counter == 1)
		{
			System.out.println("There is " + counter + " negative number in the array");
		}
		else if(counter > 1)
		{
			System.out.println("There are " + counter + " negative numbers in the array");
		}
		
		
	}
}
