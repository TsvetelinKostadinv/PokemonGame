package pokemon;

public class Pikachu extends Pokemon{

	public Pikachu(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "electricity", "electricity");
	}
	public Pikachu() {
		super(100, 30, "electricity", "electricity");
	}
	
	@Override
	public int thunderstrike()
	{
		return this.getAttackDmg();
	}
}
