package pokemon;

public class MissingNo extends Pokemon implements AttacksNormal{

	public MissingNo(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "normal", "normal");
	}
	public MissingNo() {
		super(100, 30, "normal", "normal", "MissingNo");
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
	@Override
	public void printAbilities()
	{
		System.out.println("[1]???");
		System.out.println("[2]???");
		System.out.println("[3]???");
		System.out.println("[4]???");
	}
	
}
