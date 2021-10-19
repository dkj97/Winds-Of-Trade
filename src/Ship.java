import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Sofonias Tekele Tesfaye
 *
 */
public class Ship 
{
	private static final double HEALTH = 100; 

	private double capacity, endurance, health, speed, wages_per_day, coins, repair_cost, loaded_capacity=0, initial_coins; 
	private String name, location; 
	private int crew_size; 
	private int upgrade = 0; 
	private ArrayList<Stock> stock_list = new ArrayList<>();
	
	Ship(String name, String location, double speed, double endurance, double capacity, double coins, double wages_per_day,
			int crew_size)
	{
		this.speed = speed; 
		this.name = name; 
		this.location = location; 
		this.endurance = endurance; 
		this.capacity = capacity; 
		this.coins = coins; 
		this.wages_per_day = wages_per_day; 
		this.crew_size = crew_size; 
		
		
		// default values 
		health = 100; 
		repair_cost = 80; 
		initial_coins  = coins; 
		
	
	}
	
	
	// Getters 
	
	public int getUpgrade()
	{
		return upgrade; 
	}
	public String getShipName()
	{
		return name; 
	}
	
	public int getCrewsize()
	{
		return crew_size;
	}
	
	public String getLocation()
	{
		return location; 
	}
	
	public double cargoCapacity()
	{
		return capacity; 
	}
	
	public ArrayList<Stock> getShipStockList()
	{
		return stock_list; 
	}
	
	public double getShipCoins()
	{
		return coins; 
	}

	public static double getDefaultHealth() 
	{
		return HEALTH;
	}

	public double getShipSpeed() 
	{
		return speed;
	}
	
	public double getShipHealth() 
	{
		return health;
	}
	public double getWages() 
	{
		return wages_per_day;
	}

	public void setShipSpeed(double ship_speed) 
	{
		this.speed = ship_speed;
	}

	public double getRepairCost() 
	{
		return repair_cost;
	}
	

	public void setWages(double wages) 
	{
		this.wages_per_day = wages;
	}

	public double getShipEndurance()
	{
		return endurance;
	}
	
	public double profit()
	{
		return coins - initial_coins; 
	}
	
	// Sets ship health to default and returns report 
	public String repairShip() 
	{
		double damage = (HEALTH - health); 
		double cost_of_damage = damage*repair_cost; 
		if (coins >= cost_of_damage)
		{
			coins = coins - cost_of_damage; 
			health = HEALTH; 
			return "\n------Ship repaired successfuly--------\n\nCost of repair: " + cost_of_damage; 
		}
		
		return "\nYou dont have enough coins to repair your ship"; 
	}
	
	
	// Returns Ship properties 
	public String getProperties()
	{
		String property = "\n-----------------Ship Properties----------------\n\n"+"Ship Name " + name  + 
				"			Ship Location " + location + " Island\n" + "Ship Crew Size " + 
				crew_size + "			Ship Loading Capacity " + capacity + " units" + "\n" 
				+ "Ship Endurance " + endurance  + "			Ship Coins " + coins  + "\n" + 
				"Repair cost " + repair_cost + " per unit of damage" + "	Ship Health " + health +
				" %" + "\n" + "Ship wages per day " + wages_per_day + "		Ship free space: " + (capacity - loaded_capacity); 
		return property; 
	}

	//Returns Ship properties modified to work well with the GUI.
	
	public String getPropertiesGUI()
	{
	String property = "Ship Name: " + name  + "\n" +
	"Ship Location: " + location + " Island\n" + "Ship Crew Size: " +
	crew_size + "\nShip Loading Capacity: " + capacity + " units" + "\n"
	+ "Ship Endurance: " + endurance  + "\n" + "Ship Coins: " + Math.floor(coins)  + "\n" +
	"Repair cost: " + repair_cost + " per unit of damage" + "\n" + "Ship Health: " + health +
	" %" + "\n" + "Ship wages per day " + wages_per_day + "\n";
	return property;
	}

	
	
	//Setter methods 

	public void setRepairCost(double repair_cost) 
	{
		this.repair_cost = repair_cost;
	}

	
	public void setShipHealth(double ship_health) 
	{
		this.health = ship_health;
	}
	public void inflictDamage(double amount)
	{
		health = health - amount; 
	}
	public void creditHealth(double amount)
	{
		health = health + amount; 
		if (health > HEALTH)
		{
			health = HEALTH; 
		}
		
	}

	public void emptyStock() 
	{
		stock_list.clear();
	}

	public void setShipEndurance(double ship_endurance) 
	{
		this.endurance = ship_endurance;
	} 
	

	// Checks if ship has space for stock of given size
	public boolean canAddStock(double size)
	{
		if (size > (capacity - loaded_capacity))
		{
			return false; 
		}
		else
		{
			return true; 
		}
		
	}
	
	// Checks if ship health is equal to default health 
	public boolean canSail()
	{
		if (health==HEALTH)
		{
			return true; 
		}
		else
		{
			return false; 
		}
		
	}
	
	public double getSailCost(double num_of_days)
	{
		return num_of_days * wages_per_day; 
	}
	public boolean canPay(double num_of_days)
	{
		if (coins >= (num_of_days * wages_per_day))
		{
			return true; 
		}
		else
		{
			return false; 
		}
	}
	
	// Checks if ship has enough coins to buy an item
	public boolean canPurchase(double price)
	{
		if (coins >= (price))
		{
			return true; 
		}
		else
		{
			return false; 
		}
	}
	
	public void addShipStock(Stock stc)
	{
		stock_list.add(stc); 
	}
	public void sail(String location)
	{
		this.location = location; 
	}
	
	public void payCoins(double number_of_days)
	{
		coins = coins - (number_of_days * wages_per_day); 
	}
	
	public void buyStock(double price)
	{
		coins = coins - (price); 
	}
	
	public ArrayList<Stock> getStockList()
	{
		return stock_list; 
	}
	
	// Returns properties of the stock that the ship is carrying 
	public String getShipStockProperties()
	{
		String ship_stock_properties="\n------------------Ship Stock---------------------\n";
		for (int i = 0; i < stock_list.size(); i ++)
		{
			ship_stock_properties = "\n" + ship_stock_properties + stock_list.get(i).getProperties(i+1); 
		}
		
		return ship_stock_properties;  
	}


	public void addCoins(double sales) 
	{
		coins = coins + sales; 
		
	}
	
	public void setLoadedCapacity(double load) 
	{
		loaded_capacity = loaded_capacity + load; 
		
	}


	public void removeStock(int index) 
	{
		stock_list.remove(index); 
		
	}
	
	public double getProfit()
	{
		return coins - initial_coins; 
	}


}
