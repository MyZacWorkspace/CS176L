

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupRun
{

	public static void main(String[] args) throws IOException
	{
		//2020 Batting Leaders-------------------------------------------------
		
		Document htmlDoc = Jsoup.connect
				("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2020&month=0&season1=2020&ind=0").timeout(6000).get();
		
		
		Elements body = htmlDoc.select("tbody");
		
		
		//Notes
		//z is of a class that extends an arraylist of elements
		//an elements object returning more Elements 
		//z will be designated here as the elements within the grid
		Elements z = body.select("td.grid_line_regular");
		
		//Each element can be output in a for-each loop
		/*
		for(Element e : z)
		{
			System.out.println(e);
		}
		*/
		
		//The .select("a") helps return elements that match in the html with an "a" tag
		Elements alpha = z.select("a");
		//Now, looping through alpha will only return a tags: <a > </a>
		
		
		int counter = 0;
		System.out.println("Batting Leaders of 2020:");
		for(Element e : alpha)
		{
			if(e.text().indexOf(" ") >= 0)//This skips <a> </a> tags that denote teams, since that syntax
				//Never uses spaces!
			{
				counter++;
				System.out.print(counter + ". ");
				
				if(counter < 10)
					System.out.printf("%22s\n", e.text());
				else
					System.out.printf("%21s\n", e.text());
			}
		}
		//-------------------
		System.out.println("\n");
		
		//2021 Batting Leaders-------------------------------------------------
		
		htmlDoc = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2021&month=0&season1=2021&ind=0").timeout(6000).get();
		
		
		body = htmlDoc.select("tbody");
		z = body.select("td.grid_line_regular");
		alpha = z.select("a");
	
		counter = 0;
		System.out.println("Batting Leaders of 2021:");
		for(Element e : alpha)
		{
			if(e.text().indexOf(" ") >= 0)
			{
				counter++;
				System.out.print(counter + ". ");
					
				//Get alignment right
				if(counter < 10)
					System.out.printf("%22s\n", e.text());
				else
					System.out.printf("%21s\n", e.text());
			}
		} 
		//-------------------
		System.out.println("\n");
				
		//2022 Batting Leaders-------------------------------------------------
		
		htmlDoc = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2022&month=0&season1=2022&ind=0").timeout(6000).get();

		
		body = htmlDoc.select("tbody");
		z = body.select("td.grid_line_regular");
		alpha = z.select("a");
	
		counter = 0;
		System.out.println("Batting Leaders of 2022:");
		for(Element e : alpha)
		{
			if(e.text().indexOf(" ") >= 0)
			{
				counter++;
				System.out.print(counter + ". ");
					
				//Get alignment right
				if(counter < 10)
					System.out.printf("%22s\n", e.text());
				else
					System.out.printf("%21s\n", e.text());
			}
		}
		//-------------------
		System.out.println("\n");
		
		//Combined Leaders (2020, 2021, 2022)--------------------------------------
		//For this one, I set a custom date on the fangraphs batting page: 2020 to 2022.
		//I use this for my rankings.
		
		htmlDoc = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2020&month=1000&season1=2022&ind=0&startdate=2020-03-01&enddate=2022-10-31").timeout(6000).get();
		
		body = htmlDoc.select("tbody");
		z = body.select("td.grid_line_regular");
		alpha = z.select("a");
	
		counter = 0;
		System.out.println("Combined Batting Leaders of 2020, 2021, and 2022:");
		for(Element e : alpha)
		{
			if(counter + 1 == 11)
				break;
			
			if(e.text().indexOf(" ") >= 0)
			{
				counter++;
				System.out.print(counter + ". ");
					
				//Get alignment right
				if(counter < 10)
					System.out.printf("%22s\n", e.text());
				else
					System.out.printf("%21s\n", e.text());
			}
		}
		
	}

}
