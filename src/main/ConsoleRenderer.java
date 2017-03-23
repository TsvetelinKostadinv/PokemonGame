package main;

import java.util.Scanner;

import pokemon.Pokemon;

public class ConsoleRenderer implements Renderer{

	@Override
	public void startGame() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello!");
		System.out.println("What is your name?");
		Player.name=input.nextLine();
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
		int chosen = input.nextInt();
		switch(chosen)
		{
		case 1:break;
		case 2:break;
		case 3:break;
		case 4:break;
		case 5:break;
		case 6:break;
		case 7:break;
		case 8:break;
		case 9:break;
		case 10:break;
		}
	}

	@Override
	public void printShop() {
		
		
	}

	@Override
	public void printAbilities(Pokemon pokemon) {

	}

}
