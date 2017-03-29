package items;

import pokemon.Pokemon;

public class MaxHPPotion extends Potion {

	
	public MaxHPPotion(int quantity) {
		super("Max health potion", "Restores all health to your Pokemon.", 50, quantity);
		
	}

	@Override
	public void activate(Pokemon pokemon)
	{
		System.out.println("You used you potion to heal fully " + pokemon.getName());
		this.quantity-=1;
		pokemon.heal(pokemon.getMaxHP()-pokemon.getHp());
	}
}
