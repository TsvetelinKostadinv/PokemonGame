package pokemon;

public class Rattata extends Pokemon{

	public Rattata(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "normal", "normal");
	}
	public Rattata() {
		super(100, 30, "normal", "normal");
	}
	
	@Override
	public int hyperFang()
	{
		return this.getAttackDmg();
	}
}
