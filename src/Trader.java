
public class Trader 
{
	private String name; 
	private double number_of_days; 
	private double elapsed_days = 0;
	private boolean end_game_id = false; 
	
	Trader(String name, double days)
	{
		this.name = name; 
		number_of_days = days; 
	}
	
	public boolean getEndGameID()
	{
		return end_game_id; 
	}
	public String getName()
	{
		return name; 
	}
	
	public double getNumdays()
	{
		return number_of_days; 
		
	}
	
	public void setNumberOfDays(double days)
	{
		number_of_days = days; 
	}
	
	public void setElapsedDays(double days)
	{
		elapsed_days = days;
	}
	
	public void setEndGameID(boolean var)
	{
		end_game_id = var; 
	}
	public double getElapsedDays()
	{
		return elapsed_days; 
	}
	
	public void addElapsedDays(double days)
	{
		elapsed_days += days; 
	}
	
	public double getRemainingDays()
	{
		return number_of_days - Math.floor(elapsed_days); 
	}
	
	
	public String getproperties()
	{
		String properties; 
		properties = "\n----------Trader Properties -----------\n"+ "Trader Name     " + name + "\n" + "Trading days    " + number_of_days + "\n" + 
		"Elapsed days    " + Math.floor(elapsed_days) + "\n" + "Remaining days  " + Math.floor(getRemainingDays());
		return properties; 
	}
	
	public String getEndgameValues(Ship selectedShip)
	{
		String EndgameMessage; 
		EndgameMessage = "\n---------- Game Over -----------\n"+ "Trader Name     " + name + "\n" + "Trading days    " + number_of_days + "\n" + 
		"Journey days    " + Math.floor(elapsed_days) + "\n" + "Ship Name	" + selectedShip.getShipName() + "\nProfit made	" + Math.floor(selectedShip.getProfit())
		+ "\nGame Score	"+ Math.floor((elapsed_days * 117)); 
		return EndgameMessage; 
	}
	

}
