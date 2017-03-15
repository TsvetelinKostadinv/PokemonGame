package pokemon;

public class Pokemon implements PokemonAttacks{
	private int maxHP;
	private int hp;
	private int attackDmg;
	private String name;
	private String primaryAttr;
	private String secondaryAttr;
	
	public Pokemon(int maxHP, int attackDmg, String name, String primaryAttr, String secondaryAttr) {
		super();
		this.maxHP = maxHP;
		this.hp = maxHP;
		this.attackDmg = attackDmg;
		this.name = name;
		this.primaryAttr = primaryAttr;
		this.secondaryAttr = secondaryAttr;
	}
	
	public void takeDamage(int amount)
	{
		hp-=amount;
	}
	public void heal(int amount)
	{
		hp+=amount;
	}
	
	public void printInfo()
	{
		System.out.println("The name of your pokemon is " + this.getName());
		System.out.println("The max health points for " + this.getName()+" is " + this.getMaxHP());
		System.out.println(name+" currently has "+ this.getHp());
		System.out.println("Your pokemon attacks for " + this.getAttackDmg());
		System.out.println(name+"'s attributes are "+this.getPrimaryAttr()+" and "+this.getSecondaryAttr());
	}

	public int getMaxHP() {
		return maxHP;
	}
	
	public int getHp() {
		return hp;
	}

	public int getAttackDmg() {
		return attackDmg;
	}

	public void setAttackDmg(int attackDmg) {
		this.attackDmg = attackDmg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryAttr() {
		return primaryAttr;
	}
	
	public String getSecondaryAttr() {
		return secondaryAttr;
	}

	
	
	
	@Override
	public int razorLeaf() {
		return 0;
	}
	@Override
	public int flamethrower() {
		return 0;
	}
	@Override
	public int hidroPump() {
		return 0;
	}
	
	
}