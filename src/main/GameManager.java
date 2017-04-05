package main;

public class GameManager {
	private static ConsoleRenderer console = new ConsoleRenderer();
	
	public static void startGame()
	{
		console.startGame();
		NewShop.fillShop();
	}
	
	
	
	public static void main(String[] args)
	{
		GameManager.startGame();
		
		System.out.println(Player.getPokemons());
		console.printMenu();
	}
}
