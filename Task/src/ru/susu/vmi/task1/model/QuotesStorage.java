package ru.susu.vmi.task1.model;
import java.util.*;


public class QuotesStorage implements  IQuotesStorage{
   
	public QuotesStorage(){

        this.quotesList=new ArrayList<IQuote>();

    }
   

public void addStock(IQuote stock){

        this.quotesList.add(stock);

    }
   

public Map<String, List<IQuote>> getStocks(Date begin, Date end){

        Map<String,List<IQuote>> map = new HashMap<String, List<IQuote>>();

        for (int i=0; i<this.quotesList.size(); i++){
 
           if ((this.quotesList.get(i).getDate().after(begin))&&(this.quotesList.get(i).getDate().before(end))){
 
               map.put(this.quotesList.get(i).getSymbol(),getStocks(this.quotesList.get(i).getSymbol(),begin,end));

            }
      
  }
        
return map;
  
  }

public List<IQuote> getStocks(String symbol, Date begin, Date end){

        List<IQuote> returnQuotesList=new ArrayList<IQuote>();

        for (int i=0; i<this.quotesList.size(); i++){
 
           if (this.quotesList.get(i).getSymbol().equals(symbol)){

                if ((this.quotesList.get(i).getDate().after(begin))||(this.quotesList.get(i).getDate().before(end))){

                    returnQuotesList.add(this.quotesList.get(i));

                }
            }

        }

        return returnQuotesList;

    }

    public void clear(){

        this.quotesList.clear();

    }

    
    public void remove(IQuote stock){

        quotesList.remove(stock);

    }


    //@return string with exact symbol

    public String toStringWithExactSymbol(String symbol){

        int quoteAmount=0;

        Date startDate=this.quotesList.get(0).getDate();

        Date finishDate=this.quotesList.get(0).getDate();

        Double maxPrice = 0.0;

        Double lowPrice = 10000.0;

        for (int i=0;i<quotesList.size();i++){

        if (this.quotesList.get(i).getSymbol().equals(symbol)){

            quoteAmount++;

            if (this.quotesList.get(i).getDate().before(startDate)){

                startDate=this.quotesList.get(i).getDate();

            }

            if (this.quotesList.get(i).getDate().after(finishDate)){

                finishDate=this.quotesList.get(i).getDate();

            }

            if (this.quotesList.get(i).getHighPrice()>maxPrice){

                maxPrice=this.quotesList.get(i).getHighPrice();

            }

            if (this.quotesList.get(i).getLowPrice()<lowPrice){

                lowPrice=this.quotesList.get(i).getLowPrice();

            }

        }

        }

        String returnString="\""+symbol+"\""+","+quoteAmount+" stocks"+", Start date="+startDate.toString()+", End date="
                +finishDate+", Max 		price="+maxPrice+", Low Price ="+lowPrice;
        return returnString;

    }

    //@return array of quotesList symbols

    private ArrayList<String> getSymbolArray(){

       ArrayList<String> symbolArray= new ArrayList<String>();
       for (int i=0;i<this.quotesList.size();i++){
 
          String symbol=this.quotesList.get(i).getSymbol();

           if (symbolArray.size()==0){

               symbolArray.add(symbol);

           }

           boolean isNotUnique=false;

           for (int j=0;j<symbolArray.size();j++){

                if (symbolArray.get(j).equals(symbol)){

                    isNotUnique=true;

                }

           }

           if (!(isNotUnique)){

                symbolArray.add(symbol);

           }

       }

       return symbolArray;

    }


    public String toString(){

        String returnString="";

        for (int i=0;i<getSymbolArray().size();i++){

            returnString+=toStringWithExactSymbol(getSymbolArray().get(i));

        }

        return returnString;
    }
 
   public List<IQuote> quotesList= new ArrayList<IQuote>();

}
