package items;

import pokemon.Pokemon;

public class HealPotion extends Potion{
	private int healFor;
	
	public HealPotion(int quantity) {
		super(quantity);
		this.healFor = 20;
	}
	
	@Override
	public void activate(Pokemon pokemon)
	{
		System.out.println("You used you potion to heal " + pokemon.getName());
		this.quantity-=1;
		pokemon.heal(healFor);
	}
}
