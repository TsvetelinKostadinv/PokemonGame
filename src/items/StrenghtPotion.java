package items;

import pokemon.Pokemon;

public class StrenghtPotion extends Potion{
	private int increaseFor;
	
	public StrenghtPotion(int quantity) {
		super(quantity, 20);
		increaseFor = 10;
	}
	
	@Override
	public void activate(Pokemon pokemon)
	{
		System.out.println("You used you potion to heal " + pokemon.getName());
		this.quantity-=1;
		pokemon.setAttackDmg(increaseFor+pokemon.getAttackDmg());
	}
}
