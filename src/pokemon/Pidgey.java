package pokemon;

public class Pidgey extends Pokemon{

	public Pidgey(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "flying", "normal");
	}
	public Pidgey() {
		super(100, 30, "flying", "normal");
	}
	
	@Override
	public int gust()
	{
		return this.getAttackDmg();
	}
}