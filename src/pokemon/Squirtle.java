package pokemon;

public class Squirtle extends Pokemon implements AttacksWater{

	public Squirtle(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "water", "water");
	}
	public Squirtle() {
		super(100, 30, "water", "water");
	}
	
	@Override
	public int hidroPump()
	{
		System.out.println(this.getName()+" used Hidro Pump!");
		return this.getAttackDmg()*2;
	}
	@Override
	public int splash() {
		System.out.println(this.getName()+" used Splash!");
		if(this.getName().equals("Magicarp"))
		{
			System.out.println("A little suspicious"
					+ " if it would deal damage but it did,"
					+ " so good for you");
		}
		return this.getAttackDmg()*2;
	}
	@Override
	public int tackle() {
		System.out.println(this.getName()+" used Tackle!");
		return this.getAttackDmg()/2;
	}
	@Override
	public int hyperFang() {
		System.out.println(this.getName()+" used Hyper Fang!");
		return this.getAttackDmg();
	}

}