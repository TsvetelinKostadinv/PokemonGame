package pokemon;

public class Bulbasour extends Pokemon {

	public Bulbasour(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, name, "grass", "poison");
	}
	
	@Override
	public int razorLeaf()
	{
		return this.getAttackDmg();
	}
	
}
