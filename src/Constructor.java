
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*
 * Constructor class keeps all the data needed to construct objects of 
 * Item class, Event class, Route class, Islands class, Trader class, 
 * Store class and Stock class
 *
 */
public class Constructor 
{
	public String getTradername()
	{
		
		// Gets the name of the Trader, Checks if it is a 
		// Valid name and returns it 
		
		String traderName = "";
		System.out.println("\nTo Continue playing the game Enter Trader Name"); 
		Scanner newObj = new Scanner (System.in); 
		traderName = newObj.nextLine(); 
		
		// Check if trader name matches only alphabets
		
		boolean result = (traderName.matches("^[a-zA-Z]+$"));
		
		if (result==false) {
			System.out.println("\nInvalid Entry, special characters and numbers are not allowed.");
			return getTradername();
		}
		
		else if (traderName.length() < 3 || traderName.length() > 15)
		{
			System.out.println("\nInvalid Entry, length should be 3-15 characters.");
			return getTradername(); 
		}
		else 
		{
			System.out.println("\nYour trader name set as " + traderName);
			return traderName; 
		}
	}
	
	public int getIntInput(int min, int max, int deducted, String message)
	{
		
		// Gets integer input from user, checks if it is within specified values 
		// and returns it 
		
		System.out.println(message + ":");
		Scanner newObj = new Scanner (System.in); 
		String input_int = newObj.nextLine(); 
		boolean result = (input_int.matches("^[0-9]+$"));
		
		if (result==false) 
		{
			System.out.println("\nInvalid Entry, try again");
			return getIntInput(min, max, deducted, message);
		} 
	
		else 
		{
			int i=Integer.parseInt(input_int); 
			if (i < min || i > max)
			{
				System.out.println("\nWrong selection, please a number between " + min + " and " + max +".");
				return getIntInput(min, max, deducted, message);
			}
			else 
			{
				return (i - deducted); 
			}
		}
	}
	
	public ArrayList<Events> eventsConstructor()
	{
		// Events constructor
		// Returns Events List 
		
		Events pirateAttack = new Events("Pirate Attack", "Your ship has been attacked by pirates.", 0, 0); 
		Events badWeather = new Events("Bad Weather ", "Your ship has encountered bad weather.", 23, 0); 
		Events rescuedSailors = new Events("Save Sailors", "You and your crew rescue some sailors!", 0, 20);
		Events SafelyArrive = new Events("No Event", "Peaceful Journey", 0, 0);
		
		ArrayList<Events> events_list = new ArrayList<>(); 
		events_list.add(rescuedSailors);
		events_list.add(badWeather);
		events_list.add(pirateAttack);
		events_list.add(SafelyArrive); 
		return events_list; 
	}
	
	public ArrayList<Islands> islandsConstructor()
	{
		//Islands Constructor 
		//Returns Islands List 
		
		Islands islandOne = new Islands("Kanto Island", "Kanto Sea", "A barren land but one which has an abundant amount of oil in its soil.");
		Islands islandTwo = new Islands("Johto Island", "Johto Sea", "A rich and fertile land full of plantlife but has no oil.");
		Islands islandThree = new Islands("Hoenn Island", "Hoenn Ocean", "A land surrounded on all sides by poisonous water.");
		Islands islandFour = new Islands("Sinnoh Island", "Sinnoh Ocean", "An island which is in a state of perpetual winter.");
		Islands islandFive = new Islands("Kalos Island", "Kalos Ocean", "An island with an abundance of various tyoes of minerals and pure metals.");
		
		ArrayList<Islands> islands_list = new ArrayList<>(); 
		islands_list.add(islandOne); 
		islands_list.add(islandTwo); 
		islands_list.add(islandThree); 
		islands_list.add(islandFour); 
		islands_list.add(islandFive); 
		return islands_list; 
		
	}
	
	public ArrayList<Islands> islandsConstructorGUI()
	{
		/**
		 * Island constructor modified to work for the GUI.
		 */
	Islands islandOne = new Islands("Kanto", "Kanto Sea", "A barren land but one which has an abundant amount of oil in its soil.");
	Islands islandTwo = new Islands("Johto", "Johto Sea", "A rich and fertile land full of plantlife but has no oil.");
	Islands islandThree = new Islands("Hoenn", "Hoenn Ocean", "A land surrounded on all sides by poisonous water.");
	Islands islandFour = new Islands("Sinnoh", "Sinnoh Ocean", "An island which is in a state of perpetual winter.");
	Islands islandFive = new Islands("Kalos", "Kalos Ocean", "An island with an abundance of various types of minerals and pure metals.");

	ArrayList<Islands> islands_list = new ArrayList<>();
	islands_list.add(islandOne);
	islands_list.add(islandTwo);
	islands_list.add(islandThree);
	islands_list.add(islandFour);
	islands_list.add(islandFive);
	return islands_list;

	}
	
	public ArrayList<Route> routesConstructor(ArrayList<Events> event_list)
	{
		
		// Routes Constructor, Assigns Events to Routes Randomly 
		// Returns List of Routes 
		
		Route routeOne = new Route("Nafkratousa", "Kanto", "Johto", "A route from Kanto to Johto.", 12520);
		Route routeTwo = new Route("Kriti", "Kanto", "Hoenn", "", 15240);
		Route routeThree = new Route("Rodos", "Kanto", "Sinnoh", "", 18974);
		Route routeFour = new Route("Tombazis", "Kanto", "Kalos", "", 9452);
		Route routeFive = new Route("Nafkratousa", "Johto", "Kanto", "", 12520);
		Route routeSix = new Route("Lemnos", "Johto", "Hoenn", "", 11529);
		Route routeSeven = new Route("Poseidon", "Johto", "Sinnoh", "", 8440);
		Route routeEight = new Route("Vasilissa Olga", "Johto", "Kalos", "", 6500);
		Route routeNine = new Route("Kriti", "Hoenn", "Kanto", "", 15240);
		Route routeTen = new Route("Lemnos", "Hoenn", "Johto", "", 11529);
		Route routeEleven = new Route("Kountouriotis", "Hoenn", "Sinnoh", "", 9825);
		Route routeTwelve = new Route("Adrias", "Hoenn", "Kalos", "", 12363);
		Route routeThirteen = new Route("Rodos", "Sinnoh", "Kanto", "", 18974);
		Route routeFourteen = new Route("Poseidon", "Sinnoh", "Johto", "", 8440);
		Route routeFifteen = new Route("Kountouriotis", "Sinnoh", "Hoenn", "", 9825);
		Route routeSixteen = new Route("Aliakmon", "Sinnoh", "Kalos", "", 11456);
		Route routeSeventeen = new Route("Tombazis", "Kalos", "Kanto", "", 9452);
		Route routeEighteen = new Route("Vasilissa Olga", "Kalos", "Johto", "", 6500);
		Route routeNineteen = new Route("Adrias", "Kalos", "Hoenn", "", 12363);
		Route routeTwenty = new Route("Aliakmon", "Kalos", "Sinnoh", "", 11456);
		
		ArrayList<Route> route_list = new ArrayList<>(); 
		
		route_list.add(routeOne); 
		route_list.add(routeTwo);
		route_list.add(routeThree); 
		route_list.add(routeFour);
		route_list.add(routeFive); 
		route_list.add(routeSix);
		route_list.add(routeSeven); 
		route_list.add(routeEight);
		route_list.add(routeNine); 
		route_list.add(routeTen);
		route_list.add(routeEleven); 
		route_list.add(routeTwelve);
		route_list.add(routeThirteen); 
		route_list.add(routeFourteen);
		route_list.add(routeFifteen); 
		route_list.add(routeSixteen);
		route_list.add(routeSeventeen); 
		route_list.add(routeEighteen);
		route_list.add(routeNineteen); 
		route_list.add(routeTwenty);
		
		
		// Randomly Assign Events to Routes 
		for (int i = 0; i < route_list.size(); i++)
		{
			for (int j = 1; j <= 10; j++)
			{
				 Random random = new Random();
				 int number = random.nextInt(4);
				 route_list.get(i).addEventtoEventList(event_list.get(number));
			}
		}
		return route_list; 
		
		
	}
	
	
	public Trader playerConstructor()
	{
		String name = getTradername();
		int days = getIntInput(20, 50, 0, "\nEnter the number of your trading days");
		
		// Trader constructor
		Trader player = new Trader(name, days); 
		return player; 
	}
	
	public Trader playerConstructorGUI()
	{
		String name = ProfileGUI.playerName;
		int days = ProfileGUI.daysSelected;
	
		// Trader constructor
		Trader player = new Trader(name, days);
		return player;
	}
	
	public ArrayList<Ship> shipsConstructor()
	{
		// Ship Constructors
		// Returns Ship List 
		Ship voyager = new Ship("SS Voyager", "Kanto", 2450, 1.5, 300, 85400, 641, 12);
		Ship crusader = new Ship("SS Crusader", "Hoenn", 2400, 1.1, 350, 105000, 388, 10);
		Ship endeavor = new Ship("SS Endeavor", "Sinnoh", 2520, 1.5, 300, 72000, 520, 15);
		Ship titan = new Ship("SS Titan", "Kalos", 2450, 1.5, 320, 85000, 441, 20);
		
		ArrayList<Ship> ship_list = new ArrayList<>(); 
		ship_list.add(voyager);
		ship_list.add(crusader);
		ship_list.add(endeavor);
		ship_list.add(titan);
		return ship_list; 
	}
	
	public    ArrayList<Store> storeConstructor()
	{
		
		// Stocks Constructor 
		// Returns Stores List 
		Stock woodStock = new Stock("Black Wood", "Pile", "A  pile of wood.", 8.0, "Piles of Wood", 15, "Kanto Island", 800 );
		Stock opalStock = new Stock("White Opal", "Pile", "A pile of opals.", 3, "Pile of Opals", 44, "Kanto Island", 1200);
		Stock sugarStock = new Stock("Brown Sugar", "Bag", "A sack filled with sugar.", 6, "sack of Sugar", 18, "Kanto Island", 720);
		Stock saltStock = new Stock("Brown Honey", "Bag", "A bag filled with Honey.", 8, "bag of honey", 13, "Kanto Island", 590);
		Stock wheatStock = new Stock("Brown corn", "Bag", "A  bag filled with a Pop corn.", 4, "Bags of pop corn", 45, "Kanto Island", 670);
		Stock oilStock = new Stock("Olive Oil", "Barrel", "A barrel filled with oil.", 12, "Barrels of Oil", 20, "Johto Island", 1100);
		Stock opiumStock = new Stock("Opium", "Bag", "A bag filled with a pile of opium.", 4, "Pile of Opium", 28, "Johto Island", 1400);
		Stock tobaccoStock = new Stock("Tobacco", "Bag", "A bag filled with a pile of tobacco.", 3, "Pile of Tobacco", 30, "Johto Island", 700);
		Stock coalStock = new Stock("Wood Coal", "Pile", "A pile of coal.", 7, "Pile of Coal", 15, "Johto Island", 569);
		Stock goldStock = new Stock("White Gold", "Brick", "A brick of gold.", 9, "Bricks of Gold", 22, "Johto Island", 1800);
		Stock copperStock = new Stock("Moulded Copper", "Pile", "A pile of copper.", 3, "Pile of Copper", 55, "Hoenn Island", 1000);
		Stock cottonStock = new Stock("Green Cotton", "Bag", "A bag filled with a pile of cotton.", 15, "Pile of cotton", 10, "Hoenn Island", 450);
		Stock silkStock = new Stock("Indian Silk", "Bag", "A bag filled with a pile of silk.", 10, "Pile of silk", 18, "Hoenn Island", 980);
		Stock milkStock = new Stock("White Wine", "Carton", "A carton of milk.", 3, "Cartons of milk", 69, "Hoenn Island", 500);
		Stock fishStock = new Stock("Fresh Fish", "Crate", "A crate filled with fish.", 6, "Crates of fish", 48, "Hoenn Island", 469);
		Stock coffeeStock = new Stock("Coffee", "Bag", "A bag of coffee seeds", 5, "Bags of Coffee Seeds", 40, "Sinnoh Island", 800);
		Stock paperStock = new Stock("Paper", "Stack", "A stack of paper.", 2, "Stacks of Paper", 140, "Sinnoh Island", 560);
		Stock silverStock = new Stock("Silver", "Brick", "A brick of silver.", 2, "Bricks of Silver", 110, "Sinnoh Island", 1400);
		Stock rumStock = new Stock("Red Rum", "Barrel", "A barrel filled with rum.", 10, "Barrels of Rum", 15, "Sinnoh Island", 699);
		Stock freshWaterStock = new Stock("Water", "Barrel", "A barrel filled with drinkable water.", 8, "Barrels of Fresh Water", 24, "Sinnoh Island", 280);
		Stock clothesStock = new Stock("Clothes", "Crate", "A crate filled with clothes.", 6, "Crates of Clothes", 18, "Kalos Island", 500);
		Stock weaponsStock = new Stock("Weapons", "Crate", "A crate filled with different kinds of weapons.", 7, "Crates of Weapons", 18, "Kalos Island", 660);
		Stock toolsStock = new Stock("Tools", "Crate", "A crate filled with different kinds of tools.", 6, "Crate of Toosl", 48, "Kalos Island", 400);
		Stock bricksStock = new Stock("Bricks", "Box", "A box filled with bricks.", 4, "Boxes of Bricks", 70, "Kalos Island", 800);
		Stock meatStock = new Stock("Ship Meat", "Bag", "A bag filled with frozen meat.", 3, "Bags of Meat", 90, "Kalos Island", 749);
		
		 ArrayList<Stock> stock_list1 = new ArrayList<>(); 
		 ArrayList<Stock> stock_list2 = new ArrayList<>(); 
		 ArrayList<Stock> stock_list3 = new ArrayList<>(); 
		 ArrayList<Stock> stock_list4 = new ArrayList<>(); 
		 ArrayList<Stock> stock_list5 = new ArrayList<>(); 
		 stock_list1.add(woodStock);
		 stock_list1.add(opalStock);
		 stock_list1.add(sugarStock);
		 stock_list1.add(saltStock);
		 stock_list1.add(wheatStock);
		 stock_list2.add(oilStock);
		 stock_list2.add(opiumStock);
		 stock_list2.add(tobaccoStock);
		 stock_list2.add(coalStock);
		 stock_list2.add(goldStock);
		 stock_list3.add(copperStock);
		 stock_list3.add(cottonStock);
		 stock_list3.add(silkStock);
		 stock_list3.add(milkStock);
		 stock_list3.add(fishStock);
		 stock_list4.add(coffeeStock);
		 stock_list4.add(paperStock);
		 stock_list4.add(silverStock);
		 stock_list4.add(rumStock);
		 stock_list4.add(freshWaterStock);
		 stock_list5.add(clothesStock);
		 stock_list5.add(weaponsStock);
		 stock_list5.add(toolsStock);
		 stock_list5.add(bricksStock);
		 stock_list5.add(meatStock);
		 
		 Store KalosStore = new Store ("Kalos Island", "Kalos", "Store Located at Kalos Island", "Athena" , 742569, stock_list5, stock_list2);
		 Store SinnohStore = new Store ("Sinnoh Island", "Sinnoh", "Store Located at Sinnoh Island", "Hercules" , 589633, stock_list4, stock_list3);
		 Store HoennStore = new Store ("Hoenn Island", "Hoenn", "Store Located at Hoenn Island", "Acropolis" , 659874, stock_list3, stock_list1);
		 Store kantoStore = new Store ("Kanto Island", "Kanto", "Store Located at Kanto Island", "Parthenon" , 854123, stock_list1, stock_list4);
		 Store johtoStore = new Store ("Johto Island", "Johto", "Store Located at Johto Island", "Acropolis" , 945210, stock_list2, stock_list5);

		 
		 ArrayList<Store> store_list = new ArrayList<>();
		 store_list.add(KalosStore); 
		 store_list.add(SinnohStore); 
		 store_list.add(HoennStore); 
		 store_list.add(johtoStore); 
		 store_list.add(kantoStore); 
		
		 
		 return store_list; 
	}
	

}
