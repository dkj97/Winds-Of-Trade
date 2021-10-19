

import java.util.ArrayList;
import java.util.List;

public class Items {
	private String itemName;
	private String itemDescription;
	private int itemSize;
	private int itemPrice;
	
	
	public List<Object> setItems(String name,String description, int size, int price){
		List<Object> item = new ArrayList<Object>();
		item.add(name);
		item.add(description);
		item.add(size);
		item.add(price);
		return item;
	}
	public List<Object> getWood() {
		return setItems("Wood", "A porous and fibrous structural tissue found in the stems and roots of trees and other woody plants.", 10, 30);
	}
	
	public List<Object> getOpal(){
		return setItems("Opal", "A gemstone consisting of a form of hydrated silica.", 10, 30);
	}
	
	public List<Object> getSugar(){
		return setItems("Sugar", "A sweet crystalline substance obtained from various plants.", 10, 30);
	}
	
	public List<Object> getSalt(){
		return setItems("Salt", "A white crystalline substance that gives seawater its characteristic taste.", 10, 30);
	}
	
	public List<Object> getWheat(){
		return setItems("Wheat", "A cereal which is the most improtant kind grown in temperate regions.", 10, 30);
	}
	
	public List<Object> getOil(){
		return setItems("Oil", "A viscous liquid derived from petroleum, especially for use as a fuel or lubricant..", 10, 30);
	}
	
	public List<Object> getOpium(){
		return setItems("Opium", "A drug used illicitly as a narcotic and occasionally in medicine as an analgesic.", 10, 30);
	}
	
	public List<Object> getTobacco(){
		return setItems("Tobacco", "A preparation of nicotine rich leaves used for smoking or chewing.", 10, 30);
	}
	
	public List<Object> getCoal(){
		return setItems("Coal", "A combustible black or dark brown rock consisting chiefly of carbonized plant matter.", 10, 30);
	}
	
	public List<Object> getGold(){
		return setItems("Gold", "A yellow precious metal used especially in jewellery and to guarantee the value of currencies.", 10, 30);
	}
	
	public List<Object> getCopper(){
		return setItems("Copper", "A red-brown metal which is an unusually good conductor of electricity and heat.", 10, 30);
	}
	
	public List<Object> getCotton(){
		return setItems("Cotton", "A soft white fibrous substance which surrounds the seeds of the cotton plant and is made into textile fibre and thread for sewing.", 10, 30);
	}
	
	public List<Object> getSilk(){
		return setItems("Silk", "A fine, strong, lustrous fibre collected to make thread and fabric.", 10, 30);
	}
	
	public List<Object> getMilk(){
		return setItems("Milk", "An opaque white fluid rich in fat and protein.", 10, 30);
	}
	
	public List<Object> getFish(){
		return setItems("Fish", "A limbless cold-blooded vertebrate animal with gills and fins living wholly in water.", 10, 30);
	}
	
	public List<Object> getCoffee(){
		return setItems("Coffee", "A shrub which yields coffee seeds.", 10, 30);
	}
	
	public List<Object> getPaper(){
		return setItems("Paper", "A material manufactured in thin sheets from the pulp of wood or other fibrous substances.", 10, 30);
	}
	
	public List<Object> getSilver(){
		return setItems("Silver", "A precious shiny greyish-white metal.", 10, 30);
	}
	
	public List<Object> getRum(){
		return setItems("Rum", "An alcoholic spirit distilled from sugar-cane reesidues or molasses.", 10, 30);
	}
	
	public List<Object> getFreshWater(){
		return setItems("Fresh Water", "Water that contains less than 1000mg per litre of dissolved fluids.", 10, 30);
	}
	
	public List<Object> getClothes(){
		return setItems("Clothes", "Items worn to cover the body.", 10, 30);
	}
	
	public List<Object> getWeapons(){
		return setItems("Weapons", "Things designed to inflict bodily harm or physical damage.", 10, 30);
	}
	
	public List<Object> getTools(){
		return setItems("Tools", "A device or implement used to carry out a particular function.", 10, 30);
	}
	
	public List<Object> getBricks(){
		return setItems("Bricks", "A small rectangular block typically made of fired or dried sun-dried clay, used in building.", 10, 30);
	}
	
	public List<Object> getMeat(){
		return setItems("Frozen Meat", "The preserved flesh of an animal, typically a mammal or bird, as food.", 10, 30);
	}

}
