
public class Stock extends Item

{
	// Stock class Attributes 
	
	private String stock_name; 
	private double buying_price; 
	private String source; 
	private int amount; 
	double unit_price;
	int sold_amount=0; 
	
	

	//Stock class constructor 
	Stock(String name, String unit, String description, double size, String stock_name, int amount, String source, double unit_price) 
	{
		super(name, unit, description, size);
		this.stock_name = stock_name; 
		this.amount = amount;
		this.source = source; 
		this.unit_price = unit_price; 
		
	}
	
	
	// Getter and setter methods

	public int getStockamount()
	{
		return amount; 
	}
	
	public double getUnitPrice()
	{
		return unit_price; 
	}
	
	public void setUnitPrice(double unit_price)
	{
		this.unit_price = unit_price; 
	}
	
	public double getTotalSize()
	{
		return (amount * this.getItemSize() ); 
	}
	
	public double getTotalPrice()
	{
		return (amount * unit_price ); 
	}
	
	public void setBuyingPrice(double price)
	{
		buying_price = price; 
	}
	
	
	public void addSoldAmount(int amount)
	{
		sold_amount = sold_amount + amount; 
	}
	
	public int stockAmount()
	{
		return amount-sold_amount; 
	}
	
	public String getProperties(int i)
	{
		String properties = ""; 
		properties = properties + i + ". " + "Item name: " + this.getItemName()  + "	Source: " + source +  
				"\tUnit Price: " + unit_price + "\tAvailable amount: " + stockAmount() + "\n"; 
		return properties; 
	}
	
	public String forpurchaseItemsProperties(int i)
	{
		String properties = ""; 
		properties = properties + i + ". " + "Item name: " + this.getItemName() +  
				"\tBuying Price: " + Math.floor(unit_price * 1.15) + "\n"; 
		return properties; 
	}
	
	
	

}
