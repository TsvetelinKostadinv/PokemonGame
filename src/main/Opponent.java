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
	private static String[] opponentName = new String[OPPONENT_COUNT];
	private static String[] openingWords = new String[OPPONENT_COUNT];
	private static int[] opponentMoney = new int[OPPONENT_COUNT];
	
	private static int numberOfHealingPots = 1;
	private static int numberOfMaxHPPots = 1;
	private static int numberOfStrenghtPots = 1;
	
	private static int currentOpponentPokemon = 1;

	private static List<Potion> potions = new ArrayList<>();
	
	private static List<Pokemon> pokemons = new ArrayList<>();
	
	static List<List<Pokemon>> opponents = new ArrayList<List<Pokemon>>(OPPONENT_COUNT);
	
	public static void main(String[] args) {
		initOpponents();
	}

	public static void initOpponents() {
		pokemons.add(new Caterpie());
		pokemons.add(new Geodude());
		pokemons.add(new Rattata());
		
		pokemons.add(new Hitmonchan());
		pokemons.add(new Charmander());
		pokemons.add(new Pidgey());
		
		pokemons.add(new Pikachu());
		pokemons.add(new Ghastly());
		pokemons.add(new Rattata());
		
		pokemons.add(new Bulbasour());
		pokemons.add(new Ghastly());
		pokemons.add(new Caterpie());
		
		pokemons.add(new Caterpie());
		pokemons.add(new Caterpie());
		pokemons.add(new Caterpie());
		
		opponents.add(pokemons.subList(0, 3));
		Opponent.setOpponentName("Bill", 1);
		Opponent.setOpponentMoney(200, 1);
		Opponent.setOpeningWords("Are you ready to get beaten up punk???", 1);
		
		opponents.add(pokemons.subList(3, 6));
		Opponent.setOpponentName("Gill", 2);
		Opponent.setOpponentMoney(300, 2);
		Opponent.setOpeningWords("Huh, you beat Bill but you won't beat me chump!!!", 2);
		
		opponents.add(pokemons.subList(6, 9));
		Opponent.setOpponentName("Kill", 3);
		Opponent.setOpponentMoney(400, 3);
		Opponent.setOpeningWords("You defeated my brothers, PREPARE TO DIE TO KILL!!!", 3);
		
		opponents.add(pokemons.subList(9, 12));
		Opponent.setOpponentName("Hill", 4);
		Opponent.setOpponentMoney(500, 4);
		Opponent.setOpeningWords("You climbed to here but you won't be over to climb over me - Hill!!!", 4);
		
		opponents.add(pokemons.subList(12, 15));
		Opponent.setOpponentName("Till", 5);
		Opponent.setOpponentMoney(1000, 5);
		Opponent.setOpeningWords("Nice job coming so far friend... Gotcha, you are no friend of mine. LET'S D-D-DDDUEL.", 5);
		
		System.out.println();
		System.out.println();
		System.out.println("OPPONENTS");
		System.out.println();
		for (int i = 0; i < opponents.size(); i++) {
			System.out.println("Opponent " + Opponent.getOpponentName(i+1) + " pokemon:");
			for(int j = 0; j < opponents.get(i).size(); j++) {
				Pokemon currentPokemon = opponents.get(i).get(j);//pokemons.get(i);
				System.out.println("["+(j+1)+"]" + currentPokemon.getName());
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	public static void initPotions()
	{	

		potions.add(new HealPotion(numberOfHealingPots));
		potions.add(new MaxHPPotion(numberOfMaxHPPots));
		potions.add(new StrenghtPotion(numberOfStrenghtPots));
	}

	
	private Opponent(){}

	
	public static int getOpponentMoney(int opponentNumber) {
		return opponentMoney[opponentNumber - 1];
	}

	public static void setOpponentMoney(int currentOpponentMoney, int opponentNumber) {
		Opponent.opponentMoney[opponentNumber - 1] = currentOpponentMoney;
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

	public static List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	public static int getLivePokemonCount(int opponentNumber) {

		int opponentLivePokemonCount = Opponent.opponents.get(opponentNumber - 1).size();
		
		for(int j = 0; j < opponents.get(opponentNumber - 1).size(); j++) {
			if (opponents.get(opponentNumber - 1).get(j).getHp() <= 0 ) {
				opponentLivePokemonCount--;
			}	
		}
		
		return opponentLivePokemonCount;
	}

	public static String getOpponentName(int opponentNumber) {
		return opponentName[opponentNumber - 1];
	}

	public static void setOpponentName(String currentOpponentName, int opponentNumber) {
		Opponent.opponentName[opponentNumber - 1] = currentOpponentName;
	}
	
	public static String getOpeningWords(int opponentNumber) {
		return openingWords[opponentNumber - 1];
	}

	public static void setOpeningWords(String currentOpeningWords, int opponentNumber) {
		Opponent.openingWords[opponentNumber - 1] = currentOpeningWords;
	}
	
	public static int getCurrentOpponentPokemon() {
		return currentOpponentPokemon;
	}

	public static void setCurrentOpponentPokemon(int currentOpponentPokemon) {
		Opponent.currentOpponentPokemon = currentOpponentPokemon;
	}
	
}
