package pokemon;

public class Pidgey extends Pokemon implements AttacksFlying{

	public Pidgey(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "flying", "normal");
	}
	public Pidgey() {
		super(100, 30, "flying", "normal");
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
	public int steelWing() {
		System.out.println(this.getName()+" used Steel Wing");
		return this.getAttackDmg()*2;
	}
	@Override
	public int gustOfWind() {
		System.out.println(this.getName()+" used Gust");
		return this.getAttackDmg()*2;
	}


}