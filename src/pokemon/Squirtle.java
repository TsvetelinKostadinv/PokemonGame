package pokemon;

public class Squirtle extends Pokemon{

	public Squirtle(int maxHP, int attackDmg, String name, String primaryAttr, String secondaryAttr) {
		super(maxHP, attackDmg, name, primaryAttr, secondaryAttr);
	}
	@Override
	public int hidroPump()
	{
		return this.getAttackDmg();
	}
}
