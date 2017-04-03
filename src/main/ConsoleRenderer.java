package main;

import java.util.List;
import java.util.Scanner;

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

public class ConsoleRenderer implements Renderer{
	private static final int inMenu = 0;
	private static final int inShop = 0;
	private static final int inArena = 0;
	private static final int inBattle = 0;
	private static int chosen;
	
	private static int whereAreWe = inMenu;
	@Override
	public void startGame() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello!");
		System.out.println("What is your name?");
		Player.setName(input.nextLine());
		
		for(int i=0;i<3;i++)
		{
			printStarterPokemon();
			int chosenPokemon = getChosen();
			System.out.println("Do you choose him?");
			System.out.println("[1]Yes    [2]No");
			int choice = input.nextInt();
			while(choice!=1)
			{
				printStarterPokemon();
				chosenPokemon = getChosen();
				System.out.println("Do you choose him?");
				System.out.println("[1]Yes      [2]No");
				choice = input.nextInt();
				if(choice==2)
				{
					printStarterPokemon();
				}else{
					Player.choosePokemon(chosenPokemon);
				}
				
			}
		}
		input.close();
	}

	@Override
	public void printStarterPokemon() {
		System.out.println("[1] Squirtle");
		System.out.println("[2] Bulbasour");
		System.out.println("[3] Charmander");
		System.out.println("[4] Caterpie");
		System.out.println("[5] Geodude");
		System.out.println("[6] Ghastly");
		System.out.println("[7] Hitmonchan");
		System.out.println("[8] Pidgey");
		System.out.println("[9] Pikachu");
		System.out.println("[10]Rattata");
		System.out.println("Insert the number of"
				+ " the pokemon you want to view");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		setChosen(choice);
		switch(choice)
		{
		case 1:new Squirtle().printInfo();break;
		case 2:new Bulbasour().printInfo();break;
		case 3:new Charmander().printInfo();break;
		case 4:new Caterpie().printInfo();break;
		case 5:new Geodude().printInfo();break;
		case 6:new Ghastly().printInfo();break;
		case 7:new Hitmonchan().printInfo();break;
		case 8:new Pidgey().printInfo();break;
		case 9:new Pikachu().printInfo();break;
		case 10:new Rattata().printInfo();break;
		}
		input.close();
	}

	@Override
	public void printMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello "+Player.getName());
		System.out.println("Where do you want to go?");
		System.out.println("[1] Arena");
		System.out.println("[2] Shop");
		System.out.println("[3] View my pokemon");
		int choice=2;
		choice = input.nextInt();
		switch(choice)
		{
		case 1://Arena, THIS IS SPARTAAAA;
			break;
		case 2: printShop();whereAreWe = inShop;
			break;
		case 3: showPokemon();
			break;
		default:printMenu();
		}
		input.close();
	}

	@Override
	public void showPokemon() {
		
		Scanner input = new Scanner(System.in);
		int choice;
		List<Pokemon> pokemons =Player.getPokemons();
		
		System.out.println("[0]Exit");
		for(int i=0;i<pokemons.size();i++)
		{
			Pokemon currentPokemon = pokemons.get(i);
			System.out.println("["+(i+1)+"]" + currentPokemon.getName());
		}
		do{
			System.out.println("Input the number you choose");
			choice = input.nextInt();
			if(choice==0)
			{
				break;
			}else{
				Pokemon chosenPokemon = pokemons.get(choice);
				chosenPokemon.printInfo();
				printMenuForPokemon(chosenPokemon);
			}
		}while(choice!=0);
		
		for(int i=0;i<50;i++) System.out.println("");
		printMenu();
		input.close();
	}

	@Override
	public void printMenuForPokemon(Pokemon pokemon) {
		System.out.println("[1]View abilities");
		System.out.println("[2]Change name");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		if(choice==1)
		{
			pokemon.printAbilities();
		}else if(choice == 2)
		{
			System.out.print("Insert the new name: ");
			pokemon.setName(input.next());
		}
		input.close();
	}
	
	@Override
	public void printShop() {
		List<Potion> potionsToPrint = NewShop.getAvailablePots();
		System.out.println("You have "+Player.getMoney()+" PokeDollars");
		for(int i=0;i<potionsToPrint.size();i++)
		{
			Potion currentPot = potionsToPrint.get(i);
			System.out.println("["+i+"] "+ currentPot.getName()+
			"("+currentPot.getQuantity()+" available)");
		}
	}
	
	@Override
	public void printAbilities(Pokemon pokemon) {
		pokemon.printAbilities();
		
	}

	
	public void setChosen(int n) {
		chosen=n;
	}
	@Override
	public int getChosen(){
		return chosen;
	}
}
