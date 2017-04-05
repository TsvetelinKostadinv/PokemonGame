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
	
	public static void boughtAPot(Potion potion)
	{
		if(potion instanceof MaxHPPotion)
		{
			Potion boughtPot = availablePotions.get(0);
			int quantOfPot = boughtPot.getQuantity();
			availablePotions.get(1).setQuantity(quantOfPot-1);
		}else if(potion instanceof HealPotion)
		{
			Potion boughtPot = availablePotions.get(1);
			int quantOfPot = boughtPot.getQuantity();
			availablePotions.get(2).setQuantity(quantOfPot+1);
		}else if(potion instanceof StrenghtPotion)
		{
			Potion boughtPot = availablePotions.get(2);
			int quantOfPot = boughtPot.getQuantity();
			availablePotions.get(3).setQuantity(quantOfPot+1);
		}
	}
	
	public static List<Potion> getAvailablePots()
	{
		return availablePotions;
	}
	
	private NewShop(){}
}
