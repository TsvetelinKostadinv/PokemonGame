package pokemon;

public class Squirtle extends Pokemon{

	public Squirtle(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "water", "water");
	}
	public Squirtle() {
		super(100, 30, "water", "water");
	}
	
	@Override
	public int hidroPump()
	{
		return this.getAttackDmg();
	}
}
