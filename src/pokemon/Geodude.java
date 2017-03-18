package pokemon;

public class Geodude extends Pokemon{

	public Geodude(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "rock", "ground");
	}
	public Geodude() {
		super(100, 30, "rock", "ground");
	}
	
	@Override
	public int rockThrow()
	{
		return this.getAttackDmg();
	}
}
