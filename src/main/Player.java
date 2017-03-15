package main;

import java.util.Scanner;

import pokemon.Bulbasour;
import pokemon.Charmander;
import pokemon.Pokemon;
import pokemon.Squirtle;

public class Player {
	private Pokemon[] pokemons = new Pokemon[3];
	private Scanner input = new Scanner(System.in);
	private int money=0;
	
	public void printPokemon()
	{
		System.out.println("[1] Squirtle");
		System.out.println("[2] Bulbasour");
		System.out.println("[3] Charmander");
		System.out.println("[4] ??????");
		System.out.println("[5] ??????");
		System.out.println("[6] ??????");
		System.out.println("[7] ??????");
		System.out.println("[8] ??????");
		System.out.println("[9] ??????");
		System.out.println("[10]??????");
	}
	
	
	
	public Player()
	{
		for(int i=0;i<3;i++)
		{
			int num;
			do{
				printPokemon();
				num = input.nextInt();
			}while(num<1 || num>10);
			
			switch(num)
			{
			case 1: pokemons[i] = new Squirtle();break;
			case 2: pokemons[i] = new Bulbasour();break;
			case 3: pokemons[i] = new Charmander();break;
//			case 4: pokemons[i] = new Squirtle();break;
//			case 5: pokemons[i] = new Squirtle();break;
//			case 6: pokemons[i] = new Squirtle();break;
//			case 7: pokemons[i] = new Squirtle();break;
//			case 8: pokemons[i] = new Squirtle();break;
//			case 9: pokemons[i] = new Squirtle();break;
//			case 10: pokemons[i] = new Squirtle();break;
			}
		}
		
	}
	
}
