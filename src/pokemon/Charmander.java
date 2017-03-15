package pokemon;

public class Charmander extends Pokemon{

	public Charmander(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "fire", "fire");
	}
	
	public Charmander() {
		super(70, 40, "fire", "fire");
	}
	@Override
	public int flamethrower()
	{
		return this.getAttackDmg();
	}
}
