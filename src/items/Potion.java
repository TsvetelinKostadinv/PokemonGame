package items;

import pokemon.Pokemon;

public class Potion {
	protected int quantity;

	private int sellsFor;



	public Potion(int quantity, int sellsFor) {
		super();
		this.quantity = quantity;
		this.sellsFor = sellsFor;
	}
	
	public void activate()
	{
		this.quantity-=1;
	}

	public void activate(Pokemon pokemon) {
		System.out.println("You used a potion on a pokemon");
		
	}
	public int getSellsFor() {
		return sellsFor;
	}

	public void setSellsFor(int sellsFor) {
		this.sellsFor = sellsFor;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
