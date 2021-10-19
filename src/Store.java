
import java.util.ArrayList;
import java.util.Scanner;

/*Store Class
 *   */
public class Store 
{
	// Attributes of Store Class
	
	private ArrayList<Stock> for_sale_stock_list = new ArrayList<>(); 
	private ArrayList<Stock> for_purchase_stock_list = new ArrayList<>();
	private String store_name; 
	private String location; 
	private String description; 
	private double store_coins; 
	
	
	
	Store() 
	
	{
		// Empty Constructor 
	} 
	
	Store(String name, String location, String description, String store_name, double store_coins, ArrayList<Stock> stock_list, ArrayList<Stock> for_purchase_stock_list) 
	
	{
		// Store class object constructor
		
		this.store_name = store_name; 
		this.location = location; 
		this.description = description; 
		this.store_coins = store_coins; 
		this.for_sale_stock_list = stock_list; 
		this.for_purchase_stock_list = for_purchase_stock_list; 
	} 
	
	
	public static int getIntinput(int min, int max, int deducted, String message)
	{
		
		/*Gets an input from user and returns it if it is an integer within the
		  range specified by minimum and max values. The function keeps calling itself
		  until the correct input is entered */
		
		System.out.println(message);
		Scanner newObj = new Scanner (System.in); 
		String input_int = newObj.nextLine(); 
		boolean result = (input_int.matches("^[0-9]+$"));
		
		// If result does not match numbers, call the method again. 
		if (result==false) 
		{
			System.out.println("\nInvalid Entry, try again");
			return getIntinput(min, max, deducted, message);
		} 
		
	
		// Return result if it is within limits. Else call method again
	
		else 
		{
			int i=Integer.parseInt(input_int); 
			if (i < min || i > max)
			{
				System.out.println("\nWrong selection, please a number between " + min + " and " + max +".");
				return getIntinput(min, max, deducted, message);
			}
			else 
			{
				return (i - deducted); 
			}
		}
	}
	
	
	public String buyStock(int index, Ship selectedShip)
	{
		// Method for buying a stock from a ship. 
		
		// Check if the stock is in ship. If not return a message to main. 
		if (selectedShip.getStockList().contains(for_purchase_stock_list.get(index))==true)
		{
			System.out.println(for_purchase_stock_list.get(index).forpurchaseItemsProperties(1)); 
			int selection = getIntinput(1, 2, 0, "\nThe above Item ready to be sold\nPlease Enter 1 to continue purchase. To cancel purchase Enter 2");
			// Check if sales is to proceed
			if (selection == 1)
			{
				//Update ship coins
				selectedShip.addCoins(for_purchase_stock_list.get(index).getTotalPrice()*1.15);
				
				// update ship loaded capacity 
				selectedShip.setLoadedCapacity(-(for_purchase_stock_list.get(index).getTotalSize()));
				
				// update ship stock 
				selectedShip.removeStock(index); 
				
				// Compile and return a sales report
				String sales_report = "\nTransaction Successfull\nTotal Transaction Amount: " + for_purchase_stock_list.get(index).getTotalPrice()*1.15;
				return sales_report; 
		
			}
			String sales_report = "\nTransaction cancelled"; 
			return sales_report; 
		}
		
		String sales_report = "\nYour ship does not have the item you wish to sale.\n"; 
		
		return sales_report; 
	}
	
	
	public String sellStock(int index, Ship selectedShip)
	{
		// Method called when store sells stock to ship 
		// Print list of items for sale
		System.out.println(for_sale_stock_list.get(index).getProperties(1)); 
		// Get user input 
		int selection = getIntinput(1, 2, 0, "\nThe above Item ready for purchase\nPlease Enter 1 to continue purchase. To cancel purchase Enter 2");
		// Print for selected item 
		System.out.println(for_sale_stock_list.get(index).getProperties(1)); 
		
		//Check if user wants to proceed with purchase 
		if (selection == 1)
		{
			// check if ship can take additional stock 
			if (selectedShip.canAddStock(for_sale_stock_list.get(index).getTotalSize()))
			{
				// check if ship can purchase stock 
				if (selectedShip.canPurchase(for_sale_stock_list.get(index).getTotalPrice()))
				{
					// Buy stock 
					selectedShip.buyStock(for_sale_stock_list.get(index).getTotalPrice());
					// update ship's loaded capacity 
					selectedShip.setLoadedCapacity(for_sale_stock_list.get(index).getTotalSize());
					// Update ship's stock 
					selectedShip.addShipStock(for_sale_stock_list.get(index));
					// Update store's stock list 
					for_sale_stock_list.remove(index); 
					// Compile a report 
					String purchase_report = "\nPurchase has been conducted successfully\n"; 
					// return a report 
					return purchase_report; 
				}
				// Compile and return sales report 
				String purchase_report = "\n****Your ship does not have enough coins for this purchase****\n"; 
				return purchase_report; 
					
			}
			// Compile and return sales report 
			String purchase_report = "\n*****Your ship does not have enough space for the purchase*******\n"; 
			return purchase_report; 
		}
		// Compile and return sales report 
		String purchase_report = "\nTransaction cancelled"; 
		return purchase_report; 
	
	}
	
	public String sellStockGUI(int index, Ship selectedShip)
	{
		// Method called when   
		if (selectedShip.canAddStock(for_sale_stock_list.get(index).getTotalSize()))
		{
			if (selectedShip.canPurchase(for_sale_stock_list.get(index).getTotalPrice()))
			{
				selectedShip.buyStock(for_sale_stock_list.get(index).getTotalPrice());
				selectedShip.setLoadedCapacity(for_sale_stock_list.get(index).getTotalSize());
				selectedShip.addShipStock(for_sale_stock_list.get(index));
				for_sale_stock_list.remove(index); 
				String purchase_report = "\nPurchase has been conducted successfully\n"; 
				return purchase_report; 
			}
			String purchase_report = "\n****Your ship does not have enough coins for this purchase****\n"; 
			return purchase_report; 
			
		}
		
		String purchase_report = "\n*****Your ship does not have enough space for the purchase*******\n"; 
		return purchase_report; 
	}
	
	public String getLocation()
	{
		return location; 
	}
	
	
	public ArrayList<Stock> getForSaleStock()
	{
		// return Items list for purchase 
		return for_sale_stock_list; 
	}
	
	
	public ArrayList<Stock> getForPurchaseStock()
	{
		// Return items list for sale 
		return for_purchase_stock_list; 
	}
	
	
	
	public String getProperties()
	{
		
		// Return Store properties 
		
		String for_purchase_properties="";
		String for_sale_properties=""; 
		
		// Store items for purchase 
		for (int i = 0; i < for_purchase_stock_list.size(); i ++)
		{
			for_purchase_properties = for_purchase_properties + for_purchase_stock_list.get(i).forpurchaseItemsProperties(i+1); 
		}
		
		// Store items for sale 
		
		for (int i = 0; i < for_sale_stock_list.size(); i ++)
		{
			for_sale_properties = for_sale_properties + for_sale_stock_list.get(i).getProperties(i+1); 
		}
		
		// Compile properties
		String properties = "\n-----------Store Properties----------------\n"; 
		properties = properties + "Store Name:	" + store_name + "\nLocation:	" + location + "\nDescription:	" + description + 
				"\nStore coins:	" + store_coins +    "\n--------Items for Sale in this Store------------\n\n" + for_sale_properties
				+ "\n--------Items This Store Buys------------\n\n"  + for_purchase_properties; 
		// return properties 
		return properties;  
	}
	
	
	
	public String getPropertiesForSale()
	{
		// Return Store properties 
		// Also calls property method for stock class 
		String for_purchase_properties="";
		String for_sale_properties=""; 
		for (int i = 0; i < for_purchase_stock_list.size(); i ++)
		{
			for_purchase_properties = for_purchase_properties + for_purchase_stock_list.get(i).forpurchaseItemsProperties(i+1); 
		}
		
		for (int i = 0; i < for_sale_stock_list.size(); i ++)
		{
			for_sale_properties = for_sale_properties + for_sale_stock_list.get(i).getProperties(i+1); 
		}
		String properties = "\n-----------Store Properties----------------\n"; 
		properties = properties + "Store Name:	" + store_name + "\nLocation:	" + location + "\nDescription:	" + description + 
				"\nStore coins:	" + store_coins +    "\n--------Items for Sale in this Store------------\n\n" + for_sale_properties; 
		return properties;  
	}
	
	
	
	public String getPropertiesForPurchase()
	{
		String for_purchase_properties="";
		for (int i = 0; i < for_purchase_stock_list.size(); i ++)
		{
			for_purchase_properties = for_purchase_properties + for_purchase_stock_list.get(i).forpurchaseItemsProperties(i+1); 
		}
		
	
		String properties = "\n-----------Store Properties----------------\n"; 
		properties = properties + "Store Name:	" + store_name + "\nLocation:	" + location + "\nDescription:	" + description + 
				"\nStore coins:	" + store_coins + "\n--------Items This Store Buys------------\n\n"  + for_purchase_properties; 
		return properties;  
	}
	
	

}
