package main;

import items.Potion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pokemon.Pokemon;
import pokemon.*;

import items.HealPotion;
import items.MaxHPPotion;
import items.StrenghtPotion;
import main.ConsoleRenderer;
import main.Player;
import main.Opponent;
import pokemon.Pokemon;
import main.Shop;


public class BattleArena {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		handleBattleInTheArena();
	}
	
	static void handleBattleInTheArena() {
		System.out.println(Opponent.opponents.get(Player.getCurrentOpponent() - 1).size());
		outputBattleStartingInformation();
		
		while(!hasSomeoneWonTheMatch()) {
			outputBattleScene();
			handleOurTurn();
			handleOpponentsTurn();
		}
		
		outputMatchConclusion();
	}
	
	private static void outputMatchConclusion() {
		if (Player.getLivePokemonCount() > 0 && Opponent.getLivePokemonCount(Player.getCurrentOpponent()) <= 0 && !Player.getHasPlayerForfeited()) {
			System.out.println("You won the match.");
			outputUpcomingOpponentInfo();
			awardMoneyToThePlayer();
			
			restoreAllPokemonToFullHealth();
			restorePlayerAndOpponentTeamOrders();
			
			moveUpToNextOpponent();
		} else if ((Player.getLivePokemonCount() <= 0 && Opponent.getLivePokemonCount(Player.getCurrentOpponent()) > 0) || Player.getHasPlayerForfeited()) {
			System.out.println("You lost the match.");
			takeMoneyFromThePlayer();
			
			restoreAllPokemonToFullHealth();
			restorePlayerAndOpponentTeamOrders();
		}
		
		//TODO put methods used both in if and else if here

	}

	private static void restorePlayerAndOpponentTeamOrders() {
		Opponent.setCurrentOpponentPokemon(1);
		Player.setCurrentPokemon(1);
	}

	private static void takeMoneyFromThePlayer() {
		int moneyLost = 0;
		if (Player.getMoney() > Opponent.getOpponentMoney(Player.getCurrentOpponent())/2) {
			moneyLost = Opponent.getOpponentMoney(Player.getCurrentOpponent())/2;
			Player.setMoney(Player.getMoney() - moneyLost);
		} else if (Player.getMoney() <= Opponent.getOpponentMoney(Player.getCurrentOpponent())/2){
			moneyLost = Player.getMoney();
			Player.setMoney(0);
		}
		System.out.println("You lost " + moneyLost + "PokeDollars");
	}

	private static void restoreAllPokemonToFullHealth() {
		System.out.println("Nurse Joy healed all your and " + Opponent.getOpponentName(Player.getCurrentOpponent()) + "'s pokemon back to full health.");
		
		//heal all player pokemon
		for (int i = 0; i < Player.pokemons.size(); i++) {
			Player.pokemons.get(i).heal(Player.pokemons.get(i).getMaxHP() - Player.pokemons.get(i).getHp());
		}
		
		//heal all opponent pokemon
		for (int i = 0; i < Opponent.opponents.get(Player.getCurrentOpponent() - 1).size(); i++) {
			Pokemon opponentPokemon = Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(i); 
			opponentPokemon.heal(opponentPokemon.getMaxHP() - opponentPokemon.getHp());
		}	
	}

	private static void moveUpToNextOpponent() {
		if (Player.getCurrentOpponent() < Opponent.OPPONENT_COUNT) {
			Player.setCurrentOpponent(Player.getCurrentOpponent() + 1);
			Player.setHasPlayerForfeited(false);
			Opponent.setCurrentOpponentPokemon(1); //starting pokemon
		}
	}

	private static void awardMoneyToThePlayer() {
		System.out.println("You won " + Opponent.getOpponentMoney(Player.getCurrentOpponent()) + "PokeDollars");
		Player.setMoney(Player.getMoney() + Opponent.getOpponentMoney(Player.getCurrentOpponent()));
	}

	private static void outputUpcomingOpponentInfo() {
		if (Player.getCurrentOpponent() < Opponent.OPPONENT_COUNT) {
			System.out.println("You can move up to the next opponent - " + Opponent.getOpponentName(Player.getCurrentOpponent() + 1));
		} else if (Player.getCurrentOpponent() == Opponent.OPPONENT_COUNT) {
			System.out.println("You beat all opponents and won the tournament! CONGRATULATIONS :D!");
		}
	}

	private static void outputBattleScene() {
		System.out.printf("%s: %s - HP[%d/%d] \n \n", Player.getName(), Player.pokemons.get(Player.getCurrentPokemon() - 1).getName(), Player.pokemons.get(Player.getCurrentPokemon() - 1).getHp(), Player.pokemons.get(Player.getCurrentPokemon() - 1).getMaxHP());
		System.out.printf("%s: %s - HP[%d/%d] \n \n", Opponent.getOpponentName(Player.getCurrentOpponent()), Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(Opponent.getCurrentOpponentPokemon() - 1).getName(), Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(Opponent.getCurrentOpponentPokemon() - 1).getHp(), Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(Opponent.getCurrentOpponentPokemon() - 1).getMaxHP());
		
	}

	private static void handleOpponentsTurn() {
		//TODO the opponent has more tactical knowledge
		if (Opponent.getLivePokemonCount(Player.getCurrentOpponent()) > 0 && !Player.getHasPlayerForfeited()) {
			boolean doesTheOpponentHaveToSwitchHisPokemon = isTheOpponentsCurrentPokemonAlive();
			handleOpponentPokemonSwitching(doesTheOpponentHaveToSwitchHisPokemon);
			
			int opponentAttackChoice = 1;
			attackPlayerPokemon(opponentAttackChoice); //TODO random(1, 4)
		}
	}

	private static void handleOpponentPokemonSwitching(
			boolean doesTheOpponentHaveToSwitchHisPokemon) {
		
		boolean hasTheOpponentPokemonSwitchBeenMade = false;
		
		if (doesTheOpponentHaveToSwitchHisPokemon) {
			for (int i = 0; i < Opponent.opponents.get(Player.getCurrentOpponent() - 1).size(); i++) {
				if (Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(i).getHp() > 0) {
					Opponent.setCurrentOpponentPokemon(i + 1);
					hasTheOpponentPokemonSwitchBeenMade = true;
					
					break;
				}
			}	
			Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(Opponent.getCurrentOpponentPokemon() - 1).getHp();
		}
	}

	private static boolean isTheOpponentsCurrentPokemonAlive() {
		int currentOpponentPokemonHP = Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(Opponent.getCurrentOpponentPokemon() - 1).getHp();
		if (currentOpponentPokemonHP > 0) {
			return true;
		}
		return false;
	}

	private static void attackPlayerPokemon(int opponentAttackChoice) {
		//TODO this might all not work
		Pokemon currentPlayerPokemon = Player.pokemons.get(Player.getCurrentPokemon() - 1);
		Pokemon currentOpponentPokemon = Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(Opponent.getCurrentOpponentPokemon() - 1); //-1?
		int currentPlayerPokemonHP = currentPlayerPokemon.getHp();
		int opponentCurrentPokemonDamage = currentOpponentPokemon.getAttackDmg();
		int playerPokemonHPAfterOutAttack = currentPlayerPokemonHP - opponentCurrentPokemonDamage;
		currentPlayerPokemon.takeDamage(opponentCurrentPokemonDamage);
		
		currentPlayerPokemonHP = currentPlayerPokemon.getHp();
		
		System.out.println(Opponent.getOpponentName(Player.getCurrentOpponent()) + " attacked your pokemon for " + opponentCurrentPokemonDamage + " damage.");
		if (currentPlayerPokemonHP <= 0) {
			System.out.println("Your pokemon fainted...");
		} else {
			System.out.println("Your pokemon has " + currentPlayerPokemonHP + "HP left...");
		}
	}

	private static void outputTheBeginningOfOurTurn() {
		System.out.println(Player.getName() + "'s turn:");
		System.out.println("-----------------------------");
	}

	private static void handleOurTurn() {
		outputTheBeginningOfOurTurn();
		outputTurnOptions();
		decideHowToProceedWithTurn();
	}

	private static void decideHowToProceedWithTurn() {
		int choice;
		
		System.out.println("Choice: ");
		
		if (Player.pokemons.get(Player.getCurrentPokemon() - 1).getHp() <= 0) {
			choice = 2; //we automatically select to go to the pokemon menu
		} else {//if (Player.pokemons.get(Player.getCurrentPokemon() - 1).getHp() > 0) {
			do {
				choice = input.nextInt();
				
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
					System.out.println("Invalid input, try again.");
				}
			} while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
		}
		
		manageChoice(choice);
	}

	private static void manageChoice(int choice) {
		if (choice == 1) {
			chooseFromAttackOptions();
		} else if (choice == 2) {
			chooseFromPokemonOptions();
		} else if (choice == 3) {
			chooseFromItemOptions();
		} else if (choice == 4) {
			chooseFromForfeitOptions();
		}
	}

	private static void chooseFromForfeitOptions() {
		System.out.println("Do you really want to forfeit? (y)es/(n)o");
		char forfeitChoice;
		
		do {
			forfeitChoice = input.next().charAt(0);
			if (forfeitChoice != 'y' && forfeitChoice != 'n') {
				System.out.println("Invalid choice. Try again.");
			}
		} while (forfeitChoice != 'y' && forfeitChoice != 'n');
		
		handleForfeitChoice(forfeitChoice);
	}

	private static void handleForfeitChoice(char forfeitChoice) {
		if (forfeitChoice == 'y') {
			System.out.println("You forfeited the match!");
			Player.setHasPlayerForfeited(true);
			//TODO
		} else {
			System.out.println("You decided not to forfeit. That's the spirit!");
			decideHowToProceedWithTurn();
		}
	}

	private static void chooseFromPokemonOptions() {
		int pokemonChoice;
		
		//The player has no pokemon attached to him Player.pokemons.size() = 0
		for (int i = 0; i < Player.pokemons.size(); i++) {
			if (Player.getCurrentPokemon() == i + 1) {
				System.out.println("->[" + (i + 1) + "] " + Player.pokemons.get(i).getName() + " HP:" + Player.pokemons.get(i).getHp());
			} else {
				System.out.println("  [" + (i + 1) + "] " + Player.pokemons.get(i).getName() + " HP:" + Player.pokemons.get(i).getHp());
			} 
		}
		
		//because when we are forced to choose our pokemon we can't exit
		if (Player.pokemons.get(Player.getCurrentPokemon() - 1).getHp() > 0) {
			System.out.println("Select a live pokemon to switch to (1-3) or exit (0)");
		}
		
		if (Player.pokemons.get(Player.getCurrentPokemon() - 1).getHp() <= 0) {
			System.out.println("Select a live pokemon to switch to (1-3)");	
		}
		do {
			pokemonChoice = input.nextInt();
			
			if ((pokemonChoice != 1 || (pokemonChoice == 1 && (Player.pokemons.get(0).getHp() <= 0 || Player.getCurrentPokemon() == 1))) && 
					(pokemonChoice != 2 || (pokemonChoice == 2 && (Player.pokemons.get(1).getHp() <= 0 || Player.getCurrentPokemon() == 2))) &&
					(pokemonChoice != 3 || (pokemonChoice == 3 && (Player.pokemons.get(2).getHp() <= 0 || Player.getCurrentPokemon() == 3))) &&
					pokemonChoice != 0) {
				System.out.println("You either selected a non-existent pokemon or a fainted one.");
			}
			
		} while ((pokemonChoice != 1 || (pokemonChoice == 1 && (Player.pokemons.get(0).getHp() <= 0 || Player.getCurrentPokemon() == 1))) && 
				(pokemonChoice != 2 || (pokemonChoice == 2 && (Player.pokemons.get(1).getHp() <= 0 || Player.getCurrentPokemon() == 2))) &&
				(pokemonChoice != 3 || (pokemonChoice == 3 && (Player.pokemons.get(2).getHp() <= 0 || Player.getCurrentPokemon() == 3))) &&
				pokemonChoice != 0);
		
		if (pokemonChoice == 0) {
			decideHowToProceedWithTurn();
		}
		
		Player.setCurrentPokemon(pokemonChoice);
		System.out.println("You switched to " + Player.pokemons.get(Player.getCurrentPokemon() - 1).getName());
	}

	private static void chooseFromItemOptions() {
		outputAvailableItems();
	}

	private static void outputAvailableItems() {
		String leftAlignFormat = "| %-6d | %-20s | %-37s | %-10d |%n";
		
		boolean hasHealingPots = false, hasStrenghtPots = false, hasMaxHPPots = false;
		
		
		//TODO make this work
		if (Player.getNumberOfHealingPots() > 0) {
			hasHealingPots = true;
		}
			System.out.format(leftAlignFormat, 1, "Heal potion", "Restores 25 health to your Pokemon.", Player.getNumberOfHealingPots());
					// NOT WORKING HealPotion.getName(), HealPotion.getDescription(), Player.getNumberOfHealingPots());
			
		//}
		if (Player.getNumberOfStrenghtPots() > 0) {
			hasStrenghtPots = true;
		}
			System.out.format(leftAlignFormat, 2, "Strenght potion", "Empowers the moves of your Pokemon.", Player.getNumberOfStrenghtPots());
					//NOT WORKING StrenghtPotion.getName(), StrenghtPotion.getDescription(), Player.getNumberOfStrenghtPots());
		//}
		if (Player.getNumberOfMaxHPPots() > 0) {
			hasMaxHPPots = true;
		}
			System.out.format(leftAlignFormat, 3, "Max health potion", "Restores all health to your Pokemon.", Player.getNumberOfMaxHPPots());
					// NOT WORKING MaxHPPotion.getName(), MaxHPPotion.getDescription(), Player.getNumberOfMaxHPPots());
		//}
		
		chooseFromPotionOptions(hasHealingPots, hasStrenghtPots, hasMaxHPPots);
	}

	private static void chooseFromPotionOptions(boolean hasHealingPots,
			boolean hasStrenghtPots, boolean hasMaxHPPots) {
		
		int potionChoice;
		
		System.out.println("Select a potion (1 - 3) or leave the inventory (0):");
		
		do {
			potionChoice = input.nextInt();
			if ((potionChoice != 1 || (potionChoice == 1 && !hasHealingPots)) && 
					(potionChoice != 2 || (potionChoice == 2 && !hasStrenghtPots)) && 
					(potionChoice != 3 || (potionChoice == 3 && !hasMaxHPPots)) && potionChoice != 0) {
				System.out.println("Invalid input, or unsufficient potion amount.");
			}
		} while ((potionChoice != 1 || (potionChoice == 1 && !hasHealingPots)) && 
				(potionChoice != 2 || (potionChoice == 2 && !hasStrenghtPots)) && 
				(potionChoice != 3 || (potionChoice == 3 && !hasMaxHPPots)) && potionChoice != 0);
		
		if (potionChoice == 0) {
			System.out.println("Left the shop.");
			decideHowToProceedWithTurn();
		} else if (potionChoice == 1 || potionChoice == 2 || potionChoice == 3) {
			int selectedPokemon = selectedPokemonOnWhichToUseItem();
			handlePotionConsumptionByThePokemon(potionChoice, selectedPokemon);
		}
	}

	private static void handlePotionConsumptionByThePokemon(int potionChoice,
			int pokemonChoice) {
		//TODO MAKE THIS DYNAMIC
		
		Pokemon selectedPokemon = Player.pokemons.get(pokemonChoice - 1);
		
		//selected HealPotion
		if (potionChoice == 1) {
			selectedPokemon.heal(25);
			Player.setNumberOfHealingPots(Player.getNumberOfHealingPots() - 1);
			System.out.println(selectedPokemon.getName() + " consumed a healing potion.");
		} else if (potionChoice == 2) { //StrengthPotion
			selectedPokemon.setAttackDmg(selectedPokemon.getAttackDmg() + 10);
			Player.setNumberOfStrenghtPots(Player.getNumberOfStrenghtPots() - 1);
			System.out.println(selectedPokemon.getName() + " consumed a strength potion.");
		} else if (potionChoice == 3) { //MaxHPPotion
			selectedPokemon.heal(selectedPokemon.getMaxHP());
			Player.setNumberOfMaxHPPots(Player.getNumberOfMaxHPPots() - 1);
			System.out.println(selectedPokemon.getName() + " consumed a maxHP potion.");
		}
	}

	private static int selectedPokemonOnWhichToUseItem() {
		int pokemonChoice;
		
		//The player has no pokemon attached to him Player.pokemons.size() = 0
		for (int i = 0; i < Player.pokemons.size(); i++) {
			System.out.println("  [" + (i + 1) + "] " + Player.pokemons.get(i).getName() + " HP:" + Player.pokemons.get(i).getHp()); 
		}
				
		System.out.println("Select a live pokemon to switch to (1-3) or exit (0)");
		do {
			pokemonChoice = input.nextInt();
					
			if ((pokemonChoice != 1 || (pokemonChoice == 1 && (Player.pokemons.get(0).getHp() <= 0))) && 
					(pokemonChoice != 2 || (pokemonChoice == 2 && (Player.pokemons.get(1).getHp() <= 0))) &&
					(pokemonChoice != 3 || (pokemonChoice == 3 && (Player.pokemons.get(2).getHp() <= 0))) &&
					pokemonChoice != 0) {
				System.out.println("You either selected a non-existent pokemon or a fainted one.");
			}
					
		} while ((pokemonChoice != 1 || (pokemonChoice == 1 && (Player.pokemons.get(0).getHp() <= 0))) && 
					(pokemonChoice != 2 || (pokemonChoice == 2 && (Player.pokemons.get(1).getHp() <= 0))) &&
					(pokemonChoice != 3 || (pokemonChoice == 3 && (Player.pokemons.get(2).getHp() <= 0))) &&
				pokemonChoice != 0);
				
		if (pokemonChoice == 0) {
			decideHowToProceedWithTurn();
		}
				
		//System.out.println("You selected to " + Player.pokemons.get(Player.getCurrentPokemon() - 1).getName());
		return pokemonChoice;//Player.pokemons.get(pokemonChoice - 1);
	}
	

	private static void chooseFromAttackOptions() {
		//TODO test if it works in the ConsoleRendered
		System.out.println(Player.pokemons.get(Player.getCurrentPokemon() - 1).getName() + ": ");
		Player.pokemons.get(Player.getCurrentPokemon() - 1).printAbilities();
		//Caterpie.printAbilities();
		System.out.println("Choose and ability (1 - 4) to attack with or go back (0): ");
		int attackChoice;
		
		do {
			attackChoice = input.nextInt();
			if (attackChoice != 1 && attackChoice != 2 && attackChoice != 3 && attackChoice != 4 && attackChoice != 0) {
				System.out.println("Invalid input. Try again!");
			}
		} while (attackChoice != 1 && attackChoice != 2 && attackChoice != 3 && attackChoice != 4 && attackChoice != 0);
	
		if (attackChoice == 1 || attackChoice == 2 || attackChoice == 3 || attackChoice == 4) {
			attackOpponentPokemon(attackChoice);
			//TODO make the attack type and attack damage count
		} else if (attackChoice == 0) {
			decideHowToProceedWithTurn();
		}
	}


	private static void attackOpponentPokemon(int attackChoice) {
		//TODO this might all not work
		Pokemon currentOpponentPokemon = Opponent.opponents.get(Player.getCurrentOpponent() - 1).get(Opponent.getCurrentOpponentPokemon() - 1); //-1?
		
		int currentOpponentPokemonHP = currentOpponentPokemon.getHp();
		int playerCurrentPokemonDamage = Player.pokemons.get(Player.getCurrentPokemon() - 1).getAttackDmg();
		int opponentPokemonHPAfterOurAttack = currentOpponentPokemonHP - playerCurrentPokemonDamage;
		currentOpponentPokemon.takeDamage(playerCurrentPokemonDamage/*opponentPokemonHPAfterOurAttack*/);
		
		currentOpponentPokemonHP = currentOpponentPokemon.getHp();
		
		System.out.println("You attacked the opponents pokemon for " + playerCurrentPokemonDamage + " damage.");
		if (currentOpponentPokemonHP <= 0) {
			System.out.println("It fainted...");
		} else {
			System.out.println("It has " + currentOpponentPokemonHP + "HP left...");
		}
	}

	private static void outputTurnOptions() {
		if (Player.pokemons.get(Player.getCurrentPokemon() - 1).getHp() <= 0) {
			System.out.println("*) You have to switch your pokemon, because your current one has fainted.");
		}
		//if (Player.pokemons.get(Player.getCurrentPokemon() - 1).getHp() > 0) {
		System.out.println("1) Attack");
		System.out.println("2) Pokemon");
		System.out.println("3) Items");
		System.out.println("4) Forfeit");
		//} else if (Player.pokemons.get(Player.getCurrentPokemon() - 1).getHp() <= 0) {
			
			
		//}
	}

	private static boolean hasSomeoneWonTheMatch() {
		if (Player.getLivePokemonCount() > 0 && Opponent.getLivePokemonCount(Player.getCurrentOpponent()) > 0 && !Player.getHasPlayerForfeited()) {
			return false;
		}
		return true;
	}

	static void outputBattleStartingInformation() {
		System.out.println(Player.getName() + " VS " + Opponent.getOpponentName(Player.getCurrentOpponent()));
		System.out.println(Opponent.getOpponentName(Player.getCurrentOpponent()) + ": " + Opponent.getOpeningWords(Player.getCurrentOpponent()));
	}
}
