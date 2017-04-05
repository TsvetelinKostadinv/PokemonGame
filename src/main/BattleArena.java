package main;

import items.Potion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pokemon.Pokemon;

import items.HealPotion;
import items.MaxHPPotion;
import items.StrenghtPotion;
import main.ConsoleRenderer;
import main.Player;
import main.Opponent;


public class BattleArena {
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		outputBattleStartingInformation();
		
	
		
		while(!hasSomeoneWonTheMatch()) {
			handleOurTurn();
			handleOpponentsTurn();
		}
	}
	
	private static void handleOpponentsTurn() {
		
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
		// TODO Auto-generated method stub
		
	}

	private static void outputTurnOptions() {
		System.out.println("1) Attack");
		System.out.println("2) Pokemon");
		System.out.println("3) Items");
		System.out.println("4) Forfeit");
	}

	private static boolean hasSomeoneWonTheMatch() {
		if (Player.getLivePokemonCount() > 0 && Opponent.getLivePokemonCount() > 0) {
			return false;
		}
		return true;
	}

	static void outputBattleStartingInformation() {
		System.out.println(Player.getName() + " VS " + Opponent.getName());
		System.out.println(Opponent.getName() + ": " + Opponent.getOpeningWords());
	}
}
