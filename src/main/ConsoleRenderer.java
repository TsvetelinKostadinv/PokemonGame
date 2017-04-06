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
	private static Scanner input = new Scanner(System.in);
	private boolean named = false;

//	public void main(String args) {
//		showPokemon();
//	}
	
	@Override
	public void startGame() {
		askForPlayerName();
		for(int i=0;i<3;i++)
		{
			chooseOnePokemon();
		}
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
	}

	@Override
	public void printMenu() {
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
			BattleArena.handleBattleInTheArena();
			whereAreWe = inArena;
			printMenu(); //we return to the menu after the battle has concluded
			break;
		case 2: 
			printShop();
			whereAreWe = inShop;
			break;
		case 3: 
			showPokemon();
			break;
		default:
			printMenu();
		}
	}

	@Override
	public void showPokemon() {
		
		int choice;
		List<Pokemon> pokemons =Player.getPokemons();
		if(!named)
		{
			initPokemonNames();
			named=true;
		}
		
		
		do{
			System.out.println("[0]Exit");
			showAvailablePokemon();
			System.out.println("Input the number you choose");
			choice = input.nextInt();
			if(choice==0)
			{
				break;
			}else{
				Pokemon chosenPokemon = pokemons.get(choice-1);
				chosenPokemon.printInfo();
				printMenuForPokemon(chosenPokemon);
			}
		}while(choice!=0);
		
		printMenu();
	}

	@Override
	public void printMenuForPokemon(Pokemon pokemon) {
		System.out.println("[0]Exit");
		System.out.println("[1]View abilities");
		System.out.println("[2]Change name");
		int choice = input.nextInt();
		if(choice==1)
		{
			pokemon.printAbilities();
		}else if(choice == 2)
		{
			System.out.print("Insert the new name: ");
			pokemon.setName(input.next());
		}else if(choice == 0)
		{
			printMenu();
			whereAreWe = inMenu;
		}
	}
	
	@Override
	public void printShop() {
		List<Potion> potionsToPrint = NewShop.getAvailablePots();
		System.out.println("You have "+Player.getMoney()+" PokeDollars");
		System.out.println("[0]Exit");
		for(int i=0;i<potionsToPrint.size();i++)
		{
			Potion currentPot = potionsToPrint.get(i);
			System.out.println("["+(i+1)+"] "+ currentPot.getName()+
			"("+currentPot.getQuantity()+" available)"+
					" costing "+currentPot.getSellsFor()+" pokedolars");
		}
		int choice = input.nextInt();
		switch(choice)
		{
		case 0: whereAreWe = inMenu;break;
		case 1: buyPotion(potionsToPrint.get(0));break;
		case 2: buyPotion(potionsToPrint.get(1));break;
		case 3: buyPotion(potionsToPrint.get(2));break;
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

	@Override
	public void askForPlayerName() {
		System.out.println("Hello!");
		System.out.println("What is your name?");
		Player.setName(input.nextLine());
		
	}

	@Override
	public void chooseOnePokemon() {

		int choice;
		do
		{
			printStarterPokemon();
			int chosenPokemon = getChosen();
			System.out.println("Do you choose him?");
			System.out.println("[1]Yes      [2]No");
			choice = input.nextInt();
			if(choice==2)
			{
				printStarterPokemon();
			}else{
				Player.choosePokemon(chosenPokemon);
				System.out.println("Successufully added a pokemon");
			}
			
		}while(choice!=1);
		
	}

	@Override
	public void buyPotion(Potion potion) {
		if(Player.getMoney()>potion.getSellsFor())
		{
			Player.setMoney(Player.getMoney()-potion.getSellsFor());
			Player.addPotion(potion);
			NewShop.boughtAPot(potion);
		}
		whereAreWe = inMenu;
		printMenu();
		
		
	}

	@Override
	public void initPokemonNames() {
		List<Pokemon> pokemons = Player.getPokemons();
		for(int i=0;i<pokemons.size();i++)
		{
			Pokemon currentPokemon = pokemons.get(i);
			System.out.println("Insert a name for your Pokemon: ");
			String pokemonName = input.next();
			currentPokemon.setName(pokemonName);
			System.out.println("["+(i+1)+"]" + currentPokemon.getName());
		}
		
	}

	@Override
	public void showAvailablePokemon() {
		List<Pokemon> pokemons = Player.getPokemons();
		for(int i=0;i<pokemons.size();i++)
		{
			System.out.println("["+(i+1)+"]"+pokemons.get(i).getName());
		}
	}
}
