package pokemon;

public class Caterpie extends Pokemon{

	public Caterpie(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "bug", "bug");
	}
	public Caterpie() {
		super(100, 30, "water", "water");
	}
	
	@Override
	public int leechLife()
	{
		//Should be done in the Pokemon.java class it seems
		//heals for 1/4 of the damage dealt
		//if (this.getAttackDmg()/4 + ...)
		return this.getAttackDmg();
	}
}