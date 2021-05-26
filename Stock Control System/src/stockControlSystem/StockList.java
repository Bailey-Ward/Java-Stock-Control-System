package stockControlSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StockList {

	private String m_name; //constructs the item name
	
	/**
	 * Creates the stocklist Arraylist
	 */
	ArrayList<StockItem> stocks = new ArrayList<StockItem>();
	public StockList(String name)
	{
		m_name = name;
	}
	/**
	 * sets the name of the item and returns it when called
	 * @return returns the name of the item
	 */
	public String getName() {return m_name;} // Will return name of item when called
	
	/**
	 * //sets name using keyboard reader
	 * @param name is the name of the item which will be set
	 */
	public void setName(String name) 
	{
		this.m_name = name; 
	}
	
	/**
	 * Adds new items to the stocklist	
	 * @param s is the object which is to be added to the list
	 */
	public void addItem(StockItem s) 
	{	
		stocks.add(s);
	}
	
	/**
	 * finds an item within the csv file and returns the items data
	 * @param name is the attribute used to search the stock list 
	 * @return if a matching item is found, the item is returned, otherwise nothing is returned
	 */
	public StockItem findItem(String name) 
	{ 
		if (!stocks.isEmpty()) 
		{
			for (StockItem item: stocks) 
			{
				if (name.equals(item.getName())) 
				{
					return item;
				}
			}
		}
		return null;
		
	/**
	 * 	removes an item 
	 * Removes an item from the stock list using the .remove command
	 */
	}
	public void removeItem(StockItem item) 
	{ 
					stocks.remove(item);
	
	}
	
	/**
	 * returns total value of all stock
	 * @return returns the total value of the stock by multiplying each items number of stock by the price, and adding it to a total
	 */
	public float getTotalValue() 
	{ 
		float total = 0;
		for (StockItem item: stocks)
		{
			float itemStock = item.getNum() * item.getPrice();
			total += itemStock;
		}
		return total;
	}
	
	/**
	 * loads the CSV file to the arrayList
	 * @param filename Loads the filename which is specified in the menu
	 * @throws IOException
	 */
	public void load(String filename) throws IOException { 
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		String stock;
		while ((stock = br.readLine()) !=null)
			{
				String stockArray[] = stock.split(",");
				StockItem s = new StockItem(stockArray[0],stockArray[1], Integer.parseInt(stockArray[2]),Float.parseFloat(stockArray[3]));
				stocks.add(s);
			}
		br.close();
	}
	/**
	 * saves items from the arrayList to csv file
	 * @param filename specifies the name of the file when it is to be saved
	 * @throws FileNotFoundException
	 */
	public void save(String filename) throws FileNotFoundException
	{
		File file = new File(filename);
		PrintWriter pw = new PrintWriter(file);
		for (StockItem s : stocks )
		{
			pw.println(s.toCSV());
		}
		pw.close();
		
	}
}


