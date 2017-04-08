package pokemon;

public class Hitmonchan extends Pokemon implements AttacksFighting{

	public Hitmonchan(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "fighting", "fighting");
	}
	public Hitmonchan() {
		super(90, 30, "fighting", "fighting", "Hitmonchan");
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
	public int punch() {
		System.out.println(this.getName()+" used Punch");
		return this.getAttackDmg()*2;
	}
	@Override
	public int kick() {
		System.out.println(this.getName()+" used Kick");
		return this.getAttackDmg()*2;
	}
	@Override
	public void printAbilities()
	{
		System.out.println("[1]Hyper Fang");
		System.out.println("[2]Tackle");
		System.out.println("[3]Punch");
		System.out.println("[4]Kick");
	}
}
