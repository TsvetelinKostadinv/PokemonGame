package pokemon;

public class Rattata extends Pokemon implements AttacksNormal{

	public Rattata(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "normal", "normal");
	}
	public Rattata() {
		super(100, 30, "normal", "normal", "Rattata");
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
		System.out.println("[1]Hyper Fang");
		System.out.println("[2]Tackle");
		System.out.println("Rattata is not very interesting, is it.");
	}
	
}
