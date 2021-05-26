package stockControlSystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import utils.KeyboardReader;

/**
 * @author Bailey Ward
 *
 */

public class Menu {

	KeyboardReader kbr;
	StockList stock;
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		Menu ui = new Menu();
		ui.run();

	}
/**
 * Creates a new instance of the keyboard reader, stockArray, and loads the contents of the file to the arrayList
 */
	public Menu() {
		kbr = new KeyboardReader();
		stock = new StockList("My Stock");
		try {
			stock.load("Business Stocklist.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
/**
 *  creates a menu to allow the user to navigate the program
 * Creates a menu for the user to help them navigate the program
 */
	public void run() { 
		int Choice = 0;

		while (Choice != 7) {
			System.out.println("------Main Menu------");
			System.out.println(
					"1.\t Add new stock\n2.\t Find stock\n3.\t Edit existing stock\n4.\t Add units to stock\n5.\t Delete items from the stocklist\n6.\t Calculate the cost of all items in stock\n7.\t Exit program ");

			Choice = kbr.getInt("Make a choice");

			if (Choice == 1) {
				add();
			} else if (Choice == 2) {
				find(stock);
			} else if (Choice == 3) {
				edit(stock);
			} else if (Choice == 4) {
				editStockUnits(stock);
			} else if (Choice == 5) {
				deleteItemFromStock();
			} else if (Choice == 6) {
				calcCost();
			} else if (Choice == 7) {
				System.out.println("Exiting program now, thank you for using the system.");
			}
		}
	}

/**
 *  Adds new items to the stocklist
 * Takes input to add a new item to the list
 */
	private void add() 
	{
		String name = kbr.getString("Enter a name for the product");
		String description = kbr.getString("Enter description");
		int numInStock = kbr.getInt("Enter the amount of product in stock");
		float price = kbr.getFloat("Enter the price of the product");
		StockItem a = new StockItem(name, description, numInStock, price);
		stock.addItem(a);
		System.out.println("New item added");
		try 
		{
			stock.save("Business Stocklist.csv");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
/**
 * finds items within the stocklist and returns their info
 * @param stock finds an item within the arraylist
 * @return returns the item and prints the attributes
 */
	private StockItem find(StockList stock) 
	{
		boolean valid = false;
		StockItem item = null;
		while (valid == false) {
			String search = kbr.getString("Enter Product Name");
			item = stock.findItem(search);

			if (item != null) 
			{
				System.out.println("Name: " + item.getName());
				System.out.println("Description: " + item.getDescription());
				System.out.println("Amount currently in stock: " + item.getNum());
				System.out.println("Current price is: " + " £" + item.getPrice());
				valid = true;
			}
		}
		return item;
	}
/**
 * edits items already present
 * @param stock loads stock arrayList to find the item and return it, and then edits a specified attribute
 */
	private void edit(StockList stock) 
	{
		StockItem item = find(stock);
		int Choice2 = 0;
		while (Choice2 != 5) {
			System.out.println("What would you like to edit");
			System.out.println(
					"1.\t Edit the name of an item\n2.\t Edit the description of an item\n3.\t Edit the amount of stock available\n4.\t Edit the price of the item\n5. \t Return to main menu");

			Choice2 = kbr.getInt("Pick an option");
			
			if(Choice2 == 1)
			{
				String name = kbr.getString("Enter a new name:");
					item.setName(name);
					System.out.println("New name accepted");
			}
			if(Choice2 == 2)
			{
				String desc = kbr.getString("Enter a new description:");
					item.setDescription(desc);
					System.out.println("New description accepted");
			}
			if(Choice2 == 3)
			{
				int num = kbr.getInt("Enter the new amount in stock:");
					item.setNum(num);
					System.out.println("New stock amount accepted");
			}
			if(Choice2 == 4)
			{
				float price = kbr.getFloat("Enter the new price for the item:");
					item.setPrice(price);
					System.out.println("New price accepted");
			}

		}
	}
	/**
	 * edits the amount of units in the stock
	 * @param stock finds item and returns it, before giving the user a choice for which attribute they would like to edit
	 */
	private void editStockUnits(StockList stock)
	{
		StockItem item = find(stock);
		int Choice3 = 0;
		while (Choice3 != 3)
		{
			System.out.println("1.\t Add units to the stock\n2.\t Remove units from the stock\n3.\t Return to the main menu");
			
			Choice3 = kbr.getInt("Pick an option:");
			
			if(Choice3 == 1)
			{
				int addnum = kbr.getInt("How many items would you like to add?");
				item.setNum(item.getNum() + addnum);
				System.out.println("Items added.");
			}
			if(Choice3 == 2)
			{
				int minusnum = kbr.getInt("How many items would you like to remove?");
				item.setNum(item.getNum() - minusnum);
				System.out.println("Items removed");
			}
			if(Choice3 == 3)
			{
				System.out.println("Returning to the main menu");
			}
		}
	}

/**
 * deletes an item from the stock list through a user input
 * Searches for an item based on name, and then uses the removeItem method to remove it from the list, and then saves the list.
 */
	private void deleteItemFromStock() 
	{
		boolean valid = false;
		while (valid == false) 
		{
			String search = kbr.getString("Enter Product Name");
			StockItem item = stock.findItem(search);

			if (item != null) 
			{
				stock.removeItem(item);
				valid = true;
				System.out.println("Item deleted");
			}
			try 
			{
				stock.save("Business Stocklist.csv");
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * calculates the cost of all owned stock
	 * Uses method getTotalValue to print the monetary value of all items in the array
	 */
	private void calcCost() 
	{
		System.out.println("Total stock value is: " + "£" + stock.getTotalValue());
	}

}

