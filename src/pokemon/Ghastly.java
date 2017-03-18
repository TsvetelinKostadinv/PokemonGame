package pokemon;

public class Ghastly extends Pokemon{

	public Ghastly(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "ghost", "poison");
	}
	public Ghastly() {
		super(100, 30, "ghost", "poison");
	}
	
	@Override
	public int shadowBall()
	{
		return this.getAttackDmg();
	}
}

