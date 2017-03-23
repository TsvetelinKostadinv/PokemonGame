package main;

import pokemon.Pokemon;

public interface Renderer {
	void startGame();
	void printStarterPokemon();
	void printShop();
	void printAbilities(Pokemon pokemon);
}
