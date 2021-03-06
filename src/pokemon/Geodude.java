package pokemon;

public class Geodude extends Pokemon implements AttacksEarth{

	public Geodude(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "rock", "ground");
	}
	public Geodude() {
		super(100, 30, "rock", "ground", "Geodude");
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
	public int rockThrow() {
		System.out.println(this.getName()+" used Rock Throw");
		return this.getAttackDmg()*2;
	}
	@Override
	public int earthquake() {
		System.out.println(this.getName()+" used Earthquake");
		return this.getAttackDmg()*2;
	}
	@Override
	public void printAbilities()
	{
		System.out.println("[1]Hyper Fang");
		System.out.println("[2]Tackle");
		System.out.println("[3]Rock throw");
		System.out.println("[4]Earthquake");
	}
	
}
