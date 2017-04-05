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
	void printAbilities(Pokemon pokemon);
	void printMenu();
	void showPokemon();
	void printMenuForPokemon(Pokemon pokemon);
	int getChosen();
}
