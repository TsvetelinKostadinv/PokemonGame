package items;

import pokemon.Pokemon;

public class HealPotion extends Potion{
	private int healFor;
	
	public HealPotion(int quantity) {
		super("Health potion", "Restores 25 health to your Pokemon.", 10, quantity);
		this.healFor = 20;
	}
	
	int getHealFor() {
		return healFor;
	}
	
	@Override
	public void activate(Pokemon pokemon)
	{
		System.out.println("You used you potion to heal " + pokemon.getName());
		this.quantity-=1;
		pokemon.heal(healFor);
	}

}
