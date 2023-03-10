import java.util.ArrayList;

class medals
  {
  public static void main(String[] args) 
    {
    ArrayList<ArrayList> olympicGrid = new ArrayList <ArrayList>();

    // To be added to olympicGrid
    ArrayList<String> country = new ArrayList <String>();

    ArrayList<Integer> gold = new ArrayList <Integer>();
    ArrayList<Integer> silver = new ArrayList <Integer>();
    ArrayList<Integer> bronze = new ArrayList <Integer>();

    //Build individual lists
    //For country
    country.add("Canada");
    country.add("Italy");
    country.add("Germany");
    country.add("Japan");
    country.add("Kazakhstan");
    country.add("Russia");
    country.add("South Korea");
    country.add("United States");
    country.add("Total");

    //For gold
    gold.add(0);
    gold.add(0);
    gold.add(0);
    gold.add(1);
    gold.add(0);
    gold.add(3);
    gold.add(0);
    gold.add(1);
    int goldTotal = 0;
    for(Integer val : gold)
    {
        goldTotal += val.intValue();
    }
    gold.add(goldTotal);
      

    //For silver
    silver.add(3);
    silver.add(0);
    silver.add(0);
    silver.add(0);
    silver.add(0);
    silver.add(1);
    silver.add(1);
    silver.add(0);
    silver.add(5);
    int silverTotal = 0;
    for(Integer val : silver)
    {
        silverTotal += val.intValue();
    }
    silver.add(silverTotal);
      
    //For bronze
    bronze.add(0);
    bronze.add(1);
    bronze.add(1);
    bronze.add(0);
    bronze.add(1);
    bronze.add(1);
    bronze.add(0);
    bronze.add(1);
    bronze.add(5);
    int bronzeTotal = 0;
    for(Integer val : bronze)
    {
        bronzeTotal += val.intValue();
    }
    bronze.add(bronzeTotal);

    
      
    //Add country, gold, silver, and bronze to olympicGrid
    olympicGrid.add(country);
    olympicGrid.add(gold);
    olympicGrid.add(silver);
    olympicGrid.add(bronze);

    //Output
    System.out.println("\n"+"        Country      Gold      Silver      Bronze      Total");// 4 tabs 3 tabs spacing

    //Use a nested output loop
    int total = 0;
    for(int i = 0 ; i < country.size() ; i++)
    {
        System.out.print("        " + olympicGrid.get(0).get(i));
        for(int j = 0 ; j < olympicGrid.size() ; j++)
        {
         
          
            
          if(j > 0)
          {
            total += ((Integer)olympicGrid.get(j).get(i)).intValue();
            
            if(j == 1)
            {
             if(i == 0)
                System.out.print("          " + olympicGrid.get(j).get(i));
              if(i == 1)
                System.out.print("           " + olympicGrid.get(j).get(i));
              if(i == 2)
                System.out.print("         " + olympicGrid.get(j).get(i));
              if(i == 3)
                System.out.print("           " + olympicGrid.get(j).get(i));
              if(i == 4)
                System.out.print("      " + olympicGrid.get(j).get(i));
              if(i == 5)
                System.out.print("          " + olympicGrid.get(j).get(i));
              if(i == 6)
                System.out.print("     " + olympicGrid.get(j).get(i));
              if(i == 7)
                System.out.print("   " + olympicGrid.get(j).get(i));
              if(i == 8)
                System.out.print("           " + olympicGrid.get(j).get(i));
            }

            if(j > 1)
            {
                System.out.print("           " + olympicGrid.get(j).get(i));
            }
          }
        }
      
      if(i == country.size() - 1)
        System.out.print("         " + total);
      else
        System.out.print("          " + total);
  
      System.out.println("");
      total = 0;
    }

  }
}