package items;

import pokemon.Pokemon;

public class MaxHPPotion extends Potion {

	
	public MaxHPPotion(int quantity) {
		super(quantity, 50);
		
	}
	
	@Override
	public void activate(Pokemon pokemon)
	{
		System.out.println("You used you potion to heal fully " + pokemon.getName());
		this.quantity-=1;
		pokemon.heal(pokemon.getMaxHP()-pokemon.getHp());
	}
}
