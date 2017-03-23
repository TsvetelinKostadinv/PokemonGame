package pokemon;

public class Charmander extends Pokemon implements AttacksFire{

	public Charmander(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "fire", "fire");
	}
	
	public Charmander() {
		super(70, 40, "fire", "fire");
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
	public int flamethrower() {
		System.out.println(this.getName()+" used Flamethrower");
		return this.getAttackDmg()*2;
	}

	@Override
	public int fireBall() {
		System.out.println(this.getName()+" used Fire Ball");		
		return this.getAttackDmg()*2;
	}
}