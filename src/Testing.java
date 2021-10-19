import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void eventsTest() {
		//
		Events theEvent = new Events("Storm Attack", "Damages the ship", 45, 50);
		
		assertEquals("Storm Attack", theEvent.getEventName());
		assertEquals("Damages the ship", theEvent.getEventDescription());
		assertEquals(45, theEvent.getDamageValue());
		assertEquals(50, theEvent.getUpgradeValue());
		

	}
	
	@Test
	void testIsland() {
		//
		Islands theIsland = new Islands("Kanto Island", "Kanto", "An island famous for delicious food");
		
		assertEquals("Kanto Island", theIsland.getIslandName());
		assertEquals("Kanto", theIsland.getIslandLocatin());
		assertEquals("An island famous for delicious food", theIsland.getIslandDescription());
		
	}
	
	@Test
	void testItem() {
		//
		Item theItem = new Item("Shiny Sword", "10", "It is long and light weighted", 2.0);
		
		assertEquals("Shiny Sword", theItem.getItemName());
		assertEquals("10", theItem.getItemUnit());
		assertEquals("It is long and light weighted", theItem.getItemDescription());
		assertEquals(2.0, theItem.getItemSize());
	}
	
	@Test
	void testShip() { 
		//
		Ship theShip = new Ship("Voyager", "Kanto", 10.0, 100.0, 50.0, 1000.0, 4.0, 5);
		
		assertEquals("Voyager", theShip.getShipName());
		assertEquals("Kanto", theShip.getLocation());
		assertEquals(10.0, theShip.getShipSpeed());
		assertEquals(100.0, theShip.getShipEndurance());
		assertEquals(50.0, theShip.cargoCapacity());
		assertEquals(1000.0, theShip.getShipCoins());
		assertEquals(4.0, theShip.getWages());
		assertEquals(5, theShip.getCrewsize());
		
		//
		theShip.setShipEndurance(90.0);
		assertEquals(90.0, theShip.getShipEndurance());
		
		//
		theShip.inflictDamage(20.0);
		assertEquals(80.0, theShip.getShipHealth());
	}

	
	@Test
	void testStock() {
		//
		Stock theStock = new Stock("Clock", "5", "It shows the time of the day", 2.3, "Clock", 3, "Kanto", 1.3);
		
		assertEquals("Clock", theStock.getItemName());
		assertEquals("5", theStock.getItemUnit());
		assertEquals("It shows the time of the day", theStock.getItemDescription());
		assertEquals(2.3, theStock.getItemSize());
		assertEquals(3, theStock.getStockamount());
		assertEquals(1.3, theStock.getUnitPrice());
	
		
	}
	
	@Test
	void testRoute() {
		//
		Route theRoute = new Route("Nafkratousa", "Kanto", "Johto", "A route from Kanto to Johto.", 12520);
		
		assertEquals("Nafkratousa", theRoute.getRouteName());
		assertEquals("Kanto", theRoute.getStartlocation());
		assertEquals("Johto", theRoute.getDestinationLocation());
		assertEquals(12520, theRoute.getDistance());
		assertEquals(12520, theRoute.getNumberofDays(1.0));
	}

	
	@Test
	void testTrader() {
		//
		Trader theTrader = new Trader("Dan", 23.0);
		
		assertEquals("Dan", theTrader.getName());
		assertEquals(23.0, theTrader.getNumdays());
		
		
		//
		theTrader.setNumberOfDays(30.0);
		
		assertEquals(30.0, theTrader.getNumdays());

	}
	
	
}
