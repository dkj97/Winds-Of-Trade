

public class Islands 

{
	// Island Attributes 
	
	private String island_name; 
	private String island_location; 
	private String island_description; 
	
	// Constructor for Island class 
	Islands(String name, String location, String description)
	{

		island_name = name; 
		island_location = location; 
		island_description = description; 
	}
	
	public String getIslandName()
	{
		return island_name; 
	}
	public String getIslandLocatin()
	{
		return island_location; 
	}
	public String getIslandDescription()
	{
		return island_description; 
	}
	
	public String getProperties()
	{
		String properties = "\n-----------Island Properties-----------------\n\nIsland Name: " + island_name
				+ "\nIsland Location: " + island_location + "\nIsland Description: " + island_description; 
		return properties; 
	}
	
	public String getPropertiesGUI()
	{
		String properties = "Island Name: " + island_name
				+ "\nIsland Location: " + island_location + "\nIsland Description: " + island_description; 
		return properties; 
	}

}
