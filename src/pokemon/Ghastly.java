package pokemon;

public class Ghastly extends Pokemon implements AttacksGhost{

	public Ghastly(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "ghost", "poison");
	}
	public Ghastly() {
		super(100, 30, "ghost", "poison", "Ghastly");
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
	public int shadowBall() {
		System.out.println(this.getName()+" used Shadow Ball");		
		return this.getAttackDmg()*2;
	}
	@Override
	public int fear() {
		System.out.println(this.getName()+" used Fear");	
		return this.getAttackDmg()*2;
	}
	
	@Override
	public void printAbilities()
	{
		System.out.println("[1]Hyper Fang");
		System.out.println("[2]Tackle");
		System.out.println("[3]Shadow Ball");
		System.out.println("[4]Fear");
	}
}


