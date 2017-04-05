package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import items.HealPotion;
import items.MaxHPPotion;
import items.StrenghtPotion;
import items.Potion;
import pokemon.Bulbasour;
import pokemon.Caterpie;
import pokemon.Charmander;
import pokemon.Geodude;
import pokemon.Ghastly;
import pokemon.Hitmonchan;
import pokemon.Pidgey;
import pokemon.Pikachu;
import pokemon.Pokemon;
import pokemon.Rattata;
import pokemon.Squirtle;
import main.ConsoleRenderer;

public final class  Player {
	
	static ConsoleRenderer console = new ConsoleRenderer();
	
	private static Scanner input = new Scanner(System.in);
	public static String name;
	private static int money = 200;
	
	private static int numberOfHealingPots = 5;
	private static int numberOfMaxHPPots = 5;
	private static int numberOfStrenghtPots = 5;
	
	private static List<Potion> potions = new ArrayList<>();
	
	private static List<Pokemon> pokemons = new ArrayList<>();
	
	

	public static void initPotions()
	{	

		potions.add(new HealPotion(numberOfHealingPots));
		potions.add(new MaxHPPotion(numberOfMaxHPPots));
		potions.add(new StrenghtPotion(numberOfStrenghtPots));
	}
	
	public static void addPotion(Potion potion)
	{
		if(potion instanceof HealPotion)
		{
			Potion boughtPot = potions.get(0);
			int quantOfPot = boughtPot.getQuantity();
			potions.get(1).setQuantity(quantOfPot+1);
		}else if(potion instanceof MaxHPPotion)
		{
			Potion boughtPot = potions.get(1);
			int quantOfPot = boughtPot.getQuantity();
			potions.get(2).setQuantity(quantOfPot+1);
		}else if(potion instanceof StrenghtPotion)
		{
			Potion boughtPot = potions.get(2);
			int quantOfPot = boughtPot.getQuantity();
			potions.get(3).setQuantity(quantOfPot+1);
		}
		System.out.println("Successfully added to your inventory");
	}
	
	
	public static void choosePokemon(int num)
	{
		switch(num)
		{
		case 1: pokemons.add(new Squirtle());break;
		case 2: pokemons.add(new Bulbasour());break;
		case 3: pokemons.add(new Charmander());break;
		case 4: pokemons.add(new Caterpie());break;
		case 5: pokemons.add(new Geodude());break;
		case 6: pokemons.add(new Ghastly());break;
		case 7: pokemons.add(new Hitmonchan());break;
		case 8: pokemons.add(new Pidgey());break;
		case 9: pokemons.add(new Pikachu());break;
		case 10:pokemons.add(new Rattata());break;
		}
	}
	
	
	private Player(){}

	public static int getMoney() {
		return money;
	}



	public static void setMoney(int money) {
		Player.money = money;
	}
	
	public static int getNumberOfHealingPots() {
		return numberOfHealingPots;
	}

	public static void setNumberOfHealingPots(int numberOfHealingPots) {
		Player.numberOfHealingPots = numberOfHealingPots;
	}

	public static int getNumberOfMaxHPPots() {
		return numberOfMaxHPPots;
	}

	public static void setNumberOfMaxHPPots(int numberOfMaxHPPots) {
		Player.numberOfMaxHPPots = numberOfMaxHPPots;
	}



	public static int getNumberOfStrenghtPots() {
		return numberOfStrenghtPots;
	}



	public static void setNumberOfStrenghtPots(int numberOfStrenghtPots) {
		Player.numberOfStrenghtPots = numberOfStrenghtPots;
	}



	public static String getName() {
		return name;
	}



	public static void setName(String name) {
		Player.name = name;
	}

	public static List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	
}
