package pokemon;

public class Bulbasour extends Pokemon {

	public Bulbasour(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "grass", "poison");
	}
	public Bulbasour() {
		super(150, 25, "grass", "poison");
	}
	
	@Override
	public int razorLeaf()
	{
		return this.getAttackDmg();
	}
	
}
