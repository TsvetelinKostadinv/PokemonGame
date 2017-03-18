package pokemon;

public class Hitmonchan extends Pokemon{

	public Hitmonchan(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "fighting", "fighting");
	}
	public Hitmonchan() {
		super(100, 30, "fighting", "fighting");
	}
	
	@Override
	public int machPunch()
	{
		return this.getAttackDmg();
	}
}
