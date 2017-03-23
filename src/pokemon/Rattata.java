package pokemon;

public class Rattata extends Pokemon implements AttacksNormal{

	public Rattata(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "normal", "normal");
	}
	public Rattata() {
		super(100, 30, "normal", "normal");
	}
	
	@Override
	public int hyperFang()
	{
		System.out.println(this.getName()+" used Hyper Fang!");
		return this.getAttackDmg()*2;
	}
	@Override
	public int tackle() {
		System.out.println(this.getName()+" used Tackle!");
		return this.getAttackDmg();
	}
}
