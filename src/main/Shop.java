package main;

import items.Potion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import items.HealPotion;
import items.MaxHPPotion;
import items.StrenghtPotion;
import main.ConsoleRenderer;
import main.Player;

public class Shop {
	private static List<Potion> potions = new ArrayList<>();
	
	 //List<List<Potion>> potions = new ArrayList<>();
//	static List<Potion> healingPotion = new ArrayList<>();
//	static List<Potion> maxHealingPotion = new ArrayList<>();
//	static List<Potion> strenghtPotion = new ArrayList<>();
//    
	static Scanner input = new Scanner(System.in);
	
	public static void initShopItems()
	{	
		int numberOfHealingPots = 20;
		int costOfHealingPots = 50;
		potions.add(new Potion("Health potion", "Restores 25 health to your Pokemon.", costOfHealingPots, numberOfHealingPots));
//		healingPotion.add("Health potion");
//		healingPotion.add("Restores 25 health to your Pokemon.");
//		healingPotion.add(costOfHealingPots);
//		healingPotion.add(numberOfHealing);
		
		
		int numberOfMaxHPPots = 5;
		int costOfMaxHPPots = 100;
		potions.add(new Potion("Max health potion", "Restores all health to your Pokemon.", costOfMaxHPPots, numberOfMaxHPPots));
		
		int numberOfStrenghtPots = 15;
		int costOfStrenghtPots = 50;
		potions.add(new Potion("Strenght potion", "Empowers the moves of your Pokemon.", costOfStrenghtPots, numberOfStrenghtPots));
			
	}
	/* another take on initiating the shop items
	final static int healthPotionNumber = 1;
	final static String healthPotionName = "Health Potion";
	final static int healthPotionCost = 10;
	final static String healthPotionDescription = "Restores 25 health to your Pokemon.";
	
	final static int maxHealthPotionNumber = 2;
	final static String maxHealthPotionName = "Max Health Potion";
	final static int maxHealthPotionCost = 50;
	final static String maxHealthPotionDescription = "Restores all the health of your Pokemon.";
	
	final static int strenghtPotionNumber = 3;
	final static String strenghtPotionName = "Strength Potion";
	final static int strenghtPotionCost = 20;
	final static String strenghtPotionDescription = "Empowers the moves of your Pokemon.";
	*/
	public static void main(String[] args) {
		initShopItems();
		
		
		int choice = -1;
		
		while(hasNotExited(choice)) {
			outputPlayerMoney();
			outputShopItems();
			outputInfo();
			choice = input.nextInt();
			handlePurchases(choice);		
			
			System.out.println();
			System.out.println();
		}
	}
	
	private static void outputPlayerMoney() {
		System.out.println("PlayerName" + /*Player.getName() + */" has " + "$" + Player.getMoney());
	}
	private static void handlePurchases(int choice) {
		if (choice <= potions.size() && choice > 0) {
			System.out.println("You chose the " + potions.get(choice-1).getName() + ". It costs " + potions.get(choice-1).getSellsFor());
		
			buyOrCancelThePurchase(choice);
			
		} else if (choice != 0 /*we exit when choice == 0*/){
			System.out.println("Invalid item number.");
		} else if (choice == 0) {
			System.out.println("You decided to exit.");
		}
	}
	
	private static void buyOrCancelThePurchase(int choice) {
		System.out.println("(b)uy or (c)ancel the purchase");
		
		char decision;
		
		do {
			decision = input.next().charAt(0);
			
			if (decision == 'b') {
				if (Player.getMoney() >= potions.get(choice-1).getSellsFor() && potions.get(choice-1).getQuantity() > 0) {
					System.out.println("Purchased a " + potions.get(choice-1).getName());
					Player.setMoney(Player.getMoney() - potions.get(choice-1).getSellsFor());
					
					//add the potion to the player's inventory
					addPotionToInventory(choice);
					
					potions.get(choice-1).setQuantity(potions.get(choice-1).getQuantity() - 1);
				} else {
					System.out.println("Unable to make the purchase due to unsufficient money or potion quantity.");
				}
			} else if (decision == 'c') {
				System.out.println("You decided not to make the purchase.");
			}
			
		} while (decision != 'b' && decision != 'c');
	}
	
	private static void addPotionToInventory(int choice) {
		if (choice == 1) {
			Player.setNumberOfHealingPots(Player.getNumberOfHealingPots() + 1);
		} else if (choice == 2) {
			Player.setNumberOfMaxHPPots(Player.getNumberOfMaxHPPots() + 1);
		} else if (choice == 3) {
			Player.setNumberOfStrenghtPots(Player.getNumberOfStrenghtPots() + 1);
		}
	}
	private static void outputInfo() {
		System.out.println("Type a number (from 1 to 3) and then type 'b' to buy it or 'c' to cancel the purchase.");
		System.out.println("Type '0' if you want to exit.");
	}
	
	private static boolean hasNotExited(int choice) {
		if (choice == 0) {
			return false;
		}
		return true;
		
	}
	
	static void outputShopItems() {
		//System.out.printf("%d. %s | %s | $%d", healthPotionNumber, healthPotionName, healthPotionDescription, healthPotionCost);
		int index = 0;
		
		String leftAlignFormat = "| %-6d | %-20s | %-37s | $%-5d | %-10d |%n";

		System.out.format("==========================================SHOP=================================================%n");
		System.out.format("+--------+----------------------+---------------------------------------+--------+------------+%n");
		System.out.format("| Num.   | Potion name          | Description                           | Cost   | Quantity   |%n");
		System.out.format("+--------+----------------------+---------------------------------------+--------+------------+%n");
//		for (int i = 0; i < 5; i++) {
//		    System.out.format(leftAlignFormat, "some data" + i, i * i, i, i);
//		    
//		    if (i < 4) {
//		    	System.out.format(".-----------------.---------------.--------.------------.%n");
//		    }
//		}
		for (Potion potion: potions) {
			//System.out.printf("%s | %s | $%d | %d\n", potion.getName(), potion.getDescription(), potion.getSellsFor(), potion.getQuantity());
			
			System.out.format(leftAlignFormat, (index + 1), potion.getName(), potion.getDescription(), potion.getSellsFor(), potion.getQuantity());
		    index++;
		    if (index < Potion.potionTypesCount) {
		    	System.out.format(".--------.----------------------.---------------------------------------.--------.------------.%n");
		    }
		}
		System.out.format("+--------+----------------------+---------------------------------------+--------+------------+%n");
		
	}
	
	
	
}
