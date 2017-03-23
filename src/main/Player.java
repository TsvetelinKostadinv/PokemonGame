package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import items.HealPotion;
import items.MaxHPPotion;
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
	private static int money=0;
	private static List<Potion> potions = new ArrayList<>();
	
	private static List<Pokemon> pokemons = new ArrayList<>();
	

	public static void initPotions()
	{	
		int numberOfHealingPots = 20;
		int numberOfMaxHPPots = 5;
		int numberOfStrenghtPots = 15;
		potions.add(new HealPotion(numberOfHealingPots));
		potions.add(new MaxHPPotion(numberOfMaxHPPots));
		potions.add(new MaxHPPotion(numberOfStrenghtPots));
	}
	
	
	
	public static void choosePokemon()
	{
		for(int i=0;i<3;i++)
		{
			int num=0;
			do{
				console.printStarterPokemon();
				num = input.nextInt();
			}while(num<1 || num>10);
			
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
	}
	
	
	private Player()
	{
		
	}
	
	
}
