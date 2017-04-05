package main;

import items.Potion;
import pokemon.Pokemon;

public interface Renderer {
	void startGame();
	void askForPlayerName();
	void printStarterPokemon();
	void chooseOnePokemon();
	
	void printShop();
	void buyPotion(Potion potion);
	
	void printMenu();
	
	void initPokemonNames();
	void showPokemon();
	void showAvailablePokemon();
	void printMenuForPokemon(Pokemon pokemon);
	void printAbilities(Pokemon pokemon);
	
	int getChosen();
}
