package main;

import java.util.ArrayList;
import java.util.List;

import items.HealPotion;
import items.MaxHPPotion;
import items.Potion;
import items.StrenghtPotion;

public class NewShop {
	private static List<Potion> availablePotions = new ArrayList<>();
	
	private final static int maxHPPotsCount = 5;
	private final static int HPPotsCount = 10;
	private final static int StrenghtPotsCount = 10;
	
	
	private static MaxHPPotion maxHPPotion = new MaxHPPotion(maxHPPotsCount);
	private static HealPotion HPPotion = new HealPotion(HPPotsCount);
	private static StrenghtPotion StrenghtPotion = new StrenghtPotion(StrenghtPotsCount);
	
	
	public static void fillShop()
	{
		availablePotions.add(maxHPPotion);
		availablePotions.add(HPPotion);
		availablePotions.add(StrenghtPotion);
	}
	
	public static List<Potion> getAvailablePots()
	{
		return availablePotions;
	}
	
	private NewShop(){}
}
