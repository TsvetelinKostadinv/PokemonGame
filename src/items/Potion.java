package items;

import pokemon.Pokemon;

public class Potion {
	protected int quantity;

	public Potion(int quantity) {
		super();
		this.quantity = quantity;
	}
	
	public void activate()
	{
		this.quantity-=1;
	}

	public void activate(Pokemon pokemon) {
		System.out.println("You used a potion on a pokemon");
		
	}
	
}
