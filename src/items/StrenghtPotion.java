package items;

import pokemon.Pokemon;
import items.HealPotion;
import items.MaxHPPotion;
import items.Potion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import items.HealPotion;
import items.MaxHPPotion;
import items.StrenghtPotion;
import main.ConsoleRenderer;


public class StrenghtPotion extends Potion{
	private int increaseFor;
	
	public StrenghtPotion(int quantity) {
		super("Strenght potion", "Empowers the moves of your Pokemon.", 20, quantity);
		increaseFor = 10;
	}
	
	@Override
	public void activate(Pokemon pokemon)
	{
		System.out.println("You used you potion to double the attack of " + pokemon.getName());
		this.quantity-=1;
		pokemon.setAttackDmg(increaseFor+pokemon.getAttackDmg());
	}
}
