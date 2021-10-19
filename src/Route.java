
import java.io.IOException;
import java.util.*; 
public class Route 

{
	
	private ArrayList<Events> events_list = new ArrayList<>(); 
	@SuppressWarnings("unused")
	private double number_of_days;
	private double route_distance; 
	@SuppressWarnings("unused")
	private String route_name, start_location, end_location, route_description;
	private static Scanner newObj; 
	Route(String name, String origin, String destination, String description, double distance)
	{
		// Constructor for route class
		route_distance = distance; 
		route_name = name; 
		start_location = origin; 
		end_location = destination; 
		route_description = description; 
		
	}
	
	
	
	public static int getIntinput(int min, int max, int deducted, String message)
	{
		
		/*Gets an input from user and returns it if it is an integer within the
		  range specified by min and max values. The function keeps calling itself
		  until the correct input is entered */
		
		System.out.println(message);
		newObj = new Scanner (System.in); 
		String input_int = newObj.nextLine(); 
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
		
	
	
	
	public double getNumberofDays(double ship_speed)
	{
		return route_distance / ship_speed; 
	}
	
	public double getDistance()
	{
		return route_distance; 
	}
	public String getRouteName()
	{
		return route_name;
	}
	
	public String getStartlocation()
	{
		return start_location;
	}
	
	public String getDestinationLocation()
	{
		return end_location;
	}
	
	public void addEventtoEventList(Events event)
	{
		// Adds events to event list 
		events_list.add(event); 
	}
	
	public String getProbability()
	{
		// Checks returns probabilities for random events in a route 

		ArrayList<String> counted_events_list = new ArrayList<>(); 
		String probability = "\nEvents Probability\n"; 
		
		List<String> event_list_string =  new ArrayList<String>(); 
		for (int i = 0; i < events_list.size(); i ++)
		{
			event_list_string.add(events_list.get(i).getEventName()); 
			//System.out.println(events_list.get(i).getEventName());
		}
		
		for (int i = 0; i < events_list.size(); i ++)
		{
			if (counted_events_list.contains(events_list.get(i).getEventName())==false)
			{
				counted_events_list.add(event_list_string.get(i)); 
				double count = Collections.frequency(event_list_string, events_list.get(i).getEventName()); 
				double percentage = Math.floor((count/events_list.size())*100); 
				probability = probability + events_list.get(i).getEventName() + ":	"+ percentage + "% " + "\n"; 
			}
		}
		return probability; 
	}
	
	public static void pauseExecution() throws IOException
	{
		// Pause Execution 
		System.out.println("\nPress Enter to continue ..."); 
		System.in.read();
	}

	
	public static void playDice(Ship selectedShip, Trader player) throws IOException
	{
		System.out.println("Your ship has encounterd pirates, to fend them off\n you must play and win in a game of dice"); 
		System.out.println("Who ever gets a greater dice roll will win the game"); 
		System.out.println("Press enter to roll a dice");
		pauseExecution(); 
		Random random = new Random();
		int player_roll = random.nextInt(6);
		int pirate_roll = random.nextInt(6) - selectedShip.getUpgrade(); 
		System.out.println("\nYour the number you rolled: " + player_roll);
		pauseExecution(); 
		System.out.println("\nThe pirates roll: " + pirate_roll);
		pauseExecution(); 
		if ((player_roll < pirate_roll) && selectedShip.getStockList().size() > 2)
		{
			selectedShip.emptyStock(); 
			System.out.println("-----You have lost in the dice game------\nThe pirates have decided to let you go\nBut they have taken all your stock!"); 
			pauseExecution(); 
		
		}
		else if ((player_roll < pirate_roll) && selectedShip.getStockList().size() <= 2)
		{
		
			System.out.println("*********Game Over***********-\nThe pirates are not satisfied with their loot.\n You have been made to walk the plank");
			player.setEndGameID(true);
			pauseExecution(); 
			
		}
		else
		{
			System.out.println("Congratulations you have successfully fended off the pirates.");
		}
		
	}
	
	public static String playDiceGUI(Ship selectedShip, Trader player) throws IOException
	{
		Random random = new Random();
		int player_roll = random.nextInt(6);
		int pirate_roll = random.nextInt(6) - selectedShip.getUpgrade();
		if ((player_roll < pirate_roll) && selectedShip.getStockList().size() > 2)
		{
			selectedShip.emptyStock();
			return "-----You have lost in the dice game------\\nThe pirates have decided to let you go\\nBut they have taken all your stock!";
		}
		else if ((player_roll < pirate_roll) && selectedShip.getStockList().size() <= 2)
		{
			player.setEndGameID(true);
			return "*********Game Over***********-\\nThe pirates are not satisfied with their loot.\\n You have been made to walk the plank";

		}
		else
		{
			return "Congratulations you have successfully fended off the pirates.";
		}

	}
	
	public String applyRoute(Ship selectedShip, Trader player) throws IOException
	{
		/* Changes Ship location as per the information contained in route
		 * checks whether the ship needs maintenance before sail 
		 * ensures if crew members are paid before start of journey
		 * updates player's elapsed date attribute if ship sailed
		 * returns general sail report (string)
		 * */
		
		// Get number of days for sail
		double num_of_days = getNumberofDays(selectedShip.getShipSpeed()); 
		
		// Check if ship has damages
		if (selectedShip.canSail())
		{
			// Check if the ship enough coins to pay crew members 
			if (selectedShip.canPay(num_of_days)==true)
			{
				// Check if the player has enough days left to sail
				if (player.getRemainingDays()-num_of_days > 0)
				{
					//Pay crew members
					selectedShip.payCoins(num_of_days);
					// Execute ship sail 
					selectedShip.sail(end_location);
					
					// Draw a random event 
					Random random = new Random();
					int index = random.nextInt(4); 
					
					// Check if the event is "Pirate Attack" if so, play a game of dice
					if (events_list.get(index).getEventName() == "Pirate Attack")
					{
						playDice(selectedShip, player); 
					}
					
					// If event is not "Pirate attack, execute event's impact on ship
					else
					{
						selectedShip.inflictDamage(events_list.get(index).getDamageValue()); 
						selectedShip.creditHealth(events_list.get(index).getUpgradeValue()); 
					}
				
				// Update player's Elapsed days 
				player.addElapsedDays(num_of_days);
					
				// Generate General Sail Report 
				String sail_report = "\n-----------------Sail Report--------------------\n"; 
				sail_report = sail_report + "Congratulations your ship has arrived at port of:  "+ this.end_location + " Island" + "\nEvent Encountered: " 
				+ events_list.get(index).getEventName() + "\nEvent Description: " + events_list.get(index).getEventDescription() +
				"\nEvent Damage Value: " + events_list.get(index).getDamageValue() + " %" + "\nEvent upgrade value: " + events_list.get(index).getUpgradeValue() + "\nCost of sail: " + 
				Math.floor(selectedShip.getSailCost(num_of_days)); 
				
				// Returns Generated Sales Report
				return sail_report; 
				}
				
				else
				{
					return "\n***********Sail Not Successful*********\nYou dont have enough days to sail\n"; 
				}
				
			}
			else
			{
				return "\n***********Sail Not Successful*********\nYou dont have enough coins to pay your crew\n";
			}
		}
		
		return "\n***********Sail Not Successful*********\nYour ship needs to be repaired before it can sail!";
	}
	

	public boolean pirateEvent(int index)
	{
		if (events_list.get(index).getEventName() == "Pirate Attack")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String applyRouteGUI(Ship selectedShip, Trader player) throws IOException
	{
		/* A method which has the same functionality as applyRoute but modified
		 * to be able to work in the GUI.*/
	
		// Get number of days for sail
		double num_of_days = getNumberofDays(selectedShip.getShipSpeed());
	
		// Check if ship has damages
		if (selectedShip.canSail())
		{
			// Check if the ship enough coins to pay crew members
			if (selectedShip.canPay(num_of_days)==true)
			{
				// Check if the player has enough days left to sail
				if (player.getRemainingDays()-num_of_days > 0)
				{
					//Pay crew members
					selectedShip.payCoins(num_of_days);
					// Execute ship sail
					selectedShip.sail(end_location);
	
					// Draw a random event
					Random random = new Random();
					int index = random.nextInt(4);
	
					// Check if the event is "Pirate Attack" if so, play a game of dice
					if (pirateEvent(index))
					{
						playDiceGUI(selectedShip, player);
					}
	
					// If event is not "Pirate attack, execute event's impact on ship
					else
					{
						selectedShip.inflictDamage(events_list.get(index).getDamageValue());
						selectedShip.creditHealth(events_list.get(index).getUpgradeValue());
					}
	
					// Update player's Elapsed days
					player.addElapsedDays(num_of_days);
		
					// Generate General Sail Report
					String sail_report = "\n-----------------Sail Report--------------------\n";
					sail_report = sail_report + "Congratulations your ship has arrived at port of:  "+ this.end_location + " Island" + "\nEvent Encountered: "
							+ events_list.get(index).getEventName() + "\nEvent Description: " + events_list.get(index).getEventDescription() +
							"\nEvent Damage Value: " + events_list.get(index).getDamageValue() + " %" + "\nEvent upgrade value: " + events_list.get(index).getUpgradeValue() + "\nCost of sail: " +
							Math.floor(selectedShip.getSailCost(num_of_days));
	
					// Returns Generated Sales Report
					return sail_report;
				}
	
				else
				{
					return "\n***********Sail Not Successful*********\nYou dont have enough days to sail\n";
				}
	
			}
			else
			{
				return "\n***********Sail Not Successful*********\nYou dont have enough coins to pay your crew\n";
			}
		}
	
		return "\n*************Sail Not Successful*************\nYour ship needs to be repaired before it can sail!";
	}

	public String getProperties(Ship selectedShip)
	{
		double num_of_days = getNumberofDays(selectedShip.getShipSpeed()); 
		String properties = "--------------Route properties-----------------\nRoute Name:	" + route_name + "\nRoute Distance:	" + route_distance + 
				"\nOrigin:		" + start_location + "\nDestination:	" + end_location + "\n" + "Cost of sail:	" + Math.floor(selectedShip.getSailCost(num_of_days)) + "\n" + getProbability() + "\n" 
				+ "----------------------------------------------\n"; 
		
		return properties; 
	}
	
	public String getPropertiesGUI(Ship selectedShip)
	{
		double num_of_days = getNumberofDays(selectedShip.getShipSpeed()); 
		String properties = "Route Name:	" + route_name + "\nRoute Distance:  " + route_distance + 
				"\nOrigin:  " + start_location + "\nDestination:  " + end_location + "\n" + "Cost of sail:  " + Math.floor(selectedShip.getSailCost(num_of_days)) + "\n" + getProbability(); 
		
		return properties; 
	}


}
