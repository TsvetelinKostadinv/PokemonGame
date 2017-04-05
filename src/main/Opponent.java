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

public final class Opponent {
	public static final int OPPONENT_COUNT = 5;
	
	static ConsoleRenderer console = new ConsoleRenderer();
	
	private static Scanner input = new Scanner(System.in);
	private static String opponentName;
	private static int opponentMoney = 200;
	
	private static int numberOfHealingPots = 5;
	private static int numberOfMaxHPPots = 5;
	private static int numberOfStrenghtPots = 5;
	
	private static List<Potion> potions = new ArrayList<>();
	
	private static List<Pokemon> pokemons = new ArrayList<>();
	
	private static List<List<Pokemon>> opponents = new ArrayList<List<Pokemon>>(OPPONENT_COUNT);
	
	public static void main(String[] args) {
		initOpponents();
	}

	public static void initOpponents() {
		pokemons.add(new Rattata());
		pokemons.add(new Caterpie());
		pokemons.add(new Geodude());
		
		pokemons.add(new Hitmonchan());
		pokemons.add(new Ghastly());
		pokemons.add(new Caterpie());
		
		pokemons.add(new Hitmonchan());
		pokemons.add(new Ghastly());
		pokemons.add(new Caterpie());
		
		pokemons.add(new Hitmonchan());
		pokemons.add(new Ghastly());
		pokemons.add(new Caterpie());
		
		pokemons.add(new Hitmonchan());
		pokemons.add(new Ghastly());
		pokemons.add(new Caterpie());
		
		opponents.add(pokemons.subList(0, 3));
		
		opponents.add(pokemons.subList(3, 6));
		
		opponents.add(pokemons.subList(6, 9));
		
		opponents.add(pokemons.subList(9, 12));
		
		opponents.add(pokemons.subList(12, 15));
		
		for (int i = 0; i < opponents.size(); i++) {
			System.out.println("Opponent " + (i+1) + " pokemon:");
			for(int j = 0; j < opponents.get(i).size(); j++) {
				Pokemon currentPokemon = opponents.get(i).get(j);//pokemons.get(i);
				System.out.println("["+(j+1)+"]" + currentPokemon.getName());
			}
			System.out.println();
		}
	}
	
	public static void initPotions()
	{	

		potions.add(new HealPotion(numberOfHealingPots));
		potions.add(new MaxHPPotion(numberOfMaxHPPots));
		potions.add(new StrenghtPotion(numberOfStrenghtPots));
	}

	
	private Opponent(){}

	public static int getOpponentMoney() {
		return opponentMoney;
	}

	public static void setOpponentMoney(int opponentMoney) {
		Opponent.opponentMoney = opponentMoney;
	}
	
	public static int getNumberOfHealingPots() {
		return numberOfHealingPots;
	}

	public static void setNumberOfHealingPots(int numberOfHealingPots) {
		Opponent.numberOfHealingPots = numberOfHealingPots;
	}

	public static int getNumberOfMaxHPPots() {
		return numberOfMaxHPPots;
	}

	public static void setNumberOfMaxHPPots(int numberOfMaxHPPots) {
		Opponent.numberOfMaxHPPots = numberOfMaxHPPots;
	}

	public static int getNumberOfStrenghtPots() {
		return numberOfStrenghtPots;
	}

	public static void setNumberOfStrenghtPots(int numberOfStrenghtPots) {
		Opponent.numberOfStrenghtPots = numberOfStrenghtPots;
	}

	public static String getOpponentName() {
		return opponentName;
	}

	public static void setOpponentName(String opponentName) {
		Opponent.opponentName = opponentName;
	}

	public static List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	
}
