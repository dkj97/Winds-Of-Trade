import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameEnvironment 

{
	
	

	public void mainMenu()
	{
		
		// Prints the main menu
		
		System.out.println("\n---------------------Main Menu--------------------------------\n"); 
		System.out.println("Please Choose what you want to do from the list of activies shown below"); 
		System.out.println("1. Sail"); 
		System.out.println("2. Repair or upgrade your ship"); 
		System.out.println("3. Visit store at current Island"); 
		System.out.println("4. View your ship's property"); 
		System.out.println("5. View Island properties"); 
		System.out.println("6. View Trader properties"); 
		System.out.println("7. View Ship Stock"); 
		System.out.println("8. Exit Game"); 
		
	}
	public void sailMenu()
	{
		// Prints the sail Menu 
		
		System.out.println("\n----------------------Sail Menu-----------------------------------\n"); 
		System.out.println("Please Choose what you want to do from the list of activies shown below"); 
		System.out.println("1. Select Available Routes"); 
		System.out.println("2. Repair your ship"); 
		System.out.println("3. View trader properties"); 
		System.out.println("4. View your ship's property"); 
		System.out.println("5. View all stores"); 
		System.out.println("6. Back to main menu"); 
		
	}
	public void displayGreeting()
	{
		// Displays Game Start Greeting 
		
		System.out.println("\n--------------------------Welcome to Winds of Trade -----------------------------------"); 
		
		System.out.println("\nIn this game you are a trader who travels"
				+ " by ship to trade goods on multiple islands.\nYou will "
				+ "buy goods on one island then travel to another to sell "
				+ "them.You will keep\ntraveling between islands and trading "
				+ "goods with the goal to earn as much profit as\npossible before "
				+ "the game ends."); 
		
	}
	
	public String getAboutGUI()
	{
		/**
		 * A string which has the text displayed in the about section
		 * in the GUI.
		 */
		String about = "\nIn this game you are a trader who travels"
		+ " by ship to trade\ngoods on multiple islands. You will "
		+ "buy goods on one island\nand then travel to another to sell "
		+ "them.You will keep\ntraveling between islands and trading "
		+ "goods with the\ngoal to earn as much profit as possible before "
		+ "the\ngame ends.";
		
		return about;
	}
	
	public void printIsland(ArrayList<Islands> island_list, String location)
	{
		// Prints List of islands 
		
		for (int i = 0; i <= (island_list.size() - 1); i++)
		{
			if (island_list.get(i).getIslandLocatin() == location)
			{
				System.out.println(island_list.get(i).getProperties()); 
			}
			

		}
	}
	
	public void printIslandsList(ArrayList<Islands> island_list)
	{
		// Prints List of islands 
		
		for (int i = 0; i <= (island_list.size() - 1); i++)
		{
			System.out.println("\nIsland: " + (i+1)); 
			System.out.println(island_list.get(i).getProperties()); 

		}
	}
	
	public static void printRouteList(ArrayList<Route> route_list, Ship selectedShip)
	{
		
		// Prints list of available routes 

		for (int i = 0; i < route_list.size(); i++)
		{
			System.out.println("Route: " + (i+1)); 
			System.out.println(route_list.get(i).getProperties(selectedShip)); 

		}
	}
	
	public static void printStoreList(ArrayList<Store> store_list)
	{
		//Prints list of available stores 
		
		for (int i = 0; i < store_list.size(); i++)
		{
			System.out.println("Store: " + (i+1)); 
			System.out.println(store_list.get(i).getProperties()); 

		}
	}
	
	public static void printStore(Store current_store, int i)
	{
		// Prints current store properties  
		
		if (i == 0)
		{
			// Prints all available items for sale and purchase 
			System.out.println(current_store.getProperties()); 
		}
		else if (i == 1)
		{
			// Prints items that only are listed as for sale 
			System.out.println(current_store.getPropertiesForSale()); 
		}
		else
		{
			// Prints items that only are listed as for purchase 
			System.out.println(current_store.getPropertiesForPurchase()); 
		}

	}
	
	public static Store getCurrentstore(ArrayList<Store> store_list, String location)
	{
		// Loops around store list and returns available store at an Island of given location 
		
		Store available_store = new Store(); 
		for (int i = 0; i < store_list.size(); i++)
		{
			if (store_list.get(i).getLocation() == location)
			{
				available_store = store_list.get(i); 
			}
		}
		return available_store; 
	}
	public static ArrayList<Route>  getAvailableRouteList(ArrayList<Route> route_list, String location)
	{
		// Loops around routes list and returns list of available routes accessible from an Island of the given location
		
		ArrayList<Route> available_routes = new ArrayList<>(); 
		route_list.size(); 
		
		for (int i = 0; i < route_list.size(); i++)
		{
			if (route_list.get(i).getStartlocation()==location)
			{
				available_routes.add(route_list.get(i)); 
			}
		}
		
		return available_routes; 
	}
	
	public static ArrayList<Route>  getAvailableRouteListGUI(ArrayList<Route> route_list, String startLocation, String destinationLocation)
	{
		/**
		 * The same method as getAvailableRouteList modified to be able to
		 * work for the GUI.
		 */
		ArrayList<Route> available_routes = new ArrayList<>();
		route_list.size();

		for (int i = 0; i < route_list.size(); i++)
		{
			if (route_list.get(i).getStartlocation() == startLocation && route_list.get(i).getDestinationLocation() == destinationLocation)
			{
				available_routes.add(route_list.get(i));
			}

		}
			return available_routes;
		}
	
	public static void printShipList(ArrayList<Ship> ship_list)
	{
		// Prints List of ships
		
		for (int i = 0; i <= (ship_list.size() - 1); i++)
		{
			System.out.println("Ship: " + (i+1)); 
			System.out.println(ship_list.get(i).getProperties()); 

		}
	}

	public static int getIntinput(int min, int max, int deducted, String message)
	{
		
		/*Gets an input from user and returns it if it is an integer within the
		  range specified by minimum and max values. The function keeps calling itself
		  until the correct input is entered */
		
		System.out.println(message);
		Scanner newObj = new Scanner (System.in); 
		String input_int = newObj.nextLine(); 
		
		// Check if input matches digits only 
		boolean result = (input_int.matches("^[0-9]+$"));
		
		if (result==false) 
		{
			System.out.println("\nInvalid Entry, try again");
			return getIntinput(min, max, deducted, message);
		} 
	
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
	
	

	
	public static void pauseExecution() throws IOException
	{
		// Pause Execution 
		System.out.println("\nPress Enter to continue ..."); 
		System.in.read();
	}
	
	public static void printMessage(String message)
	{
		// Print message
		System.out.println(message); 
	}
	
	public static void printMessage(int message)
	{
		// Print message
		System.out.println(message); 
	}
	public static void main(String[] args) throws IOException 
	{
	// Construct new constructor object
	Constructor  obj = new Constructor(); 	
	
	//Construct the game environment 
	GameEnvironment trader_game = new GameEnvironment(); 
	
	//Display greetings and game information 
	trader_game.displayGreeting(); 
	
	// Construct player
	Trader player =  obj.playerConstructor();
	System.out.println(player.getproperties()); 
	
	// Construct list of ships 
	ArrayList<Ship> ship_list = obj.shipsConstructor(); 
	
	//Construct list of islands
	ArrayList<Islands> island_list = obj.islandsConstructor(); 
	
	// Construct list of events
	ArrayList<Events> event_list = obj.eventsConstructor(); 
	pauseExecution(); 
	
	// Construct list of routes
	ArrayList<Route> route_list = obj.routesConstructor(event_list); 
	
	//Construct list of Stores 
	ArrayList<Store> store_list = obj.storeConstructor(); 

	
	//print Ship list 
	printMessage("\nTo continue playing the game please select your ship: ");
	printShipList(ship_list); 
	
	// Get index of the selected ship from user
	int ship_index = getIntinput(1, 4, 1, "\nEnter a number to select your ship: "); 
	Ship selectedShip = ship_list.get(ship_index); 
	
	// Print selected ship properties and pause program execution 
	printMessage(selectedShip.getProperties()); 
	pauseExecution(); 
	
	// Game does not end while Player has days left or EndGameID is set to true
	
	while (player.getRemainingDays() > 0 && player.getEndGameID()==false)
	{
		//Display main menu 
		trader_game.mainMenu();
		
		//Get user input 
		int selection = getIntinput(1, 8, 0, "Please enter a number from the menu items: "); 
		
		switch (selection) 
		{
		case 1: 
			boolean exit = false; 
			
			while (exit == false && player.getEndGameID()==false)
			{
				// Display sail menu 
				trader_game.sailMenu();
				
				// Get user input 
				selection = getIntinput(1, 6, 0, "Please enter a number from the sail menu items: ");
				switch (selection)
				{
				case 1: 
					// Get list of available routes 
					ArrayList<Route> available_routes = getAvailableRouteList(route_list, selectedShip.getLocation());
					
					// Print list of available routes
					printRouteList(available_routes, selectedShip);
					
					// Get user input 
					int route_index = getIntinput(1, available_routes.size(), 1, "Please enter route to sail: ");
					
					// Execute sail
					String sail_report = available_routes.get(route_index).applyRoute(selectedShip, player);
					
					// Check if the game has ended
					if (player.getEndGameID()==false)
					{
						// print sail report 
						printMessage(sail_report); 
						pauseExecution(); 
					}
					
					break; 
				case 2: 
					// Execute repair 
					String repair_report = selectedShip.repairShip(); 
					// Print repair report 
					printMessage(repair_report); 
					pauseExecution(); 
					break; 
				case 3: 
					// Print player properties 
					printMessage(player.getproperties());
					pauseExecution(); 
					break; 
				case 4: 
					//  Print Ship properties 
					printMessage(selectedShip.getProperties());
					pauseExecution(); 
					break; 
				case 5: 
					// Print All Stores list 
					printStoreList(store_list); 
					pauseExecution(); 
					break; 
				case 6:
					exit = true; 
					break; 
				}
			}
			
			break; 
		case 2: 
			pauseExecution();
			break; 
		case 3: 
			// Get available store 
			Store current_store = getCurrentstore(store_list, selectedShip.getLocation()); 
			
			// Set leave store id 
			boolean leave_store_id = false; 
			
			// Keep looping as long as leave store id is false 
			while (leave_store_id == false)
			{
				printStore(current_store, 0); 
				
				// Get integer input from user 
				selection = getIntinput(0, 2, 0, "Enter 1 to buy or 2 to sell\nEnter 0 to Exit");
				
				if (selection == 1)
				{
					printStore(current_store, 1); 
					int index = getIntinput(0, current_store.getForSaleStock().size(), 1, "Please enter the item number to purchase\n To exit enter 0\n");
					if (index == -1)
					{
						leave_store_id = true;  
					}
					else
					{
						String purchase_report = current_store.sellStock(index, selectedShip);
						printMessage(purchase_report); 
						pauseExecution(); 
					}
				}
				
				else if (selection == 2)
				{
					printStore(current_store, 2); 
					int index = getIntinput(0, current_store.getForPurchaseStock().size(), 1, "Please enter the item number to sell:\nTo exit enter 0\n");
					
					if (index == -1)
					{
						leave_store_id = true;  
					}
					else
					{
						String sales_report = current_store.buyStock(index, selectedShip);
						printMessage(sales_report); 
						pauseExecution(); 
					}
					
					
				}
				
				else
				{
					leave_store_id = true;  
				}
				
			}
			break; 
		case 4: 
			// Print ship properties 
			printMessage(selectedShip.getProperties());
			pauseExecution(); 
			break; 
		case 5: 
			// Print Islands list 
			trader_game.printIslandsList(island_list);
			pauseExecution(); 
		
			break; 
		case 6: 
			printMessage(player.getproperties());
			pauseExecution(); 
			break; 
		case 7: 
			printMessage(selectedShip.getShipStockProperties()); 
			pauseExecution(); 
			
			break; 
			
		case 8: 
			printMessage("\nAre you sure you want to Exit\n1. Yes\n2. No");
			selection = getIntinput(1, 2, 0, "Please enter a number"); 
			if (selection == 1)
			{
				player.setEndGameID(true);
				
			}
			
			break; 
			
		
		}
	}
	
	// End Game Note 
	printMessage(player.getEndgameValues(selectedShip)); 
	
	}
	
	

}