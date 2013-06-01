package ru.susu.vmi.task1;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ru.susu.vmi.task1.model.Quote;
import ru.susu.vmi.task1.model.QuotesStorage;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class QuotesStorageTest {
    @Test
    public void testQuote() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        assertNotNull("Object is not null", quote);
        assertEquals("Symbol is ok",quote.getSymbol(),"a");
        assertEquals("Date is ok",quote.getDate(),date);
        assertEquals("Open price is ok",quote.getOpenPrice(),200.0,0.1);
        assertEquals("High price is ok",quote.getHighPrice(),300.0,0.1);
        assertEquals("Low price is ok",quote.getLowPrice(),100.0,0.1);
        assertEquals("Close price is ok",quote.getClosePrice(),107.0,0.1);
    }
    @Test
    public void testQuoteStorage(){
        QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        assertNotNull("Object is not null", storage);
        assertEquals("Symbol is ok",storage.quotesList.get(0).getSymbol(),"a");
        assertEquals("Date is ok",storage.quotesList.get(0).getDate(),date);
        assertEquals("Open price is ok",storage.quotesList.get(0).getOpenPrice(),200.0,0.1);
        assertEquals("High price is ok",storage.quotesList.get(0).getHighPrice(),300.0,0.1);
        assertEquals("Low price is ok",storage.quotesList.get(0).getLowPrice(),100.0,0.1);
        assertEquals("Close price is ok",storage.quotesList.get(0).getClosePrice(),107.0,0.1);
    }
    @Test
    public void testToStringQuote(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        assertEquals(quote.toString(),"\"a\","+date.toString()+",Open=200.0,High=300.0,Low=100.0,Close=107.0,Volume=1.0");
    }
    
    /*@Test
    public void testToStringQuoteStorage(){
        QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        assertEquals(storage.quotesList.get(0).toString(),"\"a\","+date.toString()+",Open=200.0,High=300.0,Low=100.0,Close=107.0,Volume=1.0");
    }*/

    @Test
    public void testToStringQuoteStorage(){
        QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote1=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote2=new Quote("d",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        storage.addStock(quote1);     
        storage.addStock(quote2); 
        assertEquals(storage.toString(),"\"a\",2 stocks, Start date="+date.toString()+", End date="+date.toString()+", Max 		price=300.0, Low Price =100.0\"d\",1 stocks, Start date="+date.toString()+", End date="+date.toString()+", Max 		price=300.0, Low Price =100.0");     
        storage.clear();
    }
    
    @Test
    public void testgetStocksQuoteStorage(){
        QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        
        Calendar calAf = Calendar.getInstance();
        calAf.set(Calendar.YEAR, 2011);
        calAf.set(Calendar.MONTH, 3);
        calAf.set(Calendar.DAY_OF_MONTH, 3);     
        Date dateAf = calAf.getTime();
        
        Calendar calBef = Calendar.getInstance();
        calBef.set(Calendar.YEAR, 2011);
        calBef.set(Calendar.MONTH, 1);
        calBef.set(Calendar.DAY_OF_MONTH, 1);
        Date dateBef = calBef.getTime();
       
        
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote1=new Quote("b",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote2=new Quote("c",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        storage.addStock(quote1);
        storage.addStock(quote2);
        //System.out.println(storage.getStocks("b", dateBef, dateAf));          
        assertEquals(storage.getStocks("b", dateBef, dateAf).toString(),"[\"b\","+date.toString()+",Open=200.0,High=300.0,Low=100.0,Close=107.0,Volume=1.0]");     
        storage.clear();
        int x;
    }
    
    @Test
    public void testremoveQuoteStorage() {
    	QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote1=new Quote("b",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote2=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote3=new Quote("n",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote4=new Quote("h",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote2);
        storage.addStock(quote3);
        storage.addStock(quote4);
        storage.addStock(quote1);
        System.out.println(storage.quotesList.size());
        storage.remove(quote1);
        System.out.println(storage.quotesList.size());   
        // было 4 , удалили 1ую, стало 3
    }
    
    @Test
    public void testQuoteEqual() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        Quote quote1=new Quote("b",date,200.0,300.0,100.0,107.0,1.0);
        Quote quote2=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        if (quote1.equals(quote2)){        	 
            System.out.println("TRUE");}
         else {
           System.out.println("FALSE");}
       
    }
    
    @Test
    public void testToStringWithExactSymbol(){
    	QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        
        Calendar calAf = Calendar.getInstance();
        calAf.set(Calendar.YEAR, 2011);
        calAf.set(Calendar.MONTH, 3);
        calAf.set(Calendar.DAY_OF_MONTH, 3);     
        Date dateAf = calAf.getTime();
       
        Calendar calBef = Calendar.getInstance();
        calBef.set(Calendar.YEAR, 2011);
        calBef.set(Calendar.MONTH, 1);
        calBef.set(Calendar.DAY_OF_MONTH, 1);
        Date dateBef = calBef.getTime();
        
        Quote quote1=new Quote("a",dateBef,200.0,300.0,100.0,107.0,1.0);
        Quote quote2=new Quote("a",dateAf,200.0,300.0,100.0,107.0,1.0);
        Quote quote3=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote3);
        storage.addStock(quote1);
        storage.addStock(quote2);
        storage.toStringWithExactSymbol("a");
    }
    
    @Test
    public void testMapGetStocksQuoteStorage(){
        QuotesStorage storage = new QuotesStorage();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2011);
        cal.set(Calendar.MONTH, 2);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date date = cal.getTime();
        
        Calendar calAf = Calendar.getInstance();
        calAf.set(Calendar.YEAR, 2011);
        calAf.set(Calendar.MONTH, 3);
        calAf.set(Calendar.DAY_OF_MONTH, 3);     
        Date dateAf = calAf.getTime();
        
        Calendar calBef = Calendar.getInstance();
        calBef.set(Calendar.YEAR, 2011);
        calBef.set(Calendar.MONTH, 1);
        calBef.set(Calendar.DAY_OF_MONTH, 1);
        Date dateBef = calBef.getTime();
       
        
        Quote quote=new Quote("a",date,200.0,300.0,100.0,107.0,1.0);
        storage.addStock(quote);
        
//        System.out.println(storage.getStocks(dateBef, dateAf));          
        assertEquals(storage.getStocks(dateBef, dateAf).toString(),"{a=[\"a\","+date.toString()+",Open=200.0,High=300.0,Low=100.0,Close=107.0,Volume=1.0]}");
        storage.clear();
    }
}
