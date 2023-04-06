/**
   This program demonstrates the measurable Country class.
*/

import java.util.Scanner;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MeasurableViewer
{
	private static final int FRAME_WIDTH = 360;
	private static final int FRAME_HEIGHT = 180;
	
	private static final int PANEL_WIDTH = 100;
	private static final int PANEL_HEIGHT = 60;
	   
	private static void makeOptionSelect(int n)
	{
		String buttonText = "";
		if(n == 1)
		{
			buttonText = "Get Maximum ";
		}
		if(n == 2)
		{
			buttonText = "Get Minimum ";
		}
		if(n == 3)
		{
			buttonText = "Get Average ";
		}
		
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(3,1));


		JButton buttonBA = new JButton(buttonText + "Balance");
		JPanel panelBA = new JPanel();
		panelBA.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		panelBA.add(buttonBA);
		frame.add(panelBA);
		
		
		JButton buttonC = new JButton(buttonText + "Area");
		JPanel panelC = new JPanel();
		panelC.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		panelC.add(buttonC);
		frame.add(panelC);
		
		//FIXME button q
		JButton buttonQ = new JButton(buttonText + "Score");
		JPanel panelQ = new JPanel();
		panelQ.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		panelQ.add(buttonQ);
		frame.add(panelQ);
		
		ActionListener listener = new MeasurableListener(n);
		buttonBA.addActionListener(listener);
		buttonC.addActionListener(listener);
		buttonQ.addActionListener(listener);
		
		//SAME DATA------\
	    Measurable[] bank = new Measurable[3];
	    bank[0] = new BankAccount(176220);
	    bank[1] = new BankAccount(513120);
	    bank[2] = new BankAccount(30510);
		
		Measurable[] countries = new Measurable[3];
	    countries[0] = new Country("Uruguay", 176220);
	    countries[1] = new Country("Thailand", 513120);
	    countries[2] = new Country("Belgium", 30510);
	    
	    Measurable[] quizzes = new Measurable[5];
	    quizzes[0] = new Quiz(95.0);
	    quizzes[1] = new Quiz(80.0);
	    quizzes[2] = new Quiz(90.0);
	    quizzes[3] = new Quiz(50.0);
	    quizzes[4] = new Quiz(75.0);
	    //---------------
	    
	    if(n == 1)
	    {
	    	((MeasurableListener)listener).setDataValues(Data.max(bank) , Data.max(countries) , Data.max(quizzes));
	    }
	    else if(n == 2)
	    {
	    	((MeasurableListener)listener).setDataValues(Data.min(bank) , Data.min(countries) , Data.min(quizzes));
	    }
	    else if(n == 3)
	    {
	    	((MeasurableListener)listener).setDataValues(Data.average(bank) , Data.average(countries) , Data.average(quizzes));
	    }
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
   public static void main(String[] args)
   {
	 //NEW
	   
	 Scanner in = new Scanner(System.in);
	 System.out.println("Enter metric to use, 1 for maximum, 2 for minimum, 3 for average: ");
	 int n = in.nextInt();
	 
	 if(n == 1)
	 {
		 makeOptionSelect(n);
	 }
	 else if(n == 2)
	 {
		 makeOptionSelect(n);
	 }
	 else if(n == 3)
	 {
		 makeOptionSelect(n);
	 } 
   }
}

/*OLD
	  //Countries
	  System.out.println("Countries Data");
	  Measurable[] countries = new Measurable[3];
   countries[0] = new Country("Uruguay", 176220);
   countries[1] = new Country("Thailand", 513120);
   countries[2] = new Country("Belgium", 30510);
   
   double avg = Data.average(countries);
   System.out.println("Average area: " + avg);
   System.out.println("Expected: 239950");
   System.out.println("");
   
   double maxData = Data.max(countries);
   System.out.println("Maximum area: " + maxData);
   System.out.println("Expected: 513120");
   System.out.println("");
  
   //Bank Accounts
   System.out.println("Bank Account Data");
   Measurable[] bank = new Measurable[3];
   bank[0] = new BankAccount(176220);
   bank[1] = new BankAccount(513120);
   bank[2] = new BankAccount(30510);
   
   avg= Data.average(bank);
   System.out.println("Average balance: " + avg);
   System.out.println("Expected: 239950");
   System.out.println("");
   
   maxData = Data.max(bank);
   System.out.println("Maximum balance: " + maxData);
   System.out.println("Expected: 513120");
   System.out.println("");
   
   //Quizzes
   System.out.println("Quiz Data");
   Measurable[] quizzes = new Measurable[5];
   quizzes[0] = new Quiz(95.0);
   quizzes[1] = new Quiz(80.0);
   quizzes[2] = new Quiz(90.0);
   quizzes[3] = new Quiz(50.0);
   quizzes[4] = new Quiz(75.0);
   
   avg = Data.average(quizzes);
   System.out.println("Average score: " + avg);
   System.out.println("Expected: 78");
   System.out.println("");
   
   maxData = Data.max(quizzes);
   System.out.println("Maximum score: " + maxData);
   System.out.println("Expected: 95");
   System.out.println("");
   
  */