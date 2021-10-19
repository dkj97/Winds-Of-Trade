

public class Events
{
	private String event_name; 
	private String event_description; 
	private int event_damage_value; 
	private int event_upgrade_value; 
	
	Events(String name, String description, int damage_value, int upgrade_value)
	{
		
		// Event class constructor 
		
		event_name = name; 
		event_description = description; 
		event_damage_value = damage_value; 
		event_upgrade_value = upgrade_value; 
	}
	
	public String getEventName()
	{
		return event_name; 
	}
	
	public String getEventDescription()
	{
		return event_description; 
	}

	public int getDamageValue()
	{
		return event_damage_value;
	}
	public int getUpgradeValue()
	{
		return event_upgrade_value; 
	}
	

}
