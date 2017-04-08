package pokemon;

public class Bulbasour extends Pokemon implements AttacksGrass{

	public Bulbasour(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "grass", "poison");
	}
	public Bulbasour() {
		super(120, 25, "grass", "poison", "Bulbasour");
	}
	@Override
	public int hyperFang()
	{
		System.out.println(this.getName()+" used Hyper Fang!");
		return this.getAttackDmg();
	}
	@Override
	public int tackle() {
		System.out.println(this.getName()+" used Tackle!");
		return this.getAttackDmg()/2;
	}
	@Override
	public int razorLeaf() {
		System.out.println(this.getName()+" used Razor Leaf");
		return 0;
	}
	@Override
	public int leechLife() {
		System.out.println(this.getName()+" used Leech Life");
		return 0;
	}
	@Override
	public void printAbilities()
	{
		System.out.println("[1]Hyper Fang");
		System.out.println("[2]Tackle");
		System.out.println("[3]Razor leaf");
		System.out.println("[4]Leech Life");
	}

}
