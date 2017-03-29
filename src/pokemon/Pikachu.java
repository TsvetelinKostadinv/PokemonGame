package pokemon;

public class Pikachu extends Pokemon implements AttacksElectric{

	public Pikachu(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "electricity", "electricity");
	}
	public Pikachu() {
		super(100, 30, "electricity", "electricity");
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
	
	public int thunderBolt() {
		System.out.println(this.getName()+" used Thunderbolt");
		return this.getAttackDmg()*2;
	}
	
	@Override
	public int ThunderStrike() {
		System.out.println(this.getName()+" used Thunderstrike");
		return this.getAttackDmg()*2;
	}
	
	@Override
	public void printAbilities()
	{
		System.out.println("[1]Hyper Fang");
		System.out.println("[2]Tackle");
		System.out.println("[3]Thunderbolt");
		System.out.println("[4]Thunderstrike");
	}

}
