

public class Item 
{
	
	
	private String item_name, item_unit, item_description; 
	private double item_size; 
	
	
	Item(String name, String unit, String description, double size)
	{
		// Constructor for route class
		item_name = name; 
		item_unit = unit; 
		item_description = description; 
		item_size = size; 
		
	}
	
	public String getItemName()
	{
		// Returns item Name
		return item_name; 
	}
	
	public String getItemUnit()
	{
		// Returns item unit
		return item_unit; 
	}
	
	public String getItemDescription()
	{
		// Returns item description.
		return item_description; 
	}
	public double getItemSize()
	{
		// Returns item size
		return item_size; 
	}
	
	
	

}
