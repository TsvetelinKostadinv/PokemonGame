package main;

import java.util.List;
import java.util.Scanner;

import pokemon.Pokemon;

public class ConsoleRenderer implements Renderer{

	@Override
	public void startGame() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello!");
		System.out.println("What is your name?");
		Player.setName(input.nextLine());;
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
	}

	@Override
	public void printShop() {
		
		
	}

	@Override
	public void printMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Where do you want to go?");
		System.out.println("[1]Arena");
		System.out.println("[2]Shop");
		System.out.println("[3]View my pokemon");
		int choice = input.nextInt();
		switch(choice)
		{
		case 1://Arena, THIS IS SPARTAAAA;
			break;
		case 2://Print the shop
			break;
		case 3: showPokemon();
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
	public void printAbilities(Pokemon pokemon) {
		pokemon.printAbilities();
		
	}
}
