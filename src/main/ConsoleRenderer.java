package main;

public class ConsoleRenderer implements Renderer{

	@Override
	public void startGame() {
		System.out.println("Hello!");
		
	}

	@Override
	public void printStarterPokemon() {
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

	@Override
	public void printShop() {
		// TODO Auto-generated method stub
		
	}

}
