import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
   Used to test the BlankLinesRemover class.
*/
public class InputOutputFiles
{
   public static void main(String[] args) throws FileNotFoundException
   {
      
      Scanner path = new Scanner(System.in);
      boolean invalidPath = true;
      
      System.out.println("Please enter the path to open the input file: ");
  
      FileInputStream inputFile = null;
      
      while(invalidPath)
      {
    	  try
	      {
	    	  inputFile = new FileInputStream(path.nextLine());
	    	  invalidPath = false;
	      }
    	  catch(FileNotFoundException e)
    	  {
    		  System.out.println(invalidPath);
    		  System.out.println("File is not found, please try again: ");
    	  }
      }
      
      PrintWriter outputFile = new PrintWriter("output.txt");
      
      Scanner in = new Scanner(inputFile);
      
      while (in.hasNext()) 
      {
    	  String what = in.next();
    	  outputFile.println(what);
      }
      
      in.close();
      outputFile.close();
      
   }
}
