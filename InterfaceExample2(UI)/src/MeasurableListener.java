import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
   An action listener that prints a message.
*/
public class MeasurableListener implements ActionListener
{
	private int dataFunction;
	
	double value1;
	double value2;
	double value3;
	
	public MeasurableListener(int n)
	{
		dataFunction = n;
	}
	
	
   public void actionPerformed(ActionEvent event)
   {
	   String beginning = "";
	   String specifier = "";
	   
	   if(dataFunction == 1)
	   {
		   beginning = "Get Maximum ";
		   specifier = "Maximum ";
	   }
	   if(dataFunction == 2)
	   {
		   beginning = "Get Minimum ";
		   specifier = "Minimum ";
	   }
	   if(dataFunction == 3)
	   {
		   beginning = "Get Average ";
		   specifier = "Average ";
	   }
	   
	   String e = event.getActionCommand();
	   
	   if(e.equals(beginning + "Balance"))
	   {
		   System.out.println(specifier + "Account Balance is " + value1);
	   }
	   else if(e.equals(beginning + "Area"))
	   {
		   System.out.println(specifier + "Country Area is " + value2);
	   }
	   else if(e.equals(beginning + "Score"))
	   {
		   System.out.println(specifier + "Quiz Score is " + value3);
	   }
   }
   
   
   public void setDataValues(double v1, double v2, double v3)
   {
	   value1 = v1; value2 = v2; value3 = v3;
   }
   
   
   
   
   
   
   
   
}