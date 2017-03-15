package pokemon;

public class Charmander extends Pokemon{

	public Charmander(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, name, "fire", "fire");
	}
	
	@Override
	public int flamethrower()
	{
		return this.getAttackDmg();
	}
}
