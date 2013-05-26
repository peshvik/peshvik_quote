package ru.susu.vmi.task1;

import java.util.*;

import ru.susu.vmi.task1.model.IQuote;
import ru.susu.vmi.task1.model.IQuotesStorage;
import ru.susu.vmi.task1.model.Quote;
import ru.susu.vmi.task1.model.QuotesStorage;


public class main {

    public static void main(String[] args) {
      
  //creates new storage
        
 	IQuotesStorage storage=new QuotesStorage();

 //creates 100 QUOTES with fields of random values
 
	Random randomGenerator = new Random();
  
	for (int i=0;i<100;i++){
 
 //creates random date
           
		 long someTimeBetween25And50YearsInMilliSeconds = TWENTY_FIVE_YEARS_AS_MILLISECONDS +

                    (long)(Math.random() * ((FIFTY_YEARS_AS_MILLISECONDS - TWENTY_FIVE_YEARS_AS_MILLISECONDS) + 1));
     
            Date d = new Date(System.currentTimeMillis() - someTimeBetween25And50YearsInMilliSeconds);

 //add to storage
            
		storage.addStock(new Quote(String.valueOf(1),d,randomGenerator.nextDouble(),randomGenerator.nextDouble(),randomGenerator.nextDouble(),randomGenerator.nextDouble(),randomGenerator.nextDouble()));
      
				  }
        
//creates knowingly small date for begin date
       
//creates knowingly big date for end date
        

Date begin = new Date(System.currentTimeMillis()-FIFTY_YEARS_AS_MILLISECONDS);

Date end = new Date(System.currentTimeMillis()+FIFTY_YEARS_AS_MILLISECONDS);


//test of getStocks method
        

Map<String, List<IQuote>> map=storage.getStocks(begin,end);

        List<IQuote> list = storage.getStocks("1",begin,end);
 
//tests of IQuote getters
  
      System.out.println(list.get(0).getClosePrice());
      
      System.out.println(list.get(0).getHighPrice());

      System.out.println(list.get(0).getLowPrice());

      System.out.println(list.get(0).getOpenPrice());

      System.out.println(list.get(0).getVolume());
 

//tests of toString methods
 
      System.out.println(list.get(0).toString());

      System.out.println(storage.toString());

//tests of IQuotesStorage methods

      storage.remove(list.get(0));

      storage.clear();
 

//create 2 knowingly equal IQuotes
  
      IQuote equalQuote1=new Quote("1",begin,1.0,1.0,1.0,1.0,1.0);

      IQuote equalQuote2=new Quote("1",begin,1.0,1.0,1.0,1.0,1.0);
  
//test of override method
  
      if (equalQuote1.equals(equalQuote2)){
 
           System.out.println("TRUE");
  
      }
        else {
  
          System.out.println("FALSE");
  
      }
   
 }
   
 private static long ONE_YEAR_AS_MILLISECONDS = 365*24*60*60*1000;

 private static long TWENTY_FIVE_YEARS_AS_MILLISECONDS = 25*ONE_YEAR_AS_MILLISECONDS;

 private static long FIFTY_YEARS_AS_MILLISECONDS = 50*ONE_YEAR_AS_MILLISECONDS;
}
