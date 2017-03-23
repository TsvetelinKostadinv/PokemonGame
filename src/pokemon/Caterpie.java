package pokemon;

public class Caterpie extends Pokemon implements AttacksGrass{

	public Caterpie(int maxHP, int attackDmg, String name) {
		super(maxHP, attackDmg, "bug", "bug");
	}
	public Caterpie() {
		super(100, 30, "bug", "bug");
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
	public int leechLife()
	{
		System.out.println(this.getName()+"(of type Caterpie) "
				+ "used Leech Life and will heal "
				+ "for 1/4 of the damage dealt");
		//heals for 1/4 of the damage dealt
		if (this.getAttackDmg()/4 + this.getHp()>this.getMaxHP()){
			this.heal(getAttackDmg()/4);
		}
		return this.getAttackDmg();
	}
	@Override
	public int razorLeaf() {
		System.out.println(this.getName()+" used Razor Leaf");
		return this.getAttackDmg()*2;
	}
}