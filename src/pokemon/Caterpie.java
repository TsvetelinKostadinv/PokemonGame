package pokemon;

public class Caterpie extends Pokemon implements AttacksBugs{

	public Caterpie(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "bug", "bug", name);
	}
	public Caterpie() {
		super(80, 20, "bug", "bug", "Caterpie");
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
	public int bugBite()
	{
		System.out.println(this.getName()+" used Bug Bite");
		return this.getAttackDmg();
	}
	@Override
	public int silkShot() {
		System.out.println(this.getName()+" used Silk Shot");
		return this.getAttackDmg()*2;
	}
	
	@Override
	public void printAbilities()
	{
		System.out.println("[1]Hyper Fang");
		System.out.println("[2]Tackle");
		System.out.println("[3]Bug Bite");
		System.out.println("[4]Silk Shot");
	}
	
}
